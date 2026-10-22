package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.editor.AliyunIEditor;
import com.aliyun.svideosdk.editor.AliyunIPlayerController;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class s implements AliyunIPlayerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AliyunIEditor f25761a;

    public s(AliyunIEditor aliyunIEditor) {
        this.f25761a = aliyunIEditor;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getCurrentPlayPosition() {
        return TimeUnit.MICROSECONDS.toMillis(this.f25761a.getCurrentPlayPosition());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getCurrentStreamPosition() {
        return TimeUnit.MICROSECONDS.toMillis(this.f25761a.getCurrentStreamPosition());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getDuration() {
        return TimeUnit.MICROSECONDS.toMillis(this.f25761a.getDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getStreamDuration() {
        return TimeUnit.MICROSECONDS.toMillis(this.f25761a.getStreamDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isMute() {
        return this.f25761a.isAudioSilence();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isPaused() {
        return this.f25761a.isPaused();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isPlaying() {
        return this.f25761a.isPlaying();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int pause() {
        return this.f25761a.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int play() {
        return this.f25761a.play();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int replay() {
        return this.f25761a.replay();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int resume() {
        return this.f25761a.resume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int seek(long j, TimeUnit timeUnit) {
        return this.f25761a.seek(j, timeUnit);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public void setMute(boolean z) {
        this.f25761a.setAudioSilence(z);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int setVolume(int i) {
        return this.f25761a.setVolume(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int stop() {
        return this.f25761a.stop();
    }
}
