package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.RopeByteString;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class FileSHA256 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37708a = 8192;
    private static final String b = "SHA-256";
    private static final String c = "FileSHA256";
    private static final String d = "";
    private static final String[] e = {"SHA-256", "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(c, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            b.b(c, "file is not valid");
            return "";
        }
        RopeByteString.RopeInputStream ropeInputStream = 0;
        String strByteArray2HexStr = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                        z = true;
                    }
                    strByteArray2HexStr = z ? HexUtil.byteArray2HexStr(messageDigest.digest()) : null;
                    a.a((InputStream) fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    b.b(c, "IOException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    b.b(c, "NoSuchAlgorithmException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                }
            } catch (Throwable th) {
                th = th;
                ropeInputStream = "";
                a.a((InputStream) ropeInputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a.a((InputStream) ropeInputStream);
            throw th;
        }
        return strByteArray2HexStr;
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            while (true) {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    return HexUtil.byteArray2HexStr(messageDigest.digest());
                }
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                }
                a.a(inputStream);
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.b(c, "inputstraem exception");
            return "";
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.b(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && a(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.b(c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    private static boolean a(String str) {
        for (String str2 : e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
