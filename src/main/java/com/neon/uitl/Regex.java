package com.neon.uitl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Neon
 */
public class Regex{

    public static final String mobile = "1[3|4|5|6|7|8|9]\\d{9}";

    public static final String alias = "\\d{8}";

    public static final String vin = "(?!^\\d+$)(?!^[a-zA-Z]+$)[A-HJ-NPR-Z0-9]{13}[\\d]{4}";

    public static final String email = "[a-zA-Z0-9._-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";

    public static final String decimal = "[+-]?\\d+(\\.\\d+)?";

    public static final String number = "-?[0-9]\\d*";

    public static final String emoji = "(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)";

    public static final String mobileDisplay = "\\d{9}";

    private static final Map<String, Pattern> patternMap = new ConcurrentHashMap<>();

    private static Pattern getPattern(String reg) {
        return patternMap.computeIfAbsent(reg, s->Pattern.compile(reg));
    }

    /**
     * find first match value
     */
    public static String find(String reg, String value) {
        Matcher matcher = getPattern(reg).matcher(value);
        if(matcher.find())
            return matcher.group();
        return null;
    }

    /**
     * find all match values
     */
    public static List<String> findAll(String reg, String value) {
        Matcher matcher = getPattern(reg).matcher(value);
        List<String> list = new ArrayList<>();
        while(matcher.find())
            list.add(matcher.group());
        return list;
    }
}
