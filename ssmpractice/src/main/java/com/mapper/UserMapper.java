package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
@Select("SELECT * FROM USER WHERE username=#{username} AND PASSWORD=#{password}")
@Results({
        @Result(property = "id" ,column = "id"),
        @Result(property = "username" ,column = "username"),
        @Result(property = "password" ,column = "password"),
//        column指的是查询出来的userId传给要查询的方法
        @Result(property = "resultList" ,column = "id",
              javaType = List.class,
              many = @Many(select = "com.mapper.ResultMapper.findByUserId")
        )
})
    public User findByUsernameAndPassword(User user);
}
