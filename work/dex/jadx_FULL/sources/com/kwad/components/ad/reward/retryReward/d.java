package com.kwad.components.ad.reward.retryReward;

import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    private final Map<String, f> BB = new HashMap();
    private final ArrayList<String> BC = new ArrayList<>();
    private final Object lock = new Object();

    public static class a {
        private static final d BG = new d();
    }

    public static d kF() {
        return a.BG;
    }

    public final f Z(String str) {
        return this.BB.get(str);
    }

    public final void kG() {
        if (bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.9.20.1")) {
            i.execute(new bi() { // from class: com.kwad.components.ad.reward.retryReward.d.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    SharedPreferences sharedPreferencesM1068if;
                    try {
                        synchronized (d.this.lock) {
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                Map<String, ?> mapHO = ai.hO("ksadsdk_reward_task_cache");
                                com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "initRewardTaskAsync map cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                boolean zHN = ah.hN("ksadsdk_reward_task_cache");
                                if (mapHO != null && !mapHO.isEmpty()) {
                                    for (Map.Entry<String, ?> entry : mapHO.entrySet()) {
                                        if (entry != null) {
                                            Object value = entry.getValue();
                                            if (value instanceof String) {
                                                String strDecodeKsSdk = (String) value;
                                                if (com.kwad.sdk.core.a.c.isEncodeKsSdk(strDecodeKsSdk)) {
                                                    strDecodeKsSdk = com.kwad.sdk.core.a.c.decodeKsSdk(strDecodeKsSdk);
                                                }
                                                if (!strDecodeKsSdk.trim().isEmpty()) {
                                                    JSONObject jSONObject = new JSONObject(strDecodeKsSdk);
                                                    f fVar = new f();
                                                    fVar.parseJson(jSONObject);
                                                    com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "json parse " + entry.getKey() + com.kwad.sdk.core.response.helper.a.aD(com.kwad.sdk.core.response.helper.e.eO(fVar.mAdTemplate)) + " cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                                    if (fVar.BO * 1000 <= jCurrentTimeMillis - fVar.BP) {
                                                        if (zHN) {
                                                            d.this.BC.add(entry.getKey());
                                                        } else {
                                                            ai.az("ksadsdk_reward_task_cache", entry.getKey());
                                                        }
                                                        com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "remove task: " + entry.getKey() + com.kwad.sdk.core.response.helper.a.aD(com.kwad.sdk.core.response.helper.e.eO(fVar.mAdTemplate)) + " out time: " + ((jCurrentTimeMillis - fVar.BP) - (fVar.BO * 1000)));
                                                    } else {
                                                        d.this.BB.put(entry.getKey(), fVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (zHN && (sharedPreferencesM1068if = bq.m1068if("ksadsdk_reward_task_cache")) != null) {
                                        SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
                                        Iterator it = d.this.BC.iterator();
                                        while (it.hasNext()) {
                                            editorEdit.remove((String) it.next());
                                        }
                                        editorEdit.apply();
                                    }
                                }
                                com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", " all items: " + d.this.BB.size() + " cost time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }
            });
        }
    }

    public final void a(final String str, final f fVar) {
        if (!this.BB.containsKey(str)) {
            this.BB.put(str, fVar);
            i.execute(new bi() { // from class: com.kwad.components.ad.reward.retryReward.d.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    synchronized (d.this.lock) {
                        ai.ay(str, fVar.toJson().toString());
                        com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "addTask key: " + str + com.kwad.sdk.core.response.helper.a.aD(com.kwad.sdk.core.response.helper.e.eO(fVar.mAdTemplate)) + " save success");
                    }
                }
            });
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardRetryTaskCacheManager", "addTask key: " + str + com.kwad.sdk.core.response.helper.a.aD(com.kwad.sdk.core.response.helper.e.eO(fVar.mAdTemplate)) + " already exist");
    }
}
