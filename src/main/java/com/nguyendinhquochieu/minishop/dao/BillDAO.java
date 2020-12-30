package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.HoaDon;
import com.nguyendinhquochieu.minishop.imp.BillImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BillDAO implements BillImp {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public int addBill(HoaDon hoaDon) {
        Session session = sessionFactory.getCurrentSession();
        int id = (int) session.save(hoaDon);
        if(0 < id ){
            System.out.println("them bill thanh cong");
            return id;
        }else {
            System.out.println("them bill that bai");
            return 0;
        }
    }
}
