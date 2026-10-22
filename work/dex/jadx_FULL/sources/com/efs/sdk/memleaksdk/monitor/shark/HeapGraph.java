package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.au, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H&J\u0012\u00100\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020/H&J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0003H&J\u0010\u00103\u001a\u0002042\u0006\u0010.\u001a\u00020/H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0005R\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\n¨\u00065"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "", "classCount", "", "getClassCount", "()I", "classes", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "getContext", "()Lcom/efs/sdk/memleaksdk/monitor/shark/GraphContext;", "gcRoots", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapInstance;", "getInstances", "objectArrayCount", "getObjectArrayCount", "objectArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCount", "getObjectCount", "objects", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrays", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "findClassByName", "className", "", "findObjectById", "objectId", "", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "objectExists", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface HeapGraph {
    int a();

    @Nullable
    HeapObject.b a(@NotNull String str);

    @NotNull
    HeapObject a(long j) throws IllegalArgumentException;

    @NotNull
    GraphContext b();

    @Nullable
    HeapObject b(long j);

    int c();

    boolean c(long j);

    @NotNull
    List<GcRoot> d();

    @NotNull
    Sequence<HeapObject.c> e();
}
