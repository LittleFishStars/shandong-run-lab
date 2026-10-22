package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private KsAppDownloadListener aph;

    @Nullable
    private com.kwad.sdk.core.webview.c.c apx;
    private final com.kwad.sdk.core.webview.b fi;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public double arg;
        public double arh;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public String appName;
        public long aro;
        public String icon;
        public String md5;
        public String pkgName;
        public String tU;
        public String url;
        public String version;
        public int versionCode;
    }

    public au(com.kwad.sdk.core.webview.b bVar) {
        this.fi = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private KsAppDownloadListener yr() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.au.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                au.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                au.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                au.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                au.this.a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.apx = null;
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || (ksAppDownloadListener = this.aph) == null) {
            return;
        }
        dVar.c(ksAppDownloadListener);
        this.aph = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(2);
        } else {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEO, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(1);
        }
        this.apx = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.aph;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener ksAppDownloadListenerYr = yr();
        this.aph = ksAppDownloadListenerYr;
        this.mApkDownloadHelper.b(ksAppDownloadListenerYr);
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.pkgName;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.aro;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.tU;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.an.md5(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.apx != null) {
            a aVar = new a();
            aVar.arg = f;
            aVar.status = i;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                aVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(adTemplate).totalBytes;
                long j = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate).soFarBytes;
                aVar.soFarBytes = j;
                long j2 = aVar.totalBytes;
                if (j2 > 0) {
                    aVar.arh = (j * 1.0d) / j2;
                } else {
                    aVar.arh = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
            }
            this.apx.b(aVar);
        }
    }
}
