package com.aliyun.dns;

import android.text.TextUtils;
import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DomainProcessor {
    private static final String TAG;
    private static DomainProcessor sInstance;

    static {
        f.b();
        TAG = DomainProcessor.class.getSimpleName();
        sInstance = null;
    }

    private DomainProcessor() {
    }

    public static DomainProcessor getInstance() {
        if (sInstance == null) {
            synchronized (DomainProcessor.class) {
                if (sInstance == null) {
                    sInstance = new DomainProcessor();
                }
            }
        }
        return sInstance;
    }

    public static void loadClass() {
    }

    private static native void nAddEnhancedHttpDnsDomain(String str);

    private static native void nAddPreResolveDomain(String str);

    public void addEnhancedHttpDnsDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nAddEnhancedHttpDnsDomain(str);
    }

    public void addPreResolveDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nAddPreResolveDomain(str);
    }
}
