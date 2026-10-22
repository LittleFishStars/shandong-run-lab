package com.google.android.inner_exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void close() throws IOException {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).close();
    }

    @Nullable
    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.stream;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        long j = dataSpec.length;
        if (j == -1) {
            this.stream = new ByteArrayOutputStream();
        } else {
            Assertions.checkArgument(j <= 2147483647L);
            this.stream = new ByteArrayOutputStream((int) dataSpec.length);
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).write(bArr, i, i2);
    }
}
