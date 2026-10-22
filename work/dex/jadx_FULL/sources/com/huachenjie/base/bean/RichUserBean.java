package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/base/bean/RichUserBean;", "", "userName", "", "appUserCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "setAppUserCode", "(Ljava/lang/String;)V", "getUserName", "setUserName", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RichUserBean {

    @NotNull
    private String appUserCode;

    @NotNull
    private String userName;

    /* JADX WARN: Illegal instructions before constructor call */
    public RichUserBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public RichUserBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "appUserCode");
        this.userName = str;
        this.appUserCode = str2;
    }

    public static /* synthetic */ RichUserBean copy$default(RichUserBean richUserBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = richUserBean.userName;
        }
        if ((i & 2) != 0) {
            str2 = richUserBean.appUserCode;
        }
        return richUserBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final RichUserBean copy(@NotNull String userName, @NotNull String appUserCode) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        return new RichUserBean(userName, appUserCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RichUserBean)) {
            return false;
        }
        RichUserBean richUserBean = (RichUserBean) other;
        return Intrinsics.areEqual(this.userName, richUserBean.userName) && Intrinsics.areEqual(this.appUserCode, richUserBean.appUserCode);
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return (this.userName.hashCode() * 31) + this.appUserCode.hashCode();
    }

    public final void setAppUserCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appUserCode = str;
    }

    public final void setUserName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }

    @NotNull
    public String toString() {
        return "RichUserBean(userName=" + this.userName + ", appUserCode=" + this.appUserCode + ')';
    }

    public /* synthetic */ RichUserBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
