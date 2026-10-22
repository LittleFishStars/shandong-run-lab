package com.kwad.components.core.j;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {

    @Nullable
    private Object aaW;

    public d(Object obj) {
        this.aaW = obj;
    }

    public final void c(c cVar) {
        if (this.aaW == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.aaW).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.aaW == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.aaW).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.aaW = null;
    }
}
