package com.huachenjie.base.aliyun.detect_face;

import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.LifecycleRegistry;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.zj.adlib.y6b;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/CameraXLifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "b", "f", "e", "d", y6b.f, "c", "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "a", "owner", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "k", "j", "i", y6b.g, "Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "controlByLifecycle", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class CameraXLifecycle implements LifecycleOwner, DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final AtomicBoolean controlByLifecycle = new AtomicBoolean(true);

    public final void a(@NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        lifecycle.addObserver(this);
    }

    public final void b() {
        if (this.controlByLifecycle.get()) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }
    }

    public final void c() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public final void d() {
        if (this.controlByLifecycle.get()) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void e() {
        if (this.controlByLifecycle.get()) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }
    }

    public final void f() {
        if (this.controlByLifecycle.get()) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
    }

    public final void g() {
        if (this.controlByLifecycle.get()) {
            this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
    }

    @Override // androidx.p002lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public final void h() {
        if (!this.controlByLifecycle.get()) {
            this.controlByLifecycle.set(true);
        }
        g();
        this.controlByLifecycle.set(false);
    }

    public final void i() {
        if (!this.controlByLifecycle.get()) {
            this.controlByLifecycle.set(true);
        }
        f();
        this.controlByLifecycle.set(true);
    }

    public final void j() {
        this.controlByLifecycle.set(false);
    }

    public final void k() {
        this.controlByLifecycle.set(false);
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onCreate(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        b();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        c();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        d();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        e();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        f();
    }

    @Override // androidx.p002lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        g();
    }
}
