package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o0 implements Runnable {
    public final Set _a;
    public final boolean _b;

    public _o0(CopyOnWriteArraySet copyOnWriteArraySet, boolean z) {
        this._a = copyOnWriteArraySet;
        this._b = z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0023  */
    @Override // java.lang.Runnable
    public final void run() {
        Map.Entry<String, String> next;
        try {
            ConcurrentHashMap<String, String> concurrentHashMap = _o1._g;
            if (concurrentHashMap.isEmpty()) {
                next = null;
            } else {
                Set<Map.Entry<String, String>> setEntrySet = concurrentHashMap.entrySet();
                if (setEntrySet.isEmpty()) {
                    next = null;
                } else {
                    Iterator<Map.Entry<String, String>> it = setEntrySet.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                    } else {
                        next = null;
                    }
                }
            }
            if (next == null) {
                ScheduledFuture<?> scheduledFuture = _o1._d;
                if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                    return;
                }
                _o1._d.cancel(false);
                if (this._b) {
                    CopyOnWriteArraySet copyOnWriteArraySet = _o1._f;
                    copyOnWriteArraySet.clear();
                    copyOnWriteArraySet.addAll(this._a);
                    _o1._a();
                }
                this._a.clear();
                return;
            }
            String key = next.getKey();
            String value = next.getValue();
            concurrentHashMap.remove(key);
            boolean z_a = _cb._a(PtgAdSdk.getContext(), key);
            CopyOnWriteArraySet<String> copyOnWriteArraySet2 = _o1._e;
            copyOnWriteArraySet2.add(value);
            if (z_a) {
                _o1._f.add(value);
                this._a.add(value);
            }
            _o1._a();
            StringBuilder sb = new StringBuilder();
            for (String str : copyOnWriteArraySet2) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    sb.append("@");
                }
            }
            _jw._a(PtgAdSdk.getContext(), "ru_hi_de_to", sb.toString());
        } catch (Exception unused) {
        }
    }
}
