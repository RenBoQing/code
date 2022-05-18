package com.rbq.code.vovo;

import lombok.Data;

import java.time.Period;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 15:44
 * @Description 宠友圈Vo
 */
@Data
public class CircleVo {
    private Integer cid;
    private  String title;
    private String image;
    private String imageone;
    private String imagetwo;
    private Integer viewcount;
    private Integer count;
    private String address;
    private String comment;
    private String nickname;
    private String avatarurl;
}
