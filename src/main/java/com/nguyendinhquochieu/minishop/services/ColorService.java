package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.ColorDAO;
import com.nguyendinhquochieu.minishop.entity.ChiTietSanPham;
import com.nguyendinhquochieu.minishop.entity.MauSanPham;
import com.nguyendinhquochieu.minishop.imp.ColorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements ColorImp {
    @Autowired
    ColorDAO colorDAO;
    @Override
    public List<MauSanPham> getColorList() {
        return colorDAO.getColorList();
    }
}
