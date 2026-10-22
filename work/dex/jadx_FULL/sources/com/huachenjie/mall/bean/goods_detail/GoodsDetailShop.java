package com.huachenjie.mall.bean.goods_detail;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.external.bean.CommodityBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;", "", "type", "", "desc", "Lcom/huachenjie/mall/bean/MerchantsBean;", "goodsList", "", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "shopGoodsShow", "", "(ILcom/huachenjie/mall/bean/MerchantsBean;Ljava/util/List;Z)V", "getDesc", "()Lcom/huachenjie/mall/bean/MerchantsBean;", "getGoodsList", "()Ljava/util/List;", "getShopGoodsShow", "()Z", "getType", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailShop {

    @NotNull
    private final MerchantsBean desc;

    @Nullable
    private final List<CommodityBean> goodsList;
    private final boolean shopGoodsShow;
    private final int type;

    public GoodsDetailShop(int i, @NotNull MerchantsBean merchantsBean, @Nullable List<CommodityBean> list, boolean z) {
        Intrinsics.checkNotNullParameter(merchantsBean, "desc");
        this.type = i;
        this.desc = merchantsBean;
        this.goodsList = list;
        this.shopGoodsShow = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodsDetailShop copy$default(GoodsDetailShop goodsDetailShop, int i, MerchantsBean merchantsBean, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = goodsDetailShop.type;
        }
        if ((i2 & 2) != 0) {
            merchantsBean = goodsDetailShop.desc;
        }
        if ((i2 & 4) != 0) {
            list = goodsDetailShop.goodsList;
        }
        if ((i2 & 8) != 0) {
            z = goodsDetailShop.shopGoodsShow;
        }
        return goodsDetailShop.copy(i, merchantsBean, list, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MerchantsBean getDesc() {
        return this.desc;
    }

    @Nullable
    public final List<CommodityBean> component3() {
        return this.goodsList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShopGoodsShow() {
        return this.shopGoodsShow;
    }

    @NotNull
    public final GoodsDetailShop copy(int type, @NotNull MerchantsBean desc, @Nullable List<CommodityBean> goodsList, boolean shopGoodsShow) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new GoodsDetailShop(type, desc, goodsList, shopGoodsShow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailShop)) {
            return false;
        }
        GoodsDetailShop goodsDetailShop = (GoodsDetailShop) other;
        return this.type == goodsDetailShop.type && Intrinsics.areEqual(this.desc, goodsDetailShop.desc) && Intrinsics.areEqual(this.goodsList, goodsDetailShop.goodsList) && this.shopGoodsShow == goodsDetailShop.shopGoodsShow;
    }

    @NotNull
    public final MerchantsBean getDesc() {
        return this.desc;
    }

    @Nullable
    public final List<CommodityBean> getGoodsList() {
        return this.goodsList;
    }

    public final boolean getShopGoodsShow() {
        return this.shopGoodsShow;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.type) * 31) + this.desc.hashCode()) * 31;
        List<CommodityBean> list = this.goodsList;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.shopGoodsShow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    @NotNull
    public String toString() {
        return "GoodsDetailShop(type=" + this.type + ", desc=" + this.desc + ", goodsList=" + this.goodsList + ", shopGoodsShow=" + this.shopGoodsShow + ')';
    }

    public /* synthetic */ GoodsDetailShop(int i, MerchantsBean merchantsBean, List list, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, merchantsBean, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? false : z);
    }
}
