package com.huachenjie.login.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/login/bean/SchoolCertificationBean;", "", "schoolCode", "", "schoolName", "logoUrl", "loginUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginUrl", "()Ljava/lang/String;", "getLogoUrl", "getSchoolCode", "getSchoolName", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolCertificationBean {

    @NotNull
    private final String loginUrl;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String schoolCode;

    @NotNull
    private final String schoolName;

    public SchoolCertificationBean() {
        this(null, null, null, null, 15, null);
    }

    public SchoolCertificationBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "schoolName");
        Intrinsics.checkNotNullParameter(str3, "logoUrl");
        Intrinsics.checkNotNullParameter(str4, "loginUrl");
        this.schoolCode = str;
        this.schoolName = str2;
        this.logoUrl = str3;
        this.loginUrl = str4;
    }

    public static /* synthetic */ SchoolCertificationBean copy$default(SchoolCertificationBean schoolCertificationBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schoolCertificationBean.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = schoolCertificationBean.schoolName;
        }
        if ((i & 4) != 0) {
            str3 = schoolCertificationBean.logoUrl;
        }
        if ((i & 8) != 0) {
            str4 = schoolCertificationBean.loginUrl;
        }
        return schoolCertificationBean.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolName() {
        return this.schoolName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @NotNull
    public final SchoolCertificationBean copy(@NotNull String schoolCode, @NotNull String schoolName, @NotNull String logoUrl, @NotNull String loginUrl) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(schoolName, "schoolName");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(loginUrl, "loginUrl");
        return new SchoolCertificationBean(schoolCode, schoolName, logoUrl, loginUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolCertificationBean)) {
            return false;
        }
        SchoolCertificationBean schoolCertificationBean = (SchoolCertificationBean) other;
        return Intrinsics.areEqual(this.schoolCode, schoolCertificationBean.schoolCode) && Intrinsics.areEqual(this.schoolName, schoolCertificationBean.schoolName) && Intrinsics.areEqual(this.logoUrl, schoolCertificationBean.logoUrl) && Intrinsics.areEqual(this.loginUrl, schoolCertificationBean.loginUrl);
    }

    @NotNull
    public final String getLoginUrl() {
        return this.loginUrl;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolName() {
        return this.schoolName;
    }

    public int hashCode() {
        return (((((this.schoolCode.hashCode() * 31) + this.schoolName.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.loginUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "SchoolCertificationBean(schoolCode=" + this.schoolCode + ", schoolName=" + this.schoolName + ", logoUrl=" + this.logoUrl + ", loginUrl=" + this.loginUrl + ')';
    }

    public /* synthetic */ SchoolCertificationBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
