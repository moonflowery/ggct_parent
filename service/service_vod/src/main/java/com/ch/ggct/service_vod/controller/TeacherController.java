package com.ch.ggct.service_vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.ggct.model.vod.Teacher;
import com.ch.ggct.service_vod.service.TeacherService;
import com.ch.ggct.vo.vod.TeacherQueryVo;
import com.ch.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    public Result findAll() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    /*
        根据ID删除讲师
     */
    @ApiOperation("逻辑删除讲师")
    //TODO
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@ApiParam(name = "id", value = "ID") @PathVariable("id") Integer id) {
        boolean b = teacherService.removeById(id);
        System.out.println(b);
        if (b == true) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("按条件分页查 讲师")
    @PostMapping("findQueryPage/{current}/{limit}")
    public Result findPage(@PathVariable long current, @PathVariable long limit, @RequestBody TeacherQueryVo teacherQueryVo) {
        //创建分页对象
        Page<Teacher> pageParam = new Page<>(current, limit);


        if (teacherQueryVo == null) {
            IPage<Teacher> page = teacherService.page(pageParam, null);
            return Result.ok(page);
        } else {
            //将这四个查询条件封装在一个实体类中，在方法参数中接收，然后获取
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();

            //封装查询条件
            //为空或空字符串时为true
            if (!StringUtils.isEmpty(name)) {
                queryWrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                queryWrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                queryWrapper.ge("join_date", joinDateBegin);
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                queryWrapper.le("join_date", joinDateEnd);
            }


            //调用分页方法，将page对象，和条件对象传入进去，返回的page中存入我们的数据，和分页所需的数据
            IPage page = teacherService.page(pageParam, queryWrapper);
            return Result.ok(page);
        }
    }
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return Result.ok(null);
    }
    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }
    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Teacher teacher) {
        teacherService.updateById(teacher);
        return Result.ok(null);
    }
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        teacherService.removeByIds(idList);
        return Result.ok(null);
    }

}

