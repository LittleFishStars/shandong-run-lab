package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.kuaishou.weapon.p0.bf;
import com.kuaishou.weapon.p0.bn;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.ci;
import com.kuaishou.weapon.p0.dd;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class Engine {
    private static volatile Engine instance = null;
    public static volatile int loadSoCount = 0;
    public static volatile boolean loadSuccess = false;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static synchronized Engine getInstance(Context context) {
        if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
            if (instance == null) {
                instance = new Engine();
            }
            h hVarA = h.a(context, "re_po_rt");
            try {
                if (!bn.a(context, bo.d + soVersion.replace(Consts.DOT, "") + ".so")) {
                    loadSuccess = false;
                    return instance;
                }
                String strB = hVarA.b(dd.f, "");
                if (TextUtils.isEmpty(strB)) {
                    strB = soVersion;
                    hVarA.c(dd.f, strB, false);
                }
                loadSoCount = hVarA.c(dd.bg);
                if (!TextUtils.equals(strB, soVersion)) {
                    String str = soVersion;
                    loadSoCount = 0;
                    hVarA.c(dd.f, str, false);
                }
                if (loadSoCount + 1 < 10) {
                    loadSoCount++;
                    hVarA.d(dd.bg, loadSoCount);
                    System.loadLibrary(bo.d + soVersion.replace(Consts.DOT, ""));
                    bcd();
                    loadSoCount = 0;
                    loadSuccess = true;
                }
                hVarA.d(dd.bg, loadSoCount);
            } catch (Throwable th) {
                loadSuccess = false;
                try {
                    HashMap map = new HashMap();
                    map.put("e", th.getMessage());
                    map.put("v", soVersion);
                    map.put(t.d, ci.k);
                    bf.a(context, ci.b, map);
                } catch (Exception unused) {
                }
            }
        }
        return instance;
    }

    public static native int mmo(Member member, int i, int i2);

    public static native int mqc(Member member, int i);

    public static native int off();

    public static native String tao(int i, long j, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i, int i2, int i3, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i, String str);

    public native String nop();

    public native String pqr(int i, int i2, int i3, String str);

    public native String qrs();

    public native String stu(int i, int i2, int i3, int i4, String str);
}
