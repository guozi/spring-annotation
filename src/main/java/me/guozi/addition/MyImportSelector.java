package me.guozi.addition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 自定义ImportSelector
 *
 * @see <a href="https://juejin.im/post/5d63b455f265da03e52341d0">https://juejin.im/post/5d63b455f265da03e52341d0</a>
 * Created by chenyun on 2020/4/7
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标准@Import注解类的所有注解信息
     * @return 要导入到容器的组件的全类名数组
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        final Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println("MyImportSelector.selectImports:annotationTypes::" + annotationTypes);

        // 此处不要返回null，否则会报错
        return new String[]{"me.guozi.bean.Weather"};
    }
}
