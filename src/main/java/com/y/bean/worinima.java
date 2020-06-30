package com.y.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author yinshuaibin
 * @date 2020/6/12 15:46
 */
@XmlRootElement
@Data
public class worinima {
    private List<Authc> authc;
}
