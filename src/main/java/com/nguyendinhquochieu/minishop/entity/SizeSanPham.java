package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;

@Entity
@Table(name = "SIZESANPHAM")
public class SizeSanPham {
    @Id
    @Column(name = "masize")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int masize;

    @Column(name = "size")
    String size;

    public int getMasize() {
        return masize;
    }

    public void setMasize(int masize) {
        this.masize = masize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
