package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.z62;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/run/bean/OutsideDeductionRecordBean;", "", "planName", "", "useTime", "", "deductionDistance", "deductionTimes", "", "(Ljava/lang/String;JJI)V", "getDeductionDistance", "()J", "getDeductionTimes", "()I", "getPlanName", "()Ljava/lang/String;", "getUseTime", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "formatDistance", "formatTimes", "formatUseTime", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OutsideDeductionRecordBean {
    private final long deductionDistance;
    private final int deductionTimes;

    @NotNull
    private final String planName;
    private final long useTime;

    public OutsideDeductionRecordBean() {
        this(null, 0L, 0L, 0, 15, null);
    }

    public OutsideDeductionRecordBean(@NotNull String str, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(str, "planName");
        this.planName = str;
        this.useTime = j;
        this.deductionDistance = j2;
        this.deductionTimes = i;
    }

    public static /* synthetic */ OutsideDeductionRecordBean copy$default(OutsideDeductionRecordBean outsideDeductionRecordBean, String str, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = outsideDeductionRecordBean.planName;
        }
        if ((i2 & 2) != 0) {
            j = outsideDeductionRecordBean.useTime;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = outsideDeductionRecordBean.deductionDistance;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = outsideDeductionRecordBean.deductionTimes;
        }
        return outsideDeductionRecordBean.copy(str, j3, j4, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlanName() {
        return this.planName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUseTime() {
        return this.useTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDeductionDistance() {
        return this.deductionDistance;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final OutsideDeductionRecordBean copy(@NotNull String planName, long useTime, long deductionDistance, int deductionTimes) {
        Intrinsics.checkNotNullParameter(planName, "planName");
        return new OutsideDeductionRecordBean(planName, useTime, deductionDistance, deductionTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutsideDeductionRecordBean)) {
            return false;
        }
        OutsideDeductionRecordBean outsideDeductionRecordBean = (OutsideDeductionRecordBean) other;
        return Intrinsics.areEqual(this.planName, outsideDeductionRecordBean.planName) && this.useTime == outsideDeductionRecordBean.useTime && this.deductionDistance == outsideDeductionRecordBean.deductionDistance && this.deductionTimes == outsideDeductionRecordBean.deductionTimes;
    }

    @NotNull
    public final String formatDistance() {
        return z62.f46193a.b(Long.valueOf(this.deductionDistance), 2);
    }

    @NotNull
    public final String formatTimes() {
        return String.valueOf(this.deductionTimes);
    }

    @NotNull
    public final String formatUseTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("运动时长：");
        z62 z62Var = z62.f46193a;
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.useTime / 3600.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        sb.append(z62Var.d(str, 1));
        sb.append('h');
        return sb.toString();
    }

    public final long getDeductionDistance() {
        return this.deductionDistance;
    }

    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final String getPlanName() {
        return this.planName;
    }

    public final long getUseTime() {
        return this.useTime;
    }

    public int hashCode() {
        return (((((this.planName.hashCode() * 31) + Long.hashCode(this.useTime)) * 31) + Long.hashCode(this.deductionDistance)) * 31) + Integer.hashCode(this.deductionTimes);
    }

    @NotNull
    public String toString() {
        return "OutsideDeductionRecordBean(planName=" + this.planName + ", useTime=" + this.useTime + ", deductionDistance=" + this.deductionDistance + ", deductionTimes=" + this.deductionTimes + ')';
    }

    public /* synthetic */ OutsideDeductionRecordBean(String str, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? 0 : i);
    }
}
