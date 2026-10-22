package com.ali.auth.third.core.rpc.c;

import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.Base64;
import com.ali.auth.third.core.util.Base64URLSafe;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static ThreadLocal<a> c = new ThreadLocal<>();
    private static final byte[] d = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IvParameterSpec f23429a = null;
    private Cipher b = null;

    private a() {
        a();
    }

    private void a() {
        if (this.b == null) {
            try {
                this.b = Cipher.getInstance("AES/CBC/PKCS5Padding");
                this.f23429a = new IvParameterSpec(d);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                SDKLogger.e("auth.AESCrypto", "AES:generateCipher:generate cipher error", e);
            }
        }
    }

    public static a b() {
        if (c.get() == null) {
            c.set(new a());
        }
        return c.get();
    }

    public String a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                byte[] bArrA = a(Base64URLSafe.decode(str), str2.getBytes("UTF-8"));
                if (bArrA != null) {
                    return new String(bArrA, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                SDKLogger.e("auth.AESCrypto", "AES:decrypt:" + str + ":String to Byte Array Error", e);
            }
        }
        return null;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        StringBuilder sb;
        if (bArr == null) {
            return null;
        }
        try {
            this.b.init(2, new SecretKeySpec(bArr2, "AES"), this.f23429a);
            return this.b.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("AES:decrypt:");
            sb.append(bArr);
            sb.append(":decrypt data error");
            SDKLogger.e("auth.AESCrypto", sb.toString(), e);
            return null;
        } catch (InvalidKeyException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("AES:decrypt:");
            sb.append(bArr);
            sb.append(":decrypt data error");
            SDKLogger.e("auth.AESCrypto", sb.toString(), e);
            return null;
        } catch (BadPaddingException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("AES:decrypt:");
            sb.append(bArr);
            sb.append(":decrypt data error");
            SDKLogger.e("auth.AESCrypto", sb.toString(), e);
            return null;
        } catch (IllegalBlockSizeException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append("AES:decrypt:");
            sb.append(bArr);
            sb.append(":decrypt data error");
            SDKLogger.e("auth.AESCrypto", sb.toString(), e);
            return null;
        }
    }

    public String b(String str, String str2) {
        StringBuilder sb;
        String str3;
        String strTrim = str.trim();
        int iIntValue = Integer.valueOf(strTrim.substring(0, 8), 16).intValue();
        String strSubstring = iIntValue == strTrim.length() - 8 ? strTrim.substring(8) : strTrim.substring(8, iIntValue + 8);
        int length = strSubstring.length() % 4;
        if (length == 1) {
            sb = new StringBuilder();
            sb.append(strSubstring);
            str3 = "===";
        } else {
            if (length != 2) {
                if (length == 3) {
                    sb = new StringBuilder();
                    sb.append(strSubstring);
                    str3 = "=";
                }
                return a(strSubstring, str2);
            }
            sb = new StringBuilder();
            sb.append(strSubstring);
            str3 = "==";
        }
        sb.append(str3);
        strSubstring = sb.toString();
        return a(strSubstring, str2);
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        StringBuilder sb;
        if (bArr != null && bArr2 != null) {
            try {
                this.b.init(1, new SecretKeySpec(bArr2, "AES"), this.f23429a);
                return this.b.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("AES:encrypt:");
                sb.append(bArr);
                sb.append(":encrypt data error");
                SDKLogger.e("auth.AESCrypto", sb.toString(), e);
                return null;
            } catch (InvalidKeyException e2) {
                e = e2;
                sb = new StringBuilder();
                sb.append("AES:encrypt:");
                sb.append(bArr);
                sb.append(":encrypt data error");
                SDKLogger.e("auth.AESCrypto", sb.toString(), e);
                return null;
            } catch (BadPaddingException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append("AES:encrypt:");
                sb.append(bArr);
                sb.append(":encrypt data error");
                SDKLogger.e("auth.AESCrypto", sb.toString(), e);
                return null;
            } catch (IllegalBlockSizeException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append("AES:encrypt:");
                sb.append(bArr);
                sb.append(":encrypt data error");
                SDKLogger.e("auth.AESCrypto", sb.toString(), e);
                return null;
            }
        }
        return null;
    }

    public String c(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                byte[] bArrB = b(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
                if (bArrB != null) {
                    return Base64.encode(bArrB);
                }
            } catch (UnsupportedEncodingException e) {
                SDKLogger.e("auth.AESCrypto", "AES:encrypt:" + str + ":String to Byte Array Error", e);
            }
        }
        return null;
    }
}
