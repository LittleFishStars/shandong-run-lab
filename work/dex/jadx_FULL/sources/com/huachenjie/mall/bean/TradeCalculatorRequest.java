package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/bean/TradeCalculatorRequest;", "", "shopNo", "", "goodsNo", "goodsSkuNo", "goodsCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getGoodsCount", "()I", "getGoodsNo", "()Ljava/lang/String;", "getGoodsSkuNo", "getShopNo", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TradeCalculatorRequest {
    private final int goodsCount;

    @NotNull
    private final String goodsNo;

    @NotNull
    private final String goodsSkuNo;

    @NotNull
    private final String shopNo;

    public TradeCalculatorRequest() {
        this(null, null, null, 0, 15, null);
    }

    public TradeCalculatorRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "shopNo");
        Intrinsics.checkNotNullParameter(str2, "goodsNo");
        Intrinsics.checkNotNullParameter(str3, "goodsSkuNo");
        this.shopNo = str;
        this.goodsNo = str2;
        this.goodsSkuNo = str3;
        this.goodsCount = i;
    }

    public static /* synthetic */ TradeCalculatorRequest copy$default(TradeCalculatorRequest tradeCalculatorRequest, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tradeCalculatorRequest.shopNo;
        }
        if ((i2 & 2) != 0) {
            str2 = tradeCalculatorRequest.goodsNo;
        }
        if ((i2 & 4) != 0) {
            str3 = tradeCalculatorRequest.goodsSkuNo;
        }
        if ((i2 & 8) != 0) {
            i = tradeCalculatorRequest.goodsCount;
        }
        return tradeCalculatorRequest.copy(str, str2, str3, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoodsSkuNo() {
        return this.goodsSkuNo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getGoodsCount() {
        return this.goodsCount;
    }

    @NotNull
    public final TradeCalculatorRequest copy(@NotNull String shopNo, @NotNull String goodsNo, @NotNull String goodsSkuNo, int goodsCount) {
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(goodsSkuNo, "goodsSkuNo");
        return new TradeCalculatorRequest(shopNo, goodsNo, goodsSkuNo, goodsCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TradeCalculatorRequest)) {
            return false;
        }
        TradeCalculatorRequest tradeCalculatorRequest = (TradeCalculatorRequest) other;
        return Intrinsics.areEqual(this.shopNo, tradeCalculatorRequest.shopNo) && Intrinsics.areEqual(this.goodsNo, tradeCalculatorRequest.goodsNo) && Intrinsics.areEqual(this.goodsSkuNo, tradeCalculatorRequest.goodsSkuNo) && this.goodsCount == tradeCalculatorRequest.goodsCount;
    }

    public final int getGoodsCount() {
        return this.goodsCount;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    public final String getGoodsSkuNo() {
        return this.goodsSkuNo;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    public int hashCode() {
        return (((((this.shopNo.hashCode() * 31) + this.goodsNo.hashCode()) * 31) + this.goodsSkuNo.hashCode()) * 31) + Integer.hashCode(this.goodsCount);
    }

    @NotNull
    public String toString() {
        return "TradeCalculatorRequest(shopNo=" + this.shopNo + ", goodsNo=" + this.goodsNo + ", goodsSkuNo=" + this.goodsSkuNo + ", goodsCount=" + this.goodsCount + ')';
    }

    public /* synthetic */ TradeCalculatorRequest(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}
