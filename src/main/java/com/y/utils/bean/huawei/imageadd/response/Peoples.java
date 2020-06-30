package com.y.utils.bean.huawei.imageadd.response;


import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/15 9:56
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
