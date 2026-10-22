package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class WebCardRegisterLiveShopListener implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;

    @KsJson
    public static class AdLiveItemShopInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7621721959722008440L;
        public String price;
        public int status;
        public String title;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.apx = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveShopListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public final void a(AdLiveShopInfo adLiveShopInfo) {
        if (this.apx == null) {
            return;
        }
        AdLiveItemShopInfo adLiveItemShopInfo = new AdLiveItemShopInfo();
        adLiveItemShopInfo.status = adLiveShopInfo.status;
        adLiveItemShopInfo.title = adLiveShopInfo.title;
        adLiveItemShopInfo.url = adLiveShopInfo.url;
        adLiveItemShopInfo.price = adLiveShopInfo.price;
        this.apx.b(adLiveItemShopInfo);
    }
}
