package com.y.utils.bean.huawei;

/**
 * @author yinshuaibin
 * @date 2020/6/15 9:55
 */
public class Result {
    /**
     * M
     * 返回码，0为成功，非0为失败
     */
    private String code;

    /**
     * M
     * 错误消息
     */
    private String errmsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ResultStatus{" +
                "code='" + code + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
