package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ir5;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0006J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\t\u0010\u001d\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/social_contact/bean/BuyStarDrillInfo;", "", "goodsList", "", "Lcom/huachenjie/social_contact/bean/GoodsInfo;", "doubleStarDill", "", "(Ljava/util/List;I)V", "getDoubleStarDill", "()I", "getGoodsList", "()Ljava/util/List;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "getLeftPayAmount", "", "getLeftPayAmountStr", "", "getLeftStarDrill", "getRightPayAmount", "getRightPayAmountStr", "getRightStarDrill", "hashCode", "showLeft", "showRight", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuyStarDrillInfo {
    private final int doubleStarDill;

    @Nullable
    private final List<GoodsInfo> goodsList;

    public BuyStarDrillInfo(@Nullable List<GoodsInfo> list, int i) {
        this.goodsList = list;
        this.doubleStarDill = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuyStarDrillInfo copy$default(BuyStarDrillInfo buyStarDrillInfo, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = buyStarDrillInfo.goodsList;
        }
        if ((i2 & 2) != 0) {
            i = buyStarDrillInfo.doubleStarDill;
        }
        return buyStarDrillInfo.copy(list, i);
    }

    @Nullable
    public final List<GoodsInfo> component1() {
        return this.goodsList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDoubleStarDill() {
        return this.doubleStarDill;
    }

    @NotNull
    public final BuyStarDrillInfo copy(@Nullable List<GoodsInfo> goodsList, int doubleStarDill) {
        return new BuyStarDrillInfo(goodsList, doubleStarDill);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuyStarDrillInfo)) {
            return false;
        }
        BuyStarDrillInfo buyStarDrillInfo = (BuyStarDrillInfo) other;
        return Intrinsics.areEqual(this.goodsList, buyStarDrillInfo.goodsList) && this.doubleStarDill == buyStarDrillInfo.doubleStarDill;
    }

    public final int getDoubleStarDill() {
        return this.doubleStarDill;
    }

    @Nullable
    public final List<GoodsInfo> getGoodsList() {
        return this.goodsList;
    }

    public final float getLeftPayAmount() {
        List<GoodsInfo> list;
        GoodsInfo goodsInfo;
        if (!showLeft() || (list = this.goodsList) == null || (goodsInfo = list.get(0)) == null) {
            return 0.0f;
        }
        return goodsInfo.getGoodsAmount();
    }

    @NotNull
    public final String getLeftPayAmountStr() {
        String strA = ir5.a(Float.valueOf(getLeftPayAmount()));
        Intrinsics.checkNotNullExpressionValue(strA, "getMoneyStr(getLeftPayAmount())");
        return strA;
    }

    public final int getLeftStarDrill() {
        List<GoodsInfo> list;
        GoodsInfo goodsInfo;
        if (!showLeft() || (list = this.goodsList) == null || (goodsInfo = list.get(0)) == null) {
            return 0;
        }
        return goodsInfo.getStarDrill();
    }

    public final float getRightPayAmount() {
        List<GoodsInfo> list;
        GoodsInfo goodsInfo;
        if (!showRight() || (list = this.goodsList) == null || (goodsInfo = list.get(1)) == null) {
            return 0.0f;
        }
        return goodsInfo.getGoodsAmount();
    }

    @NotNull
    public final String getRightPayAmountStr() {
        String strA = ir5.a(Float.valueOf(getRightPayAmount()));
        Intrinsics.checkNotNullExpressionValue(strA, "getMoneyStr(getRightPayAmount())");
        return strA;
    }

    public final int getRightStarDrill() {
        List<GoodsInfo> list;
        GoodsInfo goodsInfo;
        if (!showRight() || (list = this.goodsList) == null || (goodsInfo = list.get(1)) == null) {
            return 0;
        }
        return goodsInfo.getStarDrill();
    }

    public int hashCode() {
        List<GoodsInfo> list = this.goodsList;
        return ((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.doubleStarDill);
    }

    public final boolean showLeft() {
        List<GoodsInfo> list = this.goodsList;
        return list != null && list.size() >= 1;
    }

    public final boolean showRight() {
        List<GoodsInfo> list = this.goodsList;
        return list != null && list.size() >= 2;
    }

    @NotNull
    public String toString() {
        return "BuyStarDrillInfo(goodsList=" + this.goodsList + ", doubleStarDill=" + this.doubleStarDill + ')';
    }

    public /* synthetic */ BuyStarDrillInfo(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i);
    }
}
