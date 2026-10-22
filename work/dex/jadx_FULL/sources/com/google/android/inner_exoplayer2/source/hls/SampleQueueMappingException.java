package com.google.android.inner_exoplayer2.source.hls;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@Nullable String str) {
        super("Unable to bind a sample queue to TrackGroup with mime type " + str + Consts.DOT);
    }
}
