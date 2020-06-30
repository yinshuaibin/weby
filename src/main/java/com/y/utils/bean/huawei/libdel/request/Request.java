package com.y.utils.bean.huawei.libdel.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yinshuaibin
 * @date 2020/6/15 11:39
 */
@XmlRootElement
public class Request {

    /**
     * M
     * 静态库Id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                '}';
    }
}
