package com.google.android.inner_exoplayer2;

import android.os.Handler;
import com.google.android.inner_exoplayer2.audio.AudioRendererEventListener;
import com.google.android.inner_exoplayer2.metadata.MetadataOutput;
import com.google.android.inner_exoplayer2.text.TextOutput;
import com.google.android.inner_exoplayer2.video.VideoRendererEventListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface RenderersFactory {
    Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput);
}
