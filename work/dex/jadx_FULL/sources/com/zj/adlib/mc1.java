package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mc1 extends BaseRenderer {
    public static final int N = 100000;
    public static final String f = "CameraMotionRenderer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DecoderInputBuffer f43267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public CameraMotionListener f18173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f18174a;
    public long d;
    public long e;

    public mc1() {
        super(6);
        this.f43267a = new DecoderInputBuffer(1);
        this.f18174a = new om6();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int e(d dVar) {
        return "application/x-camera-motion".equals(dVar.k) ? RendererCapabilities.create(4) : RendererCapabilities.create(0);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return f;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 8) {
            this.f18173a = (CameraMotionListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Nullable
    public final float[] k(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f18174a.Q(byteBuffer.array(), byteBuffer.limit());
        this.f18174a.S(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.f18174a.r());
        }
        return fArr;
    }

    public final void l() {
        CameraMotionListener cameraMotionListener = this.f18173a;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        l();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.e = Long.MIN_VALUE;
        l();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(d[] dVarArr, long j, long j2) {
        this.d = j2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        while (!hasReadStreamToEnd() && this.e < 100000 + j) {
            this.f43267a.b();
            if (readSource(getFormatHolder(), this.f43267a, 0) != -4 || this.f43267a.f()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f43267a;
            this.e = decoderInputBuffer.f30576a;
            if (this.f18173a != null && !decoderInputBuffer.e()) {
                this.f43267a.l();
                float[] fArrK = k((ByteBuffer) gj9.k(this.f43267a.f2588a));
                if (fArrK != null) {
                    ((CameraMotionListener) gj9.k(this.f18173a)).onCameraMotion(this.e - this.d, fArrK);
                }
            }
        }
    }
}
