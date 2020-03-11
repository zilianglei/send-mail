package com.castlzl.sendmail.service.impl;

import com.castlzl.sendmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author: leiziliang
 * @Date: 2020/3/11 17:14
 */
@Service
public class MailServiceImpl implements MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 用来发送邮件模板
     */
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void send(String to, String subject, String text) {

        Context context = new Context();
        context.setVariable("project", "demo");
        context.setVariable("author", "yimcarson");
        context.setVariable("code", text);
        String emailContent = templateEngine.process("index", context);


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();


        MimeMessageHelper mimeMessageHelper = null;

        try {

            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(emailContent, true);

        }catch (MessagingException e){
            e.printStackTrace();

        }

        javaMailSender.send(mimeMessage);
    }
}
