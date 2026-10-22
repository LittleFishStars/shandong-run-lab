package com.huachenjie.login.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/login/bean/RegisterConfigHeadBean;", "", "headImgCode", "", "headImgUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getHeadImgCode", "()Ljava/lang/String;", "getHeadImgUrl", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RegisterConfigHeadBean {

    @Nullable
    private final String headImgCode;

    @NotNull
    private final String headImgUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public RegisterConfigHeadBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public RegisterConfigHeadBean(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "headImgUrl");
        this.headImgCode = str;
        this.headImgUrl = str2;
    }

    public static /* synthetic */ RegisterConfigHeadBean copy$default(RegisterConfigHeadBean registerConfigHeadBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerConfigHeadBean.headImgCode;
        }
        if ((i & 2) != 0) {
            str2 = registerConfigHeadBean.headImgUrl;
        }
        return registerConfigHeadBean.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHeadImgCode() {
        return this.headImgCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHeadImgUrl() {
        return this.headImgUrl;
    }

    @NotNull
    public final RegisterConfigHeadBean copy(@Nullable String headImgCode, @NotNull String headImgUrl) {
        Intrinsics.checkNotNullParameter(headImgUrl, "headImgUrl");
        return new RegisterConfigHeadBean(headImgCode, headImgUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterConfigHeadBean)) {
            return false;
        }
        RegisterConfigHeadBean registerConfigHeadBean = (RegisterConfigHeadBean) other;
        return Intrinsics.areEqual(this.headImgCode, registerConfigHeadBean.headImgCode) && Intrinsics.areEqual(this.headImgUrl, registerConfigHeadBean.headImgUrl);
    }

    @Nullable
    public final String getHeadImgCode() {
        return this.headImgCode;
    }

    @NotNull
    public final String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public int hashCode() {
        String str = this.headImgCode;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.headImgUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "RegisterConfigHeadBean(headImgCode=" + this.headImgCode + ", headImgUrl=" + this.headImgUrl + ')';
    }

    public /* synthetic */ RegisterConfigHeadBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2);
    }
}
