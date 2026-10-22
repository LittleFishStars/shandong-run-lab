package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@JNINamespace("PLAYER")
public class NativeSubInfo extends SubInfo {
    @CalledByNative
    private static boolean isNativeSubInfo(SubInfo subInfo) {
        return subInfo instanceof NativeSubInfo;
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    public void onSubInfoCallback(int i, int i2, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    public void onSubInfoCallback2(int i, String str) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    public void onSubLoadFinished(int i) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.bykv.vk.component.ttvideo.player.SubInfo
    public void onSubSwitchCompleted(int i, int i2) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
