package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p20 implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSink f43877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public r20 f18755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f18756a;

    @Nullable
    public final byte[] b;

    public p20(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void a(DataSpec dataSpec) throws IOException {
        this.f43877a.a(dataSpec);
        this.f18755a = new r20(1, this.f18756a, dataSpec.f5028a, dataSpec.f5025a + dataSpec.f5032c);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws IOException {
        this.f18755a = null;
        this.f43877a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.b == null) {
            ((r20) gj9.k(this.f18755a)).d(bArr, i, i2);
            this.f43877a.write(bArr, i, i2);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            int iMin = Math.min(i2 - i3, this.b.length);
            ((r20) gj9.k(this.f18755a)).update(bArr, i + i3, iMin, this.b, 0);
            this.f43877a.write(this.b, 0, iMin);
            i3 += iMin;
        }
    }

    public p20(byte[] bArr, DataSink dataSink, @Nullable byte[] bArr2) {
        this.f43877a = dataSink;
        this.f18756a = bArr;
        this.b = bArr2;
    }
}
