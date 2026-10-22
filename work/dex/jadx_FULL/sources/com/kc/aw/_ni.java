package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ni {
    public Map<String, Long> _a;

    @Keep
    public static final class _a {
        public static final _ni _a = new _ni();
    }

    public _ni() {
        if (_a._a != null) {
            throw new IllegalStateException("SingletonHelper instance already created.");
        }
    }
}
