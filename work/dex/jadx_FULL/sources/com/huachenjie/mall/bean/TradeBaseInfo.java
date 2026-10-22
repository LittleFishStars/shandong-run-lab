package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/bean/TradeBaseInfo;", "", "goodsInfo", "Lcom/huachenjie/mall/bean/TradeGoodsInfoBean;", "totalPrice", "Lcom/huachenjie/mall/bean/TradeTotalPriceBean;", "valid", "", "payFlag", "(Lcom/huachenjie/mall/bean/TradeGoodsInfoBean;Lcom/huachenjie/mall/bean/TradeTotalPriceBean;ZZ)V", "getGoodsInfo", "()Lcom/huachenjie/mall/bean/TradeGoodsInfoBean;", "getPayFlag", "()Z", "getTotalPrice", "()Lcom/huachenjie/mall/bean/TradeTotalPriceBean;", "getValid", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TradeBaseInfo {

    @NotNull
    private final TradeGoodsInfoBean goodsInfo;
    private final boolean payFlag;

    @NotNull
    private final TradeTotalPriceBean totalPrice;
    private final boolean valid;

    public TradeBaseInfo() {
        this(null, null, false, false, 15, null);
    }

    public TradeBaseInfo(@NotNull TradeGoodsInfoBean tradeGoodsInfoBean, @NotNull TradeTotalPriceBean tradeTotalPriceBean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(tradeGoodsInfoBean, "goodsInfo");
        Intrinsics.checkNotNullParameter(tradeTotalPriceBean, "totalPrice");
        this.goodsInfo = tradeGoodsInfoBean;
        this.totalPrice = tradeTotalPriceBean;
        this.valid = z;
        this.payFlag = z2;
    }

    public static /* synthetic */ TradeBaseInfo copy$default(TradeBaseInfo tradeBaseInfo, TradeGoodsInfoBean tradeGoodsInfoBean, TradeTotalPriceBean tradeTotalPriceBean, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            tradeGoodsInfoBean = tradeBaseInfo.goodsInfo;
        }
        if ((i & 2) != 0) {
            tradeTotalPriceBean = tradeBaseInfo.totalPrice;
        }
        if ((i & 4) != 0) {
            z = tradeBaseInfo.valid;
        }
        if ((i & 8) != 0) {
            z2 = tradeBaseInfo.payFlag;
        }
        return tradeBaseInfo.copy(tradeGoodsInfoBean, tradeTotalPriceBean, z, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TradeGoodsInfoBean getGoodsInfo() {
        return this.goodsInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TradeTotalPriceBean getTotalPrice() {
        return this.totalPrice;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getPayFlag() {
        return this.payFlag;
    }

    @NotNull
    public final TradeBaseInfo copy(@NotNull TradeGoodsInfoBean goodsInfo, @NotNull TradeTotalPriceBean totalPrice, boolean valid, boolean payFlag) {
        Intrinsics.checkNotNullParameter(goodsInfo, "goodsInfo");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        return new TradeBaseInfo(goodsInfo, totalPrice, valid, payFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TradeBaseInfo)) {
            return false;
        }
        TradeBaseInfo tradeBaseInfo = (TradeBaseInfo) other;
        return Intrinsics.areEqual(this.goodsInfo, tradeBaseInfo.goodsInfo) && Intrinsics.areEqual(this.totalPrice, tradeBaseInfo.totalPrice) && this.valid == tradeBaseInfo.valid && this.payFlag == tradeBaseInfo.payFlag;
    }

    @NotNull
    public final TradeGoodsInfoBean getGoodsInfo() {
        return this.goodsInfo;
    }

    public final boolean getPayFlag() {
        return this.payFlag;
    }

    @NotNull
    public final TradeTotalPriceBean getTotalPrice() {
        return this.totalPrice;
    }

    public final boolean getValid() {
        return this.valid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.goodsInfo.hashCode() * 31) + this.totalPrice.hashCode()) * 31;
        boolean z = this.valid;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.payFlag;
        return i + (z2 ? 1 : z2);
    }

    @NotNull
    public String toString() {
        return "TradeBaseInfo(goodsInfo=" + this.goodsInfo + ", totalPrice=" + this.totalPrice + ", valid=" + this.valid + ", payFlag=" + this.payFlag + ')';
    }

    public /* synthetic */ TradeBaseInfo(TradeGoodsInfoBean tradeGoodsInfoBean, TradeTotalPriceBean tradeTotalPriceBean, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TradeGoodsInfoBean(null, null, null, null, 0, null, null, null, null, null, null, false, false, null, 16383, null) : tradeGoodsInfoBean, (i & 2) != 0 ? new TradeTotalPriceBean(null, null, false, null, 0, 31, null) : tradeTotalPriceBean, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2);
    }
}
