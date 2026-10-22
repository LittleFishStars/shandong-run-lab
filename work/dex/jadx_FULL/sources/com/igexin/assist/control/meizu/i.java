package com.igexin.assist.control.meizu;

import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i {
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str) {
        d dVarAa = A.a("android.os.SystemProperties").a(p3.f, String.class).aa(str, new Object[0]);
        if (dVarAa.f37786a) {
            return (String) dVarAa.b;
        }
        return null;
    }
}
