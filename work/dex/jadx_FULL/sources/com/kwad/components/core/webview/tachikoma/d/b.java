package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b extends com.kwad.sdk.mvp.a {
    public String Cd;
    public long Cj;
    public com.kwad.components.core.webview.tachikoma.f.c akL;
    public StyleTemplate akN;
    public e asx;
    public g auD;
    public l auE;
    public k auF;
    public boolean auG;
    public e.a auH;
    public Activity mActivity;
    public AdResultData mAdResultData;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.asx = null;
        this.mActivity = null;
        this.auD = null;
    }
}
