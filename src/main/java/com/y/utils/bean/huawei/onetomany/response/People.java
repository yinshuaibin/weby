package com.y.utils.bean.huawei.onetomany.response;

/**
 * @author yinshuaibin
 * @date 2020/6/12 14:27
 */
public class People {

    /**
     * O
     * 出生日期
     */
    private String bornTime;

    /**
     * M
     * 创建时间
     */
    private String creatTime;

    /**
     * O
     * 人员id
     * 范围：0-9A-Fa-f，长度24
     */
    private String id;

    /**
     * O
     * 国籍
     * 中文、英文、数字和.空格，长度[1,255]
     */
    private String country;

    /**
     * O
     * 证件号码
     * 英文、数字、()，长度[1,255]
     */
    private String credentialNumber;

    /**
     * O
     * 证件类型，枚举类型
     * 0：身份证
     * 1：护照
     * 2：学生证
     * 3：军官证
     * 4：驾照
     * 5：其他
     */
    private String credentialType;

    /**
     * O
     * 描述信息，长度[1,255]
     */
    private String description;

    /**
     * O
     *性别
     * 0：男
     * 1：女
     * -1:未知
     */
    private String gender;

    /**
     * O
     * 姓名
     * 中文、英文、数字和.·-空格，首位不为特殊字符，长度[1,255]
     */
    private String name;

    /**
     * O
     * 民族
     * 中文、英文、数字和空格，长度[1,255]
     */
    private String nationality;

    /**
     * O
     * 职业
     * 中文、英文、数字和-空格，长度[1,255]
     */
    private String occupation;

    /**
     * O
     * 用户标签tag
     */
    private String tag;

    /**
     * O
     * 户籍所在地
     * 长度[1,255]
     */
    private String domicile;

    /**
     * O
     * 当前居住地
     * 长度[1,255]
     * 在打标签业务中是填写areacode
     */
    private String presentPlace;

    /**
     * M
     * 库id
     */
    private String libraryId;

    /**
     * O
     * 人员的图片，最多五张图片
     */
    private Pictures pictures;

    public String getBornTime() {
        return bornTime;
    }

    public void setBornTime(String bornTime) {
        this.bornTime = bornTime;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCredentialNumber() {
        return credentialNumber;
    }

    public void setCredentialNumber(String credentialNumber) {
        this.credentialNumber = credentialNumber;
    }

    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getPresentPlace() {
        return presentPlace;
    }

    public void setPresentPlace(String presentPlace) {
        this.presentPlace = presentPlace;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "People{" +
                "bornTime='" + bornTime + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", credentialNumber='" + credentialNumber + '\'' +
                ", credentialType='" + credentialType + '\'' +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", occupation='" + occupation + '\'' +
                ", tag='" + tag + '\'' +
                ", domicile='" + domicile + '\'' +
                ", presentPlace='" + presentPlace + '\'' +
                ", libraryId='" + libraryId + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}
