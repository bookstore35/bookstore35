package com.example.springboot.service.impl;

import com.example.springboot.Vo.BooksClassVo;
import com.example.springboot.Vo.BooksVo;
import com.example.springboot.dao.BookDao;
import com.example.springboot.dao.ImagesDao;
import com.example.springboot.entity.Book;
import com.example.springboot.entity.Images;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.CODE;
import com.example.springboot.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private ImagesDao imagesDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByBookNameLike(String bookName) {
        return bookDao.findByBookNameLike("%"+bookName+"%");
    }

    @Override
    public BooksVo getById(Integer id) {
        BooksVo vo = new BooksVo();
        Book book = bookDao.findById(id).get();//根据id查询用户;
        BeanUtils.copyProperties(book,vo);

        List<Images> imagesDetails = imagesDao.findByBidAndJudge(id, CODE.JUDGE_DETAIL);
        List<Images> imagesThumbnails = imagesDao.findByBidAndJudge(id, CODE.JUDGE_THUMBNAIL);

        vo.setImagesDetails(imagesDetails);
        vo.setImagesThumbnails(imagesThumbnails);

        return vo;
    }

    @Override
    public Result getByBookName(String bookName) {
        Book book = bookDao.findByBookName(bookName);
        return Result.success(book);
    }

    @Override
    @Transactional
    public Result insert(BooksVo vo) {
        //1.构建book类并保存
        Book book = new Book();
        BeanUtils.copyProperties(vo,book);
        /*book.setAuthor(vo.getAuthor());
        book.setBookName(vo.getBookName());*/

        book = this.bookDao.save(book);

        // 2.给详情图赋值并保存
        List<Images> imagesDetails = vo.getImagesDetails();
        if(imagesDetails != null && imagesDetails.size() > 0){
            for(int i=0;i<imagesDetails.size();i++){
                Images details= imagesDetails.get(i);
                details.setBid(book.getId());
                details.setJudge(0);
            }
            this.imagesDao.saveAll(imagesDetails);
        }
        // 3.给缩略图赋值并保存
        List<Images> imagesThumbnails = vo.getImagesThumbnails();
        if(imagesThumbnails != null && imagesThumbnails.size() > 0){
            for(int i=0;i<imagesThumbnails.size();i++){
                Images details= imagesThumbnails.get(i);
                details.setBid(book.getId());
                details.setJudge(1);
            }
            this.imagesDao.saveAll(imagesThumbnails);
        }

        return Result.success(book);
    }


    @Override
    @Transactional
    public Result update(BooksVo vo){
        imagesDao.deleteByBid(vo.getId());

        Book book = new Book();
        BeanUtils.copyProperties(vo,book);
        this.bookDao.save(book);

        // 2.给详情图赋值并保存
        List<Images> imagesDetails = vo.getImagesDetails();
        if(imagesDetails != null && imagesDetails.size() > 0){
            for(int i=0;i<imagesDetails.size();i++){
                Images details= imagesDetails.get(i);
                details.setBid(book.getId());
                details.setJudge(0);
            }
            this.imagesDao.saveAll(imagesDetails);
        }
        // 3.给缩略图赋值并保存
        List<Images> imagesThumbnails = vo.getImagesThumbnails();
        if(imagesThumbnails != null && imagesThumbnails.size() > 0){
            for(int i=0;i<imagesThumbnails.size();i++){
                Images details= imagesThumbnails.get(i);
                details.setBid(book.getId());
                details.setJudge(1);
            }
            this.imagesDao.saveAll(imagesThumbnails);
        }

        return Result.success("修改成功");
    }



    @Override
    public Result delete(Integer id){

        bookDao.deleteBook(id);
//        this.bookDao.deleteById(id);
        return Result.success("删除成功！");
    }

    /**
     * 设置分页查询所有信息
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<Book> findAll(Integer page, Integer pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        Page<Book> pa=bookDao.findAll(pageable);

        return pa;
    }



}
