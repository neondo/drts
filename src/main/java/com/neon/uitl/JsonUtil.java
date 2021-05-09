package com.neon.uitl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>json util base on crm business</p>
 * @author Neon
 * @date 2018/11/23 18:43
 * according to {@link JSON}
 */
public class JsonUtil{

    /**
     * handler some nested json incident ESC character delete it in transfer{@code toJsonString}
     * @param o source
     * @return { String}
     */
    public static String toJsonString(Object o) {
        if(o == null)
            return null;
        return JSON.toJSONString(o, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect).replaceAll("\"\\[", "[").replaceAll("]\"", "]")
                .replaceAll("\"\\{", "{").replaceAll("}\"", "}").replaceAll("\\\\\"", "\"")
                .replaceAll("\\\\r|\\\\n|\\\\t|\\\\", "");
    }

    public static JSONObject toJson(String str) {
        if(!Check.notNull(str))
            return new JSONObject();
        try {
            return JSON.parseObject(str);
        } catch(Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public static JSONObject objectToJson(Object o) {
        if(o == null) return new JSONObject();
        return JsonUtil.toJson(JsonUtil.toJsonString(o));
    }

    public static <T> List<T> toList(Object value, Class<T> clazz) {
        JSONArray array = null;
        if(value instanceof JSONArray) {
            array = (JSONArray) value;
        } else {
            try {
                array = value instanceof String ? (JSONArray) JSON.parse((String) value) : (JSONArray) JSON.toJSON(value);
            } catch(Exception e) {
                try {
                    T cast = TypeUtils.cast(value, clazz, ParserConfig.getGlobalInstance());
                    if(cast != null) return new ArrayList<T>(Collections.singleton(cast));
                } catch(Exception e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
        return array != null ? array.toJavaList(clazz) : new ArrayList<T>();
    }

    public static JSONArray toArray(Object value) {
        JSONArray array;
        if(value instanceof JSONArray) {
            array = (JSONArray) value;
        } else {
            try {
                array = value instanceof String ? (JSONArray) JSON.parse((String) value) : (JSONArray) JSON.toJSON(value);
            } catch(Exception e) {
                array = new JSONArray();
                array.add(value);
                e.printStackTrace();
            }
        }
        return array == null ? new JSONArray() : array;
    }

    public static String addJsonStr(Object o, Object... param) {
        if(param == null)
            return toJsonString(o);
        if(param.length % 2 != 0)
            throw new OperateException("params number must be odd but just find " + param.length);
        JSONObject jsonObject = objectToJson(o);
        for(int i = 0; i < param.length; i++) jsonObject.put(param[i].toString(), param[++i]);
        return toJsonString(jsonObject);
    }

    public static String addArrStr(Object o, Object... param) {
        if(param == null) return toJsonString(o);
        JSONArray jsonArr = toArray(o);
        IntStream.range(0, param.length).forEachOrdered(i->jsonArr.add(param[i]));
        return toJsonString(jsonArr);
    }

    public static <T> T getObject(JSONObject content, String key, Class<T> clazz) {
        Object o = content.get(key);
        if(o == null) return null;
        if(clazz.isAssignableFrom(o.getClass())) return (T) o;
        if(o instanceof String) JSON.parseObject(o.toString(), clazz);
        return (T) o;
    }
}
