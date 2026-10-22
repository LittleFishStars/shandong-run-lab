package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public abstract class EditorCallBack {
    public static final int RENDER_CALLBACK_CUSTOM = 1;
    public static final int RENDER_CALLBACK_NONE = 0;
    public static final int RENDER_CALLBACK_TEXTURE = 2;
    public int mNeedRenderCallback = 0;
    public boolean mNeedPacketCallback = false;

    public abstract int onCustomRender(int i, int i2, int i3, long j);

    public abstract void onDataReady();

    public abstract void onEnd(int i);

    public abstract void onError(int i);

    public void onPacketSeek(long j, int i) {
    }

    public abstract void onPlayProgress(long j, long j2);

    public void onPlayStateChanged(boolean z) {
    }

    public void onRenderDestroy() {
    }

    public void onRenderSetup() {
    }

    public abstract int onTextureRender(int i, int i2, int i3, long j);

    public void onWritePacket(ByteBuffer byteBuffer, int i) {
    }
}
