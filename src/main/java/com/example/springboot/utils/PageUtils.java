package com.example.springboot.utils;

import com.example.springboot.entity.User;

import java.util.List;

/**
 * @author Liangyifeng
 * @created 2020/10/26/14:20
 */


public class PageUtils<T> {

    private Integer pageNo;     // 第多少页
    private Integer pageSize;   // 显示多少记录
    private Long totalRecord;   // 总记录
    private Integer totalPage;  // 总页数
    private List<T> results;    // 返回结果


    public PageUtils(){
        super();
    }

    public PageUtils(Integer pageNo, Integer pageSize, Long totalRecord, Integer totalPage, List<T> results){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.results=results;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}