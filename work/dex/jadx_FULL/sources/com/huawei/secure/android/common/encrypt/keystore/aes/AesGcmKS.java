package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AesGcmKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37713a = "GCMKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/GCM/NoPadding";
    private static final String d = "";
    private static final int e = 12;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new HashMap();

    private static SecretKey a(String str) {
        b.c(f37713a, "load key");
        SecretKey secretKeyGenerateKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKeyGenerateKey = (SecretKey) key;
            } else {
                b.c(f37713a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKeyGenerateKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            b.b(f37713a, "IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            b.b(f37713a, "InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            b.b(f37713a, "KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            b.b(f37713a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            b.b(f37713a, "NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            b.b(f37713a, "UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            b.b(f37713a, "CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            b.b(f37713a, "Exception: " + e9.getMessage());
        }
        g.put(str, secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.get(str) == null) {
            a(str);
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f37713a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(f37713a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f37713a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            b.b(f37713a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37713a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 12) {
                b.b(f37713a, "Decrypt source data is invalid.");
                return bArr2;
            }
            return decrypt(b(str), bArr);
        }
        b.b(f37713a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37713a, "sdk version is too low");
                return bArr2;
            }
            return encrypt(b(str), bArr);
        }
        b.b(f37713a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(f37713a, "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            b.b(f37713a, "secret key is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f37713a, "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            b.b(f37713a, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.b(f37713a, "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            b.b(f37713a, "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            b.b(f37713a, "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            b.b(f37713a, "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            b.b(f37713a, "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            b.b(f37713a, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(f37713a, "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            b.b(f37713a, "content is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f37713a, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            b.b(f37713a, "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e2) {
            b.b(f37713a, "InvalidAlgorithmParameterException : " + e2.getMessage());
            return bArr2;
        } catch (InvalidKeyException e3) {
            b.b(f37713a, "InvalidKeyException : " + e3.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e4) {
            b.b(f37713a, "NoSuchAlgorithmException : " + e4.getMessage());
            return bArr2;
        } catch (BadPaddingException e5) {
            b.b(f37713a, "BadPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e6) {
            b.b(f37713a, "IllegalBlockSizeException : " + e6.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e7) {
            b.b(f37713a, "NoSuchPaddingException : " + e7.getMessage());
            return bArr2;
        } catch (Exception e8) {
            b.b(f37713a, "Exception: " + e8.getMessage());
            return bArr2;
        }
    }
}
