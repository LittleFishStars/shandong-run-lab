package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lcom/huachenjie/mall/bean/EpisodeProgress;", "", "seeCount", "", "seeDuration", "", "totalDuration", "nonSeeCount", "lastPlayNo", "", "(IJJILjava/lang/String;)V", "getLastPlayNo", "()Ljava/lang/String;", "getNonSeeCount", "()I", "getSeeCount", "getSeeDuration", "()J", "seeDurationStr", "getSeeDurationStr", "getTotalDuration", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EpisodeProgress {

    @NotNull
    private final String lastPlayNo;
    private final int nonSeeCount;
    private final int seeCount;
    private final long seeDuration;
    private final long totalDuration;

    public EpisodeProgress() {
        this(0, 0L, 0L, 0, null, 31, null);
    }

    public EpisodeProgress(int i, long j, long j2, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "lastPlayNo");
        this.seeCount = i;
        this.seeDuration = j;
        this.totalDuration = j2;
        this.nonSeeCount = i2;
        this.lastPlayNo = str;
    }

    public static /* synthetic */ EpisodeProgress copy$default(EpisodeProgress episodeProgress, int i, long j, long j2, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = episodeProgress.seeCount;
        }
        if ((i3 & 2) != 0) {
            j = episodeProgress.seeDuration;
        }
        long j3 = j;
        if ((i3 & 4) != 0) {
            j2 = episodeProgress.totalDuration;
        }
        long j4 = j2;
        if ((i3 & 8) != 0) {
            i2 = episodeProgress.nonSeeCount;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str = episodeProgress.lastPlayNo;
        }
        return episodeProgress.copy(i, j3, j4, i4, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSeeCount() {
        return this.seeCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSeeDuration() {
        return this.seeDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTotalDuration() {
        return this.totalDuration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNonSeeCount() {
        return this.nonSeeCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLastPlayNo() {
        return this.lastPlayNo;
    }

    @NotNull
    public final EpisodeProgress copy(int seeCount, long seeDuration, long totalDuration, int nonSeeCount, @NotNull String lastPlayNo) {
        Intrinsics.checkNotNullParameter(lastPlayNo, "lastPlayNo");
        return new EpisodeProgress(seeCount, seeDuration, totalDuration, nonSeeCount, lastPlayNo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeProgress)) {
            return false;
        }
        EpisodeProgress episodeProgress = (EpisodeProgress) other;
        return this.seeCount == episodeProgress.seeCount && this.seeDuration == episodeProgress.seeDuration && this.totalDuration == episodeProgress.totalDuration && this.nonSeeCount == episodeProgress.nonSeeCount && Intrinsics.areEqual(this.lastPlayNo, episodeProgress.lastPlayNo);
    }

    @NotNull
    public final String getLastPlayNo() {
        return this.lastPlayNo;
    }

    public final int getNonSeeCount() {
        return this.nonSeeCount;
    }

    public final int getSeeCount() {
        return this.seeCount;
    }

    public final long getSeeDuration() {
        return this.seeDuration;
    }

    @NotNull
    public final String getSeeDurationStr() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setGroupingUsed(false);
        float f = 10;
        return decimalFormat.format(Float.valueOf(((float) Math.floor(this.seeDuration / 360.0f)) / f)) + "h / " + decimalFormat.format(Float.valueOf(((float) Math.floor(this.totalDuration / 360.0f)) / f)) + 'h';
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.seeCount) * 31) + Long.hashCode(this.seeDuration)) * 31) + Long.hashCode(this.totalDuration)) * 31) + Integer.hashCode(this.nonSeeCount)) * 31) + this.lastPlayNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "EpisodeProgress(seeCount=" + this.seeCount + ", seeDuration=" + this.seeDuration + ", totalDuration=" + this.totalDuration + ", nonSeeCount=" + this.nonSeeCount + ", lastPlayNo=" + this.lastPlayNo + ')';
    }

    public /* synthetic */ EpisodeProgress(int i, long j, long j2, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0L : j, (i3 & 4) == 0 ? j2 : 0L, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str);
    }
}
