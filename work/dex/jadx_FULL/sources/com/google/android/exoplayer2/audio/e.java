package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.zj.adlib.at6;
import com.zj.adlib.pi0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e implements AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioSink f30564a;

    public e(AudioSink audioSink) {
        this.f30564a = audioSink;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(com.google.android.exoplayer2.d dVar) {
        return this.f30564a.a(dVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.j b() {
        return this.f30564a.b();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(com.google.android.exoplayer2.j jVar) {
        this.f30564a.c(jVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    @Nullable
    public a d() {
        return this.f30564a.d();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        this.f30564a.disableTunneling();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(pi0 pi0Var) {
        this.f30564a.e(pi0Var);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21() {
        this.f30564a.enableTunnelingV21();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        this.f30564a.experimentalFlushWithoutAudioTrackRelease();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int f(com.google.android.exoplayer2.d dVar) {
        return this.f30564a.f(dVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        this.f30564a.flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(com.google.android.exoplayer2.d dVar, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        this.f30564a.g(dVar, i, iArr);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        return this.f30564a.getCurrentPositionUs(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return this.f30564a.getSkipSilenceEnabled();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(@Nullable at6 at6Var) {
        this.f30564a.h(at6Var);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws AudioSink.WriteException, AudioSink.InitializationException {
        return this.f30564a.handleBuffer(byteBuffer, j, i);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.f30564a.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return this.f30564a.hasPendingData();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i(AudioSink.Listener listener) {
        this.f30564a.i(listener);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return this.f30564a.isEnded();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j(a aVar) {
        this.f30564a.j(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.f30564a.pause();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.f30564a.play();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        this.f30564a.playToEndOfStream();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.f30564a.reset();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        this.f30564a.setAudioSessionId(i);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        this.f30564a.setSkipSilenceEnabled(z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        this.f30564a.setVolume(f);
    }
}
