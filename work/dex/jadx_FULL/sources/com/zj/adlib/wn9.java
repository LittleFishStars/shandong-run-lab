package com.zj.adlib;

import com.hw.videoprocessor.util.VideoProgressListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class wn9 implements VideoProgressListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f45640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VideoProgressListener f20474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f20475a;

    public wn9(float[] fArr, VideoProgressListener videoProgressListener) {
        this.f20475a = fArr;
        this.f20474a = videoProgressListener;
    }

    public void a(int i) {
        this.K = i;
        this.f45640a = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            this.f45640a += this.f20475a[i2];
        }
    }

    public void b(VideoProgressListener videoProgressListener) {
        this.f20474a = videoProgressListener;
    }

    @Override // com.hw.videoprocessor.util.VideoProgressListener
    public void onProgress(float f) {
        VideoProgressListener videoProgressListener = this.f20474a;
        if (videoProgressListener != null) {
            videoProgressListener.onProgress((f * this.f20475a[this.K]) + this.f45640a);
        }
    }
}
