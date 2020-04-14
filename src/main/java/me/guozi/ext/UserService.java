package me.guozi.ext;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by chenyun on 2020/4/12
 */
@Component
public class UserService {
    /**
     * 添加一个事件监听器，可以是指定类型，也可以是ApplicationContextEvent类型
     *
     * @param event
     */
    @EventListener(classes = {ContextRefreshedEvent.class})
    public void listen(ContextRefreshedEvent event) {
        System.out.println("UserService。。监听到的事件：" + event);
    }
}
