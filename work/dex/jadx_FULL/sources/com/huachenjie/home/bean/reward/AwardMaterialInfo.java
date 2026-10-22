package com.huachenjie.home.bean.reward;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/home/bean/reward/AwardMaterialInfo;", "Landroid/os/Parcelable;", "itemNo", "", "(Ljava/lang/String;)V", "getItemNo", "()Ljava/lang/String;", "component1", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AwardMaterialInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AwardMaterialInfo> CREATOR = new Creator();

    @NotNull
    private final String itemNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AwardMaterialInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardMaterialInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AwardMaterialInfo(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardMaterialInfo[] newArray(int i) {
            return new AwardMaterialInfo[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AwardMaterialInfo() {
        String str = null;
        this(str, 1, str);
    }

    public AwardMaterialInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemNo");
        this.itemNo = str;
    }

    public static /* synthetic */ AwardMaterialInfo copy$default(AwardMaterialInfo awardMaterialInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = awardMaterialInfo.itemNo;
        }
        return awardMaterialInfo.copy(str);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemNo() {
        return this.itemNo;
    }

    @NotNull
    public final AwardMaterialInfo copy(@NotNull String itemNo) {
        Intrinsics.checkNotNullParameter(itemNo, "itemNo");
        return new AwardMaterialInfo(itemNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AwardMaterialInfo) && Intrinsics.areEqual(this.itemNo, ((AwardMaterialInfo) other).itemNo);
    }

    @NotNull
    public final String getItemNo() {
        return this.itemNo;
    }

    public int hashCode() {
        return this.itemNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AwardMaterialInfo(itemNo=" + this.itemNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.itemNo);
    }

    public /* synthetic */ AwardMaterialInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
