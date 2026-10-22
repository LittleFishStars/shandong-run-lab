package com.kc.dw.ad.nativ;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l extends com.kc.dw.core.safe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39136a;

    public l(NormalMediaView normalMediaView) {
        this.f39136a = normalMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        NormalMediaView normalMediaView = this.f39136a;
        if (normalMediaView.o == 2) {
            normalMediaView.resume();
        } else {
            normalMediaView.replay();
        }
    }
}
