package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/huachenjie/run/bean/EmaAnswerBean;", "Landroid/os/Parcelable;", "answerNo", "", "rewardAmount", "", "questions", "", "Lcom/huachenjie/run/bean/EmaQuestionBean;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getAnswerNo", "()Ljava/lang/String;", "getQuestions", "()Ljava/util/List;", "getRewardAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/huachenjie/run/bean/EmaAnswerBean;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmaAnswerBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EmaAnswerBean> CREATOR = new Creator();

    @Nullable
    private final String answerNo;

    @Nullable
    private final List<EmaQuestionBean> questions;

    @Nullable
    private final Integer rewardAmount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmaAnswerBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaAnswerBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(EmaQuestionBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new EmaAnswerBean(string, numValueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaAnswerBean[] newArray(int i) {
            return new EmaAnswerBean[i];
        }
    }

    public EmaAnswerBean() {
        this(null, null, null, 7, null);
    }

    public EmaAnswerBean(@Nullable String str, @Nullable Integer num, @Nullable List<EmaQuestionBean> list) {
        this.answerNo = str;
        this.rewardAmount = num;
        this.questions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmaAnswerBean copy$default(EmaAnswerBean emaAnswerBean, String str, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emaAnswerBean.answerNo;
        }
        if ((i & 2) != 0) {
            num = emaAnswerBean.rewardAmount;
        }
        if ((i & 4) != 0) {
            list = emaAnswerBean.questions;
        }
        return emaAnswerBean.copy(str, num, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnswerNo() {
        return this.answerNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getRewardAmount() {
        return this.rewardAmount;
    }

    @Nullable
    public final List<EmaQuestionBean> component3() {
        return this.questions;
    }

    @NotNull
    public final EmaAnswerBean copy(@Nullable String answerNo, @Nullable Integer rewardAmount, @Nullable List<EmaQuestionBean> questions) {
        return new EmaAnswerBean(answerNo, rewardAmount, questions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmaAnswerBean)) {
            return false;
        }
        EmaAnswerBean emaAnswerBean = (EmaAnswerBean) other;
        return Intrinsics.areEqual(this.answerNo, emaAnswerBean.answerNo) && Intrinsics.areEqual(this.rewardAmount, emaAnswerBean.rewardAmount) && Intrinsics.areEqual(this.questions, emaAnswerBean.questions);
    }

    @Nullable
    public final String getAnswerNo() {
        return this.answerNo;
    }

    @Nullable
    public final List<EmaQuestionBean> getQuestions() {
        return this.questions;
    }

    @Nullable
    public final Integer getRewardAmount() {
        return this.rewardAmount;
    }

    public int hashCode() {
        String str = this.answerNo;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.rewardAmount;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<EmaQuestionBean> list = this.questions;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EmaAnswerBean(answerNo=" + this.answerNo + ", rewardAmount=" + this.rewardAmount + ", questions=" + this.questions + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.answerNo);
        Integer num = this.rewardAmount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        List<EmaQuestionBean> list = this.questions;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<EmaQuestionBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ EmaAnswerBean(String str, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list);
    }
}
