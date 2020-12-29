package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Column(name = "manhanvien")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int manhanvien;

    @Column(name = "hoten")
    String hoten;
    @Column(name = "diachi")
    String diachi;
    @Column(name = "gioitinh")
    boolean gioitinh;
    @Column(name = "cmnd")
    String cmnd;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machucvu")
    ChucVu chucVu;
    @Column(name = "email")
    String email;
    @Column(name = "tendangnhap")
    String tendangnhap;
    @Column(name = "matkhau")
    String matkhau;

    public int getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
