package com.y.utils.bean.huawei.imageadd.response.sync;

import com.y.utils.bean.huawei.Result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 10:50
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
     * 人员id
     */
    private Ids ids;

    /**
     * 人员特征提取状态列表
     */
    private FaceStates faceStates;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Ids getIds() {
        return ids;
    }

    public void setIds(Ids ids) {
        this.ids = ids;
    }

    public FaceStates getFaceStates() {
        return faceStates;
    }

    public void setFaceStates(FaceStates faceStates) {
        this.faceStates = faceStates;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", ids=" + ids +
                ", faceStates=" + faceStates +
                '}';
    }
}
