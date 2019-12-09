package com.wom.service;

import com.wom.error.BusinessException;
import com.wom.service.model.UserModel;

public interface UserService {
    //通过用户Id获取用户对象的接口
    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessException;

    /*
    * telphone:用户注册手机
    * password：用户加密后的密码
    *
    * */
    UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
