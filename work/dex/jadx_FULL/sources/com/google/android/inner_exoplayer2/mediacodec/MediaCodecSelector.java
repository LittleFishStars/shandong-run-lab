package com.google.android.inner_exoplayer2.mediacodec;

import com.google.android.inner_exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: com.zj.adlib.xg5
        @Override // com.google.android.inner_exoplayer2.mediacodec.MediaCodecSelector
        public final List getDecoderInfos(String str, boolean z, boolean z2) {
            return MediaCodecUtil.getDecoderInfos(str, z, z2);
        }
    };

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2);
}
