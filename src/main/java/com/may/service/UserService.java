package com.may.service;

import com.may.model.UserInfo;

/**
 * @author 紫枫伊
 * @param : createTime 2021-6-24 14:39
 * @param : updateTime 2021-6-24 14:39
 * @param : description 用户服务接口
 */

public interface UserService {

    //用户登录查询
    UserInfo User_ChkLogin(String account,String password);

    //保存新用户
    void User_saveNewUser(UserInfo newUser);
}
