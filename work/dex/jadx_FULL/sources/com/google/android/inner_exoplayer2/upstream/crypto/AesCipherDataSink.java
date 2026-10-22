package com.google.android.inner_exoplayer2.upstream.crypto;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.upstream.DataSink;
import com.google.android.inner_exoplayer2.upstream.DataSpec;
import com.google.android.inner_exoplayer2.util.Util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class AesCipherDataSink implements DataSink {

    @Nullable
    private AesFlushingCipher cipher;

    @Nullable
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, null);
    }

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void close() {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        this.wrappedDataSink.open(dataSpec);
        this.cipher = new AesFlushingCipher(1, this.secretKey, dataSpec.key, dataSpec.position + dataSpec.uriPositionOffset);
    }

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        if (this.scratch == null) {
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).updateInPlace(bArr, i, i2);
            this.wrappedDataSink.write(bArr, i, i2);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            int iMin = Math.min(i2 - i3, this.scratch.length);
            ((AesFlushingCipher) Util.castNonNull(this.cipher)).update(bArr, i + i3, iMin, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, iMin);
            i3 += iMin;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, @Nullable byte[] bArr2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = bArr;
        this.scratch = bArr2;
    }
}
