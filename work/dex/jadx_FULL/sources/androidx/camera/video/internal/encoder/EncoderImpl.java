package androidx.camera.video.internal.encoder;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.workaround.EncoderFinder;
import androidx.camera.video.internal.workaround.VideoTimebaseConverter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class EncoderImpl implements Encoder {
    private static final boolean DEBUG = false;
    private static final int FAKE_BUFFER_INDEX = -9999;
    private static final long NO_LIMIT_LONG = Long.MAX_VALUE;
    private static final Range<Long> NO_RANGE = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private static final long STOP_TIMEOUT_MS = 1000;
    final Executor mEncoderExecutor;
    final EncoderFinder mEncoderFinder;
    private final EncoderInfo mEncoderInfo;
    final Encoder.EncoderInput mEncoderInput;
    final Timebase mInputTimebase;
    final boolean mIsVideoEncoder;
    final MediaCodec mMediaCodec;
    private final MediaFormat mMediaFormat;
    private final CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private final ListenableFuture<Void> mReleasedFuture;
    InternalState mState;
    final String mTag;
    final Object mLock = new Object();
    final Queue<Integer> mFreeInputBufferIndexQueue = new ArrayDeque();
    private final Queue<CallbackToFutureAdapter.Completer<InputBuffer>> mAcquisitionQueue = new ArrayDeque();
    private final Set<InputBuffer> mInputBufferSet = new HashSet();
    final Set<EncodedDataImpl> mEncodedDataSet = new HashSet();
    final Deque<Range<Long>> mActivePauseResumeTimeRanges = new ArrayDeque();
    final TimeProvider mTimeProvider = new SystemTimeProvider();

    @GuardedBy("mLock")
    EncoderCallback mEncoderCallback = EncoderCallback.EMPTY;

    @GuardedBy("mLock")
    Executor mEncoderCallbackExecutor = CameraXExecutors.directExecutor();
    Range<Long> mStartStopTimeRangeUs = NO_RANGE;
    long mTotalPausedDurationUs = 0;
    boolean mPendingCodecStop = false;
    Long mLastDataStopTimestamp = null;
    Future<?> mStopTimeoutFuture = null;
    private MediaCodecCallback mMediaCodecCallback = null;
    private boolean mIsFlushedAfterEndOfStream = false;
    private boolean mSourceStoppedSignalled = false;
    boolean mMediaCodecEosSignalled = false;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.EncoderImpl$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_START_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_RELEASE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.RELEASED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        @DoNotInline
        public static Surface createPersistentInputSurface() {
            return MediaCodec.createPersistentInputSurface();
        }

        @DoNotInline
        public static void setInputSurface(@NonNull MediaCodec mediaCodec, @NonNull Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    public class ByteBufferInput implements Encoder.ByteBufferInput {
        private final Map<Observable.Observer<? super BufferProvider.State>, Executor> mStateObservers = new LinkedHashMap();
        private BufferProvider.State mBufferProviderState = BufferProvider.State.INACTIVE;
        private final List<ListenableFuture<InputBuffer>> mAcquisitionList = new ArrayList();

        public ByteBufferInput() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: cancelInputBuffer, reason: merged with bridge method [inline-methods] */
        public void lambda$acquireBuffer$2(@NonNull ListenableFuture<InputBuffer> listenableFuture) {
            if (listenableFuture.cancel(true)) {
                return;
            }
            Preconditions.checkState(listenableFuture.isDone());
            try {
                listenableFuture.get().cancel();
            } catch (InterruptedException | CancellationException | ExecutionException e) {
                Logger.w(EncoderImpl.this.mTag, "Unable to cancel the input buffer: " + e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$acquireBuffer$3(ListenableFuture listenableFuture) {
            this.mAcquisitionList.remove(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$acquireBuffer$4(CallbackToFutureAdapter.Completer completer) {
            BufferProvider.State state = this.mBufferProviderState;
            if (state == BufferProvider.State.ACTIVE) {
                final ListenableFuture<InputBuffer> listenableFutureAcquireInputBuffer = EncoderImpl.this.acquireInputBuffer();
                Futures.propagate(listenableFutureAcquireInputBuffer, completer);
                completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21403a.lambda$acquireBuffer$2(listenableFutureAcquireInputBuffer);
                    }
                }, CameraXExecutors.directExecutor());
                this.mAcquisitionList.add(listenableFutureAcquireInputBuffer);
                listenableFutureAcquireInputBuffer.addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21404a.lambda$acquireBuffer$3(listenableFutureAcquireInputBuffer);
                    }
                }, EncoderImpl.this.mEncoderExecutor);
                return;
            }
            if (state == BufferProvider.State.INACTIVE) {
                completer.setException(new IllegalStateException("BufferProvider is not active."));
                return;
            }
            completer.setException(new IllegalStateException("Unknown state: " + this.mBufferProviderState));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$acquireBuffer$5(final CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21399a.lambda$acquireBuffer$4(completer);
                }
            });
            return "acquireBuffer";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addObserver$7(final Observable.Observer observer, Executor executor) {
            this.mStateObservers.put((Observable.Observer) Preconditions.checkNotNull(observer), (Executor) Preconditions.checkNotNull(executor));
            final BufferProvider.State state = this.mBufferProviderState;
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.d
                @Override // java.lang.Runnable
                public final void run() {
                    observer.onNewData(state);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.Completer completer) {
            completer.set(this.mBufferProviderState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$fetchData$1(final CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21402a.lambda$fetchData$0(completer);
                }
            });
            return "fetchData";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$removeObserver$8(Observable.Observer observer) {
            this.mStateObservers.remove(Preconditions.checkNotNull(observer));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setActive$9(Map.Entry entry, BufferProvider.State state) {
            ((Observable.Observer) entry.getKey()).onNewData(state);
        }

        @Override // androidx.camera.video.internal.BufferProvider
        @NonNull
        public ListenableFuture<InputBuffer> acquireBuffer() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.e
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f21401a.lambda$acquireBuffer$5(completer);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(@NonNull final Executor executor, @NonNull final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f147a.lambda$addObserver$7(observer, executor);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        @NonNull
        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.j
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f21406a.lambda$fetchData$1(completer);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(@NonNull final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f146a.lambda$removeObserver$8(observer);
                }
            });
        }

        public void setActive(boolean z) {
            final BufferProvider.State state = z ? BufferProvider.State.ACTIVE : BufferProvider.State.INACTIVE;
            if (this.mBufferProviderState == state) {
                return;
            }
            this.mBufferProviderState = state;
            if (state == BufferProvider.State.INACTIVE) {
                Iterator<ListenableFuture<InputBuffer>> it = this.mAcquisitionList.iterator();
                while (it.hasNext()) {
                    it.next().cancel(true);
                }
                this.mAcquisitionList.clear();
            }
            for (final Map.Entry<Observable.Observer<? super BufferProvider.State>, Executor> entry : this.mStateObservers.entrySet()) {
                try {
                    entry.getValue().execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            EncoderImpl.ByteBufferInput.lambda$setActive$9(entry, state);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                }
            }
        }
    }

    public enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    @RequiresApi(21)
    public class MediaCodecCallback extends MediaCodec.Callback {

        @Nullable
        private final VideoTimebaseConverter mVideoTimestampConverter;
        private boolean mHasSendStartCallback = false;
        private boolean mHasFirstData = false;
        private boolean mHasEndData = false;
        private long mLastPresentationTimeUs = 0;
        private long mLastSentAdjustedTimeUs = 0;
        private boolean mIsOutputBufferInPauseState = false;
        private boolean mIsKeyFrameRequired = false;
        private boolean mStopped = false;

        public MediaCodecCallback() {
            Timebase timebase = null;
            if (!EncoderImpl.this.mIsVideoEncoder) {
                this.mVideoTimestampConverter = null;
                return;
            }
            if (DeviceQuirks.get(CameraUseInconsistentTimebaseQuirk.class) != null) {
                Logger.w(EncoderImpl.this.mTag, "CameraUseInconsistentTimebaseQuirk is enabled");
            } else {
                timebase = EncoderImpl.this.mInputTimebase;
            }
            this.mVideoTimestampConverter = new VideoTimebaseConverter(EncoderImpl.this.mTimeProvider, timebase);
        }

        private boolean checkBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (this.mHasEndData) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by already reach end of stream.");
                return false;
            }
            if (bufferInfo.size <= 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by invalid buffer size.");
                return false;
            }
            if ((bufferInfo.flags & 2) != 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by codec config.");
                return false;
            }
            VideoTimebaseConverter videoTimebaseConverter = this.mVideoTimestampConverter;
            if (videoTimebaseConverter != null) {
                bufferInfo.presentationTimeUs = videoTimebaseConverter.convertToUptimeUs(bufferInfo.presentationTimeUs);
            }
            long j = bufferInfo.presentationTimeUs;
            if (j <= this.mLastPresentationTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by out of order buffer from MediaCodec.");
                return false;
            }
            this.mLastPresentationTimeUs = j;
            if (!EncoderImpl.this.mStartStopTimeRangeUs.contains(Long.valueOf(j))) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by not in start-stop range.");
                EncoderImpl encoderImpl = EncoderImpl.this;
                if (encoderImpl.mPendingCodecStop && bufferInfo.presentationTimeUs >= ((Long) encoderImpl.mStartStopTimeRangeUs.getUpper()).longValue()) {
                    Future<?> future = EncoderImpl.this.mStopTimeoutFuture;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
                return false;
            }
            if (updatePauseRangeStateAndCheckIfBufferPaused(bufferInfo)) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by pause.");
                return false;
            }
            if (EncoderImpl.this.getAdjustedTimeUs(bufferInfo) <= this.mLastSentAdjustedTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by adjusted time is less than the last sent time.");
                if (EncoderImpl.this.mIsVideoEncoder && EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
                return false;
            }
            if (!this.mHasFirstData && !this.mIsKeyFrameRequired && EncoderImpl.this.mIsVideoEncoder) {
                this.mIsKeyFrameRequired = true;
            }
            if (this.mIsKeyFrameRequired) {
                if (!EncoderImpl.isKeyFrame(bufferInfo)) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by not a key frame.");
                    EncoderImpl.this.requestKeyFrameToMediaCodec();
                    return false;
                }
                this.mIsKeyFrameRequired = false;
            }
            return true;
        }

        private boolean isEndOfStream(@NonNull MediaCodec.BufferInfo bufferInfo) {
            return EncoderImpl.hasEndOfStreamFlag(bufferInfo) || isEosSignalledAndStopTimeReached(bufferInfo);
        }

        private boolean isEosSignalledAndStopTimeReached(@NonNull MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl encoderImpl = EncoderImpl.this;
            return encoderImpl.mMediaCodecEosSignalled && bufferInfo.presentationTimeUs > ((Long) encoderImpl.mStartStopTimeRangeUs.getUpper()).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$4(MediaCodec.CodecException codecException) {
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.handleEncodeError(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInputBufferAvailable$0(int i) {
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives input frame after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.mFreeInputBufferIndexQueue.offer(Integer.valueOf(i));
                    EncoderImpl.this.matchAcquisitionsAndFreeBufferIndexes();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputBufferAvailable$1(Executor executor, final EncoderCallback encoderCallback) {
            if (EncoderImpl.this.mState == InternalState.ERROR) {
                return;
            }
            try {
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable(encoderCallback) { // from class: com.zj.adlib.n23

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ EncoderCallback f43430a;

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputBufferAvailable$2(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
            final EncoderCallback encoderCallback;
            final Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives frame after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                        break;
                    }
                    if (!this.mHasSendStartCallback) {
                        this.mHasSendStartCallback = true;
                        try {
                            Objects.requireNonNull(encoderCallback);
                            executor.execute(new Runnable(encoderCallback) { // from class: com.zj.adlib.m23

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                public final /* synthetic */ EncoderCallback f43203a;

                                @Override // java.lang.Runnable
                                public final void run() {
                                }
                            });
                        } catch (RejectedExecutionException e) {
                            Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        }
                        break;
                    }
                    if (!checkBufferInfo(bufferInfo)) {
                        if (i != -9999) {
                            try {
                                EncoderImpl.this.mMediaCodec.releaseOutputBuffer(i, false);
                            } catch (MediaCodec.CodecException e2) {
                                EncoderImpl.this.handleEncodeError(e2);
                                return;
                            }
                        }
                        break;
                    } else {
                        if (!this.mHasFirstData) {
                            this.mHasFirstData = true;
                            Logger.d(EncoderImpl.this.mTag, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.mInputTimebase + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo bufferInfoResolveOutputBufferInfo = resolveOutputBufferInfo(bufferInfo);
                        this.mLastSentAdjustedTimeUs = bufferInfoResolveOutputBufferInfo.presentationTimeUs;
                        try {
                            sendEncodedData(new EncodedDataImpl(mediaCodec, i, bufferInfoResolveOutputBufferInfo), encoderCallback, executor);
                        } catch (MediaCodec.CodecException e3) {
                            EncoderImpl.this.handleEncodeError(e3);
                            return;
                        }
                        break;
                    }
                    if (this.mHasEndData || !isEndOfStream(bufferInfo)) {
                        return;
                    }
                    this.mHasEndData = true;
                    EncoderImpl.this.stopMediaCodec(new Runnable() { // from class: androidx.camera.video.internal.encoder.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f154a.lambda$onOutputBufferAvailable$1(executor, encoderCallback);
                        }
                    });
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaFormat lambda$onOutputFormatChanged$5(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onOutputFormatChanged$6(EncoderCallback encoderCallback, final MediaFormat mediaFormat) {
            encoderCallback.onOutputConfigUpdate(new OutputConfig() { // from class: androidx.camera.video.internal.encoder.o
                @Override // androidx.camera.video.internal.encoder.OutputConfig
                public final MediaFormat getMediaFormat() {
                    return EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$5(mediaFormat);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFormatChanged$7(final MediaFormat mediaFormat) {
            final EncoderCallback encoderCallback;
            Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                        break;
                    }
                    try {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$6(encoderCallback, mediaFormat);
                            }
                        });
                        return;
                    } catch (RejectedExecutionException e) {
                        Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        @NonNull
        private MediaCodec.BufferInfo resolveOutputBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            long adjustedTimeUs = EncoderImpl.this.getAdjustedTimeUs(bufferInfo);
            if (bufferInfo.presentationTimeUs == adjustedTimeUs) {
                return bufferInfo;
            }
            Preconditions.checkState(adjustedTimeUs > this.mLastSentAdjustedTimeUs);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, adjustedTimeUs, bufferInfo.flags);
            return bufferInfo2;
        }

        private void sendEncodedData(@NonNull final EncodedDataImpl encodedDataImpl, @NonNull final EncoderCallback encoderCallback, @NonNull Executor executor) {
            EncoderImpl.this.mEncodedDataSet.add(encodedDataImpl);
            Futures.addCallback(encodedDataImpl.getClosedFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.MediaCodecCallback.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                    if (th instanceof MediaCodec.CodecException) {
                        EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                    } else {
                        EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r2) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                }
            }, EncoderImpl.this.mEncoderExecutor);
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        encoderCallback.onEncodedData(encodedDataImpl);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                encodedDataImpl.close();
            }
        }

        private boolean updatePauseRangeStateAndCheckIfBufferPaused(@NonNull MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            final EncoderCallback encoderCallback;
            EncoderImpl.this.updateTotalPausedDuration(bufferInfo.presentationTimeUs);
            boolean zIsInPauseRange = EncoderImpl.this.isInPauseRange(bufferInfo.presentationTimeUs);
            boolean z = this.mIsOutputBufferInPauseState;
            if (!z && zIsInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to pause state");
                this.mIsOutputBufferInPauseState = true;
                synchronized (EncoderImpl.this.mLock) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.mEncoderCallbackExecutor;
                    encoderCallback = encoderImpl.mEncoderCallback;
                }
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable(encoderCallback) { // from class: com.zj.adlib.l23

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ EncoderCallback f42979a;

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.mState == InternalState.PAUSED && ((encoderImpl2.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!EncoderImpl.this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null))) {
                    Encoder.EncoderInput encoderInput = EncoderImpl.this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(false);
                    }
                    EncoderImpl.this.setMediaCodecPaused(true);
                }
                EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.mPendingCodecStop) {
                    Future<?> future = encoderImpl3.mStopTimeoutFuture;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
            } else if (z && !zIsInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to resume state");
                this.mIsOutputBufferInPauseState = false;
                if (EncoderImpl.this.mIsVideoEncoder && !EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
            }
            return this.mIsOutputBufferInPauseState;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull final MediaCodec.CodecException codecException) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f150a.lambda$onError$4(codecException);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, final int i) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21414a.lambda$onInputBufferAvailable$0(i);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull final MediaCodec mediaCodec, final int i, @NonNull final MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f153a.lambda$onOutputBufferAvailable$2(bufferInfo, mediaCodec, i);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull final MediaFormat mediaFormat) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f149a.lambda$onOutputFormatChanged$7(mediaFormat);
                }
            });
        }

        public void stop() {
            this.mStopped = true;
        }
    }

    @RequiresApi(21)
    public class SurfaceInput implements Encoder.SurfaceInput {
        private final Object mLock = new Object();

        @GuardedBy("mLock")
        private final Set<Surface> mObsoleteSurfaces = new HashSet();

        @GuardedBy("mLock")
        private Surface mSurface;

        @GuardedBy("mLock")
        private Executor mSurfaceUpdateExecutor;

        @GuardedBy("mLock")
        private Encoder.SurfaceInput.OnSurfaceUpdateListener mSurfaceUpdateListener;

        public SurfaceInput() {
        }

        private void notifySurfaceUpdate(@NonNull Executor executor, @NonNull final Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener, @NonNull final Surface surface) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        onSurfaceUpdateListener.onSurfaceUpdate(surface);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
            }
        }

        public void releaseSurface() {
            Surface surface;
            HashSet hashSet;
            synchronized (this.mLock) {
                surface = this.mSurface;
                this.mSurface = null;
                hashSet = new HashSet(this.mObsoleteSurfaces);
                this.mObsoleteSurfaces.clear();
            }
            if (surface != null) {
                surface.release();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((Surface) it.next()).release();
            }
        }

        @SuppressLint({"NewApi"})
        public void resetSurface() {
            Surface surfaceCreateInputSurface;
            Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener;
            Executor executor;
            EncoderNotUsePersistentInputSurfaceQuirk encoderNotUsePersistentInputSurfaceQuirk = (EncoderNotUsePersistentInputSurfaceQuirk) DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class);
            synchronized (this.mLock) {
                try {
                    if (encoderNotUsePersistentInputSurfaceQuirk == null) {
                        if (this.mSurface == null) {
                            surfaceCreateInputSurface = Api23Impl.createPersistentInputSurface();
                            this.mSurface = surfaceCreateInputSurface;
                        } else {
                            surfaceCreateInputSurface = null;
                        }
                        Api23Impl.setInputSurface(EncoderImpl.this.mMediaCodec, this.mSurface);
                    } else {
                        Surface surface = this.mSurface;
                        if (surface != null) {
                            this.mObsoleteSurfaces.add(surface);
                        }
                        surfaceCreateInputSurface = EncoderImpl.this.mMediaCodec.createInputSurface();
                        this.mSurface = surfaceCreateInputSurface;
                    }
                    onSurfaceUpdateListener = this.mSurfaceUpdateListener;
                    executor = this.mSurfaceUpdateExecutor;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (surfaceCreateInputSurface == null || onSurfaceUpdateListener == null || executor == null) {
                return;
            }
            notifySurfaceUpdate(executor, onSurfaceUpdateListener, surfaceCreateInputSurface);
        }

        @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput
        public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
            Surface surface;
            synchronized (this.mLock) {
                this.mSurfaceUpdateListener = (Encoder.SurfaceInput.OnSurfaceUpdateListener) Preconditions.checkNotNull(onSurfaceUpdateListener);
                this.mSurfaceUpdateExecutor = (Executor) Preconditions.checkNotNull(executor);
                surface = this.mSurface;
            }
            if (surface != null) {
                notifySurfaceUpdate(executor, onSurfaceUpdateListener, surface);
            }
        }
    }

    public EncoderImpl(@NonNull Executor executor, @NonNull EncoderConfig encoderConfig) throws Throwable {
        EncoderFinder encoderFinder = new EncoderFinder();
        this.mEncoderFinder = encoderFinder;
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(encoderConfig);
        this.mEncoderExecutor = CameraXExecutors.newSequentialExecutor(executor);
        if (encoderConfig instanceof AudioEncoderConfig) {
            this.mTag = "AudioEncoder";
            this.mIsVideoEncoder = false;
            this.mEncoderInput = new ByteBufferInput();
        } else {
            if (!(encoderConfig instanceof VideoEncoderConfig)) {
                throw new InvalidConfigException("Unknown encoder config type");
            }
            this.mTag = "VideoEncoder";
            this.mIsVideoEncoder = true;
            this.mEncoderInput = new SurfaceInput();
        }
        Timebase inputTimebase = encoderConfig.getInputTimebase();
        this.mInputTimebase = inputTimebase;
        Logger.d(this.mTag, "mInputTimebase = " + inputTimebase);
        MediaFormat mediaFormat = encoderConfig.toMediaFormat();
        this.mMediaFormat = mediaFormat;
        Logger.d(this.mTag, "mMediaFormat = " + mediaFormat);
        MediaCodec mediaCodecFindEncoder = encoderFinder.findEncoder(mediaFormat);
        this.mMediaCodec = mediaCodecFindEncoder;
        Logger.i(this.mTag, "Selected encoder: " + mediaCodecFindEncoder.getName());
        EncoderInfo encoderInfoCreateEncoderInfo = createEncoderInfo(this.mIsVideoEncoder, mediaCodecFindEncoder.getCodecInfo(), encoderConfig.getMimeType());
        this.mEncoderInfo = encoderInfoCreateEncoderInfo;
        if (this.mIsVideoEncoder) {
            clampVideoBitrateIfNotSupported((VideoEncoderInfo) encoderInfoCreateEncoderInfo, mediaFormat);
        }
        try {
            reset();
            final AtomicReference atomicReference = new AtomicReference();
            this.mReleasedFuture = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(atomicReference) { // from class: com.zj.adlib.b23

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AtomicReference f40662a;

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                }
            }));
            this.mReleasedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            setState(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e) {
            throw new InvalidConfigException(e);
        }
    }

    private void clampVideoBitrateIfNotSupported(@NonNull VideoEncoderInfo videoEncoderInfo, @NonNull MediaFormat mediaFormat) {
        Preconditions.checkState(this.mIsVideoEncoder);
        if (mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE)) {
            int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE);
            int iIntValue = ((Integer) videoEncoderInfo.getSupportedBitrateRange().clamp(Integer.valueOf(integer))).intValue();
            if (integer != iIntValue) {
                mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iIntValue);
                Logger.d(this.mTag, "updated bitrate from " + integer + " to " + iIntValue);
            }
        }
    }

    @NonNull
    private static EncoderInfo createEncoderInfo(boolean z, @NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        return z ? new VideoEncoderInfoImpl(mediaCodecInfo, str) : new AudioEncoderInfoImpl(mediaCodecInfo, str);
    }

    public static boolean hasEndOfStreamFlag(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    public static boolean isKeyFrame(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$acquireInputBuffer$12(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "acquireInputBuffer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireInputBuffer$13(CallbackToFutureAdapter.Completer completer) {
        this.mAcquisitionQueue.remove(completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$matchAcquisitionsAndFreeBufferIndexes$14(InputBufferImpl inputBufferImpl) {
        this.mInputBufferSet.remove(inputBufferImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$new$0(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "mReleasedFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyError$10(EncoderCallback encoderCallback, int i, String str, Throwable th) {
        encoderCallback.onEncodeError(new EncodeException(i, str, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pause$5(long j) {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return;
            case 2:
                Logger.d(this.mTag, "Pause on " + DebugUtils.readableUs(j));
                this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(j), Long.MAX_VALUE));
                setState(InternalState.PAUSED);
                return;
            case 6:
                setState(InternalState.PENDING_START_PAUSED);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$6() {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 8:
                releaseInternal();
                return;
            case 4:
            case 5:
            case 6:
                setState(InternalState.PENDING_RELEASE);
                return;
            case 7:
            case 9:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyFrame$8() {
        int i = AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()];
        if (i == 2) {
            requestKeyFrameToMediaCodec();
        } else if (i == 7 || i == 9) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$signalSourceStopped$7() {
        this.mSourceStoppedSignalled = true;
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1(long j) {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
                this.mLastDataStopTimestamp = null;
                Logger.d(this.mTag, "Start on " + DebugUtils.readableUs(j));
                try {
                    if (this.mIsFlushedAfterEndOfStream) {
                        reset();
                    }
                    this.mStartStopTimeRangeUs = Range.create(Long.valueOf(j), Long.MAX_VALUE);
                    this.mMediaCodec.start();
                    Encoder.EncoderInput encoderInput = this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(true);
                    }
                    setState(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e) {
                    handleEncodeError(e);
                    return;
                }
            case 2:
            case 6:
            case 8:
                return;
            case 3:
                this.mLastDataStopTimestamp = null;
                Range<Long> rangeRemoveLast = this.mActivePauseResumeTimeRanges.removeLast();
                Preconditions.checkState(rangeRemoveLast != null && ((Long) rangeRemoveLast.getUpper()).longValue() == Long.MAX_VALUE, "There should be a \"pause\" before \"resume\"");
                long jLongValue = ((Long) rangeRemoveLast.getLower()).longValue();
                this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(jLongValue), Long.valueOf(j)));
                Logger.d(this.mTag, "Resume on " + DebugUtils.readableUs(j) + "\nPaused duration = " + DebugUtils.readableUs(j - jLongValue));
                if ((this.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null)) {
                    setMediaCodecPaused(false);
                    Encoder.EncoderInput encoderInput2 = this.mEncoderInput;
                    if (encoderInput2 instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput2).setActive(true);
                    }
                }
                if (this.mIsVideoEncoder) {
                    requestKeyFrameToMediaCodec();
                }
                setState(InternalState.STARTED);
                return;
            case 4:
            case 5:
                setState(InternalState.PENDING_START);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$2() {
        if (this.mPendingCodecStop) {
            Logger.w(this.mTag, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.mLastDataStopTimestamp = null;
            signalCodecStop();
            this.mPendingCodecStop = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$3() {
        this.mEncoderExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.i23

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EncoderImpl f42261a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$4(long j, long j2) {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 4:
            case 8:
                return;
            case 2:
            case 3:
                InternalState internalState = this.mState;
                setState(InternalState.STOPPING);
                long jLongValue = ((Long) this.mStartStopTimeRangeUs.getLower()).longValue();
                if (jLongValue == Long.MAX_VALUE) {
                    throw new AssertionError("There should be a \"start\" before \"stop\"");
                }
                if (j == -1) {
                    j = j2;
                } else if (j < jLongValue) {
                    Logger.w(this.mTag, "The expected stop time is less than the start time. Use current time as stop time.");
                    j = j2;
                }
                if (j < jLongValue) {
                    throw new AssertionError("The start time should be before the stop time.");
                }
                this.mStartStopTimeRangeUs = Range.create(Long.valueOf(jLongValue), Long.valueOf(j));
                Logger.d(this.mTag, "Stop on " + DebugUtils.readableUs(j));
                if (internalState == InternalState.PAUSED && this.mLastDataStopTimestamp != null) {
                    signalCodecStop();
                    return;
                } else {
                    this.mPendingCodecStop = true;
                    this.mStopTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new Runnable(this) { // from class: com.zj.adlib.k23

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ EncoderImpl f42727a;

                        @Override // java.lang.Runnable
                        public final void run() {
                        }
                    }, 1000L, TimeUnit.MILLISECONDS);
                    return;
                }
            case 5:
            case 6:
                setState(InternalState.CONFIGURED);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopMediaCodec$11(List list, Runnable runnable) {
        if (this.mState != InternalState.ERROR) {
            if (!list.isEmpty()) {
                Logger.d(this.mTag, "encoded data and input buffers are returned");
            }
            if (!(this.mEncoderInput instanceof SurfaceInput) || this.mSourceStoppedSignalled) {
                this.mMediaCodec.stop();
            } else {
                this.mMediaCodec.flush();
                this.mIsFlushedAfterEndOfStream = true;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        handleStopped();
    }

    private void releaseInternal() {
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            this.mIsFlushedAfterEndOfStream = false;
        }
        this.mMediaCodec.release();
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).releaseSurface();
        }
        setState(InternalState.RELEASED);
        this.mReleasedCompleter.set(null);
    }

    private void reset() {
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0L;
        this.mActivePauseResumeTimeRanges.clear();
        this.mFreeInputBufferIndexQueue.clear();
        Iterator<CallbackToFutureAdapter.Completer<InputBuffer>> it = this.mAcquisitionQueue.iterator();
        while (it.hasNext()) {
            it.next().setCancelled();
        }
        this.mAcquisitionQueue.clear();
        this.mMediaCodec.reset();
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        this.mPendingCodecStop = false;
        Future<?> future = this.mStopTimeoutFuture;
        if (future != null) {
            future.cancel(true);
            this.mStopTimeoutFuture = null;
        }
        MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
        if (mediaCodecCallback != null) {
            mediaCodecCallback.stop();
        }
        MediaCodecCallback mediaCodecCallback2 = new MediaCodecCallback();
        this.mMediaCodecCallback = mediaCodecCallback2;
        this.mMediaCodec.setCallback(mediaCodecCallback2);
        this.mMediaCodec.configure(this.mMediaFormat, (Surface) null, (MediaCrypto) null, 1);
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).resetSurface();
        }
    }

    private void setState(InternalState internalState) {
        if (this.mState == internalState) {
            return;
        }
        Logger.d(this.mTag, "Transitioning encoder internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalEndOfInputStream() {
        Futures.addCallback(acquireInputBuffer(), new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                EncoderImpl.this.handleEncodeError(0, "Unable to acquire InputBuffer.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(InputBuffer inputBuffer) {
                inputBuffer.setPresentationTimeUs(EncoderImpl.this.generatePresentationTimeUs());
                inputBuffer.setEndOfStream(true);
                inputBuffer.submit();
                Futures.addCallback(inputBuffer.getTerminationFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(@NonNull Throwable th) {
                        if (th instanceof MediaCodec.CodecException) {
                            EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                        } else {
                            EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                        }
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(@Nullable Void r1) {
                    }
                }, EncoderImpl.this.mEncoderExecutor);
            }
        }, this.mEncoderExecutor);
    }

    @NonNull
    public ListenableFuture<InputBuffer> acquireInputBuffer() {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                final AtomicReference atomicReference = new AtomicReference();
                ListenableFuture<InputBuffer> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(atomicReference) { // from class: com.zj.adlib.g23

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ AtomicReference f41802a;

                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    }
                });
                final CallbackToFutureAdapter.Completer<InputBuffer> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
                this.mAcquisitionQueue.offer(completer);
                completer.addCancellationListener(new Runnable(this, completer) { // from class: com.zj.adlib.h23

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ EncoderImpl f42035a;

                    /* JADX INFO: renamed from: a, reason: collision with other field name */
                    public final /* synthetic */ CallbackToFutureAdapter.Completer f16920a;

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                }, this.mEncoderExecutor);
                matchAcquisitionsAndFreeBufferIndexes();
                return future;
            case 8:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
            case 9:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    public long generatePresentationTimeUs() {
        return this.mTimeProvider.uptimeUs();
    }

    public long getAdjustedTimeUs(@NonNull MediaCodec.BufferInfo bufferInfo) {
        long j = this.mTotalPausedDurationUs;
        return j > 0 ? bufferInfo.presentationTimeUs - j : bufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public int getConfiguredBitrate() {
        if (this.mMediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE)) {
            return this.mMediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE);
        }
        return 0;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public EncoderInfo getEncoderInfo() {
        return this.mEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public Encoder.EncoderInput getInput() {
        return this.mEncoderInput;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public ListenableFuture<Void> getReleasedFuture() {
        return this.mReleasedFuture;
    }

    public void handleEncodeError(@NonNull MediaCodec.CodecException codecException) {
        handleEncodeError(1, codecException.getMessage(), codecException);
    }

    public void handleStopped() {
        InternalState internalState = this.mState;
        if (internalState == InternalState.PENDING_RELEASE) {
            releaseInternal();
            return;
        }
        if (!this.mIsFlushedAfterEndOfStream) {
            reset();
        }
        setState(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    public boolean isInPauseRange(long j) {
        for (Range<Long> range : this.mActivePauseResumeTimeRanges) {
            if (range.contains(Long.valueOf(j))) {
                return true;
            }
            if (j < ((Long) range.getLower()).longValue()) {
                break;
            }
        }
        return false;
    }

    public void matchAcquisitionsAndFreeBufferIndexes() {
        while (!this.mAcquisitionQueue.isEmpty() && !this.mFreeInputBufferIndexQueue.isEmpty()) {
            CallbackToFutureAdapter.Completer completerPoll = this.mAcquisitionQueue.poll();
            Objects.requireNonNull(completerPoll);
            Integer numPoll = this.mFreeInputBufferIndexQueue.poll();
            Objects.requireNonNull(numPoll);
            try {
                final InputBufferImpl inputBufferImpl = new InputBufferImpl(this.mMediaCodec, numPoll.intValue());
                if (completerPoll.set(inputBufferImpl)) {
                    this.mInputBufferSet.add(inputBufferImpl);
                    inputBufferImpl.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f21397a.lambda$matchAcquisitionsAndFreeBufferIndexes$14(inputBufferImpl);
                        }
                    }, this.mEncoderExecutor);
                } else {
                    inputBufferImpl.cancel();
                }
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: notifyError, reason: merged with bridge method [inline-methods] */
    public void lambda$handleEncodeError$9(final int i, @Nullable final String str, @Nullable final Throwable th) {
        final EncoderCallback encoderCallback;
        Executor executor;
        synchronized (this.mLock) {
            encoderCallback = this.mEncoderCallback;
            executor = this.mEncoderCallbackExecutor;
        }
        try {
            executor.execute(new Runnable(encoderCallback, i, str, th) { // from class: com.zj.adlib.c23
                public final /* synthetic */ int K;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ EncoderCallback f40885a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ Throwable f15674a;
                public final /* synthetic */ String f;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        } catch (RejectedExecutionException e) {
            Logger.e(this.mTag, "Unable to post to the supplied executor.", e);
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void pause() {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable(this, jGeneratePresentationTimeUs) { // from class: com.zj.adlib.w13

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f45505a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ EncoderImpl f20358a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void release() {
        this.mEncoderExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.a23

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EncoderImpl f40436a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void requestKeyFrame() {
        this.mEncoderExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.z13

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EncoderImpl f46159a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void requestKeyFrameToMediaCodec() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mMediaCodec.setParameters(bundle);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void setEncoderCallback(@NonNull EncoderCallback encoderCallback, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mEncoderCallback = encoderCallback;
            this.mEncoderCallbackExecutor = executor;
        }
    }

    public void setMediaCodecPaused(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z ? 1 : 0);
        this.mMediaCodec.setParameters(bundle);
    }

    public void signalCodecStop() {
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof ByteBufferInput) {
            ((ByteBufferInput) encoderInput).setActive(false);
            ArrayList arrayList = new ArrayList();
            Iterator<InputBuffer> it = this.mInputBufferSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTerminationFuture());
            }
            Futures.successfulAsList(arrayList).addListener(new Runnable(this) { // from class: com.zj.adlib.e23

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ EncoderImpl f41328a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            }, this.mEncoderExecutor);
            return;
        }
        if (encoderInput instanceof SurfaceInput) {
            try {
                this.mMediaCodec.signalEndOfInputStream();
                this.mMediaCodecEosSignalled = true;
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
            }
        }
    }

    public void signalSourceStopped() {
        this.mEncoderExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.j23

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EncoderImpl f42491a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void start() {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable(this, jGeneratePresentationTimeUs) { // from class: com.zj.adlib.x13

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f45728a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ EncoderImpl f20591a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop() {
        stop(-1L);
    }

    public void stopMediaCodec(@Nullable final Runnable runnable) {
        final ArrayList arrayList = new ArrayList();
        Iterator<EncodedDataImpl> it = this.mEncodedDataSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClosedFuture());
        }
        Iterator<InputBuffer> it2 = this.mInputBufferSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getTerminationFuture());
        }
        if (!arrayList.isEmpty()) {
            Logger.d(this.mTag, "Waiting for resources to return. encoded data = " + this.mEncodedDataSet.size() + ", input buffers = " + this.mInputBufferSet.size());
        }
        Futures.successfulAsList(arrayList).addListener(new Runnable(this, arrayList, runnable) { // from class: com.zj.adlib.f23

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EncoderImpl f41578a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Runnable f16434a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ List f16435a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        }, this.mEncoderExecutor);
    }

    public void updateTotalPausedDuration(long j) {
        while (!this.mActivePauseResumeTimeRanges.isEmpty()) {
            Range<Long> first = this.mActivePauseResumeTimeRanges.getFirst();
            if (j <= ((Long) first.getUpper()).longValue()) {
                return;
            }
            this.mActivePauseResumeTimeRanges.removeFirst();
            this.mTotalPausedDurationUs += ((Long) first.getUpper()).longValue() - ((Long) first.getLower()).longValue();
            Logger.d(this.mTag, "Total paused duration = " + DebugUtils.readableUs(this.mTotalPausedDurationUs));
        }
    }

    public void handleEncodeError(final int i, @Nullable final String str, @Nullable final Throwable th) {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
                lambda$handleEncodeError$9(i, str, th);
                reset();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setState(InternalState.ERROR);
                stopMediaCodec(new Runnable(this, i, str, th) { // from class: com.zj.adlib.y13
                    public final /* synthetic */ int K;

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ EncoderImpl f45937a;

                    /* JADX INFO: renamed from: a, reason: collision with other field name */
                    public final /* synthetic */ Throwable f20763a;
                    public final /* synthetic */ String f;

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
                break;
            case 8:
                Logger.w(this.mTag, "Get more than one error: " + str + "(" + i + ")", th);
                break;
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop(final long j) {
        final long jGeneratePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable(this, j, jGeneratePresentationTimeUs) { // from class: com.zj.adlib.d23

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f41092a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ EncoderImpl f15916a;
            public final /* synthetic */ long b;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }
}
