package com.aliyun.darabonbanumber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public static Long add(Long l, Long l2) throws Exception {
        return Long.valueOf(l.longValue() + l2.longValue());
    }

    public static Double div(Long l, Long l2) throws Exception {
        return Double.valueOf(l.longValue() / l2.longValue());
    }

    public static Boolean gt(Long l, Long l2) throws Exception {
        return Boolean.valueOf(l.longValue() > l2.longValue());
    }

    public static Boolean gte(Long l, Long l2) throws Exception {
        return Boolean.valueOf(l.longValue() >= l2.longValue());
    }

    public static Long itol(Integer num) throws Exception {
        return Long.valueOf(num.longValue());
    }

    public static Boolean lt(Long l, Long l2) throws Exception {
        return Boolean.valueOf(l.longValue() < l2.longValue());
    }

    public static Boolean lte(Long l, Long l2) throws Exception {
        return Boolean.valueOf(l.longValue() <= l2.longValue());
    }

    public static Integer ltoi(Long l) throws Exception {
        return Integer.valueOf(l.intValue());
    }

    public static Long mul(Long l, Long l2) throws Exception {
        return Long.valueOf(l.longValue() * l2.longValue());
    }

    public static Double parseDouble(String str) throws Exception {
        return Double.valueOf(Double.parseDouble(str));
    }

    public static Float parseFloat(String str) throws Exception {
        return Float.valueOf(Float.parseFloat(str));
    }

    public static Integer parseInt(String str) throws Exception {
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static Long parseLong(String str) throws Exception {
        return Long.valueOf(Long.parseLong(str));
    }

    public static Long sub(Long l, Long l2) throws Exception {
        return Long.valueOf(l.longValue() - l2.longValue());
    }
}
