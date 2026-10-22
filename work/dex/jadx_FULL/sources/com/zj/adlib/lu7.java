package com.zj.adlib;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lu7 {
    public static void A(@NonNull Parcel parcel, int i, @NonNull SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
        }
        g0(parcel, iF0);
    }

    public static void B(@NonNull Parcel parcel, int i, @NonNull IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeStrongBinder(iBinder);
            g0(parcel, iF0);
        }
    }

    public static void C(@NonNull Parcel parcel, int i, @NonNull IBinder[] iBinderArr, boolean z) {
        if (iBinderArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            g0(parcel, iF0);
        }
    }

    public static void D(@NonNull Parcel parcel, int i, @NonNull List<IBinder> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeBinderList(list);
            g0(parcel, iF0);
        }
    }

    public static void E(@NonNull Parcel parcel, int i, @NonNull SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeStrongBinder(sparseArray.valueAt(i2));
        }
        g0(parcel, iF0);
    }

    public static void F(@NonNull Parcel parcel, int i, int i2) {
        h0(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void G(@NonNull Parcel parcel, int i, @NonNull int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeIntArray(iArr);
            g0(parcel, iF0);
        }
    }

    public static void H(@NonNull Parcel parcel, int i, @NonNull List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        g0(parcel, iF0);
    }

    public static void I(@NonNull Parcel parcel, int i, @NonNull Integer num, boolean z) {
        if (num != null) {
            h0(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            h0(parcel, i, 0);
        }
    }

    public static void J(@NonNull Parcel parcel, int i, @NonNull List list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeList(list);
            g0(parcel, iF0);
        }
    }

    public static void K(@NonNull Parcel parcel, int i, long j) {
        h0(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void L(@NonNull Parcel parcel, int i, @NonNull long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeLongArray(jArr);
            g0(parcel, iF0);
        }
    }

    public static void M(@NonNull Parcel parcel, int i, @NonNull List<Long> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeLong(list.get(i2).longValue());
        }
        g0(parcel, iF0);
    }

    public static void N(@NonNull Parcel parcel, int i, @NonNull Long l, boolean z) {
        if (l != null) {
            h0(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            h0(parcel, i, 0);
        }
    }

    public static void O(@NonNull Parcel parcel, int i, @NonNull Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            g0(parcel, iF0);
        }
    }

    public static void P(@NonNull Parcel parcel, int i, @NonNull Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void Q(@NonNull Parcel parcel, int i, @NonNull List<Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcel parcel2 = list.get(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void R(@NonNull Parcel parcel, int i, @NonNull SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            Parcel parcelValueAt = sparseArray.valueAt(i2);
            if (parcelValueAt != null) {
                parcel.writeInt(parcelValueAt.dataSize());
                parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void S(@NonNull Parcel parcel, int i, @NonNull Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            g0(parcel, iF0);
        }
    }

    public static void T(@NonNull Parcel parcel, int i, @NonNull PendingIntent pendingIntent, boolean z) {
        if (pendingIntent == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            g0(parcel, iF0);
        }
    }

    public static void U(@NonNull Parcel parcel, int i, short s) {
        h0(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void V(@NonNull Parcel parcel, int i, @NonNull SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            g0(parcel, iF0);
        }
    }

    public static void W(@NonNull Parcel parcel, int i, @NonNull SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseIntArray.keyAt(i2));
            parcel.writeInt(sparseIntArray.valueAt(i2));
        }
        g0(parcel, iF0);
    }

    public static void X(@NonNull Parcel parcel, int i, @NonNull SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseLongArray.keyAt(i2));
            parcel.writeLong(sparseLongArray.valueAt(i2));
        }
        g0(parcel, iF0);
    }

    public static void Y(@NonNull Parcel parcel, int i, @NonNull String str, boolean z) {
        if (str == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeString(str);
            g0(parcel, iF0);
        }
    }

    public static void Z(@NonNull Parcel parcel, int i, @NonNull String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeStringArray(strArr);
            g0(parcel, iF0);
        }
    }

    public static int a(@NonNull Parcel parcel) {
        return f0(parcel, 20293);
    }

    public static void a0(@NonNull Parcel parcel, int i, @NonNull List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeStringList(list);
            g0(parcel, iF0);
        }
    }

    public static void b(@NonNull Parcel parcel, int i) {
        g0(parcel, i);
    }

    public static void b0(@NonNull Parcel parcel, int i, @NonNull SparseArray<String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeString(sparseArray.valueAt(i2));
        }
        g0(parcel, iF0);
    }

    public static void c(@NonNull Parcel parcel, int i, @NonNull BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            g0(parcel, iF0);
        }
    }

    public static <T extends Parcelable> void c0(@NonNull Parcel parcel, int i, @NonNull T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, t, i2);
            }
        }
        g0(parcel, iF0);
    }

    public static void d(@NonNull Parcel parcel, int i, @NonNull BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
        }
        g0(parcel, iF0);
    }

    public static <T extends Parcelable> void d0(@NonNull Parcel parcel, int i, @NonNull List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, t, 0);
            }
        }
        g0(parcel, iF0);
    }

    public static void e(@NonNull Parcel parcel, int i, @NonNull BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            g0(parcel, iF0);
        }
    }

    public static <T extends Parcelable> void e0(@NonNull Parcel parcel, int i, @NonNull SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            T tValueAt = sparseArray.valueAt(i2);
            if (tValueAt == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, tValueAt, 0);
            }
        }
        g0(parcel, iF0);
    }

    public static void f(@NonNull Parcel parcel, int i, @NonNull BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        g0(parcel, iF0);
    }

    public static int f0(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void g(@NonNull Parcel parcel, int i, boolean z) {
        h0(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void g0(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void h(@NonNull Parcel parcel, int i, @NonNull boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeBooleanArray(zArr);
            g0(parcel, iF0);
        }
    }

    public static void h0(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public static void i(@NonNull Parcel parcel, int i, @NonNull List<Boolean> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
        }
        g0(parcel, iF0);
    }

    public static void i0(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static void j(@NonNull Parcel parcel, int i, @NonNull Boolean bool, boolean z) {
        if (bool != null) {
            h0(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            h0(parcel, i, 0);
        }
    }

    public static void k(@NonNull Parcel parcel, int i, @NonNull Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeBundle(bundle);
            g0(parcel, iF0);
        }
    }

    public static void l(@NonNull Parcel parcel, int i, byte b) {
        h0(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m(@NonNull Parcel parcel, int i, @NonNull byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeByteArray(bArr);
            g0(parcel, iF0);
        }
    }

    public static void n(@NonNull Parcel parcel, int i, @NonNull byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        g0(parcel, iF0);
    }

    public static void o(@NonNull Parcel parcel, int i, @NonNull SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeByteArray(sparseArray.valueAt(i2));
        }
        g0(parcel, iF0);
    }

    public static void p(@NonNull Parcel parcel, int i, char c) {
        h0(parcel, i, 4);
        parcel.writeInt(c);
    }

    public static void q(@NonNull Parcel parcel, int i, @NonNull char[] cArr, boolean z) {
        if (cArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeCharArray(cArr);
            g0(parcel, iF0);
        }
    }

    public static void r(@NonNull Parcel parcel, int i, double d) {
        h0(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void s(@NonNull Parcel parcel, int i, @NonNull double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeDoubleArray(dArr);
            g0(parcel, iF0);
        }
    }

    public static void t(@NonNull Parcel parcel, int i, @NonNull List<Double> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeDouble(list.get(i2).doubleValue());
        }
        g0(parcel, iF0);
    }

    public static void u(@NonNull Parcel parcel, int i, @NonNull Double d, boolean z) {
        if (d != null) {
            h0(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            h0(parcel, i, 0);
        }
    }

    public static void v(@NonNull Parcel parcel, int i, @NonNull SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
        }
        g0(parcel, iF0);
    }

    public static void w(@NonNull Parcel parcel, int i, float f) {
        h0(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void x(@NonNull Parcel parcel, int i, @NonNull float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                h0(parcel, i, 0);
            }
        } else {
            int iF0 = f0(parcel, i);
            parcel.writeFloatArray(fArr);
            g0(parcel, iF0);
        }
    }

    public static void y(@NonNull Parcel parcel, int i, @NonNull List<Float> list, boolean z) {
        if (list == null) {
            if (z) {
                h0(parcel, i, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeFloat(list.get(i2).floatValue());
        }
        g0(parcel, iF0);
    }

    public static void z(@NonNull Parcel parcel, int i, @NonNull Float f, boolean z) {
        if (f != null) {
            h0(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            h0(parcel, i, 0);
        }
    }
}
