package com.bytedance.sdk.openadsdk.mediation;

import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, 1365})
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private int c;
    private AdSlot tt;
    private List<String> ve;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.c = i;
        this.tt = adSlot;
        this.ve = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.ve;
    }
}
