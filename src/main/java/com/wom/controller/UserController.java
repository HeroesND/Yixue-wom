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

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller("user")
@RequestMapping("/")
@CrossOrigin(origins = {"*"},allowCredentials = "true")//跨域请求
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @Autowired
    private  HttpServletRequest httpServletRequest;

    //用户登陆接口
    @RequestMapping(value = "/login",method ={RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody

    public CommonReturnType login(@RequestParam(name="telphone")String telphone,
                                  @RequestParam(name="password")String password) throws BusinessException {
        //校验入参
        if (org.apache.commons.lang3.StringUtils.isEmpty(telphone)||StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        //用户登陆服务,用来校验用户登陆是否合法
        UserModel userModel=userService.validateLogin(String.valueOf(telphone),String.valueOf(password));

        //加登陆凭证入到用户登陆成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);
        return CommonReturnType.create(null);

    }


    @RequestMapping(value = "/register",method ={RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    //用户注册接口
    public CommonReturnType register(@RequestParam(name="telphone")String telphone,
                                     @RequestParam(name="otpCode")String otpCode,
                                     @RequestParam(name="name")String name,
                                     @RequestParam(name="gender")Integer gender,
                                     @RequestParam(name="age")Integer age,
                                     @RequestParam(name="password")Integer password) throws BusinessException {
       //验证手机号和对应的otpCode相符合
        String inSessionotpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode,inSessionotpCode)){//为什么使用对应类库里的equal因为内部做了判空处理
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"短信验证码不符合");

        }
        //用户的注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("byphone");
       /* userModel.setEncrptPassword(this.EncodeByMd5(password));*/
        userModel.setEncrptPassword("encrptPassword");
        userService.register(userModel);
        return CommonReturnType.create(null);
    }

   /* public String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder=new BASE64Encoder();
        //加密字符串
        String newstr=base64Encoder(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
*/

    //用户获取otp短信接口
    @RequestMapping(value = "/getotp",method ={RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telphone")String telphone){
        //需要按照一定的规则生成OTP验证码,取Random随机数
        Random random =new Random();
        int randomInt=random.nextInt(99999);
        randomInt+=10000;
        String otpCode=String.valueOf(randomInt);
        //将OTP验证码同对应用户的手机号关联,使用HTTPsession的方式绑定他的手机号与OTPCDODE
        httpServletRequest.getSession().setAttribute(telphone,otpCode);



        //将OTP验证码通过短信通道发送给用户，省略
        System.out.println("telphone="+ telphone+"&otpCode="+otpCode);

        return CommonReturnType.create(null);
    }


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType fetUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务获取对应Id的用户对象并返回给前端

        UserModel userModel = userService.getUserById(id);
        ValidationResult result= new ValidationResult();

        //若获取的对应用户信息不存在
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST, result.getErrMsg());
        }

        //将核心领域模型与用户对象转化为可供UI使用的viewobject
        UserVO userVO = convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);

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