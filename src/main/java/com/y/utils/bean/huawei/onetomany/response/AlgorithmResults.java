package com.y.utils.bean.huawei.onetomany.response;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 15:03
 */
public class AlgorithmResults {

    /**
     * 算法响应结果
     */
    private List<AlgorithmResult> algorithmResult;

    public List<AlgorithmResult> getAlgorithmResult() {
        return algorithmResult;
    }

    public void setAlgorithmResult(List<AlgorithmResult> algorithmResult) {
        this.algorithmResult = algorithmResult;
    }

    @Override
    public String toString() {
        return "AlgorithmResults{" +
                "algorithmResult=" + algorithmResult +
                '}';
    }
}
