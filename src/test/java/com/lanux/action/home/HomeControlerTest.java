package com.lanux.action.home;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.lanux.common.JunitControllerTestBase;

public class HomeControlerTest extends JunitControllerTestBase {
	@Test
	public void test() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/home/index");
		request.setMethod("get");
		ModelAndView mav = new ModelAndView();
		try {
			mav = excuteAction(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mav.getViewName());
	}
}
