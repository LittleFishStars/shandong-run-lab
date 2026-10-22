package com.alipay.sdk.m.s0;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import com.ipd.dsp.internal.q.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    public static d j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25505a;
    public e c;
    public String d;
    public String e;
    public com.alipay.sdk.m.r0.a f;
    public com.alipay.sdk.m.r0.a g;
    public static final Object i = new Object();
    public static final String k = ".UTSystemConfig" + File.separator + "Global";
    public String b = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.f25505a = null;
        this.c = null;
        this.d = "xx_utdid_key";
        this.e = "xx_utdid_domain";
        this.f = null;
        this.g = null;
        this.f25505a = context;
        this.g = new com.alipay.sdk.m.r0.a(context, k, "Alvin2", false, true);
        this.f = new com.alipay.sdk.m.r0.a(context, ".DataStorage", "ContextData", false, true);
        this.c = new e();
        this.d = String.format("K_%d", Integer.valueOf(com.alipay.sdk.m.q0.f.a(this.d)));
        this.e = String.format("D_%d", Integer.valueOf(com.alipay.sdk.m.q0.f.a(this.e)));
    }

    public final void a() {
        boolean z;
        com.alipay.sdk.m.r0.a aVar = this.g;
        if (aVar != null) {
            if (com.alipay.sdk.m.q0.f.b(aVar.a("UTDID2"))) {
                String strA = this.g.a("UTDID");
                if (!com.alipay.sdk.m.q0.f.b(strA)) {
                    b(strA);
                }
            }
            boolean z2 = true;
            if (com.alipay.sdk.m.q0.f.b(this.g.a("DID"))) {
                z = false;
            } else {
                this.g.b("DID");
                z = true;
            }
            if (!com.alipay.sdk.m.q0.f.b(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (com.alipay.sdk.m.q0.f.b(this.g.a("SI"))) {
                z2 = z;
            } else {
                this.g.b("SI");
            }
            if (z2) {
                this.g.b();
            }
        }
    }

    public final void b(String str) {
        com.alipay.sdk.m.r0.a aVar;
        if (a(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.g) == null) {
                return;
            }
            aVar.a("UTDID2", str);
            this.g.b();
        }
    }

    public final void c(String str) {
        com.alipay.sdk.m.r0.a aVar;
        if (str == null || (aVar = this.f) == null || str.equals(aVar.a(this.d))) {
            return;
        }
        this.f.a(this.d, str);
        this.f.b();
    }

    public synchronized String d() {
        try {
            String strF = f();
            this.b = strF;
            if (!TextUtils.isEmpty(strF)) {
                return this.b;
            }
            try {
                byte[] bArrB = b();
                if (bArrB != null) {
                    String strC = com.alipay.sdk.m.q0.b.c(bArrB, 2);
                    this.b = strC;
                    b(strC);
                    String strA = this.c.a(bArrB);
                    if (strA != null) {
                        c(strA);
                    }
                    return this.b;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String e() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return d();
    }

    public synchronized String f() {
        String strC = c();
        if (a(strC)) {
            c(this.c.a(strC));
            this.b = strC;
            return strC;
        }
        String strA = this.f.a(this.d);
        if (!com.alipay.sdk.m.q0.f.b(strA)) {
            String strA2 = new f().a(strA);
            if (!a(strA2)) {
                strA2 = this.c.b(strA);
            }
            if (a(strA2) && !com.alipay.sdk.m.q0.f.b(strA2)) {
                this.b = strA2;
                b(strA2);
                return this.b;
            }
        }
        return null;
    }

    public final String c() {
        com.alipay.sdk.m.r0.a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        String strA = aVar.a("UTDID2");
        if (com.alipay.sdk.m.q0.f.b(strA) || this.c.a(strA) == null) {
            return null;
        }
        return strA;
    }

    public final byte[] b() throws Exception {
        String strA;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrA = com.alipay.sdk.m.q0.c.a(iCurrentTimeMillis);
        byte[] bArrA2 = com.alipay.sdk.m.q0.c.a(iNextInt);
        byteArrayOutputStream.write(bArrA, 0, 4);
        byteArrayOutputStream.write(bArrA2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strA = com.alipay.sdk.m.q0.d.a(this.f25505a);
        } catch (Exception unused) {
            strA = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.alipay.sdk.m.q0.c.a(com.alipay.sdk.m.q0.f.a(strA)), 0, 4);
        byteArrayOutputStream.write(com.alipay.sdk.m.q0.c.a(com.alipay.sdk.m.q0.f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static d a(Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    d dVar = new d(context);
                    j = dVar;
                    dVar.a();
                }
            }
        }
        return j;
    }

    public final boolean a(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, u.v7, u.B7, 86, -11, 11, -78, -96, -17, -99, SignedBytes.f32242a, com.google.common.base.a.A, -95, -126, -82, u.n7, 113, 116, -16, -103, com.alibaba.ariver.resource.parser.a.e.j, -30, 9, u.D7, com.google.android.exoplayer2.text.cea.a.e, -80, -68, -78, -117, com.alibaba.ariver.resource.parser.a.e.n, com.google.common.base.a.H, -122, SignedBytes.f32242a, -104, 74, u.z7, 106, 85, u.A7, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.alipay.sdk.m.q0.e.a(bArr2), mac.getAlgorithm()));
        return com.alipay.sdk.m.q0.b.c(mac.doFinal(bArr), 2);
    }
}
