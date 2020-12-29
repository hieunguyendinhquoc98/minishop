package com.nguyendinhquochieu.minishop.controller;

import com.nguyendinhquochieu.minishop.entity.NhanVien;
import com.nguyendinhquochieu.minishop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping("login/")
@EnableWebMvc
public class LoginController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String Default(){
        return "login";
    }
    @PostMapping
    public String SignUp(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau, ModelMap modelMap){
        boolean checkMail = validate(email);
        if(checkMail){
            if(matkhau.equals(nhaplaimatkhau)){
                NhanVien nhanVien = new NhanVien();
                nhanVien.setEmail(email);
                nhanVien.setMatkhau(matkhau);
                boolean checkSignUp =  employeeService.ThemNhanVien(nhanVien);
                if(checkSignUp){
                    modelMap.addAttribute("checkSignUp","Tạo thành công!");
                }
            }else{
                    modelMap.addAttribute("checkSignUp","Mật khẩu không khớp");
            }
        }else {
            modelMap.addAttribute("checkSignUp","Email sai định dạng!");
        }
        return "login";
    }
    //JAVA EMAIL REGEX
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
