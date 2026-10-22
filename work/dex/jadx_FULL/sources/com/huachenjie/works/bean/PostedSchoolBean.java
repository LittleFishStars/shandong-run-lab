package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J½\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0005HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006C"}, d2 = {"Lcom/huachenjie/works/bean/PostedSchoolBean;", "", "schoolCode", "", "number", "", "name", "shortName", "logo", "foregroundColor", "backgroundColor", "signFlag", "schoolNumber", "schoolLocation", "cityCode", "area", "proEnable", "coverUrl", "coverHue", "motto", "logoUrl", "city", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()I", "getBackgroundColor", "()Ljava/lang/String;", "getCity", "getCityCode", "getCoverHue", "getCoverUrl", "getForegroundColor", "getLogo", "getLogoUrl", "getMotto", "getName", "getNumber", "getProEnable", "getSchoolCode", "getSchoolLocation", "getSchoolNumber", "getShortName", "getSignFlag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostedSchoolBean {
    private final int area;

    @NotNull
    private final String backgroundColor;

    @NotNull
    private final String city;
    private final int cityCode;

    @NotNull
    private final String coverHue;

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String foregroundColor;

    @NotNull
    private final String logo;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String motto;

    @NotNull
    private final String name;
    private final int number;
    private final int proEnable;

    @NotNull
    private final String schoolCode;

    @NotNull
    private final String schoolLocation;

    @NotNull
    private final String schoolNumber;

    @NotNull
    private final String shortName;
    private final int signFlag;

    public PostedSchoolBean() {
        this(null, 0, null, null, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, 262143, null);
    }

    public PostedSchoolBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, @NotNull String str7, @NotNull String str8, int i3, int i4, int i5, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "shortName");
        Intrinsics.checkNotNullParameter(str4, "logo");
        Intrinsics.checkNotNullParameter(str5, "foregroundColor");
        Intrinsics.checkNotNullParameter(str6, "backgroundColor");
        Intrinsics.checkNotNullParameter(str7, "schoolNumber");
        Intrinsics.checkNotNullParameter(str8, "schoolLocation");
        Intrinsics.checkNotNullParameter(str9, "coverUrl");
        Intrinsics.checkNotNullParameter(str10, "coverHue");
        Intrinsics.checkNotNullParameter(str11, "motto");
        Intrinsics.checkNotNullParameter(str12, "logoUrl");
        Intrinsics.checkNotNullParameter(str13, "city");
        this.schoolCode = str;
        this.number = i;
        this.name = str2;
        this.shortName = str3;
        this.logo = str4;
        this.foregroundColor = str5;
        this.backgroundColor = str6;
        this.signFlag = i2;
        this.schoolNumber = str7;
        this.schoolLocation = str8;
        this.cityCode = i3;
        this.area = i4;
        this.proEnable = i5;
        this.coverUrl = str9;
        this.coverHue = str10;
        this.motto = str11;
        this.logoUrl = str12;
        this.city = str13;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSchoolLocation() {
        return this.schoolLocation;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getCityCode() {
        return this.cityCode;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getArea() {
        return this.area;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getProEnable() {
        return this.proEnable;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getMotto() {
        return this.motto;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSignFlag() {
        return this.signFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSchoolNumber() {
        return this.schoolNumber;
    }

    @NotNull
    public final PostedSchoolBean copy(@NotNull String schoolCode, int number, @NotNull String name, @NotNull String shortName, @NotNull String logo, @NotNull String foregroundColor, @NotNull String backgroundColor, int signFlag, @NotNull String schoolNumber, @NotNull String schoolLocation, int cityCode, int area, int proEnable, @NotNull String coverUrl, @NotNull String coverHue, @NotNull String motto, @NotNull String logoUrl, @NotNull String city) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(foregroundColor, "foregroundColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(schoolNumber, "schoolNumber");
        Intrinsics.checkNotNullParameter(schoolLocation, "schoolLocation");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverHue, "coverHue");
        Intrinsics.checkNotNullParameter(motto, "motto");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(city, "city");
        return new PostedSchoolBean(schoolCode, number, name, shortName, logo, foregroundColor, backgroundColor, signFlag, schoolNumber, schoolLocation, cityCode, area, proEnable, coverUrl, coverHue, motto, logoUrl, city);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostedSchoolBean)) {
            return false;
        }
        PostedSchoolBean postedSchoolBean = (PostedSchoolBean) other;
        return Intrinsics.areEqual(this.schoolCode, postedSchoolBean.schoolCode) && this.number == postedSchoolBean.number && Intrinsics.areEqual(this.name, postedSchoolBean.name) && Intrinsics.areEqual(this.shortName, postedSchoolBean.shortName) && Intrinsics.areEqual(this.logo, postedSchoolBean.logo) && Intrinsics.areEqual(this.foregroundColor, postedSchoolBean.foregroundColor) && Intrinsics.areEqual(this.backgroundColor, postedSchoolBean.backgroundColor) && this.signFlag == postedSchoolBean.signFlag && Intrinsics.areEqual(this.schoolNumber, postedSchoolBean.schoolNumber) && Intrinsics.areEqual(this.schoolLocation, postedSchoolBean.schoolLocation) && this.cityCode == postedSchoolBean.cityCode && this.area == postedSchoolBean.area && this.proEnable == postedSchoolBean.proEnable && Intrinsics.areEqual(this.coverUrl, postedSchoolBean.coverUrl) && Intrinsics.areEqual(this.coverHue, postedSchoolBean.coverHue) && Intrinsics.areEqual(this.motto, postedSchoolBean.motto) && Intrinsics.areEqual(this.logoUrl, postedSchoolBean.logoUrl) && Intrinsics.areEqual(this.city, postedSchoolBean.city);
    }

    public final int getArea() {
        return this.area;
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getCity() {
        return this.city;
    }

    public final int getCityCode() {
        return this.cityCode;
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
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getMotto() {
        return this.motto;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getProEnable() {
        return this.proEnable;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolLocation() {
        return this.schoolLocation;
    }

    @NotNull
    public final String getSchoolNumber() {
        return this.schoolNumber;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    public final int getSignFlag() {
        return this.signFlag;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.schoolCode.hashCode() * 31) + Integer.hashCode(this.number)) * 31) + this.name.hashCode()) * 31) + this.shortName.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.foregroundColor.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31) + Integer.hashCode(this.signFlag)) * 31) + this.schoolNumber.hashCode()) * 31) + this.schoolLocation.hashCode()) * 31) + Integer.hashCode(this.cityCode)) * 31) + Integer.hashCode(this.area)) * 31) + Integer.hashCode(this.proEnable)) * 31) + this.coverUrl.hashCode()) * 31) + this.coverHue.hashCode()) * 31) + this.motto.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.city.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostedSchoolBean(schoolCode=" + this.schoolCode + ", number=" + this.number + ", name=" + this.name + ", shortName=" + this.shortName + ", logo=" + this.logo + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", signFlag=" + this.signFlag + ", schoolNumber=" + this.schoolNumber + ", schoolLocation=" + this.schoolLocation + ", cityCode=" + this.cityCode + ", area=" + this.area + ", proEnable=" + this.proEnable + ", coverUrl=" + this.coverUrl + ", coverHue=" + this.coverHue + ", motto=" + this.motto + ", logoUrl=" + this.logoUrl + ", city=" + this.city + ')';
    }

    public /* synthetic */ PostedSchoolBean(String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, int i3, int i4, int i5, String str9, String str10, String str11, String str12, String str13, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? "" : str3, (i6 & 16) != 0 ? "" : str4, (i6 & 32) != 0 ? "" : str5, (i6 & 64) != 0 ? "" : str6, (i6 & 128) != 0 ? 0 : i2, (i6 & 256) != 0 ? "" : str7, (i6 & 512) != 0 ? "" : str8, (i6 & 1024) != 0 ? 0 : i3, (i6 & 2048) != 0 ? 0 : i4, (i6 & 4096) == 0 ? i5 : 0, (i6 & 8192) != 0 ? "" : str9, (i6 & 16384) != 0 ? "" : str10, (i6 & 32768) != 0 ? "" : str11, (i6 & 65536) != 0 ? "" : str12, (i6 & 131072) != 0 ? "" : str13);
    }
}
