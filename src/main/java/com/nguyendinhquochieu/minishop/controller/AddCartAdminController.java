package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.services.ProductService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ProductAdmin")
@EnableWebMvc
public class AddCartAdminController {
    @Autowired
    ProductService productService;
    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession){
        List<SanPham> list = productService.getListHotProduct(0);
        List<SanPham> listAllProduct = productService.getListHotProduct(-1);
        double sumOfPage =  Math.ceil((double)listAllProduct.size() / 5);
        modelMap.addAttribute("listSanPham",list);
        modelMap.addAttribute("allProduct", listAllProduct);
        modelMap.addAttribute("sumOfPage",sumOfPage);
        return "product_admin";
    }
}
