package com.huachenjie.login.bean;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/huachenjie/login/bean/BindVisitorBean;", "", "appUserCode", "", AliyunLogCommon.TERMINAL_TYPE, "sex", "schoolCode", "schoolName", "schoolLogo", "idNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "getIdNumber", "getPhone", "getSchoolCode", "getSchoolLogo", "getSchoolName", "getSex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BindVisitorBean {

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String idNumber;

    @NotNull
    private final String phone;

    @NotNull
    private final String schoolCode;

    @NotNull
    private final String schoolLogo;

    @NotNull
    private final String schoolName;

    @NotNull
    private final String sex;

    public BindVisitorBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public BindVisitorBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str2, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(str3, "sex");
        Intrinsics.checkNotNullParameter(str4, "schoolCode");
        Intrinsics.checkNotNullParameter(str5, "schoolName");
        Intrinsics.checkNotNullParameter(str6, "schoolLogo");
        Intrinsics.checkNotNullParameter(str7, "idNumber");
        this.appUserCode = str;
        this.phone = str2;
        this.sex = str3;
        this.schoolCode = str4;
        this.schoolName = str5;
        this.schoolLogo = str6;
        this.idNumber = str7;
    }

    public static /* synthetic */ BindVisitorBean copy$default(BindVisitorBean bindVisitorBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindVisitorBean.appUserCode;
        }
        if ((i & 2) != 0) {
            str2 = bindVisitorBean.phone;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = bindVisitorBean.sex;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = bindVisitorBean.schoolCode;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = bindVisitorBean.schoolName;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = bindVisitorBean.schoolLogo;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = bindVisitorBean.idNumber;
        }
        return bindVisitorBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSex() {
        return this.sex;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchoolName() {
        return this.schoolName;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSchoolLogo() {
        return this.schoolLogo;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIdNumber() {
        return this.idNumber;
    }

    @NotNull
    public final BindVisitorBean copy(@NotNull String appUserCode, @NotNull String phone, @NotNull String sex, @NotNull String schoolCode, @NotNull String schoolName, @NotNull String schoolLogo, @NotNull String idNumber) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(schoolName, "schoolName");
        Intrinsics.checkNotNullParameter(schoolLogo, "schoolLogo");
        Intrinsics.checkNotNullParameter(idNumber, "idNumber");
        return new BindVisitorBean(appUserCode, phone, sex, schoolCode, schoolName, schoolLogo, idNumber);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindVisitorBean)) {
            return false;
        }
        BindVisitorBean bindVisitorBean = (BindVisitorBean) other;
        return Intrinsics.areEqual(this.appUserCode, bindVisitorBean.appUserCode) && Intrinsics.areEqual(this.phone, bindVisitorBean.phone) && Intrinsics.areEqual(this.sex, bindVisitorBean.sex) && Intrinsics.areEqual(this.schoolCode, bindVisitorBean.schoolCode) && Intrinsics.areEqual(this.schoolName, bindVisitorBean.schoolName) && Intrinsics.areEqual(this.schoolLogo, bindVisitorBean.schoolLogo) && Intrinsics.areEqual(this.idNumber, bindVisitorBean.idNumber);
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getIdNumber() {
        return this.idNumber;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSchoolLogo() {
        return this.schoolLogo;
    }

    @NotNull
    public final String getSchoolName() {
        return this.schoolName;
    }

    @NotNull
    public final String getSex() {
        return this.sex;
    }

    public int hashCode() {
        return (((((((((((this.appUserCode.hashCode() * 31) + this.phone.hashCode()) * 31) + this.sex.hashCode()) * 31) + this.schoolCode.hashCode()) * 31) + this.schoolName.hashCode()) * 31) + this.schoolLogo.hashCode()) * 31) + this.idNumber.hashCode();
    }

    @NotNull
    public String toString() {
        return "BindVisitorBean(appUserCode=" + this.appUserCode + ", phone=" + this.phone + ", sex=" + this.sex + ", schoolCode=" + this.schoolCode + ", schoolName=" + this.schoolName + ", schoolLogo=" + this.schoolLogo + ", idNumber=" + this.idNumber + ')';
    }

    public /* synthetic */ BindVisitorBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }
}
