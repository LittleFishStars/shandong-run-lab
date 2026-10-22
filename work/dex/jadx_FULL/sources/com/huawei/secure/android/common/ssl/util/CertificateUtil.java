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
public final class CertificateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37744a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate getHwCbgRootCA(Context context) throws Throwable {
        InputStream inputStreamOpen;
        ?? r0 = 0;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(h.e);
                inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStreamOpen.reset();
                    keyStore.load(inputStreamOpen, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(h.f);
                    context = inputStreamOpen;
                } catch (IOException e) {
                    e = e;
                    e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (RuntimeException e2) {
                    e = e2;
                    e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (KeyStoreException e3) {
                    e = e3;
                    e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                } catch (CertificateException e5) {
                    e = e5;
                    e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStreamOpen;
                }
            } catch (Throwable th) {
                r0 = context;
                th = th;
                d.a((InputStream) r0);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStreamOpen = null;
            e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (RuntimeException e7) {
            e = e7;
            inputStreamOpen = null;
            e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (KeyStoreException e8) {
            e = e8;
            inputStreamOpen = null;
            e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            inputStreamOpen = null;
            e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (CertificateException e10) {
            e = e10;
            inputStreamOpen = null;
            e.b(f37744a, "loadBksCA: exception : " + e.getMessage());
            context = inputStreamOpen;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) r0);
            throw th;
        }
        d.a((InputStream) context);
        return x509Certificate;
    }
}
