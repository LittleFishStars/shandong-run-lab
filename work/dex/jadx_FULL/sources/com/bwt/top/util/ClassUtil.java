package com.bwt.top.util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClassUtil {
    public static Object createInstanceByClass(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            ALog.e("ClassUtil", "no found  classPath:" + str);
            return null;
        }
    }
}
