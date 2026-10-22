package com.googlecode.mp4parser.boxes.cenc;

import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.RangeStartMap;
import com.kuaishou.weapon.p0.b;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
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
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CencEncryptingSampleList extends AbstractList<Sample> {
    List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    RangeStartMap<Integer, SecretKey> ceks;
    Cipher cipher;
    private final String encryptionAlgo;
    List<Sample> parent;

    public class EncryptedSampleImpl implements Sample {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final SecretKey cek;
        private final CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat;
        private final Cipher cipher;
        private final Sample clearSample;

        public /* synthetic */ EncryptedSampleImpl(CencEncryptingSampleList cencEncryptingSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, SecretKey secretKey, EncryptedSampleImpl encryptedSampleImpl) {
            this(sample, cencSampleAuxiliaryDataFormat, cipher, secretKey);
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.cencSampleAuxiliaryDataFormat;
            CencEncryptingSampleList.this.initCipher(cencSampleAuxiliaryDataFormat.iv, this.cek);
            try {
                CencSampleAuxiliaryDataFormat.Pair[] pairArr = cencSampleAuxiliaryDataFormat.pairs;
                if (pairArr != null) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : pairArr) {
                        byte[] bArr = new byte[pair.clear()];
                        byteBuffer.get(bArr);
                        byteBufferAllocate.put(bArr);
                        if (pair.encrypted() > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted())];
                            byteBuffer.get(bArr2);
                            byteBufferAllocate.put(this.cipher.update(bArr2));
                        }
                    }
                } else {
                    int iLimit = byteBuffer.limit();
                    byte[] bArr3 = new byte[iLimit];
                    byteBuffer.get(bArr3);
                    if ("cbc1".equals(CencEncryptingSampleList.this.encryptionAlgo)) {
                        int i = (iLimit / 16) * 16;
                        byteBufferAllocate.put(this.cipher.doFinal(bArr3, 0, i));
                        byteBufferAllocate.put(bArr3, i, iLimit - i);
                    } else if ("cenc".equals(CencEncryptingSampleList.this.encryptionAlgo)) {
                        byteBufferAllocate.put(this.cipher.doFinal(bArr3));
                    }
                }
                byteBuffer.rewind();
                byteBufferAllocate.rewind();
                return byteBufferAllocate;
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.clearSample.getSize();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            CencEncryptingSampleList.this.initCipher(this.cencSampleAuxiliaryDataFormat.iv, this.cek);
            try {
                CencSampleAuxiliaryDataFormat.Pair[] pairArr = this.cencSampleAuxiliaryDataFormat.pairs;
                if (pairArr == null || pairArr.length <= 0) {
                    int iLimit = byteBuffer.limit();
                    byte[] bArr = new byte[iLimit];
                    byteBuffer.get(bArr);
                    if ("cbc1".equals(CencEncryptingSampleList.this.encryptionAlgo)) {
                        int i = (iLimit / 16) * 16;
                        writableByteChannel.write(ByteBuffer.wrap(this.cipher.doFinal(bArr, 0, i)));
                        writableByteChannel.write(ByteBuffer.wrap(bArr, i, iLimit - i));
                    } else if ("cenc".equals(CencEncryptingSampleList.this.encryptionAlgo)) {
                        writableByteChannel.write(ByteBuffer.wrap(this.cipher.doFinal(bArr)));
                    }
                } else {
                    byte[] bArr2 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr2);
                    int iEncrypted = 0;
                    for (CencSampleAuxiliaryDataFormat.Pair pair : this.cencSampleAuxiliaryDataFormat.pairs) {
                        int iClear = iEncrypted + pair.clear();
                        if (pair.encrypted() > 0) {
                            this.cipher.update(bArr2, iClear, CastUtils.l2i(pair.encrypted()), bArr2, iClear);
                            iEncrypted = (int) (((long) iClear) + pair.encrypted());
                        } else {
                            iEncrypted = iClear;
                        }
                    }
                    writableByteChannel.write(ByteBuffer.wrap(bArr2));
                }
                byteBuffer.rewind();
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e2) {
                throw new RuntimeException(e2);
            } catch (ShortBufferException e3) {
                throw new RuntimeException(e3);
            }
        }

        private EncryptedSampleImpl(Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, SecretKey secretKey) {
            this.clearSample = sample;
            this.cencSampleAuxiliaryDataFormat = cencSampleAuxiliaryDataFormat;
            this.cipher = cipher;
            this.cek = secretKey;
        }
    }

    public CencEncryptingSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        this(new RangeStartMap(0, secretKey), list, list2, "cenc");
    }

    public void initCipher(byte[] bArr, SecretKey secretKey) {
        try {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.cipher.init(1, secretKey, new IvParameterSpec(bArr2));
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.parent.size();
    }

    public CencEncryptingSampleList(RangeStartMap<Integer, SecretKey> rangeStartMap, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2, String str) {
        new RangeStartMap();
        this.auxiliaryDataFormats = list2;
        this.ceks = rangeStartMap;
        this.encryptionAlgo = str;
        this.parent = list;
        try {
            if ("cenc".equals(str)) {
                this.cipher = Cipher.getInstance("AES/CTR/NoPadding");
            } else {
                if (!"cbc1".equals(str)) {
                    throw new RuntimeException("Only cenc & cbc1 is supported as encryptionAlgo");
                }
                this.cipher = Cipher.getInstance(b.f40051a);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        Sample sample = this.parent.get(i);
        return this.ceks.get(Integer.valueOf(i)) != null ? new EncryptedSampleImpl(this, sample, this.auxiliaryDataFormats.get(i), this.cipher, this.ceks.get(Integer.valueOf(i)), null) : sample;
    }
}
