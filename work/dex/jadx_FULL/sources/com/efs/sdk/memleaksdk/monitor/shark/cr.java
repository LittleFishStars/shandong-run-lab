package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ShallowSizeCalculator;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;)V", "computeShallowSize", "", "objectId", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HeapGraph f29853a;

    public cr(@NotNull HeapGraph heapGraph) {
        Intrinsics.checkNotNullParameter(heapGraph, "graph");
        this.f29853a = heapGraph;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final int a(long j) throws NoWhenBranchMatchedException {
        HeapValue heapValue;
        HeapObject heapObjectA = this.f29853a.a(j);
        Long lValueOf = null;
        if (heapObjectA instanceof HeapObject.c) {
            HeapObject.c cVar = (HeapObject.c) heapObjectA;
            if (!Intrinsics.areEqual(cVar.h(), "java.lang.String")) {
                return cVar.i().g();
            }
            HeapField heapFieldB = cVar.b("java.lang.String", "value");
            if (heapFieldB != null && (heapValue = heapFieldB.c) != null) {
                lValueOf = heapValue.d();
            }
            return cVar.i().g() + (lValueOf != null ? a(lValueOf.longValue()) : 0);
        }
        if (!(heapObjectA instanceof HeapObject.d)) {
            if (heapObjectA instanceof HeapObject.e) {
                return ((HeapObject.e) heapObjectA).f();
            }
            if (heapObjectA instanceof HeapObject.b) {
                return heapObjectA.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        HeapObject.d dVar = (HeapObject.d) heapObjectA;
        if (!cp.a(dVar)) {
            return dVar.g();
        }
        long[] jArr = dVar.b().f29780a;
        int length = jArr.length * this.f29853a.a();
        int length2 = jArr.length;
        for (int i = 0; i < length2; i++) {
            long j2 = jArr[i];
            if (j2 != 0) {
                lValueOf = Long.valueOf(j2);
                break;
            }
        }
        if (lValueOf == null) {
            return length;
        }
        int iA = a(lValueOf.longValue());
        int i2 = 0;
        for (long j3 : jArr) {
            if (j3 != 0) {
                i2++;
            }
        }
        return length + (iA * i2);
    }
}
