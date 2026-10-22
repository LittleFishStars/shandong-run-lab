package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hnc implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map.Entry f42166a;

    public final pnc a() {
        return (pnc) this.f42166a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f42166a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((pnc) this.f42166a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzfo) {
            return ((pnc) this.f42166a.getValue()).c((zzfo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
