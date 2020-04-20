package com.usy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.usy.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @PackgeName: com.mapper
 * @Author: LiuTianyong
 * Date: 2020/4/14 18:15
 * @Version:
 * @Description:
 */
// 代表持久层
@Repository
public interface UserMapper extends BaseMapper<User> {

}
