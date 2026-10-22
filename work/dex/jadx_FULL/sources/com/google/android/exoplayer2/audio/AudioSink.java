package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.zj.adlib.at6;
import com.zj.adlib.pi0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30539a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f2362a = Long.MIN_VALUE;
    public static final int b = 1;
    public static final int c = 0;

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final com.google.android.exoplayer2.d format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, com.google.android.exoplayer2.d dVar, boolean z, @Nullable Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            sb.append(z ? " (recoverable)" : "");
            super(sb.toString(), exc);
            this.audioTrackState = i;
            this.isRecoverable = z;
            this.format = dVar;
        }
    }

    public interface Listener {
        default void onAudioSinkError(Exception exc) {
        }

        default void onOffloadBufferEmptying() {
        }

        default void onOffloadBufferFull() {
        }

        default void onPositionAdvancing(long j) {
        }

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z);

        void onUnderrun(int i, long j, long j2);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final com.google.android.exoplayer2.d format;
        public final boolean isRecoverable;

        public WriteException(int i, com.google.android.exoplayer2.d dVar, boolean z) {
            super("AudioTrack write failed: " + i);
            this.isRecoverable = z;
            this.errorCode = i;
            this.format = dVar;
        }
    }

    boolean a(com.google.android.exoplayer2.d dVar);

    com.google.android.exoplayer2.j b();

    void c(com.google.android.exoplayer2.j jVar);

    @Nullable
    a d();

    void disableTunneling();

    void e(pi0 pi0Var);

    void enableTunnelingV21();

    void experimentalFlushWithoutAudioTrackRelease();

    int f(com.google.android.exoplayer2.d dVar);

    void flush();

    void g(com.google.android.exoplayer2.d dVar, int i, @Nullable int[] iArr) throws ConfigurationException;

    long getCurrentPositionUs(boolean z);

    boolean getSkipSilenceEnabled();

    default void h(@Nullable at6 at6Var) {
    }

    boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    void handleDiscontinuity();

    boolean hasPendingData();

    void i(Listener listener);

    boolean isEnded();

    void j(a aVar);

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void reset();

    void setAudioSessionId(int i);

    void setSkipSilenceEnabled(boolean z);

    void setVolume(float f);

    public static final class ConfigurationException extends Exception {
        public final com.google.android.exoplayer2.d format;

        public ConfigurationException(Throwable th, com.google.android.exoplayer2.d dVar) {
            super(th);
            this.format = dVar;
        }

        public ConfigurationException(String str, com.google.android.exoplayer2.d dVar) {
            super(str);
            this.format = dVar;
        }
    }
}
