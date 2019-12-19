package com.wom.service;

import com.wom.dao.TestPackageDOMapper;
import com.wom.model.dao.request.TestPackageDto;
import com.wom.model.dao.response.TestPackageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestPackageService {

    /**
     * 添加测试
     * @param testPackageDto
     * @return
     */
    int addTestPackageModel(TestPackageDto testPackageDto);

    /**
     * 根据id查看详情
     * @param id
     * @return
     */
    TestPackageModel selTestPackageModelByid(int id);

    /**
     * 删除
     * @return
     */
    int delTestPackageModelByid(@Param("id")Integer id);

    /**
     * 多条件分页查询
     * @param testPackageDto
     * @return
     */
    List<TestPackageModel> selTestPackageModelByPage(TestPackageDto testPackageDto);

    /**
     * 多条件分页查询总条数
     * @param testPackageDto
     * @return
     */
    int selTestPackageModelAllNum(TestPackageDto testPackageDto);
}
