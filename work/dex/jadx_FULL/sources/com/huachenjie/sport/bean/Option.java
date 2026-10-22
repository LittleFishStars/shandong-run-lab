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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/huachenjie/sport/bean/Option;", "Landroid/os/Parcelable;", "questionOptionsCode", "", "optionName", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getOptionName", "()Ljava/lang/String;", "setOptionName", "(Ljava/lang/String;)V", "getQuestionOptionsCode", "()Ljava/lang/Long;", "setQuestionOptionsCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", OperatePopupWindow.g, "(Ljava/lang/Long;Ljava/lang/String;)Lcom/huachenjie/sport/bean/Option;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Option implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Option> CREATOR = new Creator();

    @Nullable
    private String optionName;

    @Nullable
    private Long questionOptionsCode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Option> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Option createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Option(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Option[] newArray(int i) {
            return new Option[i];
        }
    }

    public Option(@Nullable Long l, @Nullable String str) {
        this.questionOptionsCode = l;
        this.optionName = str;
    }

    public static /* synthetic */ Option copy$default(Option option, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = option.questionOptionsCode;
        }
        if ((i & 2) != 0) {
            str = option.optionName;
        }
        return option.copy(l, str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getQuestionOptionsCode() {
        return this.questionOptionsCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOptionName() {
        return this.optionName;
    }

    @NotNull
    public final Option copy(@Nullable Long questionOptionsCode, @Nullable String optionName) {
        return new Option(questionOptionsCode, optionName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Option)) {
            return false;
        }
        Option option = (Option) other;
        return Intrinsics.areEqual(this.questionOptionsCode, option.questionOptionsCode) && Intrinsics.areEqual(this.optionName, option.optionName);
    }

    @Nullable
    public final String getOptionName() {
        return this.optionName;
    }

    @Nullable
    public final Long getQuestionOptionsCode() {
        return this.questionOptionsCode;
    }

    public int hashCode() {
        Long l = this.questionOptionsCode;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.optionName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setOptionName(@Nullable String str) {
        this.optionName = str;
    }

    public final void setQuestionOptionsCode(@Nullable Long l) {
        this.questionOptionsCode = l;
    }

    @NotNull
    public String toString() {
        return "Option(questionOptionsCode=" + this.questionOptionsCode + ", optionName=" + this.optionName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.questionOptionsCode;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.optionName);
    }
}
