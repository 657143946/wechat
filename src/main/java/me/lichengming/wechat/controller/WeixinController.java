package me.lichengming.wechat.controller;

import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;
import me.abnerlee.wechatAPI.Accessor;

/**
 * Created by Administrator on 14-10-10.
 */
@ClearInterceptor(ClearLayer.ALL)
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
}
