package com.huachenjie.base.bean.reward;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/reward/RewardInfoMaterialBean;", "Landroid/os/Parcelable;", "materialNo", "", "materialType", "", "materialSubType", "itemNo", "value", "(Ljava/lang/String;IILjava/lang/String;I)V", "getItemNo", "()Ljava/lang/String;", "getMaterialNo", "getMaterialSubType", "()I", "getMaterialType", "getValue", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RewardInfoMaterialBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RewardInfoMaterialBean> CREATOR = new Creator();

    @NotNull
    private final String itemNo;

    @NotNull
    private final String materialNo;
    private final int materialSubType;
    private final int materialType;
    private final int value;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RewardInfoMaterialBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoMaterialBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RewardInfoMaterialBean(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoMaterialBean[] newArray(int i) {
            return new RewardInfoMaterialBean[i];
        }
    }

    public RewardInfoMaterialBean() {
        this(null, 0, 0, null, 0, 31, null);
    }

    public RewardInfoMaterialBean(@NotNull String str, int i, int i2, @NotNull String str2, int i3) {
        Intrinsics.checkNotNullParameter(str, "materialNo");
        Intrinsics.checkNotNullParameter(str2, "itemNo");
        this.materialNo = str;
        this.materialType = i;
        this.materialSubType = i2;
        this.itemNo = str2;
        this.value = i3;
    }

    public static /* synthetic */ RewardInfoMaterialBean copy$default(RewardInfoMaterialBean rewardInfoMaterialBean, String str, int i, int i2, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = rewardInfoMaterialBean.materialNo;
        }
        if ((i4 & 2) != 0) {
            i = rewardInfoMaterialBean.materialType;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = rewardInfoMaterialBean.materialSubType;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            str2 = rewardInfoMaterialBean.itemNo;
        }
        String str3 = str2;
        if ((i4 & 16) != 0) {
            i3 = rewardInfoMaterialBean.value;
        }
        return rewardInfoMaterialBean.copy(str, i5, i6, str3, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMaterialNo() {
        return this.materialNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaterialType() {
        return this.materialType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMaterialSubType() {
        return this.materialSubType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getItemNo() {
        return this.itemNo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    @NotNull
    public final RewardInfoMaterialBean copy(@NotNull String materialNo, int materialType, int materialSubType, @NotNull String itemNo, int value) {
        Intrinsics.checkNotNullParameter(materialNo, "materialNo");
        Intrinsics.checkNotNullParameter(itemNo, "itemNo");
        return new RewardInfoMaterialBean(materialNo, materialType, materialSubType, itemNo, value);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardInfoMaterialBean)) {
            return false;
        }
        RewardInfoMaterialBean rewardInfoMaterialBean = (RewardInfoMaterialBean) other;
        return Intrinsics.areEqual(this.materialNo, rewardInfoMaterialBean.materialNo) && this.materialType == rewardInfoMaterialBean.materialType && this.materialSubType == rewardInfoMaterialBean.materialSubType && Intrinsics.areEqual(this.itemNo, rewardInfoMaterialBean.itemNo) && this.value == rewardInfoMaterialBean.value;
    }

    @NotNull
    public final String getItemNo() {
        return this.itemNo;
    }

    @NotNull
    public final String getMaterialNo() {
        return this.materialNo;
    }

    public final int getMaterialSubType() {
        return this.materialSubType;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((this.materialNo.hashCode() * 31) + Integer.hashCode(this.materialType)) * 31) + Integer.hashCode(this.materialSubType)) * 31) + this.itemNo.hashCode()) * 31) + Integer.hashCode(this.value);
    }

    @NotNull
    public String toString() {
        return "RewardInfoMaterialBean(materialNo=" + this.materialNo + ", materialType=" + this.materialType + ", materialSubType=" + this.materialSubType + ", itemNo=" + this.itemNo + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.materialNo);
        parcel.writeInt(this.materialType);
        parcel.writeInt(this.materialSubType);
        parcel.writeString(this.itemNo);
        parcel.writeInt(this.value);
    }

    public /* synthetic */ RewardInfoMaterialBean(String str, int i, int i2, String str2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) == 0 ? str2 : "", (i4 & 16) != 0 ? 0 : i3);
    }
}
