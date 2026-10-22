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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/run/bean/RunVision;", "Landroid/os/Parcelable;", "targetNumber", "", "actualNumber", "visionStatus", "(III)V", "getActualNumber", "()I", "getTargetNumber", "getVisionStatus", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RunVision implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RunVision> CREATOR = new Creator();
    private final int actualNumber;
    private final int targetNumber;
    private final int visionStatus;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RunVision> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunVision createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RunVision(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunVision[] newArray(int i) {
            return new RunVision[i];
        }
    }

    public RunVision() {
        this(0, 0, 0, 7, null);
    }

    public RunVision(int i, int i2, int i3) {
        this.targetNumber = i;
        this.actualNumber = i2;
        this.visionStatus = i3;
    }

    public static /* synthetic */ RunVision copy$default(RunVision runVision, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = runVision.targetNumber;
        }
        if ((i4 & 2) != 0) {
            i2 = runVision.actualNumber;
        }
        if ((i4 & 4) != 0) {
            i3 = runVision.visionStatus;
        }
        return runVision.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTargetNumber() {
        return this.targetNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getActualNumber() {
        return this.actualNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVisionStatus() {
        return this.visionStatus;
    }

    @NotNull
    public final RunVision copy(int targetNumber, int actualNumber, int visionStatus) {
        return new RunVision(targetNumber, actualNumber, visionStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RunVision)) {
            return false;
        }
        RunVision runVision = (RunVision) other;
        return this.targetNumber == runVision.targetNumber && this.actualNumber == runVision.actualNumber && this.visionStatus == runVision.visionStatus;
    }

    public final int getActualNumber() {
        return this.actualNumber;
    }

    public final int getTargetNumber() {
        return this.targetNumber;
    }

    public final int getVisionStatus() {
        return this.visionStatus;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.targetNumber) * 31) + Integer.hashCode(this.actualNumber)) * 31) + Integer.hashCode(this.visionStatus);
    }

    @NotNull
    public String toString() {
        return "RunVision(targetNumber=" + this.targetNumber + ", actualNumber=" + this.actualNumber + ", visionStatus=" + this.visionStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.targetNumber);
        parcel.writeInt(this.actualNumber);
        parcel.writeInt(this.visionStatus);
    }

    public /* synthetic */ RunVision(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
