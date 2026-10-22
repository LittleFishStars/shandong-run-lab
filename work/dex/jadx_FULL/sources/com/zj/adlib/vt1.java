package com.zj.adlib;

import com.netease.nimlib.sdk.Observer;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final /* synthetic */ class vt1 implements Observer, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wt1 f45453a;

    public /* synthetic */ vt1(wt1 wt1Var) {
        this.f45453a = wt1Var;
    }

    public final void onEvent(Object obj) {
        this.f45453a.n((List) obj);
    }
}
