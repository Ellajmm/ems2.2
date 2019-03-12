package com.sias.service;

import com.sias.entity.User;

public interface UserService {
  public User queryUser(String name,String password);
  
  public User queryByNa(String name);
  
  public void insertUser(User user);
 

 
}
