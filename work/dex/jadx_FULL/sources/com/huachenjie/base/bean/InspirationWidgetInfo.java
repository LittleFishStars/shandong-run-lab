package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/base/bean/InspirationWidgetInfo;", "", "totalInspiration", "", "todayGained", "hasPendingReward", "", "(IIZ)V", "getHasPendingReward", "()Z", "getTodayGained", "()I", "getTotalInspiration", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InspirationWidgetInfo {
    private final boolean hasPendingReward;
    private final int todayGained;
    private final int totalInspiration;

    public InspirationWidgetInfo() {
        this(0, 0, false, 7, null);
    }

    public InspirationWidgetInfo(int i, int i2, boolean z) {
        this.totalInspiration = i;
        this.todayGained = i2;
        this.hasPendingReward = z;
    }

    public static /* synthetic */ InspirationWidgetInfo copy$default(InspirationWidgetInfo inspirationWidgetInfo, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = inspirationWidgetInfo.totalInspiration;
        }
        if ((i3 & 2) != 0) {
            i2 = inspirationWidgetInfo.todayGained;
        }
        if ((i3 & 4) != 0) {
            z = inspirationWidgetInfo.hasPendingReward;
        }
        return inspirationWidgetInfo.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalInspiration() {
        return this.totalInspiration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTodayGained() {
        return this.todayGained;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasPendingReward() {
        return this.hasPendingReward;
    }

    @NotNull
    public final InspirationWidgetInfo copy(int totalInspiration, int todayGained, boolean hasPendingReward) {
        return new InspirationWidgetInfo(totalInspiration, todayGained, hasPendingReward);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InspirationWidgetInfo)) {
            return false;
        }
        InspirationWidgetInfo inspirationWidgetInfo = (InspirationWidgetInfo) other;
        return this.totalInspiration == inspirationWidgetInfo.totalInspiration && this.todayGained == inspirationWidgetInfo.todayGained && this.hasPendingReward == inspirationWidgetInfo.hasPendingReward;
    }

    public final boolean getHasPendingReward() {
        return this.hasPendingReward;
    }

    public final int getTodayGained() {
        return this.todayGained;
    }

    public final int getTotalInspiration() {
        return this.totalInspiration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.totalInspiration) * 31) + Integer.hashCode(this.todayGained)) * 31;
        boolean z = this.hasPendingReward;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "InspirationWidgetInfo(totalInspiration=" + this.totalInspiration + ", todayGained=" + this.todayGained + ", hasPendingReward=" + this.hasPendingReward + ')';
    }

    public /* synthetic */ InspirationWidgetInfo(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }
}
