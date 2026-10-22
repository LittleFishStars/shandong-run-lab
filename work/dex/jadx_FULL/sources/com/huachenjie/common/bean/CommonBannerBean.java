package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006!"}, d2 = {"Lcom/huachenjie/common/bean/CommonBannerBean;", "", "url", "", "width", "", "height", "delFlag", "", "ratio", "", "(Ljava/lang/String;IIZF)V", "getDelFlag", "()Z", "getHeight", "()I", "getRatio", "()F", "setRatio", "(F)V", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommonBannerBean {
    private final boolean delFlag;
    private final int height;
    private float ratio;

    @NotNull
    private final String url;
    private final int width;

    public CommonBannerBean() {
        this(null, 0, 0, false, 0.0f, 31, null);
    }

    public CommonBannerBean(@NotNull String str, int i, int i2, boolean z, float f) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.width = i;
        this.height = i2;
        this.delFlag = z;
        this.ratio = f;
    }

    public static /* synthetic */ CommonBannerBean copy$default(CommonBannerBean commonBannerBean, String str, int i, int i2, boolean z, float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = commonBannerBean.url;
        }
        if ((i3 & 2) != 0) {
            i = commonBannerBean.width;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = commonBannerBean.height;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            z = commonBannerBean.delFlag;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            f = commonBannerBean.ratio;
        }
        return commonBannerBean.copy(str, i4, i5, z2, f);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getDelFlag() {
        return this.delFlag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getRatio() {
        return this.ratio;
    }

    @NotNull
    public final CommonBannerBean copy(@NotNull String url, int width, int height, boolean delFlag, float ratio) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new CommonBannerBean(url, width, height, delFlag, ratio);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonBannerBean)) {
            return false;
        }
        CommonBannerBean commonBannerBean = (CommonBannerBean) other;
        return Intrinsics.areEqual(this.url, commonBannerBean.url) && this.width == commonBannerBean.width && this.height == commonBannerBean.height && this.delFlag == commonBannerBean.delFlag && Float.compare(this.ratio, commonBannerBean.ratio) == 0;
    }

    public final boolean getDelFlag() {
        return this.delFlag;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getRatio() {
        return this.ratio;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((((this.url.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31;
        boolean z = this.delFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + Float.hashCode(this.ratio);
    }

    public final void setRatio(float f) {
        this.ratio = f;
    }

    @NotNull
    public String toString() {
        return "CommonBannerBean(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", delFlag=" + this.delFlag + ", ratio=" + this.ratio + ")";
    }

    public /* synthetic */ CommonBannerBean(String str, int i, int i2, boolean z, float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) == 0 ? z : false, (i3 & 16) != 0 ? 0.0f : f);
    }
}
