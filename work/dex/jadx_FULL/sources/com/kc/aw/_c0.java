package com.kc.aw;

import android.media.MediaDataSource;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c0 extends MediaDataSource {
    public final _c1 _a;

    public _c0(_c1 _c1Var) {
        this._a = _c1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this._a._f.length;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this._a._f;
        if (j >= bArr2.length) {
            return -1;
        }
        int i3 = (int) j;
        int iMin = Math.min(bArr2.length - i3, i2);
        System.arraycopy(this._a._f, i3, bArr, i, iMin);
        return iMin;
    }
}
