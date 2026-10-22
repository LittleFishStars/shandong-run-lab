package com.google.android.inner_exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.analytics.AnalyticsCollector;
import com.google.android.inner_exoplayer2.analytics.PlayerId;
import com.google.android.inner_exoplayer2.drm.DrmSession;
import com.google.android.inner_exoplayer2.metadata.Metadata;
import com.google.android.inner_exoplayer2.metadata.MetadataRenderer;
import com.google.android.inner_exoplayer2.source.BehindLiveWindowException;
import com.google.android.inner_exoplayer2.source.MediaPeriod;
import com.google.android.inner_exoplayer2.source.MediaSource;
import com.google.android.inner_exoplayer2.source.SampleStream;
import com.google.android.inner_exoplayer2.source.ShuffleOrder;
import com.google.android.inner_exoplayer2.source.TrackGroupArray;
import com.google.android.inner_exoplayer2.text.TextRenderer;
import com.google.android.inner_exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.inner_exoplayer2.trackselection.TrackSelector;
import com.google.android.inner_exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.inner_exoplayer2.upstream.BandwidthMeter;
import com.google.android.inner_exoplayer2.upstream.DataSourceException;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Clock;
import com.google.android.inner_exoplayer2.util.HandlerWrapper;
import com.google.android.inner_exoplayer2.util.Log;
import com.google.android.inner_exoplayer2.util.TraceUtil;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.zj.adlib.za3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final long PLAYBACK_BUFFER_EMPTY_THRESHOLD_US = 500000;
    private static final long PLAYBACK_STUCK_AFTER_MS = 4000;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;

    @Nullable
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;

    @Nullable
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;

    @Nullable
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private long playbackMaybeBecameStuckAtMs = -9223372036854775807L;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private final Set<Renderer> renderersToReset;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public static final class MediaSourceListUpdateMessage {
        private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder;
        }
    }

    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;

        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i != 0 ? i : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        private boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.playbackInfo = playbackInfo;
        }

        public void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public void setPlayWhenReadyChangeReason(int i) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo;
            this.playbackInfo = playbackInfo;
        }

        public void setPositionDiscontinuity(int i) {
            if (this.positionDiscontinuity && this.discontinuityReason != 5) {
                Assertions.checkArgument(i == 5);
                return;
            }
            this.hasPendingChange = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
            this.setTargetLiveOffset = z3;
        }
    }

    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z2, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2) {
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = j;
        this.setForegroundModeTimeoutMs = j;
        this.pauseAtEndOfWindow = z2;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        PlaybackInfo playbackInfoCreateDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = playbackInfoCreateDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(playbackInfoCreateDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].init(i2, playerId);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.renderersToReset = Sets.z();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.deliverPendingMessageAtStartPositionRequired = true;
        HandlerWrapper handlerWrapperCreateHandler = clock.createHandler(looper, null);
        this.queue = new MediaPeriodQueue(analyticsCollector, handlerWrapperCreateHandler);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector, handlerWrapperCreateHandler, playerId);
        if (looper2 != null) {
            this.internalPlaybackThread = null;
            this.playbackLooper = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.internalPlaybackThread = handlerThread;
            handlerThread.start();
            this.playbackLooper = handlerThread.getLooper();
        }
        this.handler = clock.createHandler(this.playbackLooper, this);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        seekToCurrentPosition(true);
    }

    private void deliverMessage(PlayerMessage playerMessage) {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void disableRenderer(Renderer renderer) {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01a2  */
    private void doSomeWork() throws ExoPlaybackException {
        boolean z;
        boolean z2;
        int i;
        long jUptimeMillis = this.clock.uptimeMillis();
        this.handler.removeMessages(2);
        updatePeriods();
        int i2 = this.playbackInfo.playbackState;
        if (i2 == 1 || i2 == 4) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(jUptimeMillis, 10L);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            z = true;
            z2 = true;
            int i3 = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i3 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i3];
                if (isRendererEnabled(renderer)) {
                    renderer.render(this.rendererPositionUs, jElapsedRealtime);
                    z = z && renderer.isEnded();
                    boolean z3 = playingPeriod.sampleStreams[i3] != renderer.getStream();
                    boolean z4 = z3 || (!z3 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z2 = z2 && z4;
                    if (!z4) {
                        renderer.maybeThrowStreamError();
                    }
                }
                i3++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z = true;
            z2 = true;
        }
        long j = playingPeriod.info.durationUs;
        boolean z5 = z && playingPeriod.prepared && (j == -9223372036854775807L || j <= this.playbackInfo.positionUs);
        if (z5 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (z5 && playingPeriod.info.isFinal) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z2)) {
            setState(3);
            this.pendingRecoverableRendererError = null;
            if (shouldPlayWhenReady()) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z2 : !isTimelineReady())) {
            this.isRebuffering = shouldPlayWhenReady();
            setState(2);
            if (this.isRebuffering) {
                notifyTrackSelectionRebuffer();
                this.livePlaybackSpeedControl.notifyRebuffer();
            }
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            int i4 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.renderers;
                if (i4 >= rendererArr2.length) {
                    break;
                }
                if (isRendererEnabled(rendererArr2[i4]) && this.renderers[i4].getStream() == playingPeriod.sampleStreams[i4]) {
                    this.renderers[i4].maybeThrowStreamError();
                }
                i4++;
            }
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (playbackInfo.isLoading || playbackInfo.totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US || !isLoadingPossible()) {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            } else if (this.playbackMaybeBecameStuckAtMs == -9223372036854775807L) {
                this.playbackMaybeBecameStuckAtMs = this.clock.elapsedRealtime();
            } else if (this.clock.elapsedRealtime() - this.playbackMaybeBecameStuckAtMs >= 4000) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        } else {
            this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
        }
        boolean z6 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z7 = this.offloadSchedulingEnabled && this.requestForRendererSleep && z6;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.sleepingForOffload != z7) {
            this.playbackInfo = playbackInfo2.copyWithSleepingForOffload(z7);
        }
        this.requestForRendererSleep = false;
        if (!z7 && (i = this.playbackInfo.playbackState) != 4) {
            if (z6 || i == 2) {
                scheduleNextWork(jUptimeMillis, 10L);
            } else if (i == 3 && this.enabledRendererCount != 0) {
                scheduleNextWork(jUptimeMillis, 1000L);
            }
        }
        TraceUtil.endSection();
    }

    private void enableRenderer(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i];
        if (isRendererEnabled(renderer)) {
            return;
        }
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z2 = readingPeriod == this.queue.getPlayingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
        Format[] formats = getFormats(trackSelectorResult.selections[i]);
        boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
        boolean z4 = !z && z3;
        this.enabledRendererCount++;
        this.renderersToReset.add(renderer);
        renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i], this.rendererPositionUs, z4, z2, readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
        renderer.handleMessage(11, new Renderer.WakeupListener() { // from class: com.google.android.inner_exoplayer2.ExoPlayerImplInternal.1
            @Override // com.google.android.inner_exoplayer2.Renderer.WakeupListener
            public void onSleep() {
                ExoPlayerImplInternal.this.requestForRendererSleep = true;
            }

            @Override // com.google.android.inner_exoplayer2.Renderer.WakeupListener
            public void onWakeup() {
                ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
            }
        });
        this.mediaClock.onRendererEnabled(renderer);
        if (z3) {
            renderer.start();
        }
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.e() : ImmutableList.of();
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return getLiveOffsetUs(playbackInfo.timeline, playbackInfo.periodId.periodUid, playbackInfo.positionUs);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = exoTrackSelection.getFormat(i);
        }
        return formatArr;
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        Timeline.Window window = this.window;
        if (window.windowStartTimeMs != -9223372036854775807L && window.isLive()) {
            Timeline.Window window2 = this.window;
            if (window2.isDynamic) {
                return Util.msToUs(window2.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j + this.period.getPositionInWindowUs());
            }
        }
        return -9223372036854775807L;
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0L;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPositionUs(Timeline timeline) {
        long adResumePositionUs = 0;
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, periodPositionUs.first, 0L);
        long jLongValue = ((Long) periodPositionUs.second).longValue();
        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
            if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex)) {
                adResumePositionUs = this.period.getAdResumePositionUs();
            }
        } else {
            adResumePositionUs = jLongValue;
        }
        return Pair.create(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, Long.valueOf(adResumePositionUs));
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handleIoException(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(playingPeriod.info.id);
        }
        Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForSource);
        stopInternal(false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForSource);
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    /* JADX WARN: Code duplicated, block: B:64:0x010d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0110  */
    /* JADX WARN: Code duplicated, block: B:69:0x0138  */
    /* JADX WARN: Code duplicated, block: B:78:0x0153  */
    /* JADX WARN: Code duplicated, block: B:83:0x0170  */
    /* JADX WARN: Code duplicated, block: B:85:0x017a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:91:0x018f  */
    /* JADX WARN: Code duplicated, block: B:94:0x019b  */
    /* JADX WARN: Code duplicated, block: B:95:0x019e  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c6  */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x0141: MOVE (r5 I:??[long, double]) = (r25 I:??[long, double]), block:B:73:0x0140 */
    private void handleMediaSourceListInfoRefreshed(Timeline timeline, boolean z) throws Throwable {
        int i;
        long j;
        Object obj;
        boolean z2;
        int i2;
        long j2;
        long j3;
        long jSeekToPeriodPosition;
        long j4;
        Object obj2;
        boolean z3;
        int i3;
        PositionUpdateForPlaylistChange positionUpdateForPlaylistChangeResolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodId;
        long j5 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z4 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.forceBufferingState;
        long j6 = positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.periodPositionUs;
        int i4 = 1;
        boolean z5 = (this.playbackInfo.periodId.equals(mediaPeriodId) && j6 == this.playbackInfo.positionUs) ? false : true;
        try {
            if (positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.endPlayback) {
                if (this.playbackInfo.playbackState != 1) {
                    setState(4);
                }
                resetInternal(false, false, false, true);
            }
            try {
                if (z5) {
                    i = 4;
                    j3 = j6;
                    i4 = -1;
                    if (timeline.isEmpty()) {
                        jSeekToPeriodPosition = j3;
                    } else {
                        try {
                            for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                                if (playingPeriod.info.id.equals(mediaPeriodId)) {
                                    playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline, playingPeriod.info);
                                    playingPeriod.updateClipping();
                                }
                            }
                            j6 = j3;
                            try {
                                jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, j6, z4);
                            } catch (Throwable th) {
                                th = th;
                                PlaybackInfo playbackInfo = this.playbackInfo;
                                j = j6;
                                updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, playbackInfo.timeline, playbackInfo.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? j6 : -9223372036854775807L, false);
                                if (z5) {
                                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                                    obj = playbackInfo2.periodId.periodUid;
                                    Timeline timeline2 = playbackInfo2.timeline;
                                    if (z5) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    long j7 = this.playbackInfo.discontinuityStartPositionUs;
                                    if (timeline.getIndexOfPeriod(obj) == i4) {
                                        i2 = i;
                                    } else {
                                        i2 = 3;
                                    }
                                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, j5, j7, z2, i2);
                                } else {
                                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                                    obj = playbackInfo3.periodId.periodUid;
                                    Timeline timeline3 = playbackInfo3.timeline;
                                    if (z5) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    long j8 = this.playbackInfo.discontinuityStartPositionUs;
                                    if (timeline.getIndexOfPeriod(obj) == i4) {
                                        i2 = i;
                                    } else {
                                        i2 = 3;
                                    }
                                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, j5, j8, z2, i2);
                                }
                                resetPendingPauseAtEndOfPeriod();
                                resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                                if (!timeline.isEmpty()) {
                                    this.pendingInitialSeekPosition = 0;
                                }
                                handleLoadingMediaPeriodChanged(false);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j6 = j3;
                        }
                    }
                    PlaybackInfo playbackInfo4 = this.playbackInfo;
                    Timeline timeline4 = playbackInfo4.timeline;
                    MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo4.periodId;
                    if (positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset) {
                        j4 = jSeekToPeriodPosition;
                    } else {
                        j4 = -9223372036854775807L;
                    }
                    updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, timeline4, mediaPeriodId2, j4, false);
                    if (z5) {
                        PlaybackInfo playbackInfo5 = this.playbackInfo;
                        obj2 = playbackInfo5.periodId.periodUid;
                        Timeline timeline5 = playbackInfo5.timeline;
                        if (z5) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        long j9 = this.playbackInfo.discontinuityStartPositionUs;
                        if (timeline.getIndexOfPeriod(obj2) == i4) {
                            i3 = i;
                        } else {
                            i3 = 3;
                        }
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j5, j9, z3, i3);
                    } else {
                        PlaybackInfo playbackInfo6 = this.playbackInfo;
                        obj2 = playbackInfo6.periodId.periodUid;
                        Timeline timeline6 = playbackInfo6.timeline;
                        if (z5) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                        long j10 = this.playbackInfo.discontinuityStartPositionUs;
                        if (timeline.getIndexOfPeriod(obj2) == i4) {
                            i3 = i;
                        } else {
                            i3 = 3;
                        }
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j5, j10, z3, i3);
                    }
                    resetPendingPauseAtEndOfPeriod();
                    resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                    this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                    if (!timeline.isEmpty()) {
                        this.pendingInitialSeekPosition = null;
                    }
                    handleLoadingMediaPeriodChanged(false);
                }
                try {
                    try {
                        i4 = -1;
                        i = 4;
                        j3 = j6;
                        if (!this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, getMaxRendererReadPositionUs())) {
                            seekToCurrentPosition(false);
                        }
                        jSeekToPeriodPosition = j3;
                        PlaybackInfo playbackInfo7 = this.playbackInfo;
                        Timeline timeline7 = playbackInfo7.timeline;
                        MediaSource.MediaPeriodId mediaPeriodId3 = playbackInfo7.periodId;
                        if (positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset) {
                            j4 = jSeekToPeriodPosition;
                        } else {
                            j4 = -9223372036854775807L;
                        }
                        updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, timeline7, mediaPeriodId3, j4, false);
                        if (z5 || j5 != this.playbackInfo.requestedContentPositionUs) {
                            PlaybackInfo playbackInfo8 = this.playbackInfo;
                            obj2 = playbackInfo8.periodId.periodUid;
                            Timeline timeline8 = playbackInfo8.timeline;
                            if (z5 || !z || timeline8.isEmpty() || timeline8.getPeriodByUid(obj2, this.period).isPlaceholder) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            long j11 = this.playbackInfo.discontinuityStartPositionUs;
                            if (timeline.getIndexOfPeriod(obj2) == i4) {
                                i3 = i;
                            } else {
                                i3 = 3;
                            }
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, j5, j11, z3, i3);
                        }
                        resetPendingPauseAtEndOfPeriod();
                        resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                        if (!timeline.isEmpty()) {
                            this.pendingInitialSeekPosition = null;
                        }
                        handleLoadingMediaPeriodChanged(false);
                    } catch (Throwable th3) {
                        th = th3;
                        i4 = -1;
                        i = 4;
                        PlaybackInfo playbackInfo9 = this.playbackInfo;
                        j = j6;
                        updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, playbackInfo9.timeline, playbackInfo9.periodId, positionUpdateForPlaylistChangeResolvePositionForPlaylistChange.setTargetLiveOffset ? j6 : -9223372036854775807L, false);
                        if (z5 || j5 != this.playbackInfo.requestedContentPositionUs) {
                            PlaybackInfo playbackInfo10 = this.playbackInfo;
                            obj = playbackInfo10.periodId.periodUid;
                            Timeline timeline9 = playbackInfo10.timeline;
                            if (z5 || !z || timeline9.isEmpty() || timeline9.getPeriodByUid(obj, this.period).isPlaceholder) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            long j12 = this.playbackInfo.discontinuityStartPositionUs;
                            if (timeline.getIndexOfPeriod(obj) == i4) {
                                i2 = i;
                            } else {
                                i2 = 3;
                            }
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, j5, j12, z2, i2);
                        }
                        resetPendingPauseAtEndOfPeriod();
                        resolvePendingMessagePositions(timeline, this.playbackInfo.timeline);
                        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline);
                        if (!timeline.isEmpty()) {
                            this.pendingInitialSeekPosition = 0;
                        }
                        handleLoadingMediaPeriodChanged(false);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i = 4;
                    i4 = -1;
                }
            } catch (Throwable th5) {
                th = th5;
                j6 = j2;
            }
        } catch (Throwable th6) {
            th = th6;
            i = 4;
            i4 = -1;
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                PlaybackInfo playbackInfo = this.playbackInfo;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
                long j = loadingPeriod.info.startPositionUs;
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, playbackInfo.requestedContentPositionUs, j, false, 5);
            }
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z) {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z);
    }

    @CheckResult
    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        List<Metadata> listOf;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        this.deliverPendingMessageAtStartPositionRequired = (!this.deliverPendingMessageAtStartPositionRequired && j == this.playbackInfo.positionUs && mediaPeriodId.equals(this.playbackInfo.periodId)) ? false : true;
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo = this.playbackInfo;
        TrackGroupArray trackGroupArray2 = playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.trackSelectorResult;
        List<Metadata> list = playbackInfo.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            TrackGroupArray trackGroups = playingPeriod == null ? TrackGroupArray.EMPTY : playingPeriod.getTrackGroups();
            TrackSelectorResult trackSelectorResult3 = playingPeriod == null ? this.emptyTrackSelectorResult : playingPeriod.getTrackSelectorResult();
            ImmutableList<Metadata> immutableListExtractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult3.selections);
            if (playingPeriod != null) {
                MediaPeriodInfo mediaPeriodInfo = playingPeriod.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j2) {
                    playingPeriod.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j2);
                }
            }
            trackGroupArray = trackGroups;
            trackSelectorResult = trackSelectorResult3;
            listOf = immutableListExtractMetadataFromTrackSelectionArray;
        } else if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
            listOf = list;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.emptyTrackSelectorResult;
            listOf = ImmutableList.of();
        }
        if (z) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, j3, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, listOf);
    }

    private boolean hasReachedServerSideInsertedAdsTransition(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        return mediaPeriodHolder.info.isFollowedByTransitionToSameStream && next.prepared && ((renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.getReadingPositionUs() >= next.getStartPositionRendererTime());
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd() && !hasReachedServerSideInsertedAdsTransition(renderer, readingPeriod))) {
                return false;
            }
            i++;
        }
    }

    private static boolean isIgnorableServerSideAdInsertionPeriodChange(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j2) {
        if (z || j != j2 || !mediaPeriodId.periodUid.equals(mediaPeriodId2.periodUid)) {
            return false;
        }
        if (mediaPeriodId.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex)) {
            return (period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 4 || period.getAdState(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup) == 2) ? false : true;
        }
        return mediaPeriodId2.isAd() && period.isServerSideInsertedAdGroup(mediaPeriodId2.adGroupIndex);
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady());
    }

    private static boolean isUsingPlaceholderPeriod(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        Timeline timeline = playbackInfo.timeline;
        return timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period).isPlaceholder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$release$0() {
        return Boolean.valueOf(this.released);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageToTargetThread$1(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void maybeContinueLoading() {
        boolean zShouldContinueLoading = shouldContinueLoading();
        this.shouldContinueLoading = zShouldContinueLoading;
        if (zShouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void maybeTriggerPendingMessages(long j, long j2) {
        ExoPlayerImplInternal exoPlayerImplInternal;
        PendingMessageInfo pendingMessageInfo;
        if (this.pendingMessages.isEmpty() || this.playbackInfo.periodId.isAd()) {
            return;
        }
        if (this.deliverPendingMessageAtStartPositionRequired) {
            j--;
            this.deliverPendingMessageAtStartPositionRequired = false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        int indexOfPeriod = playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
        int iMin = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
        PendingMessageInfo pendingMessageInfo2 = iMin > 0 ? this.pendingMessages.get(iMin - 1) : null;
        while (pendingMessageInfo2 != null) {
            int i = pendingMessageInfo2.resolvedPeriodIndex;
            if (i <= indexOfPeriod && (i != indexOfPeriod || pendingMessageInfo2.resolvedPeriodTimeUs <= j)) {
                break;
            }
            int i2 = iMin - 1;
            pendingMessageInfo2 = i2 > 0 ? this.pendingMessages.get(iMin - 2) : null;
            iMin = i2;
        }
        if (iMin < this.pendingMessages.size()) {
            pendingMessageInfo = this.pendingMessages.get(iMin);
            exoPlayerImplInternal = this;
        } else {
            exoPlayerImplInternal = this;
            pendingMessageInfo = null;
        }
        while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null) {
            int i3 = pendingMessageInfo.resolvedPeriodIndex;
            if (i3 >= indexOfPeriod && (i3 != indexOfPeriod || pendingMessageInfo.resolvedPeriodTimeUs > j)) {
                break;
            }
            iMin++;
            if (iMin < exoPlayerImplInternal.pendingMessages.size()) {
                pendingMessageInfo = exoPlayerImplInternal.pendingMessages.get(iMin);
            } else {
                exoPlayerImplInternal = exoPlayerImplInternal;
                pendingMessageInfo = null;
            }
        }
        while (pendingMessageInfo != null && pendingMessageInfo.resolvedPeriodUid != null && pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod) {
            long j3 = pendingMessageInfo.resolvedPeriodTimeUs;
            if (j3 <= j || j3 > j2) {
                break;
            }
            try {
                exoPlayerImplInternal.sendMessageToTarget(pendingMessageInfo.message);
                if (pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                    exoPlayerImplInternal.pendingMessages.remove(iMin);
                } else {
                    iMin++;
                }
                pendingMessageInfo = iMin < exoPlayerImplInternal.pendingMessages.size() ? exoPlayerImplInternal.pendingMessages.get(iMin) : null;
            } catch (Throwable th) {
                if (pendingMessageInfo.message.getDeleteAfterDelivery() || pendingMessageInfo.message.isCanceled()) {
                    exoPlayerImplInternal.pendingMessages.remove(iMin);
                }
                throw th;
            }
        }
        exoPlayerImplInternal.nextPendingMessageIndexHint = iMin;
    }

    private void maybeUpdateLoadingPeriod() {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder mediaPeriodHolderEnqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
            mediaPeriodHolderEnqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == mediaPeriodHolderEnqueueNextMediaPeriodHolder) {
                resetRendererPosition(nextMediaPeriodInfo.startPositionUs);
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (!this.shouldContinueLoading) {
            maybeContinueLoading();
        } else {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    private void maybeUpdatePlayingPeriod() {
        boolean z;
        boolean z2 = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z2) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkNotNull(this.queue.advancePlayingPeriod());
            if (this.playbackInfo.periodId.periodUid.equals(mediaPeriodHolder.info.id.periodUid)) {
                MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
                if (mediaPeriodId.adGroupIndex == -1) {
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodHolder.info.id;
                    if (mediaPeriodId2.adGroupIndex != -1 || mediaPeriodId.nextAdGroupIndex == mediaPeriodId2.nextAdGroupIndex) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodInfo.id;
            long j = mediaPeriodInfo.startPositionUs;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId3, j, mediaPeriodInfo.requestedContentPositionUs, j, !z, 0);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z2 = true;
        }
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return;
        }
        int i = 0;
        if (readingPeriod.getNext() != null && !this.pendingPauseAtEndOfPeriod) {
            if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.getTrackSelectorResult();
                    Timeline timeline = this.playbackInfo.timeline;
                    updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodHolderAdvanceReadingPeriod.info.id, timeline, readingPeriod.info.id, -9223372036854775807L, false);
                    if (mediaPeriodHolderAdvanceReadingPeriod.prepared && mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
                        setAllRendererStreamsFinal(mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                        return;
                    }
                    for (int i2 = 0; i2 < this.renderers.length; i2++) {
                        boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                        boolean zIsRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                        if (zIsRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                            boolean z = this.rendererCapabilities[i2].getTrackType() == -2;
                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                            if (!zIsRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                setCurrentStreamFinal(this.renderers[i2], mediaPeriodHolderAdvanceReadingPeriod.getStartPositionRendererTime());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!readingPeriod.info.isFinal && !this.pendingPauseAtEndOfPeriod) {
            return;
        }
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                long j = readingPeriod.info.durationUs;
                setCurrentStreamFinal(renderer, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
            }
            i++;
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null || this.queue.getPlayingPeriod() == readingPeriod || readingPeriod.allRenderersInCorrectState || !replaceStreamsOrDisableRendererForTransition()) {
            return;
        }
        enableRenderers();
    }

    private void mediaSourceListUpdateRequestedInternal() throws Throwable {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z);
                }
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        this.loadControl.onReleased();
        setState(1);
        HandlerThread handlerThread = this.internalPlaybackThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder), false);
    }

    private boolean replaceStreamsOrDisableRendererForTransition() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i]), readingPeriod.sampleStreams[i], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.getNext()) {
            TrackSelectorResult trackSelectorResultSelectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline);
            if (!trackSelectorResultSelectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (z) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long jApplyTrackSelection = playingPeriod2.applyTrackSelection(trackSelectorResultSelectTracks, this.playbackInfo.positionUs, zRemoveAfter, zArr);
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    boolean z2 = (playbackInfo.playbackState == 4 || jApplyTrackSelection == playbackInfo.positionUs) ? false : true;
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    this.playbackInfo = handlePositionDiscontinuity(playbackInfo2.periodId, jApplyTrackSelection, playbackInfo2.requestedContentPositionUs, playbackInfo2.discontinuityStartPositionUs, z2, 5);
                    if (z2) {
                        resetRendererPosition(jApplyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        boolean zIsRendererEnabled = isRendererEnabled(renderer);
                        zArr2[i] = zIsRendererEnabled;
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i];
                        if (zIsRendererEnabled) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    enableRenderers(zArr2);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(trackSelectorResultSelectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a2 A[PHI: r4 r5 r7
      0x00a2: PHI (r4v3 com.google.android.inner_exoplayer2.source.MediaSource$MediaPeriodId) = 
      (r4v2 com.google.android.inner_exoplayer2.source.MediaSource$MediaPeriodId)
      (r4v9 com.google.android.inner_exoplayer2.source.MediaSource$MediaPeriodId)
     binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    private void resetInternal(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        this.handler.removeMessages(2);
        this.pendingRecoverableRendererError = null;
        this.isRebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 1000000000000L;
        for (Renderer renderer : this.renderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z) {
            for (Renderer renderer2 : this.renderers) {
                if (this.renderersToReset.remove(renderer2)) {
                    try {
                        renderer2.reset();
                    } catch (RuntimeException e2) {
                        Log.e("ExoPlayerImplInternal", "Reset failed.", e2);
                    }
                }
            }
        }
        this.enabledRendererCount = 0;
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        long jLongValue = playbackInfo.positionUs;
        long j = (this.playbackInfo.periodId.isAd() || isUsingPlaceholderPeriod(this.playbackInfo, this.period)) ? this.playbackInfo.requestedContentPositionUs : this.playbackInfo.positionUs;
        if (z2) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            j = -9223372036854775807L;
            if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                z5 = false;
            } else {
                z5 = true;
            }
        } else {
            z5 = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j2 = jLongValue;
        this.queue.clear();
        this.shouldContinueLoading = false;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        Timeline timeline = playbackInfo2.timeline;
        int i = playbackInfo2.playbackState;
        ExoPlaybackException exoPlaybackException = z4 ? null : playbackInfo2.playbackError;
        TrackGroupArray trackGroupArray = z5 ? TrackGroupArray.EMPTY : playbackInfo2.trackGroups;
        TrackSelectorResult trackSelectorResult = z5 ? this.emptyTrackSelectorResult : playbackInfo2.trackSelectorResult;
        List listOf = z5 ? ImmutableList.of() : playbackInfo2.staticMetadata;
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        this.playbackInfo = new PlaybackInfo(timeline, mediaPeriodId2, j, j2, i, exoPlaybackException, false, trackGroupArray, trackSelectorResult, listOf, mediaPeriodId2, playbackInfo3.playWhenReady, playbackInfo3.playbackSuppressionReason, playbackInfo3.playbackParameters, j2, 0L, j2, false);
        if (z3) {
            this.mediaSourceList.release();
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private void resetRendererPosition(long j) {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long rendererTime = playingPeriod == null ? j + 1000000000000L : playingPeriod.toRendererTime(j);
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, window).lastPeriodIndex;
        Object obj = timeline.getPeriod(i, period, true).uid;
        long j = period.durationUs;
        pendingMessageInfo.setResolvedPosition(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getMediaItemIndex(), pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : Util.msToUs(pendingMessageInfo.message.getPositionMs())), false, i, z, window, period);
            if (pairResolveSeekPositionUs == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(pairResolveSeekPositionUs.first), ((Long) pairResolveSeekPositionUs.second).longValue(), pairResolveSeekPositionUs.first);
            if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            }
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline, pendingMessageInfo, window, period);
            return true;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        timeline2.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period);
        if (period.isPlaceholder && timeline2.getWindow(period.windowIndex, window).firstPeriodIndex == timeline2.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid)) {
            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period).windowIndex, pendingMessageInfo.resolvedPeriodTimeUs + period.getPositionInWindowUs());
            pendingMessageInfo.setResolvedPosition(timeline.getIndexOfPeriod(periodPositionUs.first), ((Long) periodPositionUs.second).longValue(), periodPositionUs.first);
        }
        return true;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (timeline.isEmpty() && timeline2.isEmpty()) {
            return;
        }
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0158  */
    /* JADX WARN: Code duplicated, block: B:50:0x0176  */
    /* JADX WARN: Code duplicated, block: B:53:0x0182  */
    /* JADX WARN: Code duplicated, block: B:58:0x018c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0196  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:79:0x01da  */
    /* JADX WARN: Code duplicated, block: B:80:0x01df  */
    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, @Nullable SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId;
        int i2;
        int firstWindowIndex;
        boolean z2;
        long jLongValue;
        int firstWindowIndex2;
        boolean z3;
        boolean z4;
        boolean z5;
        int firstWindowIndex3;
        long j;
        MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
        int i3;
        boolean z6;
        boolean z7;
        MediaSource.MediaPeriodId mediaPeriodId2;
        int i4;
        int i5;
        boolean z8;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId3 = playbackInfo.periodId;
        Object obj = mediaPeriodId3.periodUid;
        boolean zIsUsingPlaceholderPeriod = isUsingPlaceholderPeriod(playbackInfo, period);
        long j2 = (playbackInfo.periodId.isAd() || zIsUsingPlaceholderPeriod) ? playbackInfo.requestedContentPositionUs : playbackInfo.positionUs;
        if (seekPosition != null) {
            mediaPeriodId = mediaPeriodId3;
            i2 = -1;
            Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(timeline, seekPosition, true, i, z, window, period);
            if (pairResolveSeekPositionUs == null) {
                firstWindowIndex2 = timeline.getFirstWindowIndex(z);
                jLongValue = j2;
                z3 = false;
                z5 = false;
                z4 = true;
            } else {
                if (seekPosition.windowPositionUs == -9223372036854775807L) {
                    i5 = timeline.getPeriodByUid(pairResolveSeekPositionUs.first, period).windowIndex;
                    jLongValue = j2;
                    z8 = false;
                } else {
                    obj = pairResolveSeekPositionUs.first;
                    jLongValue = ((Long) pairResolveSeekPositionUs.second).longValue();
                    i5 = -1;
                    z8 = true;
                }
                z5 = z8;
                if (playbackInfo.playbackState == 4) {
                    firstWindowIndex2 = i5;
                    z4 = false;
                    z3 = true;
                } else {
                    firstWindowIndex2 = i5;
                    z3 = false;
                    z4 = false;
                }
            }
        } else {
            mediaPeriodId = mediaPeriodId3;
            i2 = -1;
            if (!playbackInfo.timeline.isEmpty()) {
                if (timeline.getIndexOfPeriod(obj) != -1) {
                    if (j2 == -9223372036854775807L) {
                        firstWindowIndex3 = timeline.getPeriodByUid(obj, period).windowIndex;
                    } else if (zIsUsingPlaceholderPeriod) {
                        mediaPeriodId = mediaPeriodId;
                        playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
                        if (playbackInfo.timeline.getWindow(period.windowIndex, window).firstPeriodIndex == playbackInfo.timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
                            Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(obj, period).windowIndex, j2 + period.getPositionInWindowUs());
                            obj = periodPositionUs.first;
                            jLongValue = ((Long) periodPositionUs.second).longValue();
                        } else {
                            jLongValue = j2;
                        }
                        firstWindowIndex2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        firstWindowIndex = -1;
                        z2 = false;
                    }
                    if (firstWindowIndex2 != i2) {
                        Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(window, period, firstWindowIndex2, -9223372036854775807L);
                        obj = periodPositionUs2.first;
                        jLongValue = ((Long) periodPositionUs2.second).longValue();
                        j = -9223372036854775807L;
                    } else {
                        j = jLongValue;
                    }
                    mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, obj, jLongValue);
                    i3 = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex;
                    if (i3 != i2 || ((i4 = mediaPeriodId.nextAdGroupIndex) != i2 && i3 >= i4)) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = (mediaPeriodId.periodUid.equals(obj) || mediaPeriodId.isAd() || mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd() || !z6) ? false : true;
                    mediaPeriodId2 = mediaPeriodId;
                    boolean zIsIgnorableServerSideAdInsertionPeriodChange = isIgnorableServerSideAdInsertionPeriodChange(zIsUsingPlaceholderPeriod, mediaPeriodId, j2, mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, timeline.getPeriodByUid(obj, period), j);
                    if (z7 || zIsIgnorableServerSideAdInsertionPeriodChange) {
                        mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId2;
                    }
                    if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaPeriodId2)) {
                            jLongValue = playbackInfo.positionUs;
                        } else {
                            timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period);
                            if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex)) {
                                jLongValue = period.getAdResumePositionUs();
                            } else {
                                jLongValue = 0;
                            }
                        }
                    }
                    return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jLongValue, j, z3, z4, z5);
                }
                Object objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z, obj, playbackInfo.timeline, timeline);
                if (objResolveSubsequentPeriod == null) {
                    firstWindowIndex = timeline.getFirstWindowIndex(z);
                    z2 = true;
                } else {
                    firstWindowIndex = timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex;
                    z2 = false;
                }
                firstWindowIndex2 = firstWindowIndex;
                z4 = z2;
                jLongValue = j2;
                z3 = false;
                z5 = false;
                if (firstWindowIndex2 != i2) {
                    Pair<Object, Long> periodPositionUs3 = timeline.getPeriodPositionUs(window, period, firstWindowIndex2, -9223372036854775807L);
                    obj = periodPositionUs3.first;
                    jLongValue = ((Long) periodPositionUs3.second).longValue();
                    j = -9223372036854775807L;
                } else {
                    j = jLongValue;
                }
                mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, obj, jLongValue);
                i3 = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex;
                if (i3 != i2) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (mediaPeriodId.periodUid.equals(obj)) {
                }
                mediaPeriodId2 = mediaPeriodId;
                boolean zIsIgnorableServerSideAdInsertionPeriodChange2 = isIgnorableServerSideAdInsertionPeriodChange(zIsUsingPlaceholderPeriod, mediaPeriodId, j2, mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, timeline.getPeriodByUid(obj, period), j);
                if (z7) {
                    mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId2;
                } else {
                    mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId2;
                }
                if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                    if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaPeriodId2)) {
                        jLongValue = playbackInfo.positionUs;
                    } else {
                        timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period);
                        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex)) {
                            jLongValue = period.getAdResumePositionUs();
                        } else {
                            jLongValue = 0;
                        }
                    }
                }
                return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jLongValue, j, z3, z4, z5);
            }
            firstWindowIndex3 = timeline.getFirstWindowIndex(z);
            firstWindowIndex2 = firstWindowIndex3;
            jLongValue = j2;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        mediaPeriodId = mediaPeriodId;
        if (firstWindowIndex2 != i2) {
            Pair<Object, Long> periodPositionUs4 = timeline.getPeriodPositionUs(window, period, firstWindowIndex2, -9223372036854775807L);
            obj = periodPositionUs4.first;
            jLongValue = ((Long) periodPositionUs4.second).longValue();
            j = -9223372036854775807L;
        } else {
            j = jLongValue;
        }
        mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodQueue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(timeline, obj, jLongValue);
        i3 = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.nextAdGroupIndex;
        if (i3 != i2) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (mediaPeriodId.periodUid.equals(obj)) {
        }
        mediaPeriodId2 = mediaPeriodId;
        boolean zIsIgnorableServerSideAdInsertionPeriodChange3 = isIgnorableServerSideAdInsertionPeriodChange(zIsUsingPlaceholderPeriod, mediaPeriodId, j2, mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, timeline.getPeriodByUid(obj, period), j);
        if (z7) {
            mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId2;
        } else {
            mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = mediaPeriodId2;
        }
        if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
            if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.equals(mediaPeriodId2)) {
                jLongValue = playbackInfo.positionUs;
            } else {
                timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, period);
                if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup == period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex)) {
                    jLongValue = period.getAdResumePositionUs();
                } else {
                    jLongValue = 0;
                }
            }
        }
        return new PositionUpdateForPlaylistChange(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange, jLongValue, j, z3, z4, z5);
    }

    @Nullable
    private static Pair<Object, Long> resolveSeekPositionUs(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window, Timeline.Period period) {
        Object objResolveSubsequentPeriod;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline3 = timeline2.isEmpty() ? timeline : timeline2;
        try {
            Pair<Object, Long> periodPositionUs = timeline3.getPeriodPositionUs(window, period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline.equals(timeline3)) {
                return periodPositionUs;
            }
            if (timeline.getIndexOfPeriod(periodPositionUs.first) != -1) {
                return (timeline3.getPeriodByUid(periodPositionUs.first, period).isPlaceholder && timeline3.getWindow(period.windowIndex, window).firstPeriodIndex == timeline3.getIndexOfPeriod(periodPositionUs.first)) ? timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(periodPositionUs.first, period).windowIndex, seekPosition.windowPositionUs) : periodPositionUs;
            }
            if (z && (objResolveSubsequentPeriod = resolveSubsequentPeriod(window, period, i, z2, periodPositionUs.first, timeline3, timeline)) != null) {
                return timeline.getPeriodPositionUs(window, period, timeline.getPeriodByUid(objResolveSubsequentPeriod, period).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object resolveSubsequentPeriod(Timeline.Window window, Timeline.Period period, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i2 = 0; i2 < periodCount && indexOfPeriod2 == -1; i2++) {
            nextPeriodIndex = timeline.getNextPeriodIndex(nextPeriodIndex, period, window, i, z);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(indexOfPeriod2);
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, jSeekToPeriodPosition, playbackInfo.requestedContentPositionUs, playbackInfo.discontinuityStartPositionUs, z, 5);
        }
    }

    private void seekToInternal(SeekPosition seekPosition) throws Throwable {
        long j;
        long j2;
        boolean z;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j3;
        long adjustedSeekPositionUs;
        long j4;
        PlaybackInfo playbackInfo;
        int i;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Object, Long> pairResolveSeekPositionUs = resolveSeekPositionUs(this.playbackInfo.timeline, seekPosition, true, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        if (pairResolveSeekPositionUs == null) {
            Pair<MediaSource.MediaPeriodId, Long> placeholderFirstMediaPeriodPositionUs = getPlaceholderFirstMediaPeriodPositionUs(this.playbackInfo.timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) placeholderFirstMediaPeriodPositionUs.first;
            long jLongValue = ((Long) placeholderFirstMediaPeriodPositionUs.second).longValue();
            z = !this.playbackInfo.timeline.isEmpty();
            j = jLongValue;
            j2 = -9223372036854775807L;
        } else {
            Object obj = pairResolveSeekPositionUs.first;
            long jLongValue2 = ((Long) pairResolveSeekPositionUs.second).longValue();
            long j5 = seekPosition.windowPositionUs == -9223372036854775807L ? -9223372036854775807L : jLongValue2;
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange = this.queue.resolveMediaPeriodIdForAdsAfterPeriodPositionChange(this.playbackInfo.timeline, obj, jLongValue2);
            if (mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.isAd()) {
                this.playbackInfo.timeline.getPeriodByUid(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.periodUid, this.period);
                jLongValue2 = this.period.getFirstAdIndexToPlay(mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adGroupIndex) == mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange.adIndexInAdGroup ? this.period.getAdResumePositionUs() : 0L;
            } else if (seekPosition.windowPositionUs != -9223372036854775807L) {
                j = jLongValue2;
                j2 = j5;
                z = false;
                mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
            }
            j = jLongValue2;
            j2 = j5;
            mediaPeriodId = mediaPeriodIdResolveMediaPeriodIdForAdsAfterPeriodPositionChange;
            z = true;
        }
        try {
            if (!this.playbackInfo.timeline.isEmpty()) {
                if (pairResolveSeekPositionUs == null) {
                    if (this.playbackInfo.playbackState != 1) {
                        setState(4);
                    }
                    resetInternal(false, true, false, true);
                } else {
                    if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                        adjustedSeekPositionUs = (playingPeriod == null || !playingPeriod.prepared || j == 0) ? j : playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(j, this.seekParameters);
                        if (Util.usToMs(adjustedSeekPositionUs) == Util.usToMs(this.playbackInfo.positionUs) && ((i = (playbackInfo = this.playbackInfo).playbackState) == 2 || i == 3)) {
                            long j6 = playbackInfo.positionUs;
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j6, j2, j6, z, 2);
                            return;
                        }
                    } else {
                        adjustedSeekPositionUs = j;
                    }
                    long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, adjustedSeekPositionUs, this.playbackInfo.playbackState == 4);
                    z |= j != jSeekToPeriodPosition;
                    try {
                        PlaybackInfo playbackInfo2 = this.playbackInfo;
                        Timeline timeline = playbackInfo2.timeline;
                        updatePlaybackSpeedSettingsForNewPeriod(timeline, mediaPeriodId, timeline, playbackInfo2.periodId, j2, true);
                        j4 = jSeekToPeriodPosition;
                    } catch (Throwable th) {
                        th = th;
                        j3 = jSeekToPeriodPosition;
                        this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j2, j3, z, 2);
                        throw th;
                    }
                }
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j4, j2, j4, z, 2);
            }
            this.pendingInitialSeekPosition = seekPosition;
            j4 = j;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j4, j2, j4, z, 2);
        } catch (Throwable th2) {
            th = th2;
            j3 = j;
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    private void sendMessageInternal(PlayerMessage playerMessage) {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        Timeline timeline = this.playbackInfo.timeline;
        if (!resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
            playerMessage.markAsProcessed(false);
        } else {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) {
        if (playerMessage.getLooper() != this.playbackLooper) {
            this.handler.obtainMessage(15, playerMessage).sendToTarget();
            return;
        }
        deliverMessage(playerMessage);
        int i = this.playbackInfo.playbackState;
        if (i == 3 || i == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (looper.getThread().isAlive()) {
            this.clock.createHandler(looper, null).post(new Runnable() { // from class: com.google.android.inner_exoplayer2.m0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31451a.lambda$sendMessageToTargetThread$1(playerMessage);
                }
            });
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        }
    }

    private void setAllRendererStreamsFinal(long j) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                setCurrentStreamFinal(renderer, j);
            }
        }
    }

    private void setCurrentStreamFinal(Renderer renderer, long j) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j);
        }
    }

    private void setForegroundModeInternal(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer) && this.renderersToReset.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setMediaClockPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.removeMessages(16);
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void setOffloadSchedulingEnabledInternal(boolean z) {
        if (z == this.offloadSchedulingEnabled) {
            return;
        }
        this.offloadSchedulingEnabled = z;
        if (z || !this.playbackInfo.sleepingForOffload) {
            return;
        }
        this.handler.sendEmptyMessage(2);
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        resetPendingPauseAtEndOfPeriod();
        if (!this.pendingPauseAtEndOfPeriod || this.queue.getReadingPeriod() == this.queue.getPlayingPeriod()) {
            return;
        }
        seekToCurrentPosition(true);
        handleLoadingMediaPeriodChanged(false);
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.isRebuffering = false;
        notifyTrackSelectionPlayWhenReadyChanged(z);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i3 = this.playbackInfo.playbackState;
        if (i3 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        setMediaClockPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws Throwable {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void setState(int i) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != i) {
            if (i != 2) {
                this.playbackMaybeBecameStuckAtMs = -9223372036854775807L;
            }
            this.playbackInfo = playbackInfo.copyWithPlaybackState(i);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        return shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState;
    }

    private boolean shouldContinueLoading() {
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        long periodTime = loadingPeriod == this.queue.getPlayingPeriod() ? loadingPeriod.toPeriodTime(this.rendererPositionUs) : loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        boolean zShouldContinueLoading = this.loadControl.shouldContinueLoading(periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
        if (zShouldContinueLoading || totalBufferedDurationUs >= PLAYBACK_BUFFER_EMPTY_THRESHOLD_US) {
            return zShouldContinueLoading;
        }
        if (this.backBufferDurationUs <= 0 && !this.retainBackBufferFromKeyframe) {
            return zShouldContinueLoading;
        }
        this.queue.getPlayingPeriod().mediaPeriod.discardBuffer(this.playbackInfo.positionUs, false);
        return this.loadControl.shouldContinueLoading(periodTime, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (!playbackInfo.isLoading) {
            return true;
        }
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(playbackInfo.timeline, this.queue.getPlayingPeriod().info.id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : -9223372036854775807L;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || (loadingPeriod.info.id.isAd() && !loadingPeriod.prepared) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs);
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive()) {
            return false;
        }
        Timeline.Window window = this.window;
        return window.isDynamic && window.windowStartTimeMs != -9223372036854775807L;
    }

    private void startRenderers() {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(z || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (z != playbackInfo.isLoading) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z);
        }
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void updatePeriods() throws ExoPlaybackException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void updatePlaybackPositions() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            return;
        }
        long discontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != -9223372036854775807L) {
            resetRendererPosition(discontinuity);
            if (discontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = handlePositionDiscontinuity(playbackInfo.periodId, discontinuity, playbackInfo.requestedContentPositionUs, discontinuity, true, 5);
            }
        } else {
            long jSyncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
            this.rendererPositionUs = jSyncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(jSyncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            this.playbackInfo.positionUs = periodTime;
        }
        this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playWhenReady && playbackInfo2.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo2.timeline, playbackInfo2.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
            float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
            if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                setMediaClockPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
            }
        }
    }

    private void updatePlaybackSpeedSettingsForNewPeriod(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j, boolean z) {
        if (!shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.isAd() ? PlaybackParameters.DEFAULT : this.playbackInfo.playbackParameters;
            if (this.mediaClock.getPlaybackParameters().equals(playbackParameters)) {
                return;
            }
            setMediaClockPlaybackParameters(playbackParameters);
            handlePlaybackParameters(this.playbackInfo.playbackParameters, playbackParameters.speed, false, false);
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j != -9223372036854775807L) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j));
            return;
        }
        if (!Util.areEqual(!timeline2.isEmpty() ? timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid : null, this.window.uid) || z) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private synchronized void waitUninterruptibly(Supplier<Boolean> supplier, long j) {
        long jElapsedRealtime = this.clock.elapsedRealtime() + j;
        boolean z = false;
        while (!supplier.get().booleanValue() && j > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).sendToTarget();
    }

    public void experimentalSetForegroundModeTimeoutMs(long j) {
        this.setForegroundModeTimeoutMs = j;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.handler.obtainMessage(24, z ? 1 : 0, 0).sendToTarget();
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        MediaPeriodHolder readingPeriod;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                    setOffloadSchedulingEnabledInternal(message.arg1 == 1);
                    break;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.id);
            }
            if (e.isRecoverable && this.pendingRecoverableRendererError == null) {
                Log.w("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.pendingRecoverableRendererError = e;
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                Log.e("ExoPlayerImplInternal", "Playback error", e);
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            }
        } catch (ParserException e2) {
            int i2 = e2.dataType;
            if (i2 == 1) {
                i = e2.contentIsMalformed ? 3001 : 3003;
            } else if (i2 == 4) {
                i = e2.contentIsMalformed ? 3002 : 3004;
            }
            handleIoException(e2, i);
        } catch (DrmSession.DrmSessionException e3) {
            handleIoException(e3, e3.errorCode);
        } catch (BehindLiveWindowException e4) {
            handleIoException(e4, 1002);
        } catch (DataSourceException e5) {
            handleIoException(e5, e5.reason);
        } catch (IOException e6) {
            handleIoException(e6, 2000);
        } catch (RuntimeException e7) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? 1004 : 1000);
            Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackExceptionCreateForUnexpected);
        }
        maybeNotifyPlaybackInfoChanged();
        return true;
    }

    public void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    @Override // com.google.android.inner_exoplayer2.DefaultMediaClock.PlaybackParametersListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // com.google.android.inner_exoplayer2.MediaSourceList.MediaSourceListInfoRefreshListener
    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    @Override // com.google.android.inner_exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.inner_exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public synchronized boolean release() {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.sendEmptyMessage(7);
            waitUninterruptibly(new Supplier() { // from class: com.google.android.inner_exoplayer2.n0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return this.f31457a.lambda$release$0();
                }
            }, this.releaseTimeoutMs);
            return this.released;
        }
        return true;
    }

    public void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    @Override // com.google.android.inner_exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
            return;
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public synchronized boolean setForegroundMode(boolean z) {
        if (!this.released && this.playbackLooper.getThread().isAlive()) {
            if (z) {
                this.handler.obtainMessage(13, 1, 0).sendToTarget();
                return true;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
            waitUninterruptibly(new za3(atomicBoolean), this.setForegroundModeTimeoutMs);
            return atomicBoolean.get();
        }
        return true;
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i) && this.renderersToReset.remove(this.renderers[i])) {
                this.renderers[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (trackSelectorResult.isRendererEnabled(i2)) {
                enableRenderer(i2, zArr[i2]);
            }
        }
        readingPeriod.allRenderersInCorrectState = true;
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return Math.max(0L, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f, playbackParameters.speed);
            }
        }
    }

    @Override // com.google.android.inner_exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        stopRenderers();
        this.isRebuffering = false;
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod;
        while (next != null && !mediaPeriodId.equals(next.info.id)) {
            next = next.getNext();
        }
        if (z || playingPeriod != next || (next != null && next.toRendererTime(j) < 0)) {
            for (Renderer renderer : this.renderers) {
                disableRenderer(renderer);
            }
            if (next != null) {
                while (this.queue.getPlayingPeriod() != next) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(next);
                next.setRendererOffset(1000000000000L);
                enableRenderers();
            }
        }
        if (next != null) {
            this.queue.removeAfter(next);
            if (!next.prepared) {
                next.info = next.info.copyWithStartPositionUs(j);
            } else if (next.hasEnabledTracks) {
                long jSeekToUs = next.mediaPeriod.seekToUs(j);
                next.mediaPeriod.discardBuffer(jSeekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j = jSeekToUs;
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }
}
