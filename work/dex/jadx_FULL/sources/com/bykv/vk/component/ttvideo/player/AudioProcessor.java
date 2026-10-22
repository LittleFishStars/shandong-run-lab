package com.bykv.vk.component.ttvideo.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@JNINamespace("PLAYER")
public abstract class AudioProcessor extends NativeObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int RELEASE_REASEON_OSPLAYER_CREATED = 1;
    public static final int RELEASE_REASEON_TTPLAYER_NORMAL_CALL = 2;

    @CalledByNative
    public abstract void audioClose();

    @CalledByNative
    public abstract void audioOpen(int i, int i2, int i3, int i4);

    @CalledByNative
    public abstract void audioProcess(ByteBuffer[] byteBufferArr, int i, long j);

    @CalledByNative
    public abstract void audioRelease(int i);
}
