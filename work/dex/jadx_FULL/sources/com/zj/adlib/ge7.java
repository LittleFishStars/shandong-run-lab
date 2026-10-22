package com.zj.adlib;

import androidx.collection.SimpleArrayMap;
import androidx.room.RoomMasterTable;
import com.blankj.utilcode.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ge7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, String> f41884a = new SimpleArrayMap<>();

    public ge7() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a(String str) {
        return str.substring(str.lastIndexOf("@") + 1);
    }

    public static String b(String str) {
        return str.substring(0, str.lastIndexOf("@"));
    }

    public static List<String> c(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static String d(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceAll(str3);
    }

    public static String e(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceFirst(str3);
    }

    public static String[] f(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean g(CharSequence charSequence) {
        return o(ee7.j, charSequence);
    }

    public static boolean h(CharSequence charSequence) {
        return o(ee7.f, charSequence);
    }

    public static boolean i(String str, String[] strArr) {
        return ArrayUtils.V(strArr, a(str));
    }

    public static boolean j(String str, String str2) {
        return a(str).equalsIgnoreCase(str2);
    }

    public static boolean k(CharSequence charSequence) {
        return o(ee7.d, charSequence);
    }

    public static boolean l(CharSequence charSequence) {
        return o(ee7.e, charSequence);
    }

    public static boolean m(CharSequence charSequence) {
        if (!l(charSequence)) {
            return false;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        SimpleArrayMap<String, String> simpleArrayMap = f41884a;
        if (simpleArrayMap.isEmpty()) {
            simpleArrayMap.put("11", "北京");
            simpleArrayMap.put("12", "天津");
            simpleArrayMap.put("13", "河北");
            simpleArrayMap.put("14", "山西");
            simpleArrayMap.put("15", "内蒙古");
            simpleArrayMap.put("21", "辽宁");
            simpleArrayMap.put("22", "吉林");
            simpleArrayMap.put("23", "黑龙江");
            simpleArrayMap.put("31", "上海");
            simpleArrayMap.put("32", "江苏");
            simpleArrayMap.put("33", "浙江");
            simpleArrayMap.put("34", "安徽");
            simpleArrayMap.put("35", "福建");
            simpleArrayMap.put("36", "江西");
            simpleArrayMap.put("37", "山东");
            simpleArrayMap.put("41", "河南");
            simpleArrayMap.put(RoomMasterTable.DEFAULT_ID, "湖北");
            simpleArrayMap.put("43", "湖南");
            simpleArrayMap.put("44", "广东");
            simpleArrayMap.put("45", "广西");
            simpleArrayMap.put("46", "海南");
            simpleArrayMap.put("50", "重庆");
            simpleArrayMap.put("51", "四川");
            simpleArrayMap.put("52", "贵州");
            simpleArrayMap.put("53", "云南");
            simpleArrayMap.put("54", "西藏");
            simpleArrayMap.put("61", "陕西");
            simpleArrayMap.put("62", "甘肃");
            simpleArrayMap.put("63", "青海");
            simpleArrayMap.put("64", "宁夏");
            simpleArrayMap.put("65", "新疆");
            simpleArrayMap.put("71", "台湾老");
            simpleArrayMap.put("81", "香港");
            simpleArrayMap.put("82", "澳门");
            simpleArrayMap.put("83", "台湾新");
            simpleArrayMap.put("91", "国外");
        }
        if (simpleArrayMap.get(charSequence.subSequence(0, 2).toString()) == null) {
            return false;
        }
        int iCharAt = 0;
        for (int i = 0; i < 17; i++) {
            iCharAt += (charSequence.charAt(i) - '0') * iArr[i];
        }
        return charSequence.charAt(17) == cArr[iCharAt % 11];
    }

    public static boolean n(CharSequence charSequence) {
        return o(ee7.k, charSequence);
    }

    public static boolean o(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static boolean p(CharSequence charSequence) {
        return q(charSequence, null);
    }

    public static boolean q(CharSequence charSequence, List<String> list) {
        if (o(ee7.b, charSequence)) {
            return true;
        }
        if (list != null && charSequence != null && charSequence.length() == 11) {
            String string = charSequence.toString();
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (string.startsWith(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean r(CharSequence charSequence) {
        return o(ee7.f41417a, charSequence);
    }

    public static boolean s(CharSequence charSequence) {
        return o(ee7.c, charSequence);
    }

    public static boolean t(CharSequence charSequence) {
        return o(ee7.g, charSequence);
    }

    public static boolean u(CharSequence charSequence) {
        return o(ee7.i, charSequence);
    }

    public static boolean v(CharSequence charSequence) {
        return o(ee7.h, charSequence);
    }
}
