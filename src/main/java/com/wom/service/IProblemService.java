package com.wom.service;

import com.wom.error.BusinessException;
import com.wom.service.model.ProblemModel;


import java.util.List;


public interface IProblemService {

    //创建工单
    ProblemModel createProblem(ProblemModel problemModel) throws BusinessException;

    //工单列表浏览
    List<ProblemModel> listProblem();

    //工单详情浏览
    ProblemModel getProblemById(Integer id);
}
