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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 54})
@RequiresApi(api = 21)
public class ve {

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 24})
    public static class c extends Exception {
    }

    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt {
        public final List<X509Certificate> c;
        public final List<Integer> tt;

        public tt(List<X509Certificate> list, List<Integer> list2) {
            this.c = list;
            this.tt = list2;
        }
    }

    /* JADX INFO: renamed from: com.byazt.fdg.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 917})
    public static class C0400ve {
        public final X509Certificate[] c;
        public final tt tt;
        public byte[] ve;

        public C0400ve(X509Certificate[] x509CertificateArr, tt ttVar) {
            this.c = x509CertificateArr;
            this.tt = ttVar;
        }
    }

    public static C0400ve c(RandomAccessFile randomAccessFile, String str) throws yp, IOException {
        u uVar = a.c.get(str).get(-262969152);
        if (uVar != null) {
            return c(randomAccessFile, uVar, true);
        }
        throw new yp("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
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

    private static C0400ve c(RandomAccessFile randomAccessFile, u uVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferC = a.c(uVar.c);
                int i = 0;
                C0400ve c0400veC = null;
                while (byteBufferC.hasRemaining()) {
                    try {
                        c0400veC = c(a.c(byteBufferC), arrayMap, certificateFactory);
                        i++;
                    } catch (c unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0400veC == null) {
                    throw new SecurityException("No signers found");
                }
                if (i == 1) {
                    if (!arrayMap.isEmpty()) {
                        if (z) {
                            a.c(arrayMap, randomAccessFile, uVar);
                        }
                        if (arrayMap.containsKey(3)) {
                            c0400veC.ve = a.c((byte[]) arrayMap.get(3), randomAccessFile.length(), uVar);
                        }
                        return c0400veC;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0400ve c(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws c, IOException, SecurityException {
        ByteBuffer byteBufferC = a.c(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferC2 = a.c(byteBuffer);
        byte[] bArrTt = a.tt(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrTt2 = null;
        int i3 = 0;
        int i4 = -1;
        byte[] bArrTt3 = null;
        while (byteBufferC2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferC3 = a.c(byteBufferC2);
                if (byteBufferC3.remaining() >= 8) {
                    int i5 = byteBufferC3.getInt();
                    arrayList.add(Integer.valueOf(i5));
                    if (c(i5) && (i4 == -1 || a.c(i5, i4) > 0)) {
                        bArrTt3 = a.tt(byteBufferC3);
                        i4 = i5;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e);
            }
        }
        if (i4 == -1) {
            if (i3 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strVe = a.ve(i4);
        Pair<String, ? extends AlgorithmParameterSpec> pairUj = a.uj(i4);
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
                int i6 = 0;
                while (byteBufferC4.hasRemaining()) {
                    i6++;
                    try {
                        ByteBuffer byteBufferC5 = a.c(byteBufferC4);
                        if (byteBufferC5.remaining() >= 8) {
                            int i7 = byteBufferC5.getInt();
                            arrayList2.add(Integer.valueOf(i7));
                            if (i7 == i4) {
                                bArrTt2 = a.tt(byteBufferC5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    int iC = a.c(i4);
                    byte[] bArrPut = map.put(Integer.valueOf(iC), bArrTt2);
                    if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrTt2)) {
                        throw new SecurityException(a.tt(iC) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer byteBufferC6 = a.c(byteBufferC);
                    ArrayList arrayList3 = new ArrayList();
                    int i8 = 0;
                    while (byteBufferC6.hasRemaining()) {
                        i8++;
                        byte[] bArrTt4 = a.tt(byteBufferC6);
                        try {
                            arrayList3.add(new m((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrTt4)), bArrTt4));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(bArrTt, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                            if (byteBufferC.getInt() == i) {
                                if (byteBufferC.getInt() == i2) {
                                    return c(a.c(byteBufferC), arrayList3, certificateFactory);
                                }
                                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                            }
                            throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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

    private static C0400ve c(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        tt ttVarC = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferC = a.c(byteBuffer);
            if (byteBufferC.remaining() >= 4) {
                if (byteBufferC.getInt() == 1000370060) {
                    if (ttVarC == null) {
                        ttVarC = c(byteBufferC, certificateFactory);
                        try {
                            if (ttVarC.c.size() > 0) {
                                List<X509Certificate> list2 = ttVarC.c;
                                if (!Arrays.equals(list2.get(list2.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferC.remaining());
            }
        }
        return new C0400ve(x509CertificateArr, ttVarC);
    }

    private static tt c(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            m mVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferC = a.c(byteBuffer);
                ByteBuffer byteBufferC2 = a.c(byteBufferC);
                int i3 = byteBufferC.getInt();
                int i4 = byteBufferC.getInt();
                byte[] bArrTt = a.tt(byteBufferC);
                if (mVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairUj = a.uj(i2);
                    PublicKey publicKey = mVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairUj.first);
                    signature.initVerify(publicKey);
                    Object obj = pairUj.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(byteBufferC2);
                    if (!signature.verify(bArrTt)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairUj.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferC2.rewind();
                byte[] bArrTt2 = a.tt(byteBufferC2);
                int i5 = byteBufferC2.getInt();
                if (mVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                mVar = new m((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrTt2)), bArrTt2);
                if (!hashSet.contains(mVar)) {
                    hashSet.add(mVar);
                    arrayList.add(mVar);
                    arrayList2.add(Integer.valueOf(i3));
                    i2 = i4;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
            }
            return new tt(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }
}
