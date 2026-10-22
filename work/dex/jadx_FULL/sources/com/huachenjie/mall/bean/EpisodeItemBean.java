package com.huachenjie.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.zj.adlib.s72;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010\u0013J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\u008d\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\bHÆ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\u0013\u0010=\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\u000e\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0010J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\bJ\u0019\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010-¨\u0006K"}, d2 = {"Lcom/huachenjie/mall/bean/EpisodeItemBean;", "Landroid/os/Parcelable;", "episodeItemNo", "", "sort", "", "episodeItemName", "seeDuration", "", "videoDuration", "progressRate", "coverUrl", "trySee", "tryTime", VideoPlayerActivity.t, "isPlaying", "", "positionType", "lastReportDuration", "(Ljava/lang/String;ILjava/lang/String;JJILjava/lang/String;IJLjava/lang/String;ZIJ)V", "getCoverUrl", "()Ljava/lang/String;", "getEpisodeItemName", "getEpisodeItemNo", "()Z", "setPlaying", "(Z)V", "getLastReportDuration", "()J", "setLastReportDuration", "(J)V", "getPositionType", "()I", "setPositionType", "(I)V", "getProgressRate", "setProgressRate", "getSeeDuration", "setSeeDuration", "getSort", "getTrySee", "getTryTime", "getVideoDuration", "getVideoUrl", "setVideoUrl", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatInfo", "hasBuy", "hashCode", "toString", "updateSeeDuration", "", "duration", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EpisodeItemBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EpisodeItemBean> CREATOR = new Creator();

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String episodeItemName;

    @NotNull
    private final String episodeItemNo;
    private boolean isPlaying;
    private long lastReportDuration;
    private int positionType;
    private int progressRate;
    private long seeDuration;
    private final int sort;
    private final int trySee;
    private final long tryTime;
    private final long videoDuration;

    @Nullable
    private String videoUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EpisodeItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EpisodeItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EpisodeItemBean(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EpisodeItemBean[] newArray(int i) {
            return new EpisodeItemBean[i];
        }
    }

    public EpisodeItemBean() {
        this(null, 0, null, 0L, 0L, 0, null, 0, 0L, null, false, 0, 0L, 8191, null);
    }

    public EpisodeItemBean(@NotNull String str, int i, @NotNull String str2, long j, long j2, int i2, @NotNull String str3, int i3, long j3, @Nullable String str4, boolean z, int i4, long j4) {
        Intrinsics.checkNotNullParameter(str, "episodeItemNo");
        Intrinsics.checkNotNullParameter(str2, "episodeItemName");
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        this.episodeItemNo = str;
        this.sort = i;
        this.episodeItemName = str2;
        this.seeDuration = j;
        this.videoDuration = j2;
        this.progressRate = i2;
        this.coverUrl = str3;
        this.trySee = i3;
        this.tryTime = j3;
        this.videoUrl = str4;
        this.isPlaying = z;
        this.positionType = i4;
        this.lastReportDuration = j4;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEpisodeItemNo() {
        return this.episodeItemNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getPositionType() {
        return this.positionType;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getLastReportDuration() {
        return this.lastReportDuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEpisodeItemName() {
        return this.episodeItemName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSeeDuration() {
        return this.seeDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getVideoDuration() {
        return this.videoDuration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getProgressRate() {
        return this.progressRate;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTrySee() {
        return this.trySee;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getTryTime() {
        return this.tryTime;
    }

    @NotNull
    public final EpisodeItemBean copy(@NotNull String episodeItemNo, int sort, @NotNull String episodeItemName, long seeDuration, long videoDuration, int progressRate, @NotNull String coverUrl, int trySee, long tryTime, @Nullable String videoUrl, boolean isPlaying, int positionType, long lastReportDuration) {
        Intrinsics.checkNotNullParameter(episodeItemNo, "episodeItemNo");
        Intrinsics.checkNotNullParameter(episodeItemName, "episodeItemName");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        return new EpisodeItemBean(episodeItemNo, sort, episodeItemName, seeDuration, videoDuration, progressRate, coverUrl, trySee, tryTime, videoUrl, isPlaying, positionType, lastReportDuration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeItemBean)) {
            return false;
        }
        EpisodeItemBean episodeItemBean = (EpisodeItemBean) other;
        return Intrinsics.areEqual(this.episodeItemNo, episodeItemBean.episodeItemNo) && this.sort == episodeItemBean.sort && Intrinsics.areEqual(this.episodeItemName, episodeItemBean.episodeItemName) && this.seeDuration == episodeItemBean.seeDuration && this.videoDuration == episodeItemBean.videoDuration && this.progressRate == episodeItemBean.progressRate && Intrinsics.areEqual(this.coverUrl, episodeItemBean.coverUrl) && this.trySee == episodeItemBean.trySee && this.tryTime == episodeItemBean.tryTime && Intrinsics.areEqual(this.videoUrl, episodeItemBean.videoUrl) && this.isPlaying == episodeItemBean.isPlaying && this.positionType == episodeItemBean.positionType && this.lastReportDuration == episodeItemBean.lastReportDuration;
    }

    @NotNull
    public final String formatInfo(boolean hasBuy) {
        if (!hasBuy) {
            String strH = s72.h(this.videoDuration);
            Intrinsics.checkNotNullExpressionValue(strH, "formatSecondTime(videoDuration)");
            return strH;
        }
        return s72.h(this.seeDuration) + " / " + s72.h(this.videoDuration) + "      已学习 " + this.progressRate + '%';
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getEpisodeItemName() {
        return this.episodeItemName;
    }

    @NotNull
    public final String getEpisodeItemNo() {
        return this.episodeItemNo;
    }

    public final long getLastReportDuration() {
        return this.lastReportDuration;
    }

    public final int getPositionType() {
        return this.positionType;
    }

    public final int getProgressRate() {
        return this.progressRate;
    }

    public final long getSeeDuration() {
        return this.seeDuration;
    }

    public final int getSort() {
        return this.sort;
    }

    public final int getTrySee() {
        return this.trySee;
    }

    public final long getTryTime() {
        return this.tryTime;
    }

    public final long getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.episodeItemNo.hashCode() * 31) + Integer.hashCode(this.sort)) * 31) + this.episodeItemName.hashCode()) * 31) + Long.hashCode(this.seeDuration)) * 31) + Long.hashCode(this.videoDuration)) * 31) + Integer.hashCode(this.progressRate)) * 31) + this.coverUrl.hashCode()) * 31) + Integer.hashCode(this.trySee)) * 31) + Long.hashCode(this.tryTime)) * 31;
        String str = this.videoUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isPlaying;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode2 + r1) * 31) + Integer.hashCode(this.positionType)) * 31) + Long.hashCode(this.lastReportDuration);
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setLastReportDuration(long j) {
        this.lastReportDuration = j;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public final void setPositionType(int i) {
        this.positionType = i;
    }

    public final void setProgressRate(int i) {
        this.progressRate = i;
    }

    public final void setSeeDuration(long j) {
        this.seeDuration = j;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "EpisodeItemBean(episodeItemNo=" + this.episodeItemNo + ", sort=" + this.sort + ", episodeItemName=" + this.episodeItemName + ", seeDuration=" + this.seeDuration + ", videoDuration=" + this.videoDuration + ", progressRate=" + this.progressRate + ", coverUrl=" + this.coverUrl + ", trySee=" + this.trySee + ", tryTime=" + this.tryTime + ", videoUrl=" + this.videoUrl + ", isPlaying=" + this.isPlaying + ", positionType=" + this.positionType + ", lastReportDuration=" + this.lastReportDuration + ')';
    }

    public final void updateSeeDuration(long duration) {
        long j = this.videoDuration;
        if (j <= 0) {
            j = 1;
        }
        float f = (duration * 100.0f) / j;
        if (f > this.progressRate) {
            this.progressRate = (int) f;
        }
        this.seeDuration = duration;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.episodeItemNo);
        parcel.writeInt(this.sort);
        parcel.writeString(this.episodeItemName);
        parcel.writeLong(this.seeDuration);
        parcel.writeLong(this.videoDuration);
        parcel.writeInt(this.progressRate);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.trySee);
        parcel.writeLong(this.tryTime);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.isPlaying ? 1 : 0);
        parcel.writeInt(this.positionType);
        parcel.writeLong(this.lastReportDuration);
    }

    public /* synthetic */ EpisodeItemBean(String str, int i, String str2, long j, long j2, int i2, String str3, int i3, long j3, String str4, boolean z, int i4, long j4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? 0L : j, (i5 & 16) != 0 ? 0L : j2, (i5 & 32) != 0 ? 0 : i2, (i5 & 64) == 0 ? str3 : "", (i5 & 128) != 0 ? 0 : i3, (i5 & 256) != 0 ? 0L : j3, (i5 & 512) != 0 ? null : str4, (i5 & 1024) != 0 ? false : z, (i5 & 2048) != 0 ? 0 : i4, (i5 & 4096) != 0 ? 0L : j4);
    }
}
