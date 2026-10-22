package com.huachenjie.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/home/bean/DailyTasksRewardDisplayBean;", "Landroid/os/Parcelable;", MoreDistanceDialog.VALUE_MIN, "", "max", "(II)V", "getMax", "()I", "getMin", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DailyTasksRewardDisplayBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyTasksRewardDisplayBean> CREATOR = new Creator();
    private final int max;
    private final int min;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTasksRewardDisplayBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksRewardDisplayBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTasksRewardDisplayBean(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksRewardDisplayBean[] newArray(int i) {
            return new DailyTasksRewardDisplayBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DailyTasksRewardDisplayBean() {
        int i = 0;
        this(i, i, 3, null);
    }

    public DailyTasksRewardDisplayBean(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    public static /* synthetic */ DailyTasksRewardDisplayBean copy$default(DailyTasksRewardDisplayBean dailyTasksRewardDisplayBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dailyTasksRewardDisplayBean.min;
        }
        if ((i3 & 2) != 0) {
            i2 = dailyTasksRewardDisplayBean.max;
        }
        return dailyTasksRewardDisplayBean.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    @NotNull
    public final DailyTasksRewardDisplayBean copy(int min, int max) {
        return new DailyTasksRewardDisplayBean(min, max);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyTasksRewardDisplayBean)) {
            return false;
        }
        DailyTasksRewardDisplayBean dailyTasksRewardDisplayBean = (DailyTasksRewardDisplayBean) other;
        return this.min == dailyTasksRewardDisplayBean.min && this.max == dailyTasksRewardDisplayBean.max;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public int hashCode() {
        return (Integer.hashCode(this.min) * 31) + Integer.hashCode(this.max);
    }

    @NotNull
    public String toString() {
        return "DailyTasksRewardDisplayBean(min=" + this.min + ", max=" + this.max + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.min);
        parcel.writeInt(this.max);
    }

    public /* synthetic */ DailyTasksRewardDisplayBean(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
