package me.lichengming.wechat.controller;

import com.jfinal.core.Controller;
import me.abnerlee.wechatAPI.*;

import java.io.IOException;

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
            if (msg.getMsgType().equals("text")){
                ret = ConstructWechatXmlString.getTextXml(msg.getFromUserName(), "您发送了："+msg.getContent());
            } else {
                ret = ConstructWechatXmlString.getTextXml(msg.getFromUserName(), "更多功能尽请期待");
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
