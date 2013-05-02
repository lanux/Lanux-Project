package com.lanux.dao.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.lanux.dao.common.AbstractHibernateBaseDao;
import com.lanux.pojo.user.User;

@Repository("userDao")
@Scope("singleton")
public class UserDao extends AbstractHibernateBaseDao<User, String> implements IUserDao {
}
