package com.nguyendinhquochieu.minishop.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="CHITIETHOADON")
public class ChiTietHoaDon {
    @EmbeddedId
    ChiTietHoaDonId chiTietHoaDonId;
    @Column(name = "soluong")
    int soluong;
    @Column(name = "giatien")
    String giatien;

    public ChiTietHoaDonId getChiTietHoaDonId() {
        return chiTietHoaDonId;
    }

    public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
        this.chiTietHoaDonId = chiTietHoaDonId;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }



}
