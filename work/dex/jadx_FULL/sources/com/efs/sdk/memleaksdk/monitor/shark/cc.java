package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/AndroidNativeSizeMapper;", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;)V", "mapNativeSizes", "", "", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HeapGraph f29822a;

    public cc(@NotNull HeapGraph heapGraph) {
        Intrinsics.checkNotNullParameter(heapGraph, "graph");
        this.f29822a = heapGraph;
    }

    @NotNull
    public final Map<Long, Integer> a() {
        HeapField heapFieldB;
        HeapValue heapValue;
        Long lC;
        HeapValue heapValue2;
        HeapValue heapValue3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HeapObject.b bVarA = this.f29822a.a("sun.misc.Cleaner");
        if (bVarA != null) {
            for (HeapObject.c cVar : bVarA.l()) {
                HeapField heapFieldB2 = cVar.b("sun.misc.Cleaner", "thunk");
                Long lD = null;
                Long lD2 = (heapFieldB2 == null || (heapValue3 = heapFieldB2.c) == null) ? null : heapValue3.d();
                HeapField heapFieldB3 = cVar.b("java.lang.ref.Reference", "referent");
                if (heapFieldB3 != null && (heapValue2 = heapFieldB3.c) != null) {
                    lD = heapValue2.d();
                }
                if (lD2 != null && lD != null) {
                    HeapObject heapObjectF = heapFieldB2.c.f();
                    if (heapObjectF instanceof HeapObject.c) {
                        HeapObject.c cVar2 = (HeapObject.c) heapObjectF;
                        if (cVar2.a("libcore.util.NativeAllocationRegistry$CleanerThunk") && (heapFieldB = cVar2.b("libcore.util.NativeAllocationRegistry$CleanerThunk", "this$0")) != null && heapFieldB.c.e()) {
                            HeapObject heapObjectF2 = heapFieldB.c.f();
                            if (heapObjectF2 instanceof HeapObject.c) {
                                HeapObject.c cVar3 = (HeapObject.c) heapObjectF2;
                                if (cVar3.a("libcore.util.NativeAllocationRegistry")) {
                                    Integer num = (Integer) linkedHashMap.get(lD);
                                    int iLongValue = 0;
                                    int iIntValue = num != null ? num.intValue() : 0;
                                    HeapField heapFieldB4 = cVar3.b("libcore.util.NativeAllocationRegistry", "size");
                                    if (heapFieldB4 != null && (heapValue = heapFieldB4.c) != null && (lC = heapValue.c()) != null) {
                                        iLongValue = (int) lC.longValue();
                                    }
                                    linkedHashMap.put(lD, Integer.valueOf(iIntValue + iLongValue));
                                }
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }
}
