package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j51 implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f42511a;

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void a(DataSpec dataSpec) {
        long j = dataSpec.f5033d;
        if (j == -1) {
            this.f42511a = new ByteArrayOutputStream();
        } else {
            sb0.a(j <= 2147483647L);
            this.f42511a = new ByteArrayOutputStream((int) dataSpec.f5033d);
        }
    }

    @Nullable
    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = this.f42511a;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws IOException {
        ((ByteArrayOutputStream) gj9.k(this.f42511a)).close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        ((ByteArrayOutputStream) gj9.k(this.f42511a)).write(bArr, i, i2);
    }
}
