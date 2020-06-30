package com.y.utils.bean.huawei.onetomany.response;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 14:51
 */
public class FeatureList {

    /**
     * M
     * 特征信息
     */
    private List<Feature> feature;

    public List<Feature> getFeature() {
        return feature;
    }

    public void setFeature(List<Feature> feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "FeatureList{" +
                "feature=" + feature +
                '}';
    }
}
