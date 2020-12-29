package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.Cart;
import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.services.ProductIndexService;
import com.nguyendinhquochieu.minishop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/detail")
@SessionAttributes({"user","cart"})
@EnableWebMvc

public class DetailProductController {
    @Autowired
    ProductService  productService;
    @Autowired
    ProductIndexService productIndexService;
    @GetMapping("/{masanpham}")
    public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession){
        SanPham productById = productService.getProductById(masanpham);
        List<DanhMucSanPham> listProductIndex = productIndexService.getProductIndex();

        if( null != httpSession.getAttribute("cart")) {
            List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
            modelMap.addAttribute("productQuantity",carts.size());
            System.out.println("so luong san pham trong gio hang " + carts.size());
        }
        if( null != httpSession.getAttribute("user")){
            String email = (String) httpSession.getAttribute("user");
            System.out.println("day la user from cart:" +email);
            String firstChar = email.substring(0, 1);
            modelMap.addAttribute("firstChar", firstChar);
        }
        modelMap.addAttribute("productById",productById);
        modelMap.addAttribute("listProductIndex",listProductIndex);
        return "detail_product";
    }
}
