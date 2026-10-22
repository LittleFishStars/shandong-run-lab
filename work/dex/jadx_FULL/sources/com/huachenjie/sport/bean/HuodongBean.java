package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/bean/HuodongBean;", "", "activityCode", "", "activityTitle", "activityTime", "coverImage", "activityStatus", "", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getActivityCode", "()Ljava/lang/String;", "getActivityStatus", "()I", "getActivityTime", "getActivityTitle", "getCoverImage", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HuodongBean {

    @NotNull
    private final String activityCode;
    private final int activityStatus;

    @NotNull
    private final String activityTime;

    @NotNull
    private final String activityTitle;

    @NotNull
    private final String coverImage;

    @NotNull
    private final String url;

    public HuodongBean() {
        this(null, null, null, null, 0, null, 63, null);
    }

    public HuodongBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "activityCode");
        Intrinsics.checkNotNullParameter(str2, "activityTitle");
        Intrinsics.checkNotNullParameter(str3, "activityTime");
        Intrinsics.checkNotNullParameter(str4, "coverImage");
        Intrinsics.checkNotNullParameter(str5, "url");
        this.activityCode = str;
        this.activityTitle = str2;
        this.activityTime = str3;
        this.coverImage = str4;
        this.activityStatus = i;
        this.url = str5;
    }

    public static /* synthetic */ HuodongBean copy$default(HuodongBean huodongBean, String str, String str2, String str3, String str4, int i, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = huodongBean.activityCode;
        }
        if ((i2 & 2) != 0) {
            str2 = huodongBean.activityTitle;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = huodongBean.activityTime;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = huodongBean.coverImage;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            i = huodongBean.activityStatus;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str5 = huodongBean.url;
        }
        return huodongBean.copy(str, str6, str7, str8, i3, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityCode() {
        return this.activityCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityTime() {
        return this.activityTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final HuodongBean copy(@NotNull String activityCode, @NotNull String activityTitle, @NotNull String activityTime, @NotNull String coverImage, int activityStatus, @NotNull String url) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(activityTime, "activityTime");
        Intrinsics.checkNotNullParameter(coverImage, "coverImage");
        Intrinsics.checkNotNullParameter(url, "url");
        return new HuodongBean(activityCode, activityTitle, activityTime, coverImage, activityStatus, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HuodongBean)) {
            return false;
        }
        HuodongBean huodongBean = (HuodongBean) other;
        return Intrinsics.areEqual(this.activityCode, huodongBean.activityCode) && Intrinsics.areEqual(this.activityTitle, huodongBean.activityTitle) && Intrinsics.areEqual(this.activityTime, huodongBean.activityTime) && Intrinsics.areEqual(this.coverImage, huodongBean.coverImage) && this.activityStatus == huodongBean.activityStatus && Intrinsics.areEqual(this.url, huodongBean.url);
    }

    @NotNull
    public final String getActivityCode() {
        return this.activityCode;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    @NotNull
    public final String getActivityTime() {
        return this.activityTime;
    }

    @NotNull
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    @NotNull
    public final String getCoverImage() {
        return this.coverImage;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((this.activityCode.hashCode() * 31) + this.activityTitle.hashCode()) * 31) + this.activityTime.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + Integer.hashCode(this.activityStatus)) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "HuodongBean(activityCode=" + this.activityCode + ", activityTitle=" + this.activityTitle + ", activityTime=" + this.activityTime + ", coverImage=" + this.coverImage + ", activityStatus=" + this.activityStatus + ", url=" + this.url + ')';
    }

    public /* synthetic */ HuodongBean(String str, String str2, String str3, String str4, int i, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str5);
    }
}
