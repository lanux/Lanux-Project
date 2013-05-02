 package com.lanux.common;
 
 public class LanuxException extends Throwable
 {
   private static final long serialVersionUID = 2716803603661874697L;
 
   public LanuxException()
   {
   }
 
   public LanuxException(String message)
   {
     super(message);
   }
 
   public LanuxException(String message, Throwable cause) {
     super(message, cause);
   }
 }
