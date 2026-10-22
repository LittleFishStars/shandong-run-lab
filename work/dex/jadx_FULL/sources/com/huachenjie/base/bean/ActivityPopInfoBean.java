package com.huachenjie.base.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/base/bean/ActivityPopInfoBean;", "", "activityContent", "", "activityUrl", "activityPicUrl", "activityNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityContent", "()Ljava/lang/String;", "getActivityNo", "getActivityPicUrl", "getActivityUrl", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActivityPopInfoBean {

    @NotNull
    private final String activityContent;

    @NotNull
    private final String activityNo;

    @NotNull
    private final String activityPicUrl;

    @NotNull
    private final String activityUrl;

    public ActivityPopInfoBean() {
        this(null, null, null, null, 15, null);
    }

    public ActivityPopInfoBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "activityContent");
        Intrinsics.checkNotNullParameter(str2, "activityUrl");
        Intrinsics.checkNotNullParameter(str3, "activityPicUrl");
        Intrinsics.checkNotNullParameter(str4, "activityNo");
        this.activityContent = str;
        this.activityUrl = str2;
        this.activityPicUrl = str3;
        this.activityNo = str4;
    }

    public static /* synthetic */ ActivityPopInfoBean copy$default(ActivityPopInfoBean activityPopInfoBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityPopInfoBean.activityContent;
        }
        if ((i & 2) != 0) {
            str2 = activityPopInfoBean.activityUrl;
        }
        if ((i & 4) != 0) {
            str3 = activityPopInfoBean.activityPicUrl;
        }
        if ((i & 8) != 0) {
            str4 = activityPopInfoBean.activityNo;
        }
        return activityPopInfoBean.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityContent() {
        return this.activityContent;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getActivityNo() {
        return this.activityNo;
    }

    @NotNull
    public final ActivityPopInfoBean copy(@NotNull String activityContent, @NotNull String activityUrl, @NotNull String activityPicUrl, @NotNull String activityNo) {
        Intrinsics.checkNotNullParameter(activityContent, "activityContent");
        Intrinsics.checkNotNullParameter(activityUrl, "activityUrl");
        Intrinsics.checkNotNullParameter(activityPicUrl, "activityPicUrl");
        Intrinsics.checkNotNullParameter(activityNo, "activityNo");
        return new ActivityPopInfoBean(activityContent, activityUrl, activityPicUrl, activityNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityPopInfoBean)) {
            return false;
        }
        ActivityPopInfoBean activityPopInfoBean = (ActivityPopInfoBean) other;
        return Intrinsics.areEqual(this.activityContent, activityPopInfoBean.activityContent) && Intrinsics.areEqual(this.activityUrl, activityPopInfoBean.activityUrl) && Intrinsics.areEqual(this.activityPicUrl, activityPopInfoBean.activityPicUrl) && Intrinsics.areEqual(this.activityNo, activityPopInfoBean.activityNo);
    }

    @NotNull
    public final String getActivityContent() {
        return this.activityContent;
    }

    @NotNull
    public final String getActivityNo() {
        return this.activityNo;
    }

    @NotNull
    public final String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    @NotNull
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    public int hashCode() {
        return (((((this.activityContent.hashCode() * 31) + this.activityUrl.hashCode()) * 31) + this.activityPicUrl.hashCode()) * 31) + this.activityNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityPopInfoBean(activityContent=" + this.activityContent + ", activityUrl=" + this.activityUrl + ", activityPicUrl=" + this.activityPicUrl + ", activityNo=" + this.activityNo + ')';
    }

    public /* synthetic */ ActivityPopInfoBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
