package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresPermission;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SplashAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fo f26978a;
    private ViewGroup b;
    private boolean c = false;

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public SplashAd(Context context, View view, String str, AdListener adListener, long j) {
        Log.d("BeiZis", " request SplashAd adUnitId:" + str);
        this.f26978a = new fo(context, str, view, adListener, j);
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void cancel(Context context) {
        fo foVar = this.f26978a;
        if (foVar != null) {
            foVar.c();
        }
    }

    public String getCustomExtraData() {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return null;
        }
        return foVar.r();
    }

    public String getCustomExtraJsonData() {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return null;
        }
        return foVar.s();
    }

    public int getECPM() {
        fo foVar = this.f26978a;
        if (foVar != null) {
            return foVar.Y();
        }
        return -1;
    }

    public Map getExtraData() {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return null;
        }
        return foVar.Z();
    }

    public boolean isValid() {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return false;
        }
        return foVar.J();
    }

    public void loadAd(int i, int i2) {
        fo foVar = this.f26978a;
        if (foVar == null || this.b == null) {
            return;
        }
        foVar.d(i);
        this.f26978a.c(i2);
        this.f26978a.a(this.b);
    }

    public void reportNotShow() {
        fo foVar = this.f26978a;
        if (foVar != null) {
            foVar.c0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        fo foVar = this.f26978a;
        if (foVar == null || map == null) {
            return;
        }
        foVar.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        fo foVar = this.f26978a;
        if (foVar == null || map == null) {
            return;
        }
        foVar.b(map);
    }

    public void setBidResponse(String str) {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return;
        }
        foVar.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        fo foVar = this.f26978a;
        if (foVar == null) {
            return;
        }
        foVar.c(map);
    }

    public void setSupportRegionClick(boolean z) {
        fo foVar = this.f26978a;
        if (foVar != null) {
            foVar.a(z);
        }
    }

    public void show(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (this.c) {
            return;
        }
        if (viewGroup == null) {
            Log.e("BeiZis", "parent can't be null !");
            return;
        }
        if (this.f26978a == null || (viewGroup2 = this.b) == null) {
            return;
        }
        try {
            if (!(viewGroup2.getContext() instanceof Activity)) {
                this.f26978a.a(viewGroup.getContext());
            }
        } catch (Throwable unused) {
        }
        viewGroup.addView(this.b);
        this.f26978a.d0();
        this.c = true;
    }

    @Deprecated
    public void loadAd() {
        ViewGroup viewGroup;
        fo foVar = this.f26978a;
        if (foVar == null || (viewGroup = this.b) == null) {
            return;
        }
        foVar.a(viewGroup);
    }
}
