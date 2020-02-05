package com.ysx.demo.service;

import com.ysx.demo.bean.vo.MailVo;

public interface MailService {

    MailVo sendMail(MailVo mailVo);
    //获取邮件发信人
    String getMailSendFrom();


}
