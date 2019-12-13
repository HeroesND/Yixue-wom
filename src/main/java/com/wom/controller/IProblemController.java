package com.wom.controller;

import com.wom.controller.viewobject.IProblemVO;
import com.wom.error.BusinessException;
import com.wom.response.CommonReturnType;
import com.wom.service.IProblemService;
import com.wom.service.model.ProblemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/problem")
@RequestMapping("/problem")
@CrossOrigin(origins = {"*"},allowCredentials = "true")//跨域请求
public class IProblemController extends BaseController {

    @Autowired
    private IProblemService iProblemService;

    //创建工单的controller
    public CommonReturnType createProblem(@RequestParam(name="feedBack")String feedBack,
                                          @RequestParam(name="disposeBy")String disposeBy,
                                          @RequestParam(name="departmentby")String departmentby,
                                          @RequestParam(name="studentName")String studentName,
                                          @RequestParam(name="studentPhone")String studentPhone,
                                          @RequestParam(name="teacherName")String teacherName,
                                          @RequestParam(name="workType")String workType,
                                          @RequestParam(name="problemType")String problemType,
                                          @RequestParam(name="problem")String problem,
                                          @RequestParam(name="dispose")String dispose,
                                          @RequestParam(name="sourceType")String sourceType,
                                          @RequestParam(name="createBy")String createBy,
                                          @RequestParam(name="createTime")String createTime,
                                          @RequestParam(name="update_by")String update_by,
                                          @RequestParam(name="update_at")String update_at) throws BusinessException {
        //封装service请求用来创建工单
        ProblemModel problemModel=new ProblemModel();
        problemModel.setFeedBack(feedBack);
        problemModel.setDisposeBy(disposeBy);
        problemModel.setDepartmentby(departmentby);
        problemModel.setStudentName(studentName);
        problemModel.setStudentPhone(studentPhone);
        problemModel.setTeacherName(teacherName);
        problemModel.setWorkType(workType);
        problemModel.setProblemType(Integer.parseInt(problemType));
        problemModel.setProblem(problem);
        problemModel.setDispose(dispose);
        problemModel.setSourceType(sourceType);
        problemModel.setCreateBy(createBy);
        problemModel.setCreateTime(createTime);
        problemModel.setUpdate_by(update_by);
        problemModel.setUpdate_at(update_at);

        ProblemModel problemModelForReturn = iProblemService.createProblem(problemModel);
        IProblemVO iProblemVO=convertVOFromModel(problemModelForReturn);
        return CommonReturnType.create(iProblemVO);
    }

    private IProblemVO convertVOFromModel(ProblemModel problemModel){
        if(problemModel==null){
            return null;
        }
        IProblemVO iProblemVO=new IProblemVO();
        BeanUtils.copyProperties(problemModel,iProblemVO);
        return iProblemVO;
    }
}
