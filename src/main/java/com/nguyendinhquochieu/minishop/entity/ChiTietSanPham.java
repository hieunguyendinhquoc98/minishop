package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;

@Entity
@Table(name = "CHITIETSANPHAM")
public class ChiTietSanPham {
    @Id
    @Column(name = "machitietsanpham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int machitietsanpham;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masanpham")
    SanPham sanpham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masize")
    SizeSanPham sizeSanPham;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mamau")
    MauSanPham mauSanPham;
    @Column(name = "soluong")
    int soluong;
    @Column(name = "ngaynhap")
    String ngaynhap;

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public SizeSanPham getSizeSanPham() {
        return sizeSanPham;
    }

    public void setSizeSanPham(SizeSanPham sizeSanPham) {
        this.sizeSanPham = sizeSanPham;
    }

    public MauSanPham getMausanpham() {
        return mauSanPham;
    }

    public void setMausanpham(MauSanPham mauSanPham) {
        this.mauSanPham = mauSanPham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
}
