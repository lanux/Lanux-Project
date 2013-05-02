package com.lanux.bll.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanux.dao.user.IUserDao;
import com.lanux.pojo.user.User;

@Service("userBLL")
public class UserBLL {

	@Autowired
	public IUserDao userDao;

	public List<User> getAll() {
		List<User> list = this.userDao.getAll();
		return list;
	}

	public User get(String id) {
		return (User) this.userDao.get(id);
	}
}