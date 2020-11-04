package com.example.springboot.controller;


import com.example.springboot.Vo.BooksVo;
import com.example.springboot.Vo.ImagesVo;
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
@RequestMapping("/booksClass")
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
     * 书本分类 树形查询
     * @return
     */
    @GetMapping("selectAllWithBooksClass")
    public Result<BooksClass> selectAllWithTree() {
        return Result.success(booksClassService.listWithTree());
    }

    /**
     * 根据父级ID查出所有所属的书本信息+分页
     * @param id
     * @param number
     * @param content
     * @return
     */
    @GetMapping("selectBooks")
    public Result<BooksClass> selectBooks(Integer id,Integer number,Integer content){
        return Result.success(booksClassService.selectBooks(id,number,content));
    }

    /**
     * 书本信息+分类+店铺名的多表分页查询
     * @param pid
     * @param number
     * @param content
     * @return
     */
    @GetMapping("/booksVo")
    public Result<BooksClass> selectBooksVo(Integer pid, Integer number, Integer content){

        return Result.success(booksClassService.selectBooksVo(pid,number,content));
    }

    /**
     * 查询所有分类
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
     * 修改分类
     * @param booksClass
     * @return
     */
    @PostMapping("/update")
    public Result<BooksClass> update(@RequestBody BooksClass booksClass){
        return booksClassService.update(booksClass);
    }

    /**
     * 删除书本分类
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<BooksClass> deleteById(Integer id){
        return booksClassService.delete(id);
    }




}
