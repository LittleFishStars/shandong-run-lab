package com.huachenjie.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/home/bean/DailyTasksProgressBean;", "Landroid/os/Parcelable;", "completedCount", "", "maxCompleteCount", "(II)V", "getCompletedCount", "()I", "setCompletedCount", "(I)V", "getMaxCompleteCount", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DailyTasksProgressBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DailyTasksProgressBean> CREATOR = new Creator();
    private int completedCount;
    private final int maxCompleteCount;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DailyTasksProgressBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksProgressBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DailyTasksProgressBean(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DailyTasksProgressBean[] newArray(int i) {
            return new DailyTasksProgressBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DailyTasksProgressBean() {
        int i = 0;
        this(i, i, 3, null);
    }

    public DailyTasksProgressBean(int i, int i2) {
        this.completedCount = i;
        this.maxCompleteCount = i2;
    }

    public static /* synthetic */ DailyTasksProgressBean copy$default(DailyTasksProgressBean dailyTasksProgressBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dailyTasksProgressBean.completedCount;
        }
        if ((i3 & 2) != 0) {
            i2 = dailyTasksProgressBean.maxCompleteCount;
        }
        return dailyTasksProgressBean.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCompletedCount() {
        return this.completedCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxCompleteCount() {
        return this.maxCompleteCount;
    }

    @NotNull
    public final DailyTasksProgressBean copy(int completedCount, int maxCompleteCount) {
        return new DailyTasksProgressBean(completedCount, maxCompleteCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyTasksProgressBean)) {
            return false;
        }
        DailyTasksProgressBean dailyTasksProgressBean = (DailyTasksProgressBean) other;
        return this.completedCount == dailyTasksProgressBean.completedCount && this.maxCompleteCount == dailyTasksProgressBean.maxCompleteCount;
    }

    public final int getCompletedCount() {
        return this.completedCount;
    }

    public final int getMaxCompleteCount() {
        return this.maxCompleteCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.completedCount) * 31) + Integer.hashCode(this.maxCompleteCount);
    }

    public final void setCompletedCount(int i) {
        this.completedCount = i;
    }

    @NotNull
    public String toString() {
        return "DailyTasksProgressBean(completedCount=" + this.completedCount + ", maxCompleteCount=" + this.maxCompleteCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.completedCount);
        parcel.writeInt(this.maxCompleteCount);
    }

    public /* synthetic */ DailyTasksProgressBean(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
