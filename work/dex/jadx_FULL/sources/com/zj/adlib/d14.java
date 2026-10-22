package com.zj.adlib;

import android.view.View;
import com.huachenjie.shandong_school.home.HomeActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final /* synthetic */ class d14 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeActivity f41085a;
    public final /* synthetic */ String f;

    public /* synthetic */ d14(HomeActivity homeActivity, String str) {
        this.f41085a = homeActivity;
        this.f = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HomeActivity.D0(this.f41085a, this.f, view);
    }
}
