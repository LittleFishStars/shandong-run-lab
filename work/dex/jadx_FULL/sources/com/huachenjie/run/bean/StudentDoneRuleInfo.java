package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.run.page.ai_deduction.AiDeductionDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/huachenjie/run/bean/StudentDoneRuleInfo;", "", "completionRate", "", "doneDistance", "", "doneTargetTimes", "", AiDeductionDetailActivity.y, "awardDistance", "awardTimes", "(FJIIII)V", "getAwardDistance", "()I", "getAwardTimes", "getCompletionRate", "()F", "getDoneDistance", "()J", "getDoneTargetTimes", "getMorningTimes", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StudentDoneRuleInfo {
    private final int awardDistance;
    private final int awardTimes;
    private final float completionRate;
    private final long doneDistance;
    private final int doneTargetTimes;
    private final int morningTimes;

    public StudentDoneRuleInfo() {
        this(0.0f, 0L, 0, 0, 0, 0, 63, null);
    }

    public StudentDoneRuleInfo(float f, long j, int i, int i2, int i3, int i4) {
        this.completionRate = f;
        this.doneDistance = j;
        this.doneTargetTimes = i;
        this.morningTimes = i2;
        this.awardDistance = i3;
        this.awardTimes = i4;
    }

    public static /* synthetic */ StudentDoneRuleInfo copy$default(StudentDoneRuleInfo studentDoneRuleInfo, float f, long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f = studentDoneRuleInfo.completionRate;
        }
        if ((i5 & 2) != 0) {
            j = studentDoneRuleInfo.doneDistance;
        }
        long j2 = j;
        if ((i5 & 4) != 0) {
            i = studentDoneRuleInfo.doneTargetTimes;
        }
        int i6 = i;
        if ((i5 & 8) != 0) {
            i2 = studentDoneRuleInfo.morningTimes;
        }
        int i7 = i2;
        if ((i5 & 16) != 0) {
            i3 = studentDoneRuleInfo.awardDistance;
        }
        int i8 = i3;
        if ((i5 & 32) != 0) {
            i4 = studentDoneRuleInfo.awardTimes;
        }
        return studentDoneRuleInfo.copy(f, j2, i6, i7, i8, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getCompletionRate() {
        return this.completionRate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDoneDistance() {
        return this.doneDistance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDoneTargetTimes() {
        return this.doneTargetTimes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMorningTimes() {
        return this.morningTimes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAwardDistance() {
        return this.awardDistance;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAwardTimes() {
        return this.awardTimes;
    }

    @NotNull
    public final StudentDoneRuleInfo copy(float completionRate, long doneDistance, int doneTargetTimes, int morningTimes, int awardDistance, int awardTimes) {
        return new StudentDoneRuleInfo(completionRate, doneDistance, doneTargetTimes, morningTimes, awardDistance, awardTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StudentDoneRuleInfo)) {
            return false;
        }
        StudentDoneRuleInfo studentDoneRuleInfo = (StudentDoneRuleInfo) other;
        return Float.compare(this.completionRate, studentDoneRuleInfo.completionRate) == 0 && this.doneDistance == studentDoneRuleInfo.doneDistance && this.doneTargetTimes == studentDoneRuleInfo.doneTargetTimes && this.morningTimes == studentDoneRuleInfo.morningTimes && this.awardDistance == studentDoneRuleInfo.awardDistance && this.awardTimes == studentDoneRuleInfo.awardTimes;
    }

    public final int getAwardDistance() {
        return this.awardDistance;
    }

    public final int getAwardTimes() {
        return this.awardTimes;
    }

    public final float getCompletionRate() {
        return this.completionRate;
    }

    public final long getDoneDistance() {
        return this.doneDistance;
    }

    public final int getDoneTargetTimes() {
        return this.doneTargetTimes;
    }

    public final int getMorningTimes() {
        return this.morningTimes;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.completionRate) * 31) + Long.hashCode(this.doneDistance)) * 31) + Integer.hashCode(this.doneTargetTimes)) * 31) + Integer.hashCode(this.morningTimes)) * 31) + Integer.hashCode(this.awardDistance)) * 31) + Integer.hashCode(this.awardTimes);
    }

    @NotNull
    public String toString() {
        return "StudentDoneRuleInfo(completionRate=" + this.completionRate + ", doneDistance=" + this.doneDistance + ", doneTargetTimes=" + this.doneTargetTimes + ", morningTimes=" + this.morningTimes + ", awardDistance=" + this.awardDistance + ", awardTimes=" + this.awardTimes + ')';
    }

    public /* synthetic */ StudentDoneRuleInfo(float f, long j, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0.0f : f, (i5 & 2) != 0 ? 0L : j, (i5 & 4) != 0 ? 0 : i, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? 0 : i4);
    }
}
