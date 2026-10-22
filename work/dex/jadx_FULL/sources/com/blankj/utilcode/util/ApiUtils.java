package com.blankj.utilcode.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ApiUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28117a = "ApiUtils";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<Class, a> f1242a;
    public Map<Class, Class> b;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface Api {
        boolean isMock() default false;
    }

    public static class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ApiUtils f28118a = new ApiUtils();
    }

    public ApiUtils() {
        this.f1242a = new ConcurrentHashMap();
        this.b = new HashMap();
        d();
    }

    @Nullable
    public static <T extends a> T a(@NonNull Class<T> cls) {
        return (T) c().b(cls);
    }

    public static ApiUtils c() {
        return b.f28118a;
    }

    public static void e(@Nullable Class<? extends a> cls) {
        if (cls == null) {
            return;
        }
        c().f(cls);
    }

    @NonNull
    public static String g() {
        return c().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Result> Result b(Class cls) {
        Result result = (Result) ((a) this.f1242a.get(cls));
        if (result != null) {
            return result;
        }
        synchronized (cls) {
            Result result2 = (Result) ((a) this.f1242a.get(cls));
            if (result2 != null) {
                return result2;
            }
            Class cls2 = this.b.get(cls);
            if (cls2 == null) {
                Log.e(f28117a, "The <" + cls + "> doesn't implement.");
                return null;
            }
            try {
                Result result3 = (Result) ((a) cls2.newInstance());
                this.f1242a.put(cls, (a) result3);
                return result3;
            } catch (Exception unused) {
                Log.e(f28117a, "The <" + cls2 + "> has no parameterless constructor.");
                return null;
            }
        }
    }

    public final void d() {
    }

    public final void f(Class cls) {
        this.b.put(cls.getSuperclass(), cls);
    }

    public String toString() {
        return "ApiUtils: " + this.b;
    }
}
