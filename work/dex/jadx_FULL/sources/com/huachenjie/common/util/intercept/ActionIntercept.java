package com.huachenjie.common.util.intercept;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R$\u0010\n\u001a\u0004\u0018\u00010\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/util/intercept/ActionIntercept;", "", "actionIntercept", "", "a", "Lcom/huachenjie/common/util/intercept/ActionIntercept;", "getNextActionIntercept", "()Lcom/huachenjie/common/util/intercept/ActionIntercept;", "setNextActionIntercept", "(Lcom/huachenjie/common/util/intercept/ActionIntercept;)V", "nextActionIntercept", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public abstract class ActionIntercept {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ActionIntercept nextActionIntercept;

    public final void a(@NotNull ActionIntercept actionIntercept) {
        Intrinsics.checkNotNullParameter(actionIntercept, "actionIntercept");
        this.nextActionIntercept = actionIntercept;
    }

    @Nullable
    public final ActionIntercept getNextActionIntercept() {
        return this.nextActionIntercept;
    }

    public final void setNextActionIntercept(@Nullable ActionIntercept actionIntercept) {
        this.nextActionIntercept = actionIntercept;
    }
}
