package com.getui.gtc.base.crypt;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CryptTools {
    public static InputStream decrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, InputStream inputStream) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return new CipherInputStream(inputStream, cipher);
    }

    public static OutputStream decrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, OutputStream outputStream) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return new CipherOutputStream(outputStream, cipher);
    }

    public static byte[] decrypt(String str, PrivateKey privateKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, privateKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] decrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] digest(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String digestToHexString(String str, byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest = digest(str, bArr);
        StringBuilder sb = new StringBuilder();
        int length = bArrDigest.length;
        for (int i = 0; i < length; i++) {
            int i2 = bArrDigest[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (i2 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static InputStream encrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, InputStream inputStream) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return new CipherInputStream(inputStream, cipher);
    }

    public static OutputStream encrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, OutputStream outputStream) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return new CipherOutputStream(outputStream, cipher);
    }

    public static byte[] encrypt(String str, PublicKey publicKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(str);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static SecretKey generateKey(String str, int i) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        keyGenerator.init(i);
        return keyGenerator.generateKey();
    }

    public static KeyPair generateKeyPair(String str, int i) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str);
        keyPairGenerator.initialize(i);
        return keyPairGenerator.generateKeyPair();
    }

    public static String keyToString(Key key) {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            return Base64.encodeToString(encoded, 0);
        }
        throw new RuntimeException("can not transform key to string");
    }

    public static PrivateKey parsePrivateKey(String str, File file) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        PrivateKey privateKey = parsePrivateKey(str, sb.toString());
                        bufferedReader2.close();
                        return privateKey;
                    }
                    if (line.charAt(0) != '-') {
                        sb.append(line);
                        sb.append('\r');
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PrivateKey parsePrivateKey(String str, String str2) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 0)));
    }

    public static PublicKey parsePublicKey(String str, File file) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        PublicKey publicKey = parsePublicKey(str, sb.toString());
                        bufferedReader2.close();
                        return publicKey;
                    }
                    if (line.charAt(0) != '-') {
                        sb.append(line);
                        sb.append('\r');
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PublicKey parsePublicKey(String str, String str2) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
    }

    public static SecretKey parseSecretKey(String str, String str2) {
        return wrapperKey(str, Base64.decode(str2, 0));
    }

    public static byte[] sign(String str, PrivateKey privateKey, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean verify(String str, PublicKey publicKey, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public static SecretKey wrapperKey(String str, byte[] bArr) {
        return new SecretKeySpec(bArr, str);
    }
}
