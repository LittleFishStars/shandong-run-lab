package com.kc.dw.platform.ad_adapter.recycler;

import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m implements ShakeUtil.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f39512a;
    public final i b;

    public m(i iVar, long j) {
        this.b = iVar;
        this.f39512a = j;
    }

    @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
    public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
        ShakeUtil.getInstance().a(this.b.i);
        if (shakeResult != null) {
            shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f39512a);
        }
        this.b.f39495a.a().setClkActType(i);
        this.b.f39495a.a().setClkPower(i2);
        this.b.f39495a.a().setShakeResult(shakeResult);
        if (this.b.f39495a.a().getCbc() == 0) {
            this.b.callAdClicked();
        }
        com.kc.dw.core.utils.f.a(this.b.f39495a, i2 >= 50);
    }
}
