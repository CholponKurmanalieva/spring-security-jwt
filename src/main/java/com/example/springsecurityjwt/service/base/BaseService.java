package com.example.springsecurityjwt.service.base;

import java.util.List;

public interface BaseService<T> {
    T save(T t);
    List<T> getAll();
}