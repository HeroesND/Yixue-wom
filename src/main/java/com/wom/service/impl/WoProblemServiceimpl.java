package com.wom.service.impl;

import com.wom.dao.WoProblemDOMapper;
import com.wom.error.BusinessException;
import com.wom.model.dao.request.UpdateWoListDto;

import com.wom.service.WoProblemService;
import com.wom.service.model.WoProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WoProblemServiceimpl implements WoProblemService {

    @Autowired
    private WoProblemDOMapper woProblemDOMapper;

    @Override
    public  int upWoproblem(UpdateWoListDto updateWoListDto) throws BusinessException {
        return woProblemDOMapper.upWoproblem(updateWoListDto);
    }
    @Override
    public WoProblemModel selbyid(Integer id) throws BusinessException {
        return woProblemDOMapper.selbyid(id);
    }
}
