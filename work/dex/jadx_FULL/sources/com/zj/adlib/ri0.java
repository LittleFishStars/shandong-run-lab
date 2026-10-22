package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ri0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f44460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f19327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f19328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<byte[]> f19329a;
    public final int b;
    public final int c;

    public ri0(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f19329a = list;
        this.f19327a = i;
        this.b = i2;
        this.c = i3;
        this.f44460a = f;
        this.f19328a = str;
    }

    public static byte[] a(om6 om6Var) {
        int iM = om6Var.M();
        int iE = om6Var.e();
        om6Var.T(iM);
        return en1.d(om6Var.d(), iE, iM);
    }

    public static ri0 b(om6 om6Var) throws ParserException {
        int i;
        int i2;
        float f;
        String strA;
        try {
            om6Var.T(4);
            int iG = (om6Var.G() & 3) + 1;
            if (iG == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iG2 = om6Var.G() & 31;
            for (int i3 = 0; i3 < iG2; i3++) {
                arrayList.add(a(om6Var));
            }
            int iG3 = om6Var.G();
            for (int i4 = 0; i4 < iG3; i4++) {
                arrayList.add(a(om6Var));
            }
            if (iG2 > 0) {
                kw5.c cVarL = kw5.l((byte[]) arrayList.get(0), iG, ((byte[]) arrayList.get(0)).length);
                int i5 = cVarL.f;
                int i6 = cVarL.g;
                float f2 = cVarL.f42930a;
                strA = en1.a(cVarL.f17808a, cVarL.b, cVarL.c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
                strA = null;
            }
            return new ri0(arrayList, iG, i, i2, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e);
        }
    }
}
