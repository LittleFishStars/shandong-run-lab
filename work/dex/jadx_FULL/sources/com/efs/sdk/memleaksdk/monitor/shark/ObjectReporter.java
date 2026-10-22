package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bo, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\u0002\b\u001dJ5\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f2\u001d\u0010\u001a\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180\u001b¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006 "}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ObjectReporter;", "", "heapObject", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;)V", "getHeapObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "labels", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "getLabels", "()Ljava/util/LinkedHashSet;", "leakingReasons", "", "getLeakingReasons", "()Ljava/util/Set;", "likelyLeakingReasons", "getLikelyLeakingReasons$annotations", "()V", "getLikelyLeakingReasons", "notLeakingReasons", "getNotLeakingReasons", "whenInstanceOf", "", "expectedClassName", "block", "Lkotlin/Function2;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "Lkotlin/ExtensionFunctionType;", "expectedClass", "Lkotlin/reflect/KClass;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ObjectReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    final LinkedHashSet<String> f29807a;

    @NotNull
    final Set<String> b;

    @NotNull
    final Set<String> c;

    @NotNull
    final HeapObject d;

    public ObjectReporter(@NotNull HeapObject heapObject) {
        Intrinsics.checkNotNullParameter(heapObject, "heapObject");
        this.d = heapObject;
        this.f29807a = new LinkedHashSet<>();
        this.b = new LinkedHashSet();
        this.c = new LinkedHashSet();
    }
}
