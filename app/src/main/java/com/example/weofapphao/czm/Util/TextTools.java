/*
 * TextUtils.java
 * classes : com.baidu.netdisk.util.TextUtils
 * @author weizhengzheng
 * V 1.0.0
 * Create at 2014年3月22日 下午6:28:07
 */
package com.example.weofapphao.czm.Util;

import android.content.Context;
import android.text.ClipboardManager;

import java.util.Random;

/**
 * com.baidu.netdisk.util.TextUtils
 *
 * @author weizhengzheng <br/>
 *         create at 2014年3月22日 下午6:28:07
 */
public class TextTools {

    /**
     * 计算字符串的长度.
     *
     * @param src 需要计算的字符串
     * @return -1 表示输入的src是null值
     */
    public static int fetchCharNumber(String src) {
        int counter = -1;
        if (src != null) {
            counter = 0;
            final int len = src.length();
            for (int i = 0; i < len; i++) {
                char sigleItem = src.charAt(i);
                if (isAlphanumeric(sigleItem)) {
                    counter++;
                } else if (Character.isLetter(sigleItem)) {
                    counter = counter + 2;
                } else {
                    counter++;
                }
            }
        } else {
            counter = -1;
        }
        return counter;
    }

    public static String cutCharByNumber(String src, int length) {
        StringBuffer sb = new StringBuffer();
        int counter = -1;
        counter = 0;
        final int len = src.length();
        for (int i = 0; i < len; i++) {
            char sigleItem = src.charAt(i);
            if (isAlphanumeric(sigleItem)) {
                counter++;
            } else if (Character.isLetter(sigleItem)) {
                counter = counter + 2;
            } else {
                counter++;
            }
            if (counter <= length) {
                sb.append(sigleItem);
            }
        }

        return sb.toString();
    }

    /**
     * 判断字符是否为英文字母或者阿拉伯数字.
     *
     * @param ch char字符
     * @return true or false
     */
    public static boolean isAlphanumeric(char ch) {
        // 常量定义
        final int DIGITAL_ZERO = '0';
        final int DIGITAL_NINE = '9';
        final char MIN_LOWERCASE = 'a';
        final char MAX_LOWERCASE = 'z';
        final char MIN_UPPERCASE = 'A';
        final char MAX_UPPERCASE = 'Z';

        if ((ch >= DIGITAL_ZERO && ch <= DIGITAL_NINE) || (ch >= MIN_LOWERCASE && ch <= MAX_LOWERCASE)
                || (ch >= MIN_UPPERCASE && ch <= MAX_UPPERCASE)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 复制内容到剪切板
     *
     * @param text
     * @param context
     */
    public static void setClipboard(String text, Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            clipboard.setText(text);
        }
    }

    /**
     * 从剪贴板取出内容
     *
     * @param context
     * @return
     */
    public static CharSequence getCharSequenceFromClipboard(Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        return clipboard.getText();
    }

    /**
     * 生成4位字母（小写）和数字的组合随机数
     */
    public static String getRandomString() {
        long timeSeed = System.currentTimeMillis();
        Random ran2 = new Random(timeSeed);
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = ran2.nextInt(36);
            if (index < 10) {
                sbBuilder.append(String.valueOf(index));
            } else {
                sbBuilder.append(String.valueOf((char) (87 + index)));
            }
        }
        return sbBuilder.toString();
    }

    /**
     * 字符串拼接
     *
     * @param delimiter
     * @param tokens
     * @return
     */
    public static String joinString(CharSequence delimiter, long[] tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (long token : tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(String.valueOf(token));
        }
        return sb.toString();
    }
}
