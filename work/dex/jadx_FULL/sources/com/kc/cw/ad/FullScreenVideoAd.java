package com.kc.cw.ad;

import android.app.Activity;
import android.content.Context;
import com.kc.cw.ad.internal.e.f;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.video.VideoStateListener;
import com.kc.cw.ad.model.ShakeValue;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class FullScreenVideoAd implements AdLifeControl, IBidding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f38650a;

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, "");
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, String str2) {
        f fVar = new f(context == null ? q.a().l() : context, p.FULLSCREEN, false, str2);
        this.f38650a = fVar;
        fVar.setAdSlotId(str);
        fVar.setFullScreenVideoAdListener(fullScreenVideoAdListener);
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void cancel() {
        this.f38650a.cancel();
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void destroy() {
        onDestroyLifeCycle();
        cancel();
    }

    public String getAdSlotId() {
        return this.f38650a.getAdSlotId();
    }

    public Map<String, Object> getMediaExtraInfo() {
        f fVar = this.f38650a;
        return fVar != null ? fVar.getMediaExtraInfo() : Collections.emptyMap();
    }

    public int getPrice() {
        return this.f38650a.getPrice();
    }

    public String getRequestId() {
        return this.f38650a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        f fVar = this.f38650a;
        if (fVar != null) {
            return fVar.getShakeValue();
        }
        return null;
    }

    public String getTagId() {
        return this.f38650a.getTagId();
    }

    public boolean isLoaded() {
        return this.f38650a.f();
    }

    public boolean isLoading() {
        return this.f38650a.j();
    }

    public boolean isValid() {
        return isLoaded() && this.f38650a.g();
    }

    public void loadAd() {
        this.f38650a.a(new AdRequest.Builder().build().a());
    }

    public void loadAd(AdRequest adRequest) {
        this.f38650a.a(adRequest.a());
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        this.f38650a.onDestroyLifeCycle();
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
        this.f38650a.setOpensNativeBrowser(z);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        f fVar = this.f38650a;
        if (fVar == null) {
            return;
        }
        fVar.sendLossNotice(i, str, str2);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        f fVar = this.f38650a;
        if (fVar == null) {
            return;
        }
        fVar.sendWinNotice(i);
    }

    public void setChannel(String str) {
        this.f38650a.setChannel(str);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        f fVar = this.f38650a;
        if (fVar == null) {
            return;
        }
        fVar.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f38650a.setRequestId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        f fVar = this.f38650a;
        if (fVar == null) {
            return;
        }
        fVar.setVideoStateListener(videoStateListener);
    }

    public void show(Activity activity) {
        this.f38650a.a(activity);
    }
}
