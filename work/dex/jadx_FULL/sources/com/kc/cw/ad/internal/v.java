package com.kc.cw.ad.internal;

import com.kc.cw.ad.RewardItem;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class v implements RewardItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39066a;
    private int b;

    public v(String str, int i) {
        this.f39066a = str;
        this.b = i;
    }

    @Override // com.kc.cw.ad.RewardItem
    public int getAmount() {
        return this.b;
    }

    @Override // com.kc.cw.ad.RewardItem
    public String getType() {
        return this.f39066a;
    }
}
