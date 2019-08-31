package com.mapper;

import com.domain.Result;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResultMapper {
    @Select("select * from result where userId=#{userId}")
    List<Result>  findByUserId(int  id);
//添加方法
    @Insert("insert into result values(#{id},#{userId},#{prize})")
    void add(Result result);

   @Select("select * from result where userId=#{userId}")
    List<Result> find(int userId);
}
