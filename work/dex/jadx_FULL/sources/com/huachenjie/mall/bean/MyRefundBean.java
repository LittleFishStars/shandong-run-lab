package com.huachenjie.mall.bean;

import com.alipay.sdk.m.y.o;
import com.huachenjie.run.map.RouteOverlay;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0003R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u0006)"}, d2 = {"Lcom/huachenjie/mall/bean/MyRefundBean;", "", "refundOrderNo", "", "refundStatusType", "", "refundStatusTypeDesc", "shopName", "shopLogo", "shopNo", "goodsName", "goodsSpec", "goodsImage", "refundAmount", "afterSaleType", "afterSaleTypeDesc", "logisticStatus", o.b, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getAfterSaleType", "()I", "getAfterSaleTypeDesc", "()Ljava/lang/String;", "getGoodsImage", "getGoodsName", "getGoodsSpec", "getLogisticStatus", "setLogisticStatus", "(I)V", "getMemo", "getRefundAmount", "getRefundOrderNo", "getRefundStatusType", "getRefundStatusTypeDesc", "getShopLogo", "getShopName", "getShopNo", "canCancelRefund", "", "formatterRefundStatusColor", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MyRefundBean {
    public static final int AFTER_SALE_STATUS_TYPE_CLOSE = 4;
    public static final int REFUND_STATUS_TYPE_DISPATCH = 2;
    public static final int REFUND_STATUS_TYPE_FINISH = 3;
    public static final int REFUND_STATUS_TYPE_NONE = 0;
    public static final int REFUND_STATUS_TYPE_WAIT_MERCHANT = 1;
    private final int afterSaleType;

    @NotNull
    private final String afterSaleTypeDesc;

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsSpec;
    private int logisticStatus;

    @NotNull
    private final String memo;

    @NotNull
    private final String refundAmount;

    @NotNull
    private final String refundOrderNo;
    private final int refundStatusType;

    @NotNull
    private final String refundStatusTypeDesc;

    @NotNull
    private final String shopLogo;

    @NotNull
    private final String shopName;

    @NotNull
    private final String shopNo;

    public MyRefundBean() {
        this(null, 0, null, null, null, null, null, null, null, null, 0, null, 0, null, 16383, null);
    }

    public MyRefundBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i2, @NotNull String str10, int i3, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "refundOrderNo");
        Intrinsics.checkNotNullParameter(str2, "refundStatusTypeDesc");
        Intrinsics.checkNotNullParameter(str3, "shopName");
        Intrinsics.checkNotNullParameter(str4, "shopLogo");
        Intrinsics.checkNotNullParameter(str5, "shopNo");
        Intrinsics.checkNotNullParameter(str6, "goodsName");
        Intrinsics.checkNotNullParameter(str7, "goodsSpec");
        Intrinsics.checkNotNullParameter(str8, "goodsImage");
        Intrinsics.checkNotNullParameter(str9, "refundAmount");
        Intrinsics.checkNotNullParameter(str10, "afterSaleTypeDesc");
        Intrinsics.checkNotNullParameter(str11, o.b);
        this.refundOrderNo = str;
        this.refundStatusType = i;
        this.refundStatusTypeDesc = str2;
        this.shopName = str3;
        this.shopLogo = str4;
        this.shopNo = str5;
        this.goodsName = str6;
        this.goodsSpec = str7;
        this.goodsImage = str8;
        this.refundAmount = str9;
        this.afterSaleType = i2;
        this.afterSaleTypeDesc = str10;
        this.logisticStatus = i3;
        this.memo = str11;
    }

    public final boolean canCancelRefund() {
        int i = this.refundStatusType;
        if (i != 1) {
            return i == 2 && this.logisticStatus == 1;
        }
        return true;
    }

    @NotNull
    public final String formatterRefundStatusColor() {
        int i = this.refundStatusType;
        if (i == 1 || i == 2) {
            return RouteOverlay.f12338c;
        }
        return i != 3 ? "#8997A4" : "#2C3E50";
    }

    public final int getAfterSaleType() {
        return this.afterSaleType;
    }

    @NotNull
    public final String getAfterSaleTypeDesc() {
        return this.afterSaleTypeDesc;
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
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    public final int getLogisticStatus() {
        return this.logisticStatus;
    }

    @NotNull
    public final String getMemo() {
        return this.memo;
    }

    @NotNull
    public final String getRefundAmount() {
        return this.refundAmount;
    }

    @NotNull
    public final String getRefundOrderNo() {
        return this.refundOrderNo;
    }

    public final int getRefundStatusType() {
        return this.refundStatusType;
    }

    @NotNull
    public final String getRefundStatusTypeDesc() {
        return this.refundStatusTypeDesc;
    }

    @NotNull
    public final String getShopLogo() {
        return this.shopLogo;
    }

    @NotNull
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    public final void setLogisticStatus(int i) {
        this.logisticStatus = i;
    }

    public /* synthetic */ MyRefundBean(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, int i3, String str11, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? "" : str6, (i4 & 128) != 0 ? "" : str7, (i4 & 256) != 0 ? "" : str8, (i4 & 512) != 0 ? "" : str9, (i4 & 1024) != 0 ? 0 : i2, (i4 & 2048) != 0 ? "" : str10, (i4 & 4096) == 0 ? i3 : 0, (i4 & 8192) == 0 ? str11 : "");
    }
}
