package com.nguyendinhquochieu.minishop.imp;

import com.nguyendinhquochieu.minishop.entity.DanhMucSanPham;
import com.nguyendinhquochieu.minishop.entity.SanPham;

import java.util.List;

public interface ProductImp {
    List<SanPham> getListHotProduct(int index);
    List<SanPham> getListProductByIndex(int index);
    SanPham getProductById(int idProduct);
    boolean deleteProductById(int idProduct);
    boolean addProduct(SanPham sanPham);
}
