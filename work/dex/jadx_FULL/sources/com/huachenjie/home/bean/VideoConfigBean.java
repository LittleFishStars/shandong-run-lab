package com.huachenjie.home.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/home/bean/VideoConfigBean;", "", "allowVideo", "", "maxCount", "", "todayWatchedCount", "videoReward", "(ZIII)V", "getAllowVideo", "()Z", "getMaxCount", "()I", "getTodayWatchedCount", "setTodayWatchedCount", "(I)V", "getVideoReward", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VideoConfigBean {
    private final boolean allowVideo;
    private final int maxCount;
    private int todayWatchedCount;
    private final int videoReward;

    public VideoConfigBean() {
        this(false, 0, 0, 0, 15, null);
    }

    public VideoConfigBean(boolean z, int i, int i2, int i3) {
        this.allowVideo = z;
        this.maxCount = i;
        this.todayWatchedCount = i2;
        this.videoReward = i3;
    }

    public static /* synthetic */ VideoConfigBean copy$default(VideoConfigBean videoConfigBean, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = videoConfigBean.allowVideo;
        }
        if ((i4 & 2) != 0) {
            i = videoConfigBean.maxCount;
        }
        if ((i4 & 4) != 0) {
            i2 = videoConfigBean.todayWatchedCount;
        }
        if ((i4 & 8) != 0) {
            i3 = videoConfigBean.videoReward;
        }
        return videoConfigBean.copy(z, i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAllowVideo() {
        return this.allowVideo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTodayWatchedCount() {
        return this.todayWatchedCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVideoReward() {
        return this.videoReward;
    }

    @NotNull
    public final VideoConfigBean copy(boolean allowVideo, int maxCount, int todayWatchedCount, int videoReward) {
        return new VideoConfigBean(allowVideo, maxCount, todayWatchedCount, videoReward);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoConfigBean)) {
            return false;
        }
        VideoConfigBean videoConfigBean = (VideoConfigBean) other;
        return this.allowVideo == videoConfigBean.allowVideo && this.maxCount == videoConfigBean.maxCount && this.todayWatchedCount == videoConfigBean.todayWatchedCount && this.videoReward == videoConfigBean.videoReward;
    }

    public final boolean getAllowVideo() {
        return this.allowVideo;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final int getTodayWatchedCount() {
        return this.todayWatchedCount;
    }

    public final int getVideoReward() {
        return this.videoReward;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.allowVideo;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + Integer.hashCode(this.maxCount)) * 31) + Integer.hashCode(this.todayWatchedCount)) * 31) + Integer.hashCode(this.videoReward);
    }

    public final void setTodayWatchedCount(int i) {
        this.todayWatchedCount = i;
    }

    @NotNull
    public String toString() {
        return "VideoConfigBean(allowVideo=" + this.allowVideo + ", maxCount=" + this.maxCount + ", todayWatchedCount=" + this.todayWatchedCount + ", videoReward=" + this.videoReward + ')';
    }

    public /* synthetic */ VideoConfigBean(boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
