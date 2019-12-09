package com.wom;

import com.wom.dao.UserDOMapper;
import com.wom.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.wom"})//springboot的自动化配置
@RestController//springmvc配置
@MapperScan("com.wom.dao")
public class App {

    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")//springmvc配置
    public String home(){
        UserDO userDO=userDOMapper.selectByPrimaryKey(1);
        if (userDO == null){
            return "用户对象不存在";
        }else{
            return userDO.getName();
        }

    }

    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);//启动springboot的项目
    }
}
