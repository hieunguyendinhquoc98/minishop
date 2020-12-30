package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "HOADON")
public class HoaDon {
    @Id
    @Column(name = "mahoadon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mahoadon;

    @Column(name = "tenkhachhang")
    String tenkhachhang;

    @Column(name = "sodt")
    String sodt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mahoadon")
    Set<ChiTietHoaDon> listChiTietHoaDon;

    @Column(name = "diachigiaohang")
    String diachigiaohang;
    @Column(name = "tinhtrang")
    boolean tinhtrang;
    @Column(name = "ngaylap")
    String ngaylap;

    @Column(name = "hinhthucgiaohang")
    String hinhthucgiaohang;
    @Column(name ="ghichu")
    String ghichu;


    public String getHinhthucgiaohang() {
        return hinhthucgiaohang;
    }

    public void setHinhthucgiaohang(String hinhthucgiaohang) {
        this.hinhthucgiaohang = hinhthucgiaohang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Set<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(Set<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }
}
