package com.kwad.components.core.innerEc.live.config;

import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.config.net.LiveStartPlayResult;
import com.kwad.components.core.innerEc.live.config.net.g;
import com.kwad.components.core.innerEc.live.config.net.h;
import com.kwad.components.core.innerEc.live.i.d;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ServerException;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private final Set<a> TZ = new HashSet();
    public com.kwad.components.core.innerEc.live.c.a Ua;
    private com.kwad.components.core.innerEc.live.b.a.b Ub;
    private final AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        try {
            d.a(this.Ub, gVar, gVar.isValid());
            for (a aVar : this.TZ) {
                if (gVar.rG()) {
                    aVar.a(gVar);
                } else {
                    aVar.b(gVar);
                }
            }
            if (gVar.Ut == 601) {
                this.Ub.UJ.h(new ServerException(gVar.Ut, 0, "startPlay error"));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g gVar) {
        try {
            for (a aVar : this.TZ) {
                if (gVar.rG()) {
                    aVar.a(gVar);
                } else {
                    aVar.b(gVar);
                }
            }
            if (gVar.Ut == 601) {
                this.Ub.UJ.h(new ServerException(gVar.Ut, 0, "startPlay error"));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        try {
            if (!(th instanceof ServerException)) {
                c.e("LivePlayConfigService", "onStartPlayRequestError error", th);
                return;
            }
            ServerException serverException = (ServerException) th;
            if (serverException.errorCode == 601) {
                this.Ub.UJ.h(serverException);
            } else {
                c.e("LivePlayConfigService", "onStartPlayRequestError error", th);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final void rE() {
        new l<h, LiveStartPlayResult>() { // from class: com.kwad.components.core.innerEc.live.config.b.1
            @NonNull
            private static LiveStartPlayResult aJ(String str) {
                c.d("LivePlayConfigService", "parseData dataBody: " + str);
                JSONObject jSONObject = new JSONObject(str);
                LiveStartPlayResult liveStartPlayResult = new LiveStartPlayResult();
                liveStartPlayResult.parseJson(jSONObject);
                return liveStartPlayResult;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: rF, reason: merged with bridge method [inline-methods] */
            public h createRequest() {
                c.d("LivePlayConfigService", "createRequest call ");
                com.kwad.components.core.innerEc.live.base.b bVarAE = com.kwad.components.core.innerEc.live.base.b.rv().aD(e.aM(b.this.mAdTemplate)).aC(e.aN(b.this.mAdTemplate)).aE(e.getKwaiUserId());
                c.d("LivePlayConfigService", "liveParam: " + bVarAE.toString());
                Map mapRj = f.rj();
                if (mapRj == null) {
                    mapRj = new HashMap();
                }
                return new h(bVarAE, mapRj);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aJ(str);
            }
        }.request(new o<h, LiveStartPlayResult>() { // from class: com.kwad.components.core.innerEc.live.config.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull h hVar, @NonNull final LiveStartPlayResult liveStartPlayResult) {
                super.onSuccess(hVar, liveStartPlayResult);
                boolean zIsValid = liveStartPlayResult.mStartPlayConfig.isValid();
                c.d("LivePlayConfigService", "requestStartPlay success isValid: " + zIsValid + " liveEnd: " + liveStartPlayResult.mStartPlayConfig.rH());
                if (zIsValid) {
                    by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.config.b.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            c.i("LivePlayConfigService", "fetchDataSource success");
                            b.this.c(liveStartPlayResult.mStartPlayConfig);
                        }
                    });
                    return;
                }
                if (liveStartPlayResult.mStartPlayConfig.rH()) {
                    by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.config.b.2.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            c.i("LivePlayConfigService", "fetchDataSource success but live end");
                            b.this.d(liveStartPlayResult.mStartPlayConfig);
                        }
                    });
                    c.d("LivePlayConfigService", "requestStartPlay liveEnd");
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTe;
                    onError(hVar, eVar.errorCode, eVar.msg);
                    return;
                }
                if (liveStartPlayResult.mStartPlayConfig.rG()) {
                    c.d("LivePlayConfigService", "requestStartPlay isLiveError");
                    onError(hVar, liveStartPlayResult.mStartPlayConfig.Ut, "");
                } else {
                    c.d("LivePlayConfigService", "requestStartPlay success but newPlayConfig is null");
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aTe;
                    onError(hVar, eVar2.errorCode, eVar2.msg);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull h hVar, final int i, final String str) {
                super.onError(hVar, i, str);
                c.d("LivePlayConfigService", "requestStartPlay error");
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.config.b.2.3
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        c.e("LivePlayConfigService", "fetchDataSource error");
                        b.this.g(new ServerException(i, -1, str));
                    }
                });
            }
        });
    }

    public final void b(a aVar) {
        this.TZ.remove(aVar);
    }

    public final void a(a aVar) {
        this.TZ.add(aVar);
    }

    public final void a(com.kwad.components.core.innerEc.live.b.a.b bVar) {
        this.Ub = bVar;
        this.Ua = bVar.UJ;
    }
}
