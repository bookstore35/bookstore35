package com.example.springboot.service.impl;

import com.example.springboot.dao.OrderDetailDao;
import com.example.springboot.entity.OrderDetail;
import com.example.springboot.service.OrderDeService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDeServiceImpl implements OrderDeService {

	//引入Dao层
	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}

	@Override
	public Result getById(Integer id) {
		return Result.success(orderDetailDao.findById(id));
	}

	@Override
	public Result insert(List<OrderDetail> orderDetail) {
		for(int i=0;i<orderDetail.size();i++){

			orderDetailDao.save(orderDetail.get(i));
		}
		return Result.success("保存成功");
	}

	@Override
	public Result delete(Integer id) {
		this.orderDetailDao.deleteById(id);
		return Result.success("删除成功！");
	}

	@Override
	public Result<OrderDetail> update(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
		return Result.success("修改成功!");
	}

}
