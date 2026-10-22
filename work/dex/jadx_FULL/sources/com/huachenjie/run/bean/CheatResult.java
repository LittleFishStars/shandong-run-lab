package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONType;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/bean/CheatResult;", "Landroid/os/Parcelable;", "cheatType", "", "remark", "", "actionTime", "", "(ILjava/lang/String;J)V", "getActionTime", "()J", "getCheatType", "()I", "getRemark", "()Ljava/lang/String;", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JSONType(includes = {"cheatType", "remark", "actionTime"})
public final /* data */ class CheatResult implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CheatResult> CREATOR = new Creator();
    private final long actionTime;
    private final int cheatType;

    @NotNull
    private final String remark;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CheatResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CheatResult(parcel.readInt(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatResult[] newArray(int i) {
            return new CheatResult[i];
        }
    }

    public CheatResult(int i, @NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "remark");
        this.cheatType = i;
        this.remark = str;
        this.actionTime = j;
    }

    public static /* synthetic */ CheatResult copy$default(CheatResult cheatResult, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cheatResult.cheatType;
        }
        if ((i2 & 2) != 0) {
            str = cheatResult.remark;
        }
        if ((i2 & 4) != 0) {
            j = cheatResult.actionTime;
        }
        return cheatResult.copy(i, str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCheatType() {
        return this.cheatType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getActionTime() {
        return this.actionTime;
    }

    @NotNull
    public final CheatResult copy(int cheatType, @NotNull String remark, long actionTime) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new CheatResult(cheatType, remark, actionTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheatResult)) {
            return false;
        }
        CheatResult cheatResult = (CheatResult) other;
        return this.cheatType == cheatResult.cheatType && Intrinsics.areEqual(this.remark, cheatResult.remark) && this.actionTime == cheatResult.actionTime;
    }

    public final long getActionTime() {
        return this.actionTime;
    }

    public final int getCheatType() {
        return this.cheatType;
    }

    @NotNull
    public final String getRemark() {
        return this.remark;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.cheatType) * 31) + this.remark.hashCode()) * 31) + Long.hashCode(this.actionTime);
    }

    @NotNull
    public String toString() {
        return "CheatResult(cheatType=" + this.cheatType + ", remark=" + this.remark + ", actionTime=" + this.actionTime + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.cheatType);
        parcel.writeString(this.remark);
        parcel.writeLong(this.actionTime);
    }

    public /* synthetic */ CheatResult(int i, String str, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? System.currentTimeMillis() : j);
    }
}
