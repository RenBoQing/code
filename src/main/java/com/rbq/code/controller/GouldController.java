package com.rbq.code.controller;

import com.rbq.code.vo.GouldUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月30日 10:02
 * @Description 高德地图Controller
 */
@Controller
@RequestMapping("/map")
public class GouldController {
    //自动装配 工具类
    @Autowired
    private GouldUtil gouldUtil;

    /*
     *高德地图根据经纬度获取地址
     * @author RenBoQing
     * @date 2022/3/30 0030 10:18
     * @param getLng
     * @param getLat
     * @return java.lang.String
     */

    @RequestMapping("/address")
    @ResponseBody
    public String address(String getLng, String getLat) throws Exception {
        String aMapByLngAndLat = gouldUtil.getAMapByLngAndLat(getLng, getLat);
        return aMapByLngAndLat;
    }
    /*
     *根据地址获取经纬度
     * @author RenBoQing
     * @date 2022/3/31 0031 9:57
     * @param address
     * @return java.lang.String
     */

    @RequestMapping("/getLonLat")
    @ResponseBody
    public String[] getLonLat(String address) {
        String lonLat = gouldUtil.getLonLat(address);
        String[] split = lonLat.split(",");
        return split;
    }
    /*
     *通过两地获取两地的距离
     * @author RenBoQing
     * @date 2022/4/8 0008 17:28
     * @param addressone
     * @param addresstwo
     * @return long
     */

    @RequestMapping("/getDistance")
    @ResponseBody
    public long getDistance(String addressone, String addresstwo) {
        long distanceByAddress = gouldUtil.getDistanceByAddress(addressone, addresstwo);
        return distanceByAddress;
    }
}
