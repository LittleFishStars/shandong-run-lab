package com.huachenjie.home.bean;

import com.czhj.sdk.common.Constants;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/home/bean/SeaViewBean;", "", "imageUrl", "", "bgColor", Constants.CLICK_TYPE, "", "clickTarget", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getClickTarget", "getClickType", "()I", "getImageUrl", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SeaViewBean {

    @NotNull
    private final String bgColor;

    @NotNull
    private final String clickTarget;
    private final int clickType;

    @NotNull
    private final String imageUrl;

    public SeaViewBean() {
        this(null, null, 0, null, 15, null);
    }

    public SeaViewBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "bgColor");
        Intrinsics.checkNotNullParameter(str3, "clickTarget");
        this.imageUrl = str;
        this.bgColor = str2;
        this.clickType = i;
        this.clickTarget = str3;
    }

    public static /* synthetic */ SeaViewBean copy$default(SeaViewBean seaViewBean, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = seaViewBean.imageUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = seaViewBean.bgColor;
        }
        if ((i2 & 4) != 0) {
            i = seaViewBean.clickType;
        }
        if ((i2 & 8) != 0) {
            str3 = seaViewBean.clickTarget;
        }
        return seaViewBean.copy(str, str2, i, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBgColor() {
        return this.bgColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getClickType() {
        return this.clickType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClickTarget() {
        return this.clickTarget;
    }

    @NotNull
    public final SeaViewBean copy(@NotNull String imageUrl, @NotNull String bgColor, int clickType, @NotNull String clickTarget) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        return new SeaViewBean(imageUrl, bgColor, clickType, clickTarget);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeaViewBean)) {
            return false;
        }
        SeaViewBean seaViewBean = (SeaViewBean) other;
        return Intrinsics.areEqual(this.imageUrl, seaViewBean.imageUrl) && Intrinsics.areEqual(this.bgColor, seaViewBean.bgColor) && this.clickType == seaViewBean.clickType && Intrinsics.areEqual(this.clickTarget, seaViewBean.clickTarget);
    }

    @NotNull
    public final String getBgColor() {
        return this.bgColor;
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
        return (((((this.imageUrl.hashCode() * 31) + this.bgColor.hashCode()) * 31) + Integer.hashCode(this.clickType)) * 31) + this.clickTarget.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeaViewBean(imageUrl=" + this.imageUrl + ", bgColor=" + this.bgColor + ", clickType=" + this.clickType + ", clickTarget=" + this.clickTarget + ')';
    }

    public /* synthetic */ SeaViewBean(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3);
    }
}
