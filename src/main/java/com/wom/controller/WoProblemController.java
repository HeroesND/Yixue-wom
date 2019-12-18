package com.wom.controller;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.response.WoListResponseDto;
import com.wom.service.WoProblemService;
import com.wom.service.model.PageVo;
import com.wom.service.model.WoProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("wolist")
@RequestMapping("/wo/issue/problem")
@CrossOrigin(origins = {"*"},allowCredentials = "true")//跨域请求
public class WoProblemController/* extends BaseController */{

    @Autowired
    private WoProblemService woProblemService;
    @RequestMapping(value = "/updateById",method ={RequestMethod.POST}/*,consumes = {CONTENT_TYPE_FORMED}*/)
    @ResponseBody
    public WoProblemModel upWoproblem (WoListRequestDto woListRequestDto) throws BusinessException {
            int i=woProblemService.upWoproblem(woListRequestDto);
            if (i==1) {
                WoProblemModel woProblemModel=woProblemService.selbyid(woListRequestDto.getId());
                return woProblemModel;
            }else {
                return null;
            }
    }
    @RequestMapping(value = "/findById",method ={RequestMethod.GET}/*,consumes = {CONTENT_TYPE_FORMED}*/)
    @ResponseBody
    public WoProblemModel selbyid (@RequestParam(name="id")Integer id) throws BusinessException {
            WoProblemModel woProblemModel=woProblemService.selbyid(id);
            return woProblemModel;
    }

    @RequestMapping(value = "/findAll",method ={RequestMethod.GET}/*,consumes = {CONTENT_TYPE_FORMED}*/)
    @ResponseBody
    public Object selByPage (HttpServletRequest request,WoListResponseDto woListResponseDto)/* throws BusinessException */{
        PageVo pageVo =new PageVo();
        String page=request.getParameter("page");
        String pageSize=request.getParameter("limit");
        pageVo.setPage(Integer.parseInt(page));
        pageVo.setPageSize(Integer.parseInt(pageSize));
        woListResponseDto.setPageVo(pageVo);
        List<WoProblemModel> list=woProblemService.selByPage(woListResponseDto);
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println(woListResponseDto);
        System.out.println(list);
        map.put("code", 0);
        map.put("data", list);
        map.put("count", woProblemService.selAllNum(woListResponseDto));
        return map;
    }

}