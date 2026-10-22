package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.z62;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lcom/huachenjie/run/bean/VenueRecordDetailBean;", "", "planName", "", "deductionType", "", "useTime", "deductionDistance", "", "deductionTimes", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getDeductionDistance", "()J", "getDeductionTimes", "()Ljava/lang/String;", "getDeductionType", "()I", "getPlanName", "getUseTime", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "formatDistance", "formatTimes", "formatUseTime", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VenueRecordDetailBean {
    private final long deductionDistance;

    @NotNull
    private final String deductionTimes;
    private final int deductionType;

    @NotNull
    private final String planName;
    private final int useTime;

    public VenueRecordDetailBean() {
        this(null, 0, 0, 0L, null, 31, null);
    }

    public VenueRecordDetailBean(@NotNull String str, int i, int i2, long j, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "planName");
        Intrinsics.checkNotNullParameter(str2, "deductionTimes");
        this.planName = str;
        this.deductionType = i;
        this.useTime = i2;
        this.deductionDistance = j;
        this.deductionTimes = str2;
    }

    public static /* synthetic */ VenueRecordDetailBean copy$default(VenueRecordDetailBean venueRecordDetailBean, String str, int i, int i2, long j, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = venueRecordDetailBean.planName;
        }
        if ((i3 & 2) != 0) {
            i = venueRecordDetailBean.deductionType;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = venueRecordDetailBean.useTime;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            j = venueRecordDetailBean.deductionDistance;
        }
        long j2 = j;
        if ((i3 & 16) != 0) {
            str2 = venueRecordDetailBean.deductionTimes;
        }
        return venueRecordDetailBean.copy(str, i4, i5, j2, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlanName() {
        return this.planName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeductionType() {
        return this.deductionType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getUseTime() {
        return this.useTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getDeductionDistance() {
        return this.deductionDistance;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeductionTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final VenueRecordDetailBean copy(@NotNull String planName, int deductionType, int useTime, long deductionDistance, @NotNull String deductionTimes) {
        Intrinsics.checkNotNullParameter(planName, "planName");
        Intrinsics.checkNotNullParameter(deductionTimes, "deductionTimes");
        return new VenueRecordDetailBean(planName, deductionType, useTime, deductionDistance, deductionTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VenueRecordDetailBean)) {
            return false;
        }
        VenueRecordDetailBean venueRecordDetailBean = (VenueRecordDetailBean) other;
        return Intrinsics.areEqual(this.planName, venueRecordDetailBean.planName) && this.deductionType == venueRecordDetailBean.deductionType && this.useTime == venueRecordDetailBean.useTime && this.deductionDistance == venueRecordDetailBean.deductionDistance && Intrinsics.areEqual(this.deductionTimes, venueRecordDetailBean.deductionTimes);
    }

    @NotNull
    public final String formatDistance() {
        return z62.f46193a.b(Long.valueOf(this.deductionDistance), 2);
    }

    @NotNull
    public final String formatTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final String formatUseTime() {
        return "运动时长：" + z62.f46193a.d(String.valueOf(this.useTime / 3600.0f), 1) + 'h';
    }

    public final long getDeductionDistance() {
        return this.deductionDistance;
    }

    @NotNull
    public final String getDeductionTimes() {
        return this.deductionTimes;
    }

    public final int getDeductionType() {
        return this.deductionType;
    }

    @NotNull
    public final String getPlanName() {
        return this.planName;
    }

    public final int getUseTime() {
        return this.useTime;
    }

    public int hashCode() {
        return (((((((this.planName.hashCode() * 31) + Integer.hashCode(this.deductionType)) * 31) + Integer.hashCode(this.useTime)) * 31) + Long.hashCode(this.deductionDistance)) * 31) + this.deductionTimes.hashCode();
    }

    @NotNull
    public String toString() {
        return "VenueRecordDetailBean(planName=" + this.planName + ", deductionType=" + this.deductionType + ", useTime=" + this.useTime + ", deductionDistance=" + this.deductionDistance + ", deductionTimes=" + this.deductionTimes + ')';
    }

    public /* synthetic */ VenueRecordDetailBean(String str, int i, int i2, long j, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? "" : str2);
    }
}
