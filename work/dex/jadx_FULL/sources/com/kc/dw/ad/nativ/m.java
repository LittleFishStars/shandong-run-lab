package com.kc.dw.ad.nativ;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m extends com.kc.dw.core.safe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39137a;

    public m(NormalMediaView normalMediaView) {
        this.f39137a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.f39137a.b.b()) {
            return;
        }
        this.f39137a.resume();
    }
}
