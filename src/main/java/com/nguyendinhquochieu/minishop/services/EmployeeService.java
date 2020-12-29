package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.EmployeeDAO;
import com.nguyendinhquochieu.minishop.entity.NhanVien;
import com.nguyendinhquochieu.minishop.imp.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeImp {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public boolean KiemTraDangNhap(String email, String matkhau) {
        return employeeDAO.KiemTraDangNhap(email, matkhau);
    }

    @Override
    public boolean ThemNhanVien(NhanVien nhanVien) {
        return employeeDAO.ThemNhanVien(nhanVien);
    }
}
