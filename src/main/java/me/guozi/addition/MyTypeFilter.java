package me.guozi.addition;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义TypeFilter
 * <p>
 * Created by chenyun on 2020/4/6
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * @param metadataReader 读取当前扫描类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前正在扫描类的注解信息
        final AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前正在扫描类的类信息
        final ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取当前正在扫描类的类资源信息（类路径）
        final Resource resource = metadataReader.getResource();

        final String className = classMetadata.getClassName();

        System.out.println("MyTypeFilter.match:className::" + className);

        if (className.contains("er")) {
            return true;
        }
        return false;
    }
}
