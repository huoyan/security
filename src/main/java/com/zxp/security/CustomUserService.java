package com.zxp.security;

import com.zxp.security.dao.UserDao;
import com.zxp.security.entity.Role;
import com.zxp.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 zxp
 * 创建时间 2018/9/28/028
 * 交流群 897841829
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserDao userRepository;
    /**
     * 新增用户时候使用这个编码密码
     */
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName("user");
        role.setId(1);
        roles.add(role);
        user.setRoles(roles);
        BCryptPasswordEncoder cryptPasswordEncoder =  new BCryptPasswordEncoder(9);
        String jj = cryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(jj);
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}