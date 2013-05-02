 package com.lanux.dao.common;
 
 import com.lanux.bll.user.UserBLL;
 import org.junit.Assert;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations={"classpath*:applicationContext*.xml"})
 public class BaseDaoTest extends AbstractJUnit4SpringContextTests
 {
 
   @Autowired
   UserBLL userBLL;
 
   @Test
   public void testGetAll()
   {
     Assert.fail("Not yet implemented");
   }
 
   @Test
   public void testGetAllUser() {
     Assert.fail("Not yet implemented");
   }
 }




