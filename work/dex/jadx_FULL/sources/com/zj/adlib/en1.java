package com.zj.adlib;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class en1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41472a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f16355a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f16356a = {"", "A", "B", "C"};
    public static final int b = 32;
    public static final int c = 15;
    public static final int d = 0;

    public static String a(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static List<byte[]> b(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        Object[] objArr = new Object[5];
        objArr[0] = f16356a[i];
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Character.valueOf(z ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i4);
        StringBuilder sb = new StringBuilder(gj9.H("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f16355a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    public static int e(byte[] bArr, int i) {
        int length = bArr.length - f16355a.length;
        while (i <= length) {
            if (g(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Pair<Integer, Integer> f(byte[] bArr) {
        boolean z;
        om6 om6Var = new om6(bArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 3;
            if (i3 >= bArr.length) {
                z = false;
                break;
            }
            if (om6Var.J() == 1 && (bArr[i3] & 240) == 32) {
                z = true;
                break;
            }
            om6Var.S(om6Var.e() - 2);
            i2++;
        }
        sb0.b(z, "Invalid input: VOL not found.");
        nm6 nm6Var = new nm6(bArr);
        nm6Var.s((i2 + 4) * 8);
        nm6Var.s(1);
        nm6Var.s(8);
        if (nm6Var.g()) {
            nm6Var.s(4);
            nm6Var.s(3);
        }
        if (nm6Var.h(4) == 15) {
            nm6Var.s(8);
            nm6Var.s(8);
        }
        if (nm6Var.g()) {
            nm6Var.s(2);
            nm6Var.s(1);
            if (nm6Var.g()) {
                nm6Var.s(79);
            }
        }
        sb0.b(nm6Var.h(2) == 0, "Only supports rectangular video object layer shape.");
        sb0.a(nm6Var.g());
        int iH = nm6Var.h(16);
        sb0.a(nm6Var.g());
        if (nm6Var.g()) {
            sb0.a(iH > 0);
            for (int i4 = iH - 1; i4 > 0; i4 >>= 1) {
                i++;
            }
            nm6Var.s(i);
        }
        sb0.a(nm6Var.g());
        int iH2 = nm6Var.h(13);
        sb0.a(nm6Var.g());
        int iH3 = nm6Var.h(13);
        sb0.a(nm6Var.g());
        nm6Var.s(1);
        return Pair.create(Integer.valueOf(iH2), Integer.valueOf(iH3));
    }

    public static boolean g(byte[] bArr, int i) {
        if (bArr.length - i <= f16355a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f16355a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    public static Pair<Integer, Integer> h(byte[] bArr) {
        om6 om6Var = new om6(bArr);
        om6Var.S(9);
        int iG = om6Var.G();
        om6Var.S(20);
        return Pair.create(Integer.valueOf(om6Var.K()), Integer.valueOf(iG));
    }

    public static boolean i(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    @Nullable
    public static byte[][] j(byte[] bArr) {
        if (!g(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iE = 0;
        do {
            arrayList.add(Integer.valueOf(iE));
            iE = e(bArr, iE + f16355a.length);
        } while (iE != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i = 0;
        while (i < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            int iIntValue2 = (i < arrayList.size() + (-1) ? ((Integer) arrayList.get(i + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i] = bArr3;
            i++;
        }
        return bArr2;
    }
}
