package com.zj.adlib;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.hw.videoprocessor.util.VideoProgressListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class xe0 extends Thread implements VideoProgressListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f45804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaExtractor f20649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaMuxer f20650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jo9.c f20651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ko9 f20652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Exception f20653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Float f20654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f20655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CountDownLatch f20656a;
    public Integer b;

    public xe0(Context context, jo9.c cVar, MediaMuxer mediaMuxer, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f, int i, CountDownLatch countDownLatch) {
        super("VideoProcessDecodeThread");
        this.f20651a = cVar;
        this.f20655a = num;
        this.b = num2;
        this.f20654a = f;
        this.f20650a = mediaMuxer;
        this.f45804a = context;
        this.K = i;
        this.f20649a = new MediaExtractor();
        this.f20656a = countDownLatch;
    }

    public final void b() throws Exception {
        this.f20651a.a(this.f20649a);
        int iM = np9.m(this.f20649a, true);
        if (iM >= 0) {
            this.f20649a.selectTrack(iM);
            MediaFormat trackFormat = this.f20649a.getTrackFormat(iM);
            String string = trackFormat.containsKey("mime") ? trackFormat.getString("mime") : "audio/mp4a-latm";
            Integer num = this.f20655a;
            Integer numValueOf = num == null ? null : Integer.valueOf(num.intValue() * 1000);
            Integer num2 = this.b;
            Integer numValueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * 1000) : null;
            if (!this.f20656a.await(3L, TimeUnit.SECONDS)) {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
            if (this.f20654a == null && string.equals("audio/mp4a-latm")) {
                gg0.v(this.f20649a, this.f20650a, this.K, numValueOf, numValueOf2, this);
            } else {
                Context context = this.f45804a;
                MediaExtractor mediaExtractor = this.f20649a;
                MediaMuxer mediaMuxer = this.f20650a;
                int i = this.K;
                Float f = this.f20654a;
                gg0.w(context, mediaExtractor, mediaMuxer, i, numValueOf, numValueOf2, Float.valueOf(f == null ? 1.0f : f.floatValue()), this);
            }
        }
        ko9 ko9Var = this.f20652a;
        if (ko9Var != null) {
            ko9Var.a(1.0f);
        }
        v61.k("Audio Process Done!", new Object[0]);
    }

    public Exception c() {
        return this.f20653a;
    }

    public void d(ko9 ko9Var) {
        this.f20652a = ko9Var;
    }

    @Override // com.hw.videoprocessor.util.VideoProgressListener
    public void onProgress(float f) {
        ko9 ko9Var = this.f20652a;
        if (ko9Var != null) {
            ko9Var.a(f);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                b();
            } catch (Exception e) {
                this.f20653a = e;
                v61.g(e);
            }
        } finally {
            this.f20649a.release();
        }
    }
}
