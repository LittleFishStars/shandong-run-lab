package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/SchoolBannerBean;", "", "adCode", "", "adImg", "linkType", "", "relationCode", "relationUrl", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAdCode", "()Ljava/lang/String;", "getAdImg", "getLinkType", "()I", "getRelationCode", "getRelationUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolBannerBean {

    @NotNull
    private final String adCode;

    @NotNull
    private final String adImg;
    private final int linkType;

    @NotNull
    private final String relationCode;

    @NotNull
    private final String relationUrl;

    public SchoolBannerBean() {
        this(null, null, 0, null, null, 31, null);
    }

    public SchoolBannerBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "adCode");
        Intrinsics.checkNotNullParameter(str2, "adImg");
        Intrinsics.checkNotNullParameter(str3, "relationCode");
        Intrinsics.checkNotNullParameter(str4, "relationUrl");
        this.adCode = str;
        this.adImg = str2;
        this.linkType = i;
        this.relationCode = str3;
        this.relationUrl = str4;
    }

    public static /* synthetic */ SchoolBannerBean copy$default(SchoolBannerBean schoolBannerBean, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = schoolBannerBean.adCode;
        }
        if ((i2 & 2) != 0) {
            str2 = schoolBannerBean.adImg;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = schoolBannerBean.linkType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = schoolBannerBean.relationCode;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = schoolBannerBean.relationUrl;
        }
        return schoolBannerBean.copy(str, str5, i3, str6, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdCode() {
        return this.adCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdImg() {
        return this.adImg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLinkType() {
        return this.linkType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRelationCode() {
        return this.relationCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRelationUrl() {
        return this.relationUrl;
    }

    @NotNull
    public final SchoolBannerBean copy(@NotNull String adCode, @NotNull String adImg, int linkType, @NotNull String relationCode, @NotNull String relationUrl) {
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        Intrinsics.checkNotNullParameter(adImg, "adImg");
        Intrinsics.checkNotNullParameter(relationCode, "relationCode");
        Intrinsics.checkNotNullParameter(relationUrl, "relationUrl");
        return new SchoolBannerBean(adCode, adImg, linkType, relationCode, relationUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolBannerBean)) {
            return false;
        }
        SchoolBannerBean schoolBannerBean = (SchoolBannerBean) other;
        return Intrinsics.areEqual(this.adCode, schoolBannerBean.adCode) && Intrinsics.areEqual(this.adImg, schoolBannerBean.adImg) && this.linkType == schoolBannerBean.linkType && Intrinsics.areEqual(this.relationCode, schoolBannerBean.relationCode) && Intrinsics.areEqual(this.relationUrl, schoolBannerBean.relationUrl);
    }

    @NotNull
    public final String getAdCode() {
        return this.adCode;
    }

    @NotNull
    public final String getAdImg() {
        return this.adImg;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    @NotNull
    public final String getRelationCode() {
        return this.relationCode;
    }

    @NotNull
    public final String getRelationUrl() {
        return this.relationUrl;
    }

    public int hashCode() {
        return (((((((this.adCode.hashCode() * 31) + this.adImg.hashCode()) * 31) + Integer.hashCode(this.linkType)) * 31) + this.relationCode.hashCode()) * 31) + this.relationUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "SchoolBannerBean(adCode=" + this.adCode + ", adImg=" + this.adImg + ", linkType=" + this.linkType + ", relationCode=" + this.relationCode + ", relationUrl=" + this.relationUrl + ')';
    }

    public /* synthetic */ SchoolBannerBean(String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4);
    }
}
