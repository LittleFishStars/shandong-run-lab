package com.huachenjie.sport.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\u0006\u00101\u001a\u000202J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007HÖ\u0001R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001c¨\u0006:"}, d2 = {"Lcom/huachenjie/sport/bean/Question;", "Landroid/os/Parcelable;", "questionCode", "", "questionName", "", "questionType", "", "questionTypeName", "options", "", "Lcom/huachenjie/sport/bean/Option;", "answers", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAnswers", "()Ljava/util/List;", "setAnswers", "(Ljava/util/List;)V", "getOptions", "setOptions", "getQuestionCode", "()Ljava/lang/Long;", "setQuestionCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getQuestionName", "()Ljava/lang/String;", "setQuestionName", "(Ljava/lang/String;)V", "getQuestionType", "()Ljava/lang/Integer;", "setQuestionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionTypeName", "setQuestionTypeName", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/huachenjie/sport/bean/Question;", "describeContents", "equals", "", "other", "", "getQuestionTypeEnum", "Lcom/huachenjie/sport/bean/ExamQuestionType;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Question implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Question> CREATOR = new Creator();

    @Nullable
    private List<Option> answers;

    @Nullable
    private List<Option> options;

    @Nullable
    private Long questionCode;

    @Nullable
    private String questionName;

    @Nullable
    private Integer questionType;

    @Nullable
    private String questionTypeName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Question> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Question createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList2 = null;
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(Option.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int i3 = parcel.readInt();
                arrayList2 = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList2.add(Option.CREATOR.createFromParcel(parcel));
                }
            }
            return new Question(lValueOf, string, numValueOf, string2, arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Question[] newArray(int i) {
            return new Question[i];
        }
    }

    public Question(@Nullable Long l, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable List<Option> list, @Nullable List<Option> list2) {
        this.questionCode = l;
        this.questionName = str;
        this.questionType = num;
        this.questionTypeName = str2;
        this.options = list;
        this.answers = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Question copy$default(Question question, Long l, String str, Integer num, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = question.questionCode;
        }
        if ((i & 2) != 0) {
            str = question.questionName;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            num = question.questionType;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str2 = question.questionTypeName;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            list = question.options;
        }
        List list3 = list;
        if ((i & 32) != 0) {
            list2 = question.answers;
        }
        return question.copy(l, str3, num2, str4, list3, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getQuestionCode() {
        return this.questionCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuestionName() {
        return this.questionName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getQuestionType() {
        return this.questionType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getQuestionTypeName() {
        return this.questionTypeName;
    }

    @Nullable
    public final List<Option> component5() {
        return this.options;
    }

    @Nullable
    public final List<Option> component6() {
        return this.answers;
    }

    @NotNull
    public final Question copy(@Nullable Long questionCode, @Nullable String questionName, @Nullable Integer questionType, @Nullable String questionTypeName, @Nullable List<Option> options, @Nullable List<Option> answers) {
        return new Question(questionCode, questionName, questionType, questionTypeName, options, answers);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Question)) {
            return false;
        }
        Question question = (Question) other;
        return Intrinsics.areEqual(this.questionCode, question.questionCode) && Intrinsics.areEqual(this.questionName, question.questionName) && Intrinsics.areEqual(this.questionType, question.questionType) && Intrinsics.areEqual(this.questionTypeName, question.questionTypeName) && Intrinsics.areEqual(this.options, question.options) && Intrinsics.areEqual(this.answers, question.answers);
    }

    @Nullable
    public final List<Option> getAnswers() {
        return this.answers;
    }

    @Nullable
    public final List<Option> getOptions() {
        return this.options;
    }

    @Nullable
    public final Long getQuestionCode() {
        return this.questionCode;
    }

    @Nullable
    public final String getQuestionName() {
        return this.questionName;
    }

    @Nullable
    public final Integer getQuestionType() {
        return this.questionType;
    }

    @NotNull
    public final ExamQuestionType getQuestionTypeEnum() {
        return ExamQuestionType.INSTANCE.id2Object(this.questionType);
    }

    @Nullable
    public final String getQuestionTypeName() {
        return this.questionTypeName;
    }

    public int hashCode() {
        Long l = this.questionCode;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.questionName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.questionType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.questionTypeName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Option> list = this.options;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<Option> list2 = this.answers;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAnswers(@Nullable List<Option> list) {
        this.answers = list;
    }

    public final void setOptions(@Nullable List<Option> list) {
        this.options = list;
    }

    public final void setQuestionCode(@Nullable Long l) {
        this.questionCode = l;
    }

    public final void setQuestionName(@Nullable String str) {
        this.questionName = str;
    }

    public final void setQuestionType(@Nullable Integer num) {
        this.questionType = num;
    }

    public final void setQuestionTypeName(@Nullable String str) {
        this.questionTypeName = str;
    }

    @NotNull
    public String toString() {
        return "Question(questionCode=" + this.questionCode + ", questionName=" + this.questionName + ", questionType=" + this.questionType + ", questionTypeName=" + this.questionTypeName + ", options=" + this.options + ", answers=" + this.answers + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.questionCode;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.questionName);
        Integer num = this.questionType;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.questionTypeName);
        List<Option> list = this.options;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Option> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        List<Option> list2 = this.answers;
        if (list2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list2.size());
        Iterator<Option> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
