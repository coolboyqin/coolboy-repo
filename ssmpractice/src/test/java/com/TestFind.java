package com;

import com.domain.Result;
import com.domain.User;
import com.mapper.ResultMapper;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestFind {

    @Autowired
    private ResultMapper resultMapper;
    @Test
    public void testFindByUsernameAndPassword() {
        Result result=new Result();
        result.setUserId(2);
        result.setPrize("100");
       resultMapper.add(result);
    }
}
