package com.kc.aw;

import android.util.SparseArray;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ax {
    public static int _a;
    public static final byte[][] _b = new byte[10][];
    public static final SparseArray<ArrayList<WeakReference<byte[]>>> _c = new SparseArray<>();

    public static void _a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length;
        if (length == 8192) {
            byte[][] bArr2 = _b;
            synchronized (bArr2) {
                int i = _a;
                if (i < 10) {
                    _a = i + 1;
                    bArr2[i] = bArr;
                }
            }
            return;
        }
        if (length < 16384 || length > 4194304 || (length & 16383) != 0) {
            return;
        }
        SparseArray<ArrayList<WeakReference<byte[]>>> sparseArray = _c;
        synchronized (sparseArray) {
            ArrayList<WeakReference<byte[]>> arrayList = sparseArray.get(length);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                sparseArray.put(length, arrayList);
            }
            arrayList.add(new WeakReference<>(bArr));
        }
    }

    public static byte[] _a() {
        byte[][] bArr = _b;
        synchronized (bArr) {
            int i = _a;
            if (i <= 0) {
                return new byte[8192];
            }
            int i2 = i - 1;
            _a = i2;
            byte[] bArr2 = bArr[i2];
            bArr[i2] = null;
            return bArr2;
        }
    }

    public static byte[] _a(int i) {
        byte[] bArr;
        if (i <= 8192) {
            return _a();
        }
        int i2 = 16384;
        if (i > 16384) {
            if (i > 4194304) {
                return new byte[i];
            }
            int i3 = i - 1;
            int i4 = i3 | (i3 >>> 1);
            int i5 = i4 | (i4 >>> 2);
            int i6 = i5 | (i5 >>> 4);
            int i7 = i6 | (i6 >>> 8);
            int i8 = i7 | (i7 >>> 16);
            i2 = i8 < 0 ? 1 : i8 + 1;
        }
        SparseArray<ArrayList<WeakReference<byte[]>>> sparseArray = _c;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            int iIndexOfKey = sparseArray.indexOfKey(i2);
            if (iIndexOfKey < 0) {
                iIndexOfKey = ~iIndexOfKey;
            }
            while (iIndexOfKey < size) {
                ArrayList<WeakReference<byte[]>> arrayListValueAt = _c.valueAt(iIndexOfKey);
                if (!arrayListValueAt.isEmpty()) {
                    int size2 = arrayListValueAt.size() - 1;
                    while (true) {
                        if (size2 < 0) {
                            bArr = null;
                            break;
                        }
                        WeakReference<byte[]> weakReference = arrayListValueAt.get(size2);
                        arrayListValueAt.remove(size2);
                        bArr = weakReference.get();
                        if (bArr != null) {
                            break;
                        }
                        size2--;
                    }
                    if (bArr != null && bArr.length >= i2) {
                        return bArr;
                    }
                }
                iIndexOfKey++;
            }
            return new byte[i2];
        }
    }
}
