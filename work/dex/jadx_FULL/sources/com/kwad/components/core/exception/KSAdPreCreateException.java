package com.kwad.components.core.exception;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KSAdPreCreateException extends RuntimeException {
    private static final String LIBRARY_VERSION = ". Version: 5.4.10.2";

    public KSAdPreCreateException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public KSAdPreCreateException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }
}
