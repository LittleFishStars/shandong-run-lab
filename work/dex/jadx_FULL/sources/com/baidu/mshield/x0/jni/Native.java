package com.baidu.mshield.x0.jni;

import com.baidu.mshield.b.c.a;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.f.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Native {
    public static String doExecNonStaticMethod(String str, String str2, String str3, String str4) {
        try {
            return j.a(str, str2, str3, str4);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String doExecStaticMethod(String str, String str2, String str3, String str4) {
        try {
            return j.b(str, str2, str3, str4);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String nsctl(String str, int i) {
        a.b("native shell, cmd: " + str + ", max: " + i);
        try {
            if (d.a(EngineImpl.mContext, "plc62", false) && new com.baidu.mshield.x0.l.a(EngineImpl.mContext).l() == 1) {
                return "#NULL";
            }
            return null;
        } catch (Throwable th) {
            d.a(th);
            return "#NULL";
        }
    }
}
