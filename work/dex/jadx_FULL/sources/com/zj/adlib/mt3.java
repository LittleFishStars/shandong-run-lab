package com.zj.adlib;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.multi.MultipleBarcodeReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class mt3 implements MultipleBarcodeReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43377a = 100;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ug7[] f18295a = new ug7[0];
    public static final int b = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Reader f18296a;

    public mt3(Reader reader) {
        this.f18296a = reader;
    }

    public static ug7 d(ug7 ug7Var, int i, int i2) {
        xg7[] xg7VarArrF = ug7Var.f();
        if (xg7VarArrF == null) {
            return ug7Var;
        }
        xg7[] xg7VarArr = new xg7[xg7VarArrF.length];
        for (int i3 = 0; i3 < xg7VarArrF.length; i3++) {
            xg7 xg7Var = xg7VarArrF[i3];
            if (xg7Var != null) {
                xg7VarArr[i3] = new xg7(xg7Var.c() + i, xg7Var.d() + i2);
            }
        }
        ug7 ug7Var2 = new ug7(ug7Var.g(), ug7Var.d(), ug7Var.c(), xg7VarArr, ug7Var.b(), ug7Var.h());
        ug7Var2.i(ug7Var.e());
        return ug7Var2;
    }

    public final void a(jv0 jv0Var, Map<DecodeHintType, ?> map, List<ug7> list, int i, int i2, int i3) {
        boolean z;
        float f;
        int i4;
        int i5;
        if (i3 > 4) {
            return;
        }
        try {
            ug7 ug7VarD = this.f18296a.d(jv0Var, map);
            Iterator<ug7> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g().equals(ug7VarD.g())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(d(ug7VarD, i, i2));
            }
            xg7[] xg7VarArrF = ug7VarD.f();
            if (xg7VarArrF == null || xg7VarArrF.length == 0) {
                return;
            }
            int iE = jv0Var.e();
            int iD = jv0Var.d();
            float f2 = iE;
            float f3 = 0.0f;
            float f4 = iD;
            float f5 = 0.0f;
            for (xg7 xg7Var : xg7VarArrF) {
                if (xg7Var != null) {
                    float fC = xg7Var.c();
                    float fD = xg7Var.d();
                    if (fC < f2) {
                        f2 = fC;
                    }
                    if (fD < f4) {
                        f4 = fD;
                    }
                    if (fC > f5) {
                        f5 = fC;
                    }
                    if (fD > f3) {
                        f3 = fD;
                    }
                }
            }
            if (f2 > 100.0f) {
                f = f5;
                a(jv0Var.a(0, 0, (int) f2, iD), map, list, i, i2, i3 + 1);
            } else {
                f = f5;
            }
            if (f4 > 100.0f) {
                i4 = iE;
                a(jv0Var.a(0, 0, i4, (int) f4), map, list, i, i2, i3 + 1);
            } else {
                i4 = iE;
            }
            float f6 = f;
            if (f6 < i4 - 100) {
                int i6 = (int) f6;
                i5 = iD;
                a(jv0Var.a(i6, 0, i4 - i6, i5), map, list, i + i6, i2, i3 + 1);
            } else {
                i5 = iD;
            }
            if (f3 < i5 - 100) {
                int i7 = (int) f3;
                a(jv0Var.a(0, i7, i4, i5 - i7), map, list, i, i2 + i7, i3 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] b(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(jv0Var, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (ug7[]) arrayList.toArray(f18295a);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public ug7[] c(jv0 jv0Var) throws NotFoundException {
        return b(jv0Var, null);
    }
}
