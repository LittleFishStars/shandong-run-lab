package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.z62;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006!"}, d2 = {"Lcom/huachenjie/run/bean/WearableDeductionRecordBean;", "", "sportTypeName", "", "recordNo", "deductionDistance", "", "deductionTimes", "deductionTime", "", "(Ljava/lang/String;Ljava/lang/String;IIJ)V", "getDeductionDistance", "()I", "getDeductionTime", "()J", "getDeductionTimes", "getRecordNo", "()Ljava/lang/String;", "getSportTypeName", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "formatDeductionTime", "formatDistance", "formatTimes", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WearableDeductionRecordBean {
    private final int deductionDistance;
    private final long deductionTime;
    private final int deductionTimes;

    @NotNull
    private final String recordNo;

    @NotNull
    private final String sportTypeName;

    public WearableDeductionRecordBean() {
        this(null, null, 0, 0, 0L, 31, null);
    }

    public WearableDeductionRecordBean(@NotNull String str, @NotNull String str2, int i, int i2, long j) {
        Intrinsics.checkNotNullParameter(str, "sportTypeName");
        Intrinsics.checkNotNullParameter(str2, "recordNo");
        this.sportTypeName = str;
        this.recordNo = str2;
        this.deductionDistance = i;
        this.deductionTimes = i2;
        this.deductionTime = j;
    }

    public static /* synthetic */ WearableDeductionRecordBean copy$default(WearableDeductionRecordBean wearableDeductionRecordBean, String str, String str2, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = wearableDeductionRecordBean.sportTypeName;
        }
        if ((i3 & 2) != 0) {
            str2 = wearableDeductionRecordBean.recordNo;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i = wearableDeductionRecordBean.deductionDistance;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = wearableDeductionRecordBean.deductionTimes;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            j = wearableDeductionRecordBean.deductionTime;
        }
        return wearableDeductionRecordBean.copy(str, str3, i4, i5, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSportTypeName() {
        return this.sportTypeName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecordNo() {
        return this.recordNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDeductionDistance() {
        return this.deductionDistance;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDeductionTime() {
        return this.deductionTime;
    }

    @NotNull
    public final WearableDeductionRecordBean copy(@NotNull String sportTypeName, @NotNull String recordNo, int deductionDistance, int deductionTimes, long deductionTime) {
        Intrinsics.checkNotNullParameter(sportTypeName, "sportTypeName");
        Intrinsics.checkNotNullParameter(recordNo, "recordNo");
        return new WearableDeductionRecordBean(sportTypeName, recordNo, deductionDistance, deductionTimes, deductionTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WearableDeductionRecordBean)) {
            return false;
        }
        WearableDeductionRecordBean wearableDeductionRecordBean = (WearableDeductionRecordBean) other;
        return Intrinsics.areEqual(this.sportTypeName, wearableDeductionRecordBean.sportTypeName) && Intrinsics.areEqual(this.recordNo, wearableDeductionRecordBean.recordNo) && this.deductionDistance == wearableDeductionRecordBean.deductionDistance && this.deductionTimes == wearableDeductionRecordBean.deductionTimes && this.deductionTime == wearableDeductionRecordBean.deductionTime;
    }

    @NotNull
    public final String formatDeductionTime() {
        if (this.deductionTime <= 0) {
            return "";
        }
        String str = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss", Locale.getDefault()).format(new Date(this.deductionTime));
        Intrinsics.checkNotNullExpressionValue(str, "SimpleDateFormat(\"yyyy.M…rmat(Date(deductionTime))");
        return str;
    }

    @NotNull
    public final String formatDistance() {
        return z62.f46193a.b(Long.valueOf(this.deductionDistance), 2);
    }

    @NotNull
    public final String formatTimes() {
        return String.valueOf(this.deductionTimes);
    }

    public final int getDeductionDistance() {
        return this.deductionDistance;
    }

    public final long getDeductionTime() {
        return this.deductionTime;
    }

    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final String getRecordNo() {
        return this.recordNo;
    }

    @NotNull
    public final String getSportTypeName() {
        return this.sportTypeName;
    }

    public int hashCode() {
        return (((((((this.sportTypeName.hashCode() * 31) + this.recordNo.hashCode()) * 31) + Integer.hashCode(this.deductionDistance)) * 31) + Integer.hashCode(this.deductionTimes)) * 31) + Long.hashCode(this.deductionTime);
    }

    @NotNull
    public String toString() {
        return "WearableDeductionRecordBean(sportTypeName=" + this.sportTypeName + ", recordNo=" + this.recordNo + ", deductionDistance=" + this.deductionDistance + ", deductionTimes=" + this.deductionTimes + ", deductionTime=" + this.deductionTime + ')';
    }

    public /* synthetic */ WearableDeductionRecordBean(String str, String str2, int i, int i2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "", (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? 0L : j);
    }
}
