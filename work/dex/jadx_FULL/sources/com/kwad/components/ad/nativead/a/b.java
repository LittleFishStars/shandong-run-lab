package com.kwad.components.ad.nativead.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.d;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public d mApkDownloadHelper;

    @NonNull
    public com.kwad.components.ad.nativead.d.a pD;

    @NonNull
    public AdBasePvFrameLayout pR;

    @NonNull
    public com.kwad.components.ad.nativead.d.a pX;

    @NonNull
    public KsNativeAd.VideoPlayListener pv;
    public boolean qc = false;
    public boolean qd = false;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        this.pX.release();
    }
}
