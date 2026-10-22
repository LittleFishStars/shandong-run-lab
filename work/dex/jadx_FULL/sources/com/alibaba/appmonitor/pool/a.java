package com.alibaba.appmonitor.pool;

import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23807a = new a();
    private Map<Class<? extends b>, c<? extends b>> J = new HashMap();

    private a() {
    }

    public static a a() {
        return f23807a;
    }

    public <T extends b> T a(Class<T> cls, Object... objArr) throws IllegalAccessException, InstantiationException {
        T tNewInstance = (T) a(cls).a();
        if (tNewInstance == null) {
            try {
                tNewInstance = cls.newInstance();
            } catch (Exception e) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, (Throwable) e);
            }
        }
        if (tNewInstance != null) {
            tNewInstance.fill(objArr);
        }
        return tNewInstance;
    }

    public <T extends b> void a(T t) {
        if (t != null) {
            a(t.getClass()).a(t);
        }
    }

    private synchronized <T extends b> c<T> a(Class<T> cls) {
        c<T> cVar;
        cVar = (c) this.J.get(cls);
        if (cVar == null) {
            cVar = new c<>();
            this.J.put(cls, cVar);
        }
        return cVar;
    }
}
