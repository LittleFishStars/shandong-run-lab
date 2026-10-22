package com.huachenjie.home.bean;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u0007J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/huachenjie/home/bean/HomeHeaderBean;", "", "name", "", "iconUrl", "badge", "isShow", "", UserTrackConstant.JUMP_TYPE, "", "jumpUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)V", "getBadge", "()Ljava/lang/String;", "getIconUrl", "()Z", "getJumpType", "()I", "getJumpUrl", "getName", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "showBadge", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HomeHeaderBean {

    @NotNull
    private final String badge;

    @NotNull
    private final String iconUrl;
    private final boolean isShow;
    private final int jumpType;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String name;

    public HomeHeaderBean() {
        this(null, null, null, false, 0, null, 63, null);
    }

    public HomeHeaderBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, int i, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "badge");
        Intrinsics.checkNotNullParameter(str4, "jumpUrl");
        this.name = str;
        this.iconUrl = str2;
        this.badge = str3;
        this.isShow = z;
        this.jumpType = i;
        this.jumpUrl = str4;
    }

    public static /* synthetic */ HomeHeaderBean copy$default(HomeHeaderBean homeHeaderBean, String str, String str2, String str3, boolean z, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = homeHeaderBean.name;
        }
        if ((i2 & 2) != 0) {
            str2 = homeHeaderBean.iconUrl;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = homeHeaderBean.badge;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            z = homeHeaderBean.isShow;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            i = homeHeaderBean.jumpType;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str4 = homeHeaderBean.jumpUrl;
        }
        return homeHeaderBean.copy(str, str5, str6, z2, i3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBadge() {
        return this.badge;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final HomeHeaderBean copy(@NotNull String name, @NotNull String iconUrl, @NotNull String badge, boolean isShow, int jumpType, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new HomeHeaderBean(name, iconUrl, badge, isShow, jumpType, jumpUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeHeaderBean)) {
            return false;
        }
        HomeHeaderBean homeHeaderBean = (HomeHeaderBean) other;
        return Intrinsics.areEqual(this.name, homeHeaderBean.name) && Intrinsics.areEqual(this.iconUrl, homeHeaderBean.iconUrl) && Intrinsics.areEqual(this.badge, homeHeaderBean.badge) && this.isShow == homeHeaderBean.isShow && this.jumpType == homeHeaderBean.jumpType && Intrinsics.areEqual(this.jumpUrl, homeHeaderBean.jumpUrl);
    }

    @NotNull
    public final String getBadge() {
        return this.badge;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.badge.hashCode()) * 31;
        boolean z = this.isShow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + Integer.hashCode(this.jumpType)) * 31) + this.jumpUrl.hashCode();
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final boolean showBadge() {
        return !TextUtils.isEmpty(this.badge);
    }

    @NotNull
    public String toString() {
        return "HomeHeaderBean(name=" + this.name + ", iconUrl=" + this.iconUrl + ", badge=" + this.badge + ", isShow=" + this.isShow + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ')';
    }

    public /* synthetic */ HomeHeaderBean(String str, String str2, String str3, boolean z, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str4);
    }
}
