package com.huachenjie.sport.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u00062"}, d2 = {"Lcom/huachenjie/sport/bean/ExamQuestionData;", "Landroid/os/Parcelable;", ExamHistoryResultsActivity.x, "", "remainingTime", "", "questionOrder", "questionTotal", "questions", "", "Lcom/huachenjie/sport/bean/Question;", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getExamCode", "()Ljava/lang/Long;", "setExamCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getQuestionOrder", "()Ljava/lang/Integer;", "setQuestionOrder", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionTotal", "setQuestionTotal", "getQuestions", "()Ljava/util/List;", "setQuestions", "(Ljava/util/List;)V", "getRemainingTime", "setRemainingTime", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/huachenjie/sport/bean/ExamQuestionData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamQuestionData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ExamQuestionData> CREATOR = new Creator();

    @Nullable
    private Long examCode;

    @Nullable
    private Integer questionOrder;

    @Nullable
    private Integer questionTotal;

    @Nullable
    private List<Question> questions;

    @Nullable
    private Integer remainingTime;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamQuestionData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamQuestionData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(Question.CREATOR.createFromParcel(parcel));
                }
            }
            return new ExamQuestionData(lValueOf, numValueOf, numValueOf2, numValueOf3, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExamQuestionData[] newArray(int i) {
            return new ExamQuestionData[i];
        }
    }

    public ExamQuestionData(@Nullable Long l, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable List<Question> list) {
        this.examCode = l;
        this.remainingTime = num;
        this.questionOrder = num2;
        this.questionTotal = num3;
        this.questions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamQuestionData copy$default(ExamQuestionData examQuestionData, Long l, Integer num, Integer num2, Integer num3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = examQuestionData.examCode;
        }
        if ((i & 2) != 0) {
            num = examQuestionData.remainingTime;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = examQuestionData.questionOrder;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = examQuestionData.questionTotal;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            list = examQuestionData.questions;
        }
        return examQuestionData.copy(l, num4, num5, num6, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getExamCode() {
        return this.examCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getRemainingTime() {
        return this.remainingTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getQuestionOrder() {
        return this.questionOrder;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getQuestionTotal() {
        return this.questionTotal;
    }

    @Nullable
    public final List<Question> component5() {
        return this.questions;
    }

    @NotNull
    public final ExamQuestionData copy(@Nullable Long examCode, @Nullable Integer remainingTime, @Nullable Integer questionOrder, @Nullable Integer questionTotal, @Nullable List<Question> questions) {
        return new ExamQuestionData(examCode, remainingTime, questionOrder, questionTotal, questions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamQuestionData)) {
            return false;
        }
        ExamQuestionData examQuestionData = (ExamQuestionData) other;
        return Intrinsics.areEqual(this.examCode, examQuestionData.examCode) && Intrinsics.areEqual(this.remainingTime, examQuestionData.remainingTime) && Intrinsics.areEqual(this.questionOrder, examQuestionData.questionOrder) && Intrinsics.areEqual(this.questionTotal, examQuestionData.questionTotal) && Intrinsics.areEqual(this.questions, examQuestionData.questions);
    }

    @Nullable
    public final Long getExamCode() {
        return this.examCode;
    }

    @Nullable
    public final Integer getQuestionOrder() {
        return this.questionOrder;
    }

    @Nullable
    public final Integer getQuestionTotal() {
        return this.questionTotal;
    }

    @Nullable
    public final List<Question> getQuestions() {
        return this.questions;
    }

    @Nullable
    public final Integer getRemainingTime() {
        return this.remainingTime;
    }

    public int hashCode() {
        Long l = this.examCode;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.remainingTime;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.questionOrder;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.questionTotal;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<Question> list = this.questions;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public final void setExamCode(@Nullable Long l) {
        this.examCode = l;
    }

    public final void setQuestionOrder(@Nullable Integer num) {
        this.questionOrder = num;
    }

    public final void setQuestionTotal(@Nullable Integer num) {
        this.questionTotal = num;
    }

    public final void setQuestions(@Nullable List<Question> list) {
        this.questions = list;
    }

    public final void setRemainingTime(@Nullable Integer num) {
        this.remainingTime = num;
    }

    @NotNull
    public String toString() {
        return "ExamQuestionData(examCode=" + this.examCode + ", remainingTime=" + this.remainingTime + ", questionOrder=" + this.questionOrder + ", questionTotal=" + this.questionTotal + ", questions=" + this.questions + ')';
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
        Integer num = this.remainingTime;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.questionOrder;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.questionTotal;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        List<Question> list = this.questions;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<Question> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
