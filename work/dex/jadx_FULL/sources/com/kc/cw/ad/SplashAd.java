package com.kc.cw.ad;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.cw.ad.internal.e.g;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.video.VideoStateListener;
import com.kc.cw.ad.model.ShakeValue;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class SplashAd implements AdLifeControl, IBidding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f38657a;

    public SplashAd(Context context, String str, ViewGroup viewGroup, SplashAdListener splashAdListener) {
        this(context, str, viewGroup, splashAdListener, "");
    }

    public SplashAd(Context context, String str, ViewGroup viewGroup, SplashAdListener splashAdListener, String str2) {
        g gVar = new g(context == null ? q.a().l() : context, viewGroup, str2);
        this.f38657a = gVar;
        gVar.setSplashAdListener(splashAdListener);
        gVar.setAdSlotId(str);
        gVar.a(new AdRequest.Builder().build().a());
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener, "");
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener, String str2) {
        this(context, str, null, splashAdListener, str2);
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void cancel() {
        onDestroyLifeCycle();
        g gVar = this.f38657a;
        if (gVar != null) {
            gVar.cancel();
        }
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void destroy() {
        cancel();
    }

    public String getAdSlotId() {
        return this.f38657a.getAdSlotId();
    }

    public Map<String, Object> getMediaExtraInfo() {
        g gVar = this.f38657a;
        return gVar != null ? gVar.getMediaExtraInfo() : Collections.emptyMap();
    }

    public int getPrice() {
        g gVar = this.f38657a;
        if (gVar == null) {
            return 0;
        }
        return gVar.getPrice();
    }

    public String getRequestId() {
        return this.f38657a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        g gVar = this.f38657a;
        if (gVar != null) {
            return gVar.getShakeValue();
        }
        return null;
    }

    public String getTagId() {
        g gVar = this.f38657a;
        if (gVar == null) {
            return null;
        }
        return gVar.getTagId();
    }

    public boolean isLoaded() {
        return this.f38657a.f();
    }

    public boolean isLoading() {
        return this.f38657a.j();
    }

    public boolean isValid() {
        return isLoaded() && this.f38657a.g();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onCreateLifeCycle() {
        this.f38657a.onCreateLifeCycle();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        g gVar = this.f38657a;
        if (gVar != null) {
            gVar.onDestroyLifeCycle();
        }
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onPauseLifeCycle() {
        this.f38657a.onPauseLifeCycle();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onRestartLifeCycle() {
        this.f38657a.onRestartLifeCycle();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onResumeLifeCycle() {
        this.f38657a.onResumeLifeCycle();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStartLifeCycle() {
        this.f38657a.onStartLifeCycle();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f38657a.onStopLifeCycle();
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f38657a.c(z);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        g gVar = this.f38657a;
        if (gVar == null) {
            return;
        }
        gVar.sendLossNotice(i, str, str2);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        g gVar = this.f38657a;
        if (gVar == null) {
            return;
        }
        gVar.sendWinNotice(i);
    }

    public void setAdSlotId(String str) {
        this.f38657a.setAdSlotId(str);
    }

    public void setChannel(String str) {
        this.f38657a.setChannel(str);
    }

    public void setCountDownTime(int i) {
        this.f38657a.setCountDownTime(i);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        g gVar = this.f38657a;
        if (gVar == null) {
            return;
        }
        gVar.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f38657a.setRequestId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        g gVar = this.f38657a;
        if (gVar == null) {
            return;
        }
        gVar.setVideoStateListener(videoStateListener);
    }

    public void showAd() {
        ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.SplashAd.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SplashAd f38658a;

            {
                this.f38658a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f38658a.f38657a != null) {
                    this.f38658a.f38657a.a((ViewGroup) null);
                }
            }
        });
    }

    public void showAd(ViewGroup viewGroup) {
        ThreadUtils.runOnUIThread(new Runnable(this, viewGroup) { // from class: com.kc.cw.ad.SplashAd.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ViewGroup f38659a;
            final SplashAd b;

            {
                this.b = this;
                this.f38659a = viewGroup;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.b.f38657a == null || this.f38659a == null) {
                    return;
                }
                this.b.f38657a.a(this.f38659a);
            }
        });
    }
}
