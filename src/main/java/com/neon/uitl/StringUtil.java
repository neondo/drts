package com.neon.uitl;





import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringUtil{

    public final static String oblique = "/", line = "-", underline = "_", empty = "", blank = " ", comma = ",", dot = ".", pound_sign = "#", comma_cn = "，", quota_single = "'", quota_double = "\"", semicolon = ";",
            semicolon_cn = "；", colon = ":", colon_cn = "：", asterisk = "*", caesura = "、", brackets_left = "(", brackets_right = ")", square_brackets_left = "[", square_brackets_right = "]", braces_left = "{", braces_right = "}";

    private static final String UTF_8_ANSI_CODE = new String(new byte[] { (byte) 0xC2, (byte) 0xA0 }, StandardCharsets.UTF_8);

    /**
     * 包装Excel单元格值,防止出现因为空值出现null和错位
     * @param arr cell value
     * @return String
     */
    public static String handlerCell(Object... arr) {
        if(arr == null) {
            return StringUtil.line;
        }
        return Arrays.stream(arr).map(temp->StringUtil.oblique + (Check.notNull(String.valueOf(temp)) ? temp : StringUtil.line))
                .collect(Collectors.joining()).replaceFirst(StringUtil.oblique, StringUtil.empty);
    }

    /**
     * Remind ! this method is deleted string space anywhere
     * @param c collection
     */
    public static String toArrStr(Collection<?> c) {
        if(Check.notNull(c)) {
            String s = c.toString();
            return s.substring(1, s.length() - 1);
        }
        else {
            return StringUtil.empty;
        }
    }

    public static String concat_(Object... o) {
        return concat(StringUtil.underline, o);
    }

    public static String concat(String sign, Object... o) {
        String str = Arrays.stream(o).filter(Objects::nonNull).map(temp->sign + temp).collect(Collectors.joining());
        return str.replaceFirst(sign, empty);
    }

    public static String concatLine(Object... o) {
        return concat(StringUtil.line, o);
    }

    public static String dealNull(String o) {
        return dealNull(o, StringUtil.empty);
    }

    public static String dealNull(String o, String defaultV) {
        return o != null ? o : defaultV;
    }

    public static String toString(Object o) {
        return o != null ? o.toString() : empty;
    }

    /**
     * @param str 去除ANSI乱码
     */
    public static String replaceAnsiCode(String str) {
        return str == null ? str : str.replaceAll(UTF_8_ANSI_CODE, blank);
    }

    public static <T> List<T> toList(String ids, Class<T> clazz) {
        return Arrays.stream(ids.split(StringUtil.comma)).filter(Check::isNumber).map(s->BeanUtils.cast(s, clazz)).collect(Collectors.toList());
    }

    public static List<String> splitLine(String u) {
        return split(u, StringUtil.line);
    }

    public static List<String> split(String u, String sign) {
        return u == null ? null : CollectUtil.asList(u.split(sign));
    }

    public static List<String> split_(String u) {
        return split(u, StringUtil.underline);
    }

    public static List<String> splitComma(String u) {
        return split(u, StringUtil.comma);
    }
}
