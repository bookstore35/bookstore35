package com.example.springboot.controller;


import com.example.springboot.Vo.BooksVo;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.service.BooksClassService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 书本分类查询接口
 */
@RestController
public class BooksClassController {
    @Autowired
    private BooksClassService booksClassService;

    /**
     * 查询书本分类
     * @param id
     * @return
     */
    @GetMapping("/booksClass")
    public Result<BooksClass> selectBooksClass(Integer id){

        return Result.success(booksClassService.selectBooksClass(id));
    }

    /**
     * 多表查询
     * @return
     */
    @GetMapping("/booksVo")
    public Result<BooksVo> selectBooksVo(){

        return Result.success(booksClassService.selectBooksVo());
    }

    /**
     *查询所有分类
     * @return
     */
    @GetMapping("/findAllByLevel")
    public Result<BooksClass> findAll(){
        return Result.success(booksClassService.findAll());
    }

    /**
     * 添加分类
     * @param booksClass
     * @return
     */
    @PostMapping("/insert")
    public Result<BooksClass> insert(@RequestBody BooksClass booksClass) {
        return booksClassService.insert(booksClass);
    }

    /**
     * 修改类别
     * @param booksClass
     * @return
     */
    @PostMapping("/update")
    public Result<BooksClass> update(@RequestBody BooksClass booksClass){
        return booksClassService.update(booksClass);
    }

    /**
     * 删除商家
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<BooksClass> deleteById(Integer id){
        return booksClassService.delete(id);
    }


    /**
     * 书本分类 树形查询
     * @return
     */
    @GetMapping("selectAllWithBooksClass")
    public Result<BooksClass> selectAllWithTree() {
        return Result.success(booksClassService.listWithTree());
    }

}
