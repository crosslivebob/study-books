package org.lite.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Created by bfq on 2020/2/29
 */
//ANNOTATION_TYPE修饰注解的注解，即是元注解
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD ,ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    /**
     * Declares whether the annotated dependency is required.
     * <p>Defaults to {@code true}.
     */
    boolean required() default true;
}
