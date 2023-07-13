package com.example.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "khachhang")
public class Khachhang {
    @Id
    @Column(name = "makhachhang")
    private String makhachhang;
    @Size(max = 50, message = "Ten cong ty toi da 50 ky tu.")
    @NotNull(message = "Ten cong ty khong duoc de trong.")
    @Column(name = "tencongty")
    private String tencongty;
    @Size(max = 30, message = "Ten giao dich toi da 30 ky tu.")
    @NotNull(message = "Ten giao dich khong duoc de trong.")
    @Column(name = "tengiaodich")
    private String tengiaodich;
    @Size(max = 50, message = "Dia chi toi da 50 ky tu.")
    @Column(name = "diachi")
    private String diachi;
    @Size(max = 30, message = "Email toi da 30 ky tu.")
    @Column(name = "email")
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email sai dinh dang")
    private String email;
    @Size(max = 15, message = "Dien thoai toi da 15 ky tu.")
    @Column(name = "dienthoai")
    private String dienthoai;
    @Size(max = 15, message = "Fax toi da 15 ky tu.")
    @Column(name = "fax")
    private String fax;

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
    }

    public String getTengiaodich() {
        return tengiaodich;
    }

    public void setTengiaodich(String tengiaodich) {
        this.tengiaodich = tengiaodich;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
