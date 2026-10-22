package com.fl.saas.s2s.videocache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 2.7.1";

    public ProxyCacheException(String str) {
        super(str + ". Version: 2.7.1");
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + ". Version: 2.7.1", th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 2.7.1", th);
    }
}
