package com.acse.ottn;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class z2 extends t4 {
    public static final boolean Q = false;
    public static final Map<String, k3> R;
    public Object N;
    public String O;
    public k3 P;

    static {
        HashMap map = new HashMap();
        R = map;
        map.put("alpha", j3.f23066a);
        map.put("pivotX", j3.b);
        map.put("pivotY", j3.c);
        map.put("translationX", j3.d);
        map.put("translationY", j3.e);
        map.put(Key.ROTATION, j3.f);
        map.put("rotationX", j3.g);
        map.put("rotationY", j3.h);
        map.put("scaleX", j3.i);
        map.put("scaleY", j3.j);
        map.put("scrollX", j3.k);
        map.put("scrollY", j3.l);
        map.put("x", j3.m);
        map.put("y", j3.n);
    }

    public z2() {
    }

    @Override // com.acse.ottn.t4
    public void D() {
        if (this.l) {
            return;
        }
        if (this.P == null && m.q && (this.N instanceof View)) {
            Map<String, k3> map = R;
            if (map.containsKey(this.O)) {
                a(map.get(this.O));
            }
        }
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].c(this.N);
        }
        super.D();
    }

    @Override // com.acse.ottn.t4
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public z2 clone() {
        return (z2) super.clone();
    }

    public String I() {
        return this.O;
    }

    public Object J() {
        return this.N;
    }

    public void b(String str) {
        l3[] l3VarArr = this.s;
        if (l3VarArr != null) {
            l3 l3Var = l3VarArr[0];
            String strC = l3Var.c();
            l3Var.a(str);
            this.t.remove(strC);
            this.t.put(str, l3Var);
        }
        this.O = str;
        this.l = false;
    }

    @Override // com.acse.ottn.t4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public z2 a(long j) {
        super.a(j);
        return this;
    }

    @Override // com.acse.ottn.j
    public void i() {
        D();
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].b(this.N);
        }
    }

    @Override // com.acse.ottn.j
    public void j() {
        D();
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].d(this.N);
        }
    }

    @Override // com.acse.ottn.t4, com.acse.ottn.j
    public void k() {
        super.k();
    }

    @Override // com.acse.ottn.t4
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.N;
        if (this.s != null) {
            for (int i = 0; i < this.s.length; i++) {
                str = str + "\n    " + this.s[i].toString();
            }
        }
        return str;
    }

    public z2(Object obj, String str) {
        this.N = obj;
        b(str);
    }

    public void a(k3 k3Var) {
        l3[] l3VarArr = this.s;
        if (l3VarArr != null) {
            l3 l3Var = l3VarArr[0];
            String strC = l3Var.c();
            l3Var.a(k3Var);
            this.t.remove(strC);
            this.t.put(this.O, l3Var);
        }
        if (this.P != null) {
            this.O = k3Var.a();
        }
        this.P = k3Var;
        this.l = false;
    }

    public <T> z2(T t, k3<T, ?> k3Var) {
        this.N = t;
        a((k3) k3Var);
    }

    @Override // com.acse.ottn.t4
    public void b(int... iArr) {
        l3[] l3VarArr = this.s;
        if (l3VarArr != null && l3VarArr.length != 0) {
            super.b(iArr);
            return;
        }
        k3 k3Var = this.P;
        if (k3Var != null) {
            b(l3.a((k3<?, Integer>) k3Var, iArr));
        } else {
            b(l3.a(this.O, iArr));
        }
    }

    public static z2 a(Object obj, String str, int... iArr) {
        z2 z2Var = new z2(obj, str);
        z2Var.b(iArr);
        return z2Var;
    }

    @Override // com.acse.ottn.t4
    public void b(float... fArr) {
        l3[] l3VarArr = this.s;
        if (l3VarArr != null && l3VarArr.length != 0) {
            super.b(fArr);
            return;
        }
        k3 k3Var = this.P;
        if (k3Var != null) {
            b(l3.a((k3<?, Float>) k3Var, fArr));
        } else {
            b(l3.a(this.O, fArr));
        }
    }

    public static <T> z2 a(T t, k3<T, Integer> k3Var, int... iArr) {
        z2 z2Var = new z2(t, k3Var);
        z2Var.b(iArr);
        return z2Var;
    }

    public static z2 a(Object obj, String str, float... fArr) {
        z2 z2Var = new z2(obj, str);
        z2Var.b(fArr);
        return z2Var;
    }

    public static <T> z2 a(T t, k3<T, Float> k3Var, float... fArr) {
        z2 z2Var = new z2(t, k3Var);
        z2Var.b(fArr);
        return z2Var;
    }

    public static z2 a(Object obj, String str, s4 s4Var, Object... objArr) {
        z2 z2Var = new z2(obj, str);
        z2Var.a(objArr);
        z2Var.a(s4Var);
        return z2Var;
    }

    public static <T, V> z2 a(T t, k3<T, V> k3Var, s4<V> s4Var, V... vArr) {
        z2 z2Var = new z2(t, k3Var);
        z2Var.a((Object[]) vArr);
        z2Var.a((s4) s4Var);
        return z2Var;
    }

    public static z2 a(Object obj, l3... l3VarArr) {
        z2 z2Var = new z2();
        z2Var.N = obj;
        z2Var.b(l3VarArr);
        return z2Var;
    }

    @Override // com.acse.ottn.t4
    public void a(Object... objArr) {
        l3[] l3VarArr = this.s;
        if (l3VarArr != null && l3VarArr.length != 0) {
            super.a(objArr);
            return;
        }
        k3 k3Var = this.P;
        if (k3Var != null) {
            b(l3.a(k3Var, (s4) null, objArr));
        } else {
            b(l3.a(this.O, (s4) null, objArr));
        }
    }

    @Override // com.acse.ottn.j
    public void a(Object obj) {
        Object obj2 = this.N;
        if (obj2 != obj) {
            this.N = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.l = false;
            }
        }
    }

    @Override // com.acse.ottn.t4
    public void a(float f) {
        super.a(f);
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].a(this.N);
        }
    }
}
