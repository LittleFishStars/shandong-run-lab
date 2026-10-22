package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m {
    public static void a(final int i, final g gVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo> lVar = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.1
            @NonNull
            private static RewardCallBackRespInfo K(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: hH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.f createRequest() {
                return new com.kwad.components.core.request.f(i, gVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return K(str);
            }
        };
        if (i == 1) {
            lVar.request(k(gVar));
        } else if (i == 2) {
            lVar.request(l(gVar));
        }
    }

    public static void b(g gVar, long j, long j2, long j3) {
        boolean zM = m(gVar);
        long jDl = zM ? com.kwad.sdk.core.response.helper.a.dl(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate)) : 0L;
        if (gVar.sZ || !zM || !gVar.mCheckExposureResult || j <= ((j2 - 800) - j3) - jDl || jDl <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.dm(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate))) {
            gVar.sY = 1;
            a(2, gVar);
        } else {
            gVar.sy.onRewardVerify();
        }
        gVar.sZ = true;
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> k(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.d(gVar.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.f fVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gVar.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(gVar.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.f fVar, int i, String str) {
                super.onError(fVar, i, str);
                by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        gVar.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(gVar.mAdTemplate, 1, System.currentTimeMillis() - fVar.requestStartTime, i, str);
            }
        };
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo> l(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.request.f fVar) {
                fVar.requestStartTime = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.d(gVar.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.request.f fVar, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.m.3.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            gVar.sY = 1;
                        } else {
                            gVar.sY = 2;
                        }
                        gVar.sy.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(gVar.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.f fVar, int i, String str) {
                super.onError(fVar, i, str);
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.m.3.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        gVar.sY = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(gVar.mAdTemplate, 2, System.currentTimeMillis() - fVar.requestStartTime, i, str);
            }
        };
    }

    private static boolean m(g gVar) {
        return !gVar.sZ && com.kwad.sdk.core.response.helper.a.dn(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate));
    }
}
