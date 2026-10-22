package com.hzchengdun.securityguard.adapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class JNICLibrary {
    static {
        try {
            System.loadLibrary("osmss3rd-0.0.4");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("WARNING: Could not load library!");
        }
    }

    public static native Object doCommand(int i, Object... objArr);
}
