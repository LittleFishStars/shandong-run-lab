package com.ltmb.ltadsdk.api.ad;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001?BG\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b<\u0010=B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b<\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\tHÆ\u0003J\t\u0010\r\u001a\u00020\tHÆ\u0003J\t\u0010\u000e\u001a\u00020\tHÆ\u0003J\t\u0010\u000f\u001a\u00020\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\tHÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003JY\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0013\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\"\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&¨\u0006@"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYAdComplianceInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "appName", "appPkgName", "appVersion", "descUrl", "privacyUrl", "permissionUrl", "developer", "appFiling", OperatePopupWindow.g, "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "b", "getAppPkgName", "setAppPkgName", "c", "getAppVersion", "setAppVersion", "d", "getDescUrl", "setDescUrl", "e", "getPrivacyUrl", "setPrivacyUrl", "f", "getPermissionUrl", "setPermissionUrl", y6b.f, "getDeveloper", "setDeveloper", y6b.g, "getAppFiling", "setAppFiling", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final /* data */ class SYAdComplianceInfo implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    public String appName;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @NotNull
    public String appPkgName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @NotNull
    public String appVersion;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @NotNull
    public String descUrl;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @NotNull
    public String privacyUrl;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @NotNull
    public String permissionUrl;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    @NotNull
    public String developer;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    @NotNull
    public String appFiling;

    /* JADX INFO: renamed from: com.ltmb.ltadsdk.api.ad.SYAdComplianceInfo$CREATOR, reason: from kotlin metadata */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYAdComplianceInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ltmb/ltadsdk/api/ad/SYAdComplianceInfo;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "", "size", "", "newArray", "(I)[Lcom/ltmb/ltadsdk/api/ad/SYAdComplianceInfo;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion implements Parcelable.Creator<SYAdComplianceInfo> {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SYAdComplianceInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SYAdComplianceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SYAdComplianceInfo[] newArray(int size) {
            return new SYAdComplianceInfo[size];
        }
    }

    public SYAdComplianceInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "appName");
        Intrinsics.checkNotNullParameter(str2, "appPkgName");
        Intrinsics.checkNotNullParameter(str3, "appVersion");
        Intrinsics.checkNotNullParameter(str4, "descUrl");
        Intrinsics.checkNotNullParameter(str5, "privacyUrl");
        Intrinsics.checkNotNullParameter(str6, "permissionUrl");
        Intrinsics.checkNotNullParameter(str7, "developer");
        Intrinsics.checkNotNullParameter(str8, "appFiling");
        this.appName = str;
        this.appPkgName = str2;
        this.appVersion = str3;
        this.descUrl = str4;
        this.privacyUrl = str5;
        this.permissionUrl = str6;
        this.developer = str7;
        this.appFiling = str8;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppPkgName() {
        return this.appPkgName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescUrl() {
        return this.descUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPermissionUrl() {
        return this.permissionUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAppFiling() {
        return this.appFiling;
    }

    @NotNull
    public final SYAdComplianceInfo copy(@NotNull String appName, @NotNull String appPkgName, @NotNull String appVersion, @NotNull String descUrl, @NotNull String privacyUrl, @NotNull String permissionUrl, @NotNull String developer, @NotNull String appFiling) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appPkgName, "appPkgName");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(descUrl, "descUrl");
        Intrinsics.checkNotNullParameter(privacyUrl, "privacyUrl");
        Intrinsics.checkNotNullParameter(permissionUrl, "permissionUrl");
        Intrinsics.checkNotNullParameter(developer, "developer");
        Intrinsics.checkNotNullParameter(appFiling, "appFiling");
        return new SYAdComplianceInfo(appName, appPkgName, appVersion, descUrl, privacyUrl, permissionUrl, developer, appFiling);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SYAdComplianceInfo)) {
            return false;
        }
        SYAdComplianceInfo sYAdComplianceInfo = (SYAdComplianceInfo) other;
        return Intrinsics.areEqual(this.appName, sYAdComplianceInfo.appName) && Intrinsics.areEqual(this.appPkgName, sYAdComplianceInfo.appPkgName) && Intrinsics.areEqual(this.appVersion, sYAdComplianceInfo.appVersion) && Intrinsics.areEqual(this.descUrl, sYAdComplianceInfo.descUrl) && Intrinsics.areEqual(this.privacyUrl, sYAdComplianceInfo.privacyUrl) && Intrinsics.areEqual(this.permissionUrl, sYAdComplianceInfo.permissionUrl) && Intrinsics.areEqual(this.developer, sYAdComplianceInfo.developer) && Intrinsics.areEqual(this.appFiling, sYAdComplianceInfo.appFiling);
    }

    @NotNull
    public final String getAppFiling() {
        return this.appFiling;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppPkgName() {
        return this.appPkgName;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getDescUrl() {
        return this.descUrl;
    }

    @NotNull
    public final String getDeveloper() {
        return this.developer;
    }

    @NotNull
    public final String getPermissionUrl() {
        return this.permissionUrl;
    }

    @NotNull
    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appPkgName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.appVersion;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.descUrl;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.privacyUrl;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.permissionUrl;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.developer;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.appFiling;
        return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setAppFiling(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appFiling = str;
    }

    public final void setAppName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppPkgName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appPkgName = str;
    }

    public final void setAppVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setDescUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descUrl = str;
    }

    public final void setDeveloper(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.developer = str;
    }

    public final void setPermissionUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.permissionUrl = str;
    }

    public final void setPrivacyUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.privacyUrl = str;
    }

    @NotNull
    public String toString() {
        return "SYAdComplianceInfo(appName=" + this.appName + ", appPkgName=" + this.appPkgName + ", appVersion=" + this.appVersion + ", descUrl=" + this.descUrl + ", privacyUrl=" + this.privacyUrl + ", permissionUrl=" + this.permissionUrl + ", developer=" + this.developer + ", appFiling=" + this.appFiling + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.appName);
        parcel.writeString(this.appPkgName);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.descUrl);
        parcel.writeString(this.privacyUrl);
        parcel.writeString(this.permissionUrl);
        parcel.writeString(this.developer);
        parcel.writeString(this.appFiling);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SYAdComplianceInfo(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String str = string != null ? string : "";
        Intrinsics.checkNotNullExpressionValue(str, "parcel.readString() ?: \"\"");
        String string2 = parcel.readString();
        String str2 = string2 != null ? string2 : "";
        Intrinsics.checkNotNullExpressionValue(str2, "parcel.readString() ?: \"\"");
        String string3 = parcel.readString();
        String str3 = string3 != null ? string3 : "";
        Intrinsics.checkNotNullExpressionValue(str3, "parcel.readString() ?: \"\"");
        String string4 = parcel.readString();
        String str4 = string4 != null ? string4 : "";
        Intrinsics.checkNotNullExpressionValue(str4, "parcel.readString() ?: \"\"");
        String string5 = parcel.readString();
        String str5 = string5 != null ? string5 : "";
        Intrinsics.checkNotNullExpressionValue(str5, "parcel.readString() ?: \"\"");
        String string6 = parcel.readString();
        String str6 = string6 != null ? string6 : "";
        Intrinsics.checkNotNullExpressionValue(str6, "parcel.readString() ?: \"\"");
        String string7 = parcel.readString();
        String str7 = string7 != null ? string7 : "";
        Intrinsics.checkNotNullExpressionValue(str7, "parcel.readString() ?: \"\"");
        String string8 = parcel.readString();
        String str8 = string8 != null ? string8 : "";
        Intrinsics.checkNotNullExpressionValue(str8, "parcel.readString() ?: \"\"");
        this(str, str2, str3, str4, str5, str6, str7, str8);
    }
}
