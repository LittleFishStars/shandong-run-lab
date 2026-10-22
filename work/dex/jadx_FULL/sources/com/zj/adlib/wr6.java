package com.zj.adlib;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class wr6 implements Supplier<vr6> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f45670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final s74 f20509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xr6 f20510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<ControllerListener> f20511a;

    public wr6(Context context) {
        this(context, u74.k());
    }

    @Override // com.facebook.common.internal.Supplier
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public vr6 get() {
        return new vr6(this.f45670a, this.f20510a, this.f20509a, this.f20511a);
    }

    public wr6(Context context, u74 u74Var) {
        this(context, u74Var, null);
    }

    public wr6(Context context, u74 u74Var, Set<ControllerListener> set) {
        this.f45670a = context;
        this.f20509a = u74Var.j();
        AnimatedFactory animatedFactoryD = u74Var.d();
        this.f20510a = new xr6(context.getResources(), DeferredReleaser.e(), animatedFactoryD != null ? animatedFactoryD.b(context) : null, uf9.d());
        this.f20511a = set;
    }
}
