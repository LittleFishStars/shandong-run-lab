package com.kwad.sdk.liteapi.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.FileUtils;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.kwad.sdk.liteapi.utils.LiteMd5Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LiteSignatureUtils {
    private static final int BUFFER_SIZE = 4096;
    private static String TAG = "LiteSignatureUtils";
    public static Signature[] currentSignatures = new Signature[0];

    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] getArchiveSignatures(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            return null;
        }
        return packageArchiveInfo.signatures;
    }

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return LiteMd5Util.md5ForByte(signatures[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            LiteApiLogger.w(TAG, e);
            return "";
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] getSignatures(Context context) {
        Signature[] signatureArr = currentSignatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            currentSignatures = packageInfo.signatures;
        }
        return currentSignatures;
    }

    public static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, signatureArr);
        HashSet hashSet2 = new HashSet();
        Collections.addAll(hashSet2, signatureArr2);
        return hashSet.equals(hashSet2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0054: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0054 */
    private static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Throwable {
        BufferedInputStream bufferedInputStream;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    } catch (RuntimeException e2) {
                        e = e2;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
                FileUtils.closeQuietly(bufferedInputStream);
                return certificates;
            } catch (Throwable th) {
                th = th;
                autoCloseable2 = autoCloseable;
                FileUtils.closeQuietly(autoCloseable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
            LiteApiLogger.w(TAG, e);
            FileUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (RuntimeException e4) {
            e = e4;
            bufferedInputStream = null;
            LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
            LiteApiLogger.w(TAG, e);
            FileUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeQuietly(autoCloseable2);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0230  */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x022d: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:95:0x022d */
    @Nullable
    public static Signature[] getArchiveSignatures(String str, boolean z) throws Throwable {
        AutoCloseable autoCloseable;
        JarFile jarFile;
        AutoCloseable autoCloseable2;
        Certificate[] certificateArrLoadCertificates;
        boolean z2;
        try {
            try {
                byte[] bArr = new byte[4096];
                jarFile = new JarFile(str);
                try {
                    if (z) {
                        JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
                        certificateArrLoadCertificates = loadCertificates(jarFile, jarEntry, bArr);
                        if (certificateArrLoadCertificates == null) {
                            LiteApiLogger.w(TAG, "Package  has no certificates at entry " + jarEntry.getName() + "; ignoring!");
                            LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                            FileUtils.closeQuietly(jarFile);
                            return null;
                        }
                        LiteApiLogger.i(TAG, "File " + str + ": entry=" + jarEntry + " certs=" + certificateArrLoadCertificates.length);
                        for (Certificate certificate : certificateArrLoadCertificates) {
                            LiteApiLogger.d(TAG, "  Public key: " + Arrays.toString(certificate.getPublicKey().getEncoded()) + " " + certificate.getPublicKey());
                        }
                    } else {
                        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                        Certificate[] certificateArr = null;
                        while (enumerationEntries.hasMoreElements()) {
                            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            if (jarEntryNextElement.isDirectory() || jarEntryNextElement.getName().startsWith("META-INF/")) {
                                bArr = bArr;
                            } else {
                                Certificate[] certificateArrLoadCertificates2 = loadCertificates(jarFile, jarEntryNextElement, bArr);
                                String str2 = TAG;
                                StringBuilder sb = new StringBuilder("File ");
                                sb.append(str);
                                sb.append(" entry ");
                                sb.append(jarEntryNextElement.getName());
                                sb.append(": certs=");
                                sb.append(Arrays.toString(certificateArr));
                                sb.append(" (");
                                sb.append(certificateArr != null ? certificateArr.length : 0);
                                sb.append(")");
                                LiteApiLogger.d(str2, sb.toString());
                                if (certificateArrLoadCertificates2 == null) {
                                    LiteApiLogger.w(TAG, "Package  has no certificates at entry " + jarEntryNextElement.getName() + "; ignoring!");
                                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                                    FileUtils.closeQuietly(jarFile);
                                    return null;
                                }
                                if (certificateArr == null) {
                                    certificateArr = certificateArrLoadCertificates2;
                                } else {
                                    int length = certificateArr.length;
                                    int i = 0;
                                    while (i < length) {
                                        Certificate certificate2 = certificateArr[i];
                                        byte[] bArr2 = bArr;
                                        int length2 = certificateArrLoadCertificates2.length;
                                        int i2 = length;
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 >= length2) {
                                                z2 = false;
                                                break;
                                            }
                                            int i4 = length2;
                                            Certificate certificate3 = certificateArrLoadCertificates2[i3];
                                            if (certificate2 != null && certificate2.equals(certificate3)) {
                                                z2 = true;
                                                break;
                                            }
                                            i3++;
                                            length2 = i4;
                                        }
                                        if (z2 && certificateArr.length == certificateArrLoadCertificates2.length) {
                                            i++;
                                            length = i2;
                                            bArr = bArr2;
                                        }
                                        LiteApiLogger.w(TAG, "Package  has mismatched certificates at entry " + jarEntryNextElement.getName() + "; ignoring!");
                                        LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES");
                                        FileUtils.closeQuietly(jarFile);
                                        return null;
                                    }
                                    bArr = bArr;
                                }
                            }
                        }
                        certificateArrLoadCertificates = certificateArr;
                    }
                    if (certificateArrLoadCertificates != null && certificateArrLoadCertificates.length > 0) {
                        int length3 = certificateArrLoadCertificates.length;
                        Signature[] signatureArr = new Signature[certificateArrLoadCertificates.length];
                        for (int i5 = 0; i5 < length3; i5++) {
                            signatureArr[i5] = new Signature(certificateArrLoadCertificates[i5].getEncoded());
                        }
                        FileUtils.closeQuietly(jarFile);
                        return signatureArr;
                    }
                    LiteApiLogger.w(TAG, "Package  has no certificates; ignoring!");
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                    FileUtils.closeQuietly(jarFile);
                    return null;
                } catch (IOException e) {
                    e = e;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                } catch (RuntimeException e2) {
                    e = e2;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                } catch (CertificateEncodingException e3) {
                    e = e3;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                autoCloseable = autoCloseable2;
                if (autoCloseable != null) {
                    FileUtils.closeQuietly(autoCloseable);
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            jarFile = null;
        } catch (RuntimeException e5) {
            e = e5;
            jarFile = null;
        } catch (CertificateEncodingException e6) {
            e = e6;
            jarFile = null;
        } catch (Throwable th2) {
            th = th2;
            autoCloseable = null;
            if (autoCloseable != null) {
                FileUtils.closeQuietly(autoCloseable);
            }
            throw th;
        }
    }

    @Nullable
    public static Signature[] getSignatures(Context context, String str) throws Throwable {
        Signature[] archiveSignatures = getArchiveSignatures(context, str);
        if (archiveSignatures != null) {
            return archiveSignatures;
        }
        Signature[] archiveSignatures2 = getArchiveSignatures(str, false);
        return archiveSignatures2 == null ? getArchiveSignatures(str, true) : archiveSignatures2;
    }

    public static boolean isSignaturesSame(String str, Signature[] signatureArr) {
        if (TextUtils.isEmpty(str) || signatureArr == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (signature.toCharsString().toLowerCase().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
