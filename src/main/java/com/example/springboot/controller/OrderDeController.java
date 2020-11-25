package com.example.springboot.controller;

import com.example.springboot.entity.OrderDetail;
import com.example.springboot.service.OrderDeService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单详情接口
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/order_d")

public class OrderDeController {

	//引入业务层的资源
	@Autowired
	private OrderDeService orderDeService;

	@GetMapping("/findAll")
	public Result<OrderDetail> findAll(){
		return Result.success(orderDeService.findAll());
	}

/*
	 * 根据id查询订单信息
	 * @param id
	 * @return
	*/

	@GetMapping("/getById")
	public Result<OrderDetail> getById(Integer id){
		return orderDeService.getById(id);
	}


/*
	 * 添加订单信息
	 * @param orderDetail
	 * @return
 */

	@PostMapping("/insert")
	public Result<OrderDetail> insert(@RequestBody OrderDetail orderDetail) {
		return this.orderDeService.insert(orderDetail);
	}
/*
	 * 修改订单信息
	 * @param orderDetail
	 * @return
			 */

//	@PostMapping("/update")
//	public Result<OrderDetail> update(@RequestBody OrderDetail orderDetail){
//		return this.orderDeService.update(orderDetail);
//	}

	@PostMapping("/update")
	public Result<OrderDetail> update(@RequestBody OrderDetail orderDetail){
		return this.orderDeService.update(orderDetail);
	}


	/*
	 * 删除订单
	 * @param id
	 * @return
			 */

	@DeleteMapping("/delete")
	public Result<OrderDetail> deleteById(Integer id){
		return this.orderDeService.delete(id);
	}



}

