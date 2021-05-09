package com.neon.uitl;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.core.Converter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * override cglib bean copy
 * @author Neon
 * @date 2019-11-16 16:40:21
 */
public class BeanUtils{

    private static final Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();

    private static final Map<String, Set<String>> EXCEPT_FIELD = new ConcurrentHashMap<>();

    private static final String BEAN_KEY = "clear", SET_METHOD_PREFIX = "set";

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        return beanCopierCache.computeIfAbsent(beanKey, s->BeanCopier.create(sourceClass, targetClass, true));
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass, String beanKey) {
        return beanCopierCache.computeIfAbsent(beanKey, s->BeanCopier.create(sourceClass, targetClass, true));
    }

    public static void copyProperties(Object source, Object target) {
        copy(source, target, true);
    }

    public static void copyIgnoreNull(Object source, Object target) {
        copy(source, target, false);
    }

    private static void copy(Object source, Object target, boolean cover) {
        if(source == null || target == null) return;
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target,
                (value, t, context)->
                        !cover && value == null || value != null && !t.isAssignableFrom(value.getClass())
                                && !value.getClass().isAssignableFrom(t) ?
                                BeanMap.create(target).get(getPropertyName(String.valueOf(context))) : value);
    }

    public static void clear(Object source) {
        clear(source, (String) null);
    }

    public static void clearIgnoreId(Object source) {
        clear(source, "id");
    }

    /**
     * @param source          需要清空属性值的对象
     * @param exceptFieldName 无须清除的字段
     */
    public static void clear(Object source, String... exceptFieldName) {
        if(source == null) return;
        Set<String> fieldNames = exceptFieldName == null ? null :
                EXCEPT_FIELD.computeIfAbsent(Arrays.toString(exceptFieldName), v->
                        Arrays.stream(exceptFieldName).map(s->SET_METHOD_PREFIX + Character.toString(s.charAt(0)).toUpperCase() + s.substring(1))
                                .collect(Collectors.toSet()));
        String beanKey = source.getClass().toString() + BEAN_KEY + source.getClass().toString() + BEAN_KEY;
        BeanCopier copier = getBeanCopier(source.getClass(), source.getClass(), beanKey);
        copier.copy(source, source,
                (value, t, context)->fieldNames != null && fieldNames.contains(context.toString()) ? value : null);
    }

    public static void copy(Object source, Object target, Converter cover) {
        if(source == null || target == null) return;
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, cover);
    }

    private BeanUtils() {
    }

    private static String getPropertyName(String methodName) {
        char[] newChar = new char[methodName.length() - 3];
        System.arraycopy(methodName.toCharArray(), 3, newChar, 0, methodName.length() - 3);
        newChar[0] = Character.toLowerCase(newChar[0]);
        return String.valueOf(newChar);
    }

    /**
     * 类型转换
     */
    public static <T> T cast(Object o, Class<T> clazz) {
        return TypeUtils.cast(o, clazz, ParserConfig.getGlobalInstance());
    }
}