package cn.hzjizhun.admin.util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ClassUtil {
    public static Object createInstanceByClass(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable unused) {
            ALog.e("ClassUtil", "no found  classPath:" + str);
            return null;
        }
    }
}
