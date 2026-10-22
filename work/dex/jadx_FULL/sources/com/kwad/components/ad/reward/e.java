package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {

    public static class a {
        private static e sv = new e(0);
    }

    public static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> sw = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.p.a.vL().h(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.components.core.p.a.vL().h(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* JADX INFO: renamed from: gN, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void gM() {
            request(this.sw);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    private static void Q(AdTemplate adTemplate) {
        new b(adTemplate).gM();
    }

    public static e gK() {
        return a.sv;
    }

    public final void P(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.bZ(adInfoEO))) {
            p.b(adTemplate, adInfoEO);
        } else {
            Q(adTemplate);
        }
    }

    private e() {
    }
}
