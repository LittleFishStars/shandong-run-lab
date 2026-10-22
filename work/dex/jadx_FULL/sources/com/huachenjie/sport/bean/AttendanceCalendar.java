package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/sport/bean/AttendanceCalendar;", "", "attendDate", "", "attendStatus", "", "attendTimestamp", "", "(Ljava/lang/String;IJ)V", "getAttendDate", "()Ljava/lang/String;", "getAttendStatus", "()I", "getAttendTimestamp", "()J", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendanceCalendar {

    @NotNull
    private final String attendDate;
    private final int attendStatus;
    private final long attendTimestamp;

    public AttendanceCalendar(@NotNull String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "attendDate");
        this.attendDate = str;
        this.attendStatus = i;
        this.attendTimestamp = j;
    }

    public static /* synthetic */ AttendanceCalendar copy$default(AttendanceCalendar attendanceCalendar, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = attendanceCalendar.attendDate;
        }
        if ((i2 & 2) != 0) {
            i = attendanceCalendar.attendStatus;
        }
        if ((i2 & 4) != 0) {
            j = attendanceCalendar.attendTimestamp;
        }
        return attendanceCalendar.copy(str, i, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttendDate() {
        return this.attendDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAttendStatus() {
        return this.attendStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getAttendTimestamp() {
        return this.attendTimestamp;
    }

    @NotNull
    public final AttendanceCalendar copy(@NotNull String attendDate, int attendStatus, long attendTimestamp) {
        Intrinsics.checkNotNullParameter(attendDate, "attendDate");
        return new AttendanceCalendar(attendDate, attendStatus, attendTimestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceCalendar)) {
            return false;
        }
        AttendanceCalendar attendanceCalendar = (AttendanceCalendar) other;
        return Intrinsics.areEqual(this.attendDate, attendanceCalendar.attendDate) && this.attendStatus == attendanceCalendar.attendStatus && this.attendTimestamp == attendanceCalendar.attendTimestamp;
    }

    @NotNull
    public final String getAttendDate() {
        return this.attendDate;
    }

    public final int getAttendStatus() {
        return this.attendStatus;
    }

    public final long getAttendTimestamp() {
        return this.attendTimestamp;
    }

    public int hashCode() {
        return (((this.attendDate.hashCode() * 31) + Integer.hashCode(this.attendStatus)) * 31) + Long.hashCode(this.attendTimestamp);
    }

    @NotNull
    public String toString() {
        return "AttendanceCalendar(attendDate=" + this.attendDate + ", attendStatus=" + this.attendStatus + ", attendTimestamp=" + this.attendTimestamp + ')';
    }
}
