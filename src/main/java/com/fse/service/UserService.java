package com.fse.service;

import com.fse.entity.User;
import com.fse.pojo.UserBean;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService
  //      extends UserDetailsService
{

    public User findByUserName(String userId);

    public void saveOrUpdate(UserBean user);

}
