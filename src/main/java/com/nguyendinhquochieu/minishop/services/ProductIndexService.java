package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.ProductIndexDAO;
import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.imp.ProductIndexImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductIndexService implements ProductIndexImp {
    @Autowired
    ProductIndexDAO productIndexDAO;
    @Override
    public List<DanhMucSanPham> getProductIndex() {
        return productIndexDAO.getProductIndex();
    }
}
