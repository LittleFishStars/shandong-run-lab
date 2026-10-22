package com.huachenjie.run.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.run.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006("}, d2 = {"Lcom/huachenjie/run/bean/ActivityRunBean;", "", "activityName", "", "sunRunActivityCode", "activityStatus", "", "runPlanName", "runPlanCode", "rewardInfo", "dateTime", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getActivityStatus", "()I", "activityStatusStr", "getActivityStatusStr", "backgroundResource", "getBackgroundResource", "getDateTime", "getRewardInfo", "getRunPlanCode", "getRunPlanName", "getSunRunActivityCode", "textColor", "getTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActivityRunBean {

    @NotNull
    private final String activityName;
    private final int activityStatus;

    @NotNull
    private final String dateTime;

    @NotNull
    private final String rewardInfo;

    @NotNull
    private final String runPlanCode;

    @NotNull
    private final String runPlanName;

    @NotNull
    private final String sunRunActivityCode;

    public ActivityRunBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "activityName");
        Intrinsics.checkNotNullParameter(str2, "sunRunActivityCode");
        Intrinsics.checkNotNullParameter(str3, "runPlanName");
        Intrinsics.checkNotNullParameter(str4, "runPlanCode");
        Intrinsics.checkNotNullParameter(str5, "rewardInfo");
        Intrinsics.checkNotNullParameter(str6, "dateTime");
        this.activityName = str;
        this.sunRunActivityCode = str2;
        this.activityStatus = i;
        this.runPlanName = str3;
        this.runPlanCode = str4;
        this.rewardInfo = str5;
        this.dateTime = str6;
    }

    public static /* synthetic */ ActivityRunBean copy$default(ActivityRunBean activityRunBean, String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = activityRunBean.activityName;
        }
        if ((i2 & 2) != 0) {
            str2 = activityRunBean.sunRunActivityCode;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            i = activityRunBean.activityStatus;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = activityRunBean.runPlanName;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = activityRunBean.runPlanCode;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = activityRunBean.rewardInfo;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            str6 = activityRunBean.dateTime;
        }
        return activityRunBean.copy(str, str7, i3, str8, str9, str10, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSunRunActivityCode() {
        return this.sunRunActivityCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRunPlanCode() {
        return this.runPlanCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRewardInfo() {
        return this.rewardInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDateTime() {
        return this.dateTime;
    }

    @NotNull
    public final ActivityRunBean copy(@NotNull String activityName, @NotNull String sunRunActivityCode, int activityStatus, @NotNull String runPlanName, @NotNull String runPlanCode, @NotNull String rewardInfo, @NotNull String dateTime) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(sunRunActivityCode, "sunRunActivityCode");
        Intrinsics.checkNotNullParameter(runPlanName, "runPlanName");
        Intrinsics.checkNotNullParameter(runPlanCode, "runPlanCode");
        Intrinsics.checkNotNullParameter(rewardInfo, "rewardInfo");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        return new ActivityRunBean(activityName, sunRunActivityCode, activityStatus, runPlanName, runPlanCode, rewardInfo, dateTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityRunBean)) {
            return false;
        }
        ActivityRunBean activityRunBean = (ActivityRunBean) other;
        return Intrinsics.areEqual(this.activityName, activityRunBean.activityName) && Intrinsics.areEqual(this.sunRunActivityCode, activityRunBean.sunRunActivityCode) && this.activityStatus == activityRunBean.activityStatus && Intrinsics.areEqual(this.runPlanName, activityRunBean.runPlanName) && Intrinsics.areEqual(this.runPlanCode, activityRunBean.runPlanCode) && Intrinsics.areEqual(this.rewardInfo, activityRunBean.rewardInfo) && Intrinsics.areEqual(this.dateTime, activityRunBean.dateTime);
    }

    @NotNull
    public final String getActivityName() {
        return this.activityName;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    public final String getActivityStatusStr() {
        int i = this.activityStatus;
        if (i == 0) {
            return "待开始";
        }
        if (i != 1) {
            return i != 2 ? "未知" : "已结束";
        }
        return "进行中";
    }

    public final int getBackgroundResource() {
        int i = this.activityStatus;
        if (i == 0) {
            return R.drawable.run_shape_bg_activity_run_wait;
        }
        if (i != 1) {
            return i != 2 ? R.drawable.run_shape_bg_activity_run_wait : R.drawable.run_shape_bg_activity_run_end;
        }
        return R.drawable.run_shape_bg_activity_run_ing;
    }

    @NotNull
    public final String getDateTime() {
        return this.dateTime;
    }

    @NotNull
    public final String getRewardInfo() {
        return this.rewardInfo;
    }

    @NotNull
    public final String getRunPlanCode() {
        return this.runPlanCode;
    }

    @NotNull
    public final String getRunPlanName() {
        return this.runPlanName;
    }

    @NotNull
    public final String getSunRunActivityCode() {
        return this.sunRunActivityCode;
    }

    public final int getTextColor() {
        int i = this.activityStatus;
        if (i == 0) {
            return -10155284;
        }
        if (i != 1) {
            return i != 2 ? -10155284 : -7759964;
        }
        return -1;
    }

    public int hashCode() {
        return (((((((((((this.activityName.hashCode() * 31) + this.sunRunActivityCode.hashCode()) * 31) + Integer.hashCode(this.activityStatus)) * 31) + this.runPlanName.hashCode()) * 31) + this.runPlanCode.hashCode()) * 31) + this.rewardInfo.hashCode()) * 31) + this.dateTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityRunBean(activityName=" + this.activityName + ", sunRunActivityCode=" + this.sunRunActivityCode + ", activityStatus=" + this.activityStatus + ", runPlanName=" + this.runPlanName + ", runPlanCode=" + this.runPlanCode + ", rewardInfo=" + this.rewardInfo + ", dateTime=" + this.dateTime + ')';
    }
}
