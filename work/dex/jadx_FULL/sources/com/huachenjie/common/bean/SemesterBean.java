package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/huachenjie/common/bean/SemesterBean;", "", "semesterCode", "", "name", "status", "", "startTime", "", "endTime", "planOptionFlag", "", "(Ljava/lang/String;Ljava/lang/String;IJJZ)V", "getEndTime", "()J", "getName", "()Ljava/lang/String;", "getPlanOptionFlag", "()Z", "getSemesterCode", "getStartTime", "getStatus", "()I", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SemesterBean {
    private final long endTime;

    @NotNull
    private final String name;
    private final boolean planOptionFlag;

    @NotNull
    private final String semesterCode;
    private final long startTime;
    private final int status;

    public SemesterBean(@NotNull String str, @NotNull String str2, int i, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "semesterCode");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.semesterCode = str;
        this.name = str2;
        this.status = i;
        this.startTime = j;
        this.endTime = j2;
        this.planOptionFlag = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSemesterCode() {
        return this.semesterCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getPlanOptionFlag() {
        return this.planOptionFlag;
    }

    @NotNull
    public final SemesterBean copy(@NotNull String semesterCode, @NotNull String name, int status, long startTime, long endTime, boolean planOptionFlag) {
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SemesterBean(semesterCode, name, status, startTime, endTime, planOptionFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemesterBean)) {
            return false;
        }
        SemesterBean semesterBean = (SemesterBean) other;
        return Intrinsics.areEqual(this.semesterCode, semesterBean.semesterCode) && Intrinsics.areEqual(this.name, semesterBean.name) && this.status == semesterBean.status && this.startTime == semesterBean.startTime && this.endTime == semesterBean.endTime && this.planOptionFlag == semesterBean.planOptionFlag;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getPlanOptionFlag() {
        return this.planOptionFlag;
    }

    @NotNull
    public final String getSemesterCode() {
        return this.semesterCode;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((((this.semesterCode.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31;
        boolean z = this.planOptionFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "SemesterBean(semesterCode=" + this.semesterCode + ", name=" + this.name + ", status=" + this.status + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", planOptionFlag=" + this.planOptionFlag + ")";
    }

    public /* synthetic */ SemesterBean(String str, String str2, int i, long j, long j2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, i, j, j2, (i2 & 32) != 0 ? false : z);
    }
}
