package com.wom.dao;

import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.response.WoListResponseDto;
import com.wom.service.model.WoProblemModel;

import java.util.List;

public interface WoProblemDOMapper {
    /**
     * 根据id修改工单
     * @param woListRequestDto
     * @return
     */
    int  upWoproblem(WoListRequestDto woListRequestDto);

    /**
     * 根据id查看工单详情
     * @param id
     * @return
     */
    WoProblemModel selbyid(Integer id);

    /**
     * 多条件分页查询
     * @param woListResponseDto
     * @return
     */
    List<WoProblemModel> selByPage(WoListResponseDto woListResponseDto);

    /**
     * 多条件分页查询总条数
     * @param woListResponseDto
     * @return
     */
    int selAllNum(WoListResponseDto woListResponseDto);
}
