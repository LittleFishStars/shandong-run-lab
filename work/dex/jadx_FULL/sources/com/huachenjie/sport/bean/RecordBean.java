package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/huachenjie/sport/bean/RecordBean;", "", "attendDateTimestamp", "", "attendLocationName", "", "attendStatus", "", "courseName", "signType", "studentAttendanceRecordCode", "(JLjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getAttendDateTimestamp", "()J", "getAttendLocationName", "()Ljava/lang/String;", "getAttendStatus", "()I", "getCourseName", "getSignType", "getStudentAttendanceRecordCode", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RecordBean {
    private final long attendDateTimestamp;

    @NotNull
    private final String attendLocationName;
    private final int attendStatus;

    @NotNull
    private final String courseName;
    private final int signType;

    @NotNull
    private final String studentAttendanceRecordCode;

    public RecordBean(long j, @NotNull String str, int i, @NotNull String str2, int i2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "attendLocationName");
        Intrinsics.checkNotNullParameter(str2, "courseName");
        Intrinsics.checkNotNullParameter(str3, "studentAttendanceRecordCode");
        this.attendDateTimestamp = j;
        this.attendLocationName = str;
        this.attendStatus = i;
        this.courseName = str2;
        this.signType = i2;
        this.studentAttendanceRecordCode = str3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getAttendDateTimestamp() {
        return this.attendDateTimestamp;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAttendLocationName() {
        return this.attendLocationName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAttendStatus() {
        return this.attendStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSignType() {
        return this.signType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStudentAttendanceRecordCode() {
        return this.studentAttendanceRecordCode;
    }

    @NotNull
    public final RecordBean copy(long attendDateTimestamp, @NotNull String attendLocationName, int attendStatus, @NotNull String courseName, int signType, @NotNull String studentAttendanceRecordCode) {
        Intrinsics.checkNotNullParameter(attendLocationName, "attendLocationName");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(studentAttendanceRecordCode, "studentAttendanceRecordCode");
        return new RecordBean(attendDateTimestamp, attendLocationName, attendStatus, courseName, signType, studentAttendanceRecordCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordBean)) {
            return false;
        }
        RecordBean recordBean = (RecordBean) other;
        return this.attendDateTimestamp == recordBean.attendDateTimestamp && Intrinsics.areEqual(this.attendLocationName, recordBean.attendLocationName) && this.attendStatus == recordBean.attendStatus && Intrinsics.areEqual(this.courseName, recordBean.courseName) && this.signType == recordBean.signType && Intrinsics.areEqual(this.studentAttendanceRecordCode, recordBean.studentAttendanceRecordCode);
    }

    public final long getAttendDateTimestamp() {
        return this.attendDateTimestamp;
    }

    @NotNull
    public final String getAttendLocationName() {
        return this.attendLocationName;
    }

    public final int getAttendStatus() {
        return this.attendStatus;
    }

    @NotNull
    public final String getCourseName() {
        return this.courseName;
    }

    public final int getSignType() {
        return this.signType;
    }

    @NotNull
    public final String getStudentAttendanceRecordCode() {
        return this.studentAttendanceRecordCode;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.attendDateTimestamp) * 31) + this.attendLocationName.hashCode()) * 31) + Integer.hashCode(this.attendStatus)) * 31) + this.courseName.hashCode()) * 31) + Integer.hashCode(this.signType)) * 31) + this.studentAttendanceRecordCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecordBean(attendDateTimestamp=" + this.attendDateTimestamp + ", attendLocationName=" + this.attendLocationName + ", attendStatus=" + this.attendStatus + ", courseName=" + this.courseName + ", signType=" + this.signType + ", studentAttendanceRecordCode=" + this.studentAttendanceRecordCode + ')';
    }
}
