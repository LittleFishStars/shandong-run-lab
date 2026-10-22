package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class u extends zzcp {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f5776a = new Object[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31359a = 0;

    public u(int i) {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcp
    public /* bridge */ /* synthetic */ zzcp a(Object obj) {
        throw null;
    }

    public final u b(Object obj) {
        obj.getClass();
        d(this.f31359a + 1);
        Object[] objArr = this.f5776a;
        int i = this.f31359a;
        this.f31359a = i + 1;
        objArr[i] = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzcp c(Iterable iterable) {
        if (iterable instanceof Collection) {
            d(this.f31359a + iterable.size());
            if (iterable instanceof zzcq) {
                this.f31359a = ((zzcq) iterable).zza(this.f5776a, this.f31359a);
                return this;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        return this;
    }

    public final void d(int i) {
        Object[] objArr = this.f5776a;
        int length = objArr.length;
        if (length >= i) {
            if (this.f5775a) {
                this.f5776a = (Object[]) objArr.clone();
                this.f5775a = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.f5776a = Arrays.copyOf(objArr, i2);
        this.f5775a = false;
    }
}
