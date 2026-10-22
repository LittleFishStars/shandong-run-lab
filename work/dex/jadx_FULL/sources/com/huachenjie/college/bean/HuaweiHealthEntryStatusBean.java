package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/college/bean/HuaweiHealthEntryStatusBean;", "", "schoolOpened", "", "authStatus", "authUrl", "", "(ZZLjava/lang/String;)V", "getAuthStatus", "()Z", "getAuthUrl", "()Ljava/lang/String;", "getSchoolOpened", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuaweiHealthEntryStatusBean {
    private final boolean authStatus;

    @NotNull
    private final String authUrl;
    private final boolean schoolOpened;

    public HuaweiHealthEntryStatusBean() {
        this(false, false, null, 7, null);
    }

    public HuaweiHealthEntryStatusBean(boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "authUrl");
        this.schoolOpened = z;
        this.authStatus = z2;
        this.authUrl = str;
    }

    public static /* synthetic */ HuaweiHealthEntryStatusBean copy$default(HuaweiHealthEntryStatusBean huaweiHealthEntryStatusBean, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = huaweiHealthEntryStatusBean.schoolOpened;
        }
        if ((i & 2) != 0) {
            z2 = huaweiHealthEntryStatusBean.authStatus;
        }
        if ((i & 4) != 0) {
            str = huaweiHealthEntryStatusBean.authUrl;
        }
        return huaweiHealthEntryStatusBean.copy(z, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSchoolOpened() {
        return this.schoolOpened;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAuthStatus() {
        return this.authStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuthUrl() {
        return this.authUrl;
    }

    @NotNull
    public final HuaweiHealthEntryStatusBean copy(boolean schoolOpened, boolean authStatus, @NotNull String authUrl) {
        Intrinsics.checkNotNullParameter(authUrl, "authUrl");
        return new HuaweiHealthEntryStatusBean(schoolOpened, authStatus, authUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuaweiHealthEntryStatusBean)) {
            return false;
        }
        HuaweiHealthEntryStatusBean huaweiHealthEntryStatusBean = (HuaweiHealthEntryStatusBean) other;
        return this.schoolOpened == huaweiHealthEntryStatusBean.schoolOpened && this.authStatus == huaweiHealthEntryStatusBean.authStatus && Intrinsics.areEqual(this.authUrl, huaweiHealthEntryStatusBean.authUrl);
    }

    public final boolean getAuthStatus() {
        return this.authStatus;
    }

    @NotNull
    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final boolean getSchoolOpened() {
        return this.schoolOpened;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.schoolOpened;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.authStatus;
        return ((i + (z2 ? 1 : z2)) * 31) + this.authUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "HuaweiHealthEntryStatusBean(schoolOpened=" + this.schoolOpened + ", authStatus=" + this.authStatus + ", authUrl=" + this.authUrl + ')';
    }

    public /* synthetic */ HuaweiHealthEntryStatusBean(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str);
    }
}
