package com.example.dataSource.test2.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper2 {
    @Select("SELECT * FROM user")
    List<Map<String,Object>> getAll();
}
