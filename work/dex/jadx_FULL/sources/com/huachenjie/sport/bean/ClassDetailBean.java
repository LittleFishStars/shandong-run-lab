package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003JÞ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\u00122\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0007HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001a¨\u0006H"}, d2 = {"Lcom/huachenjie/sport/bean/ClassDetailBean;", "", "applySex", "", "attendWeekDay", "courseCode", "courseCount", "", "courseDate", "courseIntroduction", "courseLocation", "courseName", "semesterStatus", "gradeDepartmentList", "", "Lcom/huachenjie/sport/bean/GradeDepartment;", "remainCount", "selected", "", "semesterName", "signUpStatus", "subjectName", "teacherName", "electiveEndDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApplySex", "()Ljava/lang/String;", "getAttendWeekDay", "getCourseCode", "getCourseCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCourseDate", "getCourseIntroduction", "getCourseLocation", "getCourseName", "getElectiveEndDate", "getGradeDepartmentList", "()Ljava/util/List;", "getRemainCount", "getSelected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSemesterName", "getSemesterStatus", "()I", "getSignUpStatus", "getSubjectName", "getTeacherName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/huachenjie/sport/bean/ClassDetailBean;", "equals", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClassDetailBean {

    @Nullable
    private final String applySex;

    @Nullable
    private final String attendWeekDay;

    @Nullable
    private final String courseCode;

    @Nullable
    private final Integer courseCount;

    @Nullable
    private final String courseDate;

    @Nullable
    private final String courseIntroduction;

    @Nullable
    private final String courseLocation;

    @Nullable
    private final String courseName;

    @Nullable
    private final String electiveEndDate;

    @Nullable
    private final List<GradeDepartment> gradeDepartmentList;

    @Nullable
    private final Integer remainCount;

    @Nullable
    private final Boolean selected;

    @Nullable
    private final String semesterName;
    private final int semesterStatus;

    @Nullable
    private final Integer signUpStatus;

    @Nullable
    private final String subjectName;

    @Nullable
    private final String teacherName;

    public ClassDetailBean() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, 131071, null);
    }

    public ClassDetailBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i, @Nullable List<GradeDepartment> list, @Nullable Integer num2, @Nullable Boolean bool, @Nullable String str8, @Nullable Integer num3, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.applySex = str;
        this.attendWeekDay = str2;
        this.courseCode = str3;
        this.courseCount = num;
        this.courseDate = str4;
        this.courseIntroduction = str5;
        this.courseLocation = str6;
        this.courseName = str7;
        this.semesterStatus = i;
        this.gradeDepartmentList = list;
        this.remainCount = num2;
        this.selected = bool;
        this.semesterName = str8;
        this.signUpStatus = num3;
        this.subjectName = str9;
        this.teacherName = str10;
        this.electiveEndDate = str11;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApplySex() {
        return this.applySex;
    }

    @Nullable
    public final List<GradeDepartment> component10() {
        return this.gradeDepartmentList;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSemesterName() {
        return this.semesterName;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getSignUpStatus() {
        return this.signUpStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getTeacherName() {
        return this.teacherName;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getElectiveEndDate() {
        return this.electiveEndDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAttendWeekDay() {
        return this.attendWeekDay;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCourseCode() {
        return this.courseCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getCourseCount() {
        return this.courseCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCourseDate() {
        return this.courseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCourseIntroduction() {
        return this.courseIntroduction;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCourseLocation() {
        return this.courseLocation;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSemesterStatus() {
        return this.semesterStatus;
    }

    @NotNull
    public final ClassDetailBean copy(@Nullable String applySex, @Nullable String attendWeekDay, @Nullable String courseCode, @Nullable Integer courseCount, @Nullable String courseDate, @Nullable String courseIntroduction, @Nullable String courseLocation, @Nullable String courseName, int semesterStatus, @Nullable List<GradeDepartment> gradeDepartmentList, @Nullable Integer remainCount, @Nullable Boolean selected, @Nullable String semesterName, @Nullable Integer signUpStatus, @Nullable String subjectName, @Nullable String teacherName, @Nullable String electiveEndDate) {
        return new ClassDetailBean(applySex, attendWeekDay, courseCode, courseCount, courseDate, courseIntroduction, courseLocation, courseName, semesterStatus, gradeDepartmentList, remainCount, selected, semesterName, signUpStatus, subjectName, teacherName, electiveEndDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassDetailBean)) {
            return false;
        }
        ClassDetailBean classDetailBean = (ClassDetailBean) other;
        return Intrinsics.areEqual(this.applySex, classDetailBean.applySex) && Intrinsics.areEqual(this.attendWeekDay, classDetailBean.attendWeekDay) && Intrinsics.areEqual(this.courseCode, classDetailBean.courseCode) && Intrinsics.areEqual(this.courseCount, classDetailBean.courseCount) && Intrinsics.areEqual(this.courseDate, classDetailBean.courseDate) && Intrinsics.areEqual(this.courseIntroduction, classDetailBean.courseIntroduction) && Intrinsics.areEqual(this.courseLocation, classDetailBean.courseLocation) && Intrinsics.areEqual(this.courseName, classDetailBean.courseName) && this.semesterStatus == classDetailBean.semesterStatus && Intrinsics.areEqual(this.gradeDepartmentList, classDetailBean.gradeDepartmentList) && Intrinsics.areEqual(this.remainCount, classDetailBean.remainCount) && Intrinsics.areEqual(this.selected, classDetailBean.selected) && Intrinsics.areEqual(this.semesterName, classDetailBean.semesterName) && Intrinsics.areEqual(this.signUpStatus, classDetailBean.signUpStatus) && Intrinsics.areEqual(this.subjectName, classDetailBean.subjectName) && Intrinsics.areEqual(this.teacherName, classDetailBean.teacherName) && Intrinsics.areEqual(this.electiveEndDate, classDetailBean.electiveEndDate);
    }

    @Nullable
    public final String getApplySex() {
        return this.applySex;
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
    public final Integer getCourseCount() {
        return this.courseCount;
    }

    @Nullable
    public final String getCourseDate() {
        return this.courseDate;
    }

    @Nullable
    public final String getCourseIntroduction() {
        return this.courseIntroduction;
    }

    @Nullable
    public final String getCourseLocation() {
        return this.courseLocation;
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
    public final List<GradeDepartment> getGradeDepartmentList() {
        return this.gradeDepartmentList;
    }

    @Nullable
    public final Integer getRemainCount() {
        return this.remainCount;
    }

    @Nullable
    public final Boolean getSelected() {
        return this.selected;
    }

    @Nullable
    public final String getSemesterName() {
        return this.semesterName;
    }

    public final int getSemesterStatus() {
        return this.semesterStatus;
    }

    @Nullable
    public final Integer getSignUpStatus() {
        return this.signUpStatus;
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
        String str = this.applySex;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.attendWeekDay;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.courseCode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.courseCount;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.courseDate;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.courseIntroduction;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.courseLocation;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.courseName;
        int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.semesterStatus)) * 31;
        List<GradeDepartment> list = this.gradeDepartmentList;
        int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.remainCount;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.selected;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str8 = this.semesterName;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num3 = this.signUpStatus;
        int iHashCode13 = (iHashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str9 = this.subjectName;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.teacherName;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.electiveEndDate;
        return iHashCode15 + (str11 != null ? str11.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClassDetailBean(applySex=" + this.applySex + ", attendWeekDay=" + this.attendWeekDay + ", courseCode=" + this.courseCode + ", courseCount=" + this.courseCount + ", courseDate=" + this.courseDate + ", courseIntroduction=" + this.courseIntroduction + ", courseLocation=" + this.courseLocation + ", courseName=" + this.courseName + ", semesterStatus=" + this.semesterStatus + ", gradeDepartmentList=" + this.gradeDepartmentList + ", remainCount=" + this.remainCount + ", selected=" + this.selected + ", semesterName=" + this.semesterName + ", signUpStatus=" + this.signUpStatus + ", subjectName=" + this.subjectName + ", teacherName=" + this.teacherName + ", electiveEndDate=" + this.electiveEndDate + ')';
    }

    public /* synthetic */ ClassDetailBean(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, int i, List list, Integer num2, Boolean bool, String str8, Integer num3, String str9, String str10, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? null : list, (i2 & 1024) != 0 ? null : num2, (i2 & 2048) != 0 ? null : bool, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : num3, (i2 & 16384) != 0 ? null : str9, (i2 & 32768) != 0 ? null : str10, (i2 & 65536) != 0 ? null : str11);
    }
}
