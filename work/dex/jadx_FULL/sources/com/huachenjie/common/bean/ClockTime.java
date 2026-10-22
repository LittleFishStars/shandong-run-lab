package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0003J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006+"}, d2 = {"Lcom/huachenjie/common/bean/ClockTime;", "Landroid/os/Parcelable;", "endTime", "", "endTimeStatus", "", "finishFlag", "", "startTime", "timeFrameCode", "startTimeStatus", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;I)V", "getEndTime", "()Ljava/lang/String;", "getEndTimeStatus", "()I", "getFinishFlag", "()Z", "getStartTime", "getStartTimeStatus", "getTimeFrameCode", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "endTagStr", "equals", "other", "", "hashCode", "showEndTagStr", "showStartTagStr", "startTagStr", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClockTime implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockTime> CREATOR = new Creator();

    @NotNull
    private final String endTime;
    private final int endTimeStatus;
    private final boolean finishFlag;

    @NotNull
    private final String startTime;
    private final int startTimeStatus;

    @NotNull
    private final String timeFrameCode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockTime> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTime createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClockTime(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTime[] newArray(int i) {
            return new ClockTime[i];
        }
    }

    public ClockTime(@NotNull String str, int i, boolean z, @NotNull String str2, @NotNull String str3, int i2) {
        Intrinsics.checkNotNullParameter(str, "endTime");
        Intrinsics.checkNotNullParameter(str2, "startTime");
        Intrinsics.checkNotNullParameter(str3, "timeFrameCode");
        this.endTime = str;
        this.endTimeStatus = i;
        this.finishFlag = z;
        this.startTime = str2;
        this.timeFrameCode = str3;
        this.startTimeStatus = i2;
    }

    public static /* synthetic */ ClockTime copy$default(ClockTime clockTime, String str, int i, boolean z, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = clockTime.endTime;
        }
        if ((i3 & 2) != 0) {
            i = clockTime.endTimeStatus;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            z = clockTime.finishFlag;
        }
        boolean z2 = z;
        if ((i3 & 8) != 0) {
            str2 = clockTime.startTime;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            str3 = clockTime.timeFrameCode;
        }
        String str5 = str3;
        if ((i3 & 32) != 0) {
            i2 = clockTime.startTimeStatus;
        }
        return clockTime.copy(str, i4, z2, str4, str5, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEndTimeStatus() {
        return this.endTimeStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFinishFlag() {
        return this.finishFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTimeFrameCode() {
        return this.timeFrameCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStartTimeStatus() {
        return this.startTimeStatus;
    }

    @NotNull
    public final ClockTime copy(@NotNull String endTime, int endTimeStatus, boolean finishFlag, @NotNull String startTime, @NotNull String timeFrameCode, int startTimeStatus) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(timeFrameCode, "timeFrameCode");
        return new ClockTime(endTime, endTimeStatus, finishFlag, startTime, timeFrameCode, startTimeStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String endTagStr() {
        int i = this.endTimeStatus;
        if (i != 1) {
            return (i == 2 || i != 3) ? "" : "签退时间已过";
        }
        return "未到签退时间";
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClockTime)) {
            return false;
        }
        ClockTime clockTime = (ClockTime) other;
        return Intrinsics.areEqual(this.endTime, clockTime.endTime) && this.endTimeStatus == clockTime.endTimeStatus && this.finishFlag == clockTime.finishFlag && Intrinsics.areEqual(this.startTime, clockTime.startTime) && Intrinsics.areEqual(this.timeFrameCode, clockTime.timeFrameCode) && this.startTimeStatus == clockTime.startTimeStatus;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    public final int getEndTimeStatus() {
        return this.endTimeStatus;
    }

    public final boolean getFinishFlag() {
        return this.finishFlag;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    public final int getStartTimeStatus() {
        return this.startTimeStatus;
    }

    @NotNull
    public final String getTimeFrameCode() {
        return this.timeFrameCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    public int hashCode() {
        int iHashCode = ((this.endTime.hashCode() * 31) + Integer.hashCode(this.endTimeStatus)) * 31;
        boolean z = this.finishFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + this.startTime.hashCode()) * 31) + this.timeFrameCode.hashCode()) * 31) + Integer.hashCode(this.startTimeStatus);
    }

    public final boolean showEndTagStr() {
        return !TextUtils.isEmpty(endTagStr());
    }

    public final boolean showStartTagStr() {
        return !TextUtils.isEmpty(startTagStr());
    }

    @NotNull
    public final String startTagStr() {
        int i = this.startTimeStatus;
        if (i != 1) {
            return (i == 2 || i != 3) ? "" : "签到时间已过";
        }
        return "未到签到时间";
    }

    @NotNull
    public String toString() {
        return "ClockTime(endTime=" + this.endTime + ", endTimeStatus=" + this.endTimeStatus + ", finishFlag=" + this.finishFlag + ", startTime=" + this.startTime + ", timeFrameCode=" + this.timeFrameCode + ", startTimeStatus=" + this.startTimeStatus + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.endTime);
        parcel.writeInt(this.endTimeStatus);
        parcel.writeInt(this.finishFlag ? 1 : 0);
        parcel.writeString(this.startTime);
        parcel.writeString(this.timeFrameCode);
        parcel.writeInt(this.startTimeStatus);
    }
}
