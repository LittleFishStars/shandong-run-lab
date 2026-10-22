package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tz3 {
    public static final int d = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f45033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f19921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f19922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<byte[]> f19923a;
    public final int b;
    public final int c;

    public tz3(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f19923a = list;
        this.f19921a = i;
        this.b = i2;
        this.c = i3;
        this.f45033a = f;
        this.f19922a = str;
    }

    public static tz3 a(om6 om6Var) throws ParserException {
        try {
            om6Var.T(21);
            int iG = om6Var.G() & 3;
            int iG2 = om6Var.G();
            int iE = om6Var.e();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < iG2; i3++) {
                om6Var.T(1);
                int iM = om6Var.M();
                for (int i4 = 0; i4 < iM; i4++) {
                    int iM2 = om6Var.M();
                    i2 += iM2 + 4;
                    om6Var.T(iM2);
                }
            }
            om6Var.S(iE);
            byte[] bArr = new byte[i2];
            int i5 = -1;
            int i6 = -1;
            float f = 1.0f;
            String strC = null;
            int i7 = 0;
            int i8 = 0;
            while (i7 < iG2) {
                int iG3 = om6Var.G() & 127;
                int iM3 = om6Var.M();
                int i9 = i;
                while (i9 < iM3) {
                    int iM4 = om6Var.M();
                    byte[] bArr2 = kw5.f17801a;
                    int i10 = iG2;
                    System.arraycopy(bArr2, i, bArr, i8, bArr2.length);
                    int length = i8 + bArr2.length;
                    System.arraycopy(om6Var.d(), om6Var.e(), bArr, length, iM4);
                    if (iG3 == 33 && i9 == 0) {
                        kw5.a aVarH = kw5.h(bArr, length, length + iM4);
                        int i11 = aVarH.f;
                        i6 = aVarH.g;
                        f = aVarH.f42928a;
                        i5 = i11;
                        strC = en1.c(aVarH.f17804a, aVarH.f17805a, aVarH.b, aVarH.c, aVarH.f17806a, aVarH.d);
                    }
                    i8 = length + iM4;
                    om6Var.T(iM4);
                    i9++;
                    iG2 = i10;
                    iG3 = iG3;
                    iM3 = iM3;
                    i = 0;
                }
                i7++;
                i = 0;
            }
            return new tz3(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iG + 1, i5, i6, f, strC);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }
}
