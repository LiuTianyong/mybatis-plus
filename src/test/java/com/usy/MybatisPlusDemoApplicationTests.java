package com.usy;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.usy.mapper.UserMapper;
import com.usy.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 条件构造器 demo
     */


    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setName("50");
        user.setAge(50);
        user.setEmail("1063331689@qq.com");

        userMapper.insert(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(5L);
        user.setName("balabala");
        user.setAge(7);
        user.setEmail("1063331689@qq.com");

        userMapper.updateById(user);
    }

    // 测试乐观锁成功
    @Test
    void testOptimisticLocker(){
        // 1.查询用户信息
        User user = userMapper.selectById(1L);
        // 2.修改用户信息
        user.setAge(99);
        // 3.执行操作
        userMapper.updateById(user);
    }

    // 测试乐观锁失败
    @Test
    void testOptimisticLocker2(){

        // 线程1

        // 1.查询用户信息
        User user = userMapper.selectById(1L);
        // 2.修改用户信息
        user.setAge(99);

        // 模拟另外一个线程进行插队操作
        User user2 = userMapper.selectById(1L);
        user2.setAge(55);
        userMapper.updateById(user2);

        // 3.执行操作
        // 可以采用自旋锁进行操作
        userMapper.updateById(user);        //如果没有乐观锁就会覆盖值插队的值
    }

    // id查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 批量id查询
    @Test
    public void testSelectByBatchIds(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1L,2L,3L));
        userList.forEach(System.out::println);
    }

    // 条件查询之一 使用 map 操作
    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        // 自定义要查询的条件
        map.put("name","Jack");
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(System.out::println);
    }

    // 分页查询
    @Test
    public void testSelectPage(){
        // 参数1 当前页
        // 参数2 页面大小
        Page<User> userPage = new Page<>(1,5);
        Page<User> userList = userMapper.selectPage(userPage,null);
        userPage.getRecords().forEach(System.out::println);
    }

    // 根据id删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(3L);
    }

    // 批量id删除
    @Test
    public void testDeleteByIds(){
        userMapper.deleteBatchIds(Arrays.asList(1L,2L));
    }

    // 通过 map 删除
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","balabala");
        userMapper.deleteByMap(map);
    }
}
