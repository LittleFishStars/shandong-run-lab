package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    @KsJson
    public static final class C1292a extends com.kwad.sdk.core.response.a.a {
        public String Nq;
        public String SDKVersion;
        public int SDKVersionCode;
        public int Sp;
        public int Sq;
        public String Un;
        public String aQZ;
        public String aRa;
        public String aWY;
        public String aWn;
        public String aXa;
        public String aXb;
        public String aXo;
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
        public String bda;
        public String bdb;
        public boolean bdc;
        public String bdd;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C1292a PL() {
            C1292a c1292a = new C1292a();
            c1292a.SDKVersion = BuildConfig.VERSION_NAME;
            c1292a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c1292a.aWn = "6.2.3";
            c1292a.bdd = "1.3";
            c1292a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c1292a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c1292a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c1292a.appVersion = n.cZ(context);
            c1292a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c1292a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c1292a.bda = "";
            c1292a.aXb = ai.getEGid();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c1292a.aXa = hVar.qQ();
            }
            c1292a.aqu = String.valueOf(aq.dB(context));
            c1292a.aqv = bt.WU();
            c1292a.model = bt.WK();
            c1292a.Nq = bt.WM();
            c1292a.aqw = 1;
            c1292a.aqx = bt.getOsVersion();
            c1292a.aqy = bt.WX();
            c1292a.aqz = bt.getLanguage();
            c1292a.Un = bt.getLocale();
            c1292a.bdc = ((f) ServiceProvider.get(f.class)).Fu();
            c1292a.bdb = bf.getDeviceId();
            c1292a.Sq = bt.getScreenWidth(context);
            c1292a.Sp = bt.getScreenHeight(context);
            c1292a.aQZ = bf.dO(context);
            c1292a.aRa = bf.getOaid();
            c1292a.aWY = bf.dP(context);
            c1292a.aXo = bf.dQ(context);
            c1292a.aqA = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c1292a.aqB = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c1292a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        cVar.b(C1292a.PL());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
