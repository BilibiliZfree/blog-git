package com.may.service.impl;


import com.may.dao.UserRepository;
import com.may.model.UserInfo;
import com.may.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 紫枫伊
 * @param : createTime 2021-6-24 14:45
 * @param : updateTime 2021-6-24 14:45
 * @param : description 用户服务接口实现
 */
@Service
public class UserServiceImpl implements UserService {

    //注入JPA以操作数据库
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo User_ChkLogin(String account, String password) {
        UserInfo user = userRepository.findUserInfoByAccountAndPassword(account,password);
        return user;
    }

    @Override
    public void User_saveNewUser(UserInfo newUser) {
        userRepository.save(newUser);
    }
}
