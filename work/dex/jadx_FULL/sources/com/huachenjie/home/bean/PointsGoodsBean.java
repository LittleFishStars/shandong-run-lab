package com.huachenjie.home.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import com.alibaba.android.arouter.utils.Consts;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.zj.adlib.b49;
import com.zj.adlib.c49;
import com.zj.adlib.qv1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0011HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0014HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\u0006\u0010>\u001a\u00020\u0003J\u0006\u0010?\u001a\u00020\u0003J\u0006\u0010@\u001a\u00020\u0003J\u0006\u0010A\u001a\u00020\u0003J\u0006\u0010B\u001a\u00020\u0003J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020\u0014J\u0006\u0010F\u001a\u00020\u0014J\t\u0010G\u001a\u00020\u0014HÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017¨\u0006I"}, d2 = {"Lcom/huachenjie/home/bean/PointsGoodsBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "goodsNo", "", "goodsName", "minSkuPrice", "maxSkuPrice", "multipleSku", "", "minPointsInMinPriceSku", "outPrice", "totalSaleCount", "savePrice", "outOfStock", "minSkuPointsPrice", "maxSkuPointsPrice", "imageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "shopNo", "neededPoints", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;Ljava/lang/String;I)V", "getGoodsName", "()Ljava/lang/String;", "getGoodsNo", "getImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getMaxSkuPointsPrice", "getMaxSkuPrice", "getMinPointsInMinPriceSku", "getMinSkuPointsPrice", "getMinSkuPrice", "getMultipleSku", "()Z", "getNeededPoints", "getOutOfStock", "getOutPrice", "getSavePrice", "getShopNo", "getTotalSaleCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "", "findBargainPrice", "findDeduction", "findGoodsCover", "findGoodsName", "findTag", "formatPrice", "", "getCoverHeight", "getCoverWidth", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PointsGoodsBean implements MultiItemEntity {

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @NotNull
    private final ImageBean imageInfo;

    @NotNull
    private final String maxSkuPointsPrice;

    @NotNull
    private final String maxSkuPrice;

    @NotNull
    private final String minPointsInMinPriceSku;

    @NotNull
    private final String minSkuPointsPrice;

    @NotNull
    private final String minSkuPrice;
    private final boolean multipleSku;
    private final int neededPoints;

    @NotNull
    private final String outOfStock;

    @NotNull
    private final String outPrice;

    @NotNull
    private final String savePrice;

    @NotNull
    private final String shopNo;

    @NotNull
    private final String totalSaleCount;

    public PointsGoodsBean() {
        this(null, null, null, null, false, null, null, null, null, null, null, null, null, null, 0, 32767, null);
    }

    public PointsGoodsBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull ImageBean imageBean, @NotNull String str12, int i) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "minSkuPrice");
        Intrinsics.checkNotNullParameter(str4, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(str5, "minPointsInMinPriceSku");
        Intrinsics.checkNotNullParameter(str6, "outPrice");
        Intrinsics.checkNotNullParameter(str7, "totalSaleCount");
        Intrinsics.checkNotNullParameter(str8, "savePrice");
        Intrinsics.checkNotNullParameter(str9, "outOfStock");
        Intrinsics.checkNotNullParameter(str10, "minSkuPointsPrice");
        Intrinsics.checkNotNullParameter(str11, "maxSkuPointsPrice");
        Intrinsics.checkNotNullParameter(imageBean, "imageInfo");
        Intrinsics.checkNotNullParameter(str12, "shopNo");
        this.goodsNo = str;
        this.goodsName = str2;
        this.minSkuPrice = str3;
        this.maxSkuPrice = str4;
        this.multipleSku = z;
        this.minPointsInMinPriceSku = str5;
        this.outPrice = str6;
        this.totalSaleCount = str7;
        this.savePrice = str8;
        this.outOfStock = str9;
        this.minSkuPointsPrice = str10;
        this.maxSkuPointsPrice = str11;
        this.imageInfo = imageBean;
        this.shopNo = str12;
        this.neededPoints = i;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOutOfStock() {
        return this.outOfStock;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMinSkuPointsPrice() {
        return this.minSkuPointsPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getMaxSkuPointsPrice() {
        return this.maxSkuPointsPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getShopNo() {
        return this.shopNo;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getNeededPoints() {
        return this.neededPoints;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getMultipleSku() {
        return this.multipleSku;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMinPointsInMinPriceSku() {
        return this.minPointsInMinPriceSku;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOutPrice() {
        return this.outPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTotalSaleCount() {
        return this.totalSaleCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSavePrice() {
        return this.savePrice;
    }

    @NotNull
    public final PointsGoodsBean copy(@NotNull String goodsNo, @NotNull String goodsName, @NotNull String minSkuPrice, @NotNull String maxSkuPrice, boolean multipleSku, @NotNull String minPointsInMinPriceSku, @NotNull String outPrice, @NotNull String totalSaleCount, @NotNull String savePrice, @NotNull String outOfStock, @NotNull String minSkuPointsPrice, @NotNull String maxSkuPointsPrice, @NotNull ImageBean imageInfo, @NotNull String shopNo, int neededPoints) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        Intrinsics.checkNotNullParameter(maxSkuPrice, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(minPointsInMinPriceSku, "minPointsInMinPriceSku");
        Intrinsics.checkNotNullParameter(outPrice, "outPrice");
        Intrinsics.checkNotNullParameter(totalSaleCount, "totalSaleCount");
        Intrinsics.checkNotNullParameter(savePrice, "savePrice");
        Intrinsics.checkNotNullParameter(outOfStock, "outOfStock");
        Intrinsics.checkNotNullParameter(minSkuPointsPrice, "minSkuPointsPrice");
        Intrinsics.checkNotNullParameter(maxSkuPointsPrice, "maxSkuPointsPrice");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        return new PointsGoodsBean(goodsNo, goodsName, minSkuPrice, maxSkuPrice, multipleSku, minPointsInMinPriceSku, outPrice, totalSaleCount, savePrice, outOfStock, minSkuPointsPrice, maxSkuPointsPrice, imageInfo, shopNo, neededPoints);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointsGoodsBean)) {
            return false;
        }
        PointsGoodsBean pointsGoodsBean = (PointsGoodsBean) other;
        return Intrinsics.areEqual(this.goodsNo, pointsGoodsBean.goodsNo) && Intrinsics.areEqual(this.goodsName, pointsGoodsBean.goodsName) && Intrinsics.areEqual(this.minSkuPrice, pointsGoodsBean.minSkuPrice) && Intrinsics.areEqual(this.maxSkuPrice, pointsGoodsBean.maxSkuPrice) && this.multipleSku == pointsGoodsBean.multipleSku && Intrinsics.areEqual(this.minPointsInMinPriceSku, pointsGoodsBean.minPointsInMinPriceSku) && Intrinsics.areEqual(this.outPrice, pointsGoodsBean.outPrice) && Intrinsics.areEqual(this.totalSaleCount, pointsGoodsBean.totalSaleCount) && Intrinsics.areEqual(this.savePrice, pointsGoodsBean.savePrice) && Intrinsics.areEqual(this.outOfStock, pointsGoodsBean.outOfStock) && Intrinsics.areEqual(this.minSkuPointsPrice, pointsGoodsBean.minSkuPointsPrice) && Intrinsics.areEqual(this.maxSkuPointsPrice, pointsGoodsBean.maxSkuPointsPrice) && Intrinsics.areEqual(this.imageInfo, pointsGoodsBean.imageInfo) && Intrinsics.areEqual(this.shopNo, pointsGoodsBean.shopNo) && this.neededPoints == pointsGoodsBean.neededPoints;
    }

    @NotNull
    public final String findBargainPrice() {
        return "闪金币特价¥" + this.minSkuPrice;
    }

    @NotNull
    public final String findDeduction() {
        return "可抵¥" + this.savePrice;
    }

    @NotNull
    public final String findGoodsCover() {
        return this.imageInfo.getUrl();
    }

    @NotNull
    public final String findGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String findTag() {
        return (char) 24046 + this.neededPoints + "闪金币可享特价";
    }

    @NotNull
    public final CharSequence formatPrice() {
        String str = this.outPrice;
        try {
            c49 c49VarF = c49.f();
            if (StringsKt.contains$default(str, Consts.DOT, false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default(str, new String[]{Consts.DOT}, false, 0, 6, (Object) null);
                if (listSplit$default.size() > 1) {
                    c49VarF.g(new b49().o((String) listSplit$default.get(0)).q(qv1.W(18.0f)).p(Color.parseColor("#FFF3474A")).r(1)).g(new b49().o('.' + ((String) listSplit$default.get(1))).q(qv1.W(11.0f)).p(Color.parseColor("#FFF3474A")).r(1));
                } else {
                    c49VarF.g(new b49().o(str).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FFF3474A")));
                }
            } else {
                c49VarF.g(new b49().o(str).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FFF3474A")));
            }
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            return String.valueOf(str);
        }
    }

    public final int getCoverHeight() {
        return this.imageInfo.getHeight();
    }

    public final int getCoverWidth() {
        return this.imageInfo.getWidth();
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    @NotNull
    public final String getMaxSkuPointsPrice() {
        return this.maxSkuPointsPrice;
    }

    @NotNull
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    @NotNull
    public final String getMinPointsInMinPriceSku() {
        return this.minPointsInMinPriceSku;
    }

    @NotNull
    public final String getMinSkuPointsPrice() {
        return this.minSkuPointsPrice;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    public final boolean getMultipleSku() {
        return this.multipleSku;
    }

    public final int getNeededPoints() {
        return this.neededPoints;
    }

    @NotNull
    public final String getOutOfStock() {
        return this.outOfStock;
    }

    @NotNull
    public final String getOutPrice() {
        return this.outPrice;
    }

    @NotNull
    public final String getSavePrice() {
        return this.savePrice;
    }

    @NotNull
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    public final String getTotalSaleCount() {
        return this.totalSaleCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((this.goodsNo.hashCode() * 31) + this.goodsName.hashCode()) * 31) + this.minSkuPrice.hashCode()) * 31) + this.maxSkuPrice.hashCode()) * 31;
        boolean z = this.multipleSku;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((((((((((iHashCode + r1) * 31) + this.minPointsInMinPriceSku.hashCode()) * 31) + this.outPrice.hashCode()) * 31) + this.totalSaleCount.hashCode()) * 31) + this.savePrice.hashCode()) * 31) + this.outOfStock.hashCode()) * 31) + this.minSkuPointsPrice.hashCode()) * 31) + this.maxSkuPointsPrice.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + this.shopNo.hashCode()) * 31) + Integer.hashCode(this.neededPoints);
    }

    @NotNull
    public String toString() {
        return "PointsGoodsBean(goodsNo=" + this.goodsNo + ", goodsName=" + this.goodsName + ", minSkuPrice=" + this.minSkuPrice + ", maxSkuPrice=" + this.maxSkuPrice + ", multipleSku=" + this.multipleSku + ", minPointsInMinPriceSku=" + this.minPointsInMinPriceSku + ", outPrice=" + this.outPrice + ", totalSaleCount=" + this.totalSaleCount + ", savePrice=" + this.savePrice + ", outOfStock=" + this.outOfStock + ", minSkuPointsPrice=" + this.minSkuPointsPrice + ", maxSkuPointsPrice=" + this.maxSkuPointsPrice + ", imageInfo=" + this.imageInfo + ", shopNo=" + this.shopNo + ", neededPoints=" + this.neededPoints + ')';
    }

    public /* synthetic */ PointsGoodsBean(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ImageBean imageBean, String str12, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) != 0 ? "" : str10, (i2 & 2048) != 0 ? "" : str11, (i2 & 4096) != 0 ? new ImageBean(null, null, 0, 0, 0, 31, null) : imageBean, (i2 & 8192) == 0 ? str12 : "", (i2 & 16384) != 0 ? 0 : i);
    }
}
