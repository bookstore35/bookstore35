package com.example.springboot.controller;

import com.example.springboot.entity.OrderDetail;
import com.example.springboot.service.OrderDeService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单详情接口
 */
@RestController
@RequestMapping("/order_d")

public class OrderDeController {

	//引入业务层的资源
	@Autowired
	private OrderDeService orderDeService;

	/**
	 * 查询所有详情订单
	 * @return
	 */
	@GetMapping("/findAll")
	public Result<OrderDetail> findAll(){
		return Result.success(orderDeService.findAll());
	}

	/**
	 * 根据id查询订单详情信息
	 * @param id
	 * @return
	 */
	@GetMapping("/getById")
	public Result<OrderDetail> getById(Integer id){
		return orderDeService.getById(id);
	}


	/**
	 * 添加订单详情信息
	 * @param orderDetail
	 * @return
	 */
	@PostMapping("/insert")
	public Result insert(@RequestBody List<OrderDetail> orderDetail) {
		this.orderDeService.insert(orderDetail);
		return Result.success("添加成功");
	}

	/**
	 * 修改订单详情信息
	 * @param orderDetail
	 * @return
	 */
	@PostMapping("/update")
	public Result<OrderDetail> update(@RequestBody OrderDetail orderDetail){
		return this.orderDeService.update(orderDetail);
	}


	/**
	 * 删除订单详情
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public Result<OrderDetail> deleteById(Integer id){
		return this.orderDeService.delete(id);
	}



}

