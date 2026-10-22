package com.kc.dw.ad.reward;

import android.view.View;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39156a;

    public d(FullScreenMediaView fullScreenMediaView) {
        this.f39156a = fullScreenMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        FullScreenMediaView fullScreenMediaView = this.f39156a;
        int i = FullScreenMediaView.s;
        fullScreenMediaView.c();
    }
}
