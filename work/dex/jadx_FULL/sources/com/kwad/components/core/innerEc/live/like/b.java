package com.kwad.components.core.innerEc.live.like;

import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private final AdTemplate TQ;
    private final Set<a> Xh = new HashSet();

    public interface a {
        void a(LikeResponse likeResponse);

        void sz();
    }

    public b(AdTemplate adTemplate) {
        this.TQ = adTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Throwable th) {
        try {
            Iterator<a> it = this.Xh.iterator();
            while (it.hasNext()) {
                it.next().sz();
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final void aZ(final int i) {
        new l<com.kwad.components.core.innerEc.live.like.a, LikeResponse>() { // from class: com.kwad.components.core.innerEc.live.like.b.1
            @NonNull
            private static LikeResponse aN(String str) {
                JSONObject jSONObject = new JSONObject(str);
                LikeResponse likeResponse = new LikeResponse();
                likeResponse.parseJson(jSONObject);
                return likeResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: sI, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.innerEc.live.like.a createRequest() {
                return new com.kwad.components.core.innerEc.live.like.a(com.kwad.components.core.innerEc.live.base.b.rv().aD(e.aM(b.this.TQ)).aV(i).I(1L).aC(e.aN(b.this.TQ)).aE(e.getKwaiUserId()), f.rj());
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aN(str);
            }
        }.request(new o<com.kwad.components.core.innerEc.live.like.a, LikeResponse>() { // from class: com.kwad.components.core.innerEc.live.like.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.innerEc.live.like.a aVar, @NonNull final LikeResponse likeResponse) {
                super.onSuccess(aVar, likeResponse);
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.like.b.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        b.this.a(likeResponse);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.innerEc.live.like.a aVar, int i2, String str) {
                super.onError(aVar, i2, str);
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.like.b.2.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        b.this.k(null);
                    }
                });
            }
        });
    }

    public final void b(a aVar) {
        this.Xh.remove(aVar);
    }

    private void b(LikeResponse likeResponse) {
        Iterator<a> it = this.Xh.iterator();
        while (it.hasNext()) {
            it.next().a(likeResponse);
        }
    }

    public final void a(a aVar) {
        this.Xh.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LikeResponse likeResponse) {
        try {
            b(likeResponse);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
