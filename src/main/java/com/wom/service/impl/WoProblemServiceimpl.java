package com.wom.service.impl;

import com.wom.dao.WoProblemDOMapper;
import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;

import com.wom.model.dao.request.WoListDto;
import com.wom.service.WoProblemService;
import com.wom.model.dao.response.WoProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoProblemServiceimpl implements WoProblemService {

    @Autowired
    private WoProblemDOMapper woProblemDOMapper;

    @Override
    public  int upWoProblemModel(WoListRequestDto woListRequestDto){
        return woProblemDOMapper.upWoProblemModel(woListRequestDto);
    }
    @Override
    public WoProblemModel selWoProblemModelbyid(Integer id){
        return woProblemDOMapper.selWoProblemModelbyid(id);
    }

    @Override
    public List<WoProblemModel> selWoListDtoByPage(WoListDto woListDto){
        return woProblemDOMapper.selWoListDtoByPage(woListDto);
    }

    @Override
    public int selWoListDtoAllNum(WoListDto woListDto){
        return woProblemDOMapper.selWoListDtoAllNum(woListDto);
    }
}
