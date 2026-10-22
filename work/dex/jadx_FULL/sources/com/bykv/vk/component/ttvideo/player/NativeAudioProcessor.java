package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@JNINamespace("PLAYER")
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper = 0;

    @CalledByNative
    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }

    @CalledByNative
    public static boolean isNativeAudioProcessor(AudioProcessor audioProcessor) {
        return audioProcessor instanceof NativeAudioProcessor;
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioOpen(int i, int i2, int i3, int i4) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioProcess(ByteBuffer[] byteBufferArr, int i, long j) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.AudioProcessor
    public void audioRelease(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @CalledByNative
    public void setNativeWrapper(long j) {
        this.mNativeWrapper = j;
    }
}
