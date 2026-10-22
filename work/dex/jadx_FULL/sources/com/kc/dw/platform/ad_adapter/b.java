package com.kc.dw.platform.ad_adapter;

import com.kc.dw.core.ad.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends com.kc.dw.core.ad.a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSlot f39452a;

    public b(com.kc.dw.ad.banner.a aVar) {
        super(null, "SSD");
        this.f39452a = aVar;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdSlot a() {
        return this.f39452a;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public int getInteractionType() {
        return this.f39452a.getInteractionType();
    }
}
