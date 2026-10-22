package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l extends LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f31419a;

    public l(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f31419a = new ArrayList();
        super.f31226a.addCallback("TaskOnStopCallback", this);
    }

    public static l k(Activity activity) {
        LifecycleFragment lifecycleFragmentB = LifecycleCallback.b(activity);
        l lVar = (l) lifecycleFragmentB.getCallbackOrNull("TaskOnStopCallback", l.class);
        return lVar == null ? new l(lifecycleFragmentB) : lVar;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    @MainThread
    public final void j() {
        synchronized (this.f31419a) {
            Iterator it = this.f31419a.iterator();
            while (it.hasNext()) {
                zzq zzqVar = (zzq) ((WeakReference) it.next()).get();
                if (zzqVar != null) {
                    zzqVar.zzc();
                }
            }
            this.f31419a.clear();
        }
    }

    public final void l(zzq zzqVar) {
        synchronized (this.f31419a) {
            this.f31419a.add(new WeakReference(zzqVar));
        }
    }
}
