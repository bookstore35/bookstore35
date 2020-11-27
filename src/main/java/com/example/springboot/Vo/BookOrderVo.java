package com.example.springboot.Vo;

import com.example.springboot.entity.BookOrder;
import com.example.springboot.entity.OrderDetail;

import java.util.List;

public class BookOrderVo extends BookOrder {
    private List<OrderDetail> orderDetails; //详细集合

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
