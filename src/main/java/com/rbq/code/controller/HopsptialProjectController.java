package com.rbq.code.controller;

import com.github.pagehelper.PageInfo;
import com.rbq.code.entity.HosptialServiceVo;
import com.rbq.code.service.HopsptialProjectService;
import com.rbq.code.service.HosptialProService;
import com.rbq.code.vo.JsonObject;
import com.rbq.code.vovo.HospitalProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年04月12日 16:06
 * @Description 医院项目控制器
 */
@RequestMapping("/service")
@Controller
public class HopsptialProjectController {
    @Autowired
    private HopsptialProjectService hopsptialProjectService;
    @Autowired
    private HosptialProService hosptialProService;
    /*
     *通过医院id获取对应的数据
     * @author RenBoQing
     * @date 2022/4/12 0012 19:12
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonObject queryAllProjectsById(Integer id) {
        List<HospitalProjectVo> hopsptialProjects = hopsptialProjectService.queryAllProjectById(id);
        return JsonObject.success(0, hopsptialProjects, "查询成功", (long) hopsptialProjects.size());
    }

    /*
     *查询医院的项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:06
     * @param model
     * @param hospitalProjectVo
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/alllist")
    @ResponseBody
    public JsonObject queryAllProjects(Model model, HospitalProjectVo hospitalProjectVo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<HospitalProjectVo> hospitalProjectVoPageInfo = hopsptialProjectService.queryHopsptialProject(page, limit, hospitalProjectVo);
        return JsonObject.success(0, hospitalProjectVoPageInfo.getList(), "查询成功", hospitalProjectVoPageInfo.getTotal());
    }

    /*
     *查询所有的医院项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:05
     * @param model
     * @param hosptialServiceVo
     * @param page
     * @param limit
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/servicelist")
    @ResponseBody
    public JsonObject queryAllPro(Model model, HosptialServiceVo hosptialServiceVo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        PageInfo<HosptialServiceVo> hosptialServiceVoPageInfo = hosptialProService.queryAllProject(page, limit, hosptialServiceVo);
        return JsonObject.success(0, hosptialServiceVoPageInfo.getList(), "查询成功", hosptialServiceVoPageInfo.getTotal());
    }

    /*
     *根据rid删除项目
     * @author RenBoQing
     * @date 2022/4/30 0030 16:55
     * @param rid
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/del")
    @ResponseBody
    public JsonObject deleteProjectByRid(Integer rid) {
        int deleteProjectByRid = hopsptialProjectService.deleteProjectByRid(rid);
        if (deleteProjectByRid > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 17:30
     * @param rid
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delProByIds")
    @ResponseBody
    public JsonObject delProByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        //后台获取
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        hopsptialProjectService.delProByIds(delList);
        return JsonObject.success("删除成功");
    }

    /*
     *根据id删除对应的项目
     * @author RenBoQing
     * @date 2022/4/30 0030 20:30
     * @param id
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delserviceByid")
    @ResponseBody
    public JsonObject delserviceByid(Integer id) {
        int deleteServiceById = hosptialProService.deleteServiceById(id);
        if (deleteServiceById > 0) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *添加医院项目
     * @author RenBoQing
     * @date 2022/4/30 0030 21:08
     * @param hosptialServiceVo
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonObject addService(HosptialServiceVo hosptialServiceVo) {

        int addService = hosptialProService.addService(hosptialServiceVo);
        if (addService > 0) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/4/30 0030 21:23
     * @param ids
     * @return com.rbq.code.vo.JsonObject
     */
    @RequestMapping("/delServiceByIds")
    @ResponseBody
    public JsonObject delServiceByIds(String ids) {
        List<Integer> delList = new ArrayList<>();
        //后台获取
        String[] strs = ids.split(",");
        for (String str : strs) {
            delList.add(Integer.parseInt(str));
        }
        int delServiceByIds = hosptialProService.delServiceByIds(delList);
        if(delServiceByIds>0){
            return JsonObject.success(0,"删除成功");
        }else {
            return JsonObject.fail(0,"删除失败");
        }
    }
      /*
       *修改状态
       * @author RenBoQing
       * @date 2022/4/30 0030 22:24
       * @param hosptialServiceVo
       * @return com.rbq.code.vo.JsonObject
       */
    @RequestMapping("/updateService")
    @ResponseBody
    public JsonObject updateService(HosptialServiceVo hosptialServiceVo){
        int updateServiceById = hosptialProService.updateServiceById(hosptialServiceVo);
        if(updateServiceById>0){
            return JsonObject.success(0,"修改成功");
        }
        else{
            return JsonObject.fail(1,"修改失败");
        }
    }

}
