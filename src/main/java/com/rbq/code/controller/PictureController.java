package com.rbq.code.controller;

import com.rbq.code.entity.Picture;
import com.rbq.code.service.PictureService;
import com.rbq.code.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月03日 10:18
 * @Description 图片资源控制类
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    /*
     *获取所有的图片数据
     * @author RenBoQing
     * @date 2022/4/12 0012 19:16
     * @return com.rbq.code.vo.R
     */
    @RequestMapping("/picture")
    @ResponseBody
    public R queryAllPicture() {
        List<Picture> pictureList = pictureService.queryAllPicture();
        return R.success("查询成功", pictureList);
    }
}
