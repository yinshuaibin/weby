package com.y.utils.bean.huawei.imageadd.response.sync;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/15 10:51
 */
public class FaceStates {

    /**
     * M
     * 人员特征提取状态
     */
    List<FaceState> faceState;

    public List<FaceState> getFaceState() {
        return faceState;
    }

    public void setFaceState(List<FaceState> faceState) {
        this.faceState = faceState;
    }

    @Override
    public String toString() {
        return "FaceStates{" +
                "faceState=" + faceState +
                '}';
    }
}
