package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/works/bean/OfficialActivityBean;", "", "activityShowFlag", "", "activityInfo", "Lcom/huachenjie/works/bean/ActivityInfo;", "(ZLcom/huachenjie/works/bean/ActivityInfo;)V", "getActivityInfo", "()Lcom/huachenjie/works/bean/ActivityInfo;", "getActivityShowFlag", "()Z", "component1", "component2", OperatePopupWindow.g, "equals", "other", "formatTitle", "", "formatUrl", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OfficialActivityBean {

    @Nullable
    private final ActivityInfo activityInfo;
    private final boolean activityShowFlag;

    /* JADX WARN: Illegal instructions before constructor call */
    public OfficialActivityBean() {
        ActivityInfo activityInfo = null;
        this(false, activityInfo, 3, activityInfo);
    }

    public OfficialActivityBean(boolean z, @Nullable ActivityInfo activityInfo) {
        this.activityShowFlag = z;
        this.activityInfo = activityInfo;
    }

    public static /* synthetic */ OfficialActivityBean copy$default(OfficialActivityBean officialActivityBean, boolean z, ActivityInfo activityInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = officialActivityBean.activityShowFlag;
        }
        if ((i & 2) != 0) {
            activityInfo = officialActivityBean.activityInfo;
        }
        return officialActivityBean.copy(z, activityInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getActivityShowFlag() {
        return this.activityShowFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ActivityInfo getActivityInfo() {
        return this.activityInfo;
    }

    @NotNull
    public final OfficialActivityBean copy(boolean activityShowFlag, @Nullable ActivityInfo activityInfo) {
        return new OfficialActivityBean(activityShowFlag, activityInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialActivityBean)) {
            return false;
        }
        OfficialActivityBean officialActivityBean = (OfficialActivityBean) other;
        return this.activityShowFlag == officialActivityBean.activityShowFlag && Intrinsics.areEqual(this.activityInfo, officialActivityBean.activityInfo);
    }

    @NotNull
    public final String formatTitle() {
        String title;
        ActivityInfo activityInfo = this.activityInfo;
        return (activityInfo == null || (title = activityInfo.getTitle()) == null) ? "" : title;
    }

    @NotNull
    public final String formatUrl() {
        String logoUrl;
        ActivityInfo activityInfo = this.activityInfo;
        return (activityInfo == null || (logoUrl = activityInfo.getLogoUrl()) == null) ? "" : logoUrl;
    }

    @Nullable
    public final ActivityInfo getActivityInfo() {
        return this.activityInfo;
    }

    public final boolean getActivityShowFlag() {
        return this.activityShowFlag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.activityShowFlag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ActivityInfo activityInfo = this.activityInfo;
        return i + (activityInfo == null ? 0 : activityInfo.hashCode());
    }

    @NotNull
    public String toString() {
        return "OfficialActivityBean(activityShowFlag=" + this.activityShowFlag + ", activityInfo=" + this.activityInfo + ')';
    }

    public /* synthetic */ OfficialActivityBean(boolean z, ActivityInfo activityInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : activityInfo);
    }
}
