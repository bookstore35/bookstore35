package com.example.springboot.service.impl;

import com.example.springboot.dao.AdvertiseDao;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Advertise;
import com.example.springboot.service.AdvertiseService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    AdvertiseDao advertiseDao;
    @Override
    public List<Advertise> findAll() {
        return advertiseDao.findAll();
    }

    @Override
    public Result<Advertise> getById(Integer id) {
        Advertise advertise = advertiseDao.findById(id).get();//根据id查询;
        return Result.success(advertise);
    }

    @Override
    public Result insert(Advertise advertise) {
        advertise = advertiseDao.save(advertise);
        return Result.success(advertise);
    }

    @Override
    public Result delete(Integer id) {
        this.advertiseDao.deleteById(id);
        return Result.success("删除成功！");
    }

    @Override
    public Result<Advertise> update(Advertise advertise) {
        this.advertiseDao.save(advertise);
        return Result.success("修改成功!");
    }
}
