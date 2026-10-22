package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/bean/WorksPromotionInfo;", "Landroid/os/Parcelable;", UserTrackConstant.JUMP_TYPE, "", "jumpUrl", "", "(ILjava/lang/String;)V", "getJumpType", "()I", "getJumpUrl", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorksPromotionInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<WorksPromotionInfo> CREATOR = new Creator();
    private final int jumpType;

    @NotNull
    private final String jumpUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WorksPromotionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorksPromotionInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WorksPromotionInfo(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WorksPromotionInfo[] newArray(int i) {
            return new WorksPromotionInfo[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WorksPromotionInfo() {
        String str = null;
        this(0, str, 3, str);
    }

    public WorksPromotionInfo(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jumpUrl");
        this.jumpType = i;
        this.jumpUrl = str;
    }

    public static /* synthetic */ WorksPromotionInfo copy$default(WorksPromotionInfo worksPromotionInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = worksPromotionInfo.jumpType;
        }
        if ((i2 & 2) != 0) {
            str = worksPromotionInfo.jumpUrl;
        }
        return worksPromotionInfo.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final WorksPromotionInfo copy(int jumpType, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new WorksPromotionInfo(jumpType, jumpUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorksPromotionInfo)) {
            return false;
        }
        WorksPromotionInfo worksPromotionInfo = (WorksPromotionInfo) other;
        return this.jumpType == worksPromotionInfo.jumpType && Intrinsics.areEqual(this.jumpUrl, worksPromotionInfo.jumpUrl);
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        return (Integer.hashCode(this.jumpType) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "WorksPromotionInfo(jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.jumpType);
        parcel.writeString(this.jumpUrl);
    }

    public /* synthetic */ WorksPromotionInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }
}
