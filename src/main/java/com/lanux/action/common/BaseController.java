package com.lanux.action.common;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 可以使用@ControllerAdvice标签
 * @author Lanux
 *
 */
public class BaseController {
	protected Logger logger = Logger.getLogger(super.getClass());

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
			final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			public void setAsText(String text) throws IllegalArgumentException {
				try {
					Date date = this.sf.parse(text);
					setValue(date);
				} catch (ParseException e) {
					throw new IllegalArgumentException(e);
				}
			}
		});
	}

	@ExceptionHandler({ Exception.class })
	public ModelAndView handleException(Exception ex, WebRequest request) {
		return new ModelAndView("exception").addObject("ex", ex);
	}
}
