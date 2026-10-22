package com.zj.adlib;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class g51 implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f41823a;

    public g51(Reader reader) {
        this.f41823a = reader;
    }

    public static void b(xg7[] xg7VarArr, int i, int i2) {
        if (xg7VarArr != null) {
            for (int i3 = 0; i3 < xg7VarArr.length; i3++) {
                xg7 xg7Var = xg7VarArr[i3];
                if (xg7Var != null) {
                    xg7VarArr[i3] = new xg7(xg7Var.c() + i, xg7Var.d() + i2);
                }
            }
        }
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, ChecksumException, FormatException {
        return d(jv0Var, null);
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int iE = jv0Var.e() / 2;
        int iD = jv0Var.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.f41823a.d(jv0Var.a(0, 0, iE, iD), map);
                    } catch (NotFoundException unused) {
                        int i = iE / 2;
                        int i2 = iD / 2;
                        ug7 ug7VarD = this.f41823a.d(jv0Var.a(i, i2, iE, iD), map);
                        b(ug7VarD.f(), i, i2);
                        return ug7VarD;
                    }
                } catch (NotFoundException unused2) {
                    ug7 ug7VarD2 = this.f41823a.d(jv0Var.a(iE, iD, iE, iD), map);
                    b(ug7VarD2.f(), iE, iD);
                    return ug7VarD2;
                }
            } catch (NotFoundException unused3) {
                ug7 ug7VarD3 = this.f41823a.d(jv0Var.a(0, iD, iE, iD), map);
                b(ug7VarD3.f(), 0, iD);
                return ug7VarD3;
            }
        } catch (NotFoundException unused4) {
            ug7 ug7VarD4 = this.f41823a.d(jv0Var.a(iE, 0, iE, iD), map);
            b(ug7VarD4.f(), iE, 0);
            return ug7VarD4;
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.f41823a.reset();
    }
}
