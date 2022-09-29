package com.ch.ggct.service_vod.service.impl;

import com.ch.exception.GgktException;
import com.ch.ggct.model.vod.Video;
import com.ch.ggct.service_vod.config.ConstantPropertiesUtil;
import com.ch.ggct.service_vod.service.VideoService;
import com.ch.ggct.service_vod.service.VodService;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月24日 15:48
 */
@Service
public class VodServiceImpl implements VodService {
    @Autowired
    VideoService videoService;
    @Value("${tencent.video.appid}")
    String appId;

    @Override
    public String uploadVideo()   {
        VodUploadClient client = new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        VodUploadRequest request = new VodUploadRequest();
        request.setMediaFilePath("/Users/chenghao/temp/12282_1664420077.mp4");
        request.setProcedure("LongVideoPreset");
       try {
           VodUploadResponse response = client.upload("ap-chengdu", request);
           //获取上传之后视频id
           String fileId = response.getFileId();
           return fileId;
       }catch (Exception e){
           System.out.println("上传失败");
           throw new GgktException(20001,"上传失败失败----");
       }

    }

    @Override
    public void removeVideo(String fileId) {


            try{
                // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
                Credential cred =
                        new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID,
                                ConstantPropertiesUtil.ACCESS_KEY_SECRET);
                // 实例化要请求产品的client对象,clientProfile是可选的
                VodClient client = new VodClient(cred, "");
                // 实例化一个请求对象,每个接口都会对应一个request对象
                DeleteMediaRequest req = new DeleteMediaRequest();
                req.setFileId(fileId);
                // 返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
                DeleteMediaResponse resp = client.DeleteMedia(req);
                // 输出json格式的字符串回包
                System.out.println(DeleteMediaResponse.toJsonString(resp));
            } catch (TencentCloudSDKException e) {
                e.printStackTrace();
            }
        }
    /*
    视屏播放功能：拿到视频ID，拿到腾讯云appIdZ
     */
    @Override
    public Map<String, Object> getPlayAuth(Long courseId, Long videoId) {
        Video video = videoService.getById(videoId);
        Map<String,Object> map = new HashMap<>();
        map.put("videoSourceId",video.getVideoSourceId());
        map.put("appId",appId);
        return map;
    }
}