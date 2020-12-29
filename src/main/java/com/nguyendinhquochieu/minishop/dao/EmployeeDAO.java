package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.NhanVien;
import com.nguyendinhquochieu.minishop.imp.EmployeeImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDAO implements EmployeeImp {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean KiemTraDangNhap(String email, String matkhau) {
        Session session = sessionFactory.getCurrentSession();
        try{
            NhanVien nhanVien =(NhanVien) session.createQuery("from NhanVien where  email = '"+ email + "' AND matkhau = '" + matkhau +"' ").getSingleResult();
            return nhanVien != null;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean ThemNhanVien(NhanVien nhanVien) {
        Session session = sessionFactory.getCurrentSession();
        try{
           int manhanvien = (int) session.save(nhanVien);
            if(manhanvien > 0)
               return true;
            else return false;
        }catch (Exception e){
            return false;
        }
    }
}
