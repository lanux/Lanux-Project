package com.lanux.pojo.user;                                                     
                                                                                 
import java.io.Serializable;                                                     
import javax.persistence.Entity;                                                 
import javax.persistence.GeneratedValue;                                         
import javax.persistence.Id;                                                     
import javax.persistence.Table;                                                  
import org.apache.commons.lang3.builder.ToStringBuilder;                         
import org.hibernate.annotations.GenericGenerator;                               
                                                                                 
@Entity                                                                          
@Table(name="t_user")                                                            
public class User                                                                
  implements Serializable                                                        
{                                                                                
  private static final long serialVersionUID = -3944630127188673485L;            
  private String userId;                                                         
  private String password;                                                       
  private String name;                                                           
  private int role;                                                              
                                                                                 
  @Id                                                                            
  @GeneratedValue(generator="paymentableGenerator")                              
  @GenericGenerator(name="paymentableGenerator", strategy="assigned")            
  public String getUserId()                                                      
  {                                                                              
    return this.userId;                                                          
  }                                                                              
                                                                                 
  public void setUserId(String userId) {                                         
    this.userId = userId;                                                        
  }                                                                              
                                                                                 
  public String getPassword() {                                                  
    return this.password;                                                        
  }                                                                              
                                                                                 
  public void setPassword(String password) {                                     
    this.password = password;                                                    
  }                                                                              
                                                                                 
  public String getName() {                                                      
    return this.name;                                                            
  }                                                                              
                                                                                 
  public void setName(String name) {                                             
    this.name = name;                                                            
  }                                                                              
                                                                                 
  public int getRole() {                                                         
    return this.role;                                                            
  }                                                                              
                                                                                 
  public void setRole(int role) {                                                
    this.role = role;                                                            
  }                                                                              
                                                                                 
  public String toString()                                                       
  {                                                                              
    return ToStringBuilder.reflectionToString(this);                             
  }                                                                              
}                                                                                




