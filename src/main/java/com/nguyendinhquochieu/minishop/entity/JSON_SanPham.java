package com.nguyendinhquochieu.minishop.entity;

import java.util.Set;

public class JSON_SanPham {

    int masanpham;
    DanhMucSanPham danhMucSanPham;
    String tensanpham;
    String giatien;
    String mota;
    String hinhsanpham;
    String gianhcho;
    Set<ChiTietSanPham> chitietsanpham;
    Set<KhuyenMai> listKhuyenMai;

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public String getGianhcho() {
        return gianhcho;
    }

    public void setGianhcho(String gianhcho) {
        this.gianhcho = gianhcho;
    }

    public Set<ChiTietSanPham> getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }

    public Set<KhuyenMai> getListKhuyenMai() {
        return listKhuyenMai;
    }

    public void setListKhuyenMai(Set<KhuyenMai> listKhuyenMai) {
        this.listKhuyenMai = listKhuyenMai;
    }
}
