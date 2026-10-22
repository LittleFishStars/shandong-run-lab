package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y1 extends c2 {
    public int g;
    public int h;
    public int i;
    public boolean j;

    public y1(b2.b... bVarArr) {
        super(bVarArr);
        this.j = true;
    }

    @Override // com.acse.ottn.c2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public y1 clone() {
        ArrayList<b2> arrayList = this.e;
        int size = arrayList.size();
        b2.b[] bVarArr = new b2.b[size];
        for (int i = 0; i < size; i++) {
            bVarArr[i] = (b2.b) arrayList.get(i).clone();
        }
        return new y1(bVarArr);
    }

    @Override // com.acse.ottn.c2
    public Object a(float f) {
        return Integer.valueOf(b(f));
    }

    public int b(float f) {
        int i = this.f22907a;
        if (i == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((b2.b) this.e.get(0)).h();
                int iH = ((b2.b) this.e.get(1)).h();
                this.h = iH;
                this.i = iH - this.g;
            }
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            s4 s4Var = this.f;
            if (s4Var == null) {
                return this.g + ((int) (f * this.i));
            }
            return ((Number) s4Var.evaluate(f, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
        }
        if (f <= 0.0f) {
            b2.b bVar = (b2.b) this.e.get(0);
            b2.b bVar2 = (b2.b) this.e.get(1);
            int iH2 = bVar.h();
            int iH3 = bVar2.h();
            float fB = bVar.b();
            float fB2 = bVar2.b();
            Interpolator interpolatorC = bVar2.c();
            if (interpolatorC != null) {
                f = interpolatorC.getInterpolation(f);
            }
            float f2 = (f - fB) / (fB2 - fB);
            s4 s4Var2 = this.f;
            return s4Var2 == null ? iH2 + ((int) (f2 * (iH3 - iH2))) : ((Number) s4Var2.evaluate(f2, Integer.valueOf(iH2), Integer.valueOf(iH3))).intValue();
        }
        if (f >= 1.0f) {
            b2.b bVar3 = (b2.b) this.e.get(i - 2);
            b2.b bVar4 = (b2.b) this.e.get(this.f22907a - 1);
            int iH4 = bVar3.h();
            int iH5 = bVar4.h();
            float fB3 = bVar3.b();
            float fB4 = bVar4.b();
            Interpolator interpolatorC2 = bVar4.c();
            if (interpolatorC2 != null) {
                f = interpolatorC2.getInterpolation(f);
            }
            float f3 = (f - fB3) / (fB4 - fB3);
            s4 s4Var3 = this.f;
            return s4Var3 == null ? iH4 + ((int) (f3 * (iH5 - iH4))) : ((Number) s4Var3.evaluate(f3, Integer.valueOf(iH4), Integer.valueOf(iH5))).intValue();
        }
        b2.b bVar5 = (b2.b) this.e.get(0);
        int i2 = 1;
        while (true) {
            int i3 = this.f22907a;
            if (i2 < i3) {
                b2.b bVar6 = (b2.b) this.e.get(i2);
                if (f < bVar6.b()) {
                    Interpolator interpolatorC3 = bVar6.c();
                    if (interpolatorC3 != null) {
                        f = interpolatorC3.getInterpolation(f);
                    }
                    float fB5 = (f - bVar5.b()) / (bVar6.b() - bVar5.b());
                    int iH6 = bVar5.h();
                    int iH7 = bVar6.h();
                    s4 s4Var4 = this.f;
                    return s4Var4 == null ? iH6 + ((int) (fB5 * (iH7 - iH6))) : ((Number) s4Var4.evaluate(fB5, Integer.valueOf(iH6), Integer.valueOf(iH7))).intValue();
                }
                i2++;
                bVar5 = bVar6;
            } else {
                return ((Number) this.e.get(i3 - 1).e()).intValue();
            }
        }
    }
}
