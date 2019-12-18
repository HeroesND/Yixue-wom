package com.wom.service;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.response.WoListResponseDto;
import com.wom.service.model.WoProblemModel;

import java.util.List;

public interface WoProblemService {
    /**
     * 根据id修改工单
     * @param woListRequestDto
     * @return
     */
    int  upWoproblem(WoListRequestDto woListRequestDto) throws BusinessException;

    /**
     * 根据id查看工单详情
     * @param id
     * @return
     */
    WoProblemModel selbyid(Integer id) throws BusinessException;

    /**
     * 多条件分页查询
     * @param woListResponseDto
     * @return
     */
    List<WoProblemModel> selByPage(WoListResponseDto woListResponseDto)/* throws BusinessException*/;

    /**
     * 多条件分页查询总条数
     * @param woListResponseDto
     * @return
     */
    int selAllNum(WoListResponseDto woListResponseDto)/* throws BusinessException*/;
}
