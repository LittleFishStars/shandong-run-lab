package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37752a;

    public h(Context context) {
        this.f37752a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate a(String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        ?? r0 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(e);
                inputStreamOpen = this.f37752a.getAssets().open(str);
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                    str = inputStreamOpen;
                } catch (IOException e2) {
                    e = e2;
                    e.b(b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (KeyStoreException e3) {
                    e = e3;
                    e.b(b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.b(b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                } catch (CertificateException e5) {
                    e = e5;
                    e.b(b, "loadBksCA: exception : " + e.getMessage());
                    str = inputStreamOpen;
                }
            } catch (Throwable th) {
                th = th;
                r0 = str;
                d.a((InputStream) r0);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStreamOpen = null;
            e.b(b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (KeyStoreException e7) {
            e = e7;
            inputStreamOpen = null;
            e.b(b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            inputStreamOpen = null;
            e.b(b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (CertificateException e9) {
            e = e9;
            inputStreamOpen = null;
            e.b(b, "loadBksCA: exception : " + e.getMessage());
            str = inputStreamOpen;
            d.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) r0);
            throw th;
        }
        d.a((InputStream) str);
        return x509Certificate;
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }

    public X509Certificate a() {
        return a(g, h);
    }
}
