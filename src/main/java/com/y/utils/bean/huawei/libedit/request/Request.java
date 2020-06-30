package com.y.utils.bean.huawei.libedit.request;

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

    private StaticLibrary staticLibrary;

    public StaticLibrary getStaticLibrary() {
        return staticLibrary;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", staticLibrary=" + staticLibrary +
                '}';
    }

    public void setStaticLibrary(StaticLibrary staticLibrary) {
        this.staticLibrary = staticLibrary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
