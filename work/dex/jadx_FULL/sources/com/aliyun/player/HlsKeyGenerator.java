package com.aliyun.player;

import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HlsKeyGenerator {
    private static HlsKeyGenerator instance;
    private OnKeyGenerateListener mOnKeyGenerateListener = null;

    public interface OnKeyGenerateListener {
        byte[] getHlsKey(String str, String str2);

        void onHlsKeyInfoInit(String str, int i, String str2);
    }

    static {
        f.b();
        instance = null;
    }

    private HlsKeyGenerator() {
    }

    private static byte[] getHlsKey(String str, String str2) {
        OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            return onKeyGenerateListener.getHlsKey(str, str2);
        }
        return null;
    }

    public static HlsKeyGenerator getInstance() {
        if (instance == null) {
            synchronized (HlsKeyGenerator.class) {
                if (instance == null) {
                    instance = new HlsKeyGenerator();
                }
            }
        }
        return instance;
    }

    public static void loadClass() {
    }

    private static void onHlsKeyInfoInit(String str, int i, String str2) {
        OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            onKeyGenerateListener.onHlsKeyInfoInit(str, i, str2);
        }
    }

    public void setOnKeyGenerateListener(OnKeyGenerateListener onKeyGenerateListener) {
        this.mOnKeyGenerateListener = onKeyGenerateListener;
    }
}
