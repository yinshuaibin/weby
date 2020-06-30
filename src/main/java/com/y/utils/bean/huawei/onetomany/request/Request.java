package com.y.utils.bean.huawei.onetomany.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/12 10:46
 */
@XmlRootElement
public class Request {

    /**
     * M
     * 库id，多个以逗号分隔，最多支持64个
     */
    private String libraryIds;

    /**
     * O
     *
     * 姓名
     *
     * 中文、英文、数字和.·-空格，首位不为特殊字符，长度[1,255]
     */
    private String name;

    /**
     * O
     * 上传时间戳
     */
    private String beginTime;

    /**
     * O
     * 上传时间戳
     */
    private String endTime;

    /**
     * O
     * 查询出生日期范围的开始时间
     *
     * 例如2015-09-25
     */
    private String bornStartTime;

    /**
     * O
     * 查询出生日期范围的结束时间
     *
     * 例如2015-09-25
     */
    private String bornEndTime;

    /**
     * O
     * 证件号
     *
     * 英文、数字、()，长度[1,255]
     */
    private String credentialNumber;

    /**
     * O
     * 证件类型，枚举类型
     *
     * 0：身份证
     *
     * 1：护照
     *
     * 2：学生证
     *
     * 3：军官证
     *
     * 4：驾照
     *
     * 5：其他
     */
    private String credentialType;

    /**
     * O
     * 性别
     *
     * 0：男
     *
     * 1：女
     *
     * -1:未知
     */
    private String gender;

    /**
     * O
     * 人员名单id
     *
     * 范围：0-9A-Fa-f，长度24人员唯一标识，如果不存在则由系统自动生成。
     */
    private String id;

    /**
     * O
     * 相似度阈值，范围1~100，图片检索时必须指定
     */
    private String similarityThreshold;

    /**
     * O
     * 是否返回特征值
     *
     * true:返回特征值
     *
     * false：不返回特征值（默认）
     */
    private String isFeature;

    /**
     * M
     * 分页信息
     */
    private Page page;

    /**
     * 户籍所在地
     *
     * 长度 [1,255
     */
    private String domicile;

    /**
     * O
     * 当前居住地
     *
     * 长度 [1,255]
     *
     * 在打标签业务中是填写areacode
     */
    private String presentPlace;

    /**
     * O
     * 用户标签
     */
    private String tag;

    /**
     * O
     * 图片检索时决定是否过滤红名单，该字段只针对有红名单权限的用户有效，无红名单权限的用户默认过滤红名单。
     *
     * 取值：true或false，默认为false
     */
    private String filterOptions;

    /**
     * 人脸算法(不指定算法检索时默认返回所有算法结果)
     */
    private AlgorithmCodes algorithmCodes;

    /**
     * O
     * 质量分数范围，结构化查询根据质量分数范围查询要求指定单算法，多算法查询不支持。
     *
     * 取值范围:0~100
     */
    private String qualityLow;

    /**
     * 质量分数范围，结构化检索范围有效，图片检索该字段无效。
     *
     * 取值范围:0~100
     */
    private String qualityHigh;

    /**
     * M
     * 图片，以下四种必须选择一种上传方式，优先模式：
     *
     * fileId第一优先级
     *
     * base64第二优先级，
     *
     * stream第三优先级，
     *
     * url 第四优先级。
     */
    private Picture picture;

    public String getLibraryIds() {
        return libraryIds;
    }

    public String getName() {
        return name;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getBornStartTime() {
        return bornStartTime;
    }

    public String getBornEndTime() {
        return bornEndTime;
    }

    public String getCredentialNumber() {
        return credentialNumber;
    }

    public String getCredentialType() {
        return credentialType;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getSimilarityThreshold() {
        return similarityThreshold;
    }

    public String getIsFeature() {
        return isFeature;
    }

    public Page getPage() {
        return page;
    }

    public String getDomicile() {
        return domicile;
    }

    public String getPresentPlace() {
        return presentPlace;
    }

    public String getTag() {
        return tag;
    }

    public String getFilterOptions() {
        return filterOptions;
    }

    public AlgorithmCodes getAlgorithmCodes() {
        return algorithmCodes;
    }

    public String getQualityLow() {
        return qualityLow;
    }

    public String getQualityHigh() {
        return qualityHigh;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setLibraryIds(String libraryIds) {
        this.libraryIds = libraryIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setBornStartTime(String bornStartTime) {
        this.bornStartTime = bornStartTime;
    }

    public void setBornEndTime(String bornEndTime) {
        this.bornEndTime = bornEndTime;
    }

    public void setCredentialNumber(String credentialNumber) {
        this.credentialNumber = credentialNumber;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSimilarityThreshold(String similarityThreshold) {
        this.similarityThreshold = similarityThreshold;
    }

    public void setIsFeature(String isFeature) {
        this.isFeature = isFeature;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public void setPresentPlace(String presentPlace) {
        this.presentPlace = presentPlace;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setFilterOptions(String filterOptions) {
        this.filterOptions = filterOptions;
    }

    public void setAlgorithmCodes(AlgorithmCodes algorithmCodes) {
        this.algorithmCodes = algorithmCodes;
    }

    public void setQualityLow(String qualityLow) {
        this.qualityLow = qualityLow;
    }

    public void setQualityHigh(String qualityHigh) {
        this.qualityHigh = qualityHigh;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Request{" +
                "libraryIds='" + libraryIds + '\'' +
                ", name='" + name + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", bornStartTime='" + bornStartTime + '\'' +
                ", bornEndTime='" + bornEndTime + '\'' +
                ", credentialNumber='" + credentialNumber + '\'' +
                ", credentialType='" + credentialType + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", similarityThreshold='" + similarityThreshold + '\'' +
                ", isFeature='" + isFeature + '\'' +
                ", page=" + page +
                ", domicile='" + domicile + '\'' +
                ", presentPlace='" + presentPlace + '\'' +
                ", tag='" + tag + '\'' +
                ", filterOptions='" + filterOptions + '\'' +
                ", algorithmCodes=" + algorithmCodes +
                ", qualityLow='" + qualityLow + '\'' +
                ", qualityHigh='" + qualityHigh + '\'' +
                ", picture=" + picture +
                '}';
    }
}
