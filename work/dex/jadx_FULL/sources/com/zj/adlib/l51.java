package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l51 extends BaseDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Uri f42999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f17881a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17882b;
    public int c;

    public l51(byte[] bArr) {
        super(false);
        sb0.g(bArr);
        sb0.a(bArr.length > 0);
        this.f17881a = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        this.f42999a = dataSpec.f5026a;
        transferInitializing(dataSpec);
        long j = dataSpec.f5032c;
        byte[] bArr = this.f17881a;
        if (j > bArr.length) {
            throw new DataSourceException(2008);
        }
        this.b = (int) j;
        int length = bArr.length - ((int) j);
        this.c = length;
        long j2 = dataSpec.f5033d;
        if (j2 != -1) {
            this.c = (int) Math.min(length, j2);
        }
        this.f17882b = true;
        transferStarted(dataSpec);
        long j3 = dataSpec.f5033d;
        return j3 != -1 ? j3 : this.c;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f17882b) {
            this.f17882b = false;
            transferEnded();
        }
        this.f42999a = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f42999a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.c;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(this.f17881a, this.b, bArr, i, iMin);
        this.b += iMin;
        this.c -= iMin;
        bytesTransferred(iMin);
        return iMin;
    }
}
