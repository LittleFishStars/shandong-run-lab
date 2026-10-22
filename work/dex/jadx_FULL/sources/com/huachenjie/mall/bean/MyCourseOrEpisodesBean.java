package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.R;
import com.huachenjie.run.map.RouteOverlay;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/huachenjie/mall/bean/MyCourseOrEpisodesBean;", "", "orderItemNo", "", "goodsNo", "skuNo", "episodeName", "goodsImage", "progressRate", "", "lastPlaySort", "status", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V", "getEpisodeName", "()Ljava/lang/String;", "getGoodsImage", "getGoodsNo", "getLastPlaySort", "()I", "getOrderItemNo", "getProgressRate", "getSkuNo", "getStatus", "getType", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "formatterColor", "formatterStatus", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyCourseOrEpisodesBean {

    @NotNull
    private final String episodeName;

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsNo;
    private final int lastPlaySort;

    @NotNull
    private final String orderItemNo;
    private final int progressRate;

    @NotNull
    private final String skuNo;
    private final int status;
    private int type;

    public MyCourseOrEpisodesBean() {
        this(null, null, null, null, null, 0, 0, 0, 0, 511, null);
    }

    public MyCourseOrEpisodesBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "orderItemNo");
        Intrinsics.checkNotNullParameter(str2, "goodsNo");
        Intrinsics.checkNotNullParameter(str3, "skuNo");
        Intrinsics.checkNotNullParameter(str4, "episodeName");
        Intrinsics.checkNotNullParameter(str5, "goodsImage");
        this.orderItemNo = str;
        this.goodsNo = str2;
        this.skuNo = str3;
        this.episodeName = str4;
        this.goodsImage = str5;
        this.progressRate = i;
        this.lastPlaySort = i2;
        this.status = i3;
        this.type = i4;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSkuNo() {
        return this.skuNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEpisodeName() {
        return this.episodeName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getProgressRate() {
        return this.progressRate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getLastPlaySort() {
        return this.lastPlaySort;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final MyCourseOrEpisodesBean copy(@NotNull String orderItemNo, @NotNull String goodsNo, @NotNull String skuNo, @NotNull String episodeName, @NotNull String goodsImage, int progressRate, int lastPlaySort, int status, int type) {
        Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(skuNo, "skuNo");
        Intrinsics.checkNotNullParameter(episodeName, "episodeName");
        Intrinsics.checkNotNullParameter(goodsImage, "goodsImage");
        return new MyCourseOrEpisodesBean(orderItemNo, goodsNo, skuNo, episodeName, goodsImage, progressRate, lastPlaySort, status, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyCourseOrEpisodesBean)) {
            return false;
        }
        MyCourseOrEpisodesBean myCourseOrEpisodesBean = (MyCourseOrEpisodesBean) other;
        return Intrinsics.areEqual(this.orderItemNo, myCourseOrEpisodesBean.orderItemNo) && Intrinsics.areEqual(this.goodsNo, myCourseOrEpisodesBean.goodsNo) && Intrinsics.areEqual(this.skuNo, myCourseOrEpisodesBean.skuNo) && Intrinsics.areEqual(this.episodeName, myCourseOrEpisodesBean.episodeName) && Intrinsics.areEqual(this.goodsImage, myCourseOrEpisodesBean.goodsImage) && this.progressRate == myCourseOrEpisodesBean.progressRate && this.lastPlaySort == myCourseOrEpisodesBean.lastPlaySort && this.status == myCourseOrEpisodesBean.status && this.type == myCourseOrEpisodesBean.type;
    }

    @NotNull
    public final String formatterColor() {
        int i = this.status;
        if (i != 0) {
            return i != 2 ? RouteOverlay.f12338c : "#2C3E50";
        }
        return "#C1C1C1";
    }

    @NotNull
    public final String formatterStatus() {
        if (this.type == 0) {
            int i = this.status;
            if (i == 0) {
                String strE = ys8.e(R.string.mall_video_enter_status0);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.mall_video_enter_status0)");
                return strE;
            }
            if (i == 1) {
                String strF = ys8.f(R.string.mall_video_enter_status1, Integer.valueOf(this.progressRate));
                Intrinsics.checkNotNullExpressionValue(strF, "getString(R.string.mall_…er_status1, progressRate)");
                return strF;
            }
            if (i != 2) {
                return "";
            }
            String strE2 = ys8.e(R.string.mall_video_enter_status2);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.mall_video_enter_status2)");
            return strE2;
        }
        int i2 = this.status;
        if (i2 == 0) {
            String strE3 = ys8.e(R.string.mall_video_enter_episode_status0);
            Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.mall_…eo_enter_episode_status0)");
            return strE3;
        }
        if (i2 == 1) {
            String strF2 = ys8.f(R.string.mall_video_enter_episode_status1, Integer.valueOf(this.lastPlaySort), Integer.valueOf(this.progressRate));
            Intrinsics.checkNotNullExpressionValue(strF2, "getString(\n             …essRate\n                )");
            return strF2;
        }
        if (i2 != 2) {
            return "";
        }
        String strE4 = ys8.e(R.string.mall_video_enter_episode_status2);
        Intrinsics.checkNotNullExpressionValue(strE4, "getString(R.string.mall_…eo_enter_episode_status2)");
        return strE4;
    }

    @NotNull
    public final String getEpisodeName() {
        return this.episodeName;
    }

    @NotNull
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    public final int getLastPlaySort() {
        return this.lastPlaySort;
    }

    @NotNull
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    public final int getProgressRate() {
        return this.progressRate;
    }

    @NotNull
    public final String getSkuNo() {
        return this.skuNo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((((this.orderItemNo.hashCode() * 31) + this.goodsNo.hashCode()) * 31) + this.skuNo.hashCode()) * 31) + this.episodeName.hashCode()) * 31) + this.goodsImage.hashCode()) * 31) + Integer.hashCode(this.progressRate)) * 31) + Integer.hashCode(this.lastPlaySort)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.type);
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "MyCourseOrEpisodesBean(orderItemNo=" + this.orderItemNo + ", goodsNo=" + this.goodsNo + ", skuNo=" + this.skuNo + ", episodeName=" + this.episodeName + ", goodsImage=" + this.goodsImage + ", progressRate=" + this.progressRate + ", lastPlaySort=" + this.lastPlaySort + ", status=" + this.status + ", type=" + this.type + ')';
    }

    public /* synthetic */ MyCourseOrEpisodesBean(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? "" : str2, (i5 & 4) != 0 ? "" : str3, (i5 & 8) != 0 ? "" : str4, (i5 & 16) == 0 ? str5 : "", (i5 & 32) != 0 ? 0 : i, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? 0 : i3, (i5 & 256) == 0 ? i4 : 0);
    }
}
