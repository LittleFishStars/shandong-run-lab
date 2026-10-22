package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.util.a$a, reason: collision with other inner class name */
    public static class C0274a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & com.google.common.base.a.q]);
            }
            return sb.toString();
        }
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + l.b + packageName;
    }

    private static String a(Context context, String str) {
        String strA;
        Signature[] signingCertificateHistory;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.hasMultipleSigners()) {
                    signingCertificateHistory = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners();
                } else {
                    signingCertificateHistory = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
                }
            } else {
                signingCertificateHistory = context.getPackageManager().getPackageInfo(str, 64).signatures;
            }
            strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signingCertificateHistory[0].toByteArray())));
        } catch (Exception e) {
            e.printStackTrace();
            strA = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strA.length(); i++) {
            stringBuffer.append(strA.charAt(i));
            if (i > 0 && i % 2 == 1 && i < strA.length() - 1) {
                stringBuffer.append(u15.f19942b);
            }
        }
        return stringBuffer.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return C0274a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
