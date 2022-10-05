package com.ch.ggct.live.api;

import com.alibaba.fastjson.JSONObject;
import com.ch.ggct.live.service.LiveCourseService;
import com.ch.result.Result;
import com.ch.utils.AuthContextHolder;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年10月05日 16:36
 */
@RestController
@RequestMapping("api/live/liveCourse")
public class LiveCourseApiController {
    @Autowired
    private LiveCourseService liveCourseService;

    @ApiOperation(value = "获取用户access_token")
    @GetMapping("getPlayAuth/{id}")
    public Result  getPlayAuth(@PathVariable Long id) {
        //之前在前端页面从将用户信息从localStorage中放到请求头中，使用工具类获取，改工具类中保存在
        Long userId =  AuthContextHolder.getUserId();
        JSONObject object = liveCourseService.getAccessToken(id, userId);
        return Result.ok(object);
    }

    @ApiOperation("根据ID查询课程")
    @GetMapping("getInfo/{courseId}")
    public Result getInfo(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){
        Map<String, Object> map = liveCourseService.getInfoById(courseId);
        return Result.ok(map);
    }
}
