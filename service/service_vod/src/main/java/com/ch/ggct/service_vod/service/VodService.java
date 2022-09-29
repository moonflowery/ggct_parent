package com.ch.ggct.service_vod.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface VodService {

    String uploadVideo();

    void removeVideo(String fileId);

    Map<String,Object> getPlayAuth(Long courseId, Long videoId);
}
