package com.ipd.dsp.internal.f0;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38303a = 10;
    public static final int b = 307;
    public static final int c = 308;

    @NonNull
    public static String a(com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a, int i) throws IOException {
        String strA = interfaceC0886a.a("Location");
        if (strA != null) {
            return strA;
        }
        throw new ProtocolException("Response code is " + i + " but can't find Location field");
    }

    public static boolean a(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }
}
