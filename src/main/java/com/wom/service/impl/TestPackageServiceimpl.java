package com.wom.service.impl;

import com.wom.dao.TestPackageDOMapper;
import com.wom.model.dao.request.TestPackageDto;
import com.wom.model.dao.response.TestPackageModel;
import com.wom.service.TestPackageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestPackageServiceimpl implements TestPackageService {
    @Autowired
    private TestPackageDOMapper testPackageDOMapper;

    @Override
    public int addTestPackageModel(TestPackageDto testPackageDto) {
        return testPackageDOMapper.addTestPackageModel(testPackageDto);
    }

    @Override
    public TestPackageModel selTestPackageModelByid(int id) {
        return testPackageDOMapper.selTestPackageModelByid(id);
    }

    @Override
    public int delTestPackageModelByid(@Param("id")Integer id) {
        return testPackageDOMapper.delTestPackageModelByid(id);
    }

    @Override
    public List<TestPackageModel> selTestPackageModelByPage(TestPackageDto testPackageDto) {
        return testPackageDOMapper.selTestPackageModelByPage(testPackageDto);
    }

    @Override
    public int selTestPackageModelAllNum(TestPackageDto testPackageDto) {
        return testPackageDOMapper.selTestPackageModelAllNum(testPackageDto);
    }
}
