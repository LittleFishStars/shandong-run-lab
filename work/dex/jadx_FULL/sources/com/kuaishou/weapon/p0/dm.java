package com.kuaishou.weapon.p0;

import android.annotation.SuppressLint;
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
public class dm {

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = Cdo.a(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            Field fieldA = Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES);
            File[] fileArr = (File[]) fieldA.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            fieldA.set(obj, arrayList.toArray(new File[0]));
        }
    }

    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = Cdo.a(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            Field fieldA = Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES);
            Collection arrayList = (List) fieldA.get(obj);
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
            fieldA.set(obj, arrayList2);
            if (fieldA.get(obj) != arrayList2) {
                Cdo.b(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).set(obj, arrayList2);
            }
            List arrayList3 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object obj2 = (Object[]) Cdo.a(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field fieldA2 = Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS);
            fieldA2.set(obj, obj2);
            if (fieldA2.get(obj) != obj2) {
                Cdo.b(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, obj2);
            }
        }
    }

    public static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = Cdo.a(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            List arrayList = (List) Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj);
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
            List arrayList2 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, (Object[]) Cdo.a(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    public static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException {
            Object obj = Cdo.a(classLoader, NativeLibs.FIELD_PATH_LIST).get(classLoader);
            List arrayList = (List) Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_DIRECTORIES).get(obj);
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
            List arrayList2 = (List) Cdo.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            Cdo.a(obj, NativeLibs.FIELD_NATIVE_LIBRARY_PATH_ELEMENTS).set(obj, (Object[]) Cdo.a(obj, NativeLibs.METHOD_MAKE_PATH_ELEMENTS, List.class).invoke(obj, arrayList3));
        }
    }

    public static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
            String str;
            String path = file.getPath();
            Field fieldA = Cdo.a(classLoader, "libPath");
            String strValueOf = String.valueOf(fieldA.get(classLoader));
            if (TextUtils.isEmpty(strValueOf)) {
                str = path;
            } else {
                str = strValueOf + u15.f19942b + path;
            }
            fieldA.set(classLoader, str);
            Field fieldA2 = Cdo.a(classLoader, NativeLibs.FIELD_LIBRARY_PATH_ELEMENTS);
            List list = (List) fieldA2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            fieldA2.set(classLoader, list);
        }
    }

    public static synchronized void a(ClassLoader classLoader, File file) {
        if (file != null) {
            if (file.exists()) {
                try {
                    d.b(classLoader, file);
                } catch (Throwable unused) {
                    b.b(classLoader, file);
                }
            }
        }
    }
}
