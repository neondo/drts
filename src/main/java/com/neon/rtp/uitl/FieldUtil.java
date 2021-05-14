
package com.neon.rtp.uitl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Neon
 * @date 2019/8/15 22:40
 */
public class FieldUtil{

    public static List<Field> getAllField(Object o) {
        List<Field> fields = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while(clazz != null && !"Object".equals(clazz.getSimpleName())) {
            Collections.addAll(fields, clazz.getDeclaredFields());
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static Field getField(Object o, String fieldName) {
        if(o == null)
            return null;
        Class<?> clazz = o.getClass();
        try {
            return clazz.getDeclaredField(fieldName);
        } catch(NoSuchFieldException e) {
            return null;
        }
    }

    public static Object getFieldValue(Object o, String fieldName) {
        Field field = getField(o, fieldName);
        if(field != null) {
            field.setAccessible(true);
            try {
                return field.get(o);
            } catch(IllegalAccessException e) {
                return null;
            }
        }
        return null;
    }

    public static Boolean setFieldValue(Object o, String fieldName, Object fieldValue) {
        Field field = getField(o, fieldName);
        if(field != null) {
            field.setAccessible(true);
            try {
                field.set(o, fieldValue);
                return true;
            } catch(IllegalAccessException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * 获取字段
     * @param clazz     类
     * @param fieldName 要获取的字段名
     * @return Field
     */
    public static Field access(Class<?> clazz, String fieldName) {
        while(clazz != null && !"Object".equals(clazz.getSimpleName())) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch(NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    /**
     * 校验字段是否存在
     * @param t         实体
     * @param fieldName 字段名
     * @return Boolean
     */
    public static Boolean hasField(Object t, String fieldName) {
        return FieldUtil.access(t.getClass(), fieldName) != null;
    }

    public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotation) {
        return field.getAnnotation(annotation);
    }
}
