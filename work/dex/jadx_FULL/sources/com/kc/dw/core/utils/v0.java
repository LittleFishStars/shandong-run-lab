package com.kc.dw.core.utils;

import android.content.Context;
import com.kc.dw.core.ad.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class v0 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39412a;

    public v0(Context context, AdType adType) {
        this.f39412a = context;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        w0.h(this.f39412a);
    }
}
