package com.castlzl.sendmail.service;

/**
 * @Author: leiziliang
 * @Date: 2020/3/11 17:14
 */
public interface MailService {

     void send(String to, String subject, String text);
}
