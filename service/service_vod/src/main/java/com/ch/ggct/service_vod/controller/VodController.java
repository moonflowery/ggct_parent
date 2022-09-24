package com.ch.ggct.service_vod.controller;

import com.ch.ggct.service_vod.service.VodService;
import com.ch.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月24日 15:42
 */
@RestController
@Api("云点播管理接口")
@RequestMapping("/admin/vod/")
public class VodController {
    @Autowired
    VodService vodService;
    @ApiOperation("上传视频")
    @PostMapping("upload")
    public Result uploadVideo(){
        String fileId = vodService.uploadVideo();
        return Result.ok(fileId);
    }
    @ApiOperation("删除视频")
    @DeleteMapping("remove")
    public Result removeVideo(String fileId){
        vodService.removeVideo(fileId);
        return Result.ok(null);


    }


}
