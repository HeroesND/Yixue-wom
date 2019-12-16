package com.wom.controller;

import com.wom.error.BusinessException;
import com.wom.model.dao.request.UpdateWoListDto;
import com.wom.service.WoProblemService;
import com.wom.service.impl.WoProblemServiceimpl;
import com.wom.service.model.WoProblemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller("wolist")
@RequestMapping("/api")
@CrossOrigin(origins = {"*"},allowCredentials = "true")//跨域请求
public class WoProblemController extends BaseController {

    @Autowired
    private WoProblemService woProblemService;

    @RequestMapping(value = "/upWoproblem",method ={RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public WoProblemModel upWoproblem (UpdateWoListDto updateWoListDto) throws BusinessException {
            int i=woProblemService.upWoproblem(updateWoListDto);
            if (i==1) {
                WoProblemModel woProblemModel=woProblemService.selbyid(updateWoListDto.getId());
                return woProblemModel;
            }else {
                return null;
            }
    }
    @RequestMapping(value = "/selbyid",method ={RequestMethod.GET},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public WoProblemModel selbyid (@RequestParam(name="id")Integer id) throws BusinessException {
            WoProblemModel woProblemModel=woProblemService.selbyid(id);
            return woProblemModel;
    }
}