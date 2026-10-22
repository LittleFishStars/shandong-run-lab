package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
final class g {
    private static final List<String> aIc;

    public static class a extends DexClassLoader {
        private final ClassLoader aId;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.aId = classLoader;
            classLoader.getClass();
        }

        private static boolean da(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("com.kwad.sdk.api") || str.startsWith("com.kwad.sdk.liteapi");
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            Set<String> set;
            if (da(str)) {
                return getParent().loadClass(str);
            }
            Class<?> clsFindLoadedClass = findLoadedClass(str);
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = super.loadClass(str, z);
            } catch (ClassNotFoundException unused2) {
            }
            if (clsFindLoadedClass != null) {
                return clsFindLoadedClass;
            }
            try {
                clsFindLoadedClass = getParent().loadClass(str);
            } catch (ClassNotFoundException unused3) {
            }
            if (clsFindLoadedClass == null && (set = com.kwad.sdk.api.c.aHB) != null && set.contains(str)) {
                throw new ClassNotFoundException(str);
            }
            return clsFindLoadedClass;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        aIc = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (b.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
