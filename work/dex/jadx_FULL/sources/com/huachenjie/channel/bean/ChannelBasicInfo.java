package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006&"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelBasicInfo;", "", "channelNo", "", "channelName", "channelDescription", "channelNumber", "logo", "coverUrl", "coverHue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelDescription", "()Ljava/lang/String;", "setChannelDescription", "(Ljava/lang/String;)V", "getChannelName", "getChannelNo", "getChannelNumber", "getCoverHue", "setCoverHue", "getCoverUrl", "setCoverUrl", "getLogo", "setLogo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelBasicInfo {

    @NotNull
    private String channelDescription;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelNo;

    @NotNull
    private final String channelNumber;

    @NotNull
    private String coverHue;

    @NotNull
    private String coverUrl;

    @NotNull
    private String logo;

    public ChannelBasicInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public ChannelBasicInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "channelNo");
        Intrinsics.checkNotNullParameter(str2, "channelName");
        Intrinsics.checkNotNullParameter(str3, "channelDescription");
        Intrinsics.checkNotNullParameter(str4, "channelNumber");
        Intrinsics.checkNotNullParameter(str5, "logo");
        Intrinsics.checkNotNullParameter(str6, "coverUrl");
        Intrinsics.checkNotNullParameter(str7, "coverHue");
        this.channelNo = str;
        this.channelName = str2;
        this.channelDescription = str3;
        this.channelNumber = str4;
        this.logo = str5;
        this.coverUrl = str6;
        this.coverHue = str7;
    }

    public static /* synthetic */ ChannelBasicInfo copy$default(ChannelBasicInfo channelBasicInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelBasicInfo.channelNo;
        }
        if ((i & 2) != 0) {
            str2 = channelBasicInfo.channelName;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = channelBasicInfo.channelDescription;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = channelBasicInfo.channelNumber;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = channelBasicInfo.logo;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = channelBasicInfo.coverUrl;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = channelBasicInfo.coverHue;
        }
        return channelBasicInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelDescription() {
        return this.channelDescription;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    public final ChannelBasicInfo copy(@NotNull String channelNo, @NotNull String channelName, @NotNull String channelDescription, @NotNull String channelNumber, @NotNull String logo, @NotNull String coverUrl, @NotNull String coverHue) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(channelDescription, "channelDescription");
        Intrinsics.checkNotNullParameter(channelNumber, "channelNumber");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverHue, "coverHue");
        return new ChannelBasicInfo(channelNo, channelName, channelDescription, channelNumber, logo, coverUrl, coverHue);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelBasicInfo)) {
            return false;
        }
        ChannelBasicInfo channelBasicInfo = (ChannelBasicInfo) other;
        return Intrinsics.areEqual(this.channelNo, channelBasicInfo.channelNo) && Intrinsics.areEqual(this.channelName, channelBasicInfo.channelName) && Intrinsics.areEqual(this.channelDescription, channelBasicInfo.channelDescription) && Intrinsics.areEqual(this.channelNumber, channelBasicInfo.channelNumber) && Intrinsics.areEqual(this.logo, channelBasicInfo.logo) && Intrinsics.areEqual(this.coverUrl, channelBasicInfo.coverUrl) && Intrinsics.areEqual(this.coverHue, channelBasicInfo.coverHue);
    }

    @NotNull
    public final String getChannelDescription() {
        return this.channelDescription;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getChannelNumber() {
        return this.channelNumber;
    }

    @NotNull
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    public int hashCode() {
        return (((((((((((this.channelNo.hashCode() * 31) + this.channelName.hashCode()) * 31) + this.channelDescription.hashCode()) * 31) + this.channelNumber.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.coverHue.hashCode();
    }

    public final void setChannelDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelDescription = str;
    }

    public final void setCoverHue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverHue = str;
    }

    public final void setCoverUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setLogo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logo = str;
    }

    @NotNull
    public String toString() {
        return "ChannelBasicInfo(channelNo=" + this.channelNo + ", channelName=" + this.channelName + ", channelDescription=" + this.channelDescription + ", channelNumber=" + this.channelNumber + ", logo=" + this.logo + ", coverUrl=" + this.coverUrl + ", coverHue=" + this.coverHue + ')';
    }

    public /* synthetic */ ChannelBasicInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }
}
