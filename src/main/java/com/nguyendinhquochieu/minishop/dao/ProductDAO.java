package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.ChiTietSanPham;
import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.imp.ProductImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDAO implements ProductImp {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<SanPham> getListHotProduct(int index) {
        Session session = sessionFactory.getCurrentSession();
        List<SanPham> listHotProduct = new ArrayList<>();

        if(index < 0) {
            System.out.println("lay tu dau");
            return listHotProduct = (List<SanPham>) session.createQuery("from SanPham").getResultList();
        }else {
            System.out.println("lay tu index input");
           return listHotProduct = (List<SanPham>) session.createQuery("from SanPham").setFirstResult(index).setMaxResults(12).getResultList();
        }
    }

    @Override
    @Transactional
    public SanPham getProductById(int idProduct) {
        Session session = sessionFactory.getCurrentSession();
        SanPham productById = null;
        return productById = (SanPham) session.createQuery("from SanPham where masanpham = '"+ idProduct+ "' " ).getSingleResult();
    }

    @Override
    @Transactional
    public List<SanPham> getListProductByIndex(int index){
        Session session = sessionFactory.getCurrentSession();
        List<SanPham> listProductByIndex =  (List<SanPham>) session.createQuery("from SanPham sp where sp.danhMucSanPham.madanhmuc ='" +index + "' ").getResultList();
        return listProductByIndex;
    }
}
