package com.fl.saas.adx.base.innterNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum NativeStyle {
    NONE,
    EXPRESS,
    NATIVE;

    public static NativeStyle create(int i) {
        if (i != 1) {
            return i != 2 ? NONE : NATIVE;
        }
        return EXPRESS;
    }
}
