/*    */ package com.lanux.common;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ public class LanuxInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/*    */   public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 38 */     String currentUri = request.getRequestURI();
/* 39 */     boolean isAccessible = true;
/*    */ 
/* 42 */     return isAccessible;
/*    */   }
/*    */ }

/* Location:           E:\apache-tomcat-7.0.37\webapps\Kendral\WEB-INF\classes\
 * Qualified Name:     com.lanux.common.LanuxInterceptor
 * JD-Core Version:    0.5.4
 */