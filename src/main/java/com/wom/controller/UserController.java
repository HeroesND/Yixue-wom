package com.wom.controller;

import com.alibaba.druid.util.StringUtils;
import com.wom.controller.viewobject.UserVO;
import com.wom.error.BusinessException;
import com.wom.error.EmBusinessError;
import com.wom.response.CommonReturnType;
import com.wom.service.UserService;
import com.wom.service.model.UserModel;
import com.wom.validator.ValidationResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")//跨域请求
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @Autowired
    private  HttpServletRequest httpServletRequest;

    //用户登陆接口
    @RequestMapping(value = "/login",method ={RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "telphone") String telphone,
                                  @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //校验入参
        if (org.apache.commons.lang3.StringUtils.isEmpty(telphone)||StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //用户登陆服务,用来校验用户登陆是否合法
        UserModel userModel=userService.validateLogin(String.valueOf(telphone),this.EncodeByMd5(password));

        //加登陆凭证入到用户登陆成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);
        return CommonReturnType.create("登陆成功");

    }

    public String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        System.out.println("密码："+str);
        String newstr=base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        System.out.println("加密侯密码："+newstr);


        return newstr;
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}