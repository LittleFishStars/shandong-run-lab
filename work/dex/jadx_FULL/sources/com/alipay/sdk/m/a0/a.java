package com.alipay.sdk.m.a0;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25382a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> g;
    public static ExecutorService h = Executors.newFixedThreadPool(16);

    /* JADX INFO: renamed from: com.alipay.sdk.m.a0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0185a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i, Object obj) {
        if (g == null) {
            g = new ConcurrentHashMap<>();
        }
        g.put(Integer.valueOf(i), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
    }

    public static Pair<Boolean, ?> a(int i, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        Object obj = pair.second;
        if (l != null && SystemClock.elapsedRealtime() - l.longValue() <= TimeUnit.MILLISECONDS.convert(j, timeUnit)) {
            return new Pair<>(Boolean.TRUE, obj);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    public static synchronized void a() {
        g = null;
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i, long j, TimeUnit timeUnit, InterfaceC0185a<Object, Boolean> interfaceC0185a, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, com.alipay.sdk.m.w.a aVar, boolean z2) {
        T tCall;
        try {
            Pair<Boolean, ?> pairA = a(i, timeUnit, j);
            if (((Boolean) pairA.first).booleanValue() && interfaceC0185a.a(pairA.second).booleanValue()) {
                g.d("getC", i + " got " + pairA.second);
                return (T) pairA.second;
            }
            if (z2 && q.h()) {
                com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "ch_get_main", "" + i);
                g.d("getC", i + " skip");
                tCall = null;
            } else {
                if (z) {
                    tCall = h.submit(callable).get(j2, timeUnit2);
                } else {
                    tCall = callable.call();
                }
                a(i, tCall);
            }
            g.d("getC", i + " new " + tCall);
            return tCall;
        } catch (Throwable th) {
            g.a(f25382a, "ch_get_e|" + i, th);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "ch_get_e|" + i, th);
            g.d("getC", i + " err");
            return null;
        }
    }
}
