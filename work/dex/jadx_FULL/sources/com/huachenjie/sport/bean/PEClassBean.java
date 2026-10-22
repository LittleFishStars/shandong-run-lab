package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jx\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u0006+"}, d2 = {"Lcom/huachenjie/sport/bean/PEClassBean;", "", "courseName", "", "courseCode", "subjectName", "teacherName", "attendWeekDay", "semesterStatus", "", "remainCount", "semesterName", "electiveEndDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAttendWeekDay", "()Ljava/lang/String;", "getCourseCode", "getCourseName", "getElectiveEndDate", "getRemainCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSemesterName", "getSemesterStatus", "()I", "getSubjectName", "getTeacherName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/huachenjie/sport/bean/PEClassBean;", "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PEClassBean {

    @Nullable
    private final String attendWeekDay;

    @Nullable
    private final String courseCode;

    @Nullable
    private final String courseName;

    @Nullable
    private final String electiveEndDate;

    @Nullable
    private final Integer remainCount;

    @Nullable
    private final String semesterName;
    private final int semesterStatus;

    @Nullable
    private final String subjectName;

    @Nullable
    private final String teacherName;

    public PEClassBean() {
        this(null, null, null, null, null, 0, null, null, null, 511, null);
    }

    public PEClassBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, @Nullable Integer num, @Nullable String str6, @Nullable String str7) {
        this.courseName = str;
        this.courseCode = str2;
        this.subjectName = str3;
        this.teacherName = str4;
        this.attendWeekDay = str5;
        this.semesterStatus = i;
        this.remainCount = num;
        this.semesterName = str6;
        this.electiveEndDate = str7;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCourseCode() {
        return this.courseCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeacherName() {
        return this.teacherName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAttendWeekDay() {
        return this.attendWeekDay;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSemesterStatus() {
        return this.semesterStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSemesterName() {
        return this.semesterName;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getElectiveEndDate() {
        return this.electiveEndDate;
    }

    @NotNull
    public final PEClassBean copy(@Nullable String courseName, @Nullable String courseCode, @Nullable String subjectName, @Nullable String teacherName, @Nullable String attendWeekDay, int semesterStatus, @Nullable Integer remainCount, @Nullable String semesterName, @Nullable String electiveEndDate) {
        return new PEClassBean(courseName, courseCode, subjectName, teacherName, attendWeekDay, semesterStatus, remainCount, semesterName, electiveEndDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PEClassBean)) {
            return false;
        }
        PEClassBean pEClassBean = (PEClassBean) other;
        return Intrinsics.areEqual(this.courseName, pEClassBean.courseName) && Intrinsics.areEqual(this.courseCode, pEClassBean.courseCode) && Intrinsics.areEqual(this.subjectName, pEClassBean.subjectName) && Intrinsics.areEqual(this.teacherName, pEClassBean.teacherName) && Intrinsics.areEqual(this.attendWeekDay, pEClassBean.attendWeekDay) && this.semesterStatus == pEClassBean.semesterStatus && Intrinsics.areEqual(this.remainCount, pEClassBean.remainCount) && Intrinsics.areEqual(this.semesterName, pEClassBean.semesterName) && Intrinsics.areEqual(this.electiveEndDate, pEClassBean.electiveEndDate);
    }

    @Nullable
    public final String getAttendWeekDay() {
        return this.attendWeekDay;
    }

    @Nullable
    public final String getCourseCode() {
        return this.courseCode;
    }

    @Nullable
    public final String getCourseName() {
        return this.courseName;
    }

    @Nullable
    public final String getElectiveEndDate() {
        return this.electiveEndDate;
    }

    @Nullable
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    @Nullable
    public final String getSemesterName() {
        return this.semesterName;
    }

    public final int getSemesterStatus() {
        return this.semesterStatus;
    }

    @Nullable
    public final String getSubjectName() {
        return this.subjectName;
    }

    @Nullable
    public final String getTeacherName() {
        return this.teacherName;
    }

    public int hashCode() {
        String str = this.courseName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.courseCode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subjectName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.teacherName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.attendWeekDay;
        int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.semesterStatus)) * 31;
        Integer num = this.remainCount;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.semesterName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.electiveEndDate;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PEClassBean(courseName=" + this.courseName + ", courseCode=" + this.courseCode + ", subjectName=" + this.subjectName + ", teacherName=" + this.teacherName + ", attendWeekDay=" + this.attendWeekDay + ", semesterStatus=" + this.semesterStatus + ", remainCount=" + this.remainCount + ", semesterName=" + this.semesterName + ", electiveEndDate=" + this.electiveEndDate + ')';
    }

    public /* synthetic */ PEClassBean(String str, String str2, String str3, String str4, String str5, int i, Integer num, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? 0 : num, (i2 & 128) != 0 ? null : str6, (i2 & 256) == 0 ? str7 : null);
    }
}
