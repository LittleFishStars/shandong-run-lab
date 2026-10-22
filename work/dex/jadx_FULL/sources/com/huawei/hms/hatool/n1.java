package com.huawei.hms.hatool;

import android.util.Pair;
import com.zj.adlib.c49;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class n1 {
    public static long a(String str, long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j))).getTime();
        } catch (ParseException unused) {
            v.f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static Pair<String, String> a(String str) {
        String strSubstring;
        String str2;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] strArrSplit = str.split(c49.f40900a);
        if (strArrSplit.length > 2) {
            str2 = strArrSplit[strArrSplit.length - 1];
            strSubstring = str.substring(0, (str.length() - str2.length()) - 1);
        } else {
            strSubstring = strArrSplit[0];
            str2 = strArrSplit[1];
        }
        return new Pair<>(strSubstring, str2);
    }

    public static String a(int i) {
        if (i == 0) {
            return "oper";
        }
        if (i == 1) {
            return "maint";
        }
        if (i != 2) {
            return i != 3 ? "alltype" : "diffprivacy";
        }
        return "preins";
    }

    public static String a(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + c49.f40900a + str2;
    }

    public static String a(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + c49.f40900a + str2 + "#" + str3;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                String str2 = str + c49.f40900a + "oper";
                String str3 = str + c49.f40900a + "maint";
                String str4 = str + c49.f40900a + "diffprivacy";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str4);
            }
        }
        return hashSet;
    }
}
