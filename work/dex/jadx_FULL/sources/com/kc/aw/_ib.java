package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ib {
    public static final ConcurrentHashMap<String, Long> _a = new ConcurrentHashMap<>();

    public static long _a(_h _hVar, AdSlot adSlot) {
        long j;
        long countdownTime = adSlot != null ? adSlot.getCountdownTime() : 0L;
        if (_hVar != null) {
            _bb _bbVar = _hVar._D;
            j = _bbVar != null ? _bbVar._c : 5L;
        } else {
            j = 0;
        }
        if (countdownTime <= 0) {
            countdownTime = j > 0 ? j : 5L;
        }
        return (countdownTime > 3 ? Math.min(countdownTime, 15L) : 3L) * 1000;
    }

    public static boolean _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return _a.containsKey(str);
    }
}
