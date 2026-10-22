package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private boolean apV;
    private Handler aqd;
    private boolean aqh;
    private boolean aqi;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a fl;

    @Nullable
    private final com.kwad.components.core.e.d.d mApkDownloadHelper;

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.aqh = false;
        this.aqi = false;
        this.apV = z;
        this.aqd = new Handler(Looper.getMainLooper());
        this.apJ = bVar;
        this.mApkDownloadHelper = dVar;
        this.aqh = false;
        if (dVar != null) {
            dVar.aS(1);
        }
        this.fl = aVar;
        this.aqi = z3;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aqd.removeCallbacksAndMessages(null);
        this.fl = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.apJ.Pv()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.QK = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.apJ.bbX) {
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ac.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (ac.this.apJ.bbY || aVar.aqY) {
                        ac.this.apJ.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ac.this.apJ.adW.getContext(), ac.this.apJ.getAdTemplate(), new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.webview.jshandler.ac.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ac.this.fl != null) {
                                    ac.this.fl.a(aVar);
                                }
                            }
                        }, ac.this.mApkDownloadHelper, aVar.aqY, ac.this.apV, ac.this.aqh, ac.this.aqi);
                    }
                }
            });
        } else if (this.fl != null) {
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ac.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (ac.this.fl != null) {
                        ac.this.fl.a(aVar);
                    }
                }
            });
        }
        cVar.b(null);
    }

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, dVar, aVar, false, false, false);
    }

    public ac(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.d dVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, dVar, aVar, false, false, false);
    }
}
