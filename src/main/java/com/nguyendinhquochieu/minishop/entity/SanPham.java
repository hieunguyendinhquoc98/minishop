package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SANPHAM")
public class SanPham {
    @Id
    @Column(name = "masanpham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int masanpham;

    @OneToOne
    @JoinColumn(name ="madanhmuc")
    DanhMucSanPham  danhMucSanPham;

    @Column(name = "tensanpham")
    String tensanpham;

    @Column(name = "giatien")
    String giatien;

    @Column(name = "mota")
    String mota;

    @Column(name = "hinhsanpham")
    String hinhsanpham;

    @Column(name = "gianhcho")
    String gianhcho;

    @OneToMany(fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
    @JoinColumn(name="masanpham")
    Set<ChiTietSanPham> chitietsanpham;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CHITIETKHUYENMAI", joinColumns = {@JoinColumn(name="masanpham", referencedColumnName = "masanpham")},
            inverseJoinColumns = {@JoinColumn(name ="makhuyenmai",referencedColumnName = "makhuyenmai")}
    )
    Set<KhuyenMai> listKhuyenMai;

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

}
