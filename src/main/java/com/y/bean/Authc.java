package com.y.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name ="request")
public class Authc {
    private Integer authcId;
    private String authcName;
}
