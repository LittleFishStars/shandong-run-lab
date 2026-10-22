package com.huachenjie.college.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/college/bean/CollegeTownBannerBean;", "", "bizName", "", "coverImg", "relationUrl", UserTrackConstant.JUMP_TYPE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBizName", "()Ljava/lang/String;", "getCoverImg", "getJumpType", "()I", "getRelationUrl", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollegeTownBannerBean {

    @NotNull
    private final String bizName;

    @NotNull
    private final String coverImg;
    private final int jumpType;

    @NotNull
    private final String relationUrl;

    public CollegeTownBannerBean() {
        this(null, null, null, 0, 15, null);
    }

    public CollegeTownBannerBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "bizName");
        Intrinsics.checkNotNullParameter(str2, "coverImg");
        Intrinsics.checkNotNullParameter(str3, "relationUrl");
        this.bizName = str;
        this.coverImg = str2;
        this.relationUrl = str3;
        this.jumpType = i;
    }

    public static /* synthetic */ CollegeTownBannerBean copy$default(CollegeTownBannerBean collegeTownBannerBean, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = collegeTownBannerBean.bizName;
        }
        if ((i2 & 2) != 0) {
            str2 = collegeTownBannerBean.coverImg;
        }
        if ((i2 & 4) != 0) {
            str3 = collegeTownBannerBean.relationUrl;
        }
        if ((i2 & 8) != 0) {
            i = collegeTownBannerBean.jumpType;
        }
        return collegeTownBannerBean.copy(str, str2, str3, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBizName() {
        return this.bizName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRelationUrl() {
        return this.relationUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final CollegeTownBannerBean copy(@NotNull String bizName, @NotNull String coverImg, @NotNull String relationUrl, int jumpType) {
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(relationUrl, "relationUrl");
        return new CollegeTownBannerBean(bizName, coverImg, relationUrl, jumpType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollegeTownBannerBean)) {
            return false;
        }
        CollegeTownBannerBean collegeTownBannerBean = (CollegeTownBannerBean) other;
        return Intrinsics.areEqual(this.bizName, collegeTownBannerBean.bizName) && Intrinsics.areEqual(this.coverImg, collegeTownBannerBean.coverImg) && Intrinsics.areEqual(this.relationUrl, collegeTownBannerBean.relationUrl) && this.jumpType == collegeTownBannerBean.jumpType;
    }

    @NotNull
    public final String getBizName() {
        return this.bizName;
    }

    @NotNull
    public final String getCoverImg() {
        return this.coverImg;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getRelationUrl() {
        return this.relationUrl;
    }

    public int hashCode() {
        return (((((this.bizName.hashCode() * 31) + this.coverImg.hashCode()) * 31) + this.relationUrl.hashCode()) * 31) + Integer.hashCode(this.jumpType);
    }

    @NotNull
    public String toString() {
        return "CollegeTownBannerBean(bizName=" + this.bizName + ", coverImg=" + this.coverImg + ", relationUrl=" + this.relationUrl + ", jumpType=" + this.jumpType + ')';
    }

    public /* synthetic */ CollegeTownBannerBean(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }
}
