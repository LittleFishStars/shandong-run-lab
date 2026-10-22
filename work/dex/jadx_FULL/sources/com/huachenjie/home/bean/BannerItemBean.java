package com.huachenjie.home.bean;

import com.czhj.sdk.common.Constants;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/home/bean/BannerItemBean;", "", "imageUrl", "", Constants.CLICK_TYPE, "", "clickTarget", "(Ljava/lang/String;ILjava/lang/String;)V", "getClickTarget", "()Ljava/lang/String;", "getClickType", "()I", "getImageUrl", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BannerItemBean {

    @NotNull
    private final String clickTarget;
    private final int clickType;

    @NotNull
    private final String imageUrl;

    public BannerItemBean() {
        this(null, 0, null, 7, null);
    }

    public BannerItemBean(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "clickTarget");
        this.imageUrl = str;
        this.clickType = i;
        this.clickTarget = str2;
    }

    public static /* synthetic */ BannerItemBean copy$default(BannerItemBean bannerItemBean, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bannerItemBean.imageUrl;
        }
        if ((i2 & 2) != 0) {
            i = bannerItemBean.clickType;
        }
        if ((i2 & 4) != 0) {
            str2 = bannerItemBean.clickTarget;
        }
        return bannerItemBean.copy(str, i, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getClickType() {
        return this.clickType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getClickTarget() {
        return this.clickTarget;
    }

    @NotNull
    public final BannerItemBean copy(@NotNull String imageUrl, int clickType, @NotNull String clickTarget) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        return new BannerItemBean(imageUrl, clickType, clickTarget);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerItemBean)) {
            return false;
        }
        BannerItemBean bannerItemBean = (BannerItemBean) other;
        return Intrinsics.areEqual(this.imageUrl, bannerItemBean.imageUrl) && this.clickType == bannerItemBean.clickType && Intrinsics.areEqual(this.clickTarget, bannerItemBean.clickTarget);
    }

    @NotNull
    public final String getClickTarget() {
        return this.clickTarget;
    }

    public final int getClickType() {
        return this.clickType;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        return (((this.imageUrl.hashCode() * 31) + Integer.hashCode(this.clickType)) * 31) + this.clickTarget.hashCode();
    }

    @NotNull
    public String toString() {
        return "BannerItemBean(imageUrl=" + this.imageUrl + ", clickType=" + this.clickType + ", clickTarget=" + this.clickTarget + ')';
    }

    public /* synthetic */ BannerItemBean(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }
}
