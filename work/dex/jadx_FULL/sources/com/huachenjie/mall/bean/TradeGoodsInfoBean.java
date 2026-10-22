package com.huachenjie.mall.bean;

import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.cy6;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\bHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!¨\u0006:"}, d2 = {"Lcom/huachenjie/mall/bean/TradeGoodsInfoBean;", "", "goodsNo", "", "shopNo", "skuNo", "goodsUnitPrice", "payPointsUnit", "", "goodsImage", "goodsSpec", "goodsName", "shopLogo", "shopName", "postage", "shippingFreeFlag", "", "valid", SendToNativeCallback.KEY_MESSAGE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getGoodsImage", "getGoodsName", "getGoodsNo", "goodsPrice", "getGoodsPrice", "getGoodsSpec", "getGoodsUnitPrice", "getPayPointsUnit", "()I", "getPostage", "getShippingFreeFlag", "()Z", "getShopLogo", "getShopName", "getShopNo", "getSkuNo", "getValid", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TradeGoodsInfoBean {

    @NotNull
    private final String errorMessage;

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @NotNull
    private final String goodsSpec;

    @NotNull
    private final String goodsUnitPrice;
    private final int payPointsUnit;

    @NotNull
    private final String postage;
    private final boolean shippingFreeFlag;

    @NotNull
    private final String shopLogo;

    @NotNull
    private final String shopName;

    @NotNull
    private final String shopNo;

    @NotNull
    private final String skuNo;
    private final boolean valid;

    public TradeGoodsInfoBean() {
        this(null, null, null, null, 0, null, null, null, null, null, null, false, false, null, 16383, null);
    }

    public TradeGoodsInfoBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, boolean z, boolean z2, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "shopNo");
        Intrinsics.checkNotNullParameter(str3, "skuNo");
        Intrinsics.checkNotNullParameter(str4, "goodsUnitPrice");
        Intrinsics.checkNotNullParameter(str5, "goodsImage");
        Intrinsics.checkNotNullParameter(str6, "goodsSpec");
        Intrinsics.checkNotNullParameter(str7, "goodsName");
        Intrinsics.checkNotNullParameter(str8, "shopLogo");
        Intrinsics.checkNotNullParameter(str9, "shopName");
        Intrinsics.checkNotNullParameter(str10, "postage");
        Intrinsics.checkNotNullParameter(str11, SendToNativeCallback.KEY_MESSAGE);
        this.goodsNo = str;
        this.shopNo = str2;
        this.skuNo = str3;
        this.goodsUnitPrice = str4;
        this.payPointsUnit = i;
        this.goodsImage = str5;
        this.goodsSpec = str6;
        this.goodsName = str7;
        this.shopLogo = str8;
        this.shopName = str9;
        this.postage = str10;
        this.shippingFreeFlag = z;
        this.valid = z2;
        this.errorMessage = str11;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPostage() {
        return this.postage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShippingFreeFlag() {
        return this.shippingFreeFlag;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getValid() {
        return this.valid;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSkuNo() {
        return this.skuNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGoodsUnitPrice() {
        return this.goodsUnitPrice;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPayPointsUnit() {
        return this.payPointsUnit;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getShopLogo() {
        return this.shopLogo;
    }

    @NotNull
    public final TradeGoodsInfoBean copy(@NotNull String goodsNo, @NotNull String shopNo, @NotNull String skuNo, @NotNull String goodsUnitPrice, int payPointsUnit, @NotNull String goodsImage, @NotNull String goodsSpec, @NotNull String goodsName, @NotNull String shopLogo, @NotNull String shopName, @NotNull String postage, boolean shippingFreeFlag, boolean valid, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        Intrinsics.checkNotNullParameter(skuNo, "skuNo");
        Intrinsics.checkNotNullParameter(goodsUnitPrice, "goodsUnitPrice");
        Intrinsics.checkNotNullParameter(goodsImage, "goodsImage");
        Intrinsics.checkNotNullParameter(goodsSpec, "goodsSpec");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(shopLogo, "shopLogo");
        Intrinsics.checkNotNullParameter(shopName, "shopName");
        Intrinsics.checkNotNullParameter(postage, "postage");
        Intrinsics.checkNotNullParameter(errorMessage, SendToNativeCallback.KEY_MESSAGE);
        return new TradeGoodsInfoBean(goodsNo, shopNo, skuNo, goodsUnitPrice, payPointsUnit, goodsImage, goodsSpec, goodsName, shopLogo, shopName, postage, shippingFreeFlag, valid, errorMessage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TradeGoodsInfoBean)) {
            return false;
        }
        TradeGoodsInfoBean tradeGoodsInfoBean = (TradeGoodsInfoBean) other;
        return Intrinsics.areEqual(this.goodsNo, tradeGoodsInfoBean.goodsNo) && Intrinsics.areEqual(this.shopNo, tradeGoodsInfoBean.shopNo) && Intrinsics.areEqual(this.skuNo, tradeGoodsInfoBean.skuNo) && Intrinsics.areEqual(this.goodsUnitPrice, tradeGoodsInfoBean.goodsUnitPrice) && this.payPointsUnit == tradeGoodsInfoBean.payPointsUnit && Intrinsics.areEqual(this.goodsImage, tradeGoodsInfoBean.goodsImage) && Intrinsics.areEqual(this.goodsSpec, tradeGoodsInfoBean.goodsSpec) && Intrinsics.areEqual(this.goodsName, tradeGoodsInfoBean.goodsName) && Intrinsics.areEqual(this.shopLogo, tradeGoodsInfoBean.shopLogo) && Intrinsics.areEqual(this.shopName, tradeGoodsInfoBean.shopName) && Intrinsics.areEqual(this.postage, tradeGoodsInfoBean.postage) && this.shippingFreeFlag == tradeGoodsInfoBean.shippingFreeFlag && this.valid == tradeGoodsInfoBean.valid && Intrinsics.areEqual(this.errorMessage, tradeGoodsInfoBean.errorMessage);
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
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
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    public final String getGoodsPrice() {
        return cy6.f(this.goodsUnitPrice, this.payPointsUnit);
    }

    @NotNull
    public final String getGoodsSpec() {
        return this.goodsSpec;
    }

    @NotNull
    public final String getGoodsUnitPrice() {
        return this.goodsUnitPrice;
    }

    public final int getPayPointsUnit() {
        return this.payPointsUnit;
    }

    @NotNull
    public final String getPostage() {
        return this.postage;
    }

    public final boolean getShippingFreeFlag() {
        return this.shippingFreeFlag;
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

    @NotNull
    public final String getSkuNo() {
        return this.skuNo;
    }

    public final boolean getValid() {
        return this.valid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.goodsNo.hashCode() * 31) + this.shopNo.hashCode()) * 31) + this.skuNo.hashCode()) * 31) + this.goodsUnitPrice.hashCode()) * 31) + Integer.hashCode(this.payPointsUnit)) * 31) + this.goodsImage.hashCode()) * 31) + this.goodsSpec.hashCode()) * 31) + this.goodsName.hashCode()) * 31) + this.shopLogo.hashCode()) * 31) + this.shopName.hashCode()) * 31) + this.postage.hashCode()) * 31;
        boolean z = this.shippingFreeFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.valid;
        return ((i + (z2 ? 1 : z2)) * 31) + this.errorMessage.hashCode();
    }

    @NotNull
    public String toString() {
        return "TradeGoodsInfoBean(goodsNo=" + this.goodsNo + ", shopNo=" + this.shopNo + ", skuNo=" + this.skuNo + ", goodsUnitPrice=" + this.goodsUnitPrice + ", payPointsUnit=" + this.payPointsUnit + ", goodsImage=" + this.goodsImage + ", goodsSpec=" + this.goodsSpec + ", goodsName=" + this.goodsName + ", shopLogo=" + this.shopLogo + ", shopName=" + this.shopName + ", postage=" + this.postage + ", shippingFreeFlag=" + this.shippingFreeFlag + ", valid=" + this.valid + ", errorMessage=" + this.errorMessage + ')';
    }

    public /* synthetic */ TradeGoodsInfoBean(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) != 0 ? "" : str10, (i2 & 2048) != 0 ? false : z, (i2 & 4096) == 0 ? z2 : false, (i2 & 8192) == 0 ? str11 : "");
    }
}
