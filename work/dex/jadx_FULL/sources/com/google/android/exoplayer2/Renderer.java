package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import com.zj.adlib.at6;
import com.zj.adlib.ue7;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Renderer extends PlayerMessage.Target {
    public static final int V1 = 6;
    public static final int W1 = 7;
    public static final int Z0 = 1;
    public static final int b1 = 2;
    public static final int c1 = 3;
    public static final int g1 = 4;
    public static final int g2 = 8;
    public static final int j1 = 5;
    public static final int j2 = 9;
    public static final int k2 = 10;
    public static final int l2 = 11;
    public static final int m2 = 10000;
    public static final int o2 = 0;
    public static final int p2 = 1;
    public static final int w2 = 2;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface WakeupListener {
        void onSleep();

        void onWakeup();
    }

    RendererCapabilities a();

    @Nullable
    MediaClock d();

    void disable();

    void f(d[] dVarArr, SampleStream sampleStream, long j, long j3) throws ExoPlaybackException;

    void g(int i, at6 at6Var);

    String getName();

    long getReadingPositionUs();

    int getState();

    int getTrackType();

    @Nullable
    SampleStream h();

    boolean hasReadStreamToEnd();

    void i(ue7 ue7Var, d[] dVarArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j3, long j4) throws ExoPlaybackException;

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j, long j3) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    default void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
    }

    void start() throws ExoPlaybackException;

    void stop();
}
