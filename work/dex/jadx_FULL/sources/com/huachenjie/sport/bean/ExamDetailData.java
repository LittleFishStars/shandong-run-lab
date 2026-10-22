package com.huachenjie.sport.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b¢\u0006\u0002\u0010\u0019J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010M\u001a\u00020\bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJä\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0018\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010WJ\t\u0010X\u001a\u00020\bHÖ\u0001J\u0013\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\u0006\u0010]\u001a\u00020\u0006J\u0006\u0010^\u001a\u00020\u0006J\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020dJ\t\u0010e\u001a\u00020\bHÖ\u0001J\u0006\u0010f\u001a\u00020ZJ\u0006\u0010g\u001a\u00020ZJ\u0006\u0010h\u001a\u00020ZJ\t\u0010i\u001a\u00020\u0006HÖ\u0001J\u0019\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010(\"\u0004\b;\u0010*R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b<\u0010\u001dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(¨\u0006o"}, d2 = {"Lcom/huachenjie/sport/bean/ExamDetailData;", "Landroid/os/Parcelable;", ExamHistoryResultsActivity.x, "", "(Ljava/lang/Long;)V", "examName", "", "examType", "", "examTypeName", "semesterName", "examLocation", "examDesc", "examTimeFmt", "examStatus", "duration", "examStandardFmt", "passScore", "attendFlag", "result", "Lcom/huachenjie/sport/bean/ExamResultData;", "submitTime", "remainTimes", "maxTimes", "allowViewAnswer", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/huachenjie/sport/bean/ExamResultData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "getAllowViewAnswer", "()I", "getAttendFlag", "()Ljava/lang/Integer;", "setAttendFlag", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDuration", "setDuration", "getExamCode", "()Ljava/lang/Long;", "setExamCode", "Ljava/lang/Long;", "getExamDesc", "()Ljava/lang/String;", "setExamDesc", "(Ljava/lang/String;)V", "getExamLocation", "setExamLocation", "getExamName", "setExamName", "getExamStandardFmt", "setExamStandardFmt", "getExamStatus", "setExamStatus", "getExamTimeFmt", "setExamTimeFmt", "getExamType", "setExamType", "getExamTypeName", "setExamTypeName", "getMaxTimes", "getPassScore", "setPassScore", "getRemainTimes", "getResult", "()Lcom/huachenjie/sport/bean/ExamResultData;", "setResult", "(Lcom/huachenjie/sport/bean/ExamResultData;)V", "getSemesterName", "setSemesterName", "getSubmitTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/huachenjie/sport/bean/ExamResultData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;I)Lcom/huachenjie/sport/bean/ExamDetailData;", "describeContents", "equals", "", "other", "", "formatExamCode", "formatRetestTimes", "getExamAttendFlagEnum", "Lcom/huachenjie/sport/bean/ExamAttendFlag;", "getExamStatusEnum", "Lcom/huachenjie/sport/bean/ExamStatus;", "getExamTypeEnum", "Lcom/huachenjie/sport/bean/ExamType;", "hashCode", "showHistory", "showRetest", "showReviewResult", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamDetailData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ExamDetailData> CREATOR = new Creator();
    private final int allowViewAnswer;

    @Nullable
    private Integer attendFlag;

    @Nullable
    private Integer duration;

    @Nullable
    private Long examCode;

    @Nullable
    private String examDesc;

    @Nullable
    private String examLocation;

    @Nullable
    private String examName;

    @Nullable
    private String examStandardFmt;

    @Nullable
    private Integer examStatus;

    @Nullable
    private String examTimeFmt;

    @Nullable
    private Integer examType;

    @Nullable
    private String examTypeName;

    @Nullable
    private final Integer maxTimes;

    @Nullable
    private String passScore;

    @Nullable
    private final Integer remainTimes;

    @Nullable
    private ExamResultData result;

    @Nullable
    private String semesterName;

    @Nullable
    private final String submitTime;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamDetailData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamDetailData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExamDetailData(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : ExamResultData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamDetailData[] newArray(int i) {
            return new ExamDetailData[i];
        }
    }

    public ExamDetailData(@Nullable Long l, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str7, @Nullable String str8, @Nullable Integer num4, @Nullable ExamResultData examResultData, @Nullable String str9, @Nullable Integer num5, @Nullable Integer num6, int i) {
        this.examCode = l;
        this.examName = str;
        this.examType = num;
        this.examTypeName = str2;
        this.semesterName = str3;
        this.examLocation = str4;
        this.examDesc = str5;
        this.examTimeFmt = str6;
        this.examStatus = num2;
        this.duration = num3;
        this.examStandardFmt = str7;
        this.passScore = str8;
        this.attendFlag = num4;
        this.result = examResultData;
        this.submitTime = str9;
        this.remainTimes = num5;
        this.maxTimes = num6;
        this.allowViewAnswer = i;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getExamCode() {
        return this.examCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getExamStandardFmt() {
        return this.examStandardFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPassScore() {
        return this.passScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getAttendFlag() {
        return this.attendFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final ExamResultData getResult() {
        return this.result;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSubmitTime() {
        return this.submitTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getRemainTimes() {
        return this.remainTimes;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getMaxTimes() {
        return this.maxTimes;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getAllowViewAnswer() {
        return this.allowViewAnswer;
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
    public final String getExamLocation() {
        return this.examLocation;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getExamDesc() {
        return this.examDesc;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getExamTimeFmt() {
        return this.examTimeFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getExamStatus() {
        return this.examStatus;
    }

    @NotNull
    public final ExamDetailData copy(@Nullable Long examCode, @Nullable String examName, @Nullable Integer examType, @Nullable String examTypeName, @Nullable String semesterName, @Nullable String examLocation, @Nullable String examDesc, @Nullable String examTimeFmt, @Nullable Integer examStatus, @Nullable Integer duration, @Nullable String examStandardFmt, @Nullable String passScore, @Nullable Integer attendFlag, @Nullable ExamResultData result, @Nullable String submitTime, @Nullable Integer remainTimes, @Nullable Integer maxTimes, int allowViewAnswer) {
        return new ExamDetailData(examCode, examName, examType, examTypeName, semesterName, examLocation, examDesc, examTimeFmt, examStatus, duration, examStandardFmt, passScore, attendFlag, result, submitTime, remainTimes, maxTimes, allowViewAnswer);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamDetailData)) {
            return false;
        }
        ExamDetailData examDetailData = (ExamDetailData) other;
        return Intrinsics.areEqual(this.examCode, examDetailData.examCode) && Intrinsics.areEqual(this.examName, examDetailData.examName) && Intrinsics.areEqual(this.examType, examDetailData.examType) && Intrinsics.areEqual(this.examTypeName, examDetailData.examTypeName) && Intrinsics.areEqual(this.semesterName, examDetailData.semesterName) && Intrinsics.areEqual(this.examLocation, examDetailData.examLocation) && Intrinsics.areEqual(this.examDesc, examDetailData.examDesc) && Intrinsics.areEqual(this.examTimeFmt, examDetailData.examTimeFmt) && Intrinsics.areEqual(this.examStatus, examDetailData.examStatus) && Intrinsics.areEqual(this.duration, examDetailData.duration) && Intrinsics.areEqual(this.examStandardFmt, examDetailData.examStandardFmt) && Intrinsics.areEqual(this.passScore, examDetailData.passScore) && Intrinsics.areEqual(this.attendFlag, examDetailData.attendFlag) && Intrinsics.areEqual(this.result, examDetailData.result) && Intrinsics.areEqual(this.submitTime, examDetailData.submitTime) && Intrinsics.areEqual(this.remainTimes, examDetailData.remainTimes) && Intrinsics.areEqual(this.maxTimes, examDetailData.maxTimes) && this.allowViewAnswer == examDetailData.allowViewAnswer;
    }

    @NotNull
    public final String formatExamCode() {
        Long l = this.examCode;
        return l == null ? "" : String.valueOf(l);
    }

    @NotNull
    public final String formatRetestTimes() {
        if (!showRetest()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("*注：还剩");
        Integer num = this.remainTimes;
        sb.append(num != null ? num.intValue() : 0);
        sb.append("次重考次数");
        return sb.toString();
    }

    public final int getAllowViewAnswer() {
        return this.allowViewAnswer;
    }

    @Nullable
    public final Integer getAttendFlag() {
        return this.attendFlag;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @NotNull
    public final ExamAttendFlag getExamAttendFlagEnum() {
        return ExamAttendFlag.INSTANCE.id2Object(this.attendFlag);
    }

    @Nullable
    public final Long getExamCode() {
        return this.examCode;
    }

    @Nullable
    public final String getExamDesc() {
        return this.examDesc;
    }

    @Nullable
    public final String getExamLocation() {
        return this.examLocation;
    }

    @Nullable
    public final String getExamName() {
        return this.examName;
    }

    @Nullable
    public final String getExamStandardFmt() {
        return this.examStandardFmt;
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
    public final Integer getMaxTimes() {
        return this.maxTimes;
    }

    @Nullable
    public final String getPassScore() {
        return this.passScore;
    }

    @Nullable
    public final Integer getRemainTimes() {
        return this.remainTimes;
    }

    @Nullable
    public final ExamResultData getResult() {
        return this.result;
    }

    @Nullable
    public final String getSemesterName() {
        return this.semesterName;
    }

    @Nullable
    public final String getSubmitTime() {
        return this.submitTime;
    }

    public int hashCode() {
        Long l = this.examCode;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.examName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.examType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.examTypeName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.semesterName;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.examLocation;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.examDesc;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.examTimeFmt;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this.examStatus;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.duration;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.examStandardFmt;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.passScore;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num4 = this.attendFlag;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ExamResultData examResultData = this.result;
        int iHashCode14 = (iHashCode13 + (examResultData == null ? 0 : examResultData.hashCode())) * 31;
        String str9 = this.submitTime;
        int iHashCode15 = (iHashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num5 = this.remainTimes;
        int iHashCode16 = (iHashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.maxTimes;
        return ((iHashCode16 + (num6 != null ? num6.hashCode() : 0)) * 31) + Integer.hashCode(this.allowViewAnswer);
    }

    public final void setAttendFlag(@Nullable Integer num) {
        this.attendFlag = num;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setExamCode(@Nullable Long l) {
        this.examCode = l;
    }

    public final void setExamDesc(@Nullable String str) {
        this.examDesc = str;
    }

    public final void setExamLocation(@Nullable String str) {
        this.examLocation = str;
    }

    public final void setExamName(@Nullable String str) {
        this.examName = str;
    }

    public final void setExamStandardFmt(@Nullable String str) {
        this.examStandardFmt = str;
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

    public final void setPassScore(@Nullable String str) {
        this.passScore = str;
    }

    public final void setResult(@Nullable ExamResultData examResultData) {
        this.result = examResultData;
    }

    public final void setSemesterName(@Nullable String str) {
        this.semesterName = str;
    }

    public final boolean showHistory() {
        Integer num = this.maxTimes;
        return (num != null ? num.intValue() : 1) > 1;
    }

    public final boolean showRetest() {
        Integer num = this.remainTimes;
        return (num != null ? num.intValue() : 0) > 0 && getExamStatusEnum() == ExamStatus.InExam;
    }

    public final boolean showReviewResult() {
        return this.allowViewAnswer == 1;
    }

    @NotNull
    public String toString() {
        return "ExamDetailData(examCode=" + this.examCode + ", examName=" + this.examName + ", examType=" + this.examType + ", examTypeName=" + this.examTypeName + ", semesterName=" + this.semesterName + ", examLocation=" + this.examLocation + ", examDesc=" + this.examDesc + ", examTimeFmt=" + this.examTimeFmt + ", examStatus=" + this.examStatus + ", duration=" + this.duration + ", examStandardFmt=" + this.examStandardFmt + ", passScore=" + this.passScore + ", attendFlag=" + this.attendFlag + ", result=" + this.result + ", submitTime=" + this.submitTime + ", remainTimes=" + this.remainTimes + ", maxTimes=" + this.maxTimes + ", allowViewAnswer=" + this.allowViewAnswer + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.examCode;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.examName);
        Integer num = this.examType;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.examTypeName);
        parcel.writeString(this.semesterName);
        parcel.writeString(this.examLocation);
        parcel.writeString(this.examDesc);
        parcel.writeString(this.examTimeFmt);
        Integer num2 = this.examStatus;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.duration;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.examStandardFmt);
        parcel.writeString(this.passScore);
        Integer num4 = this.attendFlag;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        ExamResultData examResultData = this.result;
        if (examResultData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            examResultData.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.submitTime);
        Integer num5 = this.remainTimes;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        Integer num6 = this.maxTimes;
        if (num6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        }
        parcel.writeInt(this.allowViewAnswer);
    }

    public /* synthetic */ ExamDetailData(Long l, String str, Integer num, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, String str7, String str8, Integer num4, ExamResultData examResultData, String str9, Integer num5, Integer num6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str, num, str2, str3, str4, str5, str6, num2, num3, str7, str8, num4, examResultData, (i2 & 16384) != 0 ? "" : str9, num5, num6, (i2 & 131072) != 0 ? 0 : i);
    }

    public ExamDetailData(@Nullable Long l) {
        this(l, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0);
    }
}
