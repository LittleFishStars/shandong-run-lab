package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMediationPreloadRequestInfo {
    AdSlot getAdSlot();

    int getAdType();

    List<String> getPrimeRitList();
}
