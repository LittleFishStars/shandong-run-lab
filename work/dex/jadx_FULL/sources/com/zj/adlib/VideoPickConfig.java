package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.xn9, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/xn9;", "", "", "f", "", "a", "maxDurationSeconds", "b", "toString", "hashCode", "other", "", "equals", "I", "e", "()I", "d", "()Z", "hasDurationLimit", "<init>", "(I)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class VideoPickConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxDurationSeconds;

    public VideoPickConfig() {
        this(0, 1, null);
    }

    public VideoPickConfig(int i) {
        this.maxDurationSeconds = i;
    }

    public static /* synthetic */ VideoPickConfig c(VideoPickConfig videoPickConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoPickConfig.maxDurationSeconds;
        }
        return videoPickConfig.b(i);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getMaxDurationSeconds() {
        return this.maxDurationSeconds;
    }

    @NotNull
    public final VideoPickConfig b(int maxDurationSeconds) {
        return new VideoPickConfig(maxDurationSeconds);
    }

    public final boolean d() {
        return this.maxDurationSeconds > 0;
    }

    public final int e() {
        return this.maxDurationSeconds;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VideoPickConfig) && this.maxDurationSeconds == ((VideoPickConfig) other).maxDurationSeconds;
    }

    @Nullable
    public final String f() {
        if (this.maxDurationSeconds < 0) {
            return "maxVideoDurationSeconds must be >= 0";
        }
        return null;
    }

    public int hashCode() {
        return Integer.hashCode(this.maxDurationSeconds);
    }

    @NotNull
    public String toString() {
        return "VideoPickConfig(maxDurationSeconds=" + this.maxDurationSeconds + ")";
    }

    public /* synthetic */ VideoPickConfig(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
