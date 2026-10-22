package com.baidu.platform.comjni;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class NativeComponent extends JNIBaseApi {
    protected volatile long mNativePointer;

    public abstract long create();

    public abstract int dispose();

    public void finalize() throws Throwable {
        dispose();
        super.finalize();
    }
}
