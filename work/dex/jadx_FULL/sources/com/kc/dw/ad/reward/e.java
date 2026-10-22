package com.kc.dw.ad.reward;

import android.view.View;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39157a;

    public e(FullScreenMediaView fullScreenMediaView) {
        this.f39157a = fullScreenMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        FullScreenMediaView fullScreenMediaView = this.f39157a;
        int i = FullScreenMediaView.s;
        fullScreenMediaView.b();
    }
}
