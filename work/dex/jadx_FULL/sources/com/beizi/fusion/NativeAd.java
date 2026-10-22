package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private li f26975a;

    public NativeAd(Context context, String str, NativeAdListener nativeAdListener, long j, int i) {
        Log.d("BeiZis", " request NativeAd adUnitId:" + str);
        this.f26975a = new li(context, str, nativeAdListener, j, i);
    }

    public void destroy() {
        li liVar = this.f26975a;
        if (liVar != null) {
            liVar.Y();
        }
    }

    public String getCustomExtraData() {
        li liVar = this.f26975a;
        if (liVar == null) {
            return null;
        }
        return liVar.r();
    }

    public String getCustomExtraJsonData() {
        li liVar = this.f26975a;
        if (liVar == null) {
            return null;
        }
        return liVar.s();
    }

    public int getECPM() {
        li liVar = this.f26975a;
        if (liVar != null) {
            return liVar.Z();
        }
        return -1;
    }

    public boolean isValid() {
        li liVar = this.f26975a;
        if (liVar == null) {
            return false;
        }
        return liVar.J();
    }

    public void loadAd(float f, float f2) {
        li liVar = this.f26975a;
        if (liVar != null) {
            liVar.a(f, f2);
        }
    }

    public void pause() {
        li liVar = this.f26975a;
        if (liVar != null) {
            liVar.a0();
        }
    }

    public void resume() {
        li liVar = this.f26975a;
        if (liVar != null) {
            liVar.b0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        li liVar = this.f26975a;
        if (liVar == null || map == null) {
            return;
        }
        liVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        li liVar = this.f26975a;
        if (liVar == null || map == null) {
            return;
        }
        liVar.b(map);
    }

    public void setBidResponse(String str) {
        li liVar = this.f26975a;
        if (liVar == null) {
            return;
        }
        liVar.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        li liVar = this.f26975a;
        if (liVar == null) {
            return;
        }
        liVar.c(map);
    }
}
