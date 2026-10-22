package com.huachenjie.login.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/login/bean/RemainTimesData;", "Landroid/os/Parcelable;", "smsLoginRemainTimes", "", "callLoginRemainTimes", "(II)V", "getCallLoginRemainTimes", "()I", "getSmsLoginRemainTimes", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RemainTimesData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RemainTimesData> CREATOR = new Creator();
    private final int callLoginRemainTimes;
    private final int smsLoginRemainTimes;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RemainTimesData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RemainTimesData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RemainTimesData(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RemainTimesData[] newArray(int i) {
            return new RemainTimesData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RemainTimesData() {
        int i = 0;
        this(i, i, 3, null);
    }

    public RemainTimesData(int i, int i2) {
        this.smsLoginRemainTimes = i;
        this.callLoginRemainTimes = i2;
    }

    public static /* synthetic */ RemainTimesData copy$default(RemainTimesData remainTimesData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = remainTimesData.smsLoginRemainTimes;
        }
        if ((i3 & 2) != 0) {
            i2 = remainTimesData.callLoginRemainTimes;
        }
        return remainTimesData.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSmsLoginRemainTimes() {
        return this.smsLoginRemainTimes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCallLoginRemainTimes() {
        return this.callLoginRemainTimes;
    }

    @NotNull
    public final RemainTimesData copy(int smsLoginRemainTimes, int callLoginRemainTimes) {
        return new RemainTimesData(smsLoginRemainTimes, callLoginRemainTimes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemainTimesData)) {
            return false;
        }
        RemainTimesData remainTimesData = (RemainTimesData) other;
        return this.smsLoginRemainTimes == remainTimesData.smsLoginRemainTimes && this.callLoginRemainTimes == remainTimesData.callLoginRemainTimes;
    }

    public final int getCallLoginRemainTimes() {
        return this.callLoginRemainTimes;
    }

    public final int getSmsLoginRemainTimes() {
        return this.smsLoginRemainTimes;
    }

    public int hashCode() {
        return (Integer.hashCode(this.smsLoginRemainTimes) * 31) + Integer.hashCode(this.callLoginRemainTimes);
    }

    @NotNull
    public String toString() {
        return "RemainTimesData(smsLoginRemainTimes=" + this.smsLoginRemainTimes + ", callLoginRemainTimes=" + this.callLoginRemainTimes + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.smsLoginRemainTimes);
        parcel.writeInt(this.callLoginRemainTimes);
    }

    public /* synthetic */ RemainTimesData(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
