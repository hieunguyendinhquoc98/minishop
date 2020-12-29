package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;

@Entity
@Table(name = "MAUSANPHAM")
public class MauSanPham {
    @Id
    @Column(name = "mamau")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mamau;

    @Column(name = "tenmau")
    String tenmau;

    public int getMamau() {
        return mamau;
    }

    public void setMamau(int mamau) {
        this.mamau = mamau;
    }

    public String getTenmau() {
        return tenmau;
    }

    public void setTenmau(String tenmau) {
        this.tenmau = tenmau;
    }
}
