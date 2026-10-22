package com.huachenjie.common.base;

import android.app.IntentService;
import com.zj.adlib.dx4;
import huachenjie.sdk.http.lifecycle.ILifeCycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseIntentService extends IntentService implements ILifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dx4 f33637a;

    public BaseIntentService(String name) {
        super(name);
    }

    public final dx4 getLifeCycleObservable() {
        if (this.f33637a == null) {
            this.f33637a = dx4.a();
        }
        return this.f33637a;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        dx4 dx4Var = this.f33637a;
        if (dx4Var != null) {
            dx4Var.b();
        }
        this.f33637a = null;
    }
}
