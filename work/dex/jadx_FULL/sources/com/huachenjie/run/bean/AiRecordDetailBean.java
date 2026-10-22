package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.z62;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/run/bean/AiRecordDetailBean;", "", "configName", "", "endTime", "deductionDistance", "", "deductionTimes", "", "(Ljava/lang/String;Ljava/lang/String;JI)V", "getConfigName", "()Ljava/lang/String;", "getDeductionDistance", "()J", "getDeductionTimes", "()I", "getEndTime", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "formatDistance", "formatTimes", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AiRecordDetailBean {

    @NotNull
    private final String configName;
    private final long deductionDistance;
    private final int deductionTimes;

    @NotNull
    private final String endTime;

    public AiRecordDetailBean() {
        this(null, null, 0L, 0, 15, null);
    }

    public AiRecordDetailBean(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "configName");
        Intrinsics.checkNotNullParameter(str2, "endTime");
        this.configName = str;
        this.endTime = str2;
        this.deductionDistance = j;
        this.deductionTimes = i;
    }

    public static /* synthetic */ AiRecordDetailBean copy$default(AiRecordDetailBean aiRecordDetailBean, String str, String str2, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aiRecordDetailBean.configName;
        }
        if ((i2 & 2) != 0) {
            str2 = aiRecordDetailBean.endTime;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            j = aiRecordDetailBean.deductionDistance;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            i = aiRecordDetailBean.deductionTimes;
        }
        return aiRecordDetailBean.copy(str, str3, j2, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getConfigName() {
        return this.configName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
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
    public final AiRecordDetailBean copy(@NotNull String configName, @NotNull String endTime, long deductionDistance, int deductionTimes) {
        Intrinsics.checkNotNullParameter(configName, "configName");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        return new AiRecordDetailBean(configName, endTime, deductionDistance, deductionTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiRecordDetailBean)) {
            return false;
        }
        AiRecordDetailBean aiRecordDetailBean = (AiRecordDetailBean) other;
        return Intrinsics.areEqual(this.configName, aiRecordDetailBean.configName) && Intrinsics.areEqual(this.endTime, aiRecordDetailBean.endTime) && this.deductionDistance == aiRecordDetailBean.deductionDistance && this.deductionTimes == aiRecordDetailBean.deductionTimes;
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
    public final String getConfigName() {
        return this.configName;
    }

    public final long getDeductionDistance() {
        return this.deductionDistance;
    }

    public final int getDeductionTimes() {
        return this.deductionTimes;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    public int hashCode() {
        return (((((this.configName.hashCode() * 31) + this.endTime.hashCode()) * 31) + Long.hashCode(this.deductionDistance)) * 31) + Integer.hashCode(this.deductionTimes);
    }

    @NotNull
    public String toString() {
        return "AiRecordDetailBean(configName=" + this.configName + ", endTime=" + this.endTime + ", deductionDistance=" + this.deductionDistance + ", deductionTimes=" + this.deductionTimes + ')';
    }

    public /* synthetic */ AiRecordDetailBean(String str, String str2, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? 0 : i);
    }
}
