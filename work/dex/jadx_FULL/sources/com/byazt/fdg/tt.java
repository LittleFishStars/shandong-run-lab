package com.byazt.fdg;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 13})
@RequiresApi(api = 21)
public class tt {

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public final X509Certificate[][] c;
        public final byte[] tt;

        public c(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.c = x509CertificateArr;
            this.tt = bArr;
        }
    }

    private static boolean c(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    public static X509Certificate[][] c(RandomAccessFile randomAccessFile, String str) throws yp, SecurityException, IOException {
        u uVar = a.c.get(str).get(1896449818);
        if (uVar != null) {
            return c(randomAccessFile, uVar, true).c;
        }
        throw new yp("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
    }

    private static c c(RandomAccessFile randomAccessFile, u uVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferC = a.c(uVar.c);
                int i = 0;
                while (byteBufferC.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(c(a.c(byteBufferC), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i > 0) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            a.c(arrayMap, randomAccessFile, uVar);
                        }
                        return new c((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? a.c((byte[]) arrayMap.get(3), randomAccessFile.length(), uVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] c(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferC = a.c(byteBuffer);
        ByteBuffer byteBufferC2 = a.c(byteBuffer);
        byte[] bArrTt = a.tt(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrTt2 = null;
        int i = 0;
        int i2 = -1;
        byte[] bArrTt3 = null;
        while (byteBufferC2.hasRemaining()) {
            i++;
            try {
                ByteBuffer byteBufferC3 = a.c(byteBufferC2);
                if (byteBufferC3.remaining() >= 8) {
                    int i3 = byteBufferC3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (c(i3) && (i2 == -1 || a.c(i3, i2) > 0)) {
                        bArrTt3 = a.tt(byteBufferC3);
                        i2 = i3;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i)), e);
            }
        }
        if (i2 == -1) {
            if (i == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strVe = a.ve(i2);
        Pair<String, ? extends AlgorithmParameterSpec> pairUj = a.uj(i2);
        String str = (String) pairUj.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairUj.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strVe).generatePublic(new X509EncodedKeySpec(bArrTt));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferC);
            if (signature.verify(bArrTt3)) {
                byteBufferC.clear();
                ByteBuffer byteBufferC4 = a.c(byteBufferC);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (byteBufferC4.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer byteBufferC5 = a.c(byteBufferC4);
                        if (byteBufferC5.remaining() >= 8) {
                            int i5 = byteBufferC5.getInt();
                            arrayList2.add(Integer.valueOf(i5));
                            if (i5 == i2) {
                                bArrTt2 = a.tt(byteBufferC5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int iC = a.c(i2);
                    byte[] bArrPut = map.put(Integer.valueOf(iC), bArrTt2);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrTt2)) {
                        throw new SecurityException(a.tt(iC) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferC6 = a.c(byteBufferC);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (byteBufferC6.hasRemaining()) {
                        i6++;
                        byte[] bArrTt4 = a.tt(byteBufferC6);
                        try {
                            arrayList3.add(new m((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrTt4)), bArrTt4));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(bArrTt, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            c(a.c(byteBufferC));
                            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                        }
                        throw new SecurityException("Public key mismatch between certificate and signature record");
                    }
                    throw new SecurityException("No certificates listed");
                }
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            throw new SecurityException(str + " signature did not verify");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void c(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferC = a.c(byteBuffer);
            if (byteBufferC.remaining() >= 4) {
                if (byteBufferC.getInt() == -1091571699) {
                    if (byteBufferC.remaining() >= 4) {
                        if (byteBufferC.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferC.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferC.remaining());
            }
        }
    }
}
