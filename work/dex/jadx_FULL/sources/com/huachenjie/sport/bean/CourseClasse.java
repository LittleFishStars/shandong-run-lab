package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/bean/CourseClasse;", "", "courses", "", "teacherNames", "(Ljava/lang/String;Ljava/lang/String;)V", "getCourses", "()Ljava/lang/String;", "getTeacherNames", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CourseClasse {

    @Nullable
    private final String courses;

    @Nullable
    private final String teacherNames;

    /* JADX WARN: Illegal instructions before constructor call */
    public CourseClasse() {
        String str = null;
        this(str, str, 3, str);
    }

    public CourseClasse(@Nullable String str, @Nullable String str2) {
        this.courses = str;
        this.teacherNames = str2;
    }

    public static /* synthetic */ CourseClasse copy$default(CourseClasse courseClasse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseClasse.courses;
        }
        if ((i & 2) != 0) {
            str2 = courseClasse.teacherNames;
        }
        return courseClasse.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourses() {
        return this.courses;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeacherNames() {
        return this.teacherNames;
    }

    @NotNull
    public final CourseClasse copy(@Nullable String courses, @Nullable String teacherNames) {
        return new CourseClasse(courses, teacherNames);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseClasse)) {
            return false;
        }
        CourseClasse courseClasse = (CourseClasse) other;
        return Intrinsics.areEqual(this.courses, courseClasse.courses) && Intrinsics.areEqual(this.teacherNames, courseClasse.teacherNames);
    }

    @Nullable
    public final String getCourses() {
        return this.courses;
    }

    @Nullable
    public final String getTeacherNames() {
        return this.teacherNames;
    }

    public int hashCode() {
        String str = this.courses;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.teacherNames;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CourseClasse(courses=" + this.courses + ", teacherNames=" + this.teacherNames + ')';
    }

    public /* synthetic */ CourseClasse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
