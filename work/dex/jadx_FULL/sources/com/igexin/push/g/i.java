package com.igexin.push.g;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f38149a;
    String b;
    File c;
    private byte[] d;

    private i(File file) {
        this.c = file;
    }

    private i(String str) {
        this(new File(str));
    }

    private i(String str, byte[] bArr) {
        this.f38149a = str;
        this.d = bArr;
    }

    private i(String str, byte[] bArr, String str2) {
        this(str, bArr);
        this.b = str2;
    }

    private i(byte[] bArr) {
        this.d = bArr;
    }

    private static String a(byte[] bArr) {
        Object obj = null;
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                obj = "GIF";
            } else {
                byte b2 = bArr[1];
                if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                    obj = "PNG";
                } else if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                    obj = "JPG";
                } else if (b == 66 && b2 == 77) {
                    obj = "BMP";
                }
            }
        }
        if ("JPG".equals(obj)) {
            return "image/jpeg";
        }
        if ("GIF".equals(obj)) {
            return "image/gif";
        }
        if ("PNG".equals(obj)) {
            return "image/png";
        }
        return "BMP".equals(obj) ? "image/bmp" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    private String b() {
        File file;
        if (this.f38149a == null && (file = this.c) != null && file.exists()) {
            this.f38149a = this.c.getName();
        }
        return this.f38149a;
    }

    private static String b(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return "GIF";
            }
            byte b2 = bArr[1];
            if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                return "PNG";
            }
            if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                return "JPG";
            }
            if (b == 66 && b2 == 77) {
                return "BMP";
            }
        }
        return null;
    }

    private String c() throws Throwable {
        String str;
        if (this.b == null) {
            byte[] bArrA = a();
            Object obj = null;
            if (bArrA != null && bArrA.length >= 10) {
                byte b = bArrA[0];
                if (b == 71 && bArrA[1] == 73 && bArrA[2] == 70) {
                    obj = "GIF";
                } else {
                    byte b2 = bArrA[1];
                    if (b2 == 80 && bArrA[2] == 78 && bArrA[3] == 71) {
                        obj = "PNG";
                    } else if (bArrA[6] == 74 && bArrA[7] == 70 && bArrA[8] == 73 && bArrA[9] == 70) {
                        obj = "JPG";
                    } else if (b == 66 && b2 == 77) {
                        obj = "BMP";
                    }
                }
            }
            if ("JPG".equals(obj)) {
                str = "image/jpeg";
            } else if ("GIF".equals(obj)) {
                str = "image/gif";
            } else if ("PNG".equals(obj)) {
                str = "image/png";
            } else {
                str = "BMP".equals(obj) ? "image/bmp" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
            }
            this.b = str;
        }
        return this.b;
    }

    public final byte[] a() throws Throwable {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        if (this.d == null && (file = this.c) != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(this.c);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = fileInputStream.read();
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    this.d = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
        return this.d;
    }
}
