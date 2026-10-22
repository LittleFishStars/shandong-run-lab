package com.huachenjie.common.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006#"}, d2 = {"Lcom/huachenjie/common/bean/AdPositionSwitch;", "", "adPositionName", "", "adType", "", "linkUrl", "imgUrl", "advertisementPlanCode", "adAgencyName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdAgencyName", "()Ljava/lang/String;", "setAdAgencyName", "(Ljava/lang/String;)V", "getAdPositionName", "getAdType", "()I", "setAdType", "(I)V", "getAdvertisementPlanCode", "getImgUrl", "getLinkUrl", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdPositionSwitch {

    @NotNull
    private String adAgencyName;

    @NotNull
    private final String adPositionName;
    private int adType;

    @NotNull
    private final String advertisementPlanCode;

    @NotNull
    private final String imgUrl;

    @NotNull
    private final String linkUrl;

    public AdPositionSwitch() {
        this(null, 0, null, null, null, null, 63, null);
    }

    public AdPositionSwitch(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "adPositionName");
        Intrinsics.checkNotNullParameter(str2, "linkUrl");
        Intrinsics.checkNotNullParameter(str3, "imgUrl");
        Intrinsics.checkNotNullParameter(str4, "advertisementPlanCode");
        Intrinsics.checkNotNullParameter(str5, "adAgencyName");
        this.adPositionName = str;
        this.adType = i;
        this.linkUrl = str2;
        this.imgUrl = str3;
        this.advertisementPlanCode = str4;
        this.adAgencyName = str5;
    }

    public static /* synthetic */ AdPositionSwitch copy$default(AdPositionSwitch adPositionSwitch, String str, int i, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = adPositionSwitch.adPositionName;
        }
        if ((i2 & 2) != 0) {
            i = adPositionSwitch.adType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = adPositionSwitch.linkUrl;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = adPositionSwitch.imgUrl;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = adPositionSwitch.advertisementPlanCode;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = adPositionSwitch.adAgencyName;
        }
        return adPositionSwitch.copy(str, i3, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdPositionName() {
        return this.adPositionName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAdType() {
        return this.adType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAdvertisementPlanCode() {
        return this.advertisementPlanCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAdAgencyName() {
        return this.adAgencyName;
    }

    @NotNull
    public final AdPositionSwitch copy(@NotNull String adPositionName, int adType, @NotNull String linkUrl, @NotNull String imgUrl, @NotNull String advertisementPlanCode, @NotNull String adAgencyName) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(advertisementPlanCode, "advertisementPlanCode");
        Intrinsics.checkNotNullParameter(adAgencyName, "adAgencyName");
        return new AdPositionSwitch(adPositionName, adType, linkUrl, imgUrl, advertisementPlanCode, adAgencyName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPositionSwitch)) {
            return false;
        }
        AdPositionSwitch adPositionSwitch = (AdPositionSwitch) other;
        return Intrinsics.areEqual(this.adPositionName, adPositionSwitch.adPositionName) && this.adType == adPositionSwitch.adType && Intrinsics.areEqual(this.linkUrl, adPositionSwitch.linkUrl) && Intrinsics.areEqual(this.imgUrl, adPositionSwitch.imgUrl) && Intrinsics.areEqual(this.advertisementPlanCode, adPositionSwitch.advertisementPlanCode) && Intrinsics.areEqual(this.adAgencyName, adPositionSwitch.adAgencyName);
    }

    @NotNull
    public final String getAdAgencyName() {
        return this.adAgencyName;
    }

    @NotNull
    public final String getAdPositionName() {
        return this.adPositionName;
    }

    public final int getAdType() {
        return this.adType;
    }

    @NotNull
    public final String getAdvertisementPlanCode() {
        return this.advertisementPlanCode;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public int hashCode() {
        return (((((((((this.adPositionName.hashCode() * 31) + Integer.hashCode(this.adType)) * 31) + this.linkUrl.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + this.advertisementPlanCode.hashCode()) * 31) + this.adAgencyName.hashCode();
    }

    public final void setAdAgencyName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adAgencyName = str;
    }

    public final void setAdType(int i) {
        this.adType = i;
    }

    @NotNull
    public String toString() {
        return "AdPositionSwitch(adPositionName=" + this.adPositionName + ", adType=" + this.adType + ", linkUrl=" + this.linkUrl + ", imgUrl=" + this.imgUrl + ", advertisementPlanCode=" + this.advertisementPlanCode + ", adAgencyName=" + this.adAgencyName + ")";
    }

    public /* synthetic */ AdPositionSwitch(String str, int i, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5);
    }
}
