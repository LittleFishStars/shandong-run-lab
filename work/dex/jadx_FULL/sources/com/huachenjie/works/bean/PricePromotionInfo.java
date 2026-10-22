package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/bean/PricePromotionInfo;", "", "reservePrice", "", "zkFinalPrice", "finalPromotionPrice", "promotionTagList", "", "Lcom/huachenjie/works/bean/PromotionTagList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFinalPromotionPrice", "()Ljava/lang/String;", "setFinalPromotionPrice", "(Ljava/lang/String;)V", "getPromotionTagList", "()Ljava/util/List;", "getReservePrice", "setReservePrice", "getZkFinalPrice", "setZkFinalPrice", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PricePromotionInfo {

    @NotNull
    private String finalPromotionPrice;

    @NotNull
    private final List<PromotionTagList> promotionTagList;

    @NotNull
    private String reservePrice;

    @NotNull
    private String zkFinalPrice;

    public PricePromotionInfo() {
        this(null, null, null, null, 15, null);
    }

    public PricePromotionInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<PromotionTagList> list) {
        Intrinsics.checkNotNullParameter(str, "reservePrice");
        Intrinsics.checkNotNullParameter(str2, "zkFinalPrice");
        Intrinsics.checkNotNullParameter(str3, "finalPromotionPrice");
        Intrinsics.checkNotNullParameter(list, "promotionTagList");
        this.reservePrice = str;
        this.zkFinalPrice = str2;
        this.finalPromotionPrice = str3;
        this.promotionTagList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PricePromotionInfo copy$default(PricePromotionInfo pricePromotionInfo, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pricePromotionInfo.reservePrice;
        }
        if ((i & 2) != 0) {
            str2 = pricePromotionInfo.zkFinalPrice;
        }
        if ((i & 4) != 0) {
            str3 = pricePromotionInfo.finalPromotionPrice;
        }
        if ((i & 8) != 0) {
            list = pricePromotionInfo.promotionTagList;
        }
        return pricePromotionInfo.copy(str, str2, str3, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReservePrice() {
        return this.reservePrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getZkFinalPrice() {
        return this.zkFinalPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFinalPromotionPrice() {
        return this.finalPromotionPrice;
    }

    @NotNull
    public final List<PromotionTagList> component4() {
        return this.promotionTagList;
    }

    @NotNull
    public final PricePromotionInfo copy(@NotNull String reservePrice, @NotNull String zkFinalPrice, @NotNull String finalPromotionPrice, @NotNull List<PromotionTagList> promotionTagList) {
        Intrinsics.checkNotNullParameter(reservePrice, "reservePrice");
        Intrinsics.checkNotNullParameter(zkFinalPrice, "zkFinalPrice");
        Intrinsics.checkNotNullParameter(finalPromotionPrice, "finalPromotionPrice");
        Intrinsics.checkNotNullParameter(promotionTagList, "promotionTagList");
        return new PricePromotionInfo(reservePrice, zkFinalPrice, finalPromotionPrice, promotionTagList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PricePromotionInfo)) {
            return false;
        }
        PricePromotionInfo pricePromotionInfo = (PricePromotionInfo) other;
        return Intrinsics.areEqual(this.reservePrice, pricePromotionInfo.reservePrice) && Intrinsics.areEqual(this.zkFinalPrice, pricePromotionInfo.zkFinalPrice) && Intrinsics.areEqual(this.finalPromotionPrice, pricePromotionInfo.finalPromotionPrice) && Intrinsics.areEqual(this.promotionTagList, pricePromotionInfo.promotionTagList);
    }

    @NotNull
    public final String getFinalPromotionPrice() {
        return this.finalPromotionPrice;
    }

    @NotNull
    public final List<PromotionTagList> getPromotionTagList() {
        return this.promotionTagList;
    }

    @NotNull
    public final String getReservePrice() {
        return this.reservePrice;
    }

    @NotNull
    public final String getZkFinalPrice() {
        return this.zkFinalPrice;
    }

    public int hashCode() {
        return (((((this.reservePrice.hashCode() * 31) + this.zkFinalPrice.hashCode()) * 31) + this.finalPromotionPrice.hashCode()) * 31) + this.promotionTagList.hashCode();
    }

    public final void setFinalPromotionPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.finalPromotionPrice = str;
    }

    public final void setReservePrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reservePrice = str;
    }

    public final void setZkFinalPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zkFinalPrice = str;
    }

    @NotNull
    public String toString() {
        return "PricePromotionInfo(reservePrice=" + this.reservePrice + ", zkFinalPrice=" + this.zkFinalPrice + ", finalPromotionPrice=" + this.finalPromotionPrice + ", promotionTagList=" + this.promotionTagList + ')';
    }

    public /* synthetic */ PricePromotionInfo(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new ArrayList() : list);
    }
}
