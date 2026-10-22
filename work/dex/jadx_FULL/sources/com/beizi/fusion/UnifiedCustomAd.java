package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UnifiedCustomAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kp f26979a;

    public UnifiedCustomAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        this.f26979a = new kp(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        kp kpVar = this.f26979a;
        if (kpVar != null) {
            kpVar.Y();
        }
    }

    public String getCustomExtraData() {
        kp kpVar = this.f26979a;
        if (kpVar == null) {
            return null;
        }
        return kpVar.r();
    }

    public String getCustomExtraJsonData() {
        kp kpVar = this.f26979a;
        if (kpVar == null) {
            return null;
        }
        return kpVar.s();
    }

    public boolean isLoaded() {
        kp kpVar = this.f26979a;
        if (kpVar != null) {
            return kpVar.Z();
        }
        return false;
    }

    public boolean isValid() {
        kp kpVar = this.f26979a;
        if (kpVar == null) {
            return false;
        }
        return kpVar.J();
    }

    public void loadAd() {
        kp kpVar = this.f26979a;
        if (kpVar != null) {
            kpVar.a0();
        }
    }

    public void resume() {
        kp kpVar = this.f26979a;
        if (kpVar != null) {
            kpVar.b0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        kp kpVar = this.f26979a;
        if (kpVar == null || map == null) {
            return;
        }
        kpVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        kp kpVar = this.f26979a;
        if (kpVar == null || map == null) {
            return;
        }
        kpVar.b(map);
    }

    public void setBidResponse(String str) {
        kp kpVar = this.f26979a;
        if (kpVar == null) {
            return;
        }
        kpVar.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        kp kpVar = this.f26979a;
        if (kpVar == null) {
            return;
        }
        kpVar.c(map);
    }

    public void showAd(@NonNull Activity activity) {
        kp kpVar = this.f26979a;
        if (kpVar != null) {
            kpVar.a(activity);
        }
    }
}
