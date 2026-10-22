package com.baidu.location.e.a;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Object> f26447a = new ConcurrentHashMap();
    private Handler b;

    /* JADX INFO: renamed from: com.baidu.location.e.a.a$a, reason: collision with other inner class name */
    public static class C0265a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f26448a = new a();
    }

    public static a a() {
        return C0265a.f26448a;
    }

    public void b() {
        this.b = new Handler();
    }
}
