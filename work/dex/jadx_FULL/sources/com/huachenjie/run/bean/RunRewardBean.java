package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J`\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006="}, d2 = {"Lcom/huachenjie/run/bean/RunRewardBean;", "", "activityName", "", "createTime", "", "activityDistance", "", "activityTimes", "remarks", "showLookMore", "", "index", "expanded", "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Boolean;IZ)V", "getActivityDistance", "()I", "activityDistanceDisplay", "getActivityDistanceDisplay", "()Ljava/lang/String;", "activityDistanceKM", "getActivityDistanceKM", "getActivityName", "getActivityTimes", "activityTimesDisplay", "getActivityTimesDisplay", "activityTimesStr", "getActivityTimesStr", "getCreateTime", "()J", "expandBtnText", "getExpandBtnText", "getExpanded", "()Z", "setExpanded", "(Z)V", "getIndex", "setIndex", "(I)V", "indexStr", "getIndexStr", "getRemarks", "getShowLookMore", "()Ljava/lang/Boolean;", "setShowLookMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "(Ljava/lang/String;JIILjava/lang/String;Ljava/lang/Boolean;IZ)Lcom/huachenjie/run/bean/RunRewardBean;", "equals", "other", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunRewardBean {
    private final int activityDistance;

    @NotNull
    private final String activityName;
    private final int activityTimes;
    private final long createTime;
    private boolean expanded;
    private int index;

    @NotNull
    private final String remarks;

    @Nullable
    private Boolean showLookMore;

    public RunRewardBean() {
        this(null, 0L, 0, 0, null, null, 0, false, 255, null);
    }

    public RunRewardBean(@NotNull String str, long j, int i, int i2, @NotNull String str2, @Nullable Boolean bool, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "activityName");
        Intrinsics.checkNotNullParameter(str2, "remarks");
        this.activityName = str;
        this.createTime = j;
        this.activityDistance = i;
        this.activityTimes = i2;
        this.remarks = str2;
        this.showLookMore = bool;
        this.index = i3;
        this.expanded = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getActivityDistance() {
        return this.activityDistance;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getActivityTimes() {
        return this.activityTimes;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getShowLookMore() {
        return this.showLookMore;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    @NotNull
    public final RunRewardBean copy(@NotNull String activityName, long createTime, int activityDistance, int activityTimes, @NotNull String remarks, @Nullable Boolean showLookMore, int index, boolean expanded) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        return new RunRewardBean(activityName, createTime, activityDistance, activityTimes, remarks, showLookMore, index, expanded);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunRewardBean)) {
            return false;
        }
        RunRewardBean runRewardBean = (RunRewardBean) other;
        return Intrinsics.areEqual(this.activityName, runRewardBean.activityName) && this.createTime == runRewardBean.createTime && this.activityDistance == runRewardBean.activityDistance && this.activityTimes == runRewardBean.activityTimes && Intrinsics.areEqual(this.remarks, runRewardBean.remarks) && Intrinsics.areEqual(this.showLookMore, runRewardBean.showLookMore) && this.index == runRewardBean.index && this.expanded == runRewardBean.expanded;
    }

    public final int getActivityDistance() {
        return this.activityDistance;
    }

    @NotNull
    public final String getActivityDistanceDisplay() {
        return getActivityDistanceKM() + "km";
    }

    @NotNull
    public final String getActivityDistanceKM() {
        String strF = ll7.f43096a.f(Integer.valueOf(this.activityDistance), false, false, 2);
        return strF == null ? "0.00" : strF;
    }

    @NotNull
    public final String getActivityName() {
        return this.activityName;
    }

    public final int getActivityTimes() {
        return this.activityTimes;
    }

    @NotNull
    public final String getActivityTimesDisplay() {
        return this.activityTimes + " 次";
    }

    @NotNull
    public final String getActivityTimesStr() {
        String strC = s72.c(this.createTime, "yyyy.MM.dd HH:mm:ss");
        Intrinsics.checkNotNullExpressionValue(strC, "formatDateTimeByFormat(c…e, \"yyyy.MM.dd HH:mm:ss\")");
        return strC;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getExpandBtnText() {
        return this.expanded ? "收起" : "展开";
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getIndexStr() {
        return String.valueOf(this.index);
    }

    @NotNull
    public final String getRemarks() {
        return this.remarks;
    }

    @Nullable
    public final Boolean getShowLookMore() {
        return this.showLookMore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    public int hashCode() {
        int iHashCode = ((((((((this.activityName.hashCode() * 31) + Long.hashCode(this.createTime)) * 31) + Integer.hashCode(this.activityDistance)) * 31) + Integer.hashCode(this.activityTimes)) * 31) + this.remarks.hashCode()) * 31;
        Boolean bool = this.showLookMore;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Integer.hashCode(this.index)) * 31;
        boolean z = this.expanded;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final void setExpanded(boolean z) {
        this.expanded = z;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setShowLookMore(@Nullable Boolean bool) {
        this.showLookMore = bool;
    }

    @NotNull
    public String toString() {
        return "RunRewardBean(activityName=" + this.activityName + ", createTime=" + this.createTime + ", activityDistance=" + this.activityDistance + ", activityTimes=" + this.activityTimes + ", remarks=" + this.remarks + ", showLookMore=" + this.showLookMore + ", index=" + this.index + ", expanded=" + this.expanded + ')';
    }

    public /* synthetic */ RunRewardBean(String str, long j, int i, int i2, String str2, Boolean bool, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0L : j, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) == 0 ? str2 : "", (i4 & 32) != 0 ? Boolean.FALSE : bool, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) == 0 ? z : false);
    }
}
