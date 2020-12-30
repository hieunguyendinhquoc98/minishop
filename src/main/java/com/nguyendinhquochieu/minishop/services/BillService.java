package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.BillDAO;
import com.nguyendinhquochieu.minishop.entity.HoaDon;
import com.nguyendinhquochieu.minishop.imp.BillImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService implements BillImp {
    @Autowired
    BillDAO billDAO;

    @Override
    public int addBill(HoaDon hoaDon) {
        return billDAO.addBill(hoaDon);
    }
}
