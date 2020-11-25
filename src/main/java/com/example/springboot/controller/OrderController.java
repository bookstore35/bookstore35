package com.example.springboot.controller;

import com.example.springboot.entity.BookOrder;
import com.example.springboot.service.OrderService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单接口
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/book_ord")

public class OrderController {

	//引入业务层的资源
	@Autowired
	private OrderService orderService;

	@GetMapping("/findAll")
	public Result<BookOrder> findAll(){
		return Result.success(orderService.findAll());
	}

/*
	 * 根据id查询订单信息
	 * @param id
	 * @return
	*/

	@GetMapping("/getById")
	public Result<BookOrder> getById(Integer id){
		return orderService.getById(id);
	}


/*
	 * 添加订单信息。
	 * @param bookOrder
	 * @return
 */

	@PostMapping("/insert")
	public Result<BookOrder> insert(@RequestBody BookOrder bookOrder) {
		return this.orderService.insert(bookOrder);
	}
/*
	 * 修改订单信息
	 * @param bookOrder
	 * @return
			 */

	@PostMapping("/update")
	public Result<BookOrder> update(@RequestBody BookOrder bookOrder){
		return this.orderService.update(bookOrder);
	}

/*
	 * 删除订单
	 * @param id
	 * @return
			 */

	@DeleteMapping("/delete")
	public Result<BookOrder> deleteById(Integer id){
		return this.orderService.delete(id);
	}



}

