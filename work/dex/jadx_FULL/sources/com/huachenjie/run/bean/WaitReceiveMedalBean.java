package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/bean/WaitReceiveMedalBean;", "", "hasConfiguredActivity", "", "(Z)V", "getHasConfiguredActivity", "()Z", "component1", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WaitReceiveMedalBean {
    private final boolean hasConfiguredActivity;

    public WaitReceiveMedalBean() {
        this(false, 1, null);
    }

    public WaitReceiveMedalBean(boolean z) {
        this.hasConfiguredActivity = z;
    }

    public static /* synthetic */ WaitReceiveMedalBean copy$default(WaitReceiveMedalBean waitReceiveMedalBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = waitReceiveMedalBean.hasConfiguredActivity;
        }
        return waitReceiveMedalBean.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasConfiguredActivity() {
        return this.hasConfiguredActivity;
    }

    @NotNull
    public final WaitReceiveMedalBean copy(boolean hasConfiguredActivity) {
        return new WaitReceiveMedalBean(hasConfiguredActivity);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WaitReceiveMedalBean) && this.hasConfiguredActivity == ((WaitReceiveMedalBean) other).hasConfiguredActivity;
    }

    public final boolean getHasConfiguredActivity() {
        return this.hasConfiguredActivity;
    }

    public int hashCode() {
        boolean z = this.hasConfiguredActivity;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "WaitReceiveMedalBean(hasConfiguredActivity=" + this.hasConfiguredActivity + ')';
    }

    public /* synthetic */ WaitReceiveMedalBean(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
