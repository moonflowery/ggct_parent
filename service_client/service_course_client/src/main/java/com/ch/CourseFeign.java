package com.ch;

import com.ch.ggct.model.vod.Course;
import com.ch.ggct.model.vod.Teacher;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月27日 08:21
 */
@FeignClient("service-vod")
public interface CourseFeign {
    @GetMapping("/api/vod/course/inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字", required = true)
            @PathVariable String keyword);
    @GetMapping("inner/getById/{courseId}")
    public Course getById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId);

    @GetMapping("/admin/vod/teacher/inner/getTeacher/{id}")
    Teacher getTeacherLive(@PathVariable Long id);

}
