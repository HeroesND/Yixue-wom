package com.wom.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component  //让类扫描的时候可以扫到该类
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    //实现校验方法并返回校验结果
    public ValidationResult validator(Object bean){
        ValidationResult validatorResult=new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet= validator.validate(bean);
        if (constraintViolationSet.size()>0){
            //有错误
            validatorResult.setHasErrors(true);
            constraintViolationSet.forEach(constraintViolation -> {
                String errMsg=constraintViolation.getMessage();
                String propertyName=constraintViolation.getPropertyPath().toString();
                validatorResult.getErrMsgMap().put(propertyName,errMsg);
            });
        }
        return validatorResult;


    }


    @Override
    public void afterPropertiesSet() throws Exception {
        //将hibernate validator通过工厂的初始化方式使其实例化
        this.validator= Validation.buildDefaultValidatorFactory().getValidator();

    }
}
