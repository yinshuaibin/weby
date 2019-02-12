package com.y.bean;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userId;
    private String userName;
    private String passWord;
    private String userDesc;
    private List<Role> roles;
}
