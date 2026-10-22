package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.by6;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006$"}, d2 = {"Lcom/huachenjie/works/bean/RecommendGoodsBean;", "Landroid/os/Parcelable;", "goodsNo", "", "goodsName", "minSkuPrice", "imageInfo", "Lcom/huachenjie/base/bean/ImageBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/base/bean/ImageBean;)V", "getGoodsName", "()Ljava/lang/String;", "getGoodsNo", "getImageInfo", "()Lcom/huachenjie/base/bean/ImageBean;", "getMinSkuPrice", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "formatImageUrl", "formatPrice", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RecommendGoodsBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RecommendGoodsBean> CREATOR = new Creator();

    @NotNull
    private final String goodsName;

    @NotNull
    private final String goodsNo;

    @Nullable
    private final ImageBean imageInfo;

    @NotNull
    private final String minSkuPrice;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecommendGoodsBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendGoodsBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RecommendGoodsBean(parcel.readString(), parcel.readString(), parcel.readString(), (ImageBean) parcel.readParcelable(RecommendGoodsBean.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendGoodsBean[] newArray(int i) {
            return new RecommendGoodsBean[i];
        }
    }

    public RecommendGoodsBean() {
        this(null, null, null, null, 15, null);
    }

    public RecommendGoodsBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable ImageBean imageBean) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "minSkuPrice");
        this.goodsNo = str;
        this.goodsName = str2;
        this.minSkuPrice = str3;
        this.imageInfo = imageBean;
    }

    public static /* synthetic */ RecommendGoodsBean copy$default(RecommendGoodsBean recommendGoodsBean, String str, String str2, String str3, ImageBean imageBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recommendGoodsBean.goodsNo;
        }
        if ((i & 2) != 0) {
            str2 = recommendGoodsBean.goodsName;
        }
        if ((i & 4) != 0) {
            str3 = recommendGoodsBean.minSkuPrice;
        }
        if ((i & 8) != 0) {
            imageBean = recommendGoodsBean.imageInfo;
        }
        return recommendGoodsBean.copy(str, str2, str3, imageBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
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

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final RecommendGoodsBean copy(@NotNull String goodsNo, @NotNull String goodsName, @NotNull String minSkuPrice, @Nullable ImageBean imageInfo) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(minSkuPrice, "minSkuPrice");
        return new RecommendGoodsBean(goodsNo, goodsName, minSkuPrice, imageInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendGoodsBean)) {
            return false;
        }
        RecommendGoodsBean recommendGoodsBean = (RecommendGoodsBean) other;
        return Intrinsics.areEqual(this.goodsNo, recommendGoodsBean.goodsNo) && Intrinsics.areEqual(this.goodsName, recommendGoodsBean.goodsName) && Intrinsics.areEqual(this.minSkuPrice, recommendGoodsBean.minSkuPrice) && Intrinsics.areEqual(this.imageInfo, recommendGoodsBean.imageInfo);
    }

    @NotNull
    public final String formatImageUrl() {
        String url;
        ImageBean imageBean = this.imageInfo;
        return (imageBean == null || (url = imageBean.getUrl()) == null) ? "" : url;
    }

    @NotNull
    public final CharSequence formatPrice() {
        return by6.a(this.minSkuPrice, 12.0f, 18.0f);
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @Nullable
    public final ImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final String getMinSkuPrice() {
        return this.minSkuPrice;
    }

    public int hashCode() {
        int iHashCode = ((((this.goodsNo.hashCode() * 31) + this.goodsName.hashCode()) * 31) + this.minSkuPrice.hashCode()) * 31;
        ImageBean imageBean = this.imageInfo;
        return iHashCode + (imageBean == null ? 0 : imageBean.hashCode());
    }

    @NotNull
    public String toString() {
        return "RecommendGoodsBean(goodsNo=" + this.goodsNo + ", goodsName=" + this.goodsName + ", minSkuPrice=" + this.minSkuPrice + ", imageInfo=" + this.imageInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.goodsNo);
        parcel.writeString(this.goodsName);
        parcel.writeString(this.minSkuPrice);
        parcel.writeParcelable(this.imageInfo, flags);
    }

    public /* synthetic */ RecommendGoodsBean(String str, String str2, String str3, ImageBean imageBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : imageBean);
    }
}
