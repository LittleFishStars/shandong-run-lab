package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private final Handler aqd = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String appId;
        public String appName;
        public int aqE;
        public String aqF;
        public String aqG;

        @Deprecated
        public boolean aqH;
        public boolean aqI;
        public boolean aqJ;
        public String icon;
        public String md5;
        public String pkgName;
        public String tU;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public aj(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aqd.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(2);
        } else {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEO, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(1);
        }
        this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.aj.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(aj.this.apJ.adW.getContext()).aJ(aj.this.mAdTemplate).b(aj.this.mApkDownloadHelper).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.webview.jshandler.aj.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.b(null);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.aqF;
        adConversionInfo.marketUrl = aVar.aqG;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.pkgName;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.aqE;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.tU;
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
            String str = aVar.url;
            adConversionInfo2.appDownloadUrl = str;
            adInfo.downloadId = com.kwad.sdk.utils.an.md5(str);
            return;
        }
        adInfo.adConversionInfo.h5Url = aVar.url;
    }
}
