package com.lanux.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath*:applicationContext*.xml"})
public class JunitServiceTestBase extends AbstractJUnit4SpringContextTests
{
}
