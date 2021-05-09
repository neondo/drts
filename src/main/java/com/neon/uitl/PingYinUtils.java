package com.neon.uitl;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Admin
 */
public class PingYinUtils{

    private static final Logger logger = LoggerFactory.getLogger(PingYinUtils.class);

    /**
     * 获取汉字串拼音首字母，英文字符不变
     * @param str 汉字串
     * @return 汉语拼音首字母
     */
    public static String cn2FirstSpell(String str) {
        String convert = "";
        for(int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if(pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            }
            else {
                convert += word;
            }
        }
        return convert;
    }

    /**
     * 获取汉字串拼音大写首字母，英文字符不变
     * @param str 汉字串
     * @return 汉语拼音首字母
     */
    public static String cn2FirstUpperSpell(String str) {
        String convert = "";
        for(int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if(pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            }
            else {
                convert += word;
            }
        }
        return convert.toUpperCase();
    }

    /**
     * 获取汉字串拼音，英文字符不变
     * @param src 汉字串
     * @return 汉语拼音
     */
    public static String cn2Spell(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for(int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if(Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    if(t2 == null) {
                        t2 = new String[t1.length];
                    }
                    t4 += t2[0];
                }
                else {
                    t4 += Character.toString(t1[i]);
                }
            }
            return t4;
        } catch(BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    // 将字符串转移为ASCII码
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for(int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变
     * @param chinese 汉字串
     * @return 汉语拼音首字母
     */
    public static String getFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if(temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch(BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }
            else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }

    /**
     * 获取汉字串拼音，英文字符不变
     * @param chinese 汉字串
     * @return 汉语拼音
     */
    public static String getFullSpell(String chinese) {
        try {
            StringBuilder pybf = new StringBuilder();
            if(chinese.contains("·")) {
                int indexOf = chinese.indexOf('·');
                chinese = chinese.substring(0, indexOf) + chinese.substring(indexOf + 1);
            }
            char[] arr = chinese.toCharArray();
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            for(char c : arr) {
                if(c > 128) {
                    pybf.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0]);
                }
                else {
                    pybf.append(c);
                }
            }
            return pybf.toString();
        } catch(Exception e) {
            // e.printStackTrace();
            logger.error("Exception:" + e.toString() + "chinese:" + chinese);
            return "A";
        }
    }
}
