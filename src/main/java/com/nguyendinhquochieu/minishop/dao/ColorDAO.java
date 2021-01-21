package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.ChiTietSanPham;
import com.nguyendinhquochieu.minishop.entity.MauSanPham;
import com.nguyendinhquochieu.minishop.entity.SizeSanPham;
import com.nguyendinhquochieu.minishop.imp.ColorImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ColorDAO implements ColorImp {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<MauSanPham> getColorList() {
        Session  session = sessionFactory.getCurrentSession();
        List <MauSanPham> mauSanPhams = (List<MauSanPham>) session.createQuery("from MauSanPham ").getResultList();
        return mauSanPhams;
    }
}
