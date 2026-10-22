package com.acse.ottn;

import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w0 f23276a;

    public static w0 a() {
        if (f23276a == null) {
            synchronized (w0.class) {
                if (f23276a == null) {
                    f23276a = new w0();
                }
            }
        }
        return f23276a;
    }

    public final Object b() throws ObjectStreamException {
        return f23276a;
    }
}
