package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.Cart;
import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.services.ProductIndexService;
import com.nguyendinhquochieu.minishop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
@EnableWebMvc
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductIndexService productIndexService;
    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession){
        if (httpSession.getAttribute("user") != null) {
            String email = (String) httpSession.getAttribute("user");
            String firstChar = email.substring(0, 1);
            modelMap.addAttribute("firstChar", firstChar);
        }
        if( null != httpSession.getAttribute("cart")) {
            List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
            modelMap.addAttribute("productQuantity",carts.size());
            modelMap.addAttribute("cartsList", carts);
        }
        List<DanhMucSanPham> listProductIndex = productIndexService.getProductIndex();
        modelMap.addAttribute("listProductIndex",listProductIndex);

        List<SanPham> listHotProduct = productService.getListHotProduct(0);
        modelMap.addAttribute("listHotProduct", listHotProduct);
        return "home";
    }
}