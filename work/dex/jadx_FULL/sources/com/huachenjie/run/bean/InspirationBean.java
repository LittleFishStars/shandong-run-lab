package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/run/bean/InspirationBean;", "Landroid/os/Parcelable;", "taskNo", "", "value", "", "status", "(Ljava/lang/String;II)V", "getStatus", "()I", "getTaskNo", "()Ljava/lang/String;", "getValue", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InspirationBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<InspirationBean> CREATOR = new Creator();
    private final int status;

    @NotNull
    private final String taskNo;
    private final int value;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InspirationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InspirationBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InspirationBean(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InspirationBean[] newArray(int i) {
            return new InspirationBean[i];
        }
    }

    public InspirationBean() {
        this(null, 0, 0, 7, null);
    }

    public InspirationBean(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "taskNo");
        this.taskNo = str;
        this.value = i;
        this.status = i2;
    }

    public static /* synthetic */ InspirationBean copy$default(InspirationBean inspirationBean, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inspirationBean.taskNo;
        }
        if ((i3 & 2) != 0) {
            i = inspirationBean.value;
        }
        if ((i3 & 4) != 0) {
            i2 = inspirationBean.status;
        }
        return inspirationBean.copy(str, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTaskNo() {
        return this.taskNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final InspirationBean copy(@NotNull String taskNo, int value, int status) {
        Intrinsics.checkNotNullParameter(taskNo, "taskNo");
        return new InspirationBean(taskNo, value, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InspirationBean)) {
            return false;
        }
        InspirationBean inspirationBean = (InspirationBean) other;
        return Intrinsics.areEqual(this.taskNo, inspirationBean.taskNo) && this.value == inspirationBean.value && this.status == inspirationBean.status;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTaskNo() {
        return this.taskNo;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.taskNo.hashCode() * 31) + Integer.hashCode(this.value)) * 31) + Integer.hashCode(this.status);
    }

    @NotNull
    public String toString() {
        return "InspirationBean(taskNo=" + this.taskNo + ", value=" + this.value + ", status=" + this.status + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.taskNo);
        parcel.writeInt(this.value);
        parcel.writeInt(this.status);
    }

    public /* synthetic */ InspirationBean(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}
