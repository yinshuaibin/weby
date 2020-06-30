package com.y.utils.bean.huawei.onetomany.response;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 14:27
 */
public class Peoples {

    /**
     * M
     * 人员
     */
    private List<People> people;

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Peoples{" +
                "people=" + people +
                '}';
    }
}
