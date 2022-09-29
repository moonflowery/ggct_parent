package com.ch.ggct.user.controller.api;

import com.alibaba.fastjson.JSON;
import com.ch.ggct.model.user.UserInfo;
import com.ch.ggct.user.service.UserInfoService;
import com.ch.jwt.JwtHelper;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月27日 23:40
 */

//页面需要跳转，所以不使用RestController
@Controller
@RequestMapping("/api/user/wechat")
public class WeChatContoller {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    WxMpService wxMpService;

    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;
    /*
     * @Description:可以到的Codew
     * @Author: chenghao
     * @Date: 2022/9/28 08:5
     * @param returnUrl
     * @param request
     * @return: java.lang.String
     **/
    @GetMapping("authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl, HttpServletRequest request) {
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(userInfoUrl,
                WxConsts.OAUTH2_SCOPE_USER_INFO,
                URLEncoder.encode(returnUrl.replace("guiguketan", "#")));
        System.out.println(redirectURL);
        System.out.println("访问到授权接口000000000000000--------------");
        return "redirect:" + redirectURL;
    }

    @GetMapping("userInfo")
    public String userInfo(@RequestParam("code") String code,@RequestParam("state") String returnUrl) throws WxErrorException {

        //拿着code可获取openID
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = this.wxMpService.oauth2getAccessToken(code);
        String openId = wxMpOAuth2AccessToken.getOpenId();
        System.out.println("【微信网页授权】openId={}"+openId);
        WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);

        System.out.println("【微信网页授权】wxMpUser={}"+ JSON.toJSONString(wxMpUser));
        UserInfo userInfo = userInfoService.getByOpenid(openId);
        System.out.println("77777777777777777777777777访问到了userInfo接口·········");
        if(null == userInfo) {
            userInfo = new UserInfo();
            userInfo.setOpenId(openId);
            userInfo.setUnionId(wxMpUser.getUnionId());
            userInfo.setNickName(wxMpUser.getNickname());
            userInfo.setAvatar(wxMpUser.getHeadImgUrl());
            userInfo.setSex(wxMpUser.getSexId());
            userInfo.setProvince(wxMpUser.getProvince());

            userInfoService.save(userInfo);
        }
        //使用JWT工具 生成token
        String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());
        if(returnUrl.indexOf("?") == -1) {
            return "redirect:" + returnUrl + "?token=" + token;
        } else {
            return "redirect:" + returnUrl + "&token=" + token;
        }
    }
}



