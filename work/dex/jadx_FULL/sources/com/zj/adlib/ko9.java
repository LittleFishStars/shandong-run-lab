package com.zj.adlib;

import com.hw.videoprocessor.util.VideoProgressListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ko9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VideoProgressListener f17764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Float f17765a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f17766b;

    public ko9(VideoProgressListener videoProgressListener) {
        this.f17764a = videoProgressListener;
    }

    public void a(float f) {
        this.b = f;
        VideoProgressListener videoProgressListener = this.f17764a;
        if (videoProgressListener != null) {
            videoProgressListener.onProgress((this.f42873a + f) / 2.0f);
        }
        v61.k("mAudioProgress:" + this.b, new Object[0]);
    }

    public void b(long j) {
        if (this.f17764a == null) {
            return;
        }
        Float f = this.f17765a;
        if (f != null) {
            j = (long) (j * f.floatValue());
        }
        float f2 = (j / 1000.0f) / (this.f17766b - this.f17763a);
        this.f42873a = f2;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f42873a = f2;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f42873a = f2;
        this.f17764a.onProgress((f2 + this.b) / 2.0f);
        v61.k("mEncodeProgress:" + this.f42873a, new Object[0]);
    }

    public void c(int i) {
        this.f17766b = i;
    }

    public void d(Float f) {
        this.f17765a = f;
    }

    public void e(int i) {
        this.f17763a = i;
    }
}
