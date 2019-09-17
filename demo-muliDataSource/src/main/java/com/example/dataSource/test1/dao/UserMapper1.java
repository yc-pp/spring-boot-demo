package com.example.dataSource.test1.dao;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper1 {
    @Select("SELECT * FROM user")
    List<Map<String,Object>> getAll();
}
