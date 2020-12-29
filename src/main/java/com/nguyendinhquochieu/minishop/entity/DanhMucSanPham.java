package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "DANHMUCSANPHAM")
public class DanhMucSanPham {
    @Id
    @Column(name = "madanhmuc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int madanhmuc;

    @Column(name = "tendanhmuc")
    String tendanhmuc;

    @Column(name = "hinhdanhmuc")
    String hinhdanhmuc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "madanhmuc")
    Set<SanPham> danhsachsanpham;

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getHinhdanhmuc() {
        return hinhdanhmuc;
    }

    public void setHinhdanhmuc(String hinhdanhmuc) {
        this.hinhdanhmuc = hinhdanhmuc;
    }
    public Set<SanPham> getDanhsachsanpham() {
        return danhsachsanpham;
    }

    public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
        this.danhsachsanpham = danhsachsanpham;
    }
}
