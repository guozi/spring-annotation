package me.guozi.addition;

import me.guozi.bean.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean
 *
 * @see <a href="https://juejin.im/post/5d8e06b06fb9a04e1c07d87b">https://juejin.im/post/5d8e06b06fb9a04e1c07d87b</a>
 * <p>
 * Created by chenyun on 2020/4/8
 */
public class CarFactoryBean implements FactoryBean<Car> {

    public Car getObject() throws Exception {
        return new Car();
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
