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
@RequestMapping("/product")
@SessionAttributes("cart")
@EnableWebMvc
public class ProductByIndexController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductIndexService productIndexService;
    @GetMapping("/{id}/{productIndex}")
    public String Default(@PathVariable int id,@PathVariable String productIndex, ModelMap modelMap, HttpSession httpSession){
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

        List<SanPham> listProductByIndex = productService.getListProductByIndex(id);
        modelMap.addAttribute("listProductByIndex", listProductByIndex);
        modelMap.addAttribute("productIndex", productIndex);
        return "product_by_index";
    }
}
