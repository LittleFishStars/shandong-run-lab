package com.huachenjie.common.util.intercept;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/common/util/intercept/DialogIntercept;", "Lcom/huachenjie/common/util/intercept/ActionIntercept;", "", "d", "c", "", "a", "Z", "b", "()Z", "e", "(Z)V", "empty", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public abstract class DialogIntercept extends ActionIntercept {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean empty;

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getEmpty() {
        return this.empty;
    }

    public void c() {
        if (getNextActionIntercept() == null || !(getNextActionIntercept() instanceof DialogIntercept)) {
            return;
        }
        ActionIntercept nextActionIntercept = getNextActionIntercept();
        Intrinsics.checkNotNull(nextActionIntercept, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.DialogIntercept");
        ((DialogIntercept) nextActionIntercept).d();
    }

    public abstract void d();

    public final void e(boolean z) {
        this.empty = z;
    }
}
