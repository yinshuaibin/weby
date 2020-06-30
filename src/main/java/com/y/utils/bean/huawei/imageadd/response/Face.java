package com.y.utils.bean.huawei.imageadd.response;

/**
 * @author yinshuaibin
 * @date 2020/6/15 9:57
 */
public class Face {

    /**
     * O
     * 唯一标识,长度[1,128]
     */
    private String thirdId;

    /**
     * M
     * 图片id
     */
    private String fileId;

    /**
     * M
     * 图片下载url，通过https协议访问，要支持tls1.1和1.2的加密协议；如果通过token鉴权访问，url有效期为20-30分钟
     */
    private String url;

    /**
     * M
     * 特征值list
     */
    private FeatureList featureList;

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FeatureList getFeatureList() {
        return featureList;
    }

    public void setFeatureList(FeatureList featureList) {
        this.featureList = featureList;
    }

    @Override
    public String toString() {
        return "Face{" +
                "thirdId='" + thirdId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", url='" + url + '\'' +
                ", featureList=" + featureList +
                '}';
    }
}
