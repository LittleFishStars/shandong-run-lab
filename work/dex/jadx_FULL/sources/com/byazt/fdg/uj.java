package com.byazt.fdg;

import android.content.pm.Signature;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 15})
@RequiresApi(api = 21)
public class uj {
    public static z c(String str, int i) throws Throwable {
        int[] iArr;
        if (i > 3) {
            throw new nu(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    try {
                        a.c(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            ve.C0400ve c0400veC = ve.c(randomAccessFile2, str);
                            Signature[] signatureArrC = c(new Certificate[][]{c0400veC.c});
                            ve.tt ttVar = c0400veC.tt;
                            if (ttVar != null) {
                                int size = ttVar.c.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[c0400veC.tt.tt.size()];
                                for (int i2 = 0; i2 < size; i2++) {
                                    signatureArr2[i2] = new Signature(c0400veC.tt.c.get(i2).getEncoded());
                                    iArr[i2] = c0400veC.tt.tt.get(i2).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            z zVar = new z(signatureArrC, 3, signatureArr, iArr);
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused) {
                            }
                            return zVar;
                        } catch (yp e) {
                            if (i >= 3) {
                                throw new nu(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e);
                            }
                            if (i > 2) {
                                throw new nu(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                z zVar2 = new z(c(tt.c(randomAccessFile2, str)), 2);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused2) {
                                }
                                return zVar2;
                            } catch (yp e2) {
                                if (i >= 2) {
                                    throw new nu(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e2);
                                }
                                if (i <= 1) {
                                    z zVarC = c.c(str, true);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused3) {
                                    }
                                    return zVarC;
                                }
                                throw new nu(4, "No signature found in package of version " + i + " or newer for package " + str);
                            } catch (Exception e3) {
                                throw new nu(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                            }
                        } catch (Exception e4) {
                            throw new nu(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
                        }
                    } catch (Exception e5) {
                        throw new nu(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            throw new nu(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] c(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.byazt.uq.i.ve()) {
                Constructor constructorC = com.byazt.oep.c.c((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorC != null) {
                    constructorC.setAccessible(true);
                }
                if (constructorC != null && constructorC.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorC.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.byazt.bog.a.c(e);
                    } catch (InstantiationException e2) {
                        com.byazt.bog.a.c(e2);
                    } catch (InvocationTargetException e3) {
                        com.byazt.bog.a.c(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
