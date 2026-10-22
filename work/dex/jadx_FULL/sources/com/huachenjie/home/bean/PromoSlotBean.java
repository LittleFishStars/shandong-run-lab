package com.huachenjie.home.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006."}, d2 = {"Lcom/huachenjie/home/bean/PromoSlotBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "position", "", "titleType", "", "titleContent", "imageUrl", "price", UserTrackConstant.JUMP_TYPE, "jumpUrl", "flashPrice", "reducePrice", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFlashPrice", "()Ljava/lang/String;", "getImageUrl", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getJumpType", "getJumpUrl", "getPosition", "getPrice", "getReducePrice", "getTitleContent", "getTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "", "findBargainPrice", "findDeduction", "findPrice", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PromoSlotBean implements MultiItemEntity {

    @NotNull
    private final String flashPrice;

    @NotNull
    private final String imageUrl;
    private final int jumpType;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String position;

    @NotNull
    private final String price;

    @NotNull
    private final String reducePrice;

    @NotNull
    private final String titleContent;
    private final int titleType;

    public PromoSlotBean() {
        this(null, 0, null, null, null, 0, null, null, null, 511, null);
    }

    public PromoSlotBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "position");
        Intrinsics.checkNotNullParameter(str2, "titleContent");
        Intrinsics.checkNotNullParameter(str3, "imageUrl");
        Intrinsics.checkNotNullParameter(str4, "price");
        Intrinsics.checkNotNullParameter(str5, "jumpUrl");
        Intrinsics.checkNotNullParameter(str6, "flashPrice");
        Intrinsics.checkNotNullParameter(str7, "reducePrice");
        this.position = str;
        this.titleType = i;
        this.titleContent = str2;
        this.imageUrl = str3;
        this.price = str4;
        this.jumpType = i2;
        this.jumpUrl = str5;
        this.flashPrice = str6;
        this.reducePrice = str7;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitleType() {
        return this.titleType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitleContent() {
        return this.titleContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFlashPrice() {
        return this.flashPrice;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReducePrice() {
        return this.reducePrice;
    }

    @NotNull
    public final PromoSlotBean copy(@NotNull String position, int titleType, @NotNull String titleContent, @NotNull String imageUrl, @NotNull String price, int jumpType, @NotNull String jumpUrl, @NotNull String flashPrice, @NotNull String reducePrice) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(titleContent, "titleContent");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(flashPrice, "flashPrice");
        Intrinsics.checkNotNullParameter(reducePrice, "reducePrice");
        return new PromoSlotBean(position, titleType, titleContent, imageUrl, price, jumpType, jumpUrl, flashPrice, reducePrice);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromoSlotBean)) {
            return false;
        }
        PromoSlotBean promoSlotBean = (PromoSlotBean) other;
        return Intrinsics.areEqual(this.position, promoSlotBean.position) && this.titleType == promoSlotBean.titleType && Intrinsics.areEqual(this.titleContent, promoSlotBean.titleContent) && Intrinsics.areEqual(this.imageUrl, promoSlotBean.imageUrl) && Intrinsics.areEqual(this.price, promoSlotBean.price) && this.jumpType == promoSlotBean.jumpType && Intrinsics.areEqual(this.jumpUrl, promoSlotBean.jumpUrl) && Intrinsics.areEqual(this.flashPrice, promoSlotBean.flashPrice) && Intrinsics.areEqual(this.reducePrice, promoSlotBean.reducePrice);
    }

    @NotNull
    public final String findBargainPrice() {
        return "闪金币特价¥" + this.flashPrice;
    }

    @NotNull
    public final String findDeduction() {
        return "可抵¥" + this.reducePrice;
    }

    @NotNull
    public final String findPrice() {
        return (char) 165 + this.price;
    }

    @NotNull
    public final String getFlashPrice() {
        return this.flashPrice;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.jumpType;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getPosition() {
        return this.position;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getReducePrice() {
        return this.reducePrice;
    }

    @NotNull
    public final String getTitleContent() {
        return this.titleContent;
    }

    public final int getTitleType() {
        return this.titleType;
    }

    public int hashCode() {
        return (((((((((((((((this.position.hashCode() * 31) + Integer.hashCode(this.titleType)) * 31) + this.titleContent.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.jumpType)) * 31) + this.jumpUrl.hashCode()) * 31) + this.flashPrice.hashCode()) * 31) + this.reducePrice.hashCode();
    }

    @NotNull
    public String toString() {
        return "PromoSlotBean(position=" + this.position + ", titleType=" + this.titleType + ", titleContent=" + this.titleContent + ", imageUrl=" + this.imageUrl + ", price=" + this.price + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", flashPrice=" + this.flashPrice + ", reducePrice=" + this.reducePrice + ')';
    }

    public /* synthetic */ PromoSlotBean(String str, int i, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) == 0 ? str7 : "");
    }
}
