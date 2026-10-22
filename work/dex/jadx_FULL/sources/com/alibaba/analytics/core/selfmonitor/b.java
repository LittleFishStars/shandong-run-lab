package com.alibaba.analytics.core.selfmonitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f23783a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f655a;
    private List<c> e = Collections.synchronizedList(new ArrayList());

    public static b a() {
        return f23783a;
    }

    public void init() {
        this.f655a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        for (int i = 0; i < this.e.size(); i++) {
            try {
                this.e.get(i).a(thread, th);
            } catch (Throwable unused) {
                uncaughtExceptionHandler = this.f655a;
                if (uncaughtExceptionHandler == null) {
                    return;
                }
            }
        }
        uncaughtExceptionHandler = this.f655a;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public void a(c cVar) {
        this.e.add(cVar);
    }
}
