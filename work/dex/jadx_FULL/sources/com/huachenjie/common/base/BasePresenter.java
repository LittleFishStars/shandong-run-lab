package com.huachenjie.common.base;

import androidx.annotation.NonNull;
import com.huachenjie.common.base.BaseView;
import com.zj.adlib.dx4;
import huachenjie.sdk.http.lifecycle.ILifeCycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BasePresenter<T extends BaseView> implements ILifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f33638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx4 f8492a;

    public void a(T view) {
        this.f33638a = view;
    }

    public void b(T view) {
        this.f33638a = null;
    }

    @NonNull
    public T c() {
        return this.f33638a;
    }

    public final void d() {
        dx4 dx4Var = this.f8492a;
        if (dx4Var != null) {
            dx4Var.b();
        }
        this.f8492a = null;
    }

    public void e() {
    }

    public final dx4 getLifeCycleObservable() {
        if (this.f8492a == null) {
            this.f8492a = dx4.a();
        }
        return this.f8492a;
    }
}
