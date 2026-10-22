package com.huachenjie.mall.bean.goods_detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.i46;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003J\u008d\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\rHÆ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\u0006\u00108\u001a\u00020\u0003J\u000e\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0005J\u0006\u0010;\u001a\u00020\u0003J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e¨\u0006C"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSku;", "Landroid/os/Parcelable;", "skuNo", "", "availableStock", "", "salePrice", "pointsPrice", "outPrice", "skuImageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "specsValue", "baseCommissionRate", "", "baseCommission", "cooperationCommissionRate", "cooperationCommission", "cooperationServiceChargeRate", "cooperationServiceCharge", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lcom/huachenjie/base/bean/ImageBean;Ljava/lang/String;FFFFFF)V", "getAvailableStock", "()I", "getBaseCommission", "()F", "getBaseCommissionRate", "getCooperationCommission", "getCooperationCommissionRate", "getCooperationServiceCharge", "getCooperationServiceChargeRate", "getOutPrice", "()Ljava/lang/String;", "getPointsPrice", "getSalePrice", "getSkuImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", "getSkuNo", "getSpecsValue", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "formatBaseCommissionRate", "formatCommission", "squareType", "formatCommissionRate", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailSku implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailSku> CREATOR = new Creator();
    private final int availableStock;
    private final float baseCommission;
    private final float baseCommissionRate;
    private final float cooperationCommission;
    private final float cooperationCommissionRate;
    private final float cooperationServiceCharge;
    private final float cooperationServiceChargeRate;

    @NotNull
    private final String outPrice;
    private final int pointsPrice;

    @NotNull
    private final String salePrice;

    @Nullable
    private final ImageBean skuImageInfo;

    @NotNull
    private final String skuNo;

    @NotNull
    private final String specsValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailSku> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSku createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsDetailSku(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), (ImageBean) parcel.readParcelable(GoodsDetailSku.class.getClassLoader()), parcel.readString(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailSku[] newArray(int i) {
            return new GoodsDetailSku[i];
        }
    }

    public GoodsDetailSku() {
        this(null, 0, null, 0, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8191, null);
    }

    public GoodsDetailSku(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull String str3, @Nullable ImageBean imageBean, @NotNull String str4, float f, float f2, float f3, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(str, "skuNo");
        Intrinsics.checkNotNullParameter(str2, "salePrice");
        Intrinsics.checkNotNullParameter(str3, "outPrice");
        Intrinsics.checkNotNullParameter(str4, "specsValue");
        this.skuNo = str;
        this.availableStock = i;
        this.salePrice = str2;
        this.pointsPrice = i2;
        this.outPrice = str3;
        this.skuImageInfo = imageBean;
        this.specsValue = str4;
        this.baseCommissionRate = f;
        this.baseCommission = f2;
        this.cooperationCommissionRate = f3;
        this.cooperationCommission = f4;
        this.cooperationServiceChargeRate = f5;
        this.cooperationServiceCharge = f6;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSkuNo() {
        return this.skuNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getCooperationCommissionRate() {
        return this.cooperationCommissionRate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getCooperationCommission() {
        return this.cooperationCommission;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final float getCooperationServiceChargeRate() {
        return this.cooperationServiceChargeRate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getCooperationServiceCharge() {
        return this.cooperationServiceCharge;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAvailableStock() {
        return this.availableStock;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSalePrice() {
        return this.salePrice;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPointsPrice() {
        return this.pointsPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOutPrice() {
        return this.outPrice;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ImageBean getSkuImageInfo() {
        return this.skuImageInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSpecsValue() {
        return this.specsValue;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getBaseCommissionRate() {
        return this.baseCommissionRate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getBaseCommission() {
        return this.baseCommission;
    }

    @NotNull
    public final GoodsDetailSku copy(@NotNull String skuNo, int availableStock, @NotNull String salePrice, int pointsPrice, @NotNull String outPrice, @Nullable ImageBean skuImageInfo, @NotNull String specsValue, float baseCommissionRate, float baseCommission, float cooperationCommissionRate, float cooperationCommission, float cooperationServiceChargeRate, float cooperationServiceCharge) {
        Intrinsics.checkNotNullParameter(skuNo, "skuNo");
        Intrinsics.checkNotNullParameter(salePrice, "salePrice");
        Intrinsics.checkNotNullParameter(outPrice, "outPrice");
        Intrinsics.checkNotNullParameter(specsValue, "specsValue");
        return new GoodsDetailSku(skuNo, availableStock, salePrice, pointsPrice, outPrice, skuImageInfo, specsValue, baseCommissionRate, baseCommission, cooperationCommissionRate, cooperationCommission, cooperationServiceChargeRate, cooperationServiceCharge);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailSku)) {
            return false;
        }
        GoodsDetailSku goodsDetailSku = (GoodsDetailSku) other;
        return Intrinsics.areEqual(this.skuNo, goodsDetailSku.skuNo) && this.availableStock == goodsDetailSku.availableStock && Intrinsics.areEqual(this.salePrice, goodsDetailSku.salePrice) && this.pointsPrice == goodsDetailSku.pointsPrice && Intrinsics.areEqual(this.outPrice, goodsDetailSku.outPrice) && Intrinsics.areEqual(this.skuImageInfo, goodsDetailSku.skuImageInfo) && Intrinsics.areEqual(this.specsValue, goodsDetailSku.specsValue) && Float.compare(this.baseCommissionRate, goodsDetailSku.baseCommissionRate) == 0 && Float.compare(this.baseCommission, goodsDetailSku.baseCommission) == 0 && Float.compare(this.cooperationCommissionRate, goodsDetailSku.cooperationCommissionRate) == 0 && Float.compare(this.cooperationCommission, goodsDetailSku.cooperationCommission) == 0 && Float.compare(this.cooperationServiceChargeRate, goodsDetailSku.cooperationServiceChargeRate) == 0 && Float.compare(this.cooperationServiceCharge, goodsDetailSku.cooperationServiceCharge) == 0;
    }

    @NotNull
    public final String formatBaseCommissionRate() {
        if (this.baseCommissionRate == 0.0f) {
            return "0%";
        }
        return i46.a(this.baseCommissionRate) + '%';
    }

    @NotNull
    public final String formatCommission(int squareType) {
        return (char) 165 + i46.a(squareType == 1 ? this.baseCommission : this.cooperationCommission);
    }

    @NotNull
    public final String formatCommissionRate() {
        if (this.cooperationCommissionRate == 0.0f) {
            return "0%";
        }
        return i46.a(this.cooperationCommissionRate) + '%';
    }

    public final int getAvailableStock() {
        return this.availableStock;
    }

    public final float getBaseCommission() {
        return this.baseCommission;
    }

    public final float getBaseCommissionRate() {
        return this.baseCommissionRate;
    }

    public final float getCooperationCommission() {
        return this.cooperationCommission;
    }

    public final float getCooperationCommissionRate() {
        return this.cooperationCommissionRate;
    }

    public final float getCooperationServiceCharge() {
        return this.cooperationServiceCharge;
    }

    public final float getCooperationServiceChargeRate() {
        return this.cooperationServiceChargeRate;
    }

    @NotNull
    public final String getOutPrice() {
        return this.outPrice;
    }

    public final int getPointsPrice() {
        return this.pointsPrice;
    }

    @NotNull
    public final String getSalePrice() {
        return this.salePrice;
    }

    @Nullable
    public final ImageBean getSkuImageInfo() {
        return this.skuImageInfo;
    }

    @NotNull
    public final String getSkuNo() {
        return this.skuNo;
    }

    @NotNull
    public final String getSpecsValue() {
        return this.specsValue;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.skuNo.hashCode() * 31) + Integer.hashCode(this.availableStock)) * 31) + this.salePrice.hashCode()) * 31) + Integer.hashCode(this.pointsPrice)) * 31) + this.outPrice.hashCode()) * 31;
        ImageBean imageBean = this.skuImageInfo;
        return ((((((((((((((iHashCode + (imageBean == null ? 0 : imageBean.hashCode())) * 31) + this.specsValue.hashCode()) * 31) + Float.hashCode(this.baseCommissionRate)) * 31) + Float.hashCode(this.baseCommission)) * 31) + Float.hashCode(this.cooperationCommissionRate)) * 31) + Float.hashCode(this.cooperationCommission)) * 31) + Float.hashCode(this.cooperationServiceChargeRate)) * 31) + Float.hashCode(this.cooperationServiceCharge);
    }

    @NotNull
    public String toString() {
        return "GoodsDetailSku(skuNo=" + this.skuNo + ", availableStock=" + this.availableStock + ", salePrice=" + this.salePrice + ", pointsPrice=" + this.pointsPrice + ", outPrice=" + this.outPrice + ", skuImageInfo=" + this.skuImageInfo + ", specsValue=" + this.specsValue + ", baseCommissionRate=" + this.baseCommissionRate + ", baseCommission=" + this.baseCommission + ", cooperationCommissionRate=" + this.cooperationCommissionRate + ", cooperationCommission=" + this.cooperationCommission + ", cooperationServiceChargeRate=" + this.cooperationServiceChargeRate + ", cooperationServiceCharge=" + this.cooperationServiceCharge + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.skuNo);
        parcel.writeInt(this.availableStock);
        parcel.writeString(this.salePrice);
        parcel.writeInt(this.pointsPrice);
        parcel.writeString(this.outPrice);
        parcel.writeParcelable(this.skuImageInfo, flags);
        parcel.writeString(this.specsValue);
        parcel.writeFloat(this.baseCommissionRate);
        parcel.writeFloat(this.baseCommission);
        parcel.writeFloat(this.cooperationCommissionRate);
        parcel.writeFloat(this.cooperationCommission);
        parcel.writeFloat(this.cooperationServiceChargeRate);
        parcel.writeFloat(this.cooperationServiceCharge);
    }

    public /* synthetic */ GoodsDetailSku(String str, int i, String str2, int i2, String str3, ImageBean imageBean, String str4, float f, float f2, float f3, float f4, float f5, float f6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? null : imageBean, (i3 & 64) == 0 ? str4 : "", (i3 & 128) != 0 ? 0.0f : f, (i3 & 256) != 0 ? 0.0f : f2, (i3 & 512) != 0 ? 0.0f : f3, (i3 & 1024) != 0 ? 0.0f : f4, (i3 & 2048) != 0 ? 0.0f : f5, (i3 & 4096) == 0 ? f6 : 0.0f);
    }
}
