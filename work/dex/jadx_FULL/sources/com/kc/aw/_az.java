package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _az {
    public static final char[] _c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final long _a;
    public final long _b;

    public _az(long j, long j2) {
        this._a = j;
        this._b = j2;
    }

    public _az(String str) {
        long j;
        if (str == null) {
            j = 0;
            this._a = 0L;
        } else {
            long[] jArr_a = _fx._a(str.getBytes());
            this._a = jArr_a[0];
            j = jArr_a[1];
        }
        this._b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        _az _azVar = (_az) obj;
        return this._a == _azVar._a && this._b == _azVar._b;
    }

    public final int hashCode() {
        return (int) (this._a ^ this._b);
    }
}
