package com.example.example_trainningday4.service;

import java.util.*;

public interface IGeneric<T,E> {
    List<T> findAll();
    T save (T t);
    void deleteById(E id);
    T findById(E id);
    T update(Long id,T t);
}
