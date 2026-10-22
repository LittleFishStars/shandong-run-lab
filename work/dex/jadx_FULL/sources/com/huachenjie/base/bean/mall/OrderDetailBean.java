package com.huachenjie.base.bean.mall;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u009f\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0002\u0010\u0018J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\u0012HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J£\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0012HÆ\u0001J\t\u0010B\u001a\u00020\u0012HÖ\u0001J\u0013\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\u0012HÖ\u0001J\t\u0010G\u001a\u00020\bHÖ\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&¨\u0006N"}, d2 = {"Lcom/huachenjie/base/bean/mall/OrderDetailBean;", "Lcom/huachenjie/base/bean/MyOrderBean;", "Landroid/os/Parcelable;", "addressInfo", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "signFlag", "", "payTypeDesc", "", "submitTime", "", "payTime", "deliveryTime", "finishTime", "cancelTime", "cancelReason", "postage", "afterSaleStatus", "", "afterSaleApplyFlag", "shopAccId", "logisticInfo", "Lcom/huachenjie/base/bean/mall/OrderDetailLogisticBean;", "payPointsTotal", "(Lcom/huachenjie/base/bean/mall/ShippingAddressBean;ZLjava/lang/String;JJJJJLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Lcom/huachenjie/base/bean/mall/OrderDetailLogisticBean;I)V", "getAddressInfo", "()Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "setAddressInfo", "(Lcom/huachenjie/base/bean/mall/ShippingAddressBean;)V", "getAfterSaleApplyFlag", "()Z", "getAfterSaleStatus", "()I", "setAfterSaleStatus", "(I)V", "getCancelReason", "()Ljava/lang/String;", "getCancelTime", "()J", "getDeliveryTime", "getFinishTime", "getLogisticInfo", "()Lcom/huachenjie/base/bean/mall/OrderDetailLogisticBean;", "getPayPointsTotal", "getPayTime", "getPayTypeDesc", "getPostage", "getShopAccId", "getSignFlag", "getSubmitTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderDetailBean extends MyOrderBean implements Parcelable {

    @Nullable
    private ShippingAddressBean addressInfo;
    private final boolean afterSaleApplyFlag;
    private int afterSaleStatus;

    @NotNull
    private final String cancelReason;
    private final long cancelTime;
    private final long deliveryTime;
    private final long finishTime;

    @Nullable
    private final OrderDetailLogisticBean logisticInfo;
    private final int payPointsTotal;
    private final long payTime;

    @NotNull
    private final String payTypeDesc;

    @NotNull
    private final String postage;

    @NotNull
    private final String shopAccId;
    private final boolean signFlag;
    private final long submitTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<OrderDetailBean> CREATOR = new Creator();

    @NotNull
    private static final Lazy<SimpleDateFormat> dataFormatter$delegate = LazyKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.huachenjie.base.bean.mall.OrderDetailBean$Companion$dataFormatter$2
        @NotNull
        public final SimpleDateFormat invoke() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/huachenjie/base/bean/mall/OrderDetailBean$Companion;", "", "()V", "dataFormatter", "Ljava/text/SimpleDateFormat;", "getDataFormatter", "()Ljava/text/SimpleDateFormat;", "dataFormatter$delegate", "Lkotlin/Lazy;", "formatterTime", "", "secondTime", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleDateFormat getDataFormatter() {
            return (SimpleDateFormat) OrderDetailBean.dataFormatter$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final String formatterTime(long secondTime) {
            String str = getDataFormatter().format(new Date(secondTime * ((long) 1000)));
            Intrinsics.checkNotNullExpressionValue(str, "dataFormatter.format(Date(secondTime * 1000))");
            return str;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderDetailBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderDetailBean(parcel.readInt() == 0 ? null : ShippingAddressBean.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? OrderDetailLogisticBean.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderDetailBean[] newArray(int i) {
            return new OrderDetailBean[i];
        }
    }

    public OrderDetailBean() {
        this(null, false, null, 0L, 0L, 0L, 0L, 0L, null, null, 0, false, null, null, 0, 32767, null);
    }

    public /* synthetic */ OrderDetailBean(ShippingAddressBean shippingAddressBean, boolean z, String str, long j, long j2, long j3, long j4, long j5, String str2, String str3, int i, boolean z2, String str4, OrderDetailLogisticBean orderDetailLogisticBean, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : shippingAddressBean, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? 0L : j2, (i3 & 32) != 0 ? 0L : j3, (i3 & 64) != 0 ? 0L : j4, (i3 & 128) == 0 ? j5 : 0L, (i3 & 256) != 0 ? "" : str2, (i3 & 512) != 0 ? "0" : str3, (i3 & 1024) != 0 ? 0 : i, (i3 & 2048) != 0 ? false : z2, (i3 & 4096) != 0 ? "" : str4, (i3 & 8192) != 0 ? null : orderDetailLogisticBean, (i3 & 16384) != 0 ? 0 : i2);
    }

    @JvmStatic
    @NotNull
    public static final String formatterTime(long j) {
        return INSTANCE.formatterTime(j);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ShippingAddressBean getAddressInfo() {
        return this.addressInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPostage() {
        return this.postage;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getAfterSaleApplyFlag() {
        return this.afterSaleApplyFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getShopAccId() {
        return this.shopAccId;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final OrderDetailLogisticBean getLogisticInfo() {
        return this.logisticInfo;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getPayPointsTotal() {
        return this.payPointsTotal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSignFlag() {
        return this.signFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPayTypeDesc() {
        return this.payTypeDesc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPayTime() {
        return this.payTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDeliveryTime() {
        return this.deliveryTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getFinishTime() {
        return this.finishTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getCancelTime() {
        return this.cancelTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCancelReason() {
        return this.cancelReason;
    }

    @NotNull
    public final OrderDetailBean copy(@Nullable ShippingAddressBean addressInfo, boolean signFlag, @NotNull String payTypeDesc, long submitTime, long payTime, long deliveryTime, long finishTime, long cancelTime, @NotNull String cancelReason, @NotNull String postage, int afterSaleStatus, boolean afterSaleApplyFlag, @NotNull String shopAccId, @Nullable OrderDetailLogisticBean logisticInfo, int payPointsTotal) {
        Intrinsics.checkNotNullParameter(payTypeDesc, "payTypeDesc");
        Intrinsics.checkNotNullParameter(cancelReason, "cancelReason");
        Intrinsics.checkNotNullParameter(postage, "postage");
        Intrinsics.checkNotNullParameter(shopAccId, "shopAccId");
        return new OrderDetailBean(addressInfo, signFlag, payTypeDesc, submitTime, payTime, deliveryTime, finishTime, cancelTime, cancelReason, postage, afterSaleStatus, afterSaleApplyFlag, shopAccId, logisticInfo, payPointsTotal);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderDetailBean)) {
            return false;
        }
        OrderDetailBean orderDetailBean = (OrderDetailBean) other;
        return Intrinsics.areEqual(this.addressInfo, orderDetailBean.addressInfo) && this.signFlag == orderDetailBean.signFlag && Intrinsics.areEqual(this.payTypeDesc, orderDetailBean.payTypeDesc) && this.submitTime == orderDetailBean.submitTime && this.payTime == orderDetailBean.payTime && this.deliveryTime == orderDetailBean.deliveryTime && this.finishTime == orderDetailBean.finishTime && this.cancelTime == orderDetailBean.cancelTime && Intrinsics.areEqual(this.cancelReason, orderDetailBean.cancelReason) && Intrinsics.areEqual(this.postage, orderDetailBean.postage) && this.afterSaleStatus == orderDetailBean.afterSaleStatus && this.afterSaleApplyFlag == orderDetailBean.afterSaleApplyFlag && Intrinsics.areEqual(this.shopAccId, orderDetailBean.shopAccId) && Intrinsics.areEqual(this.logisticInfo, orderDetailBean.logisticInfo) && this.payPointsTotal == orderDetailBean.payPointsTotal;
    }

    @Nullable
    public final ShippingAddressBean getAddressInfo() {
        return this.addressInfo;
    }

    public final boolean getAfterSaleApplyFlag() {
        return this.afterSaleApplyFlag;
    }

    public final int getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    @NotNull
    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final long getCancelTime() {
        return this.cancelTime;
    }

    public final long getDeliveryTime() {
        return this.deliveryTime;
    }

    public final long getFinishTime() {
        return this.finishTime;
    }

    @Nullable
    public final OrderDetailLogisticBean getLogisticInfo() {
        return this.logisticInfo;
    }

    public final int getPayPointsTotal() {
        return this.payPointsTotal;
    }

    public final long getPayTime() {
        return this.payTime;
    }

    @NotNull
    public final String getPayTypeDesc() {
        return this.payTypeDesc;
    }

    @NotNull
    public final String getPostage() {
        return this.postage;
    }

    @NotNull
    public final String getShopAccId() {
        return this.shopAccId;
    }

    public final boolean getSignFlag() {
        return this.signFlag;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ShippingAddressBean shippingAddressBean = this.addressInfo;
        int iHashCode = (shippingAddressBean == null ? 0 : shippingAddressBean.hashCode()) * 31;
        boolean z = this.signFlag;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode2 = (((((((((((((((((((iHashCode + r2) * 31) + this.payTypeDesc.hashCode()) * 31) + Long.hashCode(this.submitTime)) * 31) + Long.hashCode(this.payTime)) * 31) + Long.hashCode(this.deliveryTime)) * 31) + Long.hashCode(this.finishTime)) * 31) + Long.hashCode(this.cancelTime)) * 31) + this.cancelReason.hashCode()) * 31) + this.postage.hashCode()) * 31) + Integer.hashCode(this.afterSaleStatus)) * 31;
        boolean z2 = this.afterSaleApplyFlag;
        int iHashCode3 = (((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.shopAccId.hashCode()) * 31;
        OrderDetailLogisticBean orderDetailLogisticBean = this.logisticInfo;
        return ((iHashCode3 + (orderDetailLogisticBean != null ? orderDetailLogisticBean.hashCode() : 0)) * 31) + Integer.hashCode(this.payPointsTotal);
    }

    public final void setAddressInfo(@Nullable ShippingAddressBean shippingAddressBean) {
        this.addressInfo = shippingAddressBean;
    }

    public final void setAfterSaleStatus(int i) {
        this.afterSaleStatus = i;
    }

    @NotNull
    public String toString() {
        return "OrderDetailBean(addressInfo=" + this.addressInfo + ", signFlag=" + this.signFlag + ", payTypeDesc=" + this.payTypeDesc + ", submitTime=" + this.submitTime + ", payTime=" + this.payTime + ", deliveryTime=" + this.deliveryTime + ", finishTime=" + this.finishTime + ", cancelTime=" + this.cancelTime + ", cancelReason=" + this.cancelReason + ", postage=" + this.postage + ", afterSaleStatus=" + this.afterSaleStatus + ", afterSaleApplyFlag=" + this.afterSaleApplyFlag + ", shopAccId=" + this.shopAccId + ", logisticInfo=" + this.logisticInfo + ", payPointsTotal=" + this.payPointsTotal + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ShippingAddressBean shippingAddressBean = this.addressInfo;
        if (shippingAddressBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shippingAddressBean.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.signFlag ? 1 : 0);
        parcel.writeString(this.payTypeDesc);
        parcel.writeLong(this.submitTime);
        parcel.writeLong(this.payTime);
        parcel.writeLong(this.deliveryTime);
        parcel.writeLong(this.finishTime);
        parcel.writeLong(this.cancelTime);
        parcel.writeString(this.cancelReason);
        parcel.writeString(this.postage);
        parcel.writeInt(this.afterSaleStatus);
        parcel.writeInt(this.afterSaleApplyFlag ? 1 : 0);
        parcel.writeString(this.shopAccId);
        OrderDetailLogisticBean orderDetailLogisticBean = this.logisticInfo;
        if (orderDetailLogisticBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            orderDetailLogisticBean.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.payPointsTotal);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailBean(@Nullable ShippingAddressBean shippingAddressBean, boolean z, @NotNull String str, long j, long j2, long j3, long j4, long j5, @NotNull String str2, @NotNull String str3, int i, boolean z2, @NotNull String str4, @Nullable OrderDetailLogisticBean orderDetailLogisticBean, int i2) {
        super(null, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, false, false, false, 0, 0, 524287, null);
        Intrinsics.checkNotNullParameter(str, "payTypeDesc");
        Intrinsics.checkNotNullParameter(str2, "cancelReason");
        Intrinsics.checkNotNullParameter(str3, "postage");
        Intrinsics.checkNotNullParameter(str4, "shopAccId");
        this.addressInfo = shippingAddressBean;
        this.signFlag = z;
        this.payTypeDesc = str;
        this.submitTime = j;
        this.payTime = j2;
        this.deliveryTime = j3;
        this.finishTime = j4;
        this.cancelTime = j5;
        this.cancelReason = str2;
        this.postage = str3;
        this.afterSaleStatus = i;
        this.afterSaleApplyFlag = z2;
        this.shopAccId = str4;
        this.logisticInfo = orderDetailLogisticBean;
        this.payPointsTotal = i2;
    }
}
