package com.kwad.components.ad.interstitial.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(@NonNull View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ah() {
        return cb.r(this.mRootView, 100);
    }
}
