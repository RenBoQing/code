package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.Hospital;
import com.rbq.code.service.HospitalService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author RenBoQing
 * @date 2022年03月25日 11:06
 * @Description 医院控制器
 */
@Slf4j
@Controller
@RequestMapping("/hosptial")
public class HosptialController {
    @Autowired
    private HospitalService hospitalService;

    /*
     *查询所有的医院列表  分页查询
     * @author RenBoQing
     * @date 2022/3/26 0026 21:42
     * @return com.rbq.code.vo.JsonObject
     */
    @GetMapping("/list")
    @ResponseBody
    public JsonObject getHosptialAl(Model model, Hospital hospital, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit) {
        PageInfo<Hospital> hospitalPageInfo = hospitalService.queryHosptialAll(page, limit, hospital);
        return JsonObject.success(0, hospitalPageInfo.getList(), "查询成功", hospitalPageInfo.getTotal());
    }
    /*
     *删除医院信息
     * @author RenBoQing
     * @date 2022/3/29 0029 10:28
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject delHHosptialByid(Integer id) {
        hospitalService.deleteHosptialById(id);
        JsonObject jsonObject = new JsonObject();
        return JsonObject.success("删除成功");
    }

    /*
     *添加医院信息
     * @author RenBoQing
     * @date 2022/3/29 0029 10:27
     * @param hospital
     * @return com.rbq.code.vo.R
     */
    @RequestMapping("/add")
    @ResponseBody
    public R addHosptial(Hospital hospital) {
        hospital.setCreatetime(new Date());
        hospitalService.addaddHosptial(hospital);
        return R.success();
    }
    /*
     *修改医院信息
     * @author RenBoQing
     * @date 2022/3/29 0029 10:26
     * @param hospital
     * @return com.rbq.code.vo.R
     */
    @RequestMapping("/update")
    @ResponseBody
    public R updateHosptial(Hospital hospital, Integer hid) {
        hospitalService.updateHosptial(hospital, hid);
        return R.success();
    }
    /*
     *数据表格 统计医院数据
     * @author RenBoQing
     * @date 2022/4/2 0002 9:28
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @RequestMapping("/queryHosptialCount")
    @ResponseBody
    public List<Map<String, Object>> queryForList() {
        return hospitalService.queryHosptialCount();
    }
    /*
     *批量删除医院信息
     * @author RenBoQing
     * @date 2022/4/9 0009 9:45
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delHosptialByIds")
    @ResponseBody
    public JsonObject delHosptialByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        hospitalService.delHosptialByIds(delList);
        return JsonObject.success("删除成功");
    }

}
