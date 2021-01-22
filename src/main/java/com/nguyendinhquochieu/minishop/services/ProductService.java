package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.ProductDAO;
import com.nguyendinhquochieu.minishop.entity.SanPham;
import com.nguyendinhquochieu.minishop.imp.ProductImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductImp {
    @Autowired
    ProductDAO productDAO;

    @Override
    public List<SanPham> getListHotProduct(int index) {
        return productDAO.getListHotProduct(index);
    }

    @Override
    public SanPham getProductById(int idProduct) {
        return productDAO.getProductById(idProduct);
    }

    @Override
    public List<SanPham> getListProductByIndex(int index) {
        return productDAO.getListProductByIndex(index);
    }

    @Override
    public boolean deleteProductById(int idProduct) {
        return productDAO.deleteProductById(idProduct);
    }

    @Override
    public boolean addProduct(SanPham sanPham) {
        return productDAO.addProduct(sanPham);
    }
}
