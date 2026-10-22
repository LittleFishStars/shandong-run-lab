package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class vw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45473a = "defaultGson";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, Gson> f20341a = new ConcurrentHashMap();
    public static final String b = "delegateGson";
    public static final String c = "logUtilsGson";

    public vw3() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Gson a() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    public static <T> T b(@NonNull Gson gson, Reader reader, @NonNull Class<T> cls) {
        return (T) gson.fromJson(reader, (Class) cls);
    }

    public static <T> T c(@NonNull Gson gson, Reader reader, @NonNull Type type) {
        return (T) gson.fromJson(reader, type);
    }

    public static <T> T d(@NonNull Gson gson, String str, @NonNull Class<T> cls) {
        return (T) gson.fromJson(str, (Class) cls);
    }

    public static <T> T e(@NonNull Gson gson, String str, @NonNull Type type) {
        return (T) gson.fromJson(str, type);
    }

    public static <T> T f(@NonNull Reader reader, @NonNull Class<T> cls) {
        return (T) b(k(), reader, cls);
    }

    public static <T> T g(@NonNull Reader reader, @NonNull Type type) {
        return (T) c(k(), reader, type);
    }

    public static Type getType(@NonNull Type type, @NonNull Type... typeArr) {
        return TypeToken.getParameterized(type, typeArr).getType();
    }

    public static <T> T h(String str, @NonNull Class<T> cls) {
        return (T) d(k(), str, cls);
    }

    public static <T> T i(String str, @NonNull Type type) {
        return (T) e(k(), str, type);
    }

    public static Type j(@NonNull Type type) {
        return TypeToken.getArray(type).getType();
    }

    public static Gson k() {
        Map<String, Gson> map = f20341a;
        Gson gson = map.get(b);
        if (gson != null) {
            return gson;
        }
        Gson gson2 = map.get(f45473a);
        if (gson2 != null) {
            return gson2;
        }
        Gson gsonA = a();
        map.put(f45473a, gsonA);
        return gsonA;
    }

    public static Gson l(String str) {
        return f20341a.get(str);
    }

    public static Gson m() {
        Map<String, Gson> map = f20341a;
        Gson gson = map.get(c);
        if (gson != null) {
            return gson;
        }
        Gson gsonCreate = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        map.put(c, gsonCreate);
        return gsonCreate;
    }

    public static Type n(@NonNull Type type) {
        return TypeToken.getParameterized(List.class, type).getType();
    }

    public static Type o(@NonNull Type type, @NonNull Type type2) {
        return TypeToken.getParameterized(Map.class, type, type2).getType();
    }

    public static Type p(@NonNull Type type) {
        return TypeToken.getParameterized(Set.class, type).getType();
    }

    public static void q(String str, Gson gson) {
        if (TextUtils.isEmpty(str) || gson == null) {
            return;
        }
        f20341a.put(str, gson);
    }

    public static void r(Gson gson) {
        if (gson == null) {
            return;
        }
        f20341a.put(b, gson);
    }

    public static String s(@NonNull Gson gson, Object obj) {
        return gson.toJson(obj);
    }

    public static String t(@NonNull Gson gson, Object obj, @NonNull Type type) {
        return gson.toJson(obj, type);
    }

    public static String u(Object obj) {
        return s(k(), obj);
    }

    public static String v(Object obj, @NonNull Type type) {
        return t(k(), obj, type);
    }
}
