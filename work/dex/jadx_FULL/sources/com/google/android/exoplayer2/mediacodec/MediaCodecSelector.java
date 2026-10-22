package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaCodecSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaCodecSelector f30764a = new MediaCodecSelector() { // from class: com.zj.adlib.yg5
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public final List getDecoderInfos(String str, boolean z, boolean z2) {
            return MediaCodecUtil.t(str, z, z2);
        }
    };

    List<c> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
