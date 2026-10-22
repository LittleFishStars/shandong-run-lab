package com.kc.aw;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a0 implements _9 {
    public static final _a0 _a = new _a0();
    public static final byte[] _b = {82, 73, 70, 70};
    public static final byte[] _c = {87, 69, 66, 80};
    public static final byte[] _d = {86, 80, MaterialProgressDrawable.d, 88};

    public static BitmapDrawable _b(_c4 _c4Var) {
        int i;
        int i2;
        try {
            byte[] bArr_a = _c4Var._a();
            int i3 = _c4Var._a;
            int i4 = _c4Var._b;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr_a, 0, bArr_a.length, options);
                int i5 = options.outWidth;
                if (i5 > 0 && (i = options.outHeight) > 0) {
                    options.inJustDecodeBounds = false;
                    if (i3 <= 0 || i4 <= 0 || (i <= i4 && i5 <= i3)) {
                        i2 = 1;
                    } else {
                        int i6 = i / 2;
                        int i7 = i5 / 2;
                        i2 = 1;
                        while (i6 / i2 >= i4 && i7 / i2 >= i3) {
                            i2 *= 2;
                        }
                    }
                    options.inSampleSize = i2;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr_a, 0, bArr_a.length, options);
                    if (bitmapDecodeByteArray != null) {
                        return new BitmapDrawable((Resources) null, bitmapDecodeByteArray);
                    }
                    return null;
                }
                return null;
            } catch (OutOfMemoryError unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr_a, 0, bArr_a.length, options2);
                if (bitmapDecodeByteArray2 != null) {
                    return new BitmapDrawable((Resources) null, bitmapDecodeByteArray2);
                }
                return null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.kc.aw._9
    public final Object _a(_c4 _c4Var) {
        boolean z;
        try {
            if (_c4Var._a() == null || _c4Var._a().length == 0 || _c4Var._b()._c() != 14) {
                return null;
            }
            byte[] bArr_a = _c4Var._a();
            boolean z2 = false;
            if (bArr_a == null || bArr_a.length < 20) {
                z = false;
                break;
            }
            int i = 0;
            while (true) {
                byte[] bArr = _b;
                if (i >= 4) {
                    int i2 = 0;
                    while (true) {
                        byte[] bArr2 = _c;
                        if (i2 >= 4) {
                            z = true;
                            break;
                        }
                        int i3 = i2 + 8;
                        if (i3 < bArr_a.length && bArr_a[i3] == bArr2[i2]) {
                            i2++;
                        }
                    }
                } else if (i < bArr_a.length && bArr_a[i] == bArr[i]) {
                    i++;
                }
                z = false;
                break;
            }
            if (!z) {
                return null;
            }
            byte[] bArr_a2 = _c4Var._a();
            if (bArr_a2 != null && bArr_a2.length >= 30) {
                for (int i4 = 12; i4 < bArr_a2.length - 8; i4++) {
                    try {
                        byte b = bArr_a2[i4];
                        byte[] bArr3 = _d;
                        if (b == bArr3[0]) {
                            int i5 = i4 + 3;
                            if (i5 < bArr_a2.length && bArr_a2[i4 + 1] == bArr3[1] && bArr_a2[i4 + 2] == bArr3[2] && bArr_a2[i5] == bArr3[3]) {
                                int i6 = i4 + 8 + 4;
                                if (i6 >= bArr_a2.length || (bArr_a2[i6] & 2) == 0) {
                                    break;
                                    break;
                                }
                                z2 = true;
                                break;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            if (z2) {
                return null;
            }
            return _b(_c4Var);
        } catch (Exception unused2) {
        }
        return null;
    }
}
