package com.zj.adlib;

import android.content.Context;
import com.huachenjie.step.delegate.StepCounter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/li2;", "Lcom/huachenjie/step/delegate/StepCounter;", "", "isSupport", "Landroid/content/Context;", "context", "b", "Lkotlin/Function1;", "", "acpListener", "a", "", "c", "<init>", "()V", "step_release"}, k = 1, mv = {1, 8, 0})
public final class li2 implements StepCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final li2 f43073a = new li2();

    @Override // com.huachenjie.step.delegate.StepCounter
    public void a(@NotNull Context context, @NotNull Function1<? super Boolean, Unit> acpListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(acpListener, "acpListener");
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public int c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return 0;
    }

    @Override // com.huachenjie.step.delegate.StepCounter
    public boolean isSupport() {
        return false;
    }
}
