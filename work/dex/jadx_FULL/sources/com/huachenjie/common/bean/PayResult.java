package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/common/bean/PayResult;", "", "payStatus", "", "starDrill", "(II)V", "getPayStatus", "()I", "getStarDrill", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PayResult {
    private final int payStatus;
    private final int starDrill;

    /* JADX WARN: Illegal instructions before constructor call */
    public PayResult() {
        int i = 0;
        this(i, i, 3, null);
    }

    public PayResult(int i, int i2) {
        this.payStatus = i;
        this.starDrill = i2;
    }

    public static /* synthetic */ PayResult copy$default(PayResult payResult, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = payResult.payStatus;
        }
        if ((i3 & 2) != 0) {
            i2 = payResult.starDrill;
        }
        return payResult.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPayStatus() {
        return this.payStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    @NotNull
    public final PayResult copy(int payStatus, int starDrill) {
        return new PayResult(payStatus, starDrill);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayResult)) {
            return false;
        }
        PayResult payResult = (PayResult) other;
        return this.payStatus == payResult.payStatus && this.starDrill == payResult.starDrill;
    }

    public final int getPayStatus() {
        return this.payStatus;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    public int hashCode() {
        return (Integer.hashCode(this.payStatus) * 31) + Integer.hashCode(this.starDrill);
    }

    @NotNull
    public String toString() {
        return "PayResult(payStatus=" + this.payStatus + ", starDrill=" + this.starDrill + ")";
    }

    public /* synthetic */ PayResult(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
