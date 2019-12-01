package com.ysx.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yangboss
 * \* Date: 2019/11/27
 * \* Time: 21:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ShiroPwdUtil {

      public  static String encryptionPwd(String password,String salt){
          //对随机salt散列
          ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
          /*
           * MD5加密：
           * 使用SimpleHash类对原始密码进行加密。
           * 第一个参数代表使用MD5方式加密
           * 第二个参数为原始密码
           * 第三个参数为盐值，即用户名
           * 第四个参数为加密次数
           * 最后用toHex()方法将加密后的密码转成String
           * */
          String newPs = new SimpleHash("MD5", password,credentialsSalt,2).toHex();
          return newPs;
      }

}