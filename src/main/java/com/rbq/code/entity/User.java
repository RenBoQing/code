package com.rbq.code.entity;

import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年03月30日 19:20
 * @Description
 */
@Data
public class User {
    private Integer id;
    private String nickname;
    private String password;
    private String sex;
    private String session_key;
    private String openid;
    private String avatarurl;
    private String telnumber;
    private String email;
    private Integer status;
}
