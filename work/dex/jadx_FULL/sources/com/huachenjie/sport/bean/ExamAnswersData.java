package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/sport/bean/ExamAnswersData;", "", "questionCode", "", "answer", "", "(JLjava/util/Set;)V", "getAnswer", "()Ljava/util/Set;", "setAnswer", "(Ljava/util/Set;)V", "getQuestionCode", "()J", "setQuestionCode", "(J)V", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamAnswersData {

    @NotNull
    private Set<Long> answer;
    private long questionCode;

    public ExamAnswersData(long j, @NotNull Set<Long> set) {
        Intrinsics.checkNotNullParameter(set, "answer");
        this.questionCode = j;
        this.answer = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamAnswersData copy$default(ExamAnswersData examAnswersData, long j, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            j = examAnswersData.questionCode;
        }
        if ((i & 2) != 0) {
            set = examAnswersData.answer;
        }
        return examAnswersData.copy(j, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getQuestionCode() {
        return this.questionCode;
    }

    @NotNull
    public final Set<Long> component2() {
        return this.answer;
    }

    @NotNull
    public final ExamAnswersData copy(long questionCode, @NotNull Set<Long> answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new ExamAnswersData(questionCode, answer);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamAnswersData)) {
            return false;
        }
        ExamAnswersData examAnswersData = (ExamAnswersData) other;
        return this.questionCode == examAnswersData.questionCode && Intrinsics.areEqual(this.answer, examAnswersData.answer);
    }

    @NotNull
    public final Set<Long> getAnswer() {
        return this.answer;
    }

    public final long getQuestionCode() {
        return this.questionCode;
    }

    public int hashCode() {
        return (Long.hashCode(this.questionCode) * 31) + this.answer.hashCode();
    }

    public final void setAnswer(@NotNull Set<Long> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.answer = set;
    }

    public final void setQuestionCode(long j) {
        this.questionCode = j;
    }

    @NotNull
    public String toString() {
        return "ExamAnswersData(questionCode=" + this.questionCode + ", answer=" + this.answer + ')';
    }
}
