package com.may.dao;

import com.may.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

/**
 * @author 紫枫伊
 * @param : createTime 2021-6-24 14:55
 * @param : updateTime 2021-6-24 14:55
 * @param : description UserInfo表数据操作
 */
public interface UserRepository extends JpaRepository<UserInfo,Integer> {

    //通过账号密码查找用户
    UserInfo findUserInfoByAccountAndPassword(String account, String password);

}
