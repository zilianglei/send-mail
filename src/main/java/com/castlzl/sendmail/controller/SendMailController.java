package com.castlzl.sendmail.controller;

import com.castlzl.sendmail.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/send")
@Api(tags = "用户发送邮件接口")
public class SendMailController {

    @Autowired
    private MailService mailService;

    @PostMapping(value = "/mail")
    @ApiOperation("发送邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "toMail", value = "收件人地址"),
            @ApiImplicitParam(name = "mailName", value = "邮件名称", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", required = true)
    })
    public int mail(@RequestParam(value = "toMail") String toMail, @RequestParam(value = "mailName") String mailName, @RequestParam(value = "code") String code ){

        System.out.println("toMail:"+toMail);
        System.out.println("mailName:"+mailName);
        System.out.println("code:"+code);
        mailService.send(toMail,mailName,code);
        return 200;
    }
}
