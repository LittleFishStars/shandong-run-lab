package com.byazt.yv;

import android.os.SystemProperties;
import com.acse.ottn.p3;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 71})
public class x {
    public static volatile Object c;

    private Object c() {
        if (c == null) {
            synchronized (x.class) {
                if (c == null) {
                    try {
                        c = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            }
        }
        return c;
    }

    public String c(String str) throws IllegalArgumentException {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            da.c(th);
            try {
                Object objC = c();
                return (String) objC.getClass().getMethod(p3.f, String.class).invoke(objC, str);
            } catch (Throwable th2) {
                da.c(th2);
                return "";
            }
        }
    }
}
