package com.byazt.jna;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.byazt.bog.a;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 755, 20})
public class c {
    public static void c(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) c(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldC = c(Fragment.class, "sClassMap");
            if (fieldC != null) {
                ((SimpleArrayMap) fieldC.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsC = c("androidx.fragment.app.FragmentFactory");
            if (clsC == null) {
                return;
            }
            Field fieldC2 = c(clsC, "sClassMap");
            if (fieldC2 != null) {
                ((SimpleArrayMap) fieldC2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldC3 = c(clsC, "sClassCacheMap");
            if (fieldC3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldC3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            a.c(e);
        }
    }

    private static Field c(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
