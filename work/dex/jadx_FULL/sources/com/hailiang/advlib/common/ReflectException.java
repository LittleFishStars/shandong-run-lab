package com.hailiang.advlib.common;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class ReflectException extends RuntimeException {
    private static final long serialVersionUID = -6654702552823551870L;

    public ReflectException() {
    }

    public ReflectException(String str) {
        super(str);
    }

    public ReflectException(String str, Throwable th) {
        super(str, th);
    }

    public ReflectException(Throwable th) {
        super(th);
    }
}
