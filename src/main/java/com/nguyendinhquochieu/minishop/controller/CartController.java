package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.*;
import com.nguyendinhquochieu.minishop.services.BillService;
import com.nguyendinhquochieu.minishop.services.DetailBillService;
import com.nguyendinhquochieu.minishop.services.ProductIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("cart/")
@SessionAttributes({"user","cart"})
@EnableWebMvc

public class CartController {
    @Autowired
    ProductIndexService productIndexService;
    @Autowired
    BillService billService;
    @Autowired
    DetailBillService detailBillService;


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
    @PostMapping(produces = "text/plain; charset=utf-8")
    public String AddBill(@RequestParam String tenkhachhang,
                          @RequestParam String sodt,
                          @RequestParam String diachigiaohang,
                          @RequestParam String hinhthucgiaohang,
                          @RequestParam String ghichu, HttpSession httpSession){
        if( null != httpSession.getAttribute("cart")) {
            List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
            HoaDon hoaDon = new HoaDon();
            hoaDon.setTenkhachhang(tenkhachhang);
            hoaDon.setSodt(sodt);
            hoaDon.setDiachigiaohang(diachigiaohang);
            hoaDon.setHinhthucgiaohang(hinhthucgiaohang);
            hoaDon.setGhichu(ghichu);

            int idHoaDon = billService.addBill(hoaDon);
            if(idHoaDon > 0){
                for (Cart ignored : carts){
                    ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
                    chiTietHoaDonId.setMachitietsanpham(ignored.getMachitiet());
                    chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

                    ChiTietHoaDon   chiTietHoaDon = new ChiTietHoaDon();
                    chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
                    chiTietHoaDon.setGiatien(ignored.getGiatien().toString());
                    chiTietHoaDon.setSoluong(ignored.getSoluong());
                    detailBillService.addDetailBill(chiTietHoaDon);
                }
                System.out.printf("them chi tiet hoa don thanh cong");
            }else {
                System.out.println("them chi tiet hoa don that bai");
            };

        }

        return "cart";
    }
}
