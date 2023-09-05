package com.beckwell.springboot.conditional;

import com.beckwell.springboot.annotation.HuawuqueConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class HuawuqueOnClassConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(HuawuqueConditionalOnClass.class.getName());
        String className = (String) annotationAttributes.get("value");
        try {
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
