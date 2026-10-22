package com.acse.ottn.banner.util;

import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.OnLifecycleEvent;
import com.acse.ottn.i2;
import com.acse.ottn.y;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f22899a;
    public final LifecycleOwner b;

    public BannerLifecycleObserverAdapter(LifecycleOwner lifecycleOwner, y yVar) {
        this.b = lifecycleOwner;
        this.f22899a = yVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        i2.c("onDestroy");
        this.f22899a.a(this.b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        i2.c("onStart");
        this.f22899a.b(this.b);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        i2.c("onStop");
        this.f22899a.c(this.b);
    }
}
