package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UnifiedSplashAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private op f26980a;

    public UnifiedSplashAd(Context context, String str, UnifiedSplashAdListener unifiedSplashAdListener, long j) {
        Log.d("BeiZis", " request UnifiedSplashAd adUnitId:" + str);
        this.f26980a = new op(context, str, unifiedSplashAdListener, j);
    }

    public void adsInteractiveActions(UnifiedSplashActionData unifiedSplashActionData) {
        op opVar = this.f26980a;
        if (opVar != null) {
            opVar.a(unifiedSplashActionData);
        }
    }

    public void destroy() {
        op opVar = this.f26980a;
        if (opVar != null) {
            opVar.Y();
        }
    }

    public String getCustomExtraData() {
        op opVar = this.f26980a;
        if (opVar == null) {
            return null;
        }
        return opVar.r();
    }

    public String getCustomExtraJsonData() {
        op opVar = this.f26980a;
        if (opVar == null) {
            return null;
        }
        return opVar.s();
    }

    public int getECPM() {
        op opVar = this.f26980a;
        if (opVar != null) {
            return opVar.Z();
        }
        return -1;
    }

    public boolean isValid() {
        op opVar = this.f26980a;
        if (opVar == null) {
            return false;
        }
        return opVar.J();
    }

    public void loadAd() {
        op opVar = this.f26980a;
        if (opVar != null) {
            opVar.a0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        op opVar = this.f26980a;
        if (opVar == null || map == null) {
            return;
        }
        opVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        op opVar = this.f26980a;
        if (opVar == null || map == null) {
            return;
        }
        opVar.b(map);
    }

    public void setBidResponse(String str) {
        op opVar = this.f26980a;
        if (opVar == null) {
            return;
        }
        opVar.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        op opVar = this.f26980a;
        if (opVar == null) {
            return;
        }
        opVar.c(map);
    }

    public void showAd(ViewGroup viewGroup) {
        op opVar = this.f26980a;
        if (opVar != null) {
            opVar.c(viewGroup);
        }
    }
}
