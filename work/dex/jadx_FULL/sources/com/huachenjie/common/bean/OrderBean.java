package com.huachenjie.common.bean;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J`\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010¨\u00064"}, d2 = {"Lcom/huachenjie/common/bean/OrderBean;", "Landroid/os/Parcelable;", "orderCode", "", "orderPrice", "", "orderNo", "partnerId", "prepayId", "nonceStr", "timeStamp", UserTrackConstant.SIGN, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNonceStr", "()Ljava/lang/String;", "setNonceStr", "(Ljava/lang/String;)V", "getOrderCode", "getOrderNo", "getOrderPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPartnerId", "setPartnerId", "getPrepayId", "setPrepayId", "getSign", "setSign", "getTimeStamp", "setTimeStamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/huachenjie/common/bean/OrderBean;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrderBean> CREATOR = new Creator();

    @NotNull
    private String nonceStr;

    @NotNull
    private final String orderCode;

    @NotNull
    private final String orderNo;

    @Nullable
    private final Integer orderPrice;

    @NotNull
    private String partnerId;

    @NotNull
    private String prepayId;

    @NotNull
    private String sign;

    @NotNull
    private String timeStamp;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderBean(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderBean[] newArray(int i) {
            return new OrderBean[i];
        }
    }

    public OrderBean() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public OrderBean(@NotNull String str, @Nullable Integer num, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "orderCode");
        Intrinsics.checkNotNullParameter(str2, "orderNo");
        Intrinsics.checkNotNullParameter(str3, "partnerId");
        Intrinsics.checkNotNullParameter(str4, "prepayId");
        Intrinsics.checkNotNullParameter(str5, "nonceStr");
        Intrinsics.checkNotNullParameter(str6, "timeStamp");
        Intrinsics.checkNotNullParameter(str7, UserTrackConstant.SIGN);
        this.orderCode = str;
        this.orderPrice = num;
        this.orderNo = str2;
        this.partnerId = str3;
        this.prepayId = str4;
        this.nonceStr = str5;
        this.timeStamp = str6;
        this.sign = str7;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderCode() {
        return this.orderCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getOrderPrice() {
        return this.orderPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPartnerId() {
        return this.partnerId;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrepayId() {
        return this.prepayId;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNonceStr() {
        return this.nonceStr;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    @NotNull
    public final OrderBean copy(@NotNull String orderCode, @Nullable Integer orderPrice, @NotNull String orderNo, @NotNull String partnerId, @NotNull String prepayId, @NotNull String nonceStr, @NotNull String timeStamp, @NotNull String sign) {
        Intrinsics.checkNotNullParameter(orderCode, "orderCode");
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(partnerId, "partnerId");
        Intrinsics.checkNotNullParameter(prepayId, "prepayId");
        Intrinsics.checkNotNullParameter(nonceStr, "nonceStr");
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        Intrinsics.checkNotNullParameter(sign, UserTrackConstant.SIGN);
        return new OrderBean(orderCode, orderPrice, orderNo, partnerId, prepayId, nonceStr, timeStamp, sign);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderBean)) {
            return false;
        }
        OrderBean orderBean = (OrderBean) other;
        return Intrinsics.areEqual(this.orderCode, orderBean.orderCode) && Intrinsics.areEqual(this.orderPrice, orderBean.orderPrice) && Intrinsics.areEqual(this.orderNo, orderBean.orderNo) && Intrinsics.areEqual(this.partnerId, orderBean.partnerId) && Intrinsics.areEqual(this.prepayId, orderBean.prepayId) && Intrinsics.areEqual(this.nonceStr, orderBean.nonceStr) && Intrinsics.areEqual(this.timeStamp, orderBean.timeStamp) && Intrinsics.areEqual(this.sign, orderBean.sign);
    }

    @NotNull
    public final String getNonceStr() {
        return this.nonceStr;
    }

    @NotNull
    public final String getOrderCode() {
        return this.orderCode;
    }

    @NotNull
    public final String getOrderNo() {
        return this.orderNo;
    }

    @Nullable
    public final Integer getOrderPrice() {
        return this.orderPrice;
    }

    @NotNull
    public final String getPartnerId() {
        return this.partnerId;
    }

    @NotNull
    public final String getPrepayId() {
        return this.prepayId;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    @NotNull
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        int iHashCode = this.orderCode.hashCode() * 31;
        Integer num = this.orderPrice;
        return ((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.orderNo.hashCode()) * 31) + this.partnerId.hashCode()) * 31) + this.prepayId.hashCode()) * 31) + this.nonceStr.hashCode()) * 31) + this.timeStamp.hashCode()) * 31) + this.sign.hashCode();
    }

    public final void setNonceStr(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nonceStr = str;
    }

    public final void setPartnerId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.partnerId = str;
    }

    public final void setPrepayId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prepayId = str;
    }

    public final void setSign(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sign = str;
    }

    public final void setTimeStamp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeStamp = str;
    }

    @NotNull
    public String toString() {
        return "OrderBean(orderCode=" + this.orderCode + ", orderPrice=" + this.orderPrice + ", orderNo=" + this.orderNo + ", partnerId=" + this.partnerId + ", prepayId=" + this.prepayId + ", nonceStr=" + this.nonceStr + ", timeStamp=" + this.timeStamp + ", sign=" + this.sign + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.orderCode);
        Integer num = this.orderPrice;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeString(this.orderNo);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.prepayId);
        parcel.writeString(this.nonceStr);
        parcel.writeString(this.timeStamp);
        parcel.writeString(this.sign);
    }

    public /* synthetic */ OrderBean(String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) == 0 ? str7 : "");
    }
}
