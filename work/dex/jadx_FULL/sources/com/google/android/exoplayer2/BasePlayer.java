package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BasePlayer implements Player {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Timeline.d f30475a = new Timeline.d();

    @Override // com.google.android.exoplayer2.Player
    public final void E(int i, g gVar) {
        addMediaItems(i, Collections.singletonList(gVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void U(g gVar, boolean z) {
        setMediaItems(Collections.singletonList(gVar), z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public final g Z() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return null;
        }
        return timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).f2199a;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void addMediaItems(List<g> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void b0(g gVar) {
        setMediaItems(Collections.singletonList(gVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean canAdvertiseSession() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void f0(g gVar) {
        addMediaItems(Collections.singletonList(gVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void g0(g gVar, long j) {
        setMediaItems(Collections.singletonList(gVar), 0, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return gj9.s((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getContentDuration() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return -9223372036854775807L;
        }
        return timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).g();
    }

    @Override // com.google.android.exoplayer2.Player
    public final long getCurrentLiveOffset() {
        Timeline timelineA0 = a0();
        if (timelineA0.w() || timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).f2202b == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (this.f30475a.d() - this.f30475a.f2202b) - getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public final Object getCurrentManifest() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return null;
        }
        return timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).f2205c;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getMediaItemCount() {
        return a0().v();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getNextMediaItemIndex() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return -1;
        }
        return timelineA0.i(getCurrentMediaItemIndex(), j0(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public final int getPreviousMediaItemIndex() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return -1;
        }
        return timelineA0.r(getCurrentMediaItemIndex(), j0(), getShuffleModeEnabled());
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCommandAvailable(int i) {
        return Q().d(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemDynamic() {
        Timeline timelineA0 = a0();
        return !timelineA0.w() && timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).f2204b;
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemLive() {
        Timeline timelineA0 = a0();
        return !timelineA0.w() && timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).k();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isCurrentMediaItemSeekable() {
        Timeline timelineA0 = a0();
        return !timelineA0.w() && timelineA0.t(getCurrentMediaItemIndex(), this.f30475a).f2201a;
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final int j0() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void k0(long j) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0L));
    }

    @Override // com.google.android.exoplayer2.Player
    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekBack() {
        k0(-getSeekBackIncrement());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekForward() {
        k0(getSeekForwardIncrement());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekTo(long j) {
        seekTo(getCurrentMediaItemIndex(), j);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentMediaItemIndex());
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToNext() {
        if (a0().w() || isPlayingAd()) {
            return;
        }
        if (hasNextMediaItem()) {
            seekToNextMediaItem();
        } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
            seekToDefaultPosition();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToNextMediaItem() {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex != -1) {
            seekToDefaultPosition(nextMediaItemIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToPrevious() {
        if (a0().w() || isPlayingAd()) {
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                seekToPreviousMediaItem();
            }
        } else if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
            seekTo(0L);
        } else {
            seekToPreviousMediaItem();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToPreviousMediaItem() {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex != -1) {
            seekToDefaultPosition(previousMediaItemIndex);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setMediaItems(List<g> list) {
        setMediaItems(list, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public final void setPlaybackSpeed(float f) {
        c(b().e(f));
    }

    @Override // com.google.android.exoplayer2.Player
    public final g v(int i) {
        return a0().t(i, this.f30475a).f2199a;
    }

    @Override // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L);
    }
}
