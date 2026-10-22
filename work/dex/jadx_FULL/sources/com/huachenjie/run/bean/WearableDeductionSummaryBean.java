package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.z62;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/run/bean/WearableDeductionSummaryBean;", "", "totalDeductionDistance", "", "totalDeductionTimes", "(II)V", "getTotalDeductionDistance", "()I", "getTotalDeductionTimes", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "formatDistance", "", "formatTimes", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WearableDeductionSummaryBean {
    private final int totalDeductionDistance;
    private final int totalDeductionTimes;

    /* JADX WARN: Illegal instructions before constructor call */
    public WearableDeductionSummaryBean() {
        int i = 0;
        this(i, i, 3, null);
    }

    public WearableDeductionSummaryBean(int i, int i2) {
        this.totalDeductionDistance = i;
        this.totalDeductionTimes = i2;
    }

    public static /* synthetic */ WearableDeductionSummaryBean copy$default(WearableDeductionSummaryBean wearableDeductionSummaryBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = wearableDeductionSummaryBean.totalDeductionDistance;
        }
        if ((i3 & 2) != 0) {
            i2 = wearableDeductionSummaryBean.totalDeductionTimes;
        }
        return wearableDeductionSummaryBean.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalDeductionDistance() {
        return this.totalDeductionDistance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalDeductionTimes() {
        return this.totalDeductionTimes;
    }

    @NotNull
    public final WearableDeductionSummaryBean copy(int totalDeductionDistance, int totalDeductionTimes) {
        return new WearableDeductionSummaryBean(totalDeductionDistance, totalDeductionTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WearableDeductionSummaryBean)) {
            return false;
        }
        WearableDeductionSummaryBean wearableDeductionSummaryBean = (WearableDeductionSummaryBean) other;
        return this.totalDeductionDistance == wearableDeductionSummaryBean.totalDeductionDistance && this.totalDeductionTimes == wearableDeductionSummaryBean.totalDeductionTimes;
    }

    @NotNull
    public final String formatDistance() {
        return z62.f46193a.b(Long.valueOf(this.totalDeductionDistance), 2);
    }

    @NotNull
    public final String formatTimes() {
        return String.valueOf(this.totalDeductionTimes);
    }

    public final int getTotalDeductionDistance() {
        return this.totalDeductionDistance;
    }

    public final int getTotalDeductionTimes() {
        return this.totalDeductionTimes;
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalDeductionDistance) * 31) + Integer.hashCode(this.totalDeductionTimes);
    }

    @NotNull
    public String toString() {
        return "WearableDeductionSummaryBean(totalDeductionDistance=" + this.totalDeductionDistance + ", totalDeductionTimes=" + this.totalDeductionTimes + ')';
    }

    public /* synthetic */ WearableDeductionSummaryBean(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
