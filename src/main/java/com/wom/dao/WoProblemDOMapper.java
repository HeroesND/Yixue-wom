package com.wom.dao;

import com.wom.model.dao.request.UpdateWoListDto;
import com.wom.service.model.WoProblemModel;

public interface WoProblemDOMapper {
    int  upWoproblem(UpdateWoListDto updateWoListDto);
    WoProblemModel selbyid(Integer id);
}
