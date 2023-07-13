package com.example.springboot.service;


import com.example.springboot.model.Khachhang;
import java.util.Optional;

public interface IKhachhangService {
    ServiceResult<Iterable<Khachhang>> findAll();
    ServiceResult<Optional<Khachhang>> findByMakhachhang(String makhachhang);
    ServiceResult<Khachhang> save (Khachhang khachhang);
    ServiceResult<Khachhang> update (String makhachhang, Khachhang khachhang);
    ServiceResult<Void> deleteByMakhachhang(String makhachhang);
    ServiceResult<Iterable<Khachhang>> findByCongty(String macongty);
}
