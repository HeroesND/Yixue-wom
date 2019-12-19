package com.wom.controller;

import com.wom.model.dao.request.TestPackageDto;
import com.wom.model.dao.request.WoListDto;
import com.wom.model.dao.request.WoListRequestDto;
import com.wom.model.dao.response.TestPackageModel;
import com.wom.model.dao.response.WoProblemModel;
import com.wom.service.TestPackageService;
import com.wom.service.WoProblemService;
import com.wom.service.model.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("testpackage")
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")//跨域请求
public class TestPackageController/* extends BaseController */{

    @Autowired
    private TestPackageService testPackageService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public int addTestPackageModel(TestPackageDto testPackageDto) {
        System.out.println(testPackageDto);
        int i = testPackageService.addTestPackageModel(testPackageDto);
        if (i == 1)
            return 200;
        return 10002;
    }

    @RequestMapping(value = "/delById", method = {RequestMethod.POST})
    @ResponseBody
    public int delTestPackageModelByid(@RequestParam(name = "id") Integer id) {
        int i = testPackageService.delTestPackageModelByid(id);
        if (i == 1)
            return 200;
        return 10002;
    }

    @RequestMapping(value = "/findById", method = {RequestMethod.GET})
    @ResponseBody
    public TestPackageModel selWoProblemModelbyid(@RequestParam(name = "id") Integer id) {
        TestPackageModel testPackageModel = testPackageService.selTestPackageModelByid(id);
        return testPackageModel;
    }

    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    @ResponseBody
    public Object selWoListDtoByPage(HttpServletRequest request, TestPackageDto testPackageDto) {
        PageVo pageVo = new PageVo();
        String page = request.getParameter("page");
        String pageSize = request.getParameter("limit");
        pageVo.setPage(Integer.parseInt(page));
        pageVo.setPageSize(Integer.parseInt(pageSize));
        testPackageDto.setPageVo(pageVo);
        List<TestPackageModel> list = testPackageService.selTestPackageModelByPage(testPackageDto);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(list);
        System.out.println(testPackageService.selTestPackageModelAllNum(testPackageDto));
        map.put("code", 0);
        map.put("data", list);
        map.put("count", testPackageService.selTestPackageModelAllNum(testPackageDto));
        return map;
    }

}