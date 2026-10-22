package com.byazt.zb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 91})
public class sp {
    public static c c;

    public interface c {
        void c(String str, String str2, Throwable th);
    }

    public static void c(c cVar) {
        c = cVar;
    }

    public static boolean c() {
        return c != null;
    }

    public static void c(String str, String str2, Throwable th) {
        if (c == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        c.c(str, str2, th);
    }
}
