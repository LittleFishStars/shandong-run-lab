package com.kwad.components.core.innerEc.live.comment.history;

import androidx.annotation.NonNull;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private final Set<a> TP = new HashSet();
    private final AdTemplate TQ;

    public interface a {
        void c(HistoryCommentsResponse historyCommentsResponse);

        void rC();
    }

    public b(AdTemplate adTemplate) {
        this.TQ = adTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        Iterator<a> it = this.TP.iterator();
        while (it.hasNext()) {
            it.next().rC();
        }
    }

    public final void b(a aVar) {
        this.TP.remove(aVar);
    }

    public final void rA() {
        new l<com.kwad.components.core.innerEc.live.comment.history.a, HistoryCommentsResponse>() { // from class: com.kwad.components.core.innerEc.live.comment.history.b.1
            @NonNull
            private static HistoryCommentsResponse aH(String str) {
                JSONObject jSONObject = new JSONObject(str);
                HistoryCommentsResponse historyCommentsResponse = new HistoryCommentsResponse();
                historyCommentsResponse.parseJson(jSONObject);
                return historyCommentsResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: rB, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.innerEc.live.comment.history.a createRequest() {
                return new com.kwad.components.core.innerEc.live.comment.history.a(com.kwad.components.core.innerEc.live.base.b.rv().aD(e.aM(b.this.TQ)).aC(e.aN(b.this.TQ)).aE(e.getKwaiUserId()), f.rj());
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aH(str);
            }
        }.request(new o<com.kwad.components.core.innerEc.live.comment.history.a, HistoryCommentsResponse>() { // from class: com.kwad.components.core.innerEc.live.comment.history.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.innerEc.live.comment.history.a aVar, @NonNull final HistoryCommentsResponse historyCommentsResponse) {
                super.onSuccess(aVar, historyCommentsResponse);
                c.d("HistoryCommentsService", "fetchHistoryComments success");
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.comment.history.b.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        b.this.a(historyCommentsResponse);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.innerEc.live.comment.history.a aVar, int i, final String str) {
                super.onError(aVar, i, str);
                c.d("HistoryCommentsService", "fetchHistoryComments error: " + str);
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.comment.history.b.2.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        c.c("HistoryCommentsService", "fetchHistoryComments error", str);
                        b.this.f(new Throwable(str));
                    }
                });
            }
        });
    }

    private void b(HistoryCommentsResponse historyCommentsResponse) {
        Iterator<a> it = this.TP.iterator();
        while (it.hasNext()) {
            it.next().c(historyCommentsResponse);
        }
    }

    public final void a(a aVar) {
        this.TP.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HistoryCommentsResponse historyCommentsResponse) {
        b(historyCommentsResponse);
    }
}
