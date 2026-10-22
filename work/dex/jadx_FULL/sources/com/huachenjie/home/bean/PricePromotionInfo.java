package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006#"}, d2 = {"Lcom/huachenjie/home/bean/PricePromotionInfo;", "", "reservePrice", "", "zkFinalPrice", "finalPromotionPrice", "promotionTagList", "", "Lcom/huachenjie/home/bean/PromotionTagList;", "finalPromotionPathList", "Lcom/huachenjie/home/bean/PromotionPathList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getFinalPromotionPathList", "()Ljava/util/List;", "getFinalPromotionPrice", "()Ljava/lang/String;", "setFinalPromotionPrice", "(Ljava/lang/String;)V", "getPromotionTagList", "getReservePrice", "setReservePrice", "getZkFinalPrice", "setZkFinalPrice", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PricePromotionInfo {

    @NotNull
    private final List<PromotionPathList> finalPromotionPathList;

    @NotNull
    private String finalPromotionPrice;

    @NotNull
    private final List<PromotionTagList> promotionTagList;

    @NotNull
    private String reservePrice;

    @NotNull
    private String zkFinalPrice;

    public PricePromotionInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public PricePromotionInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<PromotionTagList> list, @NotNull List<PromotionPathList> list2) {
        Intrinsics.checkNotNullParameter(str, "reservePrice");
        Intrinsics.checkNotNullParameter(str2, "zkFinalPrice");
        Intrinsics.checkNotNullParameter(str3, "finalPromotionPrice");
        Intrinsics.checkNotNullParameter(list, "promotionTagList");
        Intrinsics.checkNotNullParameter(list2, "finalPromotionPathList");
        this.reservePrice = str;
        this.zkFinalPrice = str2;
        this.finalPromotionPrice = str3;
        this.promotionTagList = list;
        this.finalPromotionPathList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PricePromotionInfo copy$default(PricePromotionInfo pricePromotionInfo, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pricePromotionInfo.reservePrice;
        }
        if ((i & 2) != 0) {
            str2 = pricePromotionInfo.zkFinalPrice;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = pricePromotionInfo.finalPromotionPrice;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            list = pricePromotionInfo.promotionTagList;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = pricePromotionInfo.finalPromotionPathList;
        }
        return pricePromotionInfo.copy(str, str4, str5, list3, list2);
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
    public final List<PromotionPathList> component5() {
        return this.finalPromotionPathList;
    }

    @NotNull
    public final PricePromotionInfo copy(@NotNull String reservePrice, @NotNull String zkFinalPrice, @NotNull String finalPromotionPrice, @NotNull List<PromotionTagList> promotionTagList, @NotNull List<PromotionPathList> finalPromotionPathList) {
        Intrinsics.checkNotNullParameter(reservePrice, "reservePrice");
        Intrinsics.checkNotNullParameter(zkFinalPrice, "zkFinalPrice");
        Intrinsics.checkNotNullParameter(finalPromotionPrice, "finalPromotionPrice");
        Intrinsics.checkNotNullParameter(promotionTagList, "promotionTagList");
        Intrinsics.checkNotNullParameter(finalPromotionPathList, "finalPromotionPathList");
        return new PricePromotionInfo(reservePrice, zkFinalPrice, finalPromotionPrice, promotionTagList, finalPromotionPathList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PricePromotionInfo)) {
            return false;
        }
        PricePromotionInfo pricePromotionInfo = (PricePromotionInfo) other;
        return Intrinsics.areEqual(this.reservePrice, pricePromotionInfo.reservePrice) && Intrinsics.areEqual(this.zkFinalPrice, pricePromotionInfo.zkFinalPrice) && Intrinsics.areEqual(this.finalPromotionPrice, pricePromotionInfo.finalPromotionPrice) && Intrinsics.areEqual(this.promotionTagList, pricePromotionInfo.promotionTagList) && Intrinsics.areEqual(this.finalPromotionPathList, pricePromotionInfo.finalPromotionPathList);
    }

    @NotNull
    public final List<PromotionPathList> getFinalPromotionPathList() {
        return this.finalPromotionPathList;
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
        return (((((((this.reservePrice.hashCode() * 31) + this.zkFinalPrice.hashCode()) * 31) + this.finalPromotionPrice.hashCode()) * 31) + this.promotionTagList.hashCode()) * 31) + this.finalPromotionPathList.hashCode();
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
        return "PricePromotionInfo(reservePrice=" + this.reservePrice + ", zkFinalPrice=" + this.zkFinalPrice + ", finalPromotionPrice=" + this.finalPromotionPrice + ", promotionTagList=" + this.promotionTagList + ", finalPromotionPathList=" + this.finalPromotionPathList + ')';
    }

    public /* synthetic */ PricePromotionInfo(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? new ArrayList() : list, (i & 16) != 0 ? new ArrayList() : list2);
    }
}
