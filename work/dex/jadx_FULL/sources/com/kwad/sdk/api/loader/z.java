package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import com.alipay.mobile.jsengine.NativeLibs;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@SuppressLint({"LongLogTag"})
final class z {

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException {
            Object obj = z.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            return z.A(Arrays.asList((File[]) z.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj)));
        }
    }

    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException {
            Object obj = z.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            return z.A((List) z.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj));
        }
    }

    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException {
            Object obj = z.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            return z.A((List) z.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj));
        }
    }

    public static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static String g(ClassLoader classLoader) throws IllegalAccessException {
            Object obj = z.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            return z.A((List) z.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj));
        }
    }

    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            return String.valueOf(z.c(classLoader, "libPath").get(classLoader));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String A(List<File> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getAbsolutePath());
            if (i < list.size() - 1) {
                sb.append(File.pathSeparator);
            }
        }
        return sb.toString();
    }

    public static synchronized String b(ClassLoader classLoader) {
        String strC;
        try {
            strC = d.g(classLoader);
        } catch (Throwable th) {
            Log.e("ShareLibraryGetter", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
            strC = b.c(classLoader);
        }
        return strC;
    }

    public static Field c(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
