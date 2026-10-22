package com.kc.dw.ad.reward;

import android.view.View;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39154a;

    public b(FullScreenMediaView fullScreenMediaView) {
        this.f39154a = fullScreenMediaView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.f39154a.f39151a.b()) {
            return;
        }
        this.f39154a.start();
    }
}
