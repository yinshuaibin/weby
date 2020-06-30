package com.y.utils.bean.huawei.imageadd.request;

import javax.validation.constraints.NotNull;

/**
 * @author yinshuaibin
 * @date 2020/6/12 11:03
 */
public class Picture {

    /**
     * O
     * 唯一标识
     * 长度[1,128]
     * 用于第三方系统导入人脸图片时，标识图片的唯一主键。
     */
    private String thirdId;

    /**
     * O
     * 通过上传接口上传图片后，得到的由系统分配的图片id
     * 范围：0-9A-Fa-f，长度24
     */
    private String fileId;

    /**
     * O
     * 图片的URL
     * 长度[1,255]
     * 请求下载该url时，响应Header中必须包含Content-Length,不支持以Chunked的形式下载图片。
     */
    private String url;

    /**
     * O
     * 图片的base64编码的二进制图片数据,单张不大于5M。推荐base64值的长度在1M以内，超出推荐值，请求响应时间会增加。
     */
    private String base64;

    /**
     * O
     * 一个图片，二进制文件，需要用post multipart/form-data的方式上传。暂不支持
     */
    private String stream;

    /**
     * 提供一个根据图片base64生成的构造方法, 如使用其他方法, 请用空参构造
     *
     * @param base64
     */
    public Picture(@NotNull String base64) {
        this.base64 = base64;
    }

    public Picture() {
    }

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

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "thirdId='" + thirdId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", url='" + url + '\'' +
                ", base64='" + base64 + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}
