package com.alibaba.alibcwebview.jsbridge;

import android.webkit.ValueCallback;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, ValueCallback<String>> f23729a = new ConcurrentHashMap<>();

    public static ValueCallback<String> a(String str) {
        return f23729a.get(str);
    }

    public static void b(String str) {
        f23729a.remove(str);
    }
}
