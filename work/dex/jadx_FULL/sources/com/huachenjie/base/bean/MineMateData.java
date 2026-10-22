package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\nHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/MineMateData;", "", "avatarFrameImgUrl", "", "bisVip", "", MyThemeActivity.t, "followed", "accid", "vipPerksNum", "", "(Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;I)V", "getAccid", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "setAvatarFrameImgUrl", "(Ljava/lang/String;)V", "getBisVip", "()Z", "getFollowed", "getThemeImg", "setThemeImg", "getVipPerksNum", "()I", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MineMateData {

    @Nullable
    private final String accid;

    @NotNull
    private String avatarFrameImgUrl;
    private final boolean bisVip;
    private final boolean followed;

    @NotNull
    private String themeImg;
    private final int vipPerksNum;

    public MineMateData() {
        this(null, false, null, false, null, 0, 63, null);
    }

    public MineMateData(@NotNull String str, boolean z, @NotNull String str2, boolean z2, @Nullable String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str2, MyThemeActivity.t);
        this.avatarFrameImgUrl = str;
        this.bisVip = z;
        this.themeImg = str2;
        this.followed = z2;
        this.accid = str3;
        this.vipPerksNum = i;
    }

    public static /* synthetic */ MineMateData copy$default(MineMateData mineMateData, String str, boolean z, String str2, boolean z2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mineMateData.avatarFrameImgUrl;
        }
        if ((i2 & 2) != 0) {
            z = mineMateData.bisVip;
        }
        boolean z3 = z;
        if ((i2 & 4) != 0) {
            str2 = mineMateData.themeImg;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            z2 = mineMateData.followed;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            str3 = mineMateData.accid;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            i = mineMateData.vipPerksNum;
        }
        return mineMateData.copy(str, z3, str4, z4, str5, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getBisVip() {
        return this.bisVip;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThemeImg() {
        return this.themeImg;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFollowed() {
        return this.followed;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAccid() {
        return this.accid;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getVipPerksNum() {
        return this.vipPerksNum;
    }

    @NotNull
    public final MineMateData copy(@NotNull String avatarFrameImgUrl, boolean bisVip, @NotNull String themeImg, boolean followed, @Nullable String accid, int vipPerksNum) {
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(themeImg, MyThemeActivity.t);
        return new MineMateData(avatarFrameImgUrl, bisVip, themeImg, followed, accid, vipPerksNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MineMateData)) {
            return false;
        }
        MineMateData mineMateData = (MineMateData) other;
        return Intrinsics.areEqual(this.avatarFrameImgUrl, mineMateData.avatarFrameImgUrl) && this.bisVip == mineMateData.bisVip && Intrinsics.areEqual(this.themeImg, mineMateData.themeImg) && this.followed == mineMateData.followed && Intrinsics.areEqual(this.accid, mineMateData.accid) && this.vipPerksNum == mineMateData.vipPerksNum;
    }

    @Nullable
    public final String getAccid() {
        return this.accid;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final boolean getBisVip() {
        return this.bisVip;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    @NotNull
    public final String getThemeImg() {
        return this.themeImg;
    }

    public final int getVipPerksNum() {
        return this.vipPerksNum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.avatarFrameImgUrl.hashCode() * 31;
        boolean z = this.bisVip;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.themeImg.hashCode()) * 31;
        boolean z2 = this.followed;
        int i = (iHashCode2 + (z2 ? 1 : z2)) * 31;
        String str = this.accid;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.vipPerksNum);
    }

    public final void setAvatarFrameImgUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarFrameImgUrl = str;
    }

    public final void setThemeImg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeImg = str;
    }

    @NotNull
    public String toString() {
        return "MineMateData(avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", bisVip=" + this.bisVip + ", themeImg=" + this.themeImg + ", followed=" + this.followed + ", accid=" + this.accid + ", vipPerksNum=" + this.vipPerksNum + ')';
    }

    public /* synthetic */ MineMateData(String str, boolean z, String str2, boolean z2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? false : z2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? 0 : i);
    }
}
