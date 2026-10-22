package com.huachenjie.home.bean.reward;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/huachenjie/home/bean/reward/AwardListBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "imageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "awardType", "", "price", "stock", "materialInfo", "Lcom/huachenjie/home/bean/reward/AwardMaterialInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;ILjava/lang/String;ILcom/huachenjie/home/bean/reward/AwardMaterialInfo;)V", "getAwardName", "()Ljava/lang/String;", "getAwardNo", "getAwardType", "()I", "getImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", "getMaterialInfo", "()Lcom/huachenjie/home/bean/reward/AwardMaterialInfo;", "getPrice", "getStock", "setStock", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AwardListBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AwardListBean> CREATOR = new Creator();

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final ImageBean imageInfo;

    @NotNull
    private final AwardMaterialInfo materialInfo;

    @NotNull
    private final String price;
    private int stock;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AwardListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardListBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AwardListBean(parcel.readString(), parcel.readString(), (ImageBean) parcel.readParcelable(AwardListBean.class.getClassLoader()), parcel.readInt(), parcel.readString(), parcel.readInt(), AwardMaterialInfo.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardListBean[] newArray(int i) {
            return new AwardListBean[i];
        }
    }

    public AwardListBean(@NotNull String str, @NotNull String str2, @NotNull ImageBean imageBean, int i, @NotNull String str3, int i2, @NotNull AwardMaterialInfo awardMaterialInfo) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(imageBean, "imageInfo");
        Intrinsics.checkNotNullParameter(str3, "price");
        Intrinsics.checkNotNullParameter(awardMaterialInfo, "materialInfo");
        this.awardNo = str;
        this.awardName = str2;
        this.imageInfo = imageBean;
        this.awardType = i;
        this.price = str3;
        this.stock = i2;
        this.materialInfo = awardMaterialInfo;
    }

    public static /* synthetic */ AwardListBean copy$default(AwardListBean awardListBean, String str, String str2, ImageBean imageBean, int i, String str3, int i2, AwardMaterialInfo awardMaterialInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = awardListBean.awardNo;
        }
        if ((i3 & 2) != 0) {
            str2 = awardListBean.awardName;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            imageBean = awardListBean.imageInfo;
        }
        ImageBean imageBean2 = imageBean;
        if ((i3 & 8) != 0) {
            i = awardListBean.awardType;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            str3 = awardListBean.price;
        }
        String str5 = str3;
        if ((i3 & 32) != 0) {
            i2 = awardListBean.stock;
        }
        int i5 = i2;
        if ((i3 & 64) != 0) {
            awardMaterialInfo = awardListBean.materialInfo;
        }
        return awardListBean.copy(str, str4, imageBean2, i4, str5, i5, awardMaterialInfo);
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
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStock() {
        return this.stock;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AwardMaterialInfo getMaterialInfo() {
        return this.materialInfo;
    }

    @NotNull
    public final AwardListBean copy(@NotNull String awardNo, @NotNull String awardName, @NotNull ImageBean imageInfo, int awardType, @NotNull String price, int stock, @NotNull AwardMaterialInfo materialInfo) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(materialInfo, "materialInfo");
        return new AwardListBean(awardNo, awardName, imageInfo, awardType, price, stock, materialInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardListBean)) {
            return false;
        }
        AwardListBean awardListBean = (AwardListBean) other;
        return Intrinsics.areEqual(this.awardNo, awardListBean.awardNo) && Intrinsics.areEqual(this.awardName, awardListBean.awardName) && Intrinsics.areEqual(this.imageInfo, awardListBean.imageInfo) && this.awardType == awardListBean.awardType && Intrinsics.areEqual(this.price, awardListBean.price) && this.stock == awardListBean.stock && Intrinsics.areEqual(this.materialInfo, awardListBean.materialInfo);
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
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final AwardMaterialInfo getMaterialInfo() {
        return this.materialInfo;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    public final int getStock() {
        return this.stock;
    }

    public int hashCode() {
        return (((((((((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + Integer.hashCode(this.awardType)) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.stock)) * 31) + this.materialInfo.hashCode();
    }

    public final void setStock(int i) {
        this.stock = i;
    }

    @NotNull
    public String toString() {
        return "AwardListBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", imageInfo=" + this.imageInfo + ", awardType=" + this.awardType + ", price=" + this.price + ", stock=" + this.stock + ", materialInfo=" + this.materialInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeParcelable(this.imageInfo, flags);
        parcel.writeInt(this.awardType);
        parcel.writeString(this.price);
        parcel.writeInt(this.stock);
        this.materialInfo.writeToParcel(parcel, flags);
    }

    public /* synthetic */ AwardListBean(String str, String str2, ImageBean imageBean, int i, String str3, int i2, AwardMaterialInfo awardMaterialInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, imageBean, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? 0 : i2, awardMaterialInfo);
    }
}
