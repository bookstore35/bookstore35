package com.example.springboot.controller;

import com.example.springboot.aop.UserLoginToken;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

import com.example.springboot.utils.CodeUtil;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户管理
 *
 * @author yife
 * @return
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CodeUtil codeUtil;
    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param username  用户名
     * @param password  密码
     * @return
     *
     */
    @GetMapping("/login")
    public Result<User>  login(String username , String password , HttpServletRequest request){
        return userService.login(username ,password);
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public Result<User>  regist(@RequestBody User user,HttpServletRequest request){

        try {
            if (!codeUtil.checkVerifyCode(request)) {
                return Result.error("验证码出错");
            }
        } catch (Exception e) {
            // 返回错误信息给前端
            return Result.error(e.getMessage());
        }
        return this.userService. regist(user);
    }
    /**
     * 查询所有用户接口
     * @return
     */
    @GetMapping("/findAll")
    public Result<User> findAll(){
        return Result.success(userService.findAll());
    }
    /**
     * 根据id查询用户接口
     *
     * @return
     */
    @UserLoginToken
    @GetMapping("/getById")
    public Result<User>  getById(Integer id){

        return userService.getById(id);
    }
    /**
     * 修改用户接口
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result<User> update(@RequestBody User user ){

        return this.userService.update(user);
}

    /**
     * 删除用户接口
     *
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<User> delete(@PathVariable("id") Integer id ){
        return this.userService.delete(id);
    }

    /**
     * 手机登录发送验证码接口
     *
     * @return
     */
    @GetMapping("/loginVerify")
    public Result<User>  loginVerify(String moblie , String code , HttpServletRequest request){

        return userService.loginVerify(moblie ,code);
    }

    /**
     * 发送短信验证码接口
     * @param tel 手机号
     * @param type 短信类型：0 注册， 1 登录
     * @return
     */
    @GetMapping("/send")
    public Result sendMessage(String tel , Integer type){

        //type_tel :key
        return userService.sendMessage(tel,type);
    }


}
