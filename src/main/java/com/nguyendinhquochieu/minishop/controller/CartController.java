package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.Cart;
import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.services.ProductIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("cart/")
@SessionAttributes({"user","cart"})
@EnableWebMvc

public class CartController {
    @Autowired
    ProductIndexService productIndexService;
    @GetMapping
    public String Default(HttpSession httpSession, ModelMap modelMap){
        if( null != httpSession.getAttribute("cart")) {
            List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
            modelMap.addAttribute("productQuantity",carts.size());
            modelMap.addAttribute("cartsList", carts);
        }
        if( null != httpSession.getAttribute("user")){
            String email = (String) httpSession.getAttribute("user");
            System.out.println("day la user from cart:" +email);
            String firstChar = email.substring(0, 1);
            modelMap.addAttribute("firstChar", firstChar);
        }

        List<DanhMucSanPham> listProductIndex = productIndexService.getProductIndex();
        modelMap.addAttribute("listProductIndex",listProductIndex);
        return "cart";
    }
}
