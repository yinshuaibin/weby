package com.y.utils.bean.huawei.onetomany.response;

import com.y.utils.bean.huawei.Result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/12 11:48
 */
@XmlRootElement
public class Response {

    /**
     * M
     * 相似度阈值，范围1~100，图片检索时必须指定
     */
    private Result result;

    /**
     * O
     * 相似度阈值，范围1~100，图片检索时必须指定
     */
    private String total;

    /**
     * O
     * 相似度阈值，范围1~100，图片检索时必须指定
     */
    private Peoples peoples;

    /**
     * M
     * 相似度阈值，范围1~100，图片检索时必须指定
     */
    private AlgorithmResults algorithmResults;


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Peoples getPeoples() {
        return peoples;
    }

    public void setPeoples(Peoples peoples) {
        this.peoples = peoples;
    }

    public AlgorithmResults getAlgorithmResults() {
        return algorithmResults;
    }

    public void setAlgorithmResults(AlgorithmResults algorithmResults) {
        this.algorithmResults = algorithmResults;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", total='" + total + '\'' +
                ", peoples=" + peoples +
                ", algorithmResults=" + algorithmResults +
                '}';
    }
}
