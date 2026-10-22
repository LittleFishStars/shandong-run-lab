package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/bean/MultipleActivityBean;", "", "activityNo", "", "activityPicUrl", "activityUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityNo", "()Ljava/lang/String;", "getActivityPicUrl", "getActivityUrl", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MultipleActivityBean {

    @NotNull
    private final String activityNo;

    @NotNull
    private final String activityPicUrl;

    @NotNull
    private final String activityUrl;

    public MultipleActivityBean() {
        this(null, null, null, 7, null);
    }

    public MultipleActivityBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "activityNo");
        Intrinsics.checkNotNullParameter(str2, "activityPicUrl");
        Intrinsics.checkNotNullParameter(str3, "activityUrl");
        this.activityNo = str;
        this.activityPicUrl = str2;
        this.activityUrl = str3;
    }

    public static /* synthetic */ MultipleActivityBean copy$default(MultipleActivityBean multipleActivityBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = multipleActivityBean.activityNo;
        }
        if ((i & 2) != 0) {
            str2 = multipleActivityBean.activityPicUrl;
        }
        if ((i & 4) != 0) {
            str3 = multipleActivityBean.activityUrl;
        }
        return multipleActivityBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityNo() {
        return this.activityNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    @NotNull
    public final MultipleActivityBean copy(@NotNull String activityNo, @NotNull String activityPicUrl, @NotNull String activityUrl) {
        Intrinsics.checkNotNullParameter(activityNo, "activityNo");
        Intrinsics.checkNotNullParameter(activityPicUrl, "activityPicUrl");
        Intrinsics.checkNotNullParameter(activityUrl, "activityUrl");
        return new MultipleActivityBean(activityNo, activityPicUrl, activityUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultipleActivityBean)) {
            return false;
        }
        MultipleActivityBean multipleActivityBean = (MultipleActivityBean) other;
        return Intrinsics.areEqual(this.activityNo, multipleActivityBean.activityNo) && Intrinsics.areEqual(this.activityPicUrl, multipleActivityBean.activityPicUrl) && Intrinsics.areEqual(this.activityUrl, multipleActivityBean.activityUrl);
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
        return (((this.activityNo.hashCode() * 31) + this.activityPicUrl.hashCode()) * 31) + this.activityUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultipleActivityBean(activityNo=" + this.activityNo + ", activityPicUrl=" + this.activityPicUrl + ", activityUrl=" + this.activityUrl + ')';
    }

    public /* synthetic */ MultipleActivityBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
