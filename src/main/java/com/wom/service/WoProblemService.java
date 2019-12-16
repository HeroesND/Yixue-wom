package com.wom.service;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.UpdateWoListDto;
import com.wom.service.model.WoProblemModel;

public interface WoProblemService {
    //修改工单内容
    int upWoproblem(UpdateWoListDto updateWoListDto) throws BusinessException;
    WoProblemModel selbyid(Integer id) throws BusinessException;
}
