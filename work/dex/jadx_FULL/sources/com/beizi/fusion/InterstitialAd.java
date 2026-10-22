package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ag f26974a;

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j) {
        this.f26974a = new ag(context, str, interstitialAdListener, j, 0);
    }

    public void destroy() {
        ag agVar = this.f26974a;
        if (agVar != null) {
            agVar.Y();
        }
    }

    public String getCustomExtraData() {
        ag agVar = this.f26974a;
        if (agVar == null) {
            return null;
        }
        return agVar.r();
    }

    public String getCustomExtraJsonData() {
        ag agVar = this.f26974a;
        if (agVar == null) {
            return null;
        }
        return agVar.s();
    }

    public int getECPM() {
        ag agVar = this.f26974a;
        if (agVar != null) {
            return agVar.Z();
        }
        return -1;
    }

    public boolean isLoaded() {
        ag agVar = this.f26974a;
        if (agVar != null) {
            return agVar.a0();
        }
        return false;
    }

    public boolean isValid() {
        ag agVar = this.f26974a;
        if (agVar == null) {
            return false;
        }
        return agVar.J();
    }

    public void loadAd() {
        ag agVar = this.f26974a;
        if (agVar != null) {
            agVar.b0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        ag agVar = this.f26974a;
        if (agVar == null || map == null) {
            return;
        }
        agVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        ag agVar = this.f26974a;
        if (agVar == null || map == null) {
            return;
        }
        agVar.b(map);
    }

    public void setAdVersion(int i) {
        ag agVar = this.f26974a;
        if (agVar != null) {
            agVar.c(i);
        }
    }

    public void setBidResponse(String str) {
        ag agVar = this.f26974a;
        if (agVar == null) {
            return;
        }
        agVar.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        ag agVar = this.f26974a;
        if (agVar == null) {
            return;
        }
        agVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        ag agVar = this.f26974a;
        if (agVar != null) {
            agVar.a(activity);
        }
    }

    public InterstitialAd(Context context, String str, InterstitialAdListener interstitialAdListener, long j, int i) {
        Log.d("BeiZis", " request InterstitialAd adUnitId:" + str);
        this.f26974a = new ag(context, str, interstitialAdListener, j, i);
    }
}
