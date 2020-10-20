package com.example.springboot.utils;

import java.util.List;

/**
 * 设置json的格式，与layui数据表单接收json格式保持一致
 * @param <T>
 */
public class LayData<T> {
    private int code;
    private String msg;
    private long count;
    private List<T> data;

    public LayData() {
    }

    @Override
    public String toString() {
        return "LayData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}