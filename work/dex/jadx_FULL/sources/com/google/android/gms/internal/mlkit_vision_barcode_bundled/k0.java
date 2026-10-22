package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.jsc;
import com.zj.adlib.xsc;
import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f31383a = new ArrayDeque();

    public k0() {
    }

    public static /* bridge */ /* synthetic */ zzdb a(k0 k0Var, zzdb zzdbVar, zzdb zzdbVar2) {
        k0Var.b(zzdbVar);
        k0Var.b(zzdbVar2);
        zzdb zzggVar = (zzdb) k0Var.f31383a.pop();
        while (!k0Var.f31383a.isEmpty()) {
            zzggVar = new zzgg((zzdb) k0Var.f31383a.pop(), zzggVar);
        }
        return zzggVar;
    }

    public static final int c(int i) {
        int iBinarySearch = Arrays.binarySearch(zzgg.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public final void b(zzdb zzdbVar) {
        xsc xscVar;
        if (!zzdbVar.zzh()) {
            if (!(zzdbVar instanceof zzgg)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzdbVar.getClass())));
            }
            zzgg zzggVar = (zzgg) zzdbVar;
            b(zzggVar.zzd);
            b(zzggVar.zze);
            return;
        }
        int iC = c(zzdbVar.zzd());
        int iZzc = zzgg.zzc(iC + 1);
        if (this.f31383a.isEmpty() || ((zzdb) this.f31383a.peek()).zzd() >= iZzc) {
            this.f31383a.push(zzdbVar);
            return;
        }
        int iZzc2 = zzgg.zzc(iC);
        zzdb zzggVar2 = (zzdb) this.f31383a.pop();
        while (true) {
            xscVar = null;
            if (this.f31383a.isEmpty() || ((zzdb) this.f31383a.peek()).zzd() >= iZzc2) {
                break;
            } else {
                zzggVar2 = new zzgg((zzdb) this.f31383a.pop(), zzggVar2);
            }
        }
        zzgg zzggVar3 = new zzgg(zzggVar2, zzdbVar);
        while (!this.f31383a.isEmpty()) {
            if (((zzdb) this.f31383a.peek()).zzd() >= zzgg.zzc(c(zzggVar3.zzd()) + 1)) {
                break;
            } else {
                zzggVar3 = new zzgg((zzdb) this.f31383a.pop(), zzggVar3);
            }
        }
        this.f31383a.push(zzggVar3);
    }

    public /* synthetic */ k0(jsc jscVar) {
    }
}
