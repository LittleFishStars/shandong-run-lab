package com.zj.adlib;

import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/zj/adlib/jl7;", "", "Landroid/view/animation/Interpolator;", "a", "Landroid/view/animation/Interpolator;", "()Landroid/view/animation/Interpolator;", "defaultInterpolator", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class jl7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Interpolator defaultInterpolator;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final jl7 f17430a = new jl7();

    static {
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(interpolatorCreate, "create(0.25f, 0.1f, 0.25f, 1.0f)");
        defaultInterpolator = interpolatorCreate;
    }

    @NotNull
    public final Interpolator a() {
        return defaultInterpolator;
    }
}
