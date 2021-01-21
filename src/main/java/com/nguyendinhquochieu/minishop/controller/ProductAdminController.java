package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.entity.MauSanPham;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.entity.SizeSanPham;
import com.nguyendinhquochieu.minishop.services.ColorService;
import com.nguyendinhquochieu.minishop.services.ProductIndexService;
import com.nguyendinhquochieu.minishop.services.ProductService;
import com.nguyendinhquochieu.minishop.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ProductAdmin")
@EnableWebMvc
public class ProductAdminController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductIndexService productIndexService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ColorService colorService;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession){
        List<SanPham> list = productService.getListHotProduct(0);
        List<SanPham> listAllProduct = productService.getListHotProduct(-1);
        List<DanhMucSanPham> listProductIndex = productIndexService.getProductIndex();
        List<SizeSanPham> listSize = sizeService.getListSize();
        List<MauSanPham> listColor = colorService.getColorList();
        double sumOfPage =  Math.ceil((double)listAllProduct.size() / 5);
        modelMap.addAttribute("listSanPham",list);
        modelMap.addAttribute("allProduct", listAllProduct);
        modelMap.addAttribute("sumOfPage",sumOfPage);
        modelMap.addAttribute("listProductIndex",listProductIndex);
        modelMap.addAttribute("listSize",listSize);
        modelMap.addAttribute("listColor",listColor);

        return "product_admin";
    }
}
