package com.ch.ggct.service_vod.controller;

import com.ch.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月17日 18:50
 */
@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
public class UserController {
    @PostMapping("login")
    public Result login(){
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin");
        System.out.println("----------------------");

        return Result.ok(map);
    }
    @GetMapping("info")
    public Result info(){
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        System.out.println("----------------------");
        return Result.ok(map);
    }


}
