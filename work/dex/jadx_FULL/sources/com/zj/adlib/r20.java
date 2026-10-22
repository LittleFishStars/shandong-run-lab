package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cipher f19215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f19216a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final byte[] f19217b;

    public r20(int i, byte[] bArr, @Nullable String str, long j) {
        this(i, bArr, a(str), j);
    }

    public static long a(@Nullable String str) {
        long j = 0;
        if (str == null) {
            return 0L;
        }
        for (int i = 0; i < str.length(); i++) {
            long jCharAt = j ^ ((long) str.charAt(i));
            j = jCharAt + (jCharAt << 1) + (jCharAt << 4) + (jCharAt << 5) + (jCharAt << 7) + (jCharAt << 8) + (jCharAt << 40);
        }
        return j;
    }

    public final byte[] b(long j, long j2) {
        return ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
    }

    public final int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.f19215a.update(bArr, i, i2, bArr2, i3);
        } catch (ShortBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public void d(byte[] bArr, int i, int i2) {
        update(bArr, i, i2, bArr, i);
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i;
        do {
            int i5 = this.b;
            if (i5 <= 0) {
                int iC = c(bArr, i4, i2, bArr2, i3);
                if (i2 == iC) {
                    return;
                }
                int i6 = i2 - iC;
                int i7 = 0;
                sb0.i(i6 < this.f44346a);
                int i8 = i3 + iC;
                int i9 = this.f44346a - i6;
                this.b = i9;
                sb0.i(c(this.f19216a, 0, i9, this.f19217b, 0) == this.f44346a);
                while (i7 < i6) {
                    bArr2[i8] = this.f19217b[i7];
                    i7++;
                    i8++;
                }
                return;
            }
            bArr2[i3] = (byte) (bArr[i4] ^ this.f19217b[this.f44346a - i5]);
            i3++;
            i4++;
            this.b = i5 - 1;
            i2--;
        } while (i2 != 0);
    }

    public r20(int i, byte[] bArr, long j, long j2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.f19215a = cipher;
            int blockSize = cipher.getBlockSize();
            this.f44346a = blockSize;
            this.f19216a = new byte[blockSize];
            this.f19217b = new byte[blockSize];
            long j3 = j2 / ((long) blockSize);
            int i2 = (int) (j2 % ((long) blockSize));
            cipher.init(i, new SecretKeySpec(bArr, gj9.v1(cipher.getAlgorithm(), WVNativeCallbackUtil.SEPERATER)[0]), new IvParameterSpec(b(j, j3)));
            if (i2 != 0) {
                d(new byte[i2], 0, i2);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}
