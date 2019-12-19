package com.wom.service;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.request.WoListDto;
import com.wom.model.dao.response.WoProblemModel;

import java.util.List;

public interface WoProblemService {
    /**
     * 根据id修改工单
     * @param woListRequestDto
     * @return
     */
    int  upWoProblemModel(WoListRequestDto woListRequestDto);

    /**
     * 根据id查看工单详情
     * @param id
     * @return
     */
    WoProblemModel selWoProblemModelbyid(Integer id);

    /**
     * 多条件分页查询
     * @param woListDto
     * @return
     */
    List<WoProblemModel> selWoListDtoByPage(WoListDto woListDto);

    /**
     * 多条件分页查询总条数
     * @param woListDto
     * @return
     */
    int selWoListDtoAllNum(WoListDto woListDto);
}
