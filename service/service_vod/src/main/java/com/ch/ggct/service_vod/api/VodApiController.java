package com.ch.ggct.service_vod.api;

import com.ch.ggct.service_vod.service.VodService;
import com.ch.result.Result;
import io.swagger.annotations.Api;
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
 * @data 2022年09月29日 09:47
 */
///api/vod/getPlayAuth/15/51
@Api(tags = "视频播放管理")
@RestController
@RequestMapping("/api/vod")
public class VodApiController {
    @Autowired
    VodService vodService;
    @ApiOperation("视频播放接口")
    @GetMapping("getPlayAuth/{courseId}/{videoId}")
    public Result getPlayAuth(
            @ApiParam(value = "课程id", required = true)
            @PathVariable Long courseId,
            @ApiParam(value = "视频id", required = true)
            @PathVariable Long videoId){

        Map<String, Object> playAuth = vodService.getPlayAuth(courseId, videoId);
        return Result.ok(playAuth);
    }

}
