package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class IcyDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f3664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f3665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f3666a;
    public int b;

    public interface Listener {
        void a(om6 om6Var);
    }

    public IcyDataSource(DataSource dataSource, int i, Listener listener) {
        sb0.a(i > 0);
        this.f3665a = dataSource;
        this.f30819a = i;
        this.f3664a = listener;
        this.f3666a = new byte[1];
        this.b = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f3665a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        throw new UnsupportedOperationException();
    }

    public final boolean d() throws IOException {
        if (this.f3665a.read(this.f3666a, 0, 1) == -1) {
            return false;
        }
        int i = (this.f3666a[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int i4 = this.f3665a.read(bArr, i3, i2);
            if (i4 == -1) {
                return false;
            }
            i3 += i4;
            i2 -= i4;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.f3664a.a(new om6(bArr, i));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f3665a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f3665a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.b == 0) {
            if (!d()) {
                return -1;
            }
            this.b = this.f30819a;
        }
        int i3 = this.f3665a.read(bArr, i, Math.min(this.b, i2));
        if (i3 != -1) {
            this.b -= i3;
        }
        return i3;
    }
}
