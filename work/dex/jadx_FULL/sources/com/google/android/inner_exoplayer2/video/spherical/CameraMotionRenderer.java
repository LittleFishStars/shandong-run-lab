package com.google.android.inner_exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.BaseRenderer;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.RendererCapabilities;
import com.google.android.inner_exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.android.inner_exoplayer2.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CameraMotionRenderer extends BaseRenderer {
    private static final int SAMPLE_WINDOW_DURATION_US = 100000;
    private static final String TAG = "CameraMotionRenderer";
    private final DecoderInputBuffer buffer;
    private long lastTimestampUs;

    @Nullable
    private CameraMotionListener listener;
    private long offsetUs;
    private final ParsableByteArray scratch;

    public CameraMotionRenderer() {
        super(6);
        this.buffer = new DecoderInputBuffer(1);
        this.scratch = new ParsableByteArray();
    }

    @Nullable
    private float[] parseMetadata(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.scratch.reset(byteBuffer.array(), byteBuffer.limit());
        this.scratch.setPosition(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.scratch.readLittleEndianInt());
        }
        return fArr;
    }

    private void resetListener() {
        CameraMotionListener cameraMotionListener = this.listener;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.inner_exoplayer2.Renderer, com.google.android.inner_exoplayer2.RendererCapabilities
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.inner_exoplayer2.BaseRenderer, com.google.android.inner_exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) {
        if (i == 8) {
            this.listener = (CameraMotionListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.inner_exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.inner_exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.inner_exoplayer2.BaseRenderer
    public void onDisabled() {
        resetListener();
    }

    @Override // com.google.android.inner_exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.lastTimestampUs = Long.MIN_VALUE;
        resetListener();
    }

    @Override // com.google.android.inner_exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.offsetUs = j2;
    }

    @Override // com.google.android.inner_exoplayer2.Renderer
    public void render(long j, long j2) {
        while (!hasReadStreamToEnd() && this.lastTimestampUs < 100000 + j) {
            this.buffer.clear();
            if (readSource(getFormatHolder(), this.buffer, 0) != -4 || this.buffer.isEndOfStream()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.buffer;
            this.lastTimestampUs = decoderInputBuffer.timeUs;
            if (this.listener != null && !decoderInputBuffer.isDecodeOnly()) {
                this.buffer.flip();
                float[] metadata = parseMetadata((ByteBuffer) Util.castNonNull(this.buffer.data));
                if (metadata != null) {
                    ((CameraMotionListener) Util.castNonNull(this.listener)).onCameraMotion(this.lastTimestampUs - this.offsetUs, metadata);
                }
            }
        }
    }

    @Override // com.google.android.inner_exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        return "application/x-camera-motion".equals(format.sampleMimeType) ? RendererCapabilities.create(4) : RendererCapabilities.create(0);
    }
}
