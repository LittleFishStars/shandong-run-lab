package com.alibaba.triver.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LruCache<String, Drawable> f25267a = new LruCache<>(1);

    public static void a(String str, Drawable drawable) {
        if (TextUtils.isEmpty(str) || drawable == null || CommonUtils.closePreloadBrandZone()) {
            return;
        }
        f25267a.put(str, drawable);
    }

    public static Drawable a(String str) {
        if (TextUtils.isEmpty(str) || CommonUtils.closePreloadBrandZone()) {
            return null;
        }
        return f25267a.get(str);
    }
}
