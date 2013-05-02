package com.lanux.bll.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.lanux.common.JunitServiceTestBase;
import com.lanux.pojo.user.User;

public class UserBLLTest extends JunitServiceTestBase {

	@Autowired
	UserBLL userBLL;

	@Test
	public void testAdd1() {
		User user = this.userBLL.get("lanux2");
		Assert.isNull(user);
		System.out.println(user.getName());
	}

	@Test
	public void testAdd() throws Exception {
	}
}
