package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/LocalVideoInfoBean;", "", yj7.g.f20871d, "", "localPath", "saveTime", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getLocalPath", "()Ljava/lang/String;", "setLocalPath", "(Ljava/lang/String;)V", "getSaveTime", "()J", "setSaveTime", "(J)V", "getWorksNo", "setWorksNo", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LocalVideoInfoBean {

    @NotNull
    private String localPath;
    private long saveTime;

    @NotNull
    private String worksNo;

    public LocalVideoInfoBean() {
        this(null, null, 0L, 7, null);
    }

    public LocalVideoInfoBean(@NotNull String str, @NotNull String str2, long j) {
        Intrinsics.checkNotNullParameter(str, yj7.g.f20871d);
        Intrinsics.checkNotNullParameter(str2, "localPath");
        this.worksNo = str;
        this.localPath = str2;
        this.saveTime = j;
    }

    public static /* synthetic */ LocalVideoInfoBean copy$default(LocalVideoInfoBean localVideoInfoBean, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localVideoInfoBean.worksNo;
        }
        if ((i & 2) != 0) {
            str2 = localVideoInfoBean.localPath;
        }
        if ((i & 4) != 0) {
            j = localVideoInfoBean.saveTime;
        }
        return localVideoInfoBean.copy(str, str2, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWorksNo() {
        return this.worksNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSaveTime() {
        return this.saveTime;
    }

    @NotNull
    public final LocalVideoInfoBean copy(@NotNull String worksNo, @NotNull String localPath, long saveTime) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.f20871d);
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        return new LocalVideoInfoBean(worksNo, localPath, saveTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalVideoInfoBean)) {
            return false;
        }
        LocalVideoInfoBean localVideoInfoBean = (LocalVideoInfoBean) other;
        return Intrinsics.areEqual(this.worksNo, localVideoInfoBean.worksNo) && Intrinsics.areEqual(this.localPath, localVideoInfoBean.localPath) && this.saveTime == localVideoInfoBean.saveTime;
    }

    @NotNull
    public final String getLocalPath() {
        return this.localPath;
    }

    public final long getSaveTime() {
        return this.saveTime;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    public int hashCode() {
        return (((this.worksNo.hashCode() * 31) + this.localPath.hashCode()) * 31) + Long.hashCode(this.saveTime);
    }

    public final void setLocalPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localPath = str;
    }

    public final void setSaveTime(long j) {
        this.saveTime = j;
    }

    public final void setWorksNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.worksNo = str;
    }

    @NotNull
    public String toString() {
        return "LocalVideoInfoBean(worksNo=" + this.worksNo + ", localPath=" + this.localPath + ", saveTime=" + this.saveTime + ')';
    }

    public /* synthetic */ LocalVideoInfoBean(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j);
    }
}
