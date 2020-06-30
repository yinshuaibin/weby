package com.y.utils.bean.huawei.libdel.response;

import com.y.utils.bean.huawei.Result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 11:39
 */
@XmlRootElement
public class Response {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                '}';
    }
}
