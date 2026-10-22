package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RewardedVideoAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hm f26977a;
    private String b;
    private String c;

    public RewardedVideoAd(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener, long j, int i) {
        Log.d("BeiZis", " request RewardedVideoAd adUnitId:" + str);
        this.f26977a = new hm(context, str, rewardedVideoAdListener, j, i);
    }

    public void destroy() {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.Y();
        }
    }

    public String getCustomExtraData() {
        hm hmVar = this.f26977a;
        if (hmVar == null) {
            return null;
        }
        return hmVar.r();
    }

    public String getCustomExtraJsonData() {
        hm hmVar = this.f26977a;
        if (hmVar == null) {
            return null;
        }
        return hmVar.s();
    }

    public int getECPM() {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            return hmVar.Z();
        }
        return -1;
    }

    public String getExtra() {
        return this.c;
    }

    public String getUserId() {
        return this.b;
    }

    public boolean isLoaded() {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            return hmVar.c0();
        }
        return false;
    }

    public boolean isValid() {
        hm hmVar = this.f26977a;
        if (hmVar == null) {
            return false;
        }
        return hmVar.J();
    }

    public void loadAd() {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.d0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        hm hmVar = this.f26977a;
        if (hmVar == null || map == null) {
            return;
        }
        hmVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        hm hmVar = this.f26977a;
        if (hmVar == null || map == null) {
            return;
        }
        hmVar.b(map);
    }

    public void setBidResponse(String str) {
        hm hmVar = this.f26977a;
        if (hmVar == null) {
            return;
        }
        hmVar.m(str);
    }

    public void setExtra(String str) {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.n(str);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.a(rewardedVideoAdListener);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        hm hmVar = this.f26977a;
        if (hmVar == null) {
            return;
        }
        hmVar.c(map);
    }

    public void setUserId(String str) {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.o(str);
        }
    }

    public void showAd(@NonNull Activity activity) {
        hm hmVar = this.f26977a;
        if (hmVar != null) {
            hmVar.a(activity);
        }
    }
}
