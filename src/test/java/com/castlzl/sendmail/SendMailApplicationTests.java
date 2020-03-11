package com.castlzl.sendmail;

import com.castlzl.sendmail.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
@SpringBootTest(classes = {SendMailApplication.class})
class SendMailApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    void contextLoads() {
        String to = "1401681342@qq.com";

        mailService.send(to,"模板邮件", UUID.randomUUID().toString().toUpperCase());

    }

}
