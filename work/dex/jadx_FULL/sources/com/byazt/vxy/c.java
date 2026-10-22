package com.byazt.vxy;

import com.byazt.omf.x;
import com.byazt.ut.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 146, 20})
public class c {
    public static c c;

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public static com.byazt.dna.c n() {
        return uj.getAppContext(uj());
    }

    public static String tt() {
        return x.m().rl();
    }

    public static String uj() {
        return x.m().rl();
    }

    public static String ve() {
        return x.m().rl();
    }

    public com.byazt.dna.c c(String str) {
        return uj.getAppContext(str);
    }
}
