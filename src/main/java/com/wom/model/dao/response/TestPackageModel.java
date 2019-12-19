package com.wom.model.dao.response;

import lombok.Data;

@Data
public class TestPackageModel {
    //TestPackageid
    private Integer id;
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
    //更新时间
    private String update_at;
    //是否删除
    private Integer isdelete;
}
