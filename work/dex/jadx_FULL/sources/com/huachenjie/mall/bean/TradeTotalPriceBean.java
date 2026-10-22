package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.cy6;
import com.zj.adlib.fe9;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/huachenjie/mall/bean/TradeTotalPriceBean;", "", "goodsPriceTotal", "", "postage", "shippingFreeFlag", "", "orderAmount", "payPointsTotal", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "bottomAmount", "getBottomAmount", "()Ljava/lang/String;", "bottomPointAmount", "getBottomPointAmount", "getGoodsPriceTotal", "getOrderAmount", "payAmount", "getPayAmount", "getPayPointsTotal", "()I", "getPostage", "getShippingFreeFlag", "()Z", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TradeTotalPriceBean {

    @NotNull
    private final String goodsPriceTotal;

    @NotNull
    private final String orderAmount;
    private final int payPointsTotal;

    @NotNull
    private final String postage;
    private final boolean shippingFreeFlag;

    public TradeTotalPriceBean() {
        this(null, null, false, null, 0, 31, null);
    }

    public TradeTotalPriceBean(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "goodsPriceTotal");
        Intrinsics.checkNotNullParameter(str2, "postage");
        Intrinsics.checkNotNullParameter(str3, "orderAmount");
        this.goodsPriceTotal = str;
        this.postage = str2;
        this.shippingFreeFlag = z;
        this.orderAmount = str3;
        this.payPointsTotal = i;
    }

    public static /* synthetic */ TradeTotalPriceBean copy$default(TradeTotalPriceBean tradeTotalPriceBean, String str, String str2, boolean z, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tradeTotalPriceBean.goodsPriceTotal;
        }
        if ((i2 & 2) != 0) {
            str2 = tradeTotalPriceBean.postage;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            z = tradeTotalPriceBean.shippingFreeFlag;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = tradeTotalPriceBean.orderAmount;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = tradeTotalPriceBean.payPointsTotal;
        }
        return tradeTotalPriceBean.copy(str, str4, z2, str5, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsPriceTotal() {
        return this.goodsPriceTotal;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPostage() {
        return this.postage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShippingFreeFlag() {
        return this.shippingFreeFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPayPointsTotal() {
        return this.payPointsTotal;
    }

    @NotNull
    public final TradeTotalPriceBean copy(@NotNull String goodsPriceTotal, @NotNull String postage, boolean shippingFreeFlag, @NotNull String orderAmount, int payPointsTotal) {
        Intrinsics.checkNotNullParameter(goodsPriceTotal, "goodsPriceTotal");
        Intrinsics.checkNotNullParameter(postage, "postage");
        Intrinsics.checkNotNullParameter(orderAmount, "orderAmount");
        return new TradeTotalPriceBean(goodsPriceTotal, postage, shippingFreeFlag, orderAmount, payPointsTotal);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TradeTotalPriceBean)) {
            return false;
        }
        TradeTotalPriceBean tradeTotalPriceBean = (TradeTotalPriceBean) other;
        return Intrinsics.areEqual(this.goodsPriceTotal, tradeTotalPriceBean.goodsPriceTotal) && Intrinsics.areEqual(this.postage, tradeTotalPriceBean.postage) && this.shippingFreeFlag == tradeTotalPriceBean.shippingFreeFlag && Intrinsics.areEqual(this.orderAmount, tradeTotalPriceBean.orderAmount) && this.payPointsTotal == tradeTotalPriceBean.payPointsTotal;
    }

    @NotNull
    public final String getBottomAmount() {
        if (this.payPointsTotal == 0) {
            return (char) 165 + this.orderAmount;
        }
        if (Intrinsics.areEqual(this.orderAmount, "0") || Intrinsics.areEqual(this.orderAmount, "0.00")) {
            return this.payPointsTotal + fe9.b.FLASH_COINS;
        }
        return (char) 165 + this.orderAmount;
    }

    @NotNull
    public final String getBottomPointAmount() {
        if (this.payPointsTotal == 0 || Intrinsics.areEqual(this.orderAmount, "0") || Intrinsics.areEqual(this.orderAmount, "0.00")) {
            return "";
        }
        return this.payPointsTotal + fe9.b.FLASH_COINS;
    }

    @NotNull
    public final String getGoodsPriceTotal() {
        return this.goodsPriceTotal;
    }

    @NotNull
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    @NotNull
    public final String getPayAmount() {
        return cy6.f(this.orderAmount, this.payPointsTotal);
    }

    public final int getPayPointsTotal() {
        return this.payPointsTotal;
    }

    @NotNull
    public final String getPostage() {
        return this.postage;
    }

    public final boolean getShippingFreeFlag() {
        return this.shippingFreeFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((this.goodsPriceTotal.hashCode() * 31) + this.postage.hashCode()) * 31;
        boolean z = this.shippingFreeFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.orderAmount.hashCode()) * 31) + Integer.hashCode(this.payPointsTotal);
    }

    @NotNull
    public String toString() {
        return "TradeTotalPriceBean(goodsPriceTotal=" + this.goodsPriceTotal + ", postage=" + this.postage + ", shippingFreeFlag=" + this.shippingFreeFlag + ", orderAmount=" + this.orderAmount + ", payPointsTotal=" + this.payPointsTotal + ')';
    }

    public /* synthetic */ TradeTotalPriceBean(String str, String str2, boolean z, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? 0 : i);
    }
}
