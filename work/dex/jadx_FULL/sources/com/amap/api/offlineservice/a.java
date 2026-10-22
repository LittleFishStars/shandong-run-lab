package com.amap.api.offlineservice;

import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OfflineMapActivity f26157a = null;

    public final int a(float f) {
        OfflineMapActivity offlineMapActivity = this.f26157a;
        return offlineMapActivity != null ? (int) ((f * (offlineMapActivity.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }

    public final void b() {
        this.f26157a.showScr();
    }

    public abstract void c(View view);

    public final void d(OfflineMapActivity offlineMapActivity) {
        this.f26157a = offlineMapActivity;
    }

    public abstract void e();

    public boolean f() {
        return true;
    }

    public abstract RelativeLayout g();

    public abstract void h();
}
