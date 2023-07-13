package com.example.springboot.service;

import com.example.springboot.exception.KhachhangNotFoundException;
import com.example.springboot.model.Khachhang;
import com.example.springboot.repository.IKhachhangRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class KhachhangService implements IKhachhangService {

    private final IKhachhangRepository iKhachhangRepository;

    public KhachhangService(IKhachhangRepository iKhachhangRepository) {
        this.iKhachhangRepository = iKhachhangRepository;
    }

    @Override
    public ServiceResult<Iterable<Khachhang>> findAll() {
        return new ServiceResult<>(this.iKhachhangRepository.findAll(), true, "Tim thanh cong", ServiceResult.Status.OK);
    }

    @Override
    public ServiceResult<Optional<Khachhang>> findByMakhachhang(String makhachhang) {
        Optional<Khachhang> khachhangOptional = this.iKhachhangRepository.findByMakhachhang(makhachhang);
        if (!khachhangOptional.isPresent()) {
            throw new KhachhangNotFoundException();
        }
        return new ServiceResult<>(khachhangOptional, true, "Tim thanh cong", ServiceResult.Status.OK);
    }

    @Override
    public ServiceResult<Khachhang> save(Khachhang khachhang) {
        Iterable<String> maKhs = this.iKhachhangRepository.findMaKH();
        Boolean flag = true;
        while (flag) {
            String uuid = "KH" + UUID.randomUUID().toString().substring(0, 6);
            int count = 0;
            for (String m : maKhs) {
                if (m.equals(uuid)) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                flag = false;
                khachhang.setMakhachhang(uuid);
                iKhachhangRepository.save(khachhang);
            }
        }
        return new ServiceResult<>(khachhang, true, "Tao thanh cong", ServiceResult.Status.CREATED);
    }

    @Override
    public ServiceResult<Khachhang> update(String makhachhang, Khachhang khachhangUpdate) {
        Khachhang khachhang1 = this.findByMakhachhang(makhachhang).getData().get();
        khachhangUpdate.setMakhachhang(makhachhang);
        return new ServiceResult<>(khachhangUpdate, true, "Cap nhat thanh cong", ServiceResult.Status.OK);
    }

    @Override
    public ServiceResult<Void> deleteByMakhachhang(String makhachhang) {
        this.findByMakhachhang(makhachhang);
        this.iKhachhangRepository.deleteByMakhachhang(makhachhang);
        return new ServiceResult<>(null, true, "Xoa thanh cong", ServiceResult.Status.OK);
    }

    @Override
    public ServiceResult<Iterable<Khachhang>> findByCongty(String tencongty) {
        return new ServiceResult<>(this.iKhachhangRepository.findByCongty(tencongty), true, "OK", ServiceResult.Status.OK);
    }

}
