package com.example.springboot.controller;

import com.example.springboot.entity.Advertise;
import com.example.springboot.service.AdvertiseService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;
    
    /**
     * @author 自定义
     * @Description TODO
     * @date 10:08 2020/11/12
     * 查找所有
     * @param
     * @return com.example.springboot.utils.Result<com.example.springboot.entity.Advertise>
     **/
    @GetMapping("/findAll")
    public Result<Advertise> findAll(){
        return Result.success(advertiseService.findAll());
    }

    /**
     * @author 自定义
     * @Description TODO
     * @date 9:32 2020/11/12
     * 根据ID查找
     * @param id
     * @return com.example.springboot.utils.Result<com.example.springboot.entity.Advertise>
     **/
    @GetMapping("/getById")
    public Result<Advertise> getById(Integer id){
        return advertiseService.getById(id);
    }

    /**
     * @author 自定义
     * @Description TODO
     * @date 0:37 2020/11/12
     * 插入
     * @param advertise
     * @return
     **/
    @PostMapping("/insert")
    public Result<Advertise> insert(@RequestBody Advertise advertise){
        return Result.success(advertiseService.insert(advertise));
    }

    /**
     * @author 自定义
     * @Description TODO
     * @date 0:46 2020/11/12
     * 修改
     * @param advertise
     * @return
     **/
    @PostMapping("/update")
    public Result<Advertise> update(@RequestBody Advertise advertise){
        return Result.success(advertiseService.update(advertise));
    }

    /**
     * @author 自定义
     * @Description TODO
     * @date 0:46 2020/11/12
     * 删除
     * @param id
     * @return
     **/
    @GetMapping("/delete")
    public Result<Advertise> delete(Integer id){
        return Result.success(advertiseService.delete(id));
    }

}
