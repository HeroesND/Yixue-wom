package com.wom.service.impl;

import com.wom.dao.ProblemDOMapper;
import com.wom.dataobject.ProblemDO;
import com.wom.error.BusinessException;
import com.wom.error.EmBusinessError;
import com.wom.service.IProblemService;
import com.wom.service.model.ProblemModel;
import com.wom.validator.ValidationResult;
import com.wom.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IProblemServiceImpl implements IProblemService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ProblemDOMapper problemDOMapper;

    private ProblemDO convertProblemDOFromProblemModel(ProblemModel problemModel){
        if (problemModel==null){
            return null;
        }
        ProblemDO problemDO=new ProblemDO();
        BeanUtils.copyProperties(problemModel,problemDO);
        return problemDO;
    }
    @Override
    @Transactional
    public ProblemModel createProblem(ProblemModel problemModel) throws BusinessException {
        //校验入参
        System.out.println(problemModel);
        ValidationResult result= validator.validate(problemModel);
        if (result.isHasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,result.getErrMsg());
        }

        //转化ProblemModel->dataobject
        ProblemDO problemDO=this.convertProblemDOFromProblemModel(problemModel);

        //写入数据库
        problemDOMapper.insertSelective(problemModel);
        /*problemModel.setId(problemDO.getId());*/

        //返回创建完成的对象
        return problemModel;
    }

    @Override
    public List<ProblemModel> listProblem() {
        return null;
    }

    @Override
    public ProblemModel getProblemById(Integer id) {
        ProblemDO problemDO=problemDOMapper.selectByPrimaryKey(id);
        if (problemDO==null){
            return null;
        }

        //将dataobject->model
        ProblemModel problemModel =convertModelFormDataobject(problemDO);

        return problemModel;
    }

    private ProblemModel convertModelFormDataobject(ProblemDO problemDO){
        ProblemModel problemModel=new ProblemModel();
        BeanUtils.copyProperties(problemDO,problemModel);

        return problemModel;
    }
}
