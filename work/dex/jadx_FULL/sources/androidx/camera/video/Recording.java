package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.core.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class Recording implements AutoCloseable {
    private final CloseGuardHelper mCloseGuard;
    private final AtomicBoolean mIsClosed;
    private final boolean mIsPersistent;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;
    private final long mRecordingId;

    public Recording(@NonNull Recorder recorder, long j, @NonNull OutputOptions outputOptions, boolean z, boolean z2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mIsClosed = atomicBoolean;
        CloseGuardHelper closeGuardHelperCreate = CloseGuardHelper.create();
        this.mCloseGuard = closeGuardHelperCreate;
        this.mRecorder = recorder;
        this.mRecordingId = j;
        this.mOutputOptions = outputOptions;
        this.mIsPersistent = z;
        if (z2) {
            atomicBoolean.set(true);
        } else {
            closeGuardHelperCreate.open("stop");
        }
    }

    @NonNull
    public static Recording createFinalizedFrom(@NonNull PendingRecording pendingRecording, long j) {
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        return new Recording(pendingRecording.getRecorder(), j, pendingRecording.getOutputOptions(), pendingRecording.isPersistent(), true);
    }

    @NonNull
    public static Recording from(@NonNull PendingRecording pendingRecording, long j) {
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        return new Recording(pendingRecording.getRecorder(), j, pendingRecording.getOutputOptions(), pendingRecording.isPersistent(), false);
    }

    private void stopWithError(int i, @Nullable Throwable th) {
        this.mCloseGuard.close();
        if (this.mIsClosed.getAndSet(true)) {
            return;
        }
        this.mRecorder.stop(this, i, th);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        stopWithError(0, null);
    }

    public void finalize() throws Throwable {
        try {
            this.mCloseGuard.warnIfOpen();
            stopWithError(10, new RuntimeException("Recording stopped due to being garbage collected."));
        } finally {
            super.finalize();
        }
    }

    @NonNull
    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    public long getRecordingId() {
        return this.mRecordingId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        return this.mIsClosed.get();
    }

    @ExperimentalPersistentRecording
    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    public void mute(boolean z) {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.mute(this, z);
    }

    public void pause() {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.pause(this);
    }

    public void resume() {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.resume(this);
    }

    public void stop() {
        close();
    }
}
