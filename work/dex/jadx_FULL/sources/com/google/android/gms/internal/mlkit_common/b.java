package com.google.android.gms.internal.mlkit_common;

import com.zj.adlib.b9c;
import com.zj.adlib.jac;
import com.zj.adlib.t9c;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jac f5738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f5739a = new Object[8];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31336a = 0;

    public final b a(Object obj, Object obj2) {
        int i = this.f31336a + 1;
        Object[] objArr = this.f5739a;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.f5739a = Arrays.copyOf(objArr, t9c.a(length, i2));
        }
        b9c.a(obj, obj2);
        Object[] objArr2 = this.f5739a;
        int i3 = this.f31336a;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.f31336a = i3 + 1;
        return this;
    }

    public final zzau b() {
        jac jacVar = this.f5738a;
        if (jacVar != null) {
            throw jacVar.a();
        }
        zzbc zzbcVarZzg = zzbc.zzg(this.f31336a, this.f5739a, this);
        jac jacVar2 = this.f5738a;
        if (jacVar2 == null) {
            return zzbcVarZzg;
        }
        throw jacVar2.a();
    }
}
