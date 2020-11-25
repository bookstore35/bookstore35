package com.example.springboot.utils;

public class Result<T> {

    private int code;//0代表成功，1代表失败，
    private String msg;//提示信息403代表未登陆
    private T data;//接口返回数据

    public Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;

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

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //包装
    public static Result success(Object data){

        return new Result(CODE.SUCCESS, data, "");
    }
    public static Result error(String msg){
        return new Result(CODE.ERROR, null, msg);
    }
    public static Result error(int code,String msg){
        return new Result(code, null, msg);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
