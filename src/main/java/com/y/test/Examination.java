package com.y.test;

import lombok.Data;

import java.util.Date;

@Data
public class Examination {
    private String id;
    private String name;
    private Date startCheckTime;
    private Date endCheckTime;
    private boolean isValid;
}
