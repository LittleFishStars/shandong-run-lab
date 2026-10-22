package com.getui.gtc.base.crypt;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f30277a = new Object();
    private final Object b = new Object();

    @TargetApi(18)
    private KeyPair a(Context context, String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPair keyPairGenerateKeyPair;
        synchronized (this.b) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setKeySize(1024).build());
            keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        }
        return keyPairGenerateKeyPair;
    }

    @TargetApi(18)
    public final KeyPair a(Context context, String str, boolean z) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        synchronized (this.b) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias(str) || !z) {
                return new KeyPair(keyStore.getCertificate(str).getPublicKey(), (PrivateKey) keyStore.getKey(str, null));
            }
            return a(context, str);
        }
    }

    @TargetApi(23)
    public final SecretKey a(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKey secretKey;
        synchronized (this.f30277a) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.containsAlias(str);
            secretKey = (SecretKey) keyStore.getKey(str, null);
        }
        return secretKey;
    }
}
