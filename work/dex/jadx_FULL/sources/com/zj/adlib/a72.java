package com.zj.adlib;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.common.base.b;
import com.ipd.dsp.internal.n.e;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a72 extends BaseDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40464a = "data";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public byte[] f15164a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DataSpec f15165b;
    public int c;

    public a72() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        transferInitializing(dataSpec);
        this.f15165b = dataSpec;
        Uri uri = dataSpec.f5026a;
        String scheme = uri.getScheme();
        sb0.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrU1 = gj9.u1(uri.getSchemeSpecificPart(), ",");
        if (strArrU1.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uri, null);
        }
        String str = strArrU1[1];
        if (strArrU1[0].contains(e.c)) {
            try {
                this.f15164a = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f15164a = gj9.z0(URLDecoder.decode(str, b.f31594a.name()));
        }
        long j = dataSpec.f5032c;
        byte[] bArr = this.f15164a;
        if (j > bArr.length) {
            this.f15164a = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.b = i;
        int length = bArr.length - i;
        this.c = length;
        long j2 = dataSpec.f5033d;
        if (j2 != -1) {
            this.c = (int) Math.min(length, j2);
        }
        transferStarted(dataSpec);
        long j3 = dataSpec.f5033d;
        return j3 != -1 ? j3 : this.c;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f15164a != null) {
            this.f15164a = null;
            transferEnded();
        }
        this.f15165b = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSpec dataSpec = this.f15165b;
        if (dataSpec != null) {
            return dataSpec.f5026a;
        }
        return null;
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
        System.arraycopy(gj9.k(this.f15164a), this.b, bArr, i, iMin);
        this.b += iMin;
        this.c -= iMin;
        bytesTransferred(iMin);
        return iMin;
    }
}
