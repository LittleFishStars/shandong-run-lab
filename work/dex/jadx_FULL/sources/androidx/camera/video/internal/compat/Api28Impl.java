package androidx.camera.video.internal.compat;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(28)
public final class Api28Impl {
    private Api28Impl() {
    }

    @NonNull
    @DoNotInline
    public static Range<Integer> getQualityRange(@NonNull MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        return encoderCapabilities.getQualityRange();
    }
}
