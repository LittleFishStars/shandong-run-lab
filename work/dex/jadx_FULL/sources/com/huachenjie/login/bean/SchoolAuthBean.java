package com.huachenjie.login.bean;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/huachenjie/login/bean/SchoolAuthBean;", "", "type", "", "loginResult", "Lcom/huachenjie/login/bean/LoginResultData;", "userInfo", "Lcom/huachenjie/login/bean/UserInfo;", "schoolCode", "", "bindKey", "(ILcom/huachenjie/login/bean/LoginResultData;Lcom/huachenjie/login/bean/UserInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBindKey", "()Ljava/lang/String;", "getLoginResult", "()Lcom/huachenjie/login/bean/LoginResultData;", "getSchoolCode", "setSchoolCode", "(Ljava/lang/String;)V", "getType", "()I", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/login/bean/UserInfo;", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolAuthBean {

    @NotNull
    private final String bindKey;

    @NotNull
    private final LoginResultData loginResult;

    @NotNull
    private String schoolCode;
    private final int type;

    @NotNull
    private final UserInfo userInfo;

    public SchoolAuthBean() {
        this(0, null, null, null, null, 31, null);
    }

    public SchoolAuthBean(int i, @NotNull LoginResultData loginResultData, @NotNull UserInfo userInfo, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(loginResultData, "loginResult");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "bindKey");
        this.type = i;
        this.loginResult = loginResultData;
        this.userInfo = userInfo;
        this.schoolCode = str;
        this.bindKey = str2;
    }

    public static /* synthetic */ SchoolAuthBean copy$default(SchoolAuthBean schoolAuthBean, int i, LoginResultData loginResultData, UserInfo userInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = schoolAuthBean.type;
        }
        if ((i2 & 2) != 0) {
            loginResultData = schoolAuthBean.loginResult;
        }
        LoginResultData loginResultData2 = loginResultData;
        if ((i2 & 4) != 0) {
            userInfo = schoolAuthBean.userInfo;
        }
        UserInfo userInfo2 = userInfo;
        if ((i2 & 8) != 0) {
            str = schoolAuthBean.schoolCode;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = schoolAuthBean.bindKey;
        }
        return schoolAuthBean.copy(i, loginResultData2, userInfo2, str3, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LoginResultData getLoginResult() {
        return this.loginResult;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBindKey() {
        return this.bindKey;
    }

    @NotNull
    public final SchoolAuthBean copy(int type, @NotNull LoginResultData loginResult, @NotNull UserInfo userInfo, @NotNull String schoolCode, @NotNull String bindKey) {
        Intrinsics.checkNotNullParameter(loginResult, "loginResult");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(bindKey, "bindKey");
        return new SchoolAuthBean(type, loginResult, userInfo, schoolCode, bindKey);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolAuthBean)) {
            return false;
        }
        SchoolAuthBean schoolAuthBean = (SchoolAuthBean) other;
        return this.type == schoolAuthBean.type && Intrinsics.areEqual(this.loginResult, schoolAuthBean.loginResult) && Intrinsics.areEqual(this.userInfo, schoolAuthBean.userInfo) && Intrinsics.areEqual(this.schoolCode, schoolAuthBean.schoolCode) && Intrinsics.areEqual(this.bindKey, schoolAuthBean.bindKey);
    }

    @NotNull
    public final String getBindKey() {
        return this.bindKey;
    }

    @NotNull
    public final LoginResultData getLoginResult() {
        return this.loginResult;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.type) * 31) + this.loginResult.hashCode()) * 31) + this.userInfo.hashCode()) * 31) + this.schoolCode.hashCode()) * 31) + this.bindKey.hashCode();
    }

    public final void setSchoolCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
    }

    @NotNull
    public String toString() {
        return "SchoolAuthBean(type=" + this.type + ", loginResult=" + this.loginResult + ", userInfo=" + this.userInfo + ", schoolCode=" + this.schoolCode + ", bindKey=" + this.bindKey + ')';
    }

    public /* synthetic */ SchoolAuthBean(int i, LoginResultData loginResultData, UserInfo userInfo, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new LoginResultData("", "", "", 0, Boolean.FALSE, null) : loginResultData, (i2 & 4) != 0 ? new UserInfo(null, null, null, 7, null) : userInfo, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2);
    }
}
