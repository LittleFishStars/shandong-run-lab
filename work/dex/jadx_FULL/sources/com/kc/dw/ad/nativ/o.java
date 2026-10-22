package com.kc.dw.ad.nativ;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o extends com.kc.dw.core.safe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39139a;

    public o(NormalMediaView normalMediaView) {
        this.f39139a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        this.f39139a.i();
    }
}
