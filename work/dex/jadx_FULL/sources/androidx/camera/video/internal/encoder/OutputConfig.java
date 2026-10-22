package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface OutputConfig {
    @Nullable
    MediaFormat getMediaFormat();
}
