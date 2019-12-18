package com.wom.model.dao.response;

import com.wom.service.model.PageVo;
import lombok.Data;

import java.util.Date;
@Data
public class WoListResponseDto {
    //学生姓名或者老师姓名模糊查询
    private String woName;
    //反馈人姓名模糊查询
    private String feedBack;
    //工单状态
    private Integer workType;
    //问题处理情况   音频问题   网络问题
    private Integer problemType;
    //课程类型  正课  试听课
    private Integer courseType;
    //处理人 选择技术支持
    private String disposeBy;
    //创建时间
    private Date beginCreateTime;
    //创建时间
    private Date endCreateTime;
    //分页
    private PageVo pageVo;
}
