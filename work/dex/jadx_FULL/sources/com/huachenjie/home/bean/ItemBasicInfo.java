package com.huachenjie.home.bean;

import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J¹\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006A"}, d2 = {"Lcom/huachenjie/home/bean/ItemBasicInfo;", "", "title", "", "shortTitle", "pictUrl", "whiteImage", "levelOneCategoryId", "levelOneCategoryName", "categoryId", "categoryName", "sellerId", "userType", "shopTitle", "volume", RVParams.LONG_SUB_TITLE, "brandName", "annualVol", "smallImages", "", "realPostFee", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAnnualVol", "()Ljava/lang/String;", "getBrandName", "getCategoryId", "getCategoryName", "getLevelOneCategoryId", "getLevelOneCategoryName", "getPictUrl", "getRealPostFee", "getSellerId", "getShopTitle", "getShortTitle", "getSmallImages", "()Ljava/util/List;", "getSubTitle", "getTitle", "getUserType", "getVolume", "getWhiteImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ItemBasicInfo {

    @NotNull
    private final String annualVol;

    @NotNull
    private final String brandName;

    @NotNull
    private final String categoryId;

    @NotNull
    private final String categoryName;

    @NotNull
    private final String levelOneCategoryId;

    @NotNull
    private final String levelOneCategoryName;

    @NotNull
    private final String pictUrl;

    @NotNull
    private final String realPostFee;

    @NotNull
    private final String sellerId;

    @NotNull
    private final String shopTitle;

    @NotNull
    private final String shortTitle;

    @NotNull
    private final List<String> smallImages;

    @NotNull
    private final String subTitle;

    @NotNull
    private final String title;

    @NotNull
    private final String userType;

    @NotNull
    private final String volume;

    @NotNull
    private final String whiteImage;

    public ItemBasicInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public ItemBasicInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull List<String> list, @NotNull String str16) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortTitle");
        Intrinsics.checkNotNullParameter(str3, "pictUrl");
        Intrinsics.checkNotNullParameter(str4, "whiteImage");
        Intrinsics.checkNotNullParameter(str5, "levelOneCategoryId");
        Intrinsics.checkNotNullParameter(str6, "levelOneCategoryName");
        Intrinsics.checkNotNullParameter(str7, "categoryId");
        Intrinsics.checkNotNullParameter(str8, "categoryName");
        Intrinsics.checkNotNullParameter(str9, "sellerId");
        Intrinsics.checkNotNullParameter(str10, "userType");
        Intrinsics.checkNotNullParameter(str11, "shopTitle");
        Intrinsics.checkNotNullParameter(str12, "volume");
        Intrinsics.checkNotNullParameter(str13, RVParams.LONG_SUB_TITLE);
        Intrinsics.checkNotNullParameter(str14, "brandName");
        Intrinsics.checkNotNullParameter(str15, "annualVol");
        Intrinsics.checkNotNullParameter(list, "smallImages");
        Intrinsics.checkNotNullParameter(str16, "realPostFee");
        this.title = str;
        this.shortTitle = str2;
        this.pictUrl = str3;
        this.whiteImage = str4;
        this.levelOneCategoryId = str5;
        this.levelOneCategoryName = str6;
        this.categoryId = str7;
        this.categoryName = str8;
        this.sellerId = str9;
        this.userType = str10;
        this.shopTitle = str11;
        this.volume = str12;
        this.subTitle = str13;
        this.brandName = str14;
        this.annualVol = str15;
        this.smallImages = list;
        this.realPostFee = str16;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getUserType() {
        return this.userType;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getShopTitle() {
        return this.shopTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVolume() {
        return this.volume;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAnnualVol() {
        return this.annualVol;
    }

    @NotNull
    public final List<String> component16() {
        return this.smallImages;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRealPostFee() {
        return this.realPostFee;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShortTitle() {
        return this.shortTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPictUrl() {
        return this.pictUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWhiteImage() {
        return this.whiteImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLevelOneCategoryId() {
        return this.levelOneCategoryId;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLevelOneCategoryName() {
        return this.levelOneCategoryName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSellerId() {
        return this.sellerId;
    }

    @NotNull
    public final ItemBasicInfo copy(@NotNull String title, @NotNull String shortTitle, @NotNull String pictUrl, @NotNull String whiteImage, @NotNull String levelOneCategoryId, @NotNull String levelOneCategoryName, @NotNull String categoryId, @NotNull String categoryName, @NotNull String sellerId, @NotNull String userType, @NotNull String shopTitle, @NotNull String volume, @NotNull String subTitle, @NotNull String brandName, @NotNull String annualVol, @NotNull List<String> smallImages, @NotNull String realPostFee) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shortTitle, "shortTitle");
        Intrinsics.checkNotNullParameter(pictUrl, "pictUrl");
        Intrinsics.checkNotNullParameter(whiteImage, "whiteImage");
        Intrinsics.checkNotNullParameter(levelOneCategoryId, "levelOneCategoryId");
        Intrinsics.checkNotNullParameter(levelOneCategoryName, "levelOneCategoryName");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(sellerId, "sellerId");
        Intrinsics.checkNotNullParameter(userType, "userType");
        Intrinsics.checkNotNullParameter(shopTitle, "shopTitle");
        Intrinsics.checkNotNullParameter(volume, "volume");
        Intrinsics.checkNotNullParameter(subTitle, RVParams.LONG_SUB_TITLE);
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(annualVol, "annualVol");
        Intrinsics.checkNotNullParameter(smallImages, "smallImages");
        Intrinsics.checkNotNullParameter(realPostFee, "realPostFee");
        return new ItemBasicInfo(title, shortTitle, pictUrl, whiteImage, levelOneCategoryId, levelOneCategoryName, categoryId, categoryName, sellerId, userType, shopTitle, volume, subTitle, brandName, annualVol, smallImages, realPostFee);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemBasicInfo)) {
            return false;
        }
        ItemBasicInfo itemBasicInfo = (ItemBasicInfo) other;
        return Intrinsics.areEqual(this.title, itemBasicInfo.title) && Intrinsics.areEqual(this.shortTitle, itemBasicInfo.shortTitle) && Intrinsics.areEqual(this.pictUrl, itemBasicInfo.pictUrl) && Intrinsics.areEqual(this.whiteImage, itemBasicInfo.whiteImage) && Intrinsics.areEqual(this.levelOneCategoryId, itemBasicInfo.levelOneCategoryId) && Intrinsics.areEqual(this.levelOneCategoryName, itemBasicInfo.levelOneCategoryName) && Intrinsics.areEqual(this.categoryId, itemBasicInfo.categoryId) && Intrinsics.areEqual(this.categoryName, itemBasicInfo.categoryName) && Intrinsics.areEqual(this.sellerId, itemBasicInfo.sellerId) && Intrinsics.areEqual(this.userType, itemBasicInfo.userType) && Intrinsics.areEqual(this.shopTitle, itemBasicInfo.shopTitle) && Intrinsics.areEqual(this.volume, itemBasicInfo.volume) && Intrinsics.areEqual(this.subTitle, itemBasicInfo.subTitle) && Intrinsics.areEqual(this.brandName, itemBasicInfo.brandName) && Intrinsics.areEqual(this.annualVol, itemBasicInfo.annualVol) && Intrinsics.areEqual(this.smallImages, itemBasicInfo.smallImages) && Intrinsics.areEqual(this.realPostFee, itemBasicInfo.realPostFee);
    }

    @NotNull
    public final String getAnnualVol() {
        return this.annualVol;
    }

    @NotNull
    public final String getBrandName() {
        return this.brandName;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getLevelOneCategoryId() {
        return this.levelOneCategoryId;
    }

    @NotNull
    public final String getLevelOneCategoryName() {
        return this.levelOneCategoryName;
    }

    @NotNull
    public final String getPictUrl() {
        return this.pictUrl;
    }

    @NotNull
    public final String getRealPostFee() {
        return this.realPostFee;
    }

    @NotNull
    public final String getSellerId() {
        return this.sellerId;
    }

    @NotNull
    public final String getShopTitle() {
        return this.shopTitle;
    }

    @NotNull
    public final String getShortTitle() {
        return this.shortTitle;
    }

    @NotNull
    public final List<String> getSmallImages() {
        return this.smallImages;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    @NotNull
    public final String getVolume() {
        return this.volume;
    }

    @NotNull
    public final String getWhiteImage() {
        return this.whiteImage;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.title.hashCode() * 31) + this.shortTitle.hashCode()) * 31) + this.pictUrl.hashCode()) * 31) + this.whiteImage.hashCode()) * 31) + this.levelOneCategoryId.hashCode()) * 31) + this.levelOneCategoryName.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + this.categoryName.hashCode()) * 31) + this.sellerId.hashCode()) * 31) + this.userType.hashCode()) * 31) + this.shopTitle.hashCode()) * 31) + this.volume.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.brandName.hashCode()) * 31) + this.annualVol.hashCode()) * 31) + this.smallImages.hashCode()) * 31) + this.realPostFee.hashCode();
    }

    @NotNull
    public String toString() {
        return "ItemBasicInfo(title=" + this.title + ", shortTitle=" + this.shortTitle + ", pictUrl=" + this.pictUrl + ", whiteImage=" + this.whiteImage + ", levelOneCategoryId=" + this.levelOneCategoryId + ", levelOneCategoryName=" + this.levelOneCategoryName + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", sellerId=" + this.sellerId + ", userType=" + this.userType + ", shopTitle=" + this.shopTitle + ", volume=" + this.volume + ", subTitle=" + this.subTitle + ", brandName=" + this.brandName + ", annualVol=" + this.annualVol + ", smallImages=" + this.smallImages + ", realPostFee=" + this.realPostFee + ')';
    }

    public /* synthetic */ ItemBasicInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, List list, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) != 0 ? "" : str15, (i & 32768) != 0 ? new ArrayList() : list, (i & 65536) != 0 ? "" : str16);
    }
}
