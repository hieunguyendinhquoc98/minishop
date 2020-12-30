package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.ChiTietHoaDon;
import com.nguyendinhquochieu.minishop.entity.ChiTietHoaDonId;
import com.nguyendinhquochieu.minishop.imp.DetailBillImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DetailBillDAO implements DetailBillImp {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean addDetailBill(ChiTietHoaDon chiTietHoaDon){
        Session session = sessionFactory.getCurrentSession();
        ChiTietHoaDonId id = (ChiTietHoaDonId) session.save(chiTietHoaDon);
        if(id != null){
            return true;
        }else {
            return false;
        }
    }

}
