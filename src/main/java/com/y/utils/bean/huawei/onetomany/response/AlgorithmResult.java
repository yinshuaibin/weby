package com.y.utils.bean.huawei.onetomany.response;

import com.y.utils.bean.huawei.Result;

/**
 * @author yinshuaibin
 * @date 2020/6/12 15:03
 */
public class AlgorithmResult {

    /**
     * 响应结果体
     */
    private Result result;

    /**
     * O
     * 总数量
     */
    private String total;

    /**
     * M
     * 人脸算法编码
     */
    private String alrogithmCode;

    /**
     * O
     * 原图质量分数
     */
    private String srcQuality;

    /**
     * O
     * 人员列表
     */
    private Peoples peoples;


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

    public String getAlrogithmCode() {
        return alrogithmCode;
    }

    public void setAlrogithmCode(String alrogithmCode) {
        this.alrogithmCode = alrogithmCode;
    }

    public String getSrcQuality() {
        return srcQuality;
    }

    public void setSrcQuality(String srcQuality) {
        this.srcQuality = srcQuality;
    }

    public Peoples getPeoples() {
        return peoples;
    }

    public void setPeoples(Peoples peoples) {
        this.peoples = peoples;
    }

    @Override
    public String toString() {
        return "AlgorithmResult{" +
                "result=" + result +
                ", total='" + total + '\'' +
                ", alrogithmCode='" + alrogithmCode + '\'' +
                ", srcQuality='" + srcQuality + '\'' +
                ", peoples=" + peoples +
                '}';
    }
}
