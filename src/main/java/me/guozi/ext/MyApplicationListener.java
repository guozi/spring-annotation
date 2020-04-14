package me.guozi.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by chenyun on 2020/4/12
 */
@Component
public class MyApplicationListener implements ApplicationListener {

    /**
     * 当容器中发布此事件以后，方法触发
     *
     * @param event
     */
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件：" + event);
    }
}
