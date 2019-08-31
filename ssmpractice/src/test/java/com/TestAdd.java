package com;

import com.domain.User;
import com.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAdd {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindByUsernameAndPassword() {
        User user =new User();
        user.setUsername("test");
        user.setPassword("123");
        User result = userMapper.findByUsernameAndPassword(user);
        System.out.println(result);
    }
}
