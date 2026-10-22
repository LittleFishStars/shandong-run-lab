package com.huachenjie.compat.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/compat/bean/CourseInfo;", "", "courseName", "", "courseCode", "subjectName", "teacherName", "attendWeekDay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttendWeekDay", "()Ljava/lang/String;", "getCourseCode", "getCourseName", "getSubjectName", "getTeacherName", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CourseInfo {

    @NotNull
    private final String attendWeekDay;

    @NotNull
    private final String courseCode;

    @NotNull
    private final String courseName;

    @NotNull
    private final String subjectName;

    @NotNull
    private final String teacherName;

    public CourseInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public CourseInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        Intrinsics.checkNotNullParameter(str2, "courseCode");
        Intrinsics.checkNotNullParameter(str3, "subjectName");
        Intrinsics.checkNotNullParameter(str4, "teacherName");
        Intrinsics.checkNotNullParameter(str5, "attendWeekDay");
        this.courseName = str;
        this.courseCode = str2;
        this.subjectName = str3;
        this.teacherName = str4;
        this.attendWeekDay = str5;
    }

    public static /* synthetic */ CourseInfo copy$default(CourseInfo courseInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseInfo.courseName;
        }
        if ((i & 2) != 0) {
            str2 = courseInfo.courseCode;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = courseInfo.subjectName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = courseInfo.teacherName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = courseInfo.attendWeekDay;
        }
        return courseInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCourseCode() {
        return this.courseCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeacherName() {
        return this.teacherName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAttendWeekDay() {
        return this.attendWeekDay;
    }

    @NotNull
    public final CourseInfo copy(@NotNull String courseName, @NotNull String courseCode, @NotNull String subjectName, @NotNull String teacherName, @NotNull String attendWeekDay) {
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(courseCode, "courseCode");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(teacherName, "teacherName");
        Intrinsics.checkNotNullParameter(attendWeekDay, "attendWeekDay");
        return new CourseInfo(courseName, courseCode, subjectName, teacherName, attendWeekDay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseInfo)) {
            return false;
        }
        CourseInfo courseInfo = (CourseInfo) other;
        return Intrinsics.areEqual(this.courseName, courseInfo.courseName) && Intrinsics.areEqual(this.courseCode, courseInfo.courseCode) && Intrinsics.areEqual(this.subjectName, courseInfo.subjectName) && Intrinsics.areEqual(this.teacherName, courseInfo.teacherName) && Intrinsics.areEqual(this.attendWeekDay, courseInfo.attendWeekDay);
    }

    @NotNull
    public final String getAttendWeekDay() {
        return this.attendWeekDay;
    }

    @NotNull
    public final String getCourseCode() {
        return this.courseCode;
    }

    @NotNull
    public final String getCourseName() {
        return this.courseName;
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getTeacherName() {
        return this.teacherName;
    }

    public int hashCode() {
        return (((((((this.courseName.hashCode() * 31) + this.courseCode.hashCode()) * 31) + this.subjectName.hashCode()) * 31) + this.teacherName.hashCode()) * 31) + this.attendWeekDay.hashCode();
    }

    @NotNull
    public String toString() {
        return "CourseInfo(courseName=" + this.courseName + ", courseCode=" + this.courseCode + ", subjectName=" + this.subjectName + ", teacherName=" + this.teacherName + ", attendWeekDay=" + this.attendWeekDay + ')';
    }

    public /* synthetic */ CourseInfo(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}
