package com.example.besocialnetwork.service;

import java.util.Optional;

public interface ICRUDService<T, K> {
    Iterable<T> findAll();
    Optional<T> findById(K k);
    T save(T t);
    void deleteById(K k);





}
