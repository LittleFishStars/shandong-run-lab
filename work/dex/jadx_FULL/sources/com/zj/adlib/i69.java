package com.zj.adlib;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i69 {
    public static List<Throwable> a(Throwable th) {
        ax6.i(th);
        ArrayList arrayList = new ArrayList(4);
        while (th != null) {
            arrayList.add(th);
            th = th.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Throwable b(Throwable th) {
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            th = cause;
        }
    }

    public static String c(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static RuntimeException d(Throwable th) throws Throwable {
        f((Throwable) ax6.i(th));
        throw new RuntimeException(th);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public static <X extends Throwable> void e(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void f(@Nullable Throwable th) throws Throwable {
        e(th, Error.class);
        e(th, RuntimeException.class);
    }

    public static <X extends Throwable> void g(@Nullable Throwable th, Class<X> cls) throws Throwable {
        e(th, cls);
        f(th);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void h(@Nullable Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable {
        ax6.i(cls2);
        e(th, cls);
        g(th, cls2);
    }
}
