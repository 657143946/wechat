package me.lichengming.wechat.controller;

import com.jfinal.core.Controller;
import me.abnerlee.wechatAPI.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-10-10.
 */
public class WeixinController extends Controller {
    public void weixin() throws IOException {
        String ret = "weixin";
        if (getPara("echostr") != null){
            if (Accessor.checkSignature(this.getRequest())){
                ret = getPara("echostr");
            }
        }
        else {
            WechatReceiveData msg = WechatReceiveDataParser.getMsgEntity(this.getRequest().getInputStream());
            System.out.println(msg.getFromUserName());
            System.out.println(msg.getToUserName());
            if (msg.getMsgType().equals("text")){
                switch(msg.getContent()){
                    case "noe news":
                        List<Map<String, String>> news1 = new ArrayList<>();

                        Map<String, String> one1 = new HashMap<>();
                        one1.put("title", "马云乌镇演讲");
                        one1.put("desc", "马云乌镇演讲,或许影响你的一生(真诚推荐)");
                        one1.put("pic", "http://mmbiz.qpic.cn/mmbiz/ywib59nRIMicqxYia3ciaIv0Otjic4R5u6Yic32lHx2bgal23NBr4ibZ6UK76Umia2mUA1OKhiaicVaPxreUykg8nSLv7aHA/640");
                        one1.put("url", "http://mp.weixin.qq.com/s?__biz=MjM5MTM0MDE2MA==&mid=201116649&idx=1&sn=44355aafad8f20c321d827ed9e31b3b0&scene=2&from=timeline&isappinstalled=0#rd");
                        news1.add(one1);

                        ret = ConstructWechatXmlString.getNewsXml(msg.getFromUserName(), msg.getToUserName(), news1);
                        break;
                    case "more news":
                        List<Map<String, String>> news2 = new ArrayList<>();

                        Map<String, String> one2 = new HashMap<>();
                        one2.put("title", "马云乌镇演讲");
                        one2.put("desc", "马云乌镇演讲,或许影响你的一生(真诚推荐)");
                        one2.put("pic", "http://mmbiz.qpic.cn/mmbiz/ywib59nRIMicqxYia3ciaIv0Otjic4R5u6Yic32lHx2bgal23NBr4ibZ6UK76Umia2mUA1OKhiaicVaPxreUykg8nSLv7aHA/640");
                        one2.put("url", "http://mp.weixin.qq.com/s?__biz=MjM5MTM0MDE2MA==&mid=201116649&idx=1&sn=44355aafad8f20c321d827ed9e31b3b0&scene=2&from=timeline&isappinstalled=0#rd");
                        news2.add(one2);
                        news2.add(one2);
                        news2.add(one2);

                        ret = ConstructWechatXmlString.getNewsXml(msg.getFromUserName(), msg.getToUserName(), news2);
                        break;
                    default:
                        ret = ConstructWechatXmlString.getTextXml(msg.getFromUserName(), msg.getToUserName(), "您发送了："+msg.getContent());
                        break;
                }
            } else {
                ret = ConstructWechatXmlString.getTextXml(msg.getFromUserName(), msg.getToUserName(), "更多功能尽请期待");
            }
        }
        renderText(ret);
        return ;
    }

    public static void main(String[] args){
        System.out.println(Constant.TOKEN);
        System.out.println(Constant.APPID);
        System.out.println(Constant.APPSECRET);
        System.out.println(Constant.ACCESS_TOKEN_URL);
        System.out.println(Constant.IP_LIST_URL);

    }
}
