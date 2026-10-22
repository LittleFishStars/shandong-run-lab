package com.zj.adlib;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jy1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaCodec.CryptoInfo f17523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f17524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public byte[] f17525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public int[] f17526a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public byte[] f17527b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public int[] f17528b;
    public int c;
    public int d;

    @RequiresApi(24)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f42701a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaCodec.CryptoInfo f17529a;

        public final void b(int i, int i2) {
            this.f42701a.set(i, i2);
            this.f17529a.setPattern(this.f42701a);
        }

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f17529a = cryptoInfo;
            this.f42701a = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public jy1() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f17523a = cryptoInfo;
        this.f17524a = gj9.f41922a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f17523a;
    }

    public void b(int i) {
        if (i == 0) {
            return;
        }
        if (this.f17526a == null) {
            int[] iArr = new int[1];
            this.f17526a = iArr;
            this.f17523a.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f17526a;
        iArr2[0] = iArr2[0] + i;
    }

    public void c(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.b = i;
        this.f17526a = iArr;
        this.f17528b = iArr2;
        this.f17527b = bArr;
        this.f17525a = bArr2;
        this.f42700a = i2;
        this.c = i3;
        this.d = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.f17523a;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (gj9.f41922a >= 24) {
            ((b) sb0.g(this.f17524a)).b(i3, i4);
        }
    }
}
