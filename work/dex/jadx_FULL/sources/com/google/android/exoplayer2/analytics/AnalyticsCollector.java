package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.zj.adlib.p82;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void N(Player player, Looper looper);

    void a(com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void c(p82 p82Var);

    void d(com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void f(p82 p82Var);

    void h(p82 p82Var);

    void i(p82 p82Var);

    void notifySeekStarted();

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDecoderReleased(String str);

    void onAudioPositionAdvancing(long j);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i, long j, long j2);

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Object obj, long j);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDecoderReleased(String str);

    void onVideoFrameProcessingOffset(long j, int i);

    void p(AnalyticsListener analyticsListener);

    void release();

    void s(List<MediaSource.a> list, @Nullable MediaSource.a aVar);

    void u(AnalyticsListener analyticsListener);
}
