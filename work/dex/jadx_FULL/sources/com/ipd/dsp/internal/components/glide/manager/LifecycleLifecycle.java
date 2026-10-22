package com.ipd.dsp.internal.components.glide.manager;

import androidx.annotation.NonNull;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleObserver;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.OnLifecycleEvent;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.w.j;
import com.ipd.dsp.internal.w.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class LifecycleLifecycle implements j, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Set<k> f38263a = new HashSet();

    @NonNull
    public final Lifecycle b;

    public LifecycleLifecycle(Lifecycle lifecycle) {
        this.b = lifecycle;
        lifecycle.addObserver(this);
    }

    @Override // com.ipd.dsp.internal.w.j
    public void a(@NonNull k kVar) {
        this.f38263a.add(kVar);
        if (this.b.getState() == Lifecycle.State.DESTROYED) {
            kVar.onDestroy();
        } else if (this.b.getState().isAtLeast(Lifecycle.State.STARTED)) {
            kVar.onStart();
        } else {
            kVar.onStop();
        }
    }

    @Override // com.ipd.dsp.internal.w.j
    public void b(@NonNull k kVar) {
        this.f38263a.remove(kVar);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = o.a(this.f38263a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = o.a(this.f38263a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = o.a(this.f38263a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).onStop();
        }
    }
}
