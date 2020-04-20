package com.usy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.usy.mapper.UserMapper;
import com.usy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @PackgeName: com.usy
 * @Author: LiuTianyong
 * Date: 2020/4/20 9:38
 * @Version:
 * @Description:
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;


    // 条件构造器
    @Test
    void contextLoads() {
        // 查询name不为空的用户，并且邮箱不为空，年龄大于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    // selectOne
    @Test
    void test2() {
        // 查询名字为50的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","50");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    // between and
    @Test
    void test3() {
        // 查询年龄在20 - 30之间的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    // 模糊查询
    @Test
    void test4() {
        // like %e% likeRight %e likeLeft e%
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.notLike("name","e")
                .likeRight("email","t");    // t%
        List<Map<String,Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 内查询
    @Test
    void test5() {
        // 拼接sql
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.inSql("id","select id from user where id>10000");

        List<Object> objectList = userMapper.selectObjs(wrapper);
        objectList.forEach(System.out::println);
    }

    // 排序
    @Test
    void test6() {
        // 拼接sql
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // 通过id 进行排序
        wrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }
}
