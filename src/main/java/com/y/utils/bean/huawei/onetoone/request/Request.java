package com.y.utils.bean.huawei.onetoone.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 11:39
 */
@XmlRootElement
public class Request {

    /**
     * O
     * 人脸算法，多算法时必须指定
     */
    private String algorithmCode;

    /**
     * M
     * 人脸图片1
     */
    private Image image1;

    /**
     * M
     * 人脸图片1
     */
    private Image image2;


    public String getAlgorithmCode() {
        return algorithmCode;
    }

    public void setAlgorithmCode(String algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    @Override
    public String toString() {
        return "Request{" +
                "algorithmCode='" + algorithmCode + '\'' +
                ", image1=" + image1 +
                ", image2=" + image2 +
                '}';
    }
}
