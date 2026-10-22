package com.ltmb.ltadsdk.api.ad;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.common.video.VideoPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&R\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYVideoInfo;", "", "", "reportVideoStart", "", "duration", "reportVideoPause", "", MediationConstant.KEY_REASON, "reportVideoError", "reportVideoContinue", "reportVideoFinish", "total", "curr", "reportVideoProgress", "a", "Ljava/lang/String;", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", VideoPlayerActivity.t, "", "b", "I", "getVideoDuration", "()I", "setVideoDuration", "(I)V", "videoDuration", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public abstract class SYVideoInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String videoUrl = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int videoDuration;

    public final int getVideoDuration() {
        return this.videoDuration;
    }

    @NotNull
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public abstract void reportVideoContinue(long duration);

    public abstract void reportVideoError(@NotNull String reason);

    public abstract void reportVideoFinish();

    public abstract void reportVideoPause(long duration);

    public abstract void reportVideoProgress(long total, long curr);

    public abstract void reportVideoStart();

    public final void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public final void setVideoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }
}
