package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.Cart;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.services.ColorService;
import com.nguyendinhquochieu.minishop.services.EmployeeService;
import com.nguyendinhquochieu.minishop.services.ProductService;
import com.nguyendinhquochieu.minishop.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("api/")
@SessionAttributes({"user","cart"})
@EnableWebMvc
public class APIController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProductService productService;

    @Autowired
    ServletContext context;

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
                          @RequestParam String tenmau, @RequestParam String tensize, @RequestParam int soluong,
                          @RequestParam int machitiet, HttpSession httpSession){

        if(httpSession.getAttribute("cart") == null) { //if cart Session null -> create new!
            List<Cart> cartList = new ArrayList<>();
            Cart cart = new Cart();
            cart.setMasp(masp);
            cart.setMasize(masize);
            cart.setMamau(mamau);
            cart.setTensp(tensp);
            cart.setGiatien(giatien);
            cart.setTenmau(tenmau);
            cart.setTensize(tensize);
            cart.setMachitiet(machitiet);
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
                cart.setMachitiet(machitiet);
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
    @GetMapping(path="LoadProductAdmin",produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String LoadProductAdmin(@RequestParam int soluong) {

        String html ="";
        List<SanPham> sanPhamList = productService.getListHotProduct(soluong);
        for (SanPham product: sanPhamList ) {
            html+="<tr>";
            html+="<td><div class=\"checkbox\"><label><input name=\"product-checkbox\" type=\"checkbox\" value=\" '" +product.getMasanpham()+" '\"></label></div></td>\n";
            html+="<td class=\"tensp\" data-masp='"+ product.getMasanpham()+"'>"+ product.getTensanpham()+"</td>";
            html+="<td class=\"giatien\" >"+ product.getGiatien()+"</td>";
            html+="<td class=\"gianhcho\">"+ product.getGianhcho()+"</td>";
            html+="</tr>";
        }
            return html;
    }
    @GetMapping(path="DeleteProductAdmin")
    @ResponseBody
    public String DeleteProductAdmin(@RequestParam int masanpham) {
        return productService.deleteProductById(masanpham) + "";
    }
    @PostMapping(path="UploadFile")
    @ResponseBody
    public String UploadFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        String path = context.getRealPath("/resources/image/sanpham/");
        Iterator<String> listNames = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(listNames.next());
        File file = null;
        if (multipartFile != null) {
            file = new File(path + multipartFile.getOriginalFilename());
        }
        try {
            if (multipartFile != null) {
                multipartFile.transferTo(file);
                System.out.println("upload file thanh cong! - save in server tomcat first");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "true";
    }


    //support function for add to cart api "/AddCart"
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
