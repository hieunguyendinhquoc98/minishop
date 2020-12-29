package com.nguyendinhquochieu.minishop.entity;

import javax.persistence.*;

@Entity
@Table(name="CHUCVU")
public class ChucVu {
    @Id
    @Column(name = "machucvu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int machucvu;

    @Column(name = "tenchucvu")
    String tenchucvu;

    public int getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(int machucvu) {
        this.machucvu = machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }
}
