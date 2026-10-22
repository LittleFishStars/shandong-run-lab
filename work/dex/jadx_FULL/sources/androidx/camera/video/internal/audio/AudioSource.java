package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.hjq.permissions.Permission;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class AudioSource {

    @VisibleForTesting
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";

    @Nullable
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;

    @Nullable
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;

    @Nullable
    BufferProvider<? extends InputBuffer> mBufferProvider;

    @NonNull
    BufferProvider.State mBufferProviderState;

    @Nullable
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;

    @NonNull
    InternalState mState;

    @Nullable
    private Observable.Observer<BufferProvider.State> mStateObserver;

    @Nullable
    private byte[] mZeroBytes;

    /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AudioSource$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface AudioSourceCallback {
        void onAmplitudeValue(double d);

        void onError(@NonNull Throwable th);

        void onSilenceStateChanged(boolean z);

        @VisibleForTesting
        default void onSuspendStateChanged(boolean z) {
        }
    }

    public class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        public AudioStreamCallback() {
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.AudioStreamCallback
        public void onSilenceStateChanged(boolean z) {
            AudioSource audioSource = AudioSource.this;
            audioSource.mAudioStreamSilenced = z;
            if (audioSource.mState == InternalState.STARTED) {
                audioSource.notifySilenced();
            }
        }
    }

    public enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    @RequiresPermission(Permission.RECORD_AUDIO)
    public AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context) throws AudioSourceAccessException {
        this(audioSettings, executor, context, new AudioStreamFactory() { // from class: androidx.camera.video.internal.audio.a
            @Override // androidx.camera.video.internal.audio.AudioStreamFactory
            public final AudioStream create(AudioSettings audioSettings2, Context context2) {
                return new AudioStreamImpl(audioSettings2, context2);
            }
        }, 3000L);
    }

    @Nullable
    private static BufferProvider.State fetchBufferProviderState(@NonNull BufferProvider<? extends InputBuffer> bufferProvider) {
        try {
            ListenableFuture<? extends InputBuffer> listenableFutureFetchData = bufferProvider.fetchData();
            if (listenableFutureFetchData.isDone()) {
                return (BufferProvider.State) listenableFutureFetchData.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }

    public static boolean isSettingsSupported(int i, int i2, int i3) {
        return AudioStreamImpl.isSettingsSupported(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mute$7(boolean z) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else {
            if (this.mMuted == z) {
                return;
            }
            this.mMuted = z;
            if (this.mState == InternalState.STARTED) {
                notifySilenced();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postMaxAmplitude$11(AudioSourceCallback audioSourceCallback) {
        audioSourceCallback.onAmplitudeValue(this.mAudioAmplitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer completer) {
        try {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
            if (i == 1 || i == 2) {
                resetBufferProvider(null);
                this.mSilentAudioStream.release();
                this.mAudioStream.release();
                stopSendingAudio();
                setState(InternalState.RELEASED);
            }
            completer.set(null);
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$5(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(this, completer) { // from class: com.zj.adlib.cg0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f40964a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CallbackToFutureAdapter.Completer f15812a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return "AudioSource-release";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioSourceCallback$6(Executor executor, AudioSourceCallback audioSourceCallback) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i == 1) {
            this.mCallbackExecutor = executor;
            this.mAudioSourceCallback = audioSourceCallback;
        } else if (i == 2 || i == 3) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBufferProvider$0(BufferProvider bufferProvider) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else if (this.mBufferProvider != bufferProvider) {
            resetBufferProvider(bufferProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() {
        start(this.mMuted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2(boolean z) {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i != 1) {
            if (i == 3) {
                throw new AssertionError("AudioSource is released");
            }
            return;
        }
        this.mNotifiedSilenceState.set(null);
        this.mNotifiedSuspendState.set(false);
        setState(InternalState.STARTED);
        mute(z);
        updateSendingAudio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$3() {
        int i = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[this.mState.ordinal()];
        if (i == 2) {
            setState(InternalState.CONFIGURED);
            updateSendingAudio();
        } else {
            if (i != 3) {
                return;
            }
            Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        }
    }

    private void resetBufferProvider(@Nullable final BufferProvider<? extends InputBuffer> bufferProvider) {
        BufferProvider<? extends InputBuffer> bufferProvider2 = this.mBufferProvider;
        if (bufferProvider2 != null) {
            Observable.Observer<BufferProvider.State> observer = this.mStateObserver;
            Objects.requireNonNull(observer);
            bufferProvider2.removeObserver(observer);
            this.mBufferProvider = null;
            this.mStateObserver = null;
            this.mAcquireBufferCallback = null;
            this.mBufferProviderState = BufferProvider.State.INACTIVE;
            updateSendingAudio();
        }
        if (bufferProvider != null) {
            this.mBufferProvider = bufferProvider;
            this.mStateObserver = new Observable.Observer<BufferProvider.State>() { // from class: androidx.camera.video.internal.audio.AudioSource.1
                @Override // androidx.camera.core.impl.Observable.Observer
                public void onError(@NonNull Throwable th) {
                    AudioSource audioSource = AudioSource.this;
                    if (audioSource.mBufferProvider == bufferProvider) {
                        audioSource.notifyError(th);
                    }
                }

                @Override // androidx.camera.core.impl.Observable.Observer
                public void onNewData(@Nullable BufferProvider.State state) {
                    Objects.requireNonNull(state);
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Receive BufferProvider state change: " + AudioSource.this.mBufferProviderState + " to " + state);
                        AudioSource audioSource = AudioSource.this;
                        if (audioSource.mBufferProviderState != state) {
                            audioSource.mBufferProviderState = state;
                            audioSource.updateSendingAudio();
                        }
                    }
                }
            };
            this.mAcquireBufferCallback = new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.audio.AudioSource.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    if (AudioSource.this.mBufferProvider != bufferProvider) {
                        return;
                    }
                    Logger.d(AudioSource.TAG, "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                    if (th instanceof IllegalStateException) {
                        return;
                    }
                    AudioSource.this.notifyError(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(InputBuffer inputBuffer) {
                    AudioSource audioSource = AudioSource.this;
                    if (!audioSource.mIsSendingAudio || audioSource.mBufferProvider != bufferProvider) {
                        inputBuffer.cancel();
                        return;
                    }
                    if (audioSource.mInSilentStartState && audioSource.isStartRetryIntervalReached()) {
                        AudioSource.this.retryStartAudioStream();
                    }
                    AudioStream currentAudioStream = AudioSource.this.getCurrentAudioStream();
                    ByteBuffer byteBuffer = inputBuffer.getByteBuffer();
                    AudioStream.PacketInfo packetInfo = currentAudioStream.read(byteBuffer);
                    if (packetInfo.getSizeInBytes() > 0) {
                        AudioSource audioSource2 = AudioSource.this;
                        if (audioSource2.mMuted) {
                            audioSource2.overrideBySilence(byteBuffer, packetInfo.getSizeInBytes());
                        }
                        if (AudioSource.this.mCallbackExecutor != null) {
                            long timestampNs = packetInfo.getTimestampNs();
                            AudioSource audioSource3 = AudioSource.this;
                            if (timestampNs - audioSource3.mAmplitudeTimestamp >= 200) {
                                audioSource3.mAmplitudeTimestamp = packetInfo.getTimestampNs();
                                AudioSource.this.postMaxAmplitude(byteBuffer);
                            }
                        }
                        byteBuffer.limit(byteBuffer.position() + packetInfo.getSizeInBytes());
                        inputBuffer.setPresentationTimeUs(TimeUnit.NANOSECONDS.toMicros(packetInfo.getTimestampNs()));
                        inputBuffer.submit();
                    } else {
                        Logger.w(AudioSource.TAG, "Unable to read data from AudioStream.");
                        inputBuffer.cancel();
                    }
                    AudioSource.this.sendNextAudio();
                }
            };
            BufferProvider.State stateFetchBufferProviderState = fetchBufferProviderState(bufferProvider);
            if (stateFetchBufferProviderState != null) {
                this.mBufferProviderState = stateFetchBufferProviderState;
                updateSendingAudio();
            }
            this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        }
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio) {
            return;
        }
        try {
            Logger.d(TAG, "startSendingAudio");
            this.mAudioStream.start();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e) {
            Logger.w(TAG, "Failed to start AudioStream", e);
            this.mInSilentStartState = true;
            this.mSilentAudioStream.start();
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
            notifySilenced();
        }
        this.mIsSendingAudio = true;
        sendNextAudio();
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio) {
            this.mIsSendingAudio = false;
            Logger.d(TAG, "stopSendingAudio");
            this.mAudioStream.stop();
        }
    }

    @NonNull
    public AudioStream getCurrentAudioStream() {
        return this.mInSilentStartState ? this.mSilentAudioStream : this.mAudioStream;
    }

    public boolean isStartRetryIntervalReached() {
        Preconditions.checkState(this.mLatestFailedStartTimeNs > 0);
        return getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs >= this.mStartRetryIntervalNs;
    }

    public void mute(final boolean z) {
        this.mExecutor.execute(new Runnable(this, z) { // from class: com.zj.adlib.uf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f45136a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f20057a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void notifyError(@NonNull final Throwable th) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        executor.execute(new Runnable(audioSourceCallback, th) { // from class: com.zj.adlib.vf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource.AudioSourceCallback f45338a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Throwable f20211a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void notifySilenced() {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        final boolean z = this.mMuted || this.mInSilentStartState || this.mAudioStreamSilenced;
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
            return;
        }
        executor.execute(new Runnable(audioSourceCallback, z) { // from class: com.zj.adlib.tf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource.AudioSourceCallback f44905a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f19784a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void notifySuspended(final boolean z) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null || this.mNotifiedSuspendState.getAndSet(z) == z) {
            return;
        }
        executor.execute(new Runnable(audioSourceCallback, z) { // from class: com.zj.adlib.yf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource.AudioSourceCallback f46020a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f20846a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void overrideBySilence(@NonNull ByteBuffer byteBuffer, int i) {
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i) {
            this.mZeroBytes = new byte[i];
        }
        int iPosition = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i);
        byteBuffer.limit(byteBuffer.position()).position(iPosition);
    }

    public void postMaxAmplitude(ByteBuffer byteBuffer) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (this.mAudioFormat == 2) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            double dMax = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (shortBufferAsShortBuffer.hasRemaining()) {
                dMax = Math.max(dMax, Math.abs((int) shortBufferAsShortBuffer.get()));
            }
            this.mAudioAmplitude = dMax / 32767.0d;
            if (executor == null || audioSourceCallback == null) {
                return;
            }
            executor.execute(new Runnable(this, audioSourceCallback) { // from class: com.zj.adlib.dg0

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AudioSource.AudioSourceCallback f41177a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ AudioSource f15989a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    @NonNull
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: com.zj.adlib.zf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f46251a;

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            }
        });
    }

    public void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        try {
            this.mAudioStream.start();
            Logger.d(TAG, "Retry start AudioStream succeed");
            this.mSilentAudioStream.stop();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e) {
            Logger.w(TAG, "Retry start AudioStream failed", e);
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        }
    }

    public void sendNextAudio() {
        BufferProvider<? extends InputBuffer> bufferProvider = this.mBufferProvider;
        Objects.requireNonNull(bufferProvider);
        ListenableFuture<? extends InputBuffer> listenableFutureAcquireBuffer = bufferProvider.acquireBuffer();
        FutureCallback<InputBuffer> futureCallback = this.mAcquireBufferCallback;
        Objects.requireNonNull(futureCallback);
        Futures.addCallback(listenableFutureAcquireBuffer, futureCallback, this.mExecutor);
    }

    public void setAudioSourceCallback(@NonNull final Executor executor, @NonNull final AudioSourceCallback audioSourceCallback) {
        this.mExecutor.execute(new Runnable(this, executor, audioSourceCallback) { // from class: com.zj.adlib.ag0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource.AudioSourceCallback f40527a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AudioSource f15266a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Executor f15267a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void setBufferProvider(@NonNull final BufferProvider<? extends InputBuffer> bufferProvider) {
        this.mExecutor.execute(new Runnable(this, bufferProvider) { // from class: com.zj.adlib.sf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BufferProvider f44678a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AudioSource f19567a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void setState(InternalState internalState) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    public void start() {
        this.mExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.xf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f45812a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void stop() {
        this.mExecutor.execute(new Runnable(this) { // from class: com.zj.adlib.bg0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f40745a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    public void updateSendingAudio() {
        if (this.mState != InternalState.STARTED) {
            stopSendingAudio();
            return;
        }
        boolean z = this.mBufferProviderState == BufferProvider.State.ACTIVE;
        notifySuspended(!z);
        if (z) {
            startSendingAudio();
        } else {
            stopSendingAudio();
        }
    }

    @RequiresPermission(Permission.RECORD_AUDIO)
    @VisibleForTesting
    public AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context, @NonNull AudioStreamFactory audioStreamFactory, long j) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference<>(null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0L;
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = executorNewSequentialExecutor;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(j);
        try {
            BufferedAudioStream bufferedAudioStream = new BufferedAudioStream(audioStreamFactory.create(audioSettings, context), audioSettings);
            this.mAudioStream = bufferedAudioStream;
            bufferedAudioStream.setCallback(new AudioStreamCallback(), executorNewSequentialExecutor);
            this.mSilentAudioStream = new SilentAudioStream(audioSettings);
            this.mAudioFormat = audioSettings.getAudioFormat();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e);
        }
    }

    public void start(final boolean z) {
        this.mExecutor.execute(new Runnable(this, z) { // from class: com.zj.adlib.wf0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioSource f45584a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f20429a;

            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }
}
