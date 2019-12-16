package com.wom.dao;

import com.wom.dataobject.ProblemDO;
import com.wom.service.model.ProblemModel;


public interface ProblemDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemDO problemDO);

    int insertSelective(ProblemModel record);

    ProblemDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemDO record);

    int updateByPrimaryKey(ProblemDO record);
}