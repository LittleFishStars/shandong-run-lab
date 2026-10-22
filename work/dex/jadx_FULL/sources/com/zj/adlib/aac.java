package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzar;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class aac extends q9c {
    public aac() {
        super(4);
    }

    public final aac b(Object obj) {
        obj.getClass();
        int i = ((q9c) this).f44158a + 1;
        Object[] objArr = ((q9c) this).f19036a;
        int length = objArr.length;
        if (length < i) {
            ((q9c) this).f19036a = Arrays.copyOf(objArr, t9c.a(length, i));
            ((q9c) this).f19035a = false;
        } else if (((q9c) this).f19035a) {
            ((q9c) this).f19036a = (Object[]) objArr.clone();
            ((q9c) this).f19035a = false;
        }
        Object[] objArr2 = ((q9c) this).f19036a;
        int i2 = ((q9c) this).f44158a;
        ((q9c) this).f44158a = i2 + 1;
        objArr2[i2] = obj;
        return this;
    }

    public final zzar c() {
        ((q9c) this).f19035a = true;
        return zzar.zzg(((q9c) this).f19036a, ((q9c) this).f44158a);
    }
}
