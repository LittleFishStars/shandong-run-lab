package com.zj.adlib;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.a;
import com.google.android.exoplayer2.video.spherical.b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nv7 implements VideoFrameMetadataListener, CameraMotionListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceTexture f43617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public byte[] f18521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f18520a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AtomicBoolean f18523b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f18517a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final em3 f18518a = new em3();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x79<Long> f18519a = new x79<>();
    public final x79<Projection> b = new x79<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f18522a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float[] f18524b = new float[16];
    public volatile int L = 0;
    public int M = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        this.f18520a.set(true);
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public void b(long j, long j2, d dVar, @Nullable MediaFormat mediaFormat) {
        this.f18519a.a(j2, Long.valueOf(j));
        g(dVar.f2570a, dVar.T, j2);
    }

    public void c(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        GlUtil.g();
        if (this.f18520a.compareAndSet(true, false)) {
            ((SurfaceTexture) sb0.g(this.f43617a)).updateTexImage();
            GlUtil.g();
            if (this.f18523b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f18522a, 0);
            }
            long timestamp = this.f43617a.getTimestamp();
            Long lG = this.f18519a.g(timestamp);
            if (lG != null) {
                this.f18518a.c(this.f18522a, lG.longValue());
            }
            Projection projectionJ = this.b.j(timestamp);
            if (projectionJ != null) {
                this.f18517a.d(projectionJ);
            }
        }
        Matrix.multiplyMM(this.f18524b, 0, fArr, 0, this.f18522a, 0);
        this.f18517a.a(this.K, this.f18524b, z);
    }

    public SurfaceTexture d() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.g();
        this.f18517a.b();
        GlUtil.g();
        this.K = GlUtil.m();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.K);
        this.f43617a = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.zj.adlib.mv7
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f43395a.e(surfaceTexture2);
            }
        });
        return this.f43617a;
    }

    public void f(int i) {
        this.L = i;
    }

    public final void g(@Nullable byte[] bArr, int i, long j) {
        byte[] bArr2 = this.f18521a;
        int i2 = this.M;
        this.f18521a = bArr;
        if (i == -1) {
            i = this.L;
        }
        this.M = i;
        if (i2 == i && Arrays.equals(bArr2, this.f18521a)) {
            return;
        }
        byte[] bArr3 = this.f18521a;
        Projection projectionA = bArr3 != null ? a.a(bArr3, this.M) : null;
        if (projectionA == null || !b.c(projectionA)) {
            projectionA = Projection.b(this.M);
        }
        this.b.a(j, projectionA);
    }

    public void h() {
        this.f18517a.e();
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotion(long j, float[] fArr) {
        this.f18518a.e(j, fArr);
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public void onCameraMotionReset() {
        this.f18519a.c();
        this.f18518a.d();
        this.f18523b.set(true);
    }
}
