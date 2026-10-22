package com.huachenjie.sport.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\u0005HÖ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0005HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Lcom/huachenjie/sport/bean/ExamResultData;", "Landroid/os/Parcelable;", "durationFmt", "", "questionTotal", "", "score", "scoreLevel", "startTimeFmt", "submitTime", "", "errorQuestionTotalFmt", "rightQuestionTotalFmt", "examStudentResultCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDurationFmt", "()Ljava/lang/String;", "setDurationFmt", "(Ljava/lang/String;)V", "getErrorQuestionTotalFmt", "setErrorQuestionTotalFmt", "getExamStudentResultCode", "setExamStudentResultCode", "getQuestionTotal", "()Ljava/lang/Integer;", "setQuestionTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRightQuestionTotalFmt", "setRightQuestionTotalFmt", "getScore", "setScore", "getScoreLevel", "setScoreLevel", "getStartTimeFmt", "setStartTimeFmt", "getSubmitTime", "()Ljava/lang/Long;", "setSubmitTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/huachenjie/sport/bean/ExamResultData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamResultData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ExamResultData> CREATOR = new Creator();

    @Nullable
    private String durationFmt;

    @Nullable
    private String errorQuestionTotalFmt;

    @Nullable
    private String examStudentResultCode;

    @Nullable
    private Integer questionTotal;

    @Nullable
    private String rightQuestionTotalFmt;

    @Nullable
    private String score;

    @Nullable
    private Integer scoreLevel;

    @Nullable
    private String startTimeFmt;

    @Nullable
    private Long submitTime;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamResultData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamResultData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExamResultData(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamResultData[] newArray(int i) {
            return new ExamResultData[i];
        }
    }

    public ExamResultData(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable Long l, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.durationFmt = str;
        this.questionTotal = num;
        this.score = str2;
        this.scoreLevel = num2;
        this.startTimeFmt = str3;
        this.submitTime = l;
        this.errorQuestionTotalFmt = str4;
        this.rightQuestionTotalFmt = str5;
        this.examStudentResultCode = str6;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDurationFmt() {
        return this.durationFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getQuestionTotal() {
        return this.questionTotal;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getScoreLevel() {
        return this.scoreLevel;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStartTimeFmt() {
        return this.startTimeFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSubmitTime() {
        return this.submitTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getErrorQuestionTotalFmt() {
        return this.errorQuestionTotalFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRightQuestionTotalFmt() {
        return this.rightQuestionTotalFmt;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getExamStudentResultCode() {
        return this.examStudentResultCode;
    }

    @NotNull
    public final ExamResultData copy(@Nullable String durationFmt, @Nullable Integer questionTotal, @Nullable String score, @Nullable Integer scoreLevel, @Nullable String startTimeFmt, @Nullable Long submitTime, @Nullable String errorQuestionTotalFmt, @Nullable String rightQuestionTotalFmt, @Nullable String examStudentResultCode) {
        return new ExamResultData(durationFmt, questionTotal, score, scoreLevel, startTimeFmt, submitTime, errorQuestionTotalFmt, rightQuestionTotalFmt, examStudentResultCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamResultData)) {
            return false;
        }
        ExamResultData examResultData = (ExamResultData) other;
        return Intrinsics.areEqual(this.durationFmt, examResultData.durationFmt) && Intrinsics.areEqual(this.questionTotal, examResultData.questionTotal) && Intrinsics.areEqual(this.score, examResultData.score) && Intrinsics.areEqual(this.scoreLevel, examResultData.scoreLevel) && Intrinsics.areEqual(this.startTimeFmt, examResultData.startTimeFmt) && Intrinsics.areEqual(this.submitTime, examResultData.submitTime) && Intrinsics.areEqual(this.errorQuestionTotalFmt, examResultData.errorQuestionTotalFmt) && Intrinsics.areEqual(this.rightQuestionTotalFmt, examResultData.rightQuestionTotalFmt) && Intrinsics.areEqual(this.examStudentResultCode, examResultData.examStudentResultCode);
    }

    @Nullable
    public final String getDurationFmt() {
        return this.durationFmt;
    }

    @Nullable
    public final String getErrorQuestionTotalFmt() {
        return this.errorQuestionTotalFmt;
    }

    @Nullable
    public final String getExamStudentResultCode() {
        return this.examStudentResultCode;
    }

    @Nullable
    public final Integer getQuestionTotal() {
        return this.questionTotal;
    }

    @Nullable
    public final String getRightQuestionTotalFmt() {
        return this.rightQuestionTotalFmt;
    }

    @Nullable
    public final String getScore() {
        return this.score;
    }

    @Nullable
    public final Integer getScoreLevel() {
        return this.scoreLevel;
    }

    @Nullable
    public final String getStartTimeFmt() {
        return this.startTimeFmt;
    }

    @Nullable
    public final Long getSubmitTime() {
        return this.submitTime;
    }

    public int hashCode() {
        String str = this.durationFmt;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.questionTotal;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.score;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.scoreLevel;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.startTimeFmt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.submitTime;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.errorQuestionTotalFmt;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rightQuestionTotalFmt;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.examStudentResultCode;
        return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setDurationFmt(@Nullable String str) {
        this.durationFmt = str;
    }

    public final void setErrorQuestionTotalFmt(@Nullable String str) {
        this.errorQuestionTotalFmt = str;
    }

    public final void setExamStudentResultCode(@Nullable String str) {
        this.examStudentResultCode = str;
    }

    public final void setQuestionTotal(@Nullable Integer num) {
        this.questionTotal = num;
    }

    public final void setRightQuestionTotalFmt(@Nullable String str) {
        this.rightQuestionTotalFmt = str;
    }

    public final void setScore(@Nullable String str) {
        this.score = str;
    }

    public final void setScoreLevel(@Nullable Integer num) {
        this.scoreLevel = num;
    }

    public final void setStartTimeFmt(@Nullable String str) {
        this.startTimeFmt = str;
    }

    public final void setSubmitTime(@Nullable Long l) {
        this.submitTime = l;
    }

    @NotNull
    public String toString() {
        return "ExamResultData(durationFmt=" + this.durationFmt + ", questionTotal=" + this.questionTotal + ", score=" + this.score + ", scoreLevel=" + this.scoreLevel + ", startTimeFmt=" + this.startTimeFmt + ", submitTime=" + this.submitTime + ", errorQuestionTotalFmt=" + this.errorQuestionTotalFmt + ", rightQuestionTotalFmt=" + this.rightQuestionTotalFmt + ", examStudentResultCode=" + this.examStudentResultCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.durationFmt);
        Integer num = this.questionTotal;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.score);
        Integer num2 = this.scoreLevel;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.startTimeFmt);
        Long l = this.submitTime;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.errorQuestionTotalFmt);
        parcel.writeString(this.rightQuestionTotalFmt);
        parcel.writeString(this.examStudentResultCode);
    }
}
