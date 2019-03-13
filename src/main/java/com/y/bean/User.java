package com.y.bean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private String userId;
    private String username;
    private String password;
    private String userDesc;
    private List<Role> roles;
}
