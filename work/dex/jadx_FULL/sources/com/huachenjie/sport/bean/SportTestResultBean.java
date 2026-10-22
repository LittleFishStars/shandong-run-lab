package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010 \u001a\u00020\rHÆ\u0003J`\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/huachenjie/sport/bean/SportTestResultBean;", "", "addPointItems", "", "Lcom/huachenjie/sport/bean/AddPointItem;", "scoringItems", "Lcom/huachenjie/sport/bean/ScoringItem;", "testStatus", "", "totalLevel", "totalScore", "", "fitnessAllScoreVisible", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Z)V", "getAddPointItems", "()Ljava/util/List;", "getFitnessAllScoreVisible", "()Z", "getScoringItems", "getTestStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalLevel", "getTotalScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Z)Lcom/huachenjie/sport/bean/SportTestResultBean;", "equals", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportTestResultBean {

    @Nullable
    private final List<AddPointItem> addPointItems;
    private final boolean fitnessAllScoreVisible;

    @Nullable
    private final List<ScoringItem> scoringItems;

    @Nullable
    private final Integer testStatus;

    @Nullable
    private final Integer totalLevel;

    @Nullable
    private final Double totalScore;

    public SportTestResultBean() {
        this(null, null, null, null, null, false, 63, null);
    }

    public SportTestResultBean(@Nullable List<AddPointItem> list, @Nullable List<ScoringItem> list2, @Nullable Integer num, @Nullable Integer num2, @Nullable Double d, boolean z) {
        this.addPointItems = list;
        this.scoringItems = list2;
        this.testStatus = num;
        this.totalLevel = num2;
        this.totalScore = d;
        this.fitnessAllScoreVisible = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportTestResultBean copy$default(SportTestResultBean sportTestResultBean, List list, List list2, Integer num, Integer num2, Double d, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sportTestResultBean.addPointItems;
        }
        if ((i & 2) != 0) {
            list2 = sportTestResultBean.scoringItems;
        }
        List list3 = list2;
        if ((i & 4) != 0) {
            num = sportTestResultBean.testStatus;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = sportTestResultBean.totalLevel;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            d = sportTestResultBean.totalScore;
        }
        Double d2 = d;
        if ((i & 32) != 0) {
            z = sportTestResultBean.fitnessAllScoreVisible;
        }
        return sportTestResultBean.copy(list, list3, num3, num4, d2, z);
    }

    @Nullable
    public final List<AddPointItem> component1() {
        return this.addPointItems;
    }

    @Nullable
    public final List<ScoringItem> component2() {
        return this.scoringItems;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTestStatus() {
        return this.testStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTotalLevel() {
        return this.totalLevel;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getTotalScore() {
        return this.totalScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getFitnessAllScoreVisible() {
        return this.fitnessAllScoreVisible;
    }

    @NotNull
    public final SportTestResultBean copy(@Nullable List<AddPointItem> addPointItems, @Nullable List<ScoringItem> scoringItems, @Nullable Integer testStatus, @Nullable Integer totalLevel, @Nullable Double totalScore, boolean fitnessAllScoreVisible) {
        return new SportTestResultBean(addPointItems, scoringItems, testStatus, totalLevel, totalScore, fitnessAllScoreVisible);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportTestResultBean)) {
            return false;
        }
        SportTestResultBean sportTestResultBean = (SportTestResultBean) other;
        return Intrinsics.areEqual(this.addPointItems, sportTestResultBean.addPointItems) && Intrinsics.areEqual(this.scoringItems, sportTestResultBean.scoringItems) && Intrinsics.areEqual(this.testStatus, sportTestResultBean.testStatus) && Intrinsics.areEqual(this.totalLevel, sportTestResultBean.totalLevel) && Intrinsics.areEqual(this.totalScore, sportTestResultBean.totalScore) && this.fitnessAllScoreVisible == sportTestResultBean.fitnessAllScoreVisible;
    }

    @Nullable
    public final List<AddPointItem> getAddPointItems() {
        return this.addPointItems;
    }

    public final boolean getFitnessAllScoreVisible() {
        return this.fitnessAllScoreVisible;
    }

    @Nullable
    public final List<ScoringItem> getScoringItems() {
        return this.scoringItems;
    }

    @Nullable
    public final Integer getTestStatus() {
        return this.testStatus;
    }

    @Nullable
    public final Integer getTotalLevel() {
        return this.totalLevel;
    }

    @Nullable
    public final Double getTotalScore() {
        return this.totalScore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<AddPointItem> list = this.addPointItems;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ScoringItem> list2 = this.scoringItems;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.testStatus;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.totalLevel;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.totalScore;
        int iHashCode5 = (iHashCode4 + (d != null ? d.hashCode() : 0)) * 31;
        boolean z = this.fitnessAllScoreVisible;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    @NotNull
    public String toString() {
        return "SportTestResultBean(addPointItems=" + this.addPointItems + ", scoringItems=" + this.scoringItems + ", testStatus=" + this.testStatus + ", totalLevel=" + this.totalLevel + ", totalScore=" + this.totalScore + ", fitnessAllScoreVisible=" + this.fitnessAllScoreVisible + ')';
    }

    public /* synthetic */ SportTestResultBean(List list, List list2, Integer num, Integer num2, Double d, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) == 0 ? d : null, (i & 32) != 0 ? false : z);
    }
}
