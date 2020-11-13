package com.example.springboot.controller;

import com.example.springboot.entity.Advertise;
import com.example.springboot.service.AdvertiseService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 广告接口
 */
@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;

    /**
     * 查找所有
     * @return
     */
    @GetMapping("/findAll")
    public Result<Advertise> findAll(){
        return Result.success(advertiseService.findAll());
    }

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result<Advertise> getById(Integer id){
        return advertiseService.getById(id);
    }

    /**
     * 新增
     * @param advertise
     * @return
     */
    @PostMapping("/insert")
    public Result<Advertise> insert(@RequestBody Advertise advertise){
        return Result.success(advertiseService.insert(advertise));
    }

    /**
     * 修改
     * @param advertise
     * @return
     */
    @PostMapping("/update")
    public Result<Advertise> update(@RequestBody Advertise advertise){
        return Result.success(advertiseService.update(advertise));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result<Advertise> delete(Integer id){
        return Result.success(advertiseService.delete(id));
    }

}
