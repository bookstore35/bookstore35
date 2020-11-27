package com.example.springboot.service.impl;

import com.example.springboot.Vo.BookOrderVo;
import com.example.springboot.dao.OrderDao;
import com.example.springboot.dao.OrderDetailDao;
import com.example.springboot.entity.BookOrder;
import com.example.springboot.entity.OrderDetail;
import com.example.springboot.service.OrderService;
import com.example.springboot.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	//引入Dao层
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public List<BookOrder> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Result getById(Integer id) {
		return Result.success(orderDao.findById(id));
	}

	@Override
	public Result insert(BookOrderVo bookOrderVo) {
		BookOrder bookOrder = new BookOrder();
		BeanUtils.copyProperties(bookOrderVo,bookOrder);
		bookOrder = this.orderDao.save(bookOrder);

		List<OrderDetail> orderDetails = bookOrderVo.getOrderDetails();
		if(orderDetails != null && orderDetails.size() > 0){
			for(int i=0;i<orderDetails.size();i++){
				OrderDetail details= orderDetails.get(i);

				details.setOid(bookOrder.getOid());

			}
			this.orderDetailDao.saveAll(orderDetails);
		}

		return Result.success("添加成功");
}

	@Override
	public Result delete(Integer id) {
		this.orderDao.deleteById(id);
		return Result.success("删除成功！");
	}

	@Override
	public Result update(BookOrder bookOrder) {
		orderDao.save(bookOrder);
		return Result.success("修改成功!");
	}

}
