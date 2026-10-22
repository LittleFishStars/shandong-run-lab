package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ah implements com.kwad.sdk.core.webview.c.a {

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String Nq;
        public String SDKVersion;
        public int SDKVersionCode;
        public int Sp;
        public int Sq;
        public String Un;
        public String appId;
        public String appName;
        public String appVersion;
        public int aqA;
        public int aqB;
        public String aqu;
        public String aqv;
        public int aqw;
        public String aqx;
        public int aqy;
        public String aqz;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static a yu() {
            a aVar = new a();
            aVar.SDKVersion = BuildConfig.VERSION_NAME;
            aVar.SDKVersionCode = BuildConfig.VERSION_CODE;
            aVar.sdkApiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.sdkApiVersionCode = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.n.cZ(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.aqu = String.valueOf(com.kwad.sdk.utils.aq.dB(context));
            aVar.aqv = bt.WU();
            aVar.model = bt.WK();
            aVar.Nq = bt.WM();
            aVar.aqw = 1;
            aVar.aqx = bt.getOsVersion();
            aVar.aqy = bt.WX();
            aVar.aqz = bt.getLanguage();
            aVar.Un = bt.getLocale();
            aVar.Sq = bt.getScreenWidth(context);
            aVar.Sp = bt.getScreenHeight(context);
            aVar.aqA = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            aVar.aqB = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.b(a.yu());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
