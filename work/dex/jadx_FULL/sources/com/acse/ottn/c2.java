package com.acse.ottn;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22907a;
    public b2 b;
    public b2 c;
    public Interpolator d;
    public ArrayList<b2> e;
    public s4 f;

    public c2(b2... b2VarArr) {
        this.f22907a = b2VarArr.length;
        ArrayList<b2> arrayList = new ArrayList<>();
        this.e = arrayList;
        arrayList.addAll(Arrays.asList(b2VarArr));
        this.b = this.e.get(0);
        b2 b2Var = this.e.get(this.f22907a - 1);
        this.c = b2Var;
        this.d = b2Var.c();
    }

    public static c2 a(int... iArr) {
        int length = iArr.length;
        b2.b[] bVarArr = new b2.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (b2.b) b2.b(0.0f);
            bVarArr[1] = (b2.b) b2.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (b2.b) b2.a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                bVarArr[i] = (b2.b) b2.a(i / (length - 1), iArr[i]);
            }
        }
        return new y1(bVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i = 0; i < this.f22907a; i++) {
            str = str + this.e.get(i).e() + com.ipd.dsp.internal.i.q.a.i;
        }
        return str;
    }

    public static c2 a(float... fArr) {
        int length = fArr.length;
        b2.a[] aVarArr = new b2.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (b2.a) b2.a(0.0f);
            aVarArr[1] = (b2.a) b2.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (b2.a) b2.a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                aVarArr[i] = (b2.a) b2.a(i / (length - 1), fArr[i]);
            }
        }
        return new j1(aVarArr);
    }

    public static c2 a(b2... b2VarArr) {
        int length = b2VarArr.length;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (b2 b2Var : b2VarArr) {
            if (b2Var instanceof b2.a) {
                z = true;
            } else if (b2Var instanceof b2.b) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            b2.a[] aVarArr = new b2.a[length];
            while (i < length) {
                aVarArr[i] = (b2.a) b2VarArr[i];
                i++;
            }
            return new j1(aVarArr);
        }
        if (z2 && !z && !z3) {
            b2.b[] bVarArr = new b2.b[length];
            while (i < length) {
                bVarArr[i] = (b2.b) b2VarArr[i];
                i++;
            }
            return new y1(bVarArr);
        }
        return new c2(b2VarArr);
    }

    public static c2 a(Object... objArr) {
        int length = objArr.length;
        b2.c[] cVarArr = new b2.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (b2.c) b2.c(0.0f);
            cVarArr[1] = (b2.c) b2.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (b2.c) b2.a(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                cVarArr[i] = (b2.c) b2.a(i / (length - 1), objArr[i]);
            }
        }
        return new c2(cVarArr);
    }

    public void a(s4 s4Var) {
        this.f = s4Var;
    }

    @Override // 
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c2 clone() {
        ArrayList<b2> arrayList = this.e;
        int size = arrayList.size();
        b2[] b2VarArr = new b2[size];
        for (int i = 0; i < size; i++) {
            b2VarArr[i] = arrayList.get(i).clone();
        }
        return new c2(b2VarArr);
    }

    public Object a(float f) {
        int i = this.f22907a;
        if (i == 2) {
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            return this.f.evaluate(f, this.b.e(), this.c.e());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            b2 b2Var = this.e.get(1);
            Interpolator interpolatorC = b2Var.c();
            if (interpolatorC != null) {
                f = interpolatorC.getInterpolation(f);
            }
            float fB = this.b.b();
            return this.f.evaluate((f - fB) / (b2Var.b() - fB), this.b.e(), b2Var.e());
        }
        if (f >= 1.0f) {
            b2 b2Var2 = this.e.get(i - 2);
            Interpolator interpolatorC2 = this.c.c();
            if (interpolatorC2 != null) {
                f = interpolatorC2.getInterpolation(f);
            }
            float fB2 = b2Var2.b();
            return this.f.evaluate((f - fB2) / (this.c.b() - fB2), b2Var2.e(), this.c.e());
        }
        b2 b2Var3 = this.b;
        while (i2 < this.f22907a) {
            b2 b2Var4 = this.e.get(i2);
            if (f < b2Var4.b()) {
                Interpolator interpolatorC3 = b2Var4.c();
                if (interpolatorC3 != null) {
                    f = interpolatorC3.getInterpolation(f);
                }
                float fB3 = b2Var3.b();
                return this.f.evaluate((f - fB3) / (b2Var4.b() - fB3), b2Var3.e(), b2Var4.e());
            }
            i2++;
            b2Var3 = b2Var4;
        }
        return this.c.e();
    }
}
