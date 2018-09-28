package com.zxp.security.dao;

import com.zxp.security.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 作者 zxp
 * 创建时间 2018/9/28/028
 * 交流群 897841829
 */
@Mapper
public interface UserDao {


    User findByUsername(String username);

}
