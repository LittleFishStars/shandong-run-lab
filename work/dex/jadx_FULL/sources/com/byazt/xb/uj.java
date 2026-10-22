package com.byazt.xb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 15})
public class uj<T> {
    public final Class<?> c;
    public final String tt;
    public final Class[] ve;

    public uj(Class<?> cls, String str, Class... clsArr) {
        this.c = cls;
        this.tt = str;
        this.ve = clsArr;
    }

    public boolean c(T t) {
        return c(t.getClass()) != null;
    }

    public Object tt(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object uj(T t, Object... objArr) {
        try {
            return ve(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object ve(T t, Object... objArr) throws InvocationTargetException {
        Method methodC = c(t.getClass());
        if (methodC != null) {
            try {
                return methodC.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodC)));
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.tt + " not supported for object " + t);
    }

    public Object c(T t, Object... objArr) throws InvocationTargetException {
        Method methodC = c(t.getClass());
        if (methodC == null) {
            return null;
        }
        try {
            return methodC.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method c(Class<?> cls) {
        Class<?> cls2;
        String str = this.tt;
        if (str == null) {
            return null;
        }
        Method methodC = c(cls, str, this.ve);
        if (methodC == null || (cls2 = this.c) == null || cls2.isAssignableFrom(methodC.getReturnType())) {
            return methodC;
        }
        return null;
    }

    private static Method c(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
