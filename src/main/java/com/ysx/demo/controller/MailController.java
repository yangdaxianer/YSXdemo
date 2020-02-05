package com.ysx.demo.controller;

import com.ysx.demo.bean.vo.MailVo;
import com.ysx.demo.service.MailService;
import com.ysx.demo.utils.ResponseUtil;
import com.ysx.demo.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@CrossOrigin
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping(value = "/comment")
    @ResponseBody
    public ResponseUtil comment(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam String author, @RequestParam String mail, @RequestParam String text) {

        String myMail = "sj15537179243@163.com";
        if (!StringUtils.isEmpty(author) && author.length() > 50) {
            return ResponseUtil.error("姓名过长");
        }

        if (!StringUtils.isEmpty(mail) && !ValidatorUtil.isEmail(mail)) {
            return ResponseUtil.error( "请输入正确的邮箱格式");
        }

        if (text.length() > 200) {
            return ResponseUtil.error( "请输入200个字符以内的评论");
        }

        //发送邮件
        MailVo mailVo = new MailVo();
        mailVo.setFrom(myMail);
        mailVo.setTo(mail);
        mailVo.setSubject("收到您朋友【"+author+"】的信件,Ta的邮箱:"+myMail);
        mailVo.setText(text);
        mailService.sendMail(mailVo);
        return ResponseUtil.ok("发送成功");
    }
}
