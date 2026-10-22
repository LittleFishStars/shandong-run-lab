package com.kwad.components.ad.reward.retryReward;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.manager.RewardRetryTaskManager;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.api.model.KSAdRewardRetryTaskResult;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g {
    public static synchronized void a(final List<KSAdRewardRetryTaskResult> list, final RewardRetryTaskManager.RetryRewardResultListener retryRewardResultListener) {
        i.execute(new bi() { // from class: com.kwad.components.ad.reward.retryReward.g.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "requestIndustryInfo start");
                new l<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.1
                    @NonNull
                    private static RewardRetryTaskParams aa(String str) {
                        RewardRetryTaskParams rewardRetryTaskParams = new RewardRetryTaskParams();
                        try {
                            rewardRetryTaskParams.parseJson(new JSONObject(str));
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                        return rewardRetryTaskParams;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.a
                    @NonNull
                    /* JADX INFO: renamed from: kL, reason: merged with bridge method [inline-methods] */
                    public RewardRetryTaskNetRequest createRequest() {
                        return new RewardRetryTaskNetRequest(list);
                    }

                    @Override // com.kwad.sdk.core.network.l
                    @NonNull
                    public final /* synthetic */ BaseResultData parseData(String str) {
                        return aa(str);
                    }
                }.request(new o<RewardRetryTaskNetRequest, RewardRetryTaskParams>() { // from class: com.kwad.components.ad.reward.retryReward.g.1.2
                    private void a(@NonNull RewardRetryTaskParams rewardRetryTaskParams) {
                        KSAdInfoData kSAdInfoData;
                        String llsid;
                        RewardRetryTaskParams.a aVar;
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "rewardTask query successfully");
                        try {
                            Map<Long, RewardRetryTaskParams.a> taskResultMap = rewardRetryTaskParams.getTaskResultMap();
                            if (taskResultMap.keySet().isEmpty()) {
                                return;
                            }
                            for (KSAdRewardRetryTaskResult kSAdRewardRetryTaskResult : list) {
                                if (kSAdRewardRetryTaskResult != null && (kSAdInfoData = kSAdRewardRetryTaskResult.ksAdInfoData) != null && (llsid = kSAdInfoData.getLlsid()) != null && (aVar = taskResultMap.get(Long.valueOf(Long.parseLong(llsid)))) != null) {
                                    kSAdRewardRetryTaskResult.conversionStatus = aVar.conversionStatus;
                                }
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            retryRewardResultListener.onSuccess(list);
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                        a((RewardRetryTaskParams) baseResultData);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(@NonNull RewardRetryTaskNetRequest rewardRetryTaskNetRequest, int i, String str) {
                        super.onError(rewardRetryTaskNetRequest, i, str);
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskNetWorker", "onError errorCode=" + i + " errorMsg=" + str);
                        retryRewardResultListener.onError(i, str);
                    }
                });
            }
        });
    }
}
