package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/bean/TradeOrderResult;", "", "tradeNo", "", "payRemainTime", "", "orderNo", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrderNo", "()Ljava/lang/String;", "getPayRemainTime", "()I", "getTradeNo", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TradeOrderResult {

    @NotNull
    private final String orderNo;
    private final int payRemainTime;

    @NotNull
    private final String tradeNo;

    public TradeOrderResult() {
        this(null, 0, null, 7, null);
    }

    public TradeOrderResult(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tradeNo");
        Intrinsics.checkNotNullParameter(str2, "orderNo");
        this.tradeNo = str;
        this.payRemainTime = i;
        this.orderNo = str2;
    }

    public static /* synthetic */ TradeOrderResult copy$default(TradeOrderResult tradeOrderResult, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tradeOrderResult.tradeNo;
        }
        if ((i2 & 2) != 0) {
            i = tradeOrderResult.payRemainTime;
        }
        if ((i2 & 4) != 0) {
            str2 = tradeOrderResult.orderNo;
        }
        return tradeOrderResult.copy(str, i, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTradeNo() {
        return this.tradeNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPayRemainTime() {
        return this.payRemainTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    @NotNull
    public final TradeOrderResult copy(@NotNull String tradeNo, int payRemainTime, @NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(tradeNo, "tradeNo");
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        return new TradeOrderResult(tradeNo, payRemainTime, orderNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TradeOrderResult)) {
            return false;
        }
        TradeOrderResult tradeOrderResult = (TradeOrderResult) other;
        return Intrinsics.areEqual(this.tradeNo, tradeOrderResult.tradeNo) && this.payRemainTime == tradeOrderResult.payRemainTime && Intrinsics.areEqual(this.orderNo, tradeOrderResult.orderNo);
    }

    @NotNull
    public final String getOrderNo() {
        return this.orderNo;
    }

    public final int getPayRemainTime() {
        return this.payRemainTime;
    }

    @NotNull
    public final String getTradeNo() {
        return this.tradeNo;
    }

    public int hashCode() {
        return (((this.tradeNo.hashCode() * 31) + Integer.hashCode(this.payRemainTime)) * 31) + this.orderNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "TradeOrderResult(tradeNo=" + this.tradeNo + ", payRemainTime=" + this.payRemainTime + ", orderNo=" + this.orderNo + ')';
    }

    public /* synthetic */ TradeOrderResult(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }
}
