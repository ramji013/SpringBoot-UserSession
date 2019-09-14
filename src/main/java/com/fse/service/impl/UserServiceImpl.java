package com.fse.service.impl;

import com.fse.entity.Role;
import com.fse.entity.User;
import com.fse.pojo.UserBean;
import com.fse.repository.UserRepository;
import com.fse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
*/
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void saveOrUpdate(UserBean userBean) {
        User user = new User();
        user.setName(userBean.getName());
        user.setPassword(userBean.getPassword());
        user.setUserName(userBean.getUserName());
        user.setRoles(new Role("USER"));
         userRepository.save(user);

    }

    /*@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection <? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        *//*return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());*//*
        //return Collections.list(Arrays.asList(new SimpleGrantedAuthority(role.getName())));
        return Arrays.asList(new SimpleGrantedAuthority(role.getName()));
        //return ;

    }
*/
}
