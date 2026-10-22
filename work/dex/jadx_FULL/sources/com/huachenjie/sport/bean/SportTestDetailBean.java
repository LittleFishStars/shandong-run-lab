package com.huachenjie.sport.bean;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bG\b\u0086\b\u0018\u00002\u00020\u0001B³\u0002\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\"J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010T\u001a\u00020\u001eHÆ\u0003J\t\u0010U\u001a\u00020\u001eHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010W\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010&J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\bHÆ\u0003J¼\u0002\u0010_\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0002\u0010`J\u0013\u0010a\u001a\u00020\u001e2\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u000bHÖ\u0001J\t\u0010d\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010!\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u001a\u0010\u001f\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010;\u001a\u0004\b?\u0010:R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b@\u0010-R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010 \u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010'\u001a\u0004\bF\u0010&¨\u0006e"}, d2 = {"Lcom/huachenjie/sport/bean/SportTestDetailBean;", "", "administrativeClasses", "", "Lcom/huachenjie/sport/bean/AdministrativeClasse;", "courseClasses", "Lcom/huachenjie/sport/bean/CourseClasse;", "departmentNames", "", "fitnessTestDate", "fitnessTestStatus", "", "fitnessType", "gradeNames", RequestParameters.SUBRESOURCE_LOCATION, "remark", "reserveDate", "reserveEndTime", "", "reserveNumber", "reservePeriod", "reservePeriods", "reserveStartTime", "reserveTimeStatus", "teacherNames", "testProjectNames", "title", "uniqueCode", "Lcom/huachenjie/sport/bean/UniqueCode;", "hasInformedConsent", "", "hasConsent", "userReserveStatus", "canBeModified", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/sport/bean/UniqueCode;ZZLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getAdministrativeClasses", "()Ljava/util/List;", "getCanBeModified", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCourseClasses", "getDepartmentNames", "getFitnessTestDate", "()Ljava/lang/String;", "getFitnessTestStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFitnessType", "getGradeNames", "getHasConsent", "()Z", "setHasConsent", "(Z)V", "getHasInformedConsent", "getLocation", "getRemark", "getReserveDate", "getReserveEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReserveNumber", "getReservePeriod", "getReservePeriods", "getReserveStartTime", "getReserveTimeStatus", "getTeacherNames", "getTestProjectNames", "getTitle", "getUniqueCode", "()Lcom/huachenjie/sport/bean/UniqueCode;", "getUserReserveStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/sport/bean/UniqueCode;ZZLjava/lang/Boolean;Ljava/lang/Boolean;)Lcom/huachenjie/sport/bean/SportTestDetailBean;", "equals", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportTestDetailBean {

    @Nullable
    private final List<AdministrativeClasse> administrativeClasses;

    @Nullable
    private final Boolean canBeModified;

    @Nullable
    private final List<CourseClasse> courseClasses;

    @Nullable
    private final List<String> departmentNames;

    @Nullable
    private final String fitnessTestDate;

    @Nullable
    private final Integer fitnessTestStatus;

    @Nullable
    private final Integer fitnessType;

    @Nullable
    private final String gradeNames;
    private boolean hasConsent;
    private final boolean hasInformedConsent;

    @Nullable
    private final String location;

    @Nullable
    private final String remark;

    @Nullable
    private final String reserveDate;

    @Nullable
    private final Long reserveEndTime;

    @Nullable
    private final String reserveNumber;

    @Nullable
    private final String reservePeriod;

    @Nullable
    private final String reservePeriods;

    @Nullable
    private final Long reserveStartTime;

    @Nullable
    private final Integer reserveTimeStatus;

    @Nullable
    private final String teacherNames;

    @Nullable
    private final String testProjectNames;

    @Nullable
    private final String title;

    @Nullable
    private final UniqueCode uniqueCode;

    @Nullable
    private final Boolean userReserveStatus;

    public SportTestDetailBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, 16777215, null);
    }

    public SportTestDetailBean(@Nullable List<AdministrativeClasse> list, @Nullable List<CourseClasse> list2, @Nullable List<String> list3, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Long l, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Long l2, @Nullable Integer num3, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable UniqueCode uniqueCode, boolean z, boolean z2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.administrativeClasses = list;
        this.courseClasses = list2;
        this.departmentNames = list3;
        this.fitnessTestDate = str;
        this.fitnessTestStatus = num;
        this.fitnessType = num2;
        this.gradeNames = str2;
        this.location = str3;
        this.remark = str4;
        this.reserveDate = str5;
        this.reserveEndTime = l;
        this.reserveNumber = str6;
        this.reservePeriod = str7;
        this.reservePeriods = str8;
        this.reserveStartTime = l2;
        this.reserveTimeStatus = num3;
        this.teacherNames = str9;
        this.testProjectNames = str10;
        this.title = str11;
        this.uniqueCode = uniqueCode;
        this.hasInformedConsent = z;
        this.hasConsent = z2;
        this.userReserveStatus = bool;
        this.canBeModified = bool2;
    }

    @Nullable
    public final List<AdministrativeClasse> component1() {
        return this.administrativeClasses;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getReserveDate() {
        return this.reserveDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getReserveEndTime() {
        return this.reserveEndTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getReserveNumber() {
        return this.reserveNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getReservePeriods() {
        return this.reservePeriods;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Long getReserveStartTime() {
        return this.reserveStartTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getReserveTimeStatus() {
        return this.reserveTimeStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTeacherNames() {
        return this.teacherNames;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getTestProjectNames() {
        return this.testProjectNames;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<CourseClasse> component2() {
        return this.courseClasses;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final UniqueCode getUniqueCode() {
        return this.uniqueCode;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getHasInformedConsent() {
        return this.hasInformedConsent;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getHasConsent() {
        return this.hasConsent;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Boolean getUserReserveStatus() {
        return this.userReserveStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getCanBeModified() {
        return this.canBeModified;
    }

    @Nullable
    public final List<String> component3() {
        return this.departmentNames;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFitnessTestDate() {
        return this.fitnessTestDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getFitnessTestStatus() {
        return this.fitnessTestStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getFitnessType() {
        return this.fitnessType;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGradeNames() {
        return this.gradeNames;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    @NotNull
    public final SportTestDetailBean copy(@Nullable List<AdministrativeClasse> administrativeClasses, @Nullable List<CourseClasse> courseClasses, @Nullable List<String> departmentNames, @Nullable String fitnessTestDate, @Nullable Integer fitnessTestStatus, @Nullable Integer fitnessType, @Nullable String gradeNames, @Nullable String location, @Nullable String remark, @Nullable String reserveDate, @Nullable Long reserveEndTime, @Nullable String reserveNumber, @Nullable String reservePeriod, @Nullable String reservePeriods, @Nullable Long reserveStartTime, @Nullable Integer reserveTimeStatus, @Nullable String teacherNames, @Nullable String testProjectNames, @Nullable String title, @Nullable UniqueCode uniqueCode, boolean hasInformedConsent, boolean hasConsent, @Nullable Boolean userReserveStatus, @Nullable Boolean canBeModified) {
        return new SportTestDetailBean(administrativeClasses, courseClasses, departmentNames, fitnessTestDate, fitnessTestStatus, fitnessType, gradeNames, location, remark, reserveDate, reserveEndTime, reserveNumber, reservePeriod, reservePeriods, reserveStartTime, reserveTimeStatus, teacherNames, testProjectNames, title, uniqueCode, hasInformedConsent, hasConsent, userReserveStatus, canBeModified);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportTestDetailBean)) {
            return false;
        }
        SportTestDetailBean sportTestDetailBean = (SportTestDetailBean) other;
        return Intrinsics.areEqual(this.administrativeClasses, sportTestDetailBean.administrativeClasses) && Intrinsics.areEqual(this.courseClasses, sportTestDetailBean.courseClasses) && Intrinsics.areEqual(this.departmentNames, sportTestDetailBean.departmentNames) && Intrinsics.areEqual(this.fitnessTestDate, sportTestDetailBean.fitnessTestDate) && Intrinsics.areEqual(this.fitnessTestStatus, sportTestDetailBean.fitnessTestStatus) && Intrinsics.areEqual(this.fitnessType, sportTestDetailBean.fitnessType) && Intrinsics.areEqual(this.gradeNames, sportTestDetailBean.gradeNames) && Intrinsics.areEqual(this.location, sportTestDetailBean.location) && Intrinsics.areEqual(this.remark, sportTestDetailBean.remark) && Intrinsics.areEqual(this.reserveDate, sportTestDetailBean.reserveDate) && Intrinsics.areEqual(this.reserveEndTime, sportTestDetailBean.reserveEndTime) && Intrinsics.areEqual(this.reserveNumber, sportTestDetailBean.reserveNumber) && Intrinsics.areEqual(this.reservePeriod, sportTestDetailBean.reservePeriod) && Intrinsics.areEqual(this.reservePeriods, sportTestDetailBean.reservePeriods) && Intrinsics.areEqual(this.reserveStartTime, sportTestDetailBean.reserveStartTime) && Intrinsics.areEqual(this.reserveTimeStatus, sportTestDetailBean.reserveTimeStatus) && Intrinsics.areEqual(this.teacherNames, sportTestDetailBean.teacherNames) && Intrinsics.areEqual(this.testProjectNames, sportTestDetailBean.testProjectNames) && Intrinsics.areEqual(this.title, sportTestDetailBean.title) && Intrinsics.areEqual(this.uniqueCode, sportTestDetailBean.uniqueCode) && this.hasInformedConsent == sportTestDetailBean.hasInformedConsent && this.hasConsent == sportTestDetailBean.hasConsent && Intrinsics.areEqual(this.userReserveStatus, sportTestDetailBean.userReserveStatus) && Intrinsics.areEqual(this.canBeModified, sportTestDetailBean.canBeModified);
    }

    @Nullable
    public final List<AdministrativeClasse> getAdministrativeClasses() {
        return this.administrativeClasses;
    }

    @Nullable
    public final Boolean getCanBeModified() {
        return this.canBeModified;
    }

    @Nullable
    public final List<CourseClasse> getCourseClasses() {
        return this.courseClasses;
    }

    @Nullable
    public final List<String> getDepartmentNames() {
        return this.departmentNames;
    }

    @Nullable
    public final String getFitnessTestDate() {
        return this.fitnessTestDate;
    }

    @Nullable
    public final Integer getFitnessTestStatus() {
        return this.fitnessTestStatus;
    }

    @Nullable
    public final Integer getFitnessType() {
        return this.fitnessType;
    }

    @Nullable
    public final String getGradeNames() {
        return this.gradeNames;
    }

    public final boolean getHasConsent() {
        return this.hasConsent;
    }

    public final boolean getHasInformedConsent() {
        return this.hasInformedConsent;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    public final String getReserveDate() {
        return this.reserveDate;
    }

    @Nullable
    public final Long getReserveEndTime() {
        return this.reserveEndTime;
    }

    @Nullable
    public final String getReserveNumber() {
        return this.reserveNumber;
    }

    @Nullable
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    public final String getReservePeriods() {
        return this.reservePeriods;
    }

    @Nullable
    public final Long getReserveStartTime() {
        return this.reserveStartTime;
    }

    @Nullable
    public final Integer getReserveTimeStatus() {
        return this.reserveTimeStatus;
    }

    @Nullable
    public final String getTeacherNames() {
        return this.teacherNames;
    }

    @Nullable
    public final String getTestProjectNames() {
        return this.testProjectNames;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final UniqueCode getUniqueCode() {
        return this.uniqueCode;
    }

    @Nullable
    public final Boolean getUserReserveStatus() {
        return this.userReserveStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v58, types: [int] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<AdministrativeClasse> list = this.administrativeClasses;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<CourseClasse> list2 = this.courseClasses;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.departmentNames;
        int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.fitnessTestDate;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.fitnessTestStatus;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fitnessType;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.gradeNames;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.location;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.remark;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.reserveDate;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.reserveEndTime;
        int iHashCode11 = (iHashCode10 + (l == null ? 0 : l.hashCode())) * 31;
        String str6 = this.reserveNumber;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.reservePeriod;
        int iHashCode13 = (iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.reservePeriods;
        int iHashCode14 = (iHashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l2 = this.reserveStartTime;
        int iHashCode15 = (iHashCode14 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num3 = this.reserveTimeStatus;
        int iHashCode16 = (iHashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str9 = this.teacherNames;
        int iHashCode17 = (iHashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.testProjectNames;
        int iHashCode18 = (iHashCode17 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.title;
        int iHashCode19 = (iHashCode18 + (str11 == null ? 0 : str11.hashCode())) * 31;
        UniqueCode uniqueCode = this.uniqueCode;
        int iHashCode20 = (iHashCode19 + (uniqueCode == null ? 0 : uniqueCode.hashCode())) * 31;
        boolean z = this.hasInformedConsent;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode20 + r2) * 31;
        boolean z2 = this.hasConsent;
        int i2 = (i + (z2 ? 1 : z2)) * 31;
        Boolean bool = this.userReserveStatus;
        int iHashCode21 = (i2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.canBeModified;
        return iHashCode21 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setHasConsent(boolean z) {
        this.hasConsent = z;
    }

    @NotNull
    public String toString() {
        return "SportTestDetailBean(administrativeClasses=" + this.administrativeClasses + ", courseClasses=" + this.courseClasses + ", departmentNames=" + this.departmentNames + ", fitnessTestDate=" + this.fitnessTestDate + ", fitnessTestStatus=" + this.fitnessTestStatus + ", fitnessType=" + this.fitnessType + ", gradeNames=" + this.gradeNames + ", location=" + this.location + ", remark=" + this.remark + ", reserveDate=" + this.reserveDate + ", reserveEndTime=" + this.reserveEndTime + ", reserveNumber=" + this.reserveNumber + ", reservePeriod=" + this.reservePeriod + ", reservePeriods=" + this.reservePeriods + ", reserveStartTime=" + this.reserveStartTime + ", reserveTimeStatus=" + this.reserveTimeStatus + ", teacherNames=" + this.teacherNames + ", testProjectNames=" + this.testProjectNames + ", title=" + this.title + ", uniqueCode=" + this.uniqueCode + ", hasInformedConsent=" + this.hasInformedConsent + ", hasConsent=" + this.hasConsent + ", userReserveStatus=" + this.userReserveStatus + ", canBeModified=" + this.canBeModified + ')';
    }

    public /* synthetic */ SportTestDetailBean(List list, List list2, List list3, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, Long l2, Integer num3, String str9, String str10, String str11, UniqueCode uniqueCode, boolean z, boolean z2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : l2, (i & 32768) != 0 ? null : num3, (i & 65536) != 0 ? null : str9, (i & 131072) != 0 ? null : str10, (i & 262144) != 0 ? null : str11, (i & 524288) != 0 ? null : uniqueCode, (i & 1048576) != 0 ? false : z, (i & 2097152) == 0 ? z2 : false, (i & 4194304) != 0 ? null : bool, (i & 8388608) != 0 ? null : bool2);
    }
}
