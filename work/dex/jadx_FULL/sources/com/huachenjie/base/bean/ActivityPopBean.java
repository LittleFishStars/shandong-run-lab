package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/base/bean/ActivityPopBean;", "", "activityPopupFlag", "", "activityPopupInfo", "Lcom/huachenjie/base/bean/ActivityPopInfoBean;", "(ZLcom/huachenjie/base/bean/ActivityPopInfoBean;)V", "getActivityPopupFlag", "()Z", "getActivityPopupInfo", "()Lcom/huachenjie/base/bean/ActivityPopInfoBean;", "component1", "component2", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActivityPopBean {
    private final boolean activityPopupFlag;

    @NotNull
    private final ActivityPopInfoBean activityPopupInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityPopBean() {
        ActivityPopInfoBean activityPopInfoBean = null;
        this(false, activityPopInfoBean, 3, activityPopInfoBean);
    }

    public ActivityPopBean(boolean z, @NotNull ActivityPopInfoBean activityPopInfoBean) {
        Intrinsics.checkNotNullParameter(activityPopInfoBean, "activityPopupInfo");
        this.activityPopupFlag = z;
        this.activityPopupInfo = activityPopInfoBean;
    }

    public static /* synthetic */ ActivityPopBean copy$default(ActivityPopBean activityPopBean, boolean z, ActivityPopInfoBean activityPopInfoBean, int i, Object obj) {
        if ((i & 1) != 0) {
            z = activityPopBean.activityPopupFlag;
        }
        if ((i & 2) != 0) {
            activityPopInfoBean = activityPopBean.activityPopupInfo;
        }
        return activityPopBean.copy(z, activityPopInfoBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getActivityPopupFlag() {
        return this.activityPopupFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ActivityPopInfoBean getActivityPopupInfo() {
        return this.activityPopupInfo;
    }

    @NotNull
    public final ActivityPopBean copy(boolean activityPopupFlag, @NotNull ActivityPopInfoBean activityPopupInfo) {
        Intrinsics.checkNotNullParameter(activityPopupInfo, "activityPopupInfo");
        return new ActivityPopBean(activityPopupFlag, activityPopupInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityPopBean)) {
            return false;
        }
        ActivityPopBean activityPopBean = (ActivityPopBean) other;
        return this.activityPopupFlag == activityPopBean.activityPopupFlag && Intrinsics.areEqual(this.activityPopupInfo, activityPopBean.activityPopupInfo);
    }

    public final boolean getActivityPopupFlag() {
        return this.activityPopupFlag;
    }

    @NotNull
    public final ActivityPopInfoBean getActivityPopupInfo() {
        return this.activityPopupInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.activityPopupFlag;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.activityPopupInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityPopBean(activityPopupFlag=" + this.activityPopupFlag + ", activityPopupInfo=" + this.activityPopupInfo + ')';
    }

    public /* synthetic */ ActivityPopBean(boolean z, ActivityPopInfoBean activityPopInfoBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new ActivityPopInfoBean(null, null, null, null, 15, null) : activityPopInfoBean);
    }
}
