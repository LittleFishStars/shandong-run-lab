package com.huachenjie.mall.bean.goods_detail;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Landroid/os/Parcelable;", "specValue", "", "specNo", "specImageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "outOfStock", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;Z)V", "getOutOfStock", "()Z", "getSpecImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", "getSpecNo", "()Ljava/lang/String;", "getSpecValue", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailSpecValue implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailSpecValue> CREATOR = new Creator();
    private final boolean outOfStock;

    @Nullable
    private final ImageBean specImageInfo;

    @NotNull
    private final String specNo;

    @NotNull
    private final String specValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailSpecValue> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSpecValue createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsDetailSpecValue(parcel.readString(), parcel.readString(), (ImageBean) parcel.readParcelable(GoodsDetailSpecValue.class.getClassLoader()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSpecValue[] newArray(int i) {
            return new GoodsDetailSpecValue[i];
        }
    }

    public GoodsDetailSpecValue() {
        this(null, null, null, false, 15, null);
    }

    public GoodsDetailSpecValue(@NotNull String str, @NotNull String str2, @Nullable ImageBean imageBean, boolean z) {
        Intrinsics.checkNotNullParameter(str, "specValue");
        Intrinsics.checkNotNullParameter(str2, "specNo");
        this.specValue = str;
        this.specNo = str2;
        this.specImageInfo = imageBean;
        this.outOfStock = z;
    }

    public static /* synthetic */ GoodsDetailSpecValue copy$default(GoodsDetailSpecValue goodsDetailSpecValue, String str, String str2, ImageBean imageBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goodsDetailSpecValue.specValue;
        }
        if ((i & 2) != 0) {
            str2 = goodsDetailSpecValue.specNo;
        }
        if ((i & 4) != 0) {
            imageBean = goodsDetailSpecValue.specImageInfo;
        }
        if ((i & 8) != 0) {
            z = goodsDetailSpecValue.outOfStock;
        }
        return goodsDetailSpecValue.copy(str, str2, imageBean, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSpecValue() {
        return this.specValue;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSpecNo() {
        return this.specNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageBean getSpecImageInfo() {
        return this.specImageInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getOutOfStock() {
        return this.outOfStock;
    }

    @NotNull
    public final GoodsDetailSpecValue copy(@NotNull String specValue, @NotNull String specNo, @Nullable ImageBean specImageInfo, boolean outOfStock) {
        Intrinsics.checkNotNullParameter(specValue, "specValue");
        Intrinsics.checkNotNullParameter(specNo, "specNo");
        return new GoodsDetailSpecValue(specValue, specNo, specImageInfo, outOfStock);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailSpecValue)) {
            return false;
        }
        GoodsDetailSpecValue goodsDetailSpecValue = (GoodsDetailSpecValue) other;
        return Intrinsics.areEqual(this.specValue, goodsDetailSpecValue.specValue) && Intrinsics.areEqual(this.specNo, goodsDetailSpecValue.specNo) && Intrinsics.areEqual(this.specImageInfo, goodsDetailSpecValue.specImageInfo) && this.outOfStock == goodsDetailSpecValue.outOfStock;
    }

    public final boolean getOutOfStock() {
        return this.outOfStock;
    }

    @Nullable
    public final ImageBean getSpecImageInfo() {
        return this.specImageInfo;
    }

    @NotNull
    public final String getSpecNo() {
        return this.specNo;
    }

    @NotNull
    public final String getSpecValue() {
        return this.specValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((this.specValue.hashCode() * 31) + this.specNo.hashCode()) * 31;
        ImageBean imageBean = this.specImageInfo;
        int iHashCode2 = (iHashCode + (imageBean == null ? 0 : imageBean.hashCode())) * 31;
        boolean z = this.outOfStock;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    @NotNull
    public String toString() {
        return "GoodsDetailSpecValue(specValue=" + this.specValue + ", specNo=" + this.specNo + ", specImageInfo=" + this.specImageInfo + ", outOfStock=" + this.outOfStock + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.specValue);
        parcel.writeString(this.specNo);
        parcel.writeParcelable(this.specImageInfo, flags);
        parcel.writeInt(this.outOfStock ? 1 : 0);
    }

    public /* synthetic */ GoodsDetailSpecValue(String str, String str2, ImageBean imageBean, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : imageBean, (i & 8) != 0 ? false : z);
    }
}
