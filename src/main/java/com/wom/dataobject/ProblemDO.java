package com.wom.dataobject;

import java.util.Date;

public class ProblemDO {
    private Integer id;

    private String feedBack;

    private String disposeby;

    private String departmentby;

    private String studentname;

    private String studentphone;

    private String teachername;

    private String worktype;

    private int problemtype;

    private String problem;

    private String dispose;

    private int sourcetype;

    private String createby;

    private Date createtime;

    private String updateBy;

    private Date updateAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedBack;
    }

    public void setFeedback(String feedback) {
        this.feedBack = feedback == null ? null : feedback.trim();
    }

    public String getDisposeby() {
        return disposeby;
    }

    public void setDisposeby(String disposeby) {
        this.disposeby = disposeby == null ? null : disposeby.trim();
    }

    public String getDepartmentby() {
        return departmentby;
    }

    public void setDepartmentby(String departmentby) {
        this.departmentby = departmentby == null ? null : departmentby.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone == null ? null : studentphone.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype == null ? null : worktype.trim();
    }

    public int getProblemtype() {
        return problemtype;
    }

    public void setProblemtype(int problemtype) {
        this.problemtype = problemtype;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }

    public String getDispose() {
        return dispose;
    }

    public void setDispose(String dispose) {
        this.dispose = dispose == null ? null : dispose.trim();
    }

    public int getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(int sourcetype) {
        this.sourcetype = sourcetype;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}