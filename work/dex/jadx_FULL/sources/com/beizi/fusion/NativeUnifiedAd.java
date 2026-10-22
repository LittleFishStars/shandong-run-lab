package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeUnifiedAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private si f26976a;

    public NativeUnifiedAd(Context context, String str, NativeUnifiedAdListener nativeUnifiedAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeUnifiedAd adUnitId:" + str);
        this.f26976a = new si(context, str, nativeUnifiedAdListener, j, i);
    }

    public void destroy() {
        si siVar = this.f26976a;
        if (siVar != null) {
            siVar.Y();
        }
    }

    public String getCustomExtraData() {
        si siVar = this.f26976a;
        if (siVar == null) {
            return null;
        }
        return siVar.r();
    }

    public String getCustomExtraJsonData() {
        si siVar = this.f26976a;
        if (siVar == null) {
            return null;
        }
        return siVar.s();
    }

    public int getECPM() {
        si siVar = this.f26976a;
        if (siVar != null) {
            return siVar.Z();
        }
        return -1;
    }

    public boolean isLoaded() {
        si siVar = this.f26976a;
        if (siVar != null) {
            return siVar.a0();
        }
        return false;
    }

    public boolean isValid() {
        si siVar = this.f26976a;
        if (siVar == null) {
            return false;
        }
        return siVar.J();
    }

    public void loadAd() {
        si siVar = this.f26976a;
        if (siVar != null) {
            siVar.b0();
        }
    }

    public void resume() {
        si siVar = this.f26976a;
        if (siVar != null) {
            siVar.c0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        si siVar = this.f26976a;
        if (siVar == null || map == null) {
            return;
        }
        siVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        si siVar = this.f26976a;
        if (siVar == null || map == null) {
            return;
        }
        siVar.b(map);
    }

    public void setBidResponse(String str) {
        si siVar = this.f26976a;
        if (siVar == null) {
            return;
        }
        siVar.m(str);
    }

    public void setHideAdLogo(boolean z) {
        si siVar = this.f26976a;
        if (siVar != null) {
            siVar.b(z);
        }
    }

    public void setHideDownloadInfo(boolean z) {
        si siVar = this.f26976a;
        if (siVar != null) {
            siVar.c(z);
        }
    }

    public void setSpaceParam(Map<String, Object> map) {
        si siVar = this.f26976a;
        if (siVar == null) {
            return;
        }
        siVar.c(map);
    }
}
