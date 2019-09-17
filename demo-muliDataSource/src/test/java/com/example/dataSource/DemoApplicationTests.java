package com.example.dataSource;

import com.example.dataSource.test1.dao.UserMapper1;
import com.example.dataSource.test2.dao.UserMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test1(){
        List<Map<String,Object>> list = userMapper1.getAll();
        System.out.println("test1 = "+list);
    }
    @Test
    public void test2(){
        List<Map<String,Object>> list = userMapper2.getAll();
        System.out.println("test2 = "+list);
    }
}
