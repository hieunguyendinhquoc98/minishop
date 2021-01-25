package com.nguyendinhquochieu.minishop.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyendinhquochieu.minishop.entity.*;
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
import java.util.*;


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

        StringBuilder html = new StringBuilder();
        List<SanPham> sanPhamList = productService.getListHotProduct(soluong);
        for (SanPham product: sanPhamList ) {
            html.append("<tr>");
            html.append("<td><div class=\"checkbox\"><label><input name=\"product-checkbox\" type=\"checkbox\" value=\" '").append(product.getMasanpham()).append(" '\"></label></div></td>\n");
            html.append("<td class=\"tensp\" data-masp='").append(product.getMasanpham()).append("'>").append(product.getTensanpham()).append("</td>");
            html.append("<td class=\"giatien\" >").append(product.getGiatien()).append("</td>");
            html.append("<td class=\"gianhcho\">").append(product.getGianhcho()).append("</td>");
            html.append("<td style=\"color: white\" class=\"capnhatsanpham btn btn-warning\" data-id='").append(product.getMasanpham()).append(">Sửa</td>\n");
            html.append("</tr>");
        }
            return html.toString();
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

    @PostMapping(path="AddProductAdmin")
    @ResponseBody
    public String AddProductAdmin(@RequestParam String dataJson) {
        System.out.println(dataJson);
        //{} is json object, [] -> json array
        ObjectMapper objectMapper = new ObjectMapper();
        SanPham sanPham = new SanPham();
        try {
            DanhMucSanPham danhMucSanPham = new DanhMucSanPham();

            JsonNode jsonNode = objectMapper.readTree(dataJson);

            danhMucSanPham.setMadanhmuc(jsonNode.get("danhMucSanPham").asInt());
            JsonNode jsonChiTiet = jsonNode.get("chitietsanpham");
            Set<ChiTietSanPham> listChiTiet = new HashSet<>();

            for(JsonNode objectChiTiet : jsonChiTiet){
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

                MauSanPham mauSanPham = new MauSanPham();
                mauSanPham.setMamau(objectChiTiet.get("mauSanPham").asInt());
                chiTietSanPham.setMausanpham(mauSanPham);

                SizeSanPham sizeSanPham = new SizeSanPham();
                sizeSanPham.setMasize(objectChiTiet.get("sizeSanPham").asInt());
                chiTietSanPham.setSizeSanPham(sizeSanPham);

                chiTietSanPham.setSoluong(objectChiTiet.get("soluong").asInt());
                listChiTiet.add(chiTietSanPham);
            }
            String tensanpham = jsonNode.get("tensanpham").asText();
            String giatien = jsonNode.get("giatien").asText();
            String mota = jsonNode.get("mota").asText();
            String hinhsanpham = jsonNode.get("hinhsanpham").asText();
            String gianhcho = jsonNode.get("gianhcho").asText();

            sanPham.setChitietsanpham(listChiTiet);
            sanPham.setDanhMucSanPham(danhMucSanPham);
            sanPham.setTensanpham(tensanpham);
            sanPham.setGiatien(giatien);
            sanPham.setMota(mota);
            sanPham.setHinhsanpham(hinhsanpham);
            sanPham.setGianhcho(gianhcho);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(productService.addProduct(sanPham)){
            System.out.println("Them sp thanh cong" + productService.addProduct(sanPham));
            return ""+ productService.addProduct(sanPham);
        }
        else {
            System.out.println("Them sp that bai" + productService.addProduct(sanPham));
            return ""+ productService.addProduct(sanPham);
        }
    }
    @PostMapping(path="UpdateProductAdmin")
    @ResponseBody
    public String UpdateProductAdmin(@RequestParam String dataJson) {
        System.out.println(dataJson);
        //{} is json object, [] -> json array
        ObjectMapper objectMapper = new ObjectMapper();
        SanPham sanPham = new SanPham();
        try {
            DanhMucSanPham danhMucSanPham = new DanhMucSanPham();

            JsonNode jsonNode = objectMapper.readTree(dataJson);

            danhMucSanPham.setMadanhmuc(jsonNode.get("danhMucSanPham").asInt());
            JsonNode jsonChiTiet = jsonNode.get("chitietsanpham");
            Set<ChiTietSanPham> listChiTiet = new HashSet<>();

            for(JsonNode objectChiTiet : jsonChiTiet){
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

                MauSanPham mauSanPham = new MauSanPham();
                mauSanPham.setMamau(objectChiTiet.get("mauSanPham").asInt());
                chiTietSanPham.setMausanpham(mauSanPham);

                SizeSanPham sizeSanPham = new SizeSanPham();
                sizeSanPham.setMasize(objectChiTiet.get("sizeSanPham").asInt());
                chiTietSanPham.setSizeSanPham(sizeSanPham);

                chiTietSanPham.setSoluong(objectChiTiet.get("soluong").asInt());
                listChiTiet.add(chiTietSanPham);

            }
            String tensanpham = jsonNode.get("tensanpham").asText();
            String giatien = jsonNode.get("giatien").asText();
            String mota = jsonNode.get("mota").asText();
            String hinhsanpham = jsonNode.get("hinhsanpham").asText();
            String gianhcho = jsonNode.get("gianhcho").asText();
            int masanpham = jsonNode.get("masanpham").asInt();

            sanPham.setChitietsanpham(listChiTiet);
            sanPham.setDanhMucSanPham(danhMucSanPham);
            sanPham.setTensanpham(tensanpham);
            sanPham.setGiatien(giatien);
            sanPham.setMota(mota);
            sanPham.setHinhsanpham(hinhsanpham);
            sanPham.setGianhcho(gianhcho);
            sanPham.setMasanpham(masanpham);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(productService.updateProduct(sanPham)){
            System.out.println("cap nhat sp thanh cong" + productService.updateProduct(sanPham));
            return ""+ productService.updateProduct(sanPham);
        }
        else {
            System.out.println("cap nhat sp that bai" + productService.updateProduct(sanPham));
            return ""+ productService.updateProduct(sanPham);
        }
    }
    @PostMapping(path="GetProductById", produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSON_SanPham GetProductByID(@RequestParam int masanpham){
        JSON_SanPham json_sanPham = new JSON_SanPham();
        SanPham sanPham = productService.getProductById(masanpham);

        json_sanPham.setMasanpham(sanPham.getMasanpham());
        json_sanPham.setTensanpham(sanPham.getTensanpham());
        json_sanPham.setGiatien(sanPham.getGiatien());
        json_sanPham.setMota(sanPham.getMota());
        json_sanPham.setHinhsanpham(sanPham.getHinhsanpham());
        json_sanPham.setGianhcho(sanPham.getGianhcho());

        DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
        danhMucSanPham.setMadanhmuc(sanPham.getDanhMucSanPham().getMadanhmuc());
        danhMucSanPham.setTendanhmuc(sanPham.getDanhMucSanPham().getTendanhmuc());

        Set<ChiTietSanPham> chiTietSanPhamSet = new HashSet<>();
        for (ChiTietSanPham value: sanPham.getChitietsanpham()){
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setMachitietsanpham(value.getMachitietsanpham());

            MauSanPham mauSanPham = new MauSanPham();
            mauSanPham.setMamau(value.getMausanpham().getMamau());
            mauSanPham.setTenmau(value.getMausanpham().getTenmau());
            chiTietSanPham.setMausanpham(mauSanPham);

            SizeSanPham sizeSanPham = new SizeSanPham();
            sizeSanPham.setMasize(value.getSizeSanPham().getMasize());
            sizeSanPham.setSize(value.getSizeSanPham().getSize());

            chiTietSanPham.setSizeSanPham(sizeSanPham);
            chiTietSanPham.setSoluong(value.getSoluong());
            chiTietSanPhamSet.add(chiTietSanPham);
        }

        json_sanPham.setDanhMucSanPham(danhMucSanPham);
        json_sanPham.setChitietsanpham(chiTietSanPhamSet);
        return json_sanPham;
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
