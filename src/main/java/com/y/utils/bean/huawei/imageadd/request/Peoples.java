package com.y.utils.bean.huawei.imageadd.request;

import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 17:20
 */
public class Peoples {

    List<People> people;

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
