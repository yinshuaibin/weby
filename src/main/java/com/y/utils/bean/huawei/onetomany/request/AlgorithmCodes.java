package com.y.utils.bean.huawei.onetomany.request;

/**
 * @author yinshuaibin
 * @date 2020/6/12 11:01
 */
public class AlgorithmCodes {

    /**
     * O
     *  人脸算法，不指定算法检索时默认返回所有算法结果。
     */
    private String algorithmCode;

    public String getAlgorithmCode() {
        return algorithmCode;
    }

    public void setAlgorithmCode(String algorithmCode) {
        this.algorithmCode = algorithmCode;
    }

    public AlgorithmCodes(){

    }
    public AlgorithmCodes(String algorithmCode){
        this.algorithmCode = algorithmCode;
    }

    @Override
    public String toString() {
        return "AlgorithmCodes{" +
                "algorithmCode='" + algorithmCode + '\'' +
                '}';
    }
}
