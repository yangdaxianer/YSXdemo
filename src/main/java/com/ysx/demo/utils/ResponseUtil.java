package com.ysx.demo.utils;

public class ResponseUtil {

    private static final int OK = 0;
    private static final int ERROR = -1;
    private static final String MSG = "请求成功";
    private static final String ERROR_MSG = "请求失败";

    private int code;
    private String msg;
    private Object data;

    public ResponseUtil() {
    }

    public ResponseUtil(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseUtil ok() {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(OK);
        responseUtil.setMsg(MSG);
        responseUtil.setData(null);
        return responseUtil;
    }

    public static ResponseUtil ok(String msg) {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(OK);
        responseUtil.setMsg(msg);
        responseUtil.setData(null);
        return responseUtil;
    }

    public static ResponseUtil ok(String msg,Object data) {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(OK);
        responseUtil.setMsg(msg);
        responseUtil.setData(data);
        return responseUtil;
    }

    public static ResponseUtil error() {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(ERROR);
        responseUtil.setMsg(ERROR_MSG);
        responseUtil.setData(null);
        return responseUtil;
    }

    public static ResponseUtil error(String msg) {
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setCode(ERROR);
        responseUtil.setMsg(msg);
        responseUtil.setData(null);
        return responseUtil;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
