package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/huachenjie/common/bean/AdPlatformSwitch;", "", "adName", "", "openFlag", "", "adType", "", "linkUrl", "imgUrl", "advertisementPlanCode", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdName", "()Ljava/lang/String;", "getAdType", "()I", "getAdvertisementPlanCode", "getImgUrl", "getLinkUrl", "getOpenFlag", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdPlatformSwitch {

    @Nullable
    private final String adName;
    private final int adType;

    @Nullable
    private final String advertisementPlanCode;

    @Nullable
    private final String imgUrl;

    @Nullable
    private final String linkUrl;
    private final boolean openFlag;

    public AdPlatformSwitch(@Nullable String str, boolean z, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.adName = str;
        this.openFlag = z;
        this.adType = i;
        this.linkUrl = str2;
        this.imgUrl = str3;
        this.advertisementPlanCode = str4;
    }

    public static /* synthetic */ AdPlatformSwitch copy$default(AdPlatformSwitch adPlatformSwitch, String str, boolean z, int i, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adPlatformSwitch.adName;
        }
        if ((i2 & 2) != 0) {
            z = adPlatformSwitch.openFlag;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            i = adPlatformSwitch.adType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = adPlatformSwitch.linkUrl;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = adPlatformSwitch.imgUrl;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = adPlatformSwitch.advertisementPlanCode;
        }
        return adPlatformSwitch.copy(str, z2, i3, str5, str6, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdName() {
        return this.adName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOpenFlag() {
        return this.openFlag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAdType() {
        return this.adType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAdvertisementPlanCode() {
        return this.advertisementPlanCode;
    }

    @NotNull
    public final AdPlatformSwitch copy(@Nullable String adName, boolean openFlag, int adType, @Nullable String linkUrl, @Nullable String imgUrl, @Nullable String advertisementPlanCode) {
        return new AdPlatformSwitch(adName, openFlag, adType, linkUrl, imgUrl, advertisementPlanCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPlatformSwitch)) {
            return false;
        }
        AdPlatformSwitch adPlatformSwitch = (AdPlatformSwitch) other;
        return Intrinsics.areEqual(this.adName, adPlatformSwitch.adName) && this.openFlag == adPlatformSwitch.openFlag && this.adType == adPlatformSwitch.adType && Intrinsics.areEqual(this.linkUrl, adPlatformSwitch.linkUrl) && Intrinsics.areEqual(this.imgUrl, adPlatformSwitch.imgUrl) && Intrinsics.areEqual(this.advertisementPlanCode, adPlatformSwitch.advertisementPlanCode);
    }

    @Nullable
    public final String getAdName() {
        return this.adName;
    }

    public final int getAdType() {
        return this.adType;
    }

    @Nullable
    public final String getAdvertisementPlanCode() {
        return this.advertisementPlanCode;
    }

    @Nullable
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final boolean getOpenFlag() {
        return this.openFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    public int hashCode() {
        String str = this.adName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.openFlag;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode2 = (((iHashCode + r2) * 31) + Integer.hashCode(this.adType)) * 31;
        String str2 = this.linkUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imgUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.advertisementPlanCode;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AdPlatformSwitch(adName=" + this.adName + ", openFlag=" + this.openFlag + ", adType=" + this.adType + ", linkUrl=" + this.linkUrl + ", imgUrl=" + this.imgUrl + ", advertisementPlanCode=" + this.advertisementPlanCode + ")";
    }

    public /* synthetic */ AdPlatformSwitch(String str, boolean z, int i, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i, str2, str3, str4);
    }
}
