package com.y.utils.bean.huawei.libedit.request;

/**
 * @author yinshuaibin
 * @date 2020/6/15 14:12
 */
public class StaticLibrary {

    /**
     * M
     * 名称
     * 取值范围：大小写英文字母、数字、汉字、mailto:.@()-_空格，并且空格不能在字段的首尾。
     * 1~32个字符
     */
    private String name;

    /**
     * M
     * 描述
     * 0~128个字符
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StaticLibrary{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
