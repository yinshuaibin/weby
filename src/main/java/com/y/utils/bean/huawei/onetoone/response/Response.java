package com.y.utils.bean.huawei.onetoone.response;

import com.y.utils.bean.huawei.Result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 11:39
 */
@XmlRootElement
public class Response {

    /**
     * M
     * 响应体
     */
    private Result result;

    /**
     * M
     * 图片对比相似度(根据示例, 可以获得结果范围为  0-->100)
     */
    private String similarity;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", similarity='" + similarity + '\'' +
                '}';
    }
}
