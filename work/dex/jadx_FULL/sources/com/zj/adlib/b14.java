package com.zj.adlib;

import android.view.View;
import com.huachenjie.shandong_school.home.HomeActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final /* synthetic */ class b14 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeActivity f40654a;
    public final /* synthetic */ String f;

    public /* synthetic */ b14(HomeActivity homeActivity, String str) {
        this.f40654a = homeActivity;
        this.f = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HomeActivity.C0(this.f40654a, this.f, view);
    }
}
