package com.example.springboot.controller;

import com.example.springboot.model.Khachhang;
import com.example.springboot.service.IKhachhangService;
import com.example.springboot.service.ServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("khachhang")
public class KhachhangController {
    private final IKhachhangService khachhangService;

    public KhachhangController(IKhachhangService khachhangService) {
        this.khachhangService = khachhangService;
    }

    @GetMapping("/all")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<>(this.khachhangService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{makhachhang}")
    public ResponseEntity<ServiceResult> findById(@PathVariable String makhachhang) {
        return new ResponseEntity<>(this.khachhangService.findByMakhachhang(makhachhang), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@Valid @RequestBody Khachhang khachhang) {
        return new ResponseEntity<>(this.khachhangService.save(khachhang), HttpStatus.CREATED);
    }

    @PutMapping("/update/{makhachhang}")
    public ResponseEntity<ServiceResult> update(@PathVariable String makhachhang,@Valid @RequestBody Khachhang khachhang) {
        return new ResponseEntity<>(this.khachhangService.update(makhachhang, khachhang), HttpStatus.OK);
    }

    @DeleteMapping("delete/{makhachhang}")
    public ResponseEntity<ServiceResult> delete(@PathVariable String makhachhang) {
        return new ResponseEntity<>(this.khachhangService.deleteByMakhachhang(makhachhang), HttpStatus.OK);
    }

    @GetMapping("congty/{tencongty}")
    public ResponseEntity<ServiceResult> findByCongTy(@PathVariable String tencongty) {
        return new ResponseEntity<>(this.khachhangService.findByCongty(tencongty), HttpStatus.OK);
    }
}
