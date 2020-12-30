package com.nguyendinhquochieu.minishop.services;

import com.nguyendinhquochieu.minishop.dao.DetailBillDAO;
import com.nguyendinhquochieu.minishop.entity.ChiTietHoaDon;
import com.nguyendinhquochieu.minishop.imp.DetailBillImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService implements DetailBillImp {
    @Autowired
    DetailBillDAO detailBillDAO;

    @Override
    public boolean addDetailBill(ChiTietHoaDon chiTietHoaDon) {
        return detailBillDAO.addDetailBill(chiTietHoaDon);
    }
}
