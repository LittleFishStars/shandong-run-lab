package com.kwad.library.solder.lib.ext;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.jsengine.NativeLibs;
import com.zj.adlib.u15;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"LongLogTag"})
public final class d {

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            Field fieldC = com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES);
            File[] fileArr = (File[]) fieldC.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            fieldC.set(obj, arrayList.toArray(new File[0]));
        }
    }

    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            Field fieldC = com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES);
            Collection arrayList = (List) fieldC.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList2.add(file);
            fieldC.set(obj, arrayList2);
            if (fieldC.get(obj) != arrayList2) {
                com.kwad.library.solder.lib.ext.e.d(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).set(obj, arrayList2);
            }
            List arrayList3 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object obj2 = (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field fieldC2 = com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS);
            fieldC2.set(obj, obj2);
            if (fieldC2.get(obj) != obj2) {
                com.kwad.library.solder.lib.ext.e.d(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, obj2);
            }
        }
    }

    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            List arrayList = (List) com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    /* JADX INFO: renamed from: com.kwad.library.solder.lib.ext.d$d, reason: collision with other inner class name */
    public static final class C1265d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            List arrayList = (List) com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            com.kwad.library.solder.lib.ext.e.c(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class).invoke(obj, arrayList3));
        }
    }

    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            String str;
            String path = file.getPath();
            Field fieldC = com.kwad.library.solder.lib.ext.e.c(classLoader, "libPath");
            String strValueOf = String.valueOf(fieldC.get(classLoader));
            if (TextUtils.isEmpty(strValueOf)) {
                str = path;
            } else {
                str = strValueOf + u15.f19942b + path;
            }
            fieldC.set(classLoader, str);
            Field fieldC2 = com.kwad.library.solder.lib.ext.e.c(classLoader, NativeLibs.FIELD_LIBRARY_PATH_ELEMENTS);
            List list = (List) fieldC2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            fieldC2.set(classLoader, list);
        }
    }

    public static synchronized void c(ClassLoader classLoader, File file) {
        if (file != null) {
            if (file.exists()) {
                try {
                    C1265d.d(classLoader, file);
                    return;
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                    b.d(classLoader, file);
                    return;
                }
            }
        }
        com.kwad.library.solder.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
    }
}
