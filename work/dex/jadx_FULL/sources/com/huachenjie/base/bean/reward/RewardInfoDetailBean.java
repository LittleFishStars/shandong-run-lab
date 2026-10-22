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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003Je\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00063"}, d2 = {"Lcom/huachenjie/base/bean/reward/RewardInfoDetailBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "imgUrl", "imageInfo", "Lcom/huachenjie/base/bean/reward/RewardInfoImageInfoBean;", "awardType", "", "price", "materialInfo", "Lcom/huachenjie/base/bean/reward/RewardInfoMaterialBean;", "stock", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/reward/RewardInfoImageInfoBean;ILjava/lang/String;Lcom/huachenjie/base/bean/reward/RewardInfoMaterialBean;Ljava/lang/String;Z)V", "getAwardName", "()Ljava/lang/String;", "getAwardNo", "getAwardType", "()I", "getImageInfo", "()Lcom/huachenjie/base/bean/reward/RewardInfoImageInfoBean;", "getImgUrl", "()Z", "getMaterialInfo", "()Lcom/huachenjie/base/bean/reward/RewardInfoMaterialBean;", "getPrice", "getStock", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RewardInfoDetailBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RewardInfoDetailBean> CREATOR = new Creator();

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final RewardInfoImageInfoBean imageInfo;

    @NotNull
    private final String imgUrl;
    private final boolean isSelected;

    @Nullable
    private final RewardInfoMaterialBean materialInfo;

    @NotNull
    private final String price;

    @NotNull
    private final String stock;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RewardInfoDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoDetailBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RewardInfoDetailBean(parcel.readString(), parcel.readString(), parcel.readString(), RewardInfoImageInfoBean.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : RewardInfoMaterialBean.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoDetailBean[] newArray(int i) {
            return new RewardInfoDetailBean[i];
        }
    }

    public RewardInfoDetailBean() {
        this(null, null, null, null, 0, null, null, null, false, 511, null);
    }

    public RewardInfoDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull RewardInfoImageInfoBean rewardInfoImageInfoBean, int i, @NotNull String str4, @Nullable RewardInfoMaterialBean rewardInfoMaterialBean, @NotNull String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(str3, "imgUrl");
        Intrinsics.checkNotNullParameter(rewardInfoImageInfoBean, "imageInfo");
        Intrinsics.checkNotNullParameter(str4, "price");
        Intrinsics.checkNotNullParameter(str5, "stock");
        this.awardNo = str;
        this.awardName = str2;
        this.imgUrl = str3;
        this.imageInfo = rewardInfoImageInfoBean;
        this.awardType = i;
        this.price = str4;
        this.materialInfo = rewardInfoMaterialBean;
        this.stock = str5;
        this.isSelected = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAwardNo() {
        return this.awardNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RewardInfoImageInfoBean getImageInfo() {
        return this.imageInfo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RewardInfoMaterialBean getMaterialInfo() {
        return this.materialInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStock() {
        return this.stock;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @NotNull
    public final RewardInfoDetailBean copy(@NotNull String awardNo, @NotNull String awardName, @NotNull String imgUrl, @NotNull RewardInfoImageInfoBean imageInfo, int awardType, @NotNull String price, @Nullable RewardInfoMaterialBean materialInfo, @NotNull String stock, boolean isSelected) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(stock, "stock");
        return new RewardInfoDetailBean(awardNo, awardName, imgUrl, imageInfo, awardType, price, materialInfo, stock, isSelected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardInfoDetailBean)) {
            return false;
        }
        RewardInfoDetailBean rewardInfoDetailBean = (RewardInfoDetailBean) other;
        return Intrinsics.areEqual(this.awardNo, rewardInfoDetailBean.awardNo) && Intrinsics.areEqual(this.awardName, rewardInfoDetailBean.awardName) && Intrinsics.areEqual(this.imgUrl, rewardInfoDetailBean.imgUrl) && Intrinsics.areEqual(this.imageInfo, rewardInfoDetailBean.imageInfo) && this.awardType == rewardInfoDetailBean.awardType && Intrinsics.areEqual(this.price, rewardInfoDetailBean.price) && Intrinsics.areEqual(this.materialInfo, rewardInfoDetailBean.materialInfo) && Intrinsics.areEqual(this.stock, rewardInfoDetailBean.stock) && this.isSelected == rewardInfoDetailBean.isSelected;
    }

    @NotNull
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    public final String getAwardNo() {
        return this.awardNo;
    }

    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    public final RewardInfoImageInfoBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    public final RewardInfoMaterialBean getMaterialInfo() {
        return this.materialInfo;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getStock() {
        return this.stock;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public int hashCode() {
        int iHashCode = ((((((((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + Integer.hashCode(this.awardType)) * 31) + this.price.hashCode()) * 31;
        RewardInfoMaterialBean rewardInfoMaterialBean = this.materialInfo;
        int iHashCode2 = (((iHashCode + (rewardInfoMaterialBean == null ? 0 : rewardInfoMaterialBean.hashCode())) * 31) + this.stock.hashCode()) * 31;
        boolean z = this.isSelected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public String toString() {
        return "RewardInfoDetailBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", imgUrl=" + this.imgUrl + ", imageInfo=" + this.imageInfo + ", awardType=" + this.awardType + ", price=" + this.price + ", materialInfo=" + this.materialInfo + ", stock=" + this.stock + ", isSelected=" + this.isSelected + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeString(this.imgUrl);
        this.imageInfo.writeToParcel(parcel, flags);
        parcel.writeInt(this.awardType);
        parcel.writeString(this.price);
        RewardInfoMaterialBean rewardInfoMaterialBean = this.materialInfo;
        if (rewardInfoMaterialBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rewardInfoMaterialBean.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.stock);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public /* synthetic */ RewardInfoDetailBean(String str, String str2, String str3, RewardInfoImageInfoBean rewardInfoImageInfoBean, int i, String str4, RewardInfoMaterialBean rewardInfoMaterialBean, String str5, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? new RewardInfoImageInfoBean(null, 0, 0, 0, 15, null) : rewardInfoImageInfoBean, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? null : rewardInfoMaterialBean, (i2 & 128) == 0 ? str5 : "", (i2 & 256) == 0 ? z : false);
    }
}
