package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/bean/PosterBackgroundBean;", "", "posterNo", "", "posterUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getPosterNo", "()Ljava/lang/String;", "getPosterUrl", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PosterBackgroundBean {

    @NotNull
    private final String posterNo;

    @NotNull
    private final String posterUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    public PosterBackgroundBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public PosterBackgroundBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "posterNo");
        Intrinsics.checkNotNullParameter(str2, "posterUrl");
        this.posterNo = str;
        this.posterUrl = str2;
    }

    public static /* synthetic */ PosterBackgroundBean copy$default(PosterBackgroundBean posterBackgroundBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = posterBackgroundBean.posterNo;
        }
        if ((i & 2) != 0) {
            str2 = posterBackgroundBean.posterUrl;
        }
        return posterBackgroundBean.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPosterNo() {
        return this.posterNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @NotNull
    public final PosterBackgroundBean copy(@NotNull String posterNo, @NotNull String posterUrl) {
        Intrinsics.checkNotNullParameter(posterNo, "posterNo");
        Intrinsics.checkNotNullParameter(posterUrl, "posterUrl");
        return new PosterBackgroundBean(posterNo, posterUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PosterBackgroundBean)) {
            return false;
        }
        PosterBackgroundBean posterBackgroundBean = (PosterBackgroundBean) other;
        return Intrinsics.areEqual(this.posterNo, posterBackgroundBean.posterNo) && Intrinsics.areEqual(this.posterUrl, posterBackgroundBean.posterUrl);
    }

    @NotNull
    public final String getPosterNo() {
        return this.posterNo;
    }

    @NotNull
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public int hashCode() {
        return (this.posterNo.hashCode() * 31) + this.posterUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "PosterBackgroundBean(posterNo=" + this.posterNo + ", posterUrl=" + this.posterUrl + ')';
    }

    public /* synthetic */ PosterBackgroundBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
