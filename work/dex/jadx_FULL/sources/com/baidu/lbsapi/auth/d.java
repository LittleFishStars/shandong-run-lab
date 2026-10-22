package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class d {

    public static class a {
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

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + com.alipay.sdk.m.y.l.b + packageName;
    }

    private static String a(Context context, String str) {
        StringBuilder sb;
        String strA;
        Signature[] apkContentsSigners;
        SigningInfo signingInfo;
        try {
            if (Build.VERSION.SDK_INT < 28 || (signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo) == null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                apkContentsSigners = packageInfo.signatures;
            } else {
                apkContentsSigners = signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
            }
            strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(apkContentsSigners[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getFingerPrint：");
            sb.append(e.toString());
            b.a(sb.toString());
            strA = "";
        } catch (CertificateException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getFingerPrint：");
            sb.append(e.toString());
            b.a(sb.toString());
            strA = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (strA != null) {
            for (int i = 0; i < strA.length(); i++) {
                stringBuffer.append(strA.charAt(i));
                if (i > 0 && i % 2 == 1 && i < strA.length() - 1) {
                    stringBuffer.append(u15.f19942b);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            b.a("getFingerprintAs：" + e.toString());
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            b.a("generateSHA1：" + e.toString());
            return null;
        }
    }

    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] strArrB = b(context, packageName);
        if (strArrB == null || strArrB.length <= 0) {
            return null;
        }
        int length = strArrB.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = strArrB[i] + com.alipay.sdk.m.y.l.b + packageName;
            if (b.f26304a) {
                b.a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    private static String[] b(Context context, String str) {
        String[] strArr;
        StringBuilder sb;
        Signature[] apkContentsSigners;
        SigningInfo signingInfo;
        String[] strArr2 = null;
        try {
            if (Build.VERSION.SDK_INT < 28 || (signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo) == null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                apkContentsSigners = packageInfo.signatures;
            } else {
                apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            }
            if (apkContentsSigners == null || apkContentsSigners.length <= 0) {
                strArr = null;
            } else {
                strArr = new String[apkContentsSigners.length];
                for (int i = 0; i < apkContentsSigners.length; i++) {
                    try {
                        strArr[i] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(apkContentsSigners[i].toByteArray())));
                    } catch (PackageManager.NameNotFoundException e) {
                        e = e;
                        sb = new StringBuilder();
                        sb.append("getFingerPrint：");
                        sb.append(e.toString());
                        b.a(sb.toString());
                    } catch (CertificateException e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("getFingerPrint：");
                        sb.append(e.toString());
                        b.a(sb.toString());
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            strArr = null;
        } catch (CertificateException e4) {
            e = e4;
            strArr = null;
        }
        if (strArr != null && strArr.length > 0) {
            strArr2 = new String[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < strArr[i2].length(); i3++) {
                    stringBuffer.append(strArr[i2].charAt(i3));
                    if (i3 > 0 && i3 % 2 == 1 && i3 < strArr[i2].length() - 1) {
                        stringBuffer.append(u15.f19942b);
                    }
                }
                strArr2[i2] = stringBuffer.toString();
            }
        }
        return strArr2;
    }
}
