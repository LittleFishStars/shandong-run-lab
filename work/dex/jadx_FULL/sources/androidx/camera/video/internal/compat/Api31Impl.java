package androidx.camera.video.internal.compat;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(31)
public final class Api31Impl {
    private Api31Impl() {
    }

    @NonNull
    @DoNotInline
    public static Range<Integer>[] getInputChannelCountRanges(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getInputChannelCountRanges();
    }

    @DoNotInline
    public static int getMinInputChannelCount(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getMinInputChannelCount();
    }

    @DoNotInline
    public static void setContext(@NonNull AudioRecord.Builder builder, @NonNull Context context) {
        builder.setContext(context);
    }
}
