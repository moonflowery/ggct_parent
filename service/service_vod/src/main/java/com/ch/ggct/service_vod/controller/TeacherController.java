package com.ch.ggct.service_vod.controller;

import com.ch.ggct.model.vod.Teacher;
import com.ch.ggct.service_vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ch
 * @since 2022-09-11
 */
@Api(tags = "讲师管理系统")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    /*
        查询所有讲师
     */
    @ApiOperation("返回所有讲师接口")
    @GetMapping("findAll")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }
    /*
        根据ID删除讲师
     */
    @ApiOperation("逻辑删除讲师")
    //TODO
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@ApiParam(name = "id",value = "ID") @PathVariable("id") long id){
        boolean b = teacherService.removeById(id);
        return b;
    }


}

