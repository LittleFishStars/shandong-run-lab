package com.alibaba.ariver.commonability.device.jsapi.wifi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static int a(String str) {
        return a(str, 0);
    }

    public static long b(String str) {
        return a(str, 0L);
    }

    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long a(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
