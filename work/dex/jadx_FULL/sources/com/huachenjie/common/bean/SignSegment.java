package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/huachenjie/common/bean/SignSegment;", "Landroid/os/Parcelable;", "endTime", "", "finishEndTime", "finishFlag", "", "finishStartTime", "startTime", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "getFinishEndTime", "getFinishFlag", "()Z", "getFinishStartTime", "getStartTime", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignSegment implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SignSegment> CREATOR = new Creator();

    @NotNull
    private final String endTime;

    @NotNull
    private final String finishEndTime;
    private final boolean finishFlag;

    @NotNull
    private final String finishStartTime;

    @NotNull
    private final String startTime;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SignSegment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SignSegment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignSegment(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SignSegment[] newArray(int i) {
            return new SignSegment[i];
        }
    }

    public SignSegment(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "endTime");
        Intrinsics.checkNotNullParameter(str2, "finishEndTime");
        Intrinsics.checkNotNullParameter(str3, "finishStartTime");
        Intrinsics.checkNotNullParameter(str4, "startTime");
        this.endTime = str;
        this.finishEndTime = str2;
        this.finishFlag = z;
        this.finishStartTime = str3;
        this.startTime = str4;
    }

    public static /* synthetic */ SignSegment copy$default(SignSegment signSegment, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signSegment.endTime;
        }
        if ((i & 2) != 0) {
            str2 = signSegment.finishEndTime;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = signSegment.finishFlag;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = signSegment.finishStartTime;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = signSegment.startTime;
        }
        return signSegment.copy(str, str5, z2, str6, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFinishEndTime() {
        return this.finishEndTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFinishFlag() {
        return this.finishFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFinishStartTime() {
        return this.finishStartTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final SignSegment copy(@NotNull String endTime, @NotNull String finishEndTime, boolean finishFlag, @NotNull String finishStartTime, @NotNull String startTime) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(finishEndTime, "finishEndTime");
        Intrinsics.checkNotNullParameter(finishStartTime, "finishStartTime");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        return new SignSegment(endTime, finishEndTime, finishFlag, finishStartTime, startTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignSegment)) {
            return false;
        }
        SignSegment signSegment = (SignSegment) other;
        return Intrinsics.areEqual(this.endTime, signSegment.endTime) && Intrinsics.areEqual(this.finishEndTime, signSegment.finishEndTime) && this.finishFlag == signSegment.finishFlag && Intrinsics.areEqual(this.finishStartTime, signSegment.finishStartTime) && Intrinsics.areEqual(this.startTime, signSegment.startTime);
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getFinishEndTime() {
        return this.finishEndTime;
    }

    public final boolean getFinishFlag() {
        return this.finishFlag;
    }

    @NotNull
    public final String getFinishStartTime() {
        return this.finishStartTime;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((this.endTime.hashCode() * 31) + this.finishEndTime.hashCode()) * 31;
        boolean z = this.finishFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.finishStartTime.hashCode()) * 31) + this.startTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "SignSegment(endTime=" + this.endTime + ", finishEndTime=" + this.finishEndTime + ", finishFlag=" + this.finishFlag + ", finishStartTime=" + this.finishStartTime + ", startTime=" + this.startTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.endTime);
        parcel.writeString(this.finishEndTime);
        parcel.writeInt(this.finishFlag ? 1 : 0);
        parcel.writeString(this.finishStartTime);
        parcel.writeString(this.startTime);
    }
}
