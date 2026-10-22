package com.baidu.mshield.b.f;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {
    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        com.baidu.mshield.b.c.a.a(th);
                        return new Certificate[0];
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    }
                }
            } while (bufferedInputStream2.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream2.close();
            } catch (IOException unused2) {
            }
            return certificates;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PublicKey a(Signature signature) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            try {
                PublicKey publicKey = certificateFactory.generateCertificate(byteArrayInputStream).getPublicKey();
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused) {
                }
                return publicKey;
            } catch (Throwable th) {
                th = th;
                try {
                    com.baidu.mshield.b.c.a.a(th);
                    return null;
                } finally {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
        }
    }

    public static PublicKey a(String str) {
        JarFile jarFile;
        int i;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[8192];
            jarFile = new JarFile(str);
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                Certificate[] certificateArr = null;
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    if (!jarEntryNextElement.isDirectory()) {
                        String name = jarEntryNextElement.getName();
                        if (!name.contains("../") && !name.startsWith("META-INF/")) {
                            Certificate[] certificateArrA = a(jarFile, jarEntryNextElement, bArr);
                            if (certificateArrA != null && certificateArrA.length != 0) {
                                if (certificateArr != null) {
                                    for (Certificate certificate : certificateArr) {
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= certificateArrA.length) {
                                                z = false;
                                                break;
                                            }
                                            if (certificate != null && certificate.equals(certificateArrA[i2])) {
                                                z = true;
                                                break;
                                            }
                                            i2++;
                                        }
                                        i = (z && certificateArr.length == certificateArrA.length) ? i + 1 : 0;
                                        jarFile.close();
                                        try {
                                            jarFile.close();
                                        } catch (IOException unused) {
                                        }
                                        return null;
                                    }
                                }
                                certificateArr = certificateArrA;
                            }
                            jarFile.close();
                            try {
                                jarFile.close();
                            } catch (IOException unused2) {
                            }
                            return null;
                        }
                    }
                }
                if (certificateArr == null || certificateArr.length <= 0) {
                    try {
                        jarFile.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                }
                PublicKey publicKey = certificateArr[0].getPublicKey();
                try {
                    jarFile.close();
                } catch (IOException unused4) {
                }
                return publicKey;
            } catch (Throwable unused5) {
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException unused6) {
                    }
                }
                return null;
            }
        } catch (Throwable unused7) {
            jarFile = null;
        }
    }
}
