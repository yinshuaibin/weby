package com.y.utils.bean.huawei.imageadd.response;

/**
 * @author yinshuaibin
 * @date 2020/6/15 10:00
 */
public class Feature {

    /**
     * O
     *人脸特征id
     */
    private String featureId;


    /**
     * O
     * 人脸特征，当isFeature为true时，返回对应的特征。
     */
    private String featureValue;

    /**
     * O
     * 用户数据，当isFeature为true时，支持的算法返回对应的用户数据
     */
    private String userData;

    /**
     * M
     * 图片状态
     * 0：成功
     * 1：特征提取中
     * 4：添加失败
     * 7：非人脸
     */
    private String faceState;

    /**
     * M
     * 人脸算法code
     */
    private String algorithmCode;

    /**
     * O
     * 图片质量分数
     */
    private String quality;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getFaceState() {
        return faceState;
    }

    public void setFaceState(String faceState) {
        this.faceState = faceState;
    }

    public String getAlgorithmCode() {
        return algorithmCode;
    }

    public void setAlgorithmCode(String algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureId='" + featureId + '\'' +
                ", featureValue='" + featureValue + '\'' +
                ", userData='" + userData + '\'' +
                ", faceState='" + faceState + '\'' +
                ", algorithmCode='" + algorithmCode + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
