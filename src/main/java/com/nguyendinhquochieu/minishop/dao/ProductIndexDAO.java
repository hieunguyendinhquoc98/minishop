package com.nguyendinhquochieu.minishop.dao;

import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.imp.ProductIndexImp;
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
public class ProductIndexDAO  implements ProductIndexImp {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<DanhMucSanPham> getProductIndex() {
        Session session = sessionFactory.getCurrentSession();
        List<DanhMucSanPham> listProductIndex = (List<DanhMucSanPham>) session.createQuery("from DANHMUCSANPHAM ").getResultList();
        return listProductIndex;
    }
}
