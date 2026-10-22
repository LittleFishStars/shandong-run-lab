package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _oa {
    public final HashMap _a = new HashMap();
    public final ReferenceQueue<Object> _b = new ReferenceQueue<>();

    @Keep
    public static final class _a extends WeakReference<Object> {
        public final _az _a;

        public _a(_az _azVar, Object obj, ReferenceQueue<Object> referenceQueue) {
            super(obj, referenceQueue);
            this._a = _azVar;
        }
    }
}
