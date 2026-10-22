package com.igexin.push;

import com.getui.gtc.dim.DimCallback;
import com.getui.gtc.dim.DimSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SdkSource extends DimSource {
    public static final SdkSource INSTANCE = new SdkSource();

    private SdkSource() {
    }

    @Override // com.getui.gtc.dim.DimSource
    public <P, V> V get(P p, DimCallback<P, V> dimCallback) {
        com.igexin.c.a.c.a.b("SdkSource", "dim sys call from push");
        if (dimCallback != null) {
            return dimCallback.get(p);
        }
        return null;
    }
}
