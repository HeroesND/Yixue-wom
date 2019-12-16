package com.wom.service.model;


import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ProblemModel {

    private Integer id;
    //反馈人
    private String feedBack;
    //处理人
    private String disposeBy;
    //反馈人所属部门
    private String departmentby;
    //学生姓名
    private String studentName;
    //学生手机号
    private String studentPhone;
    //教师姓名
    private String teacherName;
    //工单状态
    private String workType;
    //问题类型
    private Integer problemType;
    //问题补充
    private String problem;
    //处理描述
    private String dispose;
    //来源source
    private Integer sourceType;
    //创建人
    private String createBy;
    //创建时间
    private String createTime;
    //更新人
    private String update_by;

    private String update_at;

    @Override
    public String toString() {
        return "ProblemModel{" +
                "id=" + id +
                ", feedBack='" + feedBack + '\'' +
                ", disposeBy='" + disposeBy + '\'' +
                ", departmentby='" + departmentby + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", workType='" + workType + '\'' +
                ", problemType=" + problemType +
                ", problem='" + problem + '\'' +
                ", dispose='" + dispose + '\'' +
                ", sourceType=" + sourceType +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", update_by='" + update_by + '\'' +
                ", update_at='" + update_at + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getDisposeBy() {
        return disposeBy;
    }

    public void setDisposeBy(String disposeBy) {
        this.disposeBy = disposeBy;
    }

    public String getDepartmentby() {
        return departmentby;
    }

    public void setDepartmentby(String departmentby) {
        this.departmentby = departmentby;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Integer getProblemType() {
        return problemType;
    }

    public void setProblemType(Integer problemType) {
        this.problemType = problemType;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
}
