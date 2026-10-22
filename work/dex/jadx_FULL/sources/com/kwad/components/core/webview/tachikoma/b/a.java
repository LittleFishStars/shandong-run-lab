package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends w implements Observer {
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        a(this.mAdTemplate.mAdStatusInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getTrackAdStatus";
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        AdStatusInfo adStatusInfo = (AdStatusInfo) obj;
        if (adStatusInfo != null) {
            a(adStatusInfo);
        }
    }
}
