package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(23)
public final class Api23Impl {
    private Api23Impl() {
    }

    @NonNull
    @RequiresPermission(Permission.RECORD_AUDIO)
    @DoNotInline
    public static AudioRecord build(@NonNull AudioRecord.Builder builder) {
        return builder.build();
    }

    @NonNull
    @DoNotInline
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    @DoNotInline
    public static void setAudioFormat(@NonNull AudioRecord.Builder builder, @NonNull AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    @DoNotInline
    public static void setAudioSource(@NonNull AudioRecord.Builder builder, int i) {
        builder.setAudioSource(i);
    }

    @DoNotInline
    public static void setBufferSizeInBytes(@NonNull AudioRecord.Builder builder, int i) {
        builder.setBufferSizeInBytes(i);
    }
}
