package com.huachenjie.home.bean.reward;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/home/bean/reward/LotteryThemeConfig;", "", "themeDesc", "", "logoUrl", "themeName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogoUrl", "()Ljava/lang/String;", "getThemeDesc", "getThemeName", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LotteryThemeConfig {

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String themeDesc;

    @NotNull
    private final String themeName;

    public LotteryThemeConfig() {
        this(null, null, null, 7, null);
    }

    public LotteryThemeConfig(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "themeDesc");
        Intrinsics.checkNotNullParameter(str2, "logoUrl");
        Intrinsics.checkNotNullParameter(str3, "themeName");
        this.themeDesc = str;
        this.logoUrl = str2;
        this.themeName = str3;
    }

    public static /* synthetic */ LotteryThemeConfig copy$default(LotteryThemeConfig lotteryThemeConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lotteryThemeConfig.themeDesc;
        }
        if ((i & 2) != 0) {
            str2 = lotteryThemeConfig.logoUrl;
        }
        if ((i & 4) != 0) {
            str3 = lotteryThemeConfig.themeName;
        }
        return lotteryThemeConfig.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemeDesc() {
        return this.themeDesc;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThemeName() {
        return this.themeName;
    }

    @NotNull
    public final LotteryThemeConfig copy(@NotNull String themeDesc, @NotNull String logoUrl, @NotNull String themeName) {
        Intrinsics.checkNotNullParameter(themeDesc, "themeDesc");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(themeName, "themeName");
        return new LotteryThemeConfig(themeDesc, logoUrl, themeName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LotteryThemeConfig)) {
            return false;
        }
        LotteryThemeConfig lotteryThemeConfig = (LotteryThemeConfig) other;
        return Intrinsics.areEqual(this.themeDesc, lotteryThemeConfig.themeDesc) && Intrinsics.areEqual(this.logoUrl, lotteryThemeConfig.logoUrl) && Intrinsics.areEqual(this.themeName, lotteryThemeConfig.themeName);
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getThemeDesc() {
        return this.themeDesc;
    }

    @NotNull
    public final String getThemeName() {
        return this.themeName;
    }

    public int hashCode() {
        return (((this.themeDesc.hashCode() * 31) + this.logoUrl.hashCode()) * 31) + this.themeName.hashCode();
    }

    @NotNull
    public String toString() {
        return "LotteryThemeConfig(themeDesc=" + this.themeDesc + ", logoUrl=" + this.logoUrl + ", themeName=" + this.themeName + ')';
    }

    public /* synthetic */ LotteryThemeConfig(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
