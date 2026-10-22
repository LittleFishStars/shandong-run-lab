package com.huachenjie.mall.bean;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/bean/MallBannerBean;", "", "picUrl", "", "bannerNo", UserTrackConstant.JUMP_TYPE, "", "jumpContent", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBannerNo", "()Ljava/lang/String;", "getJumpContent", "getJumpType", "()I", "getPicUrl", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MallBannerBean {

    @NotNull
    private final String bannerNo;

    @NotNull
    private final String jumpContent;
    private final int jumpType;

    @NotNull
    private final String picUrl;

    public MallBannerBean() {
        this(null, null, 0, null, 15, null);
    }

    public MallBannerBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "picUrl");
        Intrinsics.checkNotNullParameter(str2, "bannerNo");
        Intrinsics.checkNotNullParameter(str3, "jumpContent");
        this.picUrl = str;
        this.bannerNo = str2;
        this.jumpType = i;
        this.jumpContent = str3;
    }

    public static /* synthetic */ MallBannerBean copy$default(MallBannerBean mallBannerBean, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mallBannerBean.picUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = mallBannerBean.bannerNo;
        }
        if ((i2 & 4) != 0) {
            i = mallBannerBean.jumpType;
        }
        if ((i2 & 8) != 0) {
            str3 = mallBannerBean.jumpContent;
        }
        return mallBannerBean.copy(str, str2, i, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBannerNo() {
        return this.bannerNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getJumpContent() {
        return this.jumpContent;
    }

    @NotNull
    public final MallBannerBean copy(@NotNull String picUrl, @NotNull String bannerNo, int jumpType, @NotNull String jumpContent) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(bannerNo, "bannerNo");
        Intrinsics.checkNotNullParameter(jumpContent, "jumpContent");
        return new MallBannerBean(picUrl, bannerNo, jumpType, jumpContent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MallBannerBean)) {
            return false;
        }
        MallBannerBean mallBannerBean = (MallBannerBean) other;
        return Intrinsics.areEqual(this.picUrl, mallBannerBean.picUrl) && Intrinsics.areEqual(this.bannerNo, mallBannerBean.bannerNo) && this.jumpType == mallBannerBean.jumpType && Intrinsics.areEqual(this.jumpContent, mallBannerBean.jumpContent);
    }

    @NotNull
    public final String getBannerNo() {
        return this.bannerNo;
    }

    @NotNull
    public final String getJumpContent() {
        return this.jumpContent;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public int hashCode() {
        return (((((this.picUrl.hashCode() * 31) + this.bannerNo.hashCode()) * 31) + Integer.hashCode(this.jumpType)) * 31) + this.jumpContent.hashCode();
    }

    @NotNull
    public String toString() {
        return "MallBannerBean(picUrl=" + this.picUrl + ", bannerNo=" + this.bannerNo + ", jumpType=" + this.jumpType + ", jumpContent=" + this.jumpContent + ')';
    }

    public /* synthetic */ MallBannerBean(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3);
    }
}
