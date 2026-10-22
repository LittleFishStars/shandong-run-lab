package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0090\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020DJ\t\u0010E\u001a\u00020\u0007HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015¨\u0006G"}, d2 = {"Lcom/huachenjie/sport/bean/ExamListData;", "", ExamHistoryResultsActivity.x, "", "examName", "", "examType", "", "examTypeName", "semesterName", "currentSemester", "", "examTimeFmt", "startTime", "endTime", "examStatus", "attendFlag", "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAttendFlag", "()Ljava/lang/Integer;", "setAttendFlag", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCurrentSemester", "()Ljava/lang/Boolean;", "setCurrentSemester", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "setEndTime", "getExamCode", "()J", "setExamCode", "(J)V", "getExamName", "()Ljava/lang/String;", "setExamName", "(Ljava/lang/String;)V", "getExamStatus", "setExamStatus", "getExamTimeFmt", "setExamTimeFmt", "getExamType", "setExamType", "getExamTypeName", "setExamTypeName", "getSemesterName", "setSemesterName", "getStartTime", "setStartTime", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/huachenjie/sport/bean/ExamListData;", "equals", "other", "getExamStatusEnum", "Lcom/huachenjie/sport/bean/ExamStatus;", "getExamTypeEnum", "Lcom/huachenjie/sport/bean/ExamType;", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamListData {

    @Nullable
    private Integer attendFlag;

    @Nullable
    private Boolean currentSemester;

    @Nullable
    private Integer endTime;
    private long examCode;

    @Nullable
    private String examName;

    @Nullable
    private Integer examStatus;

    @Nullable
    private String examTimeFmt;

    @Nullable
    private Integer examType;

    @Nullable
    private String examTypeName;

    @Nullable
    private String semesterName;

    @Nullable
    private Integer startTime;

    public ExamListData(long j, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5) {
        this.examCode = j;
        this.examName = str;
        this.examType = num;
        this.examTypeName = str2;
        this.semesterName = str3;
        this.currentSemester = bool;
        this.examTimeFmt = str4;
        this.startTime = num2;
        this.endTime = num3;
        this.examStatus = num4;
        this.attendFlag = num5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getExamCode() {
        return this.examCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getExamStatus() {
        return this.examStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getAttendFlag() {
        return this.attendFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExamName() {
        return this.examName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getExamType() {
        return this.examType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExamTypeName() {
        return this.examTypeName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSemesterName() {
        return this.semesterName;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getCurrentSemester() {
        return this.currentSemester;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getExamTimeFmt() {
        return this.examTimeFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getStartTime() {
        return this.startTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final ExamListData copy(long examCode, @Nullable String examName, @Nullable Integer examType, @Nullable String examTypeName, @Nullable String semesterName, @Nullable Boolean currentSemester, @Nullable String examTimeFmt, @Nullable Integer startTime, @Nullable Integer endTime, @Nullable Integer examStatus, @Nullable Integer attendFlag) {
        return new ExamListData(examCode, examName, examType, examTypeName, semesterName, currentSemester, examTimeFmt, startTime, endTime, examStatus, attendFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamListData)) {
            return false;
        }
        ExamListData examListData = (ExamListData) other;
        return this.examCode == examListData.examCode && Intrinsics.areEqual(this.examName, examListData.examName) && Intrinsics.areEqual(this.examType, examListData.examType) && Intrinsics.areEqual(this.examTypeName, examListData.examTypeName) && Intrinsics.areEqual(this.semesterName, examListData.semesterName) && Intrinsics.areEqual(this.currentSemester, examListData.currentSemester) && Intrinsics.areEqual(this.examTimeFmt, examListData.examTimeFmt) && Intrinsics.areEqual(this.startTime, examListData.startTime) && Intrinsics.areEqual(this.endTime, examListData.endTime) && Intrinsics.areEqual(this.examStatus, examListData.examStatus) && Intrinsics.areEqual(this.attendFlag, examListData.attendFlag);
    }

    @Nullable
    public final Integer getAttendFlag() {
        return this.attendFlag;
    }

    @Nullable
    public final Boolean getCurrentSemester() {
        return this.currentSemester;
    }

    @Nullable
    public final Integer getEndTime() {
        return this.endTime;
    }

    public final long getExamCode() {
        return this.examCode;
    }

    @Nullable
    public final String getExamName() {
        return this.examName;
    }

    @Nullable
    public final Integer getExamStatus() {
        return this.examStatus;
    }

    @NotNull
    public final ExamStatus getExamStatusEnum() {
        return ExamStatus.INSTANCE.id2Object(this.examStatus);
    }

    @Nullable
    public final String getExamTimeFmt() {
        return this.examTimeFmt;
    }

    @Nullable
    public final Integer getExamType() {
        return this.examType;
    }

    @NotNull
    public final ExamType getExamTypeEnum() {
        return ExamType.INSTANCE.id2Object(this.examType);
    }

    @Nullable
    public final String getExamTypeName() {
        return this.examTypeName;
    }

    @Nullable
    public final String getSemesterName() {
        return this.semesterName;
    }

    @Nullable
    public final Integer getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.examCode) * 31;
        String str = this.examName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.examType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.examTypeName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.semesterName;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.currentSemester;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.examTimeFmt;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.startTime;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.endTime;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.examStatus;
        int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.attendFlag;
        return iHashCode10 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setAttendFlag(@Nullable Integer num) {
        this.attendFlag = num;
    }

    public final void setCurrentSemester(@Nullable Boolean bool) {
        this.currentSemester = bool;
    }

    public final void setEndTime(@Nullable Integer num) {
        this.endTime = num;
    }

    public final void setExamCode(long j) {
        this.examCode = j;
    }

    public final void setExamName(@Nullable String str) {
        this.examName = str;
    }

    public final void setExamStatus(@Nullable Integer num) {
        this.examStatus = num;
    }

    public final void setExamTimeFmt(@Nullable String str) {
        this.examTimeFmt = str;
    }

    public final void setExamType(@Nullable Integer num) {
        this.examType = num;
    }

    public final void setExamTypeName(@Nullable String str) {
        this.examTypeName = str;
    }

    public final void setSemesterName(@Nullable String str) {
        this.semesterName = str;
    }

    public final void setStartTime(@Nullable Integer num) {
        this.startTime = num;
    }

    @NotNull
    public String toString() {
        return "ExamListData(examCode=" + this.examCode + ", examName=" + this.examName + ", examType=" + this.examType + ", examTypeName=" + this.examTypeName + ", semesterName=" + this.semesterName + ", currentSemester=" + this.currentSemester + ", examTimeFmt=" + this.examTimeFmt + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", examStatus=" + this.examStatus + ", attendFlag=" + this.attendFlag + ')';
    }
}
