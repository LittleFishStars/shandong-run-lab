package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JH\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/huachenjie/sport/bean/ScoringItem;", "", "projectType", "", "score", "signalLevel", "testResult", "", "testFlag", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Z)V", "getProjectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScore", "getSignalLevel", "getTestFlag", "()Z", "getTestResult", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Z)Lcom/huachenjie/sport/bean/ScoringItem;", "equals", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ScoringItem {

    @Nullable
    private final Integer projectType;

    @Nullable
    private final Integer score;

    @Nullable
    private final Integer signalLevel;
    private final boolean testFlag;

    @Nullable
    private final Double testResult;

    public ScoringItem() {
        this(null, null, null, null, false, 31, null);
    }

    public ScoringItem(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Double d, boolean z) {
        this.projectType = num;
        this.score = num2;
        this.signalLevel = num3;
        this.testResult = d;
        this.testFlag = z;
    }

    public static /* synthetic */ ScoringItem copy$default(ScoringItem scoringItem, Integer num, Integer num2, Integer num3, Double d, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = scoringItem.projectType;
        }
        if ((i & 2) != 0) {
            num2 = scoringItem.score;
        }
        Integer num4 = num2;
        if ((i & 4) != 0) {
            num3 = scoringItem.signalLevel;
        }
        Integer num5 = num3;
        if ((i & 8) != 0) {
            d = scoringItem.testResult;
        }
        Double d2 = d;
        if ((i & 16) != 0) {
            z = scoringItem.testFlag;
        }
        return scoringItem.copy(num, num4, num5, d2, z);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getProjectType() {
        return this.projectType;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getScore() {
        return this.score;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSignalLevel() {
        return this.signalLevel;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getTestResult() {
        return this.testResult;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getTestFlag() {
        return this.testFlag;
    }

    @NotNull
    public final ScoringItem copy(@Nullable Integer projectType, @Nullable Integer score, @Nullable Integer signalLevel, @Nullable Double testResult, boolean testFlag) {
        return new ScoringItem(projectType, score, signalLevel, testResult, testFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScoringItem)) {
            return false;
        }
        ScoringItem scoringItem = (ScoringItem) other;
        return Intrinsics.areEqual(this.projectType, scoringItem.projectType) && Intrinsics.areEqual(this.score, scoringItem.score) && Intrinsics.areEqual(this.signalLevel, scoringItem.signalLevel) && Intrinsics.areEqual(this.testResult, scoringItem.testResult) && this.testFlag == scoringItem.testFlag;
    }

    @Nullable
    public final Integer getProjectType() {
        return this.projectType;
    }

    @Nullable
    public final Integer getScore() {
        return this.score;
    }

    @Nullable
    public final Integer getSignalLevel() {
        return this.signalLevel;
    }

    public final boolean getTestFlag() {
        return this.testFlag;
    }

    @Nullable
    public final Double getTestResult() {
        return this.testResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Integer num = this.projectType;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.score;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.signalLevel;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d = this.testResult;
        int iHashCode4 = (iHashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        boolean z = this.testFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    @NotNull
    public String toString() {
        return "ScoringItem(projectType=" + this.projectType + ", score=" + this.score + ", signalLevel=" + this.signalLevel + ", testResult=" + this.testResult + ", testFlag=" + this.testFlag + ')';
    }

    public /* synthetic */ ScoringItem(Integer num, Integer num2, Integer num3, Double d, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) == 0 ? d : null, (i & 16) != 0 ? false : z);
    }
}
