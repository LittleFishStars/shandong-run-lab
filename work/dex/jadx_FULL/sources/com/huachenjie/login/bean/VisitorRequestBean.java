package com.huachenjie.login.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/huachenjie/login/bean/VisitorRequestBean;", "", "schoolCode", "", "sex", "birthDate", "headImg", "Lcom/huachenjie/login/bean/VisitorHeadBean;", "gradeCode", UserConstants.USER_PARAMS.b, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/login/bean/VisitorHeadBean;Ljava/lang/String;Ljava/lang/String;)V", "getBirthDate", "()Ljava/lang/String;", "setBirthDate", "(Ljava/lang/String;)V", "getGradeCode", "setGradeCode", "getHeadImg", "()Lcom/huachenjie/login/bean/VisitorHeadBean;", "setHeadImg", "(Lcom/huachenjie/login/bean/VisitorHeadBean;)V", "getNickName", "setNickName", "getSchoolCode", "setSchoolCode", "getSex", "setSex", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VisitorRequestBean {

    @NotNull
    private String birthDate;

    @NotNull
    private String gradeCode;

    @Nullable
    private VisitorHeadBean headImg;

    @NotNull
    private String nickName;

    @NotNull
    private String schoolCode;

    @NotNull
    private String sex;

    public VisitorRequestBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable VisitorHeadBean visitorHeadBean, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        Intrinsics.checkNotNullParameter(str2, "sex");
        Intrinsics.checkNotNullParameter(str3, "birthDate");
        Intrinsics.checkNotNullParameter(str4, "gradeCode");
        Intrinsics.checkNotNullParameter(str5, UserConstants.USER_PARAMS.b);
        this.schoolCode = str;
        this.sex = str2;
        this.birthDate = str3;
        this.headImg = visitorHeadBean;
        this.gradeCode = str4;
        this.nickName = str5;
    }

    public static /* synthetic */ VisitorRequestBean copy$default(VisitorRequestBean visitorRequestBean, String str, String str2, String str3, VisitorHeadBean visitorHeadBean, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = visitorRequestBean.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = visitorRequestBean.sex;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = visitorRequestBean.birthDate;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            visitorHeadBean = visitorRequestBean.headImg;
        }
        VisitorHeadBean visitorHeadBean2 = visitorHeadBean;
        if ((i & 16) != 0) {
            str4 = visitorRequestBean.gradeCode;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = visitorRequestBean.nickName;
        }
        return visitorRequestBean.copy(str, str6, str7, visitorHeadBean2, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSex() {
        return this.sex;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBirthDate() {
        return this.birthDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final VisitorHeadBean getHeadImg() {
        return this.headImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGradeCode() {
        return this.gradeCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final VisitorRequestBean copy(@NotNull String schoolCode, @NotNull String sex, @NotNull String birthDate, @Nullable VisitorHeadBean headImg, @NotNull String gradeCode, @NotNull String nickName) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(birthDate, "birthDate");
        Intrinsics.checkNotNullParameter(gradeCode, "gradeCode");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        return new VisitorRequestBean(schoolCode, sex, birthDate, headImg, gradeCode, nickName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisitorRequestBean)) {
            return false;
        }
        VisitorRequestBean visitorRequestBean = (VisitorRequestBean) other;
        return Intrinsics.areEqual(this.schoolCode, visitorRequestBean.schoolCode) && Intrinsics.areEqual(this.sex, visitorRequestBean.sex) && Intrinsics.areEqual(this.birthDate, visitorRequestBean.birthDate) && Intrinsics.areEqual(this.headImg, visitorRequestBean.headImg) && Intrinsics.areEqual(this.gradeCode, visitorRequestBean.gradeCode) && Intrinsics.areEqual(this.nickName, visitorRequestBean.nickName);
    }

    @NotNull
    public final String getBirthDate() {
        return this.birthDate;
    }

    @NotNull
    public final String getGradeCode() {
        return this.gradeCode;
    }

    @Nullable
    public final VisitorHeadBean getHeadImg() {
        return this.headImg;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
    }

    @NotNull
    public final String getSex() {
        return this.sex;
    }

    public int hashCode() {
        int iHashCode = ((((this.schoolCode.hashCode() * 31) + this.sex.hashCode()) * 31) + this.birthDate.hashCode()) * 31;
        VisitorHeadBean visitorHeadBean = this.headImg;
        return ((((iHashCode + (visitorHeadBean == null ? 0 : visitorHeadBean.hashCode())) * 31) + this.gradeCode.hashCode()) * 31) + this.nickName.hashCode();
    }

    public final void setBirthDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.birthDate = str;
    }

    public final void setGradeCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gradeCode = str;
    }

    public final void setHeadImg(@Nullable VisitorHeadBean visitorHeadBean) {
        this.headImg = visitorHeadBean;
    }

    public final void setNickName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void setSchoolCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
    }

    public final void setSex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sex = str;
    }

    @NotNull
    public String toString() {
        return "VisitorRequestBean(schoolCode=" + this.schoolCode + ", sex=" + this.sex + ", birthDate=" + this.birthDate + ", headImg=" + this.headImg + ", gradeCode=" + this.gradeCode + ", nickName=" + this.nickName + ')';
    }

    public /* synthetic */ VisitorRequestBean(String str, String str2, String str3, VisitorHeadBean visitorHeadBean, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : visitorHeadBean, str4, str5);
    }
}
