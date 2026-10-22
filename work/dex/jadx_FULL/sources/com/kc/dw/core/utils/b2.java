package com.kc.dw.core.utils;

import android.util.Base64;
import com.kc.dw.core.SsdAdConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b2 {
    public static String a(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, new SecretKeySpec(MessageDigest.getInstance("MD5").digest(str2.getBytes()), "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest(SsdAdConfig.initUUID().getBytes())));
            return a(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[SYNTHETIC] */
    public static String a(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        Exception exc;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        if (bArr == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int i = gZIPInputStream.read(bArr2);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i);
                        }
                        String string = byteArrayOutputStream.toString();
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                        return string;
                    } catch (Exception e) {
                        exc = e;
                        byteArrayInputStream2 = byteArrayInputStream;
                        try {
                            exc.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (byteArrayInputStream2 == null) {
                                return "";
                            }
                            try {
                                byteArrayInputStream2.close();
                                return "";
                            } catch (IOException unused6) {
                                return "";
                            }
                        } catch (Throwable th2) {
                            byteArrayInputStream = byteArrayInputStream2;
                            th = th2;
                            Throwable th3 = th;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            th = th3;
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException unused8) {
                                }
                            }
                            if (byteArrayInputStream == null) {
                                throw th;
                            }
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (IOException unused9) {
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        Throwable th5 = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        th = th5;
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (byteArrayInputStream == null) {
                            throw th;
                        }
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (Exception e2) {
                    gZIPInputStream = null;
                    byteArrayInputStream2 = byteArrayInputStream;
                    exc = e2;
                } catch (Throwable th6) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th = th6;
                    gZIPInputStream = null;
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (byteArrayInputStream == null) {
                        throw th;
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (Exception e3) {
                gZIPInputStream = null;
                byteArrayInputStream2 = byteArrayInputStream;
                exc = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                gZIPInputStream = null;
            }
        } catch (Exception e4) {
            exc = e4;
            byteArrayOutputStream = null;
            gZIPInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        }
    }
}
