package com.zj.adlib;

import android.view.View;
import com.huachenjie.shandong_school.home.HomeActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final /* synthetic */ class z04 implements View.OnClickListener {
    public final /* synthetic */ int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeActivity f46153a;

    public /* synthetic */ z04(HomeActivity homeActivity, int i) {
        this.f46153a = homeActivity;
        this.K = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HomeActivity.r0(this.f46153a, this.K, view);
    }
}
