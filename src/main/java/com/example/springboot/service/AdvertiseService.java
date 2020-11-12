package com.example.springboot.service;

import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Advertise;
import com.example.springboot.utils.Result;

import java.util.List;

public interface AdvertiseService {
    List<Advertise> findAll();
    Result<Advertise> getById(Integer id);
    public Result insert(Advertise advertise);
    public Result delete(Integer id);
    Result<Advertise> update(Advertise advertise);
}
