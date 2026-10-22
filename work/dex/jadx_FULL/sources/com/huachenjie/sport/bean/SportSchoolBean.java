package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006$"}, d2 = {"Lcom/huachenjie/sport/bean/SportSchoolBean;", "", "title", "", "buttonType", "", "iconUrl", "redDot", "", "type", "subType", "linkUrl", "(Ljava/lang/String;ILjava/lang/String;ZIILjava/lang/String;)V", "getButtonType", "()I", "getIconUrl", "()Ljava/lang/String;", "getLinkUrl", "getRedDot", "()Z", "getSubType", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "other", "formatTip", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportSchoolBean {
    private final int buttonType;

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String linkUrl;
    private final boolean redDot;
    private final int subType;

    @NotNull
    private final String title;
    private final int type;

    public SportSchoolBean() {
        this(null, 0, null, false, 0, 0, null, 127, null);
    }

    public SportSchoolBean(@NotNull String str, int i, @NotNull String str2, boolean z, int i2, int i3, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "linkUrl");
        this.title = str;
        this.buttonType = i;
        this.iconUrl = str2;
        this.redDot = z;
        this.type = i2;
        this.subType = i3;
        this.linkUrl = str3;
    }

    public static /* synthetic */ SportSchoolBean copy$default(SportSchoolBean sportSchoolBean, String str, int i, String str2, boolean z, int i2, int i3, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = sportSchoolBean.title;
        }
        if ((i4 & 2) != 0) {
            i = sportSchoolBean.buttonType;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            str2 = sportSchoolBean.iconUrl;
        }
        String str4 = str2;
        if ((i4 & 8) != 0) {
            z = sportSchoolBean.redDot;
        }
        boolean z2 = z;
        if ((i4 & 16) != 0) {
            i2 = sportSchoolBean.type;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = sportSchoolBean.subType;
        }
        int i7 = i3;
        if ((i4 & 64) != 0) {
            str3 = sportSchoolBean.linkUrl;
        }
        return sportSchoolBean.copy(str, i5, str4, z2, i6, i7, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getButtonType() {
        return this.buttonType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRedDot() {
        return this.redDot;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @NotNull
    public final SportSchoolBean copy(@NotNull String title, int buttonType, @NotNull String iconUrl, boolean redDot, int type, int subType, @NotNull String linkUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        return new SportSchoolBean(title, buttonType, iconUrl, redDot, type, subType, linkUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportSchoolBean)) {
            return false;
        }
        SportSchoolBean sportSchoolBean = (SportSchoolBean) other;
        return Intrinsics.areEqual(this.title, sportSchoolBean.title) && this.buttonType == sportSchoolBean.buttonType && Intrinsics.areEqual(this.iconUrl, sportSchoolBean.iconUrl) && this.redDot == sportSchoolBean.redDot && this.type == sportSchoolBean.type && this.subType == sportSchoolBean.subType && Intrinsics.areEqual(this.linkUrl, sportSchoolBean.linkUrl);
    }

    @NotNull
    public final String formatTip() {
        switch (this.buttonType) {
            case 1:
                return "去查看";
            case 2:
                return "去选课";
            case 3:
                return "去参加";
            case 4:
                return "去预约";
            case 5:
                return "去报名";
            case 6:
                return "去完成";
            default:
                return "";
        }
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    public final int getSubType() {
        return this.subType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.title.hashCode() * 31) + Integer.hashCode(this.buttonType)) * 31) + this.iconUrl.hashCode()) * 31;
        boolean z = this.redDot;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.subType)) * 31) + this.linkUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "SportSchoolBean(title=" + this.title + ", buttonType=" + this.buttonType + ", iconUrl=" + this.iconUrl + ", redDot=" + this.redDot + ", type=" + this.type + ", subType=" + this.subType + ", linkUrl=" + this.linkUrl + ')';
    }

    public /* synthetic */ SportSchoolBean(String str, int i, String str2, boolean z, int i2, int i3, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? i3 : 0, (i4 & 64) != 0 ? "" : str3);
    }
}
