package com.usy.blog.service.impl;

import com.usy.blog.entity.User;
import com.usy.blog.mapper.UserMapper;
import com.usy.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiuTianyong
 * @since 2020-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
