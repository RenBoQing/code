package com.rbq.code.vovo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年05月01日 22:14
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpVo {
    private Integer hid;//文章的id
    private String nickname;//用户的昵称
    private String avatarurl;//用户头像地址
    private Integer ischecked;//是否选中
    private String content;//发布的内容
    private String keywords;//关键字
    private Date createtime;//创建时间
}
