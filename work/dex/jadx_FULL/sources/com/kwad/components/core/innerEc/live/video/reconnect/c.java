package com.kwad.components.core.innerEc.live.video.reconnect;

import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILiveFetchCallback;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IPlayerReconnect;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ServerException;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
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
public final class c implements IPlayerReconnect {
    private final String Uz;
    private final Set<Object> XS = new HashSet();

    public c(String str) {
        this.Uz = str;
    }

    private static void sL() {
        com.kwad.sdk.core.d.c.i("LivePlayerReconnectManager", "requestPlaySuccess");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sM() {
        com.kwad.sdk.core.d.c.i("LivePlayerReconnectManager", "fetchDataSource error");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IPlayerReconnect
    public final void fetchDataSource(int i, String str, String str2, ILiveFetchCallback iLiveFetchCallback) {
        try {
            a(i, str, str2, iLiveFetchCallback);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IPlayerReconnect
    public final void stopReconnect() {
    }

    private void a(int i, final String str, final String str2, final ILiveFetchCallback iLiveFetchCallback) {
        com.kwad.sdk.core.d.c.i("LivePlayerReconnectManager", "fetchDataSource reason: " + i);
        new l<b, LiveGetPlayUrlResult>() { // from class: com.kwad.components.core.innerEc.live.video.reconnect.c.1
            @NonNull
            private static LiveGetPlayUrlResult aP(String str3) {
                JSONObject jSONObject = new JSONObject(str3);
                LiveGetPlayUrlResult liveGetPlayUrlResult = new LiveGetPlayUrlResult();
                liveGetPlayUrlResult.parseJson(jSONObject);
                return liveGetPlayUrlResult;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: sN, reason: merged with bridge method [inline-methods] */
            public b createRequest() {
                com.kwad.components.core.innerEc.live.base.b bVarAE = com.kwad.components.core.innerEc.live.base.b.rv().aD(str).aC(str2).aE(e.getKwaiUserId());
                Map mapRj = f.rj();
                if (mapRj == null) {
                    mapRj = new HashMap();
                }
                return new b(bVarAE, mapRj);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str3) {
                return aP(str3);
            }
        }.request(new o<b, LiveGetPlayUrlResult>() { // from class: com.kwad.components.core.innerEc.live.video.reconnect.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull b bVar, @NonNull final LiveGetPlayUrlResult liveGetPlayUrlResult) {
                super.onSuccess(bVar, liveGetPlayUrlResult);
                com.kwad.sdk.core.d.c.d("LivePlayerReconnectManager", "requestStartPlay response: " + liveGetPlayUrlResult);
                if (liveGetPlayUrlResult.isResultOk()) {
                    com.kwad.sdk.core.d.c.d("LivePlayerReconnectManager", "requestStartPlay success");
                    by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.video.reconnect.c.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            c.this.a(liveGetPlayUrlResult.mPlayUrlConfig, iLiveFetchCallback);
                        }
                    });
                } else {
                    com.kwad.sdk.core.d.c.d("LivePlayerReconnectManager", "requestStartPlay success but newPlayConfig is null");
                    by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.video.reconnect.c.2.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            c cVar = c.this;
                            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTe;
                            new ServerException(eVar.errorCode, 0, eVar.msg);
                            c.sM();
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull b bVar, final int i2, final String str3) {
                super.onError(bVar, i2, str3);
                com.kwad.sdk.core.d.c.d("LivePlayerReconnectManager", "requestStartPlay error, errorCode: " + i2 + ", errorMsg: " + str3);
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.video.reconnect.c.2.3
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        c cVar = c.this;
                        new ServerException(i2, 0, str3);
                        c.sM();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, ILiveFetchCallback iLiveFetchCallback) {
        if (iLiveFetchCallback != null) {
            try {
                iLiveFetchCallback.onSucceed(aVar.XR);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        sL();
    }
}
