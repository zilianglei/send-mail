package com.castlzl.sendmail.service;

/**
 * @author leiziliang
 * @version 1.0
 * @date 2020/3/12 20:45
 */
public interface UserService {

     String getPassword(String username);

     int checkUserBanStatus(String username);

     String getRole(String username);

     String getRolePermission(String username);

     String getPermission(String username);

}
