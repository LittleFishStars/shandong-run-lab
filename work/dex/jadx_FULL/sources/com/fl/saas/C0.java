package com.fl.saas;

import com.fl.saas.common.util.ReflectHelper;
import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class C0 {
    public static Annotation a(Class cls, Class cls2) {
        Annotation annotation = cls2.getAnnotation(cls);
        if (annotation != null) {
            return annotation;
        }
        Class superclass = cls2.getSuperclass();
        if (a(superclass)) {
            return null;
        }
        return a(cls, superclass);
    }

    private static boolean a(Class cls) {
        if (cls == null) {
            return true;
        }
        String name = cls.getName();
        return (name.startsWith(ReflectHelper.YD_PREFIX) || name.startsWith(ReflectHelper.MS_PREFIX) || name.startsWith(ReflectHelper.HM_PREFIX) || name.startsWith(ReflectHelper.SM_PREFIX) || name.startsWith(ReflectHelper.WK_PREFIX)) ? false : true;
    }
}
