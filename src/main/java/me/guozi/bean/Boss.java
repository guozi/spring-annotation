package me.guozi.bean;

import org.springframework.stereotype.Component;

/**
 * Created by chenyun on 2020/4/10
 */
@Component
public class Boss {

    //    @Autowired
    private Car car;

    /**
     * 构造器要用的组件，都是从容器中获取
     *
     * @param car
     */
//    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    public Car getCar() {
        return car;
    }

    /**
     * 标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；方法使用的参数，自定义类型的值从ioc容器中获取
     *
     * @param car
     */
    //    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
               "car=" + car +
               '}';
    }
}
