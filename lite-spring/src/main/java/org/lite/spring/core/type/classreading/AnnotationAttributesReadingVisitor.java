package org.lite.spring.core.type.classreading;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import org.lite.spring.core.annotation.AnnotationAttributes;

import java.util.Map;

/**
 * Created by bfq on 2020/3/13
 */
final class AnnotationAttributesReadingVisitor extends AnnotationVisitor {
    private final String annotationType;

    private final Map<String, AnnotationAttributes> attributesMap;

    AnnotationAttributes attributes = new AnnotationAttributes();

    public AnnotationAttributesReadingVisitor(String annotationType,
                                              Map<String, AnnotationAttributes> attributesMap) {
        //此处设置的是一个常量，位置放在ClassMetadataReadingVisitor其实不太合适，先暂时这么处理
        super(ClassMetadataReadingVisitor.ASM_VERSION);
        this.annotationType = annotationType;
        this.attributesMap = attributesMap;
    }

    @Override
    public void visitEnd() {
        this.attributesMap.put(this.annotationType, this.attributes);
    }

    @Override
    public void visit(String attributeName, Object attributeValue)  {
        this.attributes.put(attributeName, attributeValue);
    }
}
