package com.zj.adlib;

import android.content.Context;
import com.huachenjie.step.PermissionDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/zj/adlib/jr8;", "", "", "d", "Landroid/content/Context;", "context", "c", "Lkotlin/Function1;", "", "acpListener", "e", "", "b", "Lcom/huachenjie/step/PermissionDelegate;", "a", "Lcom/huachenjie/step/PermissionDelegate;", "()Lcom/huachenjie/step/PermissionDelegate;", "f", "(Lcom/huachenjie/step/PermissionDelegate;)V", "permissionDelegate", "<init>", "()V", "step_release"}, k = 1, mv = {1, 8, 0})
public final class jr8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public static PermissionDelegate permissionDelegate;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final jr8 f17466a = new jr8();

    @Nullable
    public final PermissionDelegate a() {
        return permissionDelegate;
    }

    public final int b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ir8.f42427a.a().c(context);
    }

    public final boolean c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ir8.f42427a.a().b(context);
    }

    public final boolean d() {
        return ir8.f42427a.a().isSupport();
    }

    public final void e(@NotNull Context context, @NotNull Function1<? super Boolean, Unit> acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
        ir8.f42427a.a().a(context, acpListener);
    }

    public final void f(@Nullable PermissionDelegate permissionDelegate2) {
        permissionDelegate = permissionDelegate2;
    }
}
