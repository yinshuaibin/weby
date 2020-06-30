package com.y.utils.bean.huawei.onetomany.response;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 14:35
 */
public class Pictures {

    /**
     * O
     * 图片信息
     */
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
