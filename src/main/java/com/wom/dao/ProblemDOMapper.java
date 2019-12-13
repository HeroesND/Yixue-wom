package com.wom.dao;

import com.wom.dataobject.ProblemDO;


public interface ProblemDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemDO record);

    int insertSelective(ProblemDO record);

    ProblemDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemDO record);

    int updateByPrimaryKey(ProblemDO record);
}