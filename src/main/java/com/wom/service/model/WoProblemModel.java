package com.wom.service.model;
import lombok.Data;

import	java.util.Date;
@Data
public class WoProblemModel {
    private Integer id;
    private String feedBack;
    private String disposeBy;
    private String departmentby;
    private String studentName;
    private String studentPhone;
    private String teacherName;
    private Integer workType;
    private Integer problemType;
    private String  problem;
    private String dispose;
    private Integer sourceType;
    private String createBy;
    private  Date createTime;
    private String update_by;
    private Date update_at;
}
