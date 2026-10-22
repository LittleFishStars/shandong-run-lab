package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/common/bean/CheatBean;", "Landroid/os/Parcelable;", "cheatType", "", "cheatValue", "", "(IZ)V", "getCheatType", "()I", "getCheatValue", "()Z", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CheatBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CheatBean> CREATOR = new Creator();
    private final int cheatType;
    private final boolean cheatValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CheatBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CheatBean(parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatBean[] newArray(int i) {
            return new CheatBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheatBean() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public CheatBean(int i, boolean z) {
        this.cheatType = i;
        this.cheatValue = z;
    }

    public static /* synthetic */ CheatBean copy$default(CheatBean cheatBean, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cheatBean.cheatType;
        }
        if ((i2 & 2) != 0) {
            z = cheatBean.cheatValue;
        }
        return cheatBean.copy(i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCheatType() {
        return this.cheatType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCheatValue() {
        return this.cheatValue;
    }

    @NotNull
    public final CheatBean copy(int cheatType, boolean cheatValue) {
        return new CheatBean(cheatType, cheatValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheatBean)) {
            return false;
        }
        CheatBean cheatBean = (CheatBean) other;
        return this.cheatType == cheatBean.cheatType && this.cheatValue == cheatBean.cheatValue;
    }

    public final int getCheatType() {
        return this.cheatType;
    }

    public final boolean getCheatValue() {
        return this.cheatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.cheatType) * 31;
        boolean z = this.cheatValue;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "CheatBean(cheatType=" + this.cheatType + ", cheatValue=" + this.cheatValue + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.cheatType);
        parcel.writeInt(this.cheatValue ? 1 : 0);
    }

    public /* synthetic */ CheatBean(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
    }
}
