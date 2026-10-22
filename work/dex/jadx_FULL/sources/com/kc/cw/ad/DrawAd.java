package com.kc.cw.ad;

import android.content.Context;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class DrawAd implements AdLifeControl, IBidding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.kc.cw.ad.internal.b.c f38649a;

    public DrawAd(Context context, String str, DrawAdListener drawAdListener) {
        this(context, str, drawAdListener, "");
    }

    public DrawAd(Context context, String str, NativeAdListener nativeAdListener, String str2) {
        com.kc.cw.ad.internal.b.c cVar = new com.kc.cw.ad.internal.b.c(context == null ? q.a().l() : context, str, p.DRAW, str2);
        this.f38649a = cVar;
        cVar.a(nativeAdListener);
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void cancel() {
        com.kc.cw.ad.internal.b.c cVar = this.f38649a;
        if (cVar != null) {
            cVar.m();
            this.f38649a.b.a();
        }
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void destroy() {
        cancel();
    }

    public String getAdSlotId() {
        return this.f38649a.d();
    }

    public int getPrice() {
        com.kc.cw.ad.internal.b.c cVar = this.f38649a;
        if (cVar == null) {
            return 0;
        }
        return cVar.e();
    }

    public String getRequestId() {
        return this.f38649a.i();
    }

    public String getTagId() {
        com.kc.cw.ad.internal.b.c cVar = this.f38649a;
        if (cVar == null) {
            return null;
        }
        return cVar.f();
    }

    public boolean isLoaded() {
        return this.f38649a.g();
    }

    public boolean isValid() {
        return isLoaded() && this.f38649a.h();
    }

    public void loadAd() {
        this.f38649a.a(new AdRequest.Builder().build().a());
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onDestroyLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onResumeLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStopLifeCycle() {
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f38649a.b(z);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        com.kc.cw.ad.internal.b.c cVar = this.f38649a;
        if (cVar == null) {
            return;
        }
        cVar.sendLossNotice(i, str, str2);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        com.kc.cw.ad.internal.b.c cVar = this.f38649a;
        if (cVar == null) {
            return;
        }
        cVar.sendWinNotice(i);
    }

    public void setAdSlotId(String str) {
        this.f38649a.c(str);
    }

    public void setChannel(String str) {
        this.f38649a.e(str);
    }

    public void setRequestId(String str) {
        this.f38649a.f(str);
    }
}
