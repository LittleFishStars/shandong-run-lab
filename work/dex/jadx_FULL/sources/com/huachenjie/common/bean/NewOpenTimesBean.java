package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/common/bean/NewOpenTimesBean;", "Landroid/os/Parcelable;", "weekTime", "", "openTimes", "", "(Ljava/lang/String;Ljava/util/List;)V", "getOpenTimes", "()Ljava/util/List;", "getWeekTime", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NewOpenTimesBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<NewOpenTimesBean> CREATOR = new Creator();

    @NotNull
    private final List<String> openTimes;

    @NotNull
    private final String weekTime;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NewOpenTimesBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NewOpenTimesBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NewOpenTimesBean(parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NewOpenTimesBean[] newArray(int i) {
            return new NewOpenTimesBean[i];
        }
    }

    public NewOpenTimesBean(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "weekTime");
        Intrinsics.checkNotNullParameter(list, "openTimes");
        this.weekTime = str;
        this.openTimes = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewOpenTimesBean copy$default(NewOpenTimesBean newOpenTimesBean, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newOpenTimesBean.weekTime;
        }
        if ((i & 2) != 0) {
            list = newOpenTimesBean.openTimes;
        }
        return newOpenTimesBean.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWeekTime() {
        return this.weekTime;
    }

    @NotNull
    public final List<String> component2() {
        return this.openTimes;
    }

    @NotNull
    public final NewOpenTimesBean copy(@NotNull String weekTime, @NotNull List<String> openTimes) {
        Intrinsics.checkNotNullParameter(weekTime, "weekTime");
        Intrinsics.checkNotNullParameter(openTimes, "openTimes");
        return new NewOpenTimesBean(weekTime, openTimes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewOpenTimesBean)) {
            return false;
        }
        NewOpenTimesBean newOpenTimesBean = (NewOpenTimesBean) other;
        return Intrinsics.areEqual(this.weekTime, newOpenTimesBean.weekTime) && Intrinsics.areEqual(this.openTimes, newOpenTimesBean.openTimes);
    }

    @NotNull
    public final List<String> getOpenTimes() {
        return this.openTimes;
    }

    @NotNull
    public final String getWeekTime() {
        return this.weekTime;
    }

    public int hashCode() {
        return (this.weekTime.hashCode() * 31) + this.openTimes.hashCode();
    }

    @NotNull
    public String toString() {
        return "NewOpenTimesBean(weekTime=" + this.weekTime + ", openTimes=" + this.openTimes + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.weekTime);
        parcel.writeStringList(this.openTimes);
    }
}
