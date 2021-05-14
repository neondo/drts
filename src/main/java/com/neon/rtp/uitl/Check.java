package com.neon.rtp.uitl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 校验工具
 * @author Neon
 */
public class Check{

    public final static Pattern emojiPattern = Pattern
            .compile(Regex.emoji, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

    private static final Logger log = LoggerFactory.getLogger(Check.class);

    /**
     * 校验传入字符串是否为空
     * @param value String
     */
    public static boolean notNull(String value) {
        if(value != null) {
            String trim = value.trim();
            return !"".equals(trim) && !"undefined".equalsIgnoreCase(trim) &&
                    !"null".equalsIgnoreCase(trim);
        }
        return false;
    }

    public static boolean isNull(String value) {
        return !Check.notNull(value);
    }

    /**
     * 校验传入List,set是否为空
     * @param collection Collection
     */
    public static boolean notNull(Collection collection) {
        return collection != null && !collection.isEmpty() && !(collection.size() == 1 && collection.contains(null));
    }

    /**
     * 校验传入map是否为空
     * @param map map
     */
    public static boolean notNull(Map map) {
        return map != null && !map.isEmpty();
    }

    /**
     * 校验传入Integer是否为空
     * @param num Integer
     */
    public static boolean notNull(Integer num) {
        return num != null && num > -1;
    }

    /**
     * 校验传入Double是否为空
     * @param num Double
     */
    public static boolean notNull(Double num) {
        return num != null;
    }

    /**
     * 校验传入Float是否为空
     * @param num Float
     */
    public static boolean notNull(Float num) {
        return num != null;
    }

    /**
     * 校验传入Date是否为空
     * @param date 时间
     */
    public static boolean notNull(Date date) {
        return date != null;
    }

    /**
     * 校验传入Long是否为空
     * @param num Long
     */
    public static boolean notNull(Long num) {
        return num != null && num != 0L;
    }

    /**
     * validity empty value and emoji expression
     * @param o entity
     */
    public static void notNull(Object o, String... fieldNames) {
        boolean isMap = o instanceof Map;
        Map map = isMap ? (Map) o : null;
        for(String s : fieldNames) {
            String msg = s;
            String[] arr = s.trim().split(",");
            if(arr.length > 1) {
                s = arr[0].trim();
                msg = arr[1].trim();
            }
            try {
                Object value;
                if(isMap) {
                    value = map.get(s);
                } else {
                    Field declaredField = FieldUtil.access(o.getClass(), s);
                    if(declaredField == null) {
                        throw new OperateException("无" + msg + "此项");
                    }
                    declaredField.setAccessible(true);
                    if(arr.length == 1) {
                        Desc annotation = declaredField.getAnnotation(Desc.class);
                        if(annotation != null)
                            msg = annotation.value();
                    }
                    value = declaredField.get(o);
                }
                if(value == null || value.toString().trim().equals("")) {
                    throw new OperateException(msg + "不能为空!");
                }
            } catch(IllegalAccessException e) {
                throw new OperateException(msg + "此项获取异常!");
            }
        }
    }

    /**
     * controller acquire request params  validity simple method
     * combine {@code Check#trimAll} and {@code Check#notNull(Object,String...)} and filter emoji
     * @param t entity
     * @see Check#trimAll
     * @see Check#notNull(Object, String...)
     * @see Check#hasEmoji(String)
     */
    public static void verify(Object t, String... fieldNames) {
        List<Field> declaredFields = FieldUtil.getAllField(t);
        Map<String, String> fieldMap = null;
        if(fieldNames != null) {
            fieldMap = new HashMap<>();
            for(String fieldName : fieldNames) {
                String[] split = fieldName.split(",");
                fieldMap.put(split[0], split.length > 1 ? split[1] : null);
            }
        }
        for(Field field : declaredFields) {
            field.setAccessible(true);
            String name = field.getName();
            try {
                Object o = field.get(t);
                String trim = null;
                String msg;
                Desc annotation = field.getAnnotation(Desc.class);
                msg = annotation != null ? annotation.value() : name;
                if(fieldMap != null && fieldMap.containsKey(name)) {
                    String msgTemp = fieldMap.get(name);
                    if(msgTemp != null)
                        msg = msgTemp;
                    if(o == null)
                        throw new OperateException(msg + "不能为空!");
                    trim = o.toString().trim();
                    if(trim.isEmpty())
                        throw new OperateException(msg + "不能为空!");
                }
                if(o == null)
                    continue;
                if(field.getType().getSimpleName().equals("String")) {
                    if(trim == null)
                        trim = o.toString().trim();
                    if(Check.hasEmoji(trim))
                        throw new OperateException(msg + "中含有emoji非法字符!");
                    field.set(t, trim);
                }
            } catch(Exception e) {
                if(e instanceof OperateException)
                    throw (OperateException) e;
                log.warn("verify warn : " + t + name);
            }
        }
    }

    /**
     * 校验字符串是否是一个整数
     */
    public static boolean isNumber(String num) {
        return notNull(num) && num.matches(Regex.number);
    }

    /**
     * 校验字符串是否是一个数(包括正负整数或小数)
     */
    public static boolean isDecimal(String num) {
        return notNull(num) && num.matches(Regex.decimal);
    }

    /**
     * 校验字符串是否是一个邮箱(只允许英文字母、数字、下划线、英文句号、以及中划线组成)
     */
    public static boolean isMail(String email) {
        return notNull(email) && email.matches(Regex.email);
    }

    /**
     * 校验字符串是否为手机号格式
     */
    public static boolean isMobile(String mobile) {
        return notNull(mobile) && mobile.matches("^1[3-9]\\d{9}$");
    }

    /**
     * 校验字符串是否为查博士用户序列号
     */
    public static boolean isMobileDisplay(String mobile) {
        return notNull(mobile) && mobile.matches(Regex.mobileDisplay);
    }

    /**
     * 校验字符串是否为查博士用户序列号
     */
    public static boolean isAlias(String mobile) {
        return notNull(mobile) && mobile.matches(Regex.alias);
    }

    /**
     * 校验字符串是否为车架号VIN
     */
    public static boolean isVIN(String vin) {
        return notNull(vin) && vin.matches(Regex.vin);
    }

    /**
     * validity emoji in string
     */
    public static boolean hasEmoji(String value) {
        return notNull(value) && emojiPattern.matcher(value).find();
    }

    /**
     * 校验实体内的所有字段不为空
     * @param t 实体类
     * @return boolean
     */
    public static boolean allNotNull(Object t) {
        List<Field> declaredFields = FieldUtil.getAllField(t);
        for(Field declaredField : declaredFields) {
            try {
                if(declaredField.get(t) == null || declaredField.get(t).toString().trim().equals("")) {
                    return false;
                }
            } catch(IllegalAccessException e) {
                return false;
            }
        }
        return false;
    }

    public static void trimAll(Object t) {
        if(t instanceof Map) {
            ((Map) t).replaceAll((o, o2)->o2 instanceof String ? o2 = o2.toString().trim() : o2);
        } else {
            List<Field> declaredFields = FieldUtil.getAllField(t);
            for(Field field : declaredFields) {
                field.setAccessible(true);
                try {
                    Object o = field.get(t);
                    if(o != null && field.getType().getSimpleName().equals("String")) {
                        field.set(t, o.toString().trim());
                    }
                } catch(Exception e) {
                    log.warn("trim warn : " + t + field.getName());
                }
            }
        }
    }

    public static Boolean isJson(String content) {
        if(!Check.notNull(content)) {
            return false;
        }
        try {
            JSONObject.parseObject(content);
        } catch(JSONException e1) {
            try {
                JSONArray.parseArray(content);
            } catch(JSONException e2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证文件内容是否是图片
     */
    public static Boolean checkFileContent(InputStream inputStream, String fileName) {
        try {
            if(inputStream == null) {
                return false;
            }
            if(Check.notNull(fileName) && !checkFileSuffix(fileName)) {
                return false;
            }
            BufferedImage image = ImageIO.read(inputStream);
            if(image == null) {
                return false;
            }
        } catch(Exception e) {
            log.error("验证图片格式及内容异常", e);
        }
        return true;
    }

    /**
     * 验证文件后缀名是否以图片后缀结尾
     */
    public static Boolean checkFileSuffix(String fileName) {
        Boolean flag = false;
        String[] extensions = { ".jpg", ".png", ".bmp", ".jpeg", ".exif", ".tiff", ".gif" };
        for(int x = 0; x < extensions.length; x++) {
            if(fileName.toLowerCase().endsWith(extensions[x])) {
                flag = true;
            }
        }
        return flag;
    }
}
