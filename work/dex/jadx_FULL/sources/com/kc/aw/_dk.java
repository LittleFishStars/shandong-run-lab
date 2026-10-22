package com.kc.aw;

import androidx.core.view.MotionEventCompat;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.aq6;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dk {
    public static final byte[] _a = {69, aq6.f40585a, 105, 102, 0, 0};
    public static final int[] _b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    @Keep
    public static final class _a {
        public final ByteBuffer _a;

        public _a(int i, byte[] bArr) {
            this._a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }
    }

    public static int _a(_a _aVar) {
        int i;
        int i2;
        _aVar._a.order((_aVar._a.remaining() - 6 >= 2 ? _aVar._a.getShort(6) : (short) -1) == 18761 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        int i3 = (_aVar._a.remaining() - 10 >= 4 ? _aVar._a.getInt(10) : -1) + 6;
        short s = _aVar._a.remaining() - i3 >= 2 ? _aVar._a.getShort(i3) : (short) -1;
        for (int i4 = 0; i4 < s; i4++) {
            int i5 = (i4 * 12) + i3 + 2;
            if ((_aVar._a.remaining() - i5 >= 2 ? _aVar._a.getShort(i5) : (short) -1) == 274) {
                int i6 = i5 + 2;
                short s2 = _aVar._a.remaining() - i6 >= 2 ? _aVar._a.getShort(i6) : (short) -1;
                if (s2 >= 1 && s2 <= 12) {
                    int i7 = i5 + 4;
                    int i8 = _aVar._a.remaining() - i7 >= 4 ? _aVar._a.getInt(i7) : -1;
                    if (i8 >= 0 && (i = i8 + _b[s2]) <= 4 && (i2 = i5 + 8) >= 0 && i2 <= _aVar._a.remaining() && i >= 0 && i + i2 <= _aVar._a.remaining()) {
                        if (_aVar._a.remaining() - i2 >= 2) {
                            return _aVar._a.getShort(i2);
                        }
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    public static int _a(InputStream inputStream) {
        int i;
        boolean z;
        int i2;
        byte[] bArr_a = null;
        try {
            if (inputStream.skip(2L) != 2) {
                int i3 = _ax._a;
                return 0;
            }
            while (true) {
                if ((inputStream.read() & 255) == 255 && (i2 = inputStream.read() & 255) != 218 && i2 != 217) {
                    i = ((255 & inputStream.read()) | ((inputStream.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) - 2;
                    if (i2 == 225) {
                        break;
                    }
                    long j = i;
                    long j2 = 0;
                    if (j >= 0) {
                        long j3 = j;
                        while (j3 > 0) {
                            long jSkip = inputStream.skip(j3);
                            if (jSkip <= 0) {
                                if (inputStream.read() == -1) {
                                    break;
                                }
                                jSkip = 1;
                            }
                            j3 -= jSkip;
                        }
                        j2 = j - j3;
                    }
                    if (j2 != j) {
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                int i4 = _ax._a;
                return 0;
            }
            bArr_a = _ax._a(i);
            int i5 = i;
            while (i5 > 0) {
                int i6 = inputStream.read(bArr_a, i - i5, i5);
                if (i6 == -1) {
                    break;
                }
                i5 -= i6;
            }
            if (i5 != 0) {
                _ax._a(bArr_a);
                return 0;
            }
            if (i > 6) {
                int i7 = 0;
                while (true) {
                    if (i7 >= 6) {
                        z = true;
                        break;
                    }
                    if (bArr_a[i7] != _a[i7]) {
                        z = false;
                        break;
                    }
                    i7++;
                }
            } else {
                z = false;
                break;
            }
            if (!z) {
                _ax._a(bArr_a);
                return 0;
            }
            int i_a = _a(new _a(i, bArr_a));
            _ax._a(bArr_a);
            return i_a;
        } catch (Throwable th) {
            _ax._a(bArr_a);
            throw th;
        }
    }
}
