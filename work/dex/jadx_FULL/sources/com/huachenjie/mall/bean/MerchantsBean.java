package com.huachenjie.mall.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/huachenjie/mall/bean/MerchantsBean;", "", "shopNo", "", "shopUrl", "shopName", "saleCount", "score", "close", "", "accId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAccId", "()Ljava/lang/String;", "getClose", "()Z", "getSaleCount", "getScore", "getShopName", "getShopNo", "getShopUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "other", "formatSaleCount", "formatScore", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MerchantsBean {

    @NotNull
    private final String accId;
    private final boolean close;

    @NotNull
    private final String saleCount;

    @NotNull
    private final String score;

    @NotNull
    private final String shopName;

    @NotNull
    private final String shopNo;

    @NotNull
    private final String shopUrl;

    public MerchantsBean() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    public MerchantsBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "shopNo");
        Intrinsics.checkNotNullParameter(str2, "shopUrl");
        Intrinsics.checkNotNullParameter(str3, "shopName");
        Intrinsics.checkNotNullParameter(str4, "saleCount");
        Intrinsics.checkNotNullParameter(str5, "score");
        Intrinsics.checkNotNullParameter(str6, "accId");
        this.shopNo = str;
        this.shopUrl = str2;
        this.shopName = str3;
        this.saleCount = str4;
        this.score = str5;
        this.close = z;
        this.accId = str6;
    }

    public static /* synthetic */ MerchantsBean copy$default(MerchantsBean merchantsBean, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantsBean.shopNo;
        }
        if ((i & 2) != 0) {
            str2 = merchantsBean.shopUrl;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = merchantsBean.shopName;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = merchantsBean.saleCount;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = merchantsBean.score;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            z = merchantsBean.close;
        }
        boolean z2 = z;
        if ((i & 64) != 0) {
            str6 = merchantsBean.accId;
        }
        return merchantsBean.copy(str, str7, str8, str9, str10, z2, str6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getShopNo() {
        return this.shopNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShopUrl() {
        return this.shopUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getShopName() {
        return this.shopName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSaleCount() {
        return this.saleCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getClose() {
        return this.close;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAccId() {
        return this.accId;
    }

    @NotNull
    public final MerchantsBean copy(@NotNull String shopNo, @NotNull String shopUrl, @NotNull String shopName, @NotNull String saleCount, @NotNull String score, boolean close, @NotNull String accId) {
        Intrinsics.checkNotNullParameter(shopNo, "shopNo");
        Intrinsics.checkNotNullParameter(shopUrl, "shopUrl");
        Intrinsics.checkNotNullParameter(shopName, "shopName");
        Intrinsics.checkNotNullParameter(saleCount, "saleCount");
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(accId, "accId");
        return new MerchantsBean(shopNo, shopUrl, shopName, saleCount, score, close, accId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MerchantsBean)) {
            return false;
        }
        MerchantsBean merchantsBean = (MerchantsBean) other;
        return Intrinsics.areEqual(this.shopNo, merchantsBean.shopNo) && Intrinsics.areEqual(this.shopUrl, merchantsBean.shopUrl) && Intrinsics.areEqual(this.shopName, merchantsBean.shopName) && Intrinsics.areEqual(this.saleCount, merchantsBean.saleCount) && Intrinsics.areEqual(this.score, merchantsBean.score) && this.close == merchantsBean.close && Intrinsics.areEqual(this.accId, merchantsBean.accId);
    }

    @NotNull
    public final String formatSaleCount() {
        if (this.close || TextUtils.isEmpty(this.saleCount)) {
            return "销量 --";
        }
        return "销量 " + this.saleCount;
    }

    @NotNull
    public final String formatScore() {
        if (this.close || TextUtils.isEmpty(this.score)) {
            return "口碑 --";
        }
        return "口碑 " + this.score;
    }

    @NotNull
    public final String getAccId() {
        return this.accId;
    }

    public final boolean getClose() {
        return this.close;
    }

    @NotNull
    public final String getSaleCount() {
        return this.saleCount;
    }

    @NotNull
    public final String getScore() {
        return this.score;
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
    public final String getShopUrl() {
        return this.shopUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((((this.shopNo.hashCode() * 31) + this.shopUrl.hashCode()) * 31) + this.shopName.hashCode()) * 31) + this.saleCount.hashCode()) * 31) + this.score.hashCode()) * 31;
        boolean z = this.close;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.accId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MerchantsBean(shopNo=" + this.shopNo + ", shopUrl=" + this.shopUrl + ", shopName=" + this.shopName + ", saleCount=" + this.saleCount + ", score=" + this.score + ", close=" + this.close + ", accId=" + this.accId + ')';
    }

    public /* synthetic */ MerchantsBean(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? "" : str6);
    }
}
