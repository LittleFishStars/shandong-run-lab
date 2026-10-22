package com.byazt.iq;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 46})
public final class n extends RuntimeException {
    public static final Method c;
    public IOException tt;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        c = declaredMethod;
    }

    public n(IOException iOException) {
        super(iOException);
        this.tt = iOException;
    }

    public IOException c() {
        return this.tt;
    }

    public void c(IOException iOException) {
        c(iOException, this.tt);
        this.tt = iOException;
    }

    private void c(IOException iOException, IOException iOException2) {
        Method method = c;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
