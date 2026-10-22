package com.zj.adlib;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting(otherwise = 2)
public final class e0c extends LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f41316a;

    public e0c(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f41316a = new ArrayList();
        super.f31226a.addCallback("LifecycleObserverOnStop", this);
    }

    public static /* bridge */ /* synthetic */ e0c k(Activity activity) {
        e0c e0cVar;
        synchronized (activity) {
            LifecycleFragment lifecycleFragmentB = LifecycleCallback.b(activity);
            e0cVar = (e0c) lifecycleFragmentB.getCallbackOrNull("LifecycleObserverOnStop", e0c.class);
            if (e0cVar == null) {
                e0cVar = new e0c(lifecycleFragmentB);
            }
        }
        return e0cVar;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    @MainThread
    public final void j() {
        List list;
        synchronized (this) {
            list = this.f41316a;
            this.f41316a = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final synchronized void m(Runnable runnable) {
        this.f41316a.add(runnable);
    }
}
