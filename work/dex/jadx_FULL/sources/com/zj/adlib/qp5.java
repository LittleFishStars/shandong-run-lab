package com.zj.adlib;

import com.google.zxing.common.ECIInput;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class qp5 implements ECIInput {
    public static final int b = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f19157a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f44270a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f19158a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final b f19159a;
        public final int b;

        public boolean e() {
            return this.f44270a == 1000;
        }

        public b(char c, fv2 fv2Var, int i, b bVar, int i2) {
            char c2 = c == i2 ? (char) 1000 : c;
            this.f44270a = c2;
            this.f19158a = i;
            this.f19159a = bVar;
            int length = c2 == 1000 ? 1 : fv2Var.b(c, i).length;
            length = (bVar == null ? 0 : bVar.f19158a) != i ? length + 3 : length;
            this.b = bVar != null ? length + bVar.b : length;
        }
    }

    public qp5(String str, Charset charset, int i) {
        this.f44269a = i;
        fv2 fv2Var = new fv2(str, charset, i);
        if (fv2Var.h() != 1) {
            this.f19157a = f(str, fv2Var, i);
            return;
        }
        this.f19157a = new int[str.length()];
        for (int i2 = 0; i2 < this.f19157a.length; i2++) {
            char cCharAt = str.charAt(i2);
            int[] iArr = this.f19157a;
            if (cCharAt == i) {
                cCharAt = 1000;
            }
            iArr[i2] = cCharAt;
        }
    }

    public static void d(b[][] bVarArr, int i, b bVar) {
        if (bVarArr[i][bVar.f19158a] == null || bVarArr[i][bVar.f19158a].b > bVar.b) {
            bVarArr[i][bVar.f19158a] = bVar;
        }
    }

    public static void e(String str, fv2 fv2Var, b[][] bVarArr, int i, b bVar, int i2) {
        int i3;
        int iG;
        char cCharAt = str.charAt(i);
        int iH = fv2Var.h();
        if (fv2Var.g() < 0 || !(cCharAt == i2 || fv2Var.a(cCharAt, fv2Var.g()))) {
            i3 = iH;
            iG = 0;
        } else {
            iG = fv2Var.g();
            i3 = iG + 1;
        }
        for (int i4 = iG; i4 < i3; i4++) {
            if (cCharAt == i2 || fv2Var.a(cCharAt, i4)) {
                d(bVarArr, i + 1, new b(cCharAt, fv2Var, i4, bVar, i2));
            }
        }
    }

    public static int[] f(String str, fv2 fv2Var, int i) {
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, fv2Var.h());
        e(str, fv2Var, bVarArr, 0, null, i);
        for (int i2 = 1; i2 <= length; i2++) {
            for (int i3 = 0; i3 < fv2Var.h(); i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar != null && i2 < length) {
                    e(str, fv2Var, bVarArr, i2, bVar, i);
                }
            }
            for (int i4 = 0; i4 < fv2Var.h(); i4++) {
                bVarArr[i2 - 1][i4] = null;
            }
        }
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < fv2Var.h(); i7++) {
            b bVar2 = bVarArr[length][i7];
            if (bVar2 != null && bVar2.b < i6) {
                i6 = bVar2.b;
                i5 = i7;
            }
        }
        if (i5 < 0) {
            throw new RuntimeException("Internal error: failed to encode \"" + str + "\"");
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 = bVarArr[length][i5]; bVar3 != null; bVar3 = bVar3.f19159a) {
            if (bVar3.e()) {
                arrayList.add(0, 1000);
            } else {
                byte[] bArrB = fv2Var.b(bVar3.f44270a, bVar3.f19158a);
                for (int length2 = bArrB.length - 1; length2 >= 0; length2--) {
                    arrayList.add(0, Integer.valueOf(bArrB[length2] & 255));
                }
            }
            if ((bVar3.f19159a == null ? 0 : bVar3.f19159a.f19158a) != bVar3.f19158a) {
                arrayList.add(0, Integer.valueOf(fv2Var.f(bVar3.f19158a) + 256));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        return iArr;
    }

    @Override // com.google.zxing.common.ECIInput
    public boolean a(int i, int i2) {
        if ((i + i2) - 1 >= this.f19157a.length) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (b(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.zxing.common.ECIInput
    public boolean b(int i) {
        if (i >= 0 && i < length()) {
            int i2 = this.f19157a[i];
            return i2 > 255 && i2 <= 999;
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    @Override // com.google.zxing.common.ECIInput
    public int c(int i) {
        if (i < 0 || i >= length()) {
            throw new IndexOutOfBoundsException("" + i);
        }
        if (b(i)) {
            return this.f19157a[i] - 256;
        }
        throw new IllegalArgumentException("value at " + i + " is not an ECI but a character");
    }

    @Override // com.google.zxing.common.ECIInput
    public char charAt(int i) {
        if (i < 0 || i >= length()) {
            throw new IndexOutOfBoundsException("" + i);
        }
        if (!b(i)) {
            return (char) (h(i) ? this.f44269a : this.f19157a[i]);
        }
        throw new IllegalArgumentException("value at " + i + " is not a character but an ECI");
    }

    public int g() {
        return this.f44269a;
    }

    public boolean h(int i) {
        if (i >= 0 && i < length()) {
            return this.f19157a[i] == 1000;
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    @Override // com.google.zxing.common.ECIInput
    public int length() {
        return this.f19157a.length;
    }

    @Override // com.google.zxing.common.ECIInput
    public CharSequence subSequence(int i, int i2) {
        if (i < 0 || i > i2 || i2 > length()) {
            throw new IndexOutOfBoundsException("" + i);
        }
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            if (b(i)) {
                throw new IllegalArgumentException("value at " + i + " is not a character but an ECI");
            }
            sb.append(charAt(i));
            i++;
        }
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (b(i)) {
                sb.append("ECI(");
                sb.append(c(i));
                sb.append(')');
            } else if (charAt(i) < 128) {
                sb.append('\'');
                sb.append(charAt(i));
                sb.append('\'');
            } else {
                sb.append((int) charAt(i));
            }
        }
        return sb.toString();
    }
}
