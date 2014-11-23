package me.lichengming.wechat.controller;

import com.jfinal.core.Controller;
import me.abnerlee.wechatAPI.Accessor;
import me.abnerlee.wechatAPI.Constant;

/**
 * Created by Administrator on 14-10-10.
 */
public class WeixinController extends Controller {
    public void weixin() {
        String ret = "weixin";
        if (getPara("echostr") != null){
            if (Accessor.checkSignature(this.getRequest())){
                ret = getPara("echostr");
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
