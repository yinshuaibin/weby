package com.y.utils.bean.huawei.imageadd.response;

/**
 * @author yinshuaibin
 * @date 2020/6/15 9:56
 */
public class People {

    /**
     * M
     * 人员名单id
     */
    private String peopleId;

    /**
     * M
     * 人脸列表
     */
    private FaceList faceList;

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public FaceList getFaceList() {
        return faceList;
    }

    public void setFaceList(FaceList faceList) {
        this.faceList = faceList;
    }

    @Override
    public String toString() {
        return "People{" +
                "peopleId='" + peopleId + '\'' +
                ", faceList=" + faceList +
                '}';
    }
}
