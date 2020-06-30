package com.y.utils.bean.huawei.imageadd.response;

import com.y.utils.bean.huawei.Result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/12 17:33
 */
@XmlRootElement
public class Response {

    /**
     * M
     * 响应结果体
     */
    private Result result;

    /**
     * M
     * 人员名单状态列表，最大支持10个
     */
    private Peoples peoples;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Peoples getPeoples() {
        return peoples;
    }

    public void setPeoples(Peoples peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", peoples=" + peoples +
                '}';
    }
}
