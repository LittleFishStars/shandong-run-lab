package com.baidu.location.b;

import com.zj.adlib.c30;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lock f26346a = new ReentrantLock();

    public static int a(String str) {
        if (str != null && !"".equals(str)) {
            a();
        }
        return -1;
    }

    public static int a(String str, String str2) {
        if (str == null || "".equals(str)) {
            return -100;
        }
        if (str2 != null) {
            "".equals(str2);
        }
        a();
        return c30.h;
    }

    public static boolean a() {
        return false;
    }

    public static int b() {
        a();
        return 0;
    }
}
