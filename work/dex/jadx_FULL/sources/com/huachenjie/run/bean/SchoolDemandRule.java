package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/run/bean/SchoolDemandRule;", "", "totalDistance", "", "totalTimes", "(II)V", "getTotalDistance", "()I", "getTotalTimes", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "formatTotalDistance", "hashCode", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolDemandRule {
    private final int totalDistance;
    private final int totalTimes;

    /* JADX WARN: Illegal instructions before constructor call */
    public SchoolDemandRule() {
        int i = 0;
        this(i, i, 3, null);
    }

    public SchoolDemandRule(int i, int i2) {
        this.totalDistance = i;
        this.totalTimes = i2;
    }

    public static /* synthetic */ SchoolDemandRule copy$default(SchoolDemandRule schoolDemandRule, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = schoolDemandRule.totalDistance;
        }
        if ((i3 & 2) != 0) {
            i2 = schoolDemandRule.totalTimes;
        }
        return schoolDemandRule.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalDistance() {
        return this.totalDistance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalTimes() {
        return this.totalTimes;
    }

    @NotNull
    public final SchoolDemandRule copy(int totalDistance, int totalTimes) {
        return new SchoolDemandRule(totalDistance, totalTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolDemandRule)) {
            return false;
        }
        SchoolDemandRule schoolDemandRule = (SchoolDemandRule) other;
        return this.totalDistance == schoolDemandRule.totalDistance && this.totalTimes == schoolDemandRule.totalTimes;
    }

    public final int formatTotalDistance() {
        return Math.round((this.totalDistance * 1.0f) / 1000);
    }

    public final int getTotalDistance() {
        return this.totalDistance;
    }

    public final int getTotalTimes() {
        return this.totalTimes;
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalDistance) * 31) + Integer.hashCode(this.totalTimes);
    }

    @NotNull
    public String toString() {
        return "SchoolDemandRule(totalDistance=" + this.totalDistance + ", totalTimes=" + this.totalTimes + ')';
    }

    public /* synthetic */ SchoolDemandRule(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
