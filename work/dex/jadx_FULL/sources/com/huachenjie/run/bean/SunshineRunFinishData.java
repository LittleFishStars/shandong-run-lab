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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0010\"\u0004\b\u0013\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/huachenjie/run/bean/SunshineRunFinishData;", "Landroid/os/Parcelable;", "isFinishSuccess", "", "(Z)V", "cheatType", "", "isDataError", "isAuto", "originData", "Lcom/huachenjie/run/bean/FinishRunResult;", "(IZZZLcom/huachenjie/run/bean/FinishRunResult;)V", "getCheatType", "()I", "setCheatType", "(I)V", "()Z", "setAuto", "setDataError", "setFinishSuccess", "getOriginData", "()Lcom/huachenjie/run/bean/FinishRunResult;", "setOriginData", "(Lcom/huachenjie/run/bean/FinishRunResult;)V", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SunshineRunFinishData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SunshineRunFinishData> CREATOR = new Creator();
    private int cheatType;
    private boolean isAuto;
    private boolean isDataError;
    private boolean isFinishSuccess;

    @Nullable
    private FinishRunResult originData;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SunshineRunFinishData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFinishData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SunshineRunFinishData(parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : FinishRunResult.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFinishData[] newArray(int i) {
            return new SunshineRunFinishData[i];
        }
    }

    public SunshineRunFinishData(int i, boolean z, boolean z2, boolean z3, @Nullable FinishRunResult finishRunResult) {
        this.cheatType = i;
        this.isDataError = z;
        this.isAuto = z2;
        this.isFinishSuccess = z3;
        this.originData = finishRunResult;
    }

    public static /* synthetic */ SunshineRunFinishData copy$default(SunshineRunFinishData sunshineRunFinishData, int i, boolean z, boolean z2, boolean z3, FinishRunResult finishRunResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sunshineRunFinishData.cheatType;
        }
        if ((i2 & 2) != 0) {
            z = sunshineRunFinishData.isDataError;
        }
        boolean z4 = z;
        if ((i2 & 4) != 0) {
            z2 = sunshineRunFinishData.isAuto;
        }
        boolean z5 = z2;
        if ((i2 & 8) != 0) {
            z3 = sunshineRunFinishData.isFinishSuccess;
        }
        boolean z6 = z3;
        if ((i2 & 16) != 0) {
            finishRunResult = sunshineRunFinishData.originData;
        }
        return sunshineRunFinishData.copy(i, z4, z5, z6, finishRunResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCheatType() {
        return this.cheatType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsDataError() {
        return this.isDataError;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAuto() {
        return this.isAuto;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFinishSuccess() {
        return this.isFinishSuccess;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FinishRunResult getOriginData() {
        return this.originData;
    }

    @NotNull
    public final SunshineRunFinishData copy(int cheatType, boolean isDataError, boolean isAuto, boolean isFinishSuccess, @Nullable FinishRunResult originData) {
        return new SunshineRunFinishData(cheatType, isDataError, isAuto, isFinishSuccess, originData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SunshineRunFinishData)) {
            return false;
        }
        SunshineRunFinishData sunshineRunFinishData = (SunshineRunFinishData) other;
        return this.cheatType == sunshineRunFinishData.cheatType && this.isDataError == sunshineRunFinishData.isDataError && this.isAuto == sunshineRunFinishData.isAuto && this.isFinishSuccess == sunshineRunFinishData.isFinishSuccess && Intrinsics.areEqual(this.originData, sunshineRunFinishData.originData);
    }

    public final int getCheatType() {
        return this.cheatType;
    }

    @Nullable
    public final FinishRunResult getOriginData() {
        return this.originData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.cheatType) * 31;
        boolean z = this.isDataError;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isAuto;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.isFinishSuccess;
        int i3 = (i2 + (z3 ? 1 : z3)) * 31;
        FinishRunResult finishRunResult = this.originData;
        return i3 + (finishRunResult == null ? 0 : finishRunResult.hashCode());
    }

    public final boolean isAuto() {
        return this.isAuto;
    }

    public final boolean isDataError() {
        return this.isDataError;
    }

    public final boolean isFinishSuccess() {
        return this.isFinishSuccess;
    }

    public final void setAuto(boolean z) {
        this.isAuto = z;
    }

    public final void setCheatType(int i) {
        this.cheatType = i;
    }

    public final void setDataError(boolean z) {
        this.isDataError = z;
    }

    public final void setFinishSuccess(boolean z) {
        this.isFinishSuccess = z;
    }

    public final void setOriginData(@Nullable FinishRunResult finishRunResult) {
        this.originData = finishRunResult;
    }

    @NotNull
    public String toString() {
        return "SunshineRunFinishData(cheatType=" + this.cheatType + ", isDataError=" + this.isDataError + ", isAuto=" + this.isAuto + ", isFinishSuccess=" + this.isFinishSuccess + ", originData=" + this.originData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.cheatType);
        parcel.writeInt(this.isDataError ? 1 : 0);
        parcel.writeInt(this.isAuto ? 1 : 0);
        parcel.writeInt(this.isFinishSuccess ? 1 : 0);
        FinishRunResult finishRunResult = this.originData;
        if (finishRunResult == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            finishRunResult.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ SunshineRunFinishData(int i, boolean z, boolean z2, boolean z3, FinishRunResult finishRunResult, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, z2, (i2 & 8) != 0 ? true : z3, finishRunResult);
    }

    public SunshineRunFinishData(boolean z) {
        this(0, false, false, z, null);
    }
}
