package com.wom.controller;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.request.WoListDto;
import com.wom.service.WoProblemService;
import com.wom.service.model.PageVo;
import com.wom.model.dao.response.WoProblemModel;
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
public class WoProblemController {

    @Autowired
    private WoProblemService woProblemService;
    @RequestMapping(value = "/updateById",method ={RequestMethod.POST})
    @ResponseBody
    public int upWoProblemModel (WoListRequestDto woListRequestDto){
            System.out.println(woListRequestDto);
            int i=woProblemService.upWoProblemModel(woListRequestDto);
            if (i==1) {
                return 200;
            }else {
                return 10002;
            }
    }
    @RequestMapping(value = "/findById",method ={RequestMethod.GET})
    @ResponseBody
    public WoProblemModel selWoProblemModelbyid (@RequestParam(name="id")Integer id){
            WoProblemModel woProblemModel=woProblemService.selWoProblemModelbyid(id);
            return woProblemModel;
    }

    @RequestMapping(value = "/findAll",method ={RequestMethod.GET})
    @ResponseBody
    public Object selWoListDtoByPage (HttpServletRequest request, WoListDto woListDto){
        PageVo pageVo =new PageVo();
        String page=request.getParameter("page");
        String pageSize=request.getParameter("limit");
        pageVo.setPage(Integer.parseInt(page));
        pageVo.setPageSize(Integer.parseInt(pageSize));
        woListDto.setPageVo(pageVo);
        List<WoProblemModel> list=woProblemService.selWoListDtoByPage(woListDto);
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println(woListDto);
        System.out.println(list);
        map.put("code", 0);
        map.put("data", list);
        map.put("count", woProblemService.selWoListDtoAllNum(woListDto));
        return map;
    }

}