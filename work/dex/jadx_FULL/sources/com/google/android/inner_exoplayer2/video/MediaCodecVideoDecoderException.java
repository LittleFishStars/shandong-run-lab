package com.google.android.inner_exoplayer2.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.inner_exoplayer2.mediacodec.MediaCodecInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable Surface surface) {
        super(th, mediaCodecInfo);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
