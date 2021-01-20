package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.*;
import com.nguyendinhquochieu.minishop.imp.ProductImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        if(index < 0) {//get all product - reuse function
            return listHotProduct = (List<SanPham>) session.createQuery("from SanPham").getResultList();
        }else {
            System.out.println("lay tu index input");
           return listHotProduct = (List<SanPham>) session.createQuery("from SanPham").setFirstResult(index).setMaxResults(5).getResultList();
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

    @Override
    @Transactional
    public boolean deleteProductById(int idProduct) {
        Session session = sessionFactory.getCurrentSession();
        SanPham sanPham = session.get(SanPham.class, idProduct);
        //due to the constraint when delete SanPham, we need to delete SanPham has idProduct in ChiTietHoaDon first.
        Set<ChiTietSanPham> chiTietSanPhamList;
        chiTietSanPhamList = sanPham.getChitietsanpham();
        for (ChiTietSanPham chitietSanPham: chiTietSanPhamList) {
            session.createQuery(" delete from ChiTietHoaDon cthd where cthd.chiTietHoaDonId.machitietsanpham = '"+chitietSanPham.getMachitietsanpham()+"' ").executeUpdate();
        }

        //when using EmbeddedId, we cannot use the session.delete, that's a down point of EmbeddedId
//        session.delete(sanPham);
        session.createQuery(" delete from ChiTietSanPham ctsp where ctsp.sanpham.masanpham = '"+ idProduct +"' ").executeUpdate();
        session.createQuery(" delete from SanPham sp where sp.masanpham = '"+  idProduct +"' ").executeUpdate();

        return sanPham != null;
    }
}
