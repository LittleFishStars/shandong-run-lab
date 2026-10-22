package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qjc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44226a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final qjc f19130a = new qjc(true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f19131a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f19132a;

    public qjc() {
        this.f19132a = new HashMap();
    }

    public static qjc a() {
        return f19130a;
    }

    public final llc b(zzfo zzfoVar, int i) {
        return (llc) this.f19132a.get(new njc(zzfoVar, i));
    }

    public qjc(boolean z) {
        this.f19132a = Collections.emptyMap();
    }
}
