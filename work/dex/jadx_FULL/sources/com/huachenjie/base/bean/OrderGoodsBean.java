package com.huachenjie.base.bean;

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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0002\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\u008b\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001J\t\u00108\u001a\u00020\nHÖ\u0001J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\nHÖ\u0001J\u0006\u0010=\u001a\u00020\rJ\t\u0010>\u001a\u00020\u0003HÖ\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\nHÖ\u0001R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010!R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014¨\u0006D"}, d2 = {"Lcom/huachenjie/base/bean/OrderGoodsBean;", "Landroid/os/Parcelable;", "goodsNo", "", "orderItemNo", "goodsName", "goodsSpec", "goodsImage", "goodsUnitPrice", "goodsCount", "", "afterSaleStatus", "afterSaleApplyFlag", "", "refundAmountMax", "returnGoodsFlag", "refundOrderNo", "payPointsUnit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;ZLjava/lang/String;I)V", "getAfterSaleApplyFlag", "()Z", "setAfterSaleApplyFlag", "(Z)V", "getAfterSaleStatus", "()I", "setAfterSaleStatus", "(I)V", "getGoodsCount", "getGoodsImage", "()Ljava/lang/String;", "getGoodsName", "getGoodsNo", "setGoodsNo", "(Ljava/lang/String;)V", "getGoodsSpec", "getGoodsUnitPrice", "getOrderItemNo", "setOrderItemNo", "getPayPointsUnit", "getRefundAmountMax", "getRefundOrderNo", "getReturnGoodsFlag", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "isSaleProcessing", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderGoodsBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrderGoodsBean> CREATOR = new Creator();
    private boolean afterSaleApplyFlag;
    private int afterSaleStatus;
    private final int goodsCount;

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsName;

    @NotNull
    private String goodsNo;

    @NotNull
    private final String goodsSpec;

    @NotNull
    private final String goodsUnitPrice;

    @NotNull
    private String orderItemNo;
    private final int payPointsUnit;

    @NotNull
    private final String refundAmountMax;

    @NotNull
    private final String refundOrderNo;
    private final boolean returnGoodsFlag;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderGoodsBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderGoodsBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderGoodsBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderGoodsBean[] newArray(int i) {
            return new OrderGoodsBean[i];
        }
    }

    public OrderGoodsBean() {
        this(null, null, null, null, null, null, 0, 0, false, null, false, null, 0, 8191, null);
    }

    public OrderGoodsBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i, int i2, boolean z, @NotNull String str7, boolean z2, @NotNull String str8, int i3) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "orderItemNo");
        Intrinsics.checkNotNullParameter(str3, "goodsName");
        Intrinsics.checkNotNullParameter(str4, "goodsSpec");
        Intrinsics.checkNotNullParameter(str5, "goodsImage");
        Intrinsics.checkNotNullParameter(str6, "goodsUnitPrice");
        Intrinsics.checkNotNullParameter(str7, "refundAmountMax");
        Intrinsics.checkNotNullParameter(str8, "refundOrderNo");
        this.goodsNo = str;
        this.orderItemNo = str2;
        this.goodsName = str3;
        this.goodsSpec = str4;
        this.goodsImage = str5;
        this.goodsUnitPrice = str6;
        this.goodsCount = i;
        this.afterSaleStatus = i2;
        this.afterSaleApplyFlag = z;
        this.refundAmountMax = str7;
        this.returnGoodsFlag = z2;
        this.refundOrderNo = str8;
        this.payPointsUnit = i3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRefundAmountMax() {
        return this.refundAmountMax;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getReturnGoodsFlag() {
        return this.returnGoodsFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRefundOrderNo() {
        return this.refundOrderNo;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getPayPointsUnit() {
        return this.payPointsUnit;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGoodsUnitPrice() {
        return this.goodsUnitPrice;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getGoodsCount() {
        return this.goodsCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAfterSaleApplyFlag() {
        return this.afterSaleApplyFlag;
    }

    @NotNull
    public final OrderGoodsBean copy(@NotNull String goodsNo, @NotNull String orderItemNo, @NotNull String goodsName, @NotNull String goodsSpec, @NotNull String goodsImage, @NotNull String goodsUnitPrice, int goodsCount, int afterSaleStatus, boolean afterSaleApplyFlag, @NotNull String refundAmountMax, boolean returnGoodsFlag, @NotNull String refundOrderNo, int payPointsUnit) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(goodsSpec, "goodsSpec");
        Intrinsics.checkNotNullParameter(goodsImage, "goodsImage");
        Intrinsics.checkNotNullParameter(goodsUnitPrice, "goodsUnitPrice");
        Intrinsics.checkNotNullParameter(refundAmountMax, "refundAmountMax");
        Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
        return new OrderGoodsBean(goodsNo, orderItemNo, goodsName, goodsSpec, goodsImage, goodsUnitPrice, goodsCount, afterSaleStatus, afterSaleApplyFlag, refundAmountMax, returnGoodsFlag, refundOrderNo, payPointsUnit);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderGoodsBean)) {
            return false;
        }
        OrderGoodsBean orderGoodsBean = (OrderGoodsBean) other;
        return Intrinsics.areEqual(this.goodsNo, orderGoodsBean.goodsNo) && Intrinsics.areEqual(this.orderItemNo, orderGoodsBean.orderItemNo) && Intrinsics.areEqual(this.goodsName, orderGoodsBean.goodsName) && Intrinsics.areEqual(this.goodsSpec, orderGoodsBean.goodsSpec) && Intrinsics.areEqual(this.goodsImage, orderGoodsBean.goodsImage) && Intrinsics.areEqual(this.goodsUnitPrice, orderGoodsBean.goodsUnitPrice) && this.goodsCount == orderGoodsBean.goodsCount && this.afterSaleStatus == orderGoodsBean.afterSaleStatus && this.afterSaleApplyFlag == orderGoodsBean.afterSaleApplyFlag && Intrinsics.areEqual(this.refundAmountMax, orderGoodsBean.refundAmountMax) && this.returnGoodsFlag == orderGoodsBean.returnGoodsFlag && Intrinsics.areEqual(this.refundOrderNo, orderGoodsBean.refundOrderNo) && this.payPointsUnit == orderGoodsBean.payPointsUnit;
    }

    public final boolean getAfterSaleApplyFlag() {
        return this.afterSaleApplyFlag;
    }

    public final int getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    public final int getGoodsCount() {
        return this.goodsCount;
    }

    @NotNull
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    @NotNull
    public final String getGoodsUnitPrice() {
        return this.goodsUnitPrice;
    }

    @NotNull
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    public final int getPayPointsUnit() {
        return this.payPointsUnit;
    }

    @NotNull
    public final String getRefundAmountMax() {
        return this.refundAmountMax;
    }

    @NotNull
    public final String getRefundOrderNo() {
        return this.refundOrderNo;
    }

    public final boolean getReturnGoodsFlag() {
        return this.returnGoodsFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.goodsNo.hashCode() * 31) + this.orderItemNo.hashCode()) * 31) + this.goodsName.hashCode()) * 31) + this.goodsSpec.hashCode()) * 31) + this.goodsImage.hashCode()) * 31) + this.goodsUnitPrice.hashCode()) * 31) + Integer.hashCode(this.goodsCount)) * 31) + Integer.hashCode(this.afterSaleStatus)) * 31;
        boolean z = this.afterSaleApplyFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.refundAmountMax.hashCode()) * 31;
        boolean z2 = this.returnGoodsFlag;
        return ((((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.refundOrderNo.hashCode()) * 31) + Integer.hashCode(this.payPointsUnit);
    }

    public final boolean isSaleProcessing() {
        int i = this.afterSaleStatus;
        return i == 2 || i == 3 || i == 5 || i == 6 || i == 7;
    }

    public final void setAfterSaleApplyFlag(boolean z) {
        this.afterSaleApplyFlag = z;
    }

    public final void setAfterSaleStatus(int i) {
        this.afterSaleStatus = i;
    }

    public final void setGoodsNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsNo = str;
    }

    public final void setOrderItemNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderItemNo = str;
    }

    @NotNull
    public String toString() {
        return "OrderGoodsBean(goodsNo=" + this.goodsNo + ", orderItemNo=" + this.orderItemNo + ", goodsName=" + this.goodsName + ", goodsSpec=" + this.goodsSpec + ", goodsImage=" + this.goodsImage + ", goodsUnitPrice=" + this.goodsUnitPrice + ", goodsCount=" + this.goodsCount + ", afterSaleStatus=" + this.afterSaleStatus + ", afterSaleApplyFlag=" + this.afterSaleApplyFlag + ", refundAmountMax=" + this.refundAmountMax + ", returnGoodsFlag=" + this.returnGoodsFlag + ", refundOrderNo=" + this.refundOrderNo + ", payPointsUnit=" + this.payPointsUnit + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.goodsNo);
        parcel.writeString(this.orderItemNo);
        parcel.writeString(this.goodsName);
        parcel.writeString(this.goodsSpec);
        parcel.writeString(this.goodsImage);
        parcel.writeString(this.goodsUnitPrice);
        parcel.writeInt(this.goodsCount);
        parcel.writeInt(this.afterSaleStatus);
        parcel.writeInt(this.afterSaleApplyFlag ? 1 : 0);
        parcel.writeString(this.refundAmountMax);
        parcel.writeInt(this.returnGoodsFlag ? 1 : 0);
        parcel.writeString(this.refundOrderNo);
        parcel.writeInt(this.payPointsUnit);
    }

    public /* synthetic */ OrderGoodsBean(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, boolean z, String str7, boolean z2, String str8, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "" : str4, (i4 & 16) != 0 ? "" : str5, (i4 & 32) != 0 ? "" : str6, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? false : z, (i4 & 512) != 0 ? "" : str7, (i4 & 1024) != 0 ? false : z2, (i4 & 2048) == 0 ? str8 : "", (i4 & 4096) == 0 ? i3 : 0);
    }
}
