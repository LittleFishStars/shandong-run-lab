package com.alipay.mobile.jsengine;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativeLibs {
    public static final String CLASS_DALVIK_SYSTEM_BASE_DEX_CLASS_LOADER = "dalvik.system.BaseDexClassLoader";
    public static final String FIELD_LIBRARY_PATH_ELEMENTS = "libraryPathElements";
    public static final String FIELD_NATIVE_LIBRARY_DIRECTORIES = "nativeLibraryDirectories";
    public static final String FIELD_NATIVE_LIBRARY_PATH_ELEMENTS = "nativeLibraryPathElements";
    public static final String FIELD_PATH_LIST = "pathList";
    public static final String METHOD_MAKE_PATH_ELEMENTS = "makePathElements";
    public static final String METHOD_SPLIT_PATHS = "splitPaths";
    public static final String TAG = "NativeLibs";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25358a = "plugins_lib";

    private static Field a(String str, Class<?> cls, String str2) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null) {
                return a(str, superclass, str2);
            }
            throw new NoSuchFieldException(str + Consts.DOT + str2);
        }
    }

    public static void addExtraNativeLibraryDirectories(Delegate delegate, Context context, ClassLoader classLoader) {
        try {
            File dir = context.getDir(f25358a, 0);
            Object field = ReflectUtils.getField(Class.forName(CLASS_DALVIK_SYSTEM_BASE_DEX_CLASS_LOADER), FIELD_PATH_LIST, classLoader);
            Class<?> cls = field.getClass();
            List<File> list = (List) ReflectUtils.getField(cls, FIELD_NATIVE_LIBRARY_DIRECTORIES, field);
            for (File file : list) {
                if (file.getAbsolutePath().contains(f25358a)) {
                    delegate.w(TAG, file.getAbsolutePath() + " already contains: " + f25358a);
                    return;
                }
            }
            list.add(0, dir);
            List list2 = (List) ReflectUtils.invokeMethod(cls, METHOD_SPLIT_PATHS, new Class[]{String.class, Boolean.TYPE}, new Object[]{System.getProperty("java.library.path"), Boolean.TRUE});
            ArrayList arrayList = new ArrayList();
            list2.addAll(0, list);
            Object objInvokeMethod = ReflectUtils.invokeMethod(cls, METHOD_MAKE_PATH_ELEMENTS, new Class[]{List.class, File.class, List.class}, new Object[]{list2, null, arrayList});
            if (arrayList.isEmpty()) {
                setFieldValue(cls, field, FIELD_NATIVE_LIBRARY_PATH_ELEMENTS, objInvokeMethod);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                delegate.e(TAG, "suppressedException-", (IOException) it.next());
            }
        } catch (Throwable th) {
            delegate.e(TAG, "addExtraNativeLibraryDirectories", th);
        }
    }

    public static void setFieldValue(Class<?> cls, Object obj, String str, Object obj2) throws IllegalAccessException {
        a(cls.getName(), cls, str).set(obj, obj2);
    }
}
