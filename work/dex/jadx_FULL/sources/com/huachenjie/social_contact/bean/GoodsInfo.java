package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/social_contact/bean/GoodsInfo;", "", "goodsName", "", "goodsAmount", "", "starDrill", "", "appleId", "productId", "(Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;)V", "getAppleId", "()Ljava/lang/String;", "getGoodsAmount", "()F", "getGoodsName", "getProductId", "getStarDrill", "()I", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsInfo {

    @NotNull
    private final String appleId;
    private final float goodsAmount;

    @NotNull
    private final String goodsName;

    @NotNull
    private final String productId;
    private final int starDrill;

    public GoodsInfo() {
        this(null, 0.0f, 0, null, null, 31, null);
    }

    public GoodsInfo(@NotNull String str, float f, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "goodsName");
        Intrinsics.checkNotNullParameter(str2, "appleId");
        Intrinsics.checkNotNullParameter(str3, "productId");
        this.goodsName = str;
        this.goodsAmount = f;
        this.starDrill = i;
        this.appleId = str2;
        this.productId = str3;
    }

    public static /* synthetic */ GoodsInfo copy$default(GoodsInfo goodsInfo, String str, float f, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = goodsInfo.goodsName;
        }
        if ((i2 & 2) != 0) {
            f = goodsInfo.goodsAmount;
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            i = goodsInfo.starDrill;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = goodsInfo.appleId;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = goodsInfo.productId;
        }
        return goodsInfo.copy(str, f2, i3, str4, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getGoodsAmount() {
        return this.goodsAmount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppleId() {
        return this.appleId;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @NotNull
    public final GoodsInfo copy(@NotNull String goodsName, float goodsAmount, int starDrill, @NotNull String appleId, @NotNull String productId) {
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(appleId, "appleId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        return new GoodsInfo(goodsName, goodsAmount, starDrill, appleId, productId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsInfo)) {
            return false;
        }
        GoodsInfo goodsInfo = (GoodsInfo) other;
        return Intrinsics.areEqual(this.goodsName, goodsInfo.goodsName) && Float.compare(this.goodsAmount, goodsInfo.goodsAmount) == 0 && this.starDrill == goodsInfo.starDrill && Intrinsics.areEqual(this.appleId, goodsInfo.appleId) && Intrinsics.areEqual(this.productId, goodsInfo.productId);
    }

    @NotNull
    public final String getAppleId() {
        return this.appleId;
    }

    public final float getGoodsAmount() {
        return this.goodsAmount;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    public int hashCode() {
        return (((((((this.goodsName.hashCode() * 31) + Float.hashCode(this.goodsAmount)) * 31) + Integer.hashCode(this.starDrill)) * 31) + this.appleId.hashCode()) * 31) + this.productId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsInfo(goodsName=" + this.goodsName + ", goodsAmount=" + this.goodsAmount + ", starDrill=" + this.starDrill + ", appleId=" + this.appleId + ", productId=" + this.productId + ')';
    }

    public /* synthetic */ GoodsInfo(String str, float f, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3);
    }
}
