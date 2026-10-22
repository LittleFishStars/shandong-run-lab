package com.huachenjie.mall.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.b49;
import com.zj.adlib.c49;
import com.zj.adlib.cy6;
import com.zj.adlib.qv1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006*"}, d2 = {"Lcom/huachenjie/mall/bean/PosterDetailBean;", "", "goodsName", "", "goodsNo", "minSkuPrice", "maxSkuPrice", "outPrice", "imageUrl", UserConstants.USER_PARAMS.b, "avatar", "qrCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getGoodsName", "getGoodsNo", "getImageUrl", "getMaxSkuPrice", "getMinSkuPrice", "getNickName", "getOutPrice", "getQrCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "formatOldPrice", "", "formatPrice", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PosterDetailBean {

    @NotNull
    private final String avatar;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @NotNull
    private final String imageUrl;

    @NotNull
    private final String maxSkuPrice;

    @NotNull
    private final String minSkuPrice;

    @NotNull
    private final String nickName;

    @NotNull
    private final String outPrice;

    @NotNull
    private final String qrCode;

    public PosterDetailBean() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public PosterDetailBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "goodsName");
        Intrinsics.checkNotNullParameter(str2, "goodsNo");
        Intrinsics.checkNotNullParameter(str3, "minSkuPrice");
        Intrinsics.checkNotNullParameter(str4, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(str5, "outPrice");
        Intrinsics.checkNotNullParameter(str6, "imageUrl");
        Intrinsics.checkNotNullParameter(str7, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str8, "avatar");
        Intrinsics.checkNotNullParameter(str9, "qrCode");
        this.goodsName = str;
        this.goodsNo = str2;
        this.minSkuPrice = str3;
        this.maxSkuPrice = str4;
        this.outPrice = str5;
        this.imageUrl = str6;
        this.nickName = str7;
        this.avatar = str8;
        this.qrCode = str9;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
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

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOutPrice() {
        return this.outPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getQrCode() {
        return this.qrCode;
    }

    @NotNull
    public final PosterDetailBean copy(@NotNull String goodsName, @NotNull String goodsNo, @NotNull String minSkuPrice, @NotNull String maxSkuPrice, @NotNull String outPrice, @NotNull String imageUrl, @NotNull String nickName, @NotNull String avatar, @NotNull String qrCode) {
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        Intrinsics.checkNotNullParameter(maxSkuPrice, "maxSkuPrice");
        Intrinsics.checkNotNullParameter(outPrice, "outPrice");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        return new PosterDetailBean(goodsName, goodsNo, minSkuPrice, maxSkuPrice, outPrice, imageUrl, nickName, avatar, qrCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PosterDetailBean)) {
            return false;
        }
        PosterDetailBean posterDetailBean = (PosterDetailBean) other;
        return Intrinsics.areEqual(this.goodsName, posterDetailBean.goodsName) && Intrinsics.areEqual(this.goodsNo, posterDetailBean.goodsNo) && Intrinsics.areEqual(this.minSkuPrice, posterDetailBean.minSkuPrice) && Intrinsics.areEqual(this.maxSkuPrice, posterDetailBean.maxSkuPrice) && Intrinsics.areEqual(this.outPrice, posterDetailBean.outPrice) && Intrinsics.areEqual(this.imageUrl, posterDetailBean.imageUrl) && Intrinsics.areEqual(this.nickName, posterDetailBean.nickName) && Intrinsics.areEqual(this.avatar, posterDetailBean.avatar) && Intrinsics.areEqual(this.qrCode, posterDetailBean.qrCode);
    }

    @NotNull
    public final CharSequence formatOldPrice() {
        if (TextUtils.isEmpty(this.outPrice)) {
            return "";
        }
        try {
            c49 c49VarF = c49.f();
            c49VarF.g(new b49().o((char) 165 + this.outPrice).l(true).q(qv1.W(13.0f)).p(Color.parseColor("#FF8997A4")));
            SpannableStringBuilder spannableStringBuilderE = c49VarF.e();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilderE, "builder.build()");
            return spannableStringBuilderE;
        } catch (Exception unused) {
            return (char) 165 + this.outPrice;
        }
    }

    @NotNull
    public final CharSequence formatPrice() {
        return cy6.d(this.minSkuPrice, 26.0f, 14.0f, "#FF2C3E50", false, 16, null);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
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
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getMaxSkuPrice() {
        return this.maxSkuPrice;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getOutPrice() {
        return this.outPrice;
    }

    @NotNull
    public final String getQrCode() {
        return this.qrCode;
    }

    public int hashCode() {
        return (((((((((((((((this.goodsName.hashCode() * 31) + this.goodsNo.hashCode()) * 31) + this.minSkuPrice.hashCode()) * 31) + this.maxSkuPrice.hashCode()) * 31) + this.outPrice.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.qrCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "PosterDetailBean(goodsName=" + this.goodsName + ", goodsNo=" + this.goodsNo + ", minSkuPrice=" + this.minSkuPrice + ", maxSkuPrice=" + this.maxSkuPrice + ", outPrice=" + this.outPrice + ", imageUrl=" + this.imageUrl + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", qrCode=" + this.qrCode + ')';
    }

    public /* synthetic */ PosterDetailBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) == 0 ? str9 : "");
    }
}
