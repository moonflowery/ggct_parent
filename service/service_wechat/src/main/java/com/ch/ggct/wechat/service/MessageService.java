package com.ch.ggct.wechat.service;

import me.chanjar.weixin.common.error.WxErrorException;

import java.util.Map;
public interface MessageService {
    //接收消息
    String receiveMessage(Map<String, String> param);

    void pushPayMessage(long id) throws WxErrorException;
}
