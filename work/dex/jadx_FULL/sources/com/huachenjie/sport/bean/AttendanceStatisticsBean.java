package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/sport/bean/AttendanceStatisticsBean;", "", "semesterAttendAbsenceTotal", "", "semesterAttendLeaveTotal", "semesterAttendLateTotal", "semesterAttendEarlyTotal", "semesterAttendSuccessTotal", "semesterAttendTotal", "(IIIIII)V", "getSemesterAttendAbsenceTotal", "()I", "getSemesterAttendEarlyTotal", "getSemesterAttendLateTotal", "getSemesterAttendLeaveTotal", "getSemesterAttendSuccessTotal", "getSemesterAttendTotal", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendanceStatisticsBean {
    private final int semesterAttendAbsenceTotal;
    private final int semesterAttendEarlyTotal;
    private final int semesterAttendLateTotal;
    private final int semesterAttendLeaveTotal;
    private final int semesterAttendSuccessTotal;
    private final int semesterAttendTotal;

    public AttendanceStatisticsBean(int i, int i2, int i3, int i4, int i5, int i6) {
        this.semesterAttendAbsenceTotal = i;
        this.semesterAttendLeaveTotal = i2;
        this.semesterAttendLateTotal = i3;
        this.semesterAttendEarlyTotal = i4;
        this.semesterAttendSuccessTotal = i5;
        this.semesterAttendTotal = i6;
    }

    public static /* synthetic */ AttendanceStatisticsBean copy$default(AttendanceStatisticsBean attendanceStatisticsBean, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = attendanceStatisticsBean.semesterAttendAbsenceTotal;
        }
        if ((i7 & 2) != 0) {
            i2 = attendanceStatisticsBean.semesterAttendLeaveTotal;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = attendanceStatisticsBean.semesterAttendLateTotal;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = attendanceStatisticsBean.semesterAttendEarlyTotal;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = attendanceStatisticsBean.semesterAttendSuccessTotal;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = attendanceStatisticsBean.semesterAttendTotal;
        }
        return attendanceStatisticsBean.copy(i, i8, i9, i10, i11, i6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSemesterAttendAbsenceTotal() {
        return this.semesterAttendAbsenceTotal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSemesterAttendLeaveTotal() {
        return this.semesterAttendLeaveTotal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSemesterAttendLateTotal() {
        return this.semesterAttendLateTotal;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSemesterAttendEarlyTotal() {
        return this.semesterAttendEarlyTotal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSemesterAttendSuccessTotal() {
        return this.semesterAttendSuccessTotal;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSemesterAttendTotal() {
        return this.semesterAttendTotal;
    }

    @NotNull
    public final AttendanceStatisticsBean copy(int semesterAttendAbsenceTotal, int semesterAttendLeaveTotal, int semesterAttendLateTotal, int semesterAttendEarlyTotal, int semesterAttendSuccessTotal, int semesterAttendTotal) {
        return new AttendanceStatisticsBean(semesterAttendAbsenceTotal, semesterAttendLeaveTotal, semesterAttendLateTotal, semesterAttendEarlyTotal, semesterAttendSuccessTotal, semesterAttendTotal);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceStatisticsBean)) {
            return false;
        }
        AttendanceStatisticsBean attendanceStatisticsBean = (AttendanceStatisticsBean) other;
        return this.semesterAttendAbsenceTotal == attendanceStatisticsBean.semesterAttendAbsenceTotal && this.semesterAttendLeaveTotal == attendanceStatisticsBean.semesterAttendLeaveTotal && this.semesterAttendLateTotal == attendanceStatisticsBean.semesterAttendLateTotal && this.semesterAttendEarlyTotal == attendanceStatisticsBean.semesterAttendEarlyTotal && this.semesterAttendSuccessTotal == attendanceStatisticsBean.semesterAttendSuccessTotal && this.semesterAttendTotal == attendanceStatisticsBean.semesterAttendTotal;
    }

    public final int getSemesterAttendAbsenceTotal() {
        return this.semesterAttendAbsenceTotal;
    }

    public final int getSemesterAttendEarlyTotal() {
        return this.semesterAttendEarlyTotal;
    }

    public final int getSemesterAttendLateTotal() {
        return this.semesterAttendLateTotal;
    }

    public final int getSemesterAttendLeaveTotal() {
        return this.semesterAttendLeaveTotal;
    }

    public final int getSemesterAttendSuccessTotal() {
        return this.semesterAttendSuccessTotal;
    }

    public final int getSemesterAttendTotal() {
        return this.semesterAttendTotal;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.semesterAttendAbsenceTotal) * 31) + Integer.hashCode(this.semesterAttendLeaveTotal)) * 31) + Integer.hashCode(this.semesterAttendLateTotal)) * 31) + Integer.hashCode(this.semesterAttendEarlyTotal)) * 31) + Integer.hashCode(this.semesterAttendSuccessTotal)) * 31) + Integer.hashCode(this.semesterAttendTotal);
    }

    @NotNull
    public String toString() {
        return "AttendanceStatisticsBean(semesterAttendAbsenceTotal=" + this.semesterAttendAbsenceTotal + ", semesterAttendLeaveTotal=" + this.semesterAttendLeaveTotal + ", semesterAttendLateTotal=" + this.semesterAttendLateTotal + ", semesterAttendEarlyTotal=" + this.semesterAttendEarlyTotal + ", semesterAttendSuccessTotal=" + this.semesterAttendSuccessTotal + ", semesterAttendTotal=" + this.semesterAttendTotal + ')';
    }

    public /* synthetic */ AttendanceStatisticsBean(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, i5, i6);
    }
}
