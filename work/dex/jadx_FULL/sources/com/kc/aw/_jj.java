package com.kc.aw;

import com.ali.auth.third.login.LoginConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jj {
    public static final ConcurrentHashMap _a = new ConcurrentHashMap();
    public static final AtomicLong _b = new AtomicLong();

    public static String _a(_jh _jhVar) {
        StringBuilder sb_a = _jf._a("cache_");
        sb_a.append(_b.incrementAndGet());
        sb_a.append(LoginConstants.UNDER_LINE);
        sb_a.append(System.currentTimeMillis());
        String string = sb_a.toString();
        _a.put(string, _jhVar);
        return string;
    }
}
