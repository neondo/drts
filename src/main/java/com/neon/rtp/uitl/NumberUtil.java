package com.neon.rtp.uitl;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 数字处理工具
 * @author Neon
 * @since 2018/5/23 9:51
 */
public class NumberUtil{

    public static final List<String> NUM_TYPE = Arrays
            .asList("Byte", "byte", "Integer", "int", "Float", "float", "Double", "double", "Long", "long", "Short", "short",
                    "BigDecimal");

    /**
     * 保留小数位
     * @param num 原始数字
     * @param len 小数位长度
     * @return double
     */
    public static Double format(Double num, int len) {
        num = num == null ? 0D : num;
        return BigDecimal.valueOf(num).setScale(len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两数字相除,保留小数位
     * @param n   除数
     * @param len 小数位数长度
     * @return Double
     */
    public static Double divide(int len, Number... n) {
        if(n == null || n.length == 0)
            return 0D;
        Double v = null;
        for(int i = 0; i < n.length; i++) {
            Number number = n[i];
            if(number == null) return 0D;
            double v1 = number.doubleValue();
            if(v1 == 0) return 0D;
            if(i == 0) v = v1;
            else v = v / v1;
        }
        return format(v, len);
    }

    /**
     * 两数字相乘,保留小数位
     * @param n   乘数
     * @param len 小数位数长度
     * @return Double
     */
    public static Double multiply(int len, Number... n) {
        if(n == null || n.length == 0)
            return 0D;
        Double v = null;
        for(int i = 0; i < n.length; i++) {
            Number number = n[i];
            if(number == null) return 0D;
            double v1 = number.doubleValue();
            if(v1 == 0) return 0D;
            if(i == 0) v = v1;
            else v = v * v1;
        }
        return format(v, len);
    }

    /**
     * 两数相加,排除空指针
     * @return double
     */

    public static Integer add(Integer... n) {
        if(n == null || n.length == 0)
            return 0;
        return Arrays.stream(n).filter(Objects::nonNull).mapToInt(num->num).sum();
    }

    public static Long add(Long... n) {
        if(n == null || n.length == 0)
            return 0L;
        return Arrays.stream(n).filter(Objects::nonNull).mapToLong(num->num).sum();
    }

    public static Double add(Double... n) {
        if(n == null || n.length == 0)
            return 0D;
        return Arrays.stream(n).filter(Objects::nonNull).mapToDouble(num->num).sum();
    }

    public static BigDecimal add(int len, BigDecimal... n) {
        if(n == null || n.length == 0)
            return BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal num : n) if(num != null) sum = sum.add(num);
        return sum.setScale(len, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 两数相加,排除空指针
     * @param n 减数
     * @return double
     */

    public static Integer subtract(Integer... n) {
        if(n == null || n.length == 0)
            return 0;
        if(n[0] == null) n[0] = 0;
        return n[0] - Arrays.stream(n, 1, n.length).filter(Objects::nonNull).mapToInt(num->num).sum();
    }

    public static BigDecimal subtract(int len, BigDecimal... n) {
        if(n == null || n.length == 0) return BigDecimal.ZERO;
        BigDecimal sum = n[0] == null ? BigDecimal.ZERO : n[0];
        int i = 1;
        while(i < n.length) {
            BigDecimal num = n[i];
            if(num != null) sum = sum.subtract(num);
            i++;
        }
        return sum.setScale(len, BigDecimal.ROUND_HALF_UP);
    }

    public static long subtract(Long... n) {
        if(n == null || n.length == 0)
            return 0L;
        if(n[0] == null) n[0] = 0L;
        return n[0] - Arrays.stream(n, 1, n.length).filter(Objects::nonNull).mapToLong(num->num).sum();
    }

    public static double subtract(Double... n) {
        if(n == null || n.length == 0)
            return 0D;
        if(n[0] == null) n[0] = 0D;
        return n[0] - Arrays.stream(n, 1, n.length).filter(Objects::nonNull).mapToDouble(num->num).sum();
    }

    public static boolean isNumeric(String str) {
        return NumberUtils.isParsable(str);
    }

    public static <T> T transfer2numberType(String value, Class<T> clazz) {
        return BeanUtils.cast(value, clazz);
    }

    public static <T> T dealNull(T t, T defaultV) {
        return t != null ? t : defaultV;
    }

    /**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k     选取的元素个数
     * @param arr   数组
     */
    public static List<String> combine(int index, int k, int[] arr) {
        List<String> result = new ArrayList<>();
        combineAction(index, k, arr, new ArrayList<Integer>(), result);
        return result;
    }

    /**
     * 排列
     * 按照无序（随机）的方式取出元素，就是排列,元素个数[A arr.len 3]
     * @param k   选取的元素个数
     * @param arr 数组
     */

    public static List<String> arrange(int k, int[] arr) {
        List<String> result = new ArrayList<>();
        arrangement(k, arr, new ArrayList<>(), result);
        return result;
    }

    private static void combineAction(int index, int k, int[] arr, List<Integer> tmpArr, List<String> result) {
        if(k == 1) {
            for(int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                result.add(tmpArr.toString().replaceAll("[\\[\\] ]", ""));
                tmpArr.remove((Object) arr[i]);
            }
        } else if(k > 1) {
            for(int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combineAction(i + 1, k - 1, arr, tmpArr, result); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object) arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }
    }

    private static void arrangement(int k, int[] arr, List<Integer> tmpArr, List<String> result) {
        if(k == 1) {
            Arrays.stream(arr).forEachOrdered(j->{
                tmpArr.add(j);
                result.add(tmpArr.toString().replaceAll("[\\[\\] ]", ""));
                tmpArr.remove((Object) j);
            });
        } else if(k > 1) {
            Arrays.stream(arr).forEachOrdered(j->{
                tmpArr.add(j); //添加选到的元素
                arrangement(k - 1, removeArrayElements(arr, tmpArr.toArray(new Integer[1])), tmpArr, result); //没有取过的元素，继续挑选
                tmpArr.remove((Object) j);
            });
        }
    }

    /**
     * 移除数组某些元素（不影响原数组）
     * @param arr      数组
     * @param elements 待移除的元素
     * @return 剩余元素组成的新数组
     */
    private static int[] removeArrayElements(int[] arr, Integer... elements) {
        List<Integer> remainList = Arrays.stream(arr).filter(k->Arrays.stream(elements).noneMatch(element->k == element)).boxed()
                .collect(Collectors.toCollection(()->new ArrayList<>(arr.length)));
        return remainList.stream().mapToInt(integer->integer).toArray();
    }
}
