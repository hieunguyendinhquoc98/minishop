package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.Cart;
import com.nguyendinhquochieu.minishop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("api/")
@SessionAttributes({"user","cart"})
@EnableWebMvc
public class APIController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("HandleLogin")
    @ResponseBody
        public String HandleLogin(@RequestParam String email , @RequestParam String matkhau, ModelMap modelMap) {
            boolean check = employeeService.KiemTraDangNhap(email, matkhau);
            modelMap.addAttribute("user",email);
            if(check) {
                modelMap.addAttribute("checkSignIn",email);
            }
            return "" + check;
    }
    @GetMapping("AddCart")
    @ResponseBody
    public String addCart(@RequestParam int masp, @RequestParam int masize,
                            @RequestParam int mamau, @RequestParam String tensp, @RequestParam String giatien,
                            @RequestParam String tenmau, @RequestParam String tensize, @RequestParam int soluong, HttpSession httpSession){

        if(httpSession.getAttribute("cart") == null) { //if card Session null -> create new!
            List<Cart> cartList = new ArrayList<>();
            Cart cart = new Cart();
            cart.setMasp(masp);
            cart.setMasize(masize);
            cart.setMamau(mamau);
            cart.setTensp(tensp);
            cart.setGiatien(giatien);
            cart.setTenmau(tenmau);
            cart.setTensize(tensize);
            cart.setSoluong(1);

            cartList.add(cart);
            httpSession.setAttribute("cart", cartList);
            return cartList.size() + "";
        }else { //if cart session not null, check if product is in cart or not, if yes + 1 quantity, if not, add new one
            int indexAvailable = checkAvailable(masp, masize, mamau, httpSession);
            if(indexAvailable == -1){
                List<Cart> cartList = (List<Cart>) httpSession.getAttribute("cart");
                Cart cart = new Cart();
                cart.setMasp(masp);
                cart.setMasize(masize);
                cart.setMamau(mamau);
                cart.setTensp(tensp);
                cart.setGiatien(giatien);
                cart.setTenmau(tenmau);
                cart.setTensize(tensize);
                cart.setSoluong(1);
                cartList.add(cart);
                return cartList.size() + "";
            }else {
                List<Cart> cartList = (List<Cart>) httpSession.getAttribute("cart");
                cartList.get(indexAvailable).setSoluong(cartList.get(indexAvailable).getSoluong() + 1);
                return cartList.size() + "";
            }
        }
    }
    @GetMapping("UpdateCart")
    @ResponseBody
    public void UpdateCart(HttpSession httpSession,@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau, @RequestParam int soluong, ModelMap modelMap) {
        if( null != httpSession.getAttribute("cart")){
            int indexAvailable = checkAvailable(masp, masize, mamau, httpSession);
            if(indexAvailable != -1){
                List<Cart> cartList = (List<Cart>) httpSession.getAttribute("cart");
                cartList.get(indexAvailable).setSoluong(soluong);
                System.out.println("them so luong thanh cong!" +cartList.get(indexAvailable).getSoluong());
            }
        }
    }
    @GetMapping("DeleteCart")
    @ResponseBody
    public String DeleteCart(HttpSession httpSession,@RequestParam int masp, @RequestParam int masize, @RequestParam int mamau, ModelMap modelMap) {
        String size = "";
        if( null != httpSession.getAttribute("cart")){
            int indexAvailable = checkAvailable(masp, masize, mamau, httpSession);
            if(indexAvailable != -1){
                List<Cart> cartList = (List<Cart>) httpSession.getAttribute("cart");
                cartList.remove(indexAvailable);
                System.out.println("xoa thanh cong!" +cartList.get(indexAvailable).getSoluong());
                modelMap.addAttribute("productQuantity",cartList.size());
                size = cartList.size() + "";
            }
        }
        return size;
    }
    private int checkAvailable(int masp, int masize, int mamau, HttpSession httpSession){
        if(httpSession.getAttribute("cart") != null) {
            List<Cart> cartList = (List<Cart>) httpSession.getAttribute("cart");
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getMasp() == masp && cartList.get(i).getMasize() == masize && cartList.get(i).getMamau() == mamau)
                    return i;
            }
        }
        return -1;
    }
}
