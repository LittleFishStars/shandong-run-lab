package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u00061"}, d2 = {"Lcom/huachenjie/base/bean/ThemeConfigBean;", "Landroid/os/Parcelable;", "themeDesc", "", "logoUrl", "themeName", "badge", "pageBgUrl", "pagePromoUrl", "bottomNavText", "bottomNavImgUrl", "bottomNavUnselectedImgUrl", "lotteryDescUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBadge", "()Ljava/lang/String;", "getBottomNavImgUrl", "getBottomNavText", "getBottomNavUnselectedImgUrl", "getLogoUrl", "getLotteryDescUrl", "getPageBgUrl", "getPagePromoUrl", "getThemeDesc", "getThemeName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ThemeConfigBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ThemeConfigBean> CREATOR = new Creator();

    @NotNull
    private final String badge;

    @NotNull
    private final String bottomNavImgUrl;

    @NotNull
    private final String bottomNavText;

    @NotNull
    private final String bottomNavUnselectedImgUrl;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String lotteryDescUrl;

    @NotNull
    private final String pageBgUrl;

    @NotNull
    private final String pagePromoUrl;

    @NotNull
    private final String themeDesc;

    @NotNull
    private final String themeName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ThemeConfigBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ThemeConfigBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ThemeConfigBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ThemeConfigBean[] newArray(int i) {
            return new ThemeConfigBean[i];
        }
    }

    public ThemeConfigBean() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public ThemeConfigBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
        Intrinsics.checkNotNullParameter(str, "themeDesc");
        Intrinsics.checkNotNullParameter(str2, "logoUrl");
        Intrinsics.checkNotNullParameter(str3, "themeName");
        Intrinsics.checkNotNullParameter(str4, "badge");
        Intrinsics.checkNotNullParameter(str5, "pageBgUrl");
        Intrinsics.checkNotNullParameter(str6, "pagePromoUrl");
        Intrinsics.checkNotNullParameter(str7, "bottomNavText");
        Intrinsics.checkNotNullParameter(str8, "bottomNavImgUrl");
        Intrinsics.checkNotNullParameter(str9, "bottomNavUnselectedImgUrl");
        Intrinsics.checkNotNullParameter(str10, "lotteryDescUrl");
        this.themeDesc = str;
        this.logoUrl = str2;
        this.themeName = str3;
        this.badge = str4;
        this.pageBgUrl = str5;
        this.pagePromoUrl = str6;
        this.bottomNavText = str7;
        this.bottomNavImgUrl = str8;
        this.bottomNavUnselectedImgUrl = str9;
        this.lotteryDescUrl = str10;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemeDesc() {
        return this.themeDesc;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLotteryDescUrl() {
        return this.lotteryDescUrl;
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
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBadge() {
        return this.badge;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPageBgUrl() {
        return this.pageBgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPagePromoUrl() {
        return this.pagePromoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBottomNavText() {
        return this.bottomNavText;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBottomNavImgUrl() {
        return this.bottomNavImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBottomNavUnselectedImgUrl() {
        return this.bottomNavUnselectedImgUrl;
    }

    @NotNull
    public final ThemeConfigBean copy(@NotNull String themeDesc, @NotNull String logoUrl, @NotNull String themeName, @NotNull String badge, @NotNull String pageBgUrl, @NotNull String pagePromoUrl, @NotNull String bottomNavText, @NotNull String bottomNavImgUrl, @NotNull String bottomNavUnselectedImgUrl, @NotNull String lotteryDescUrl) {
        Intrinsics.checkNotNullParameter(themeDesc, "themeDesc");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(themeName, "themeName");
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(pageBgUrl, "pageBgUrl");
        Intrinsics.checkNotNullParameter(pagePromoUrl, "pagePromoUrl");
        Intrinsics.checkNotNullParameter(bottomNavText, "bottomNavText");
        Intrinsics.checkNotNullParameter(bottomNavImgUrl, "bottomNavImgUrl");
        Intrinsics.checkNotNullParameter(bottomNavUnselectedImgUrl, "bottomNavUnselectedImgUrl");
        Intrinsics.checkNotNullParameter(lotteryDescUrl, "lotteryDescUrl");
        return new ThemeConfigBean(themeDesc, logoUrl, themeName, badge, pageBgUrl, pagePromoUrl, bottomNavText, bottomNavImgUrl, bottomNavUnselectedImgUrl, lotteryDescUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemeConfigBean)) {
            return false;
        }
        ThemeConfigBean themeConfigBean = (ThemeConfigBean) other;
        return Intrinsics.areEqual(this.themeDesc, themeConfigBean.themeDesc) && Intrinsics.areEqual(this.logoUrl, themeConfigBean.logoUrl) && Intrinsics.areEqual(this.themeName, themeConfigBean.themeName) && Intrinsics.areEqual(this.badge, themeConfigBean.badge) && Intrinsics.areEqual(this.pageBgUrl, themeConfigBean.pageBgUrl) && Intrinsics.areEqual(this.pagePromoUrl, themeConfigBean.pagePromoUrl) && Intrinsics.areEqual(this.bottomNavText, themeConfigBean.bottomNavText) && Intrinsics.areEqual(this.bottomNavImgUrl, themeConfigBean.bottomNavImgUrl) && Intrinsics.areEqual(this.bottomNavUnselectedImgUrl, themeConfigBean.bottomNavUnselectedImgUrl) && Intrinsics.areEqual(this.lotteryDescUrl, themeConfigBean.lotteryDescUrl);
    }

    @NotNull
    public final String getBadge() {
        return this.badge;
    }

    @NotNull
    public final String getBottomNavImgUrl() {
        return this.bottomNavImgUrl;
    }

    @NotNull
    public final String getBottomNavText() {
        return this.bottomNavText;
    }

    @NotNull
    public final String getBottomNavUnselectedImgUrl() {
        return this.bottomNavUnselectedImgUrl;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getLotteryDescUrl() {
        return this.lotteryDescUrl;
    }

    @NotNull
    public final String getPageBgUrl() {
        return this.pageBgUrl;
    }

    @NotNull
    public final String getPagePromoUrl() {
        return this.pagePromoUrl;
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
        return (((((((((((((((((this.themeDesc.hashCode() * 31) + this.logoUrl.hashCode()) * 31) + this.themeName.hashCode()) * 31) + this.badge.hashCode()) * 31) + this.pageBgUrl.hashCode()) * 31) + this.pagePromoUrl.hashCode()) * 31) + this.bottomNavText.hashCode()) * 31) + this.bottomNavImgUrl.hashCode()) * 31) + this.bottomNavUnselectedImgUrl.hashCode()) * 31) + this.lotteryDescUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThemeConfigBean(themeDesc=" + this.themeDesc + ", logoUrl=" + this.logoUrl + ", themeName=" + this.themeName + ", badge=" + this.badge + ", pageBgUrl=" + this.pageBgUrl + ", pagePromoUrl=" + this.pagePromoUrl + ", bottomNavText=" + this.bottomNavText + ", bottomNavImgUrl=" + this.bottomNavImgUrl + ", bottomNavUnselectedImgUrl=" + this.bottomNavUnselectedImgUrl + ", lotteryDescUrl=" + this.lotteryDescUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.themeDesc);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.themeName);
        parcel.writeString(this.badge);
        parcel.writeString(this.pageBgUrl);
        parcel.writeString(this.pagePromoUrl);
        parcel.writeString(this.bottomNavText);
        parcel.writeString(this.bottomNavImgUrl);
        parcel.writeString(this.bottomNavUnselectedImgUrl);
        parcel.writeString(this.lotteryDescUrl);
    }

    public /* synthetic */ ThemeConfigBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) == 0 ? str10 : "");
    }
}
