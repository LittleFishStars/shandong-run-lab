package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l4b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f42997a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static String a() {
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String str = j4b.d() ? "1" : "0";
            int length = strValueOf.length();
            return strValueOf.substring(0, length - 2) + str + strValueOf.substring(length - 1);
        } catch (Throwable th) {
            v6b.b(th, "CI", "TS");
            return null;
        }
    }

    public static String b(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.d = j4b.g(context);
            aVar.i = j4b.h(context);
            return d(aVar);
        } catch (Throwable th) {
            v6b.b(th, "CI", "IX");
            return null;
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return p4b.d(j4b.i(context) + u15.f19942b + str.substring(0, str.length() - 3) + u15.f19942b + str2);
        } catch (Throwable th) {
            v6b.b(th, "CI", "Sco");
            return null;
        }
    }

    public static String d(a aVar) {
        return m4b.f(j(aVar));
    }

    public static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            s4b.k(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            s4b.k(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, s4b.p(str));
        }
    }

    public static byte[] f(Context context, boolean z, boolean z2) {
        try {
            return j(h(context, z, z2));
        } catch (Throwable th) {
            v6b.b(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        return m4b.b(bArr);
    }

    public static a h(Context context, boolean z, boolean z2) {
        a aVar = new a((byte) 0);
        aVar.f42997a = fj.L();
        aVar.b = fj.G();
        String strN = fj.N(context);
        if (strN == null) {
            strN = "";
        }
        aVar.c = strN;
        aVar.d = j4b.g(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = j4b.e(context);
        aVar.i = j4b.h(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = fj.h0(context);
        aVar.l = fj.b0(context);
        StringBuilder sb = new StringBuilder();
        sb.append(fj.Y(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fj.X(context));
        aVar.n = sb2.toString();
        aVar.o = fj.j0(context);
        aVar.p = fj.V(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] strArrI = fj.I();
            aVar.s = strArrI[0];
            aVar.t = strArrI[1];
        }
        aVar.w = fj.s();
        String strT = fj.t(context);
        if (TextUtils.isEmpty(strT)) {
            aVar.x = "";
        } else {
            aVar.x = strT;
        }
        aVar.y = "aid=" + fj.S(context);
        if ((z2 && s6b.f19529a) || s6b.f19532b) {
            String strM = fj.M(context);
            if (!TextUtils.isEmpty(strM)) {
                aVar.y += "|oaid=" + strM;
            }
        }
        String strJ = fj.J();
        if (!TextUtils.isEmpty(strJ)) {
            aVar.y += "|multiImeis=" + strJ;
        }
        String strG0 = fj.g0(context);
        if (!TextUtils.isEmpty(strG0)) {
            aVar.y += "|meid=" + strG0;
        }
        aVar.y += "|serial=" + fj.Q(context);
        String strZ = fj.z();
        if (!TextUtils.isEmpty(strZ)) {
            aVar.y += "|adiuExtras=" + strZ;
        }
        aVar.y += "|storage=" + fj.P() + "|ram=" + fj.i0(context) + "|arch=" + fj.R();
        String strB = t6b.a().b();
        if (TextUtils.isEmpty(strB)) {
            aVar.z = "";
        } else {
            aVar.z = strB;
        }
        return aVar;
    }

    public static String i(Context context) {
        return l(context);
    }

    public static byte[] j(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                e(byteArrayOutputStream, aVar.f42997a);
                e(byteArrayOutputStream, aVar.b);
                e(byteArrayOutputStream, aVar.c);
                e(byteArrayOutputStream, aVar.d);
                e(byteArrayOutputStream, aVar.e);
                e(byteArrayOutputStream, aVar.f);
                e(byteArrayOutputStream, aVar.g);
                e(byteArrayOutputStream, aVar.h);
                e(byteArrayOutputStream, aVar.i);
                e(byteArrayOutputStream, aVar.j);
                e(byteArrayOutputStream, aVar.k);
                e(byteArrayOutputStream, aVar.l);
                e(byteArrayOutputStream, aVar.m);
                e(byteArrayOutputStream, aVar.n);
                e(byteArrayOutputStream, aVar.o);
                e(byteArrayOutputStream, aVar.p);
                e(byteArrayOutputStream, aVar.q);
                e(byteArrayOutputStream, aVar.r);
                e(byteArrayOutputStream, aVar.s);
                e(byteArrayOutputStream, aVar.t);
                e(byteArrayOutputStream, aVar.u);
                e(byteArrayOutputStream, aVar.v);
                e(byteArrayOutputStream, aVar.w);
                e(byteArrayOutputStream, aVar.x);
                e(byteArrayOutputStream, aVar.y);
                e(byteArrayOutputStream, aVar.z);
                byte[] bArrK = k(s4b.u(byteArrayOutputStream.toByteArray()));
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return bArrK;
            } catch (Throwable th2) {
                th = th2;
                try {
                    v6b.b(th, "CI", "gzx");
                    return null;
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] k(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        PublicKey publicKeyY = s4b.y();
        if (bArr.length <= 117) {
            return m4b.c(bArr, publicKeyY);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] bArrC = m4b.c(bArr2, publicKeyY);
        byte[] bArr3 = new byte[(bArr.length + 128) - 117];
        System.arraycopy(bArrC, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    public static String l(Context context) {
        try {
            return d(h(context, false, false));
        } catch (Throwable th) {
            v6b.b(th, "CI", "gCXi");
            return null;
        }
    }
}
