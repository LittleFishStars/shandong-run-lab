package com.googlecode.mp4parser.boxes.cenc;

import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.RangeStartMap;
import com.kuaishou.weapon.p0.b;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CencDecryptingSampleList extends AbstractList<Sample> {
    String encryptionAlgo;
    RangeStartMap<Integer, SecretKey> keys;
    List<Sample> parent;
    List<CencSampleAuxiliaryDataFormat> sencInfo;

    public CencDecryptingSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        this(new RangeStartMap(0, secretKey), list, list2, "cenc");
    }

    public Cipher getCipher(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        try {
            if ("cenc".equals(this.encryptionAlgo)) {
                Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
                cipher.init(2, secretKey, new IvParameterSpec(bArr2));
                return cipher;
            }
            if (!"cbc1".equals(this.encryptionAlgo)) {
                throw new RuntimeException("Only cenc & cbc1 is supported as encryptionAlgo");
            }
            Cipher cipher2 = Cipher.getInstance(b.f40051a);
            cipher2.init(2, secretKey, new IvParameterSpec(bArr2));
            return cipher2;
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchPaddingException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.parent.size();
    }

    public CencDecryptingSampleList(RangeStartMap<Integer, SecretKey> rangeStartMap, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2, String str) {
        new RangeStartMap();
        this.sencInfo = list2;
        this.keys = rangeStartMap;
        this.parent = list;
        this.encryptionAlgo = str;
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        if (this.keys.get(Integer.valueOf(i)) == null) {
            return this.parent.get(i);
        }
        Sample sample = this.parent.get(i);
        ByteBuffer byteBufferAsByteBuffer = sample.asByteBuffer();
        byteBufferAsByteBuffer.rewind();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferAsByteBuffer.limit());
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.sencInfo.get(i);
        Cipher cipher = getCipher(this.keys.get(Integer.valueOf(i)), cencSampleAuxiliaryDataFormat.iv);
        try {
            CencSampleAuxiliaryDataFormat.Pair[] pairArr = cencSampleAuxiliaryDataFormat.pairs;
            if (pairArr == null || pairArr.length <= 0) {
                int iLimit = byteBufferAsByteBuffer.limit();
                byte[] bArr = new byte[iLimit];
                byteBufferAsByteBuffer.get(bArr);
                if ("cbc1".equals(this.encryptionAlgo)) {
                    int i2 = (iLimit / 16) * 16;
                    byteBufferAllocate.put(cipher.doFinal(bArr, 0, i2));
                    byteBufferAllocate.put(bArr, i2, iLimit - i2);
                } else if ("cenc".equals(this.encryptionAlgo)) {
                    byteBufferAllocate.put(cipher.doFinal(bArr));
                }
            } else {
                for (CencSampleAuxiliaryDataFormat.Pair pair : pairArr) {
                    int iClear = pair.clear();
                    int iL2i = CastUtils.l2i(pair.encrypted());
                    byte[] bArr2 = new byte[iClear];
                    byteBufferAsByteBuffer.get(bArr2);
                    byteBufferAllocate.put(bArr2);
                    if (iL2i > 0) {
                        byte[] bArr3 = new byte[iL2i];
                        byteBufferAsByteBuffer.get(bArr3);
                        byteBufferAllocate.put(cipher.update(bArr3));
                    }
                }
                if (byteBufferAsByteBuffer.remaining() > 0) {
                    System.err.println("Decrypted sample but still data remaining: " + sample.getSize());
                }
                byteBufferAllocate.put(cipher.doFinal());
            }
            byteBufferAsByteBuffer.rewind();
            byteBufferAllocate.rewind();
            return new SampleImpl(byteBufferAllocate);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e2) {
            throw new RuntimeException(e2);
        }
    }
}
