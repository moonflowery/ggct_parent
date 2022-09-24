package com.ch.ggct.service_vod.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface VodService {

    String uploadVideo();

    void removeVideo(String fileId);
}
