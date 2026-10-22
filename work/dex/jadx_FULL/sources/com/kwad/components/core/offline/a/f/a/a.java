package com.kwad.components.core.offline.a.f.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> abo = new HashMap();

    public static void a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        abo.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    public static AdResultData bp(int i) {
        WeakReference<AdResultData> weakReference = abo.get(Integer.valueOf(i));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
