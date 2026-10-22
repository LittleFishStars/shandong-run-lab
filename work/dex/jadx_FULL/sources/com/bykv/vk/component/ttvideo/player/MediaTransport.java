package com.bykv.vk.component.ttvideo.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@JNINamespace("PLAYER")
public abstract class MediaTransport extends NativeObject {
    public static final int FILTER_AUDIO = 2;
    public static final int FILTER_VIDEO = 1;

    @Keep
    public static class MediaPacket {
        public static final int CODEC_ID_AAC = 2;
        public static final int CODEC_ID_BYTE_VC1 = 1;
        public static final int CODEC_ID_H264 = 0;
        public static final int FLAG_CONFIG_FRAME = 1;
        public static final int FLAG_IS_DECODED_ONLY = 3;
        public static final int FLAG_KEY_FRAME = 2;
        public ByteBuffer mBuffer;
        public int mCodecId;
        public int mFlags;
        public boolean mIsAccessUnit;
        public boolean mIsVideo;
        public int mOffset;
        public long mPresentationTimeMs;
        public int mSize;

        @CalledByNative("MediaPacket")
        public MediaPacket() {
        }

        @CalledByNative("MediaPacket")
        public void set(ByteBuffer byteBuffer, boolean z, boolean z2, int i, int i2, long j, int i3, int i4) {
            this.mBuffer = byteBuffer;
            this.mOffset = i;
            this.mSize = i2;
            this.mPresentationTimeMs = j;
            this.mFlags = i3;
            this.mIsVideo = z;
            this.mCodecId = i4;
            this.mIsAccessUnit = z2;
        }
    }

    private native void nativeSetFilterType(int i);

    @CalledByNative
    public abstract void sendPacket(MediaPacket mediaPacket);

    public void setFilterType(int i) {
        nativeSetFilterType(i);
    }
}
