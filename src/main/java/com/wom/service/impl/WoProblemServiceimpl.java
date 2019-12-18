package com.wom.service.impl;

import com.wom.dao.WoProblemDOMapper;
import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;

import com.wom.model.dao.response.WoListResponseDto;
import com.wom.service.WoProblemService;
import com.wom.service.model.WoProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoProblemServiceimpl implements WoProblemService {

    @Autowired
    private WoProblemDOMapper woProblemDOMapper;

    @Override
    public  int upWoproblem(WoListRequestDto woListRequestDto) throws BusinessException {
        return woProblemDOMapper.upWoproblem(woListRequestDto);
    }
    @Override
    public WoProblemModel selbyid(Integer id) throws BusinessException {
        return woProblemDOMapper.selbyid(id);
    }

    @Override
    public List<WoProblemModel> selByPage(WoListResponseDto woListResponseDto)/* throws BusinessException */{
        return woProblemDOMapper.selByPage(woListResponseDto);
    }

    @Override
    public int selAllNum(WoListResponseDto woListResponseDto)/* throws BusinessException */{
        return woProblemDOMapper.selAllNum(woListResponseDto);
    }
}
