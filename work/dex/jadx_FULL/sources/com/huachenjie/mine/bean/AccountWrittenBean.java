package com.huachenjie.mine.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mine/bean/AccountWrittenBean;", "", "bisWrittenOff", "", "(Z)V", "getBisWrittenOff", "()Z", "component1", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AccountWrittenBean {
    private final boolean bisWrittenOff;

    public AccountWrittenBean(boolean z) {
        this.bisWrittenOff = z;
    }

    public static /* synthetic */ AccountWrittenBean copy$default(AccountWrittenBean accountWrittenBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = accountWrittenBean.bisWrittenOff;
        }
        return accountWrittenBean.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getBisWrittenOff() {
        return this.bisWrittenOff;
    }

    @NotNull
    public final AccountWrittenBean copy(boolean bisWrittenOff) {
        return new AccountWrittenBean(bisWrittenOff);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AccountWrittenBean) && this.bisWrittenOff == ((AccountWrittenBean) other).bisWrittenOff;
    }

    public final boolean getBisWrittenOff() {
        return this.bisWrittenOff;
    }

    public int hashCode() {
        boolean z = this.bisWrittenOff;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "AccountWrittenBean(bisWrittenOff=" + this.bisWrittenOff + ')';
    }
}
