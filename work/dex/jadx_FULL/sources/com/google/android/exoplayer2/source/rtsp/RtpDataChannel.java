package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
interface RtpDataChannel extends DataSource {

    public interface Factory {
        RtpDataChannel a(int i) throws IOException;

        @Nullable
        default Factory b() {
            return null;
        }
    }

    String e();

    @Nullable
    RtspMessageChannel.InterleavedBinaryDataListener f();

    int getLocalPort();
}
