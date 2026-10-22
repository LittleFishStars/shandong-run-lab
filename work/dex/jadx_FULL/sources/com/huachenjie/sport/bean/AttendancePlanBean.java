package com.huachenjie.sport.bean;

import android.graphics.Color;
import com.heytap.mcssdk.constant.b;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.SignPeriod;
import com.huachenjie.common.bean.SignSegment;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.huachenjie.sport.R;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.c49;
import com.zj.adlib.s72;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Ji\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\tJ\u0006\u0010-\u001a\u00020\tJ\u0006\u0010.\u001a\u00020\tJ\u0006\u0010/\u001a\u00020\tJ\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\rH\u0002J\u0006\u00102\u001a\u00020\u0003J\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u00020\tJ\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0006\u00107\u001a\u00020)J\t\u00108\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00069"}, d2 = {"Lcom/huachenjie/sport/bean/AttendancePlanBean;", "", "attendanceTimes", "", "weekTimes", b.t, "", "exerciseTime", "name", "", "outsideConfigCode", "signPeriodList", "", "Lcom/huachenjie/common/bean/SignPeriod;", b.s, "status", "(IIJILjava/lang/String;Ljava/lang/String;Ljava/util/List;JI)V", "getAttendanceTimes", "()I", "getEndDate", "()J", "getExerciseTime", "getName", "()Ljava/lang/String;", "getOutsideConfigCode", "getSignPeriodList", "()Ljava/util/List;", "getStartDate", "getStatus", "getWeekTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "getAttendanceTimesStr", "getDateStr", "getExerciseTimeStr", "getFirstSignPeriod", "getSecondSignPeriod", "getSignPeriodStr", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "getStatusBackground", "getStatusColor", "getStatusStr", "getWeekTimesStr", "hashCode", "showSecondSignPeriod", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendancePlanBean {
    private final int attendanceTimes;
    private final long endDate;
    private final int exerciseTime;

    @NotNull
    private final String name;

    @NotNull
    private final String outsideConfigCode;

    @NotNull
    private final List<SignPeriod> signPeriodList;
    private final long startDate;
    private final int status;
    private final int weekTimes;

    public AttendancePlanBean(int i, int i2, long j, int i3, @NotNull String str, @NotNull String str2, @NotNull List<SignPeriod> list, long j2, int i4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "outsideConfigCode");
        Intrinsics.checkNotNullParameter(list, "signPeriodList");
        this.attendanceTimes = i;
        this.weekTimes = i2;
        this.endDate = j;
        this.exerciseTime = i3;
        this.name = str;
        this.outsideConfigCode = str2;
        this.signPeriodList = list;
        this.startDate = j2;
        this.status = i4;
    }

    private final String getSignPeriodStr(SignPeriod bean) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bean.getWeek());
        stringBuffer.append(" ");
        for (SignSegment signSegment : bean.getTimeSegmentList()) {
            stringBuffer.append(signSegment.getStartTime());
            stringBuffer.append(c49.f40900a);
            stringBuffer.append(signSegment.getEndTime());
            stringBuffer.append(" ");
        }
        stringBuffer.substring(0, stringBuffer.length() - 1);
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAttendanceTimes() {
        return this.attendanceTimes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWeekTimes() {
        return this.weekTimes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getExerciseTime() {
        return this.exerciseTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOutsideConfigCode() {
        return this.outsideConfigCode;
    }

    @NotNull
    public final List<SignPeriod> component7() {
        return this.signPeriodList;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final AttendancePlanBean copy(int attendanceTimes, int weekTimes, long endDate, int exerciseTime, @NotNull String name, @NotNull String outsideConfigCode, @NotNull List<SignPeriod> signPeriodList, long startDate, int status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        Intrinsics.checkNotNullParameter(signPeriodList, "signPeriodList");
        return new AttendancePlanBean(attendanceTimes, weekTimes, endDate, exerciseTime, name, outsideConfigCode, signPeriodList, startDate, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendancePlanBean)) {
            return false;
        }
        AttendancePlanBean attendancePlanBean = (AttendancePlanBean) other;
        return this.attendanceTimes == attendancePlanBean.attendanceTimes && this.weekTimes == attendancePlanBean.weekTimes && this.endDate == attendancePlanBean.endDate && this.exerciseTime == attendancePlanBean.exerciseTime && Intrinsics.areEqual(this.name, attendancePlanBean.name) && Intrinsics.areEqual(this.outsideConfigCode, attendancePlanBean.outsideConfigCode) && Intrinsics.areEqual(this.signPeriodList, attendancePlanBean.signPeriodList) && this.startDate == attendancePlanBean.startDate && this.status == attendancePlanBean.status;
    }

    public final int getAttendanceTimes() {
        return this.attendanceTimes;
    }

    @NotNull
    public final String getAttendanceTimesStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.attendanceTimes);
        sb.append((char) 27425);
        return sb.toString();
    }

    @NotNull
    public final String getDateStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s72.c(this.startDate, "yyyy.MM.dd"));
        stringBuffer.append(c49.f40900a);
        stringBuffer.append(s72.c(this.endDate, "yyyy.MM.dd"));
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final int getExerciseTime() {
        return this.exerciseTime;
    }

    @NotNull
    public final String getExerciseTimeStr() {
        return (this.exerciseTime / 60) + MoreDistanceDialog.VALUE_MIN;
    }

    @NotNull
    public final String getFirstSignPeriod() {
        List<SignPeriod> list = this.signPeriodList;
        return (list == null || !(list.isEmpty() ^ true)) ? "" : getSignPeriodStr(this.signPeriodList.get(0));
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOutsideConfigCode() {
        return this.outsideConfigCode;
    }

    @NotNull
    public final String getSecondSignPeriod() {
        List<SignPeriod> list = this.signPeriodList;
        return (list == null || list.size() <= 1) ? "" : getSignPeriodStr(this.signPeriodList.get(1));
    }

    @NotNull
    public final List<SignPeriod> getSignPeriodList() {
        return this.signPeriodList;
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getStatusBackground() {
        int i = this.status;
        if (i == 0) {
            return R.drawable.bg_attendance_plan_unstart;
        }
        if (i != 1) {
            return i != 2 ? R.drawable.bg_attendance_plan_end : R.drawable.bg_attendance_plan_end;
        }
        return R.drawable.bg_attendance_plan_start;
    }

    public final int getStatusColor() {
        if (this.status != 0) {
            return -1;
        }
        return Color.parseColor(RouteOverlay.f12338c);
    }

    @NotNull
    public final String getStatusStr() {
        int i = this.status;
        if (i != 0) {
            return i != 1 ? "已结束" : "进行中";
        }
        return "未开始";
    }

    public final int getWeekTimes() {
        return this.weekTimes;
    }

    @NotNull
    public final String getWeekTimesStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.weekTimes);
        sb.append((char) 27425);
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.attendanceTimes) * 31) + Integer.hashCode(this.weekTimes)) * 31) + Long.hashCode(this.endDate)) * 31) + Integer.hashCode(this.exerciseTime)) * 31) + this.name.hashCode()) * 31) + this.outsideConfigCode.hashCode()) * 31) + this.signPeriodList.hashCode()) * 31) + Long.hashCode(this.startDate)) * 31) + Integer.hashCode(this.status);
    }

    public final boolean showSecondSignPeriod() {
        List<SignPeriod> list = this.signPeriodList;
        return list != null && list.size() > 1;
    }

    @NotNull
    public String toString() {
        return "AttendancePlanBean(attendanceTimes=" + this.attendanceTimes + ", weekTimes=" + this.weekTimes + ", endDate=" + this.endDate + ", exerciseTime=" + this.exerciseTime + ", name=" + this.name + ", outsideConfigCode=" + this.outsideConfigCode + ", signPeriodList=" + this.signPeriodList + ", startDate=" + this.startDate + ", status=" + this.status + ')';
    }
}
