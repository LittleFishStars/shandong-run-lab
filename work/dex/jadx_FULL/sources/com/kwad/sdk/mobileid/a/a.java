package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.mobileid.d;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class a extends com.kwad.sdk.mobileid.b {
    private l<b, CMTokenResponse> aqr;
    private int retryCount = 0;
    private int aUX = 3;

    public static /* synthetic */ int c(a aVar) {
        int i = aVar.retryCount;
        aVar.retryCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(final Context context) {
        new l<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.3
            @NonNull
            private static c Sq() {
                return new c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: hg, reason: merged with bridge method [inline-methods] */
            public UaidTokenResponse parseData(String str) {
                UaidTokenResponse uaidTokenResponse = new UaidTokenResponse();
                uaidTokenResponse.parseJson(new JSONObject(str));
                if (!TextUtils.isEmpty(uaidTokenResponse.uaid)) {
                    ai.af(ServiceProvider.Ud(), uaidTokenResponse.uaid);
                    ai.e(ServiceProvider.Ud(), System.currentTimeMillis());
                }
                ai.ag(ServiceProvider.Ud(), "");
                com.kwad.sdk.mobileid.c.a(context, uaidTokenResponse);
                return uaidTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return Sq();
            }
        }.request(new o<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.4
            private void C(int i, String str) {
                com.kwad.sdk.mobileid.a.Sg();
                com.kwad.sdk.mobileid.c.c(context, i, str);
            }

            private static void Sr() {
                com.kwad.sdk.mobileid.a.Sg();
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                C(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                Sr();
            }
        });
    }

    @Override // com.kwad.sdk.mobileid.b
    public final void cD(Context context) {
        d(context, false);
    }

    @SuppressLint({"CheckResult"})
    public final void d(final Context context, final boolean z) {
        com.kwad.sdk.mobileid.c.b(context, z ? new d(true, "uaidTokenCanRequestByWifi") : new d(true, "uaidTokenCanRequest"));
        l<b, CMTokenResponse> lVar = new l<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.1
            @NonNull
            private static b Sp() {
                return new b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: hf, reason: merged with bridge method [inline-methods] */
            public CMTokenResponse parseData(String str) {
                CMTokenResponse cMTokenResponse = new CMTokenResponse();
                cMTokenResponse.parseJson(new JSONObject(str));
                ai.ag(context, cMTokenResponse.getResultToken());
                com.kwad.sdk.mobileid.a.Sg();
                com.kwad.sdk.mobileid.c.a(context, cMTokenResponse);
                return cMTokenResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return Sp();
            }
        };
        this.aqr = lVar;
        lVar.request(new o<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.2
            private void B(int i, String str) {
                com.kwad.sdk.mobileid.c.b(context, i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull b bVar, @NonNull CMTokenResponse cMTokenResponse) {
                d dVar;
                super.onSuccess(bVar, cMTokenResponse);
                boolean z2 = !TextUtils.isEmpty(ai.m1067do(context));
                boolean z3 = a.this.retryCount < a.this.aUX;
                if (z2 && z3) {
                    a.c(a.this);
                    dVar = z ? new d(true, "uaidTokenCanRequestByWifi") : new d(true, "uaidTokenCanRequest");
                    a.this.cE(context);
                } else {
                    dVar = !z2 ? new d(false, "noRequestUaidTokenEmpty") : new d(false, "noRequestUaidRetry");
                }
                com.kwad.sdk.mobileid.c.c(context, dVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                B(i, str);
            }
        });
    }
}
