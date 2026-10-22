package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ky implements Runnable {
    public final Collection _a;

    public _ky(Collection collection) {
        this._a = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pattern patternCompile;
        try {
            for (String str : this._a) {
                try {
                    String str_c = com.kc.aw.lib.utils._a._c(str);
                    ConcurrentHashMap concurrentHashMap = _kx._a;
                    if (!concurrentHashMap.containsKey(str_c) && (patternCompile = Pattern.compile(str)) != null) {
                        concurrentHashMap.put(str_c, patternCompile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
