package com.alipay.sdk.m.f0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f25435a = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25436a;
        public long b;
        public long c;
    }

    public static String a(String str) {
        Map<String, a> map;
        a aVar;
        String str2;
        if (str == null || (map = f25435a) == null || (aVar = map.get(str)) == null) {
            return null;
        }
        if (a(aVar.b, aVar.c) && (str2 = aVar.f25436a) != null) {
            return str2;
        }
        map.remove(str);
        return null;
    }

    public static void a(String str, String str2) {
        a(str, str2, 86400000L);
    }

    public static void a(String str, String str2, long j) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (j == 0) {
            j = 86400000;
        }
        Map<String, a> map = f25435a;
        a aVar = map.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.f25436a = str2;
        aVar.c = j;
        aVar.b = System.currentTimeMillis();
        map.put(str, aVar);
    }

    public static boolean a(long j, long j2) {
        return System.currentTimeMillis() - j < j2;
    }
}
