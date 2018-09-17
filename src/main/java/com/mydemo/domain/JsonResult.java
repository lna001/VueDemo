package com.mydemo.domain;

/****
 * 通用json返回类
 */
public class JsonResult {
    private String  status=null; //返回状态码
    private Object  result=null;
    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
