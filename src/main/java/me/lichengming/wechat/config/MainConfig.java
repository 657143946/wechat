package me.lichengming.wechat.config;

import com.jfinal.config.*;
import com.jfinal.render.ViewType;
import me.lichengming.wechat.controller.WeixinController;

/**
 * Created by Administrator on 14-8-26.
 */
public class MainConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setViewType(ViewType.JSP);
        me.setEncoding("utf-8");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("weixin", WeixinController.class);
        
    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }

    @Override
    public void afterJFinalStart(){

    }

    @Override
    public void beforeJFinalStop(){

    }


}
