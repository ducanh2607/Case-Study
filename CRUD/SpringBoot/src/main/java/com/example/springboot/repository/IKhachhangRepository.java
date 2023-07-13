package com.example.springboot.repository;

import com.example.springboot.model.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IKhachhangRepository extends JpaRepository<Khachhang, String> {
    Optional<Khachhang> findByMakhachhang(String makhachang);

    @Transactional
    void deleteByMakhachhang(String makhachhang);

    @Query(value = "select * from khachhang where tencongty= :tencongty", nativeQuery = true)
    Iterable<Khachhang> findByCongty(@Param("tencongty") String tencongty);

    @Query(value = "select makhachhang from khachhang", nativeQuery = true)
    Iterable<String> findMaKH();

}
