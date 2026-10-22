package com.byazt.ka;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 874, 20})
public class c {
    public static final Map<String, InterfaceC0446c> c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.byazt.ka.c$c, reason: collision with other inner class name */
    public interface InterfaceC0446c {
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt(str);
    }

    private static InterfaceC0446c tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.remove(str);
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt(str);
    }
}
