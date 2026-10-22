package com.kc.dw.platform.ad_adapter.draw;

import android.view.View;
import com.kc.dw.core.safe.m;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f.a f39459a;

    public c(f.a aVar) {
        this.f39459a = aVar;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        if (this.f39459a.f39463a.f39462a.h.getInteractionListener() != null) {
            this.f39459a.f39463a.f39462a.h.getInteractionListener().onAdClosed();
        }
    }
}
