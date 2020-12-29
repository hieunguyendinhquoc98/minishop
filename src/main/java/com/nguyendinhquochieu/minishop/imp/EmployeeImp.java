package com.nguyendinhquochieu.minishop.imp;

import com.nguyendinhquochieu.minishop.entity.NhanVien;

public interface EmployeeImp {
    boolean KiemTraDangNhap(String email, String matkhau);
    boolean ThemNhanVien(NhanVien nhanVien);
}
