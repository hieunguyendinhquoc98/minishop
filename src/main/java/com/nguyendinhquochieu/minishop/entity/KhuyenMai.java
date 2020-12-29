package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "KHUYENMAI")
public class KhuyenMai {
    @Id
    @Column(name = "makhuyenmai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int makhuyenmai;

    @Column(name = "tenkhuyenmai")
    String tenkhuyenmai;

    @Column(name = "thoigianbatdau")
    String thoigianbatdau;

    @Column(name = "thoigianketthuc")
    String thoigianketthuc;

    @Column(name = "mota")
    String mota;

    @Column(name = "hinhkhuyenmai")
    String tienkhuyenmai;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CHITIETKHUYENMAI", joinColumns = {@JoinColumn(name="makhuyenmai", referencedColumnName = "makhuyenmai")},
            inverseJoinColumns = {@JoinColumn(name ="masanpham",referencedColumnName = "masanpham")}
            )
    Set<SanPham> listSanPham;


    public Set<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(Set<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public int getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public String getTenkhuyenmai() {
        return tenkhuyenmai;
    }

    public void setTenkhuyenmai(String tenkhuyenmai) {
        this.tenkhuyenmai = tenkhuyenmai;
    }

    public String getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(String thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTienkhuyenmai() {
        return tienkhuyenmai;
    }

    public void setTienkhuyenmai(String tienkhuyenmai) {
        this.tienkhuyenmai = tienkhuyenmai;
    }
}
