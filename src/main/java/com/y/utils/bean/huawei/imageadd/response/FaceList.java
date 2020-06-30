package com.y.utils.bean.huawei.imageadd.response;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/15 9:57
 */
public class FaceList {

    private List<Face> face;

    public List<Face> getFace() {
        return face;
    }

    public void setFace(List<Face> face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "FaceList{" +
                "face=" + face +
                '}';
    }
}
