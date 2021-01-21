package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.SizeDAO;
import com.nguyendinhquochieu.minishop.entity.ChiTietSanPham;
import com.nguyendinhquochieu.minishop.entity.SizeSanPham;
import com.nguyendinhquochieu.minishop.imp.SizeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements SizeImp {
    @Autowired
    SizeDAO sizeDAO;

    @Override
    public List<SizeSanPham> getListSize() {
        return sizeDAO.getListSize();
    }
}
