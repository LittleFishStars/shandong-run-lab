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
public final class RewardVideoAd implements IBidding, IRewardVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f38655a;

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, "");
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, String str2) {
        f fVar = new f(context == null ? q.a().l() : context, p.REWARD, false, str2);
        this.f38655a = fVar;
        fVar.setAdSlotId(str);
        fVar.setRewardVideoAdListener(rewardVideoAdListener);
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void destroy() {
        this.f38655a.destroy();
    }

    public Map<String, Object> getMediaExtraInfo() {
        f fVar = this.f38655a;
        return fVar != null ? fVar.getMediaExtraInfo() : Collections.emptyMap();
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public int getPrice() {
        return this.f38655a.getPrice();
    }

    public String getRequestId() {
        return this.f38655a.getRequestId();
    }

    public ShakeValue getShakeValue() {
        f fVar = this.f38655a;
        if (fVar != null) {
            return fVar.getShakeValue();
        }
        return null;
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public String getTagId() {
        return this.f38655a.getTagId();
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public boolean isLoaded() {
        return this.f38655a.f();
    }

    public boolean isValid() {
        return isLoaded() && this.f38655a.g();
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void loadAd() {
        this.f38655a.a(new AdRequest.Builder().build().a());
    }

    public void openAdInNativeBrowser(boolean z) {
        this.f38655a.c(z);
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void pause() {
        this.f38655a.u();
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void resume() {
        this.f38655a.v();
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        f fVar = this.f38655a;
        if (fVar == null) {
            return;
        }
        fVar.sendLossNotice(i, str, str2);
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        f fVar = this.f38655a;
        if (fVar == null) {
            return;
        }
        fVar.sendWinNotice(i);
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void setAdSlotId(String str) {
        this.f38655a.setAdSlotId(str);
    }

    public void setChannel(String str) {
        this.f38655a.setChannel(str);
    }

    public void setExtraData(String str) {
        this.f38655a.setExtraData(str);
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        f fVar = this.f38655a;
        if (fVar == null) {
            return;
        }
        fVar.setOnSensorListener(onSensorListener);
    }

    public void setRequestId(String str) {
        this.f38655a.setRequestId(str);
    }

    public void setUserId(String str) {
        this.f38655a.setUserId(str);
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        f fVar = this.f38655a;
        if (fVar == null) {
            return;
        }
        fVar.setVideoStateListener(videoStateListener);
    }

    @Override // com.kc.cw.ad.IRewardVideoAd
    public void show(Activity activity) {
        if (isLoaded()) {
            this.f38655a.a(activity);
        }
    }
}
