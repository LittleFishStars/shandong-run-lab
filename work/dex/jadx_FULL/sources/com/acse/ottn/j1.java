package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j1 extends c2 {
    public float g;
    public float h;
    public float i;
    public boolean j;

    public j1(b2.a... aVarArr) {
        super(aVarArr);
        this.j = true;
    }

    @Override // com.acse.ottn.c2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 clone() {
        ArrayList<b2> arrayList = this.e;
        int size = arrayList.size();
        b2.a[] aVarArr = new b2.a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = (b2.a) arrayList.get(i).clone();
        }
        return new j1(aVarArr);
    }

    @Override // com.acse.ottn.c2
    public Object a(float f) {
        return Float.valueOf(b(f));
    }

    public float b(float f) {
        int i = this.f22907a;
        if (i == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((b2.a) this.e.get(0)).h();
                float fH = ((b2.a) this.e.get(1)).h();
                this.h = fH;
                this.i = fH - this.g;
            }
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            s4 s4Var = this.f;
            if (s4Var == null) {
                return this.g + (f * this.i);
            }
            return ((Number) s4Var.evaluate(f, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
        }
        if (f <= 0.0f) {
            b2.a aVar = (b2.a) this.e.get(0);
            b2.a aVar2 = (b2.a) this.e.get(1);
            float fH2 = aVar.h();
            float fH3 = aVar2.h();
            float fB = aVar.b();
            float fB2 = aVar2.b();
            Interpolator interpolatorC = aVar2.c();
            if (interpolatorC != null) {
                f = interpolatorC.getInterpolation(f);
            }
            float f2 = (f - fB) / (fB2 - fB);
            s4 s4Var2 = this.f;
            return s4Var2 == null ? fH2 + (f2 * (fH3 - fH2)) : ((Number) s4Var2.evaluate(f2, Float.valueOf(fH2), Float.valueOf(fH3))).floatValue();
        }
        if (f >= 1.0f) {
            b2.a aVar3 = (b2.a) this.e.get(i - 2);
            b2.a aVar4 = (b2.a) this.e.get(this.f22907a - 1);
            float fH4 = aVar3.h();
            float fH5 = aVar4.h();
            float fB3 = aVar3.b();
            float fB4 = aVar4.b();
            Interpolator interpolatorC2 = aVar4.c();
            if (interpolatorC2 != null) {
                f = interpolatorC2.getInterpolation(f);
            }
            float f3 = (f - fB3) / (fB4 - fB3);
            s4 s4Var3 = this.f;
            return s4Var3 == null ? fH4 + (f3 * (fH5 - fH4)) : ((Number) s4Var3.evaluate(f3, Float.valueOf(fH4), Float.valueOf(fH5))).floatValue();
        }
        b2.a aVar5 = (b2.a) this.e.get(0);
        int i2 = 1;
        while (true) {
            int i3 = this.f22907a;
            if (i2 < i3) {
                b2.a aVar6 = (b2.a) this.e.get(i2);
                if (f < aVar6.b()) {
                    Interpolator interpolatorC3 = aVar6.c();
                    if (interpolatorC3 != null) {
                        f = interpolatorC3.getInterpolation(f);
                    }
                    float fB5 = (f - aVar5.b()) / (aVar6.b() - aVar5.b());
                    float fH6 = aVar5.h();
                    float fH7 = aVar6.h();
                    s4 s4Var4 = this.f;
                    return s4Var4 == null ? fH6 + (fB5 * (fH7 - fH6)) : ((Number) s4Var4.evaluate(fB5, Float.valueOf(fH6), Float.valueOf(fH7))).floatValue();
                }
                i2++;
                aVar5 = aVar6;
            } else {
                return ((Number) this.e.get(i3 - 1).e()).floatValue();
            }
        }
    }
}
