package com.y.utils.bean.huawei.imageadd.request;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 17:29
 */
public class Pictures {
    private List<Picture> picture;

    public List<Picture> getPicture() {
        return picture;
    }

    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "picture=" + picture +
                '}';
    }
}
