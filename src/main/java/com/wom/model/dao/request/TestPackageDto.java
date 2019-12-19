package com.wom.model.dao.request;

import com.wom.service.model.PageVo;
import lombok.Data;

@Data
public class TestPackageDto {
    //学生姓名
    private String studentName;
    //学生手机号
    private String studentPhone;
    //电脑型号
    private String modelNumber;
    //cr姓名
    private String crname;
    //配置人
    private String configurationBy;
    //测试包类型
    private String packageType;
    //是否和家长沟通
    private Integer isCommunication;
    //补充内容
    private String lectureSupplement;
    //创建人
    private String createBy;
    //创建时间
    private String createTime;
    //是否删除
    private Integer isdelete;
    //多条件查询使用
    private String testPackage;
    //分页
    private PageVo pageVo;
}
